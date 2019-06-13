package com.pluralsight.mvc;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.pluralsight.mvc.repository.AppUserRepository;
import com.pluralsight.mvc.security.CustomAuthenticationEntryPoint;
import com.pluralsight.mvc.service.AppUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@ComponentScan(basePackageClasses = { AppUserDetailsService.class, AppUserRepository.class,
		CustomAuthenticationEntryPoint.class })
//@EnableJpaRepositories(basePackageClasses = AppUserRepository.class)
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private AppUserDetailsService userDetailsService;

	@Autowired
	private CustomAuthenticationEntryPoint authenticationEntryPoint;

//	@Autowired
//	private DataSource dataSource;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring()
				// Spring Security should completely ignore URLs starting with /resources/
				.antMatchers("/resources/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests().antMatchers("/login*", "/logout*").anonymous().antMatchers("/EventTracker/**", "/**")
				.hasAnyRole("USER", "ADMIN")
// 				.antMatchers("/**").permitAll()
				.anyRequest().authenticated().and()
//				.httpBasic().authenticationEntryPoint(authenticationEntryPoint);
				.formLogin()
					.loginPage("/login").defaultSuccessUrl("/").failureUrl("/loginFailed").permitAll()
				.and()
					.logout().logoutUrl("/logout").invalidateHttpSession(true).permitAll();
		// set permitAll for all URLs associated with Form Login

//		http.formLogin().loginProcessingUrl("/login").and().logout();
		
		http.exceptionHandling().accessDeniedPage("/errro403");
		
		http.addFilterBefore(new Filter() {

			@Override
			public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
					throws IOException, ServletException {
				System.out.println(
						"<=============================> I'm just Custom filter executing BEFORE Basic Auth Filter");
				chain.doFilter(request, response);
			}
		}, BasicAuthenticationFilter.class);

		http.addFilterAfter(new Filter() {
			@Override
			public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
					throws IOException, ServletException {
				System.out.println(
						"=============================> I'm just Custom filter executing after Basic Auth Filter");
				chain.doFilter(request, response);
			}
		}, BasicAuthenticationFilter.class);

	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth
//				// enable in memory based authentication with a user named "user" and "admin"
//				.inMemoryAuthentication().passwordEncoder(passwordEncoder).withUser("user")
//				.password(passwordEncoder.encode("password")).roles("USER").and().withUser("admin")
//				.password(passwordEncoder.encode("password")).roles("USER", "ADMIN");

		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());

//		auth.authenticationProvider(authenticationProvider());

//		auth
//		.jdbcAuthentication()
//		.dataSource(dataSource)
//		.passwordEncoder(passwordEncoder)
//		.usersByUsernameQuery("Select username, password, enabled from users where username=?")
//		.authoritiesByUsernameQuery("select username authority from authorities where username=?");
	}

//	@Bean
//	public AuthenticationProvider authenticationProvider() {
//		DaoAuthenticationProvider daoProvider = new DaoAuthenticationProvider();
//		daoProvider.setUserDetailsService(userDetailsService);
//		daoProvider.setPasswordEncoder(passwordEncoder);
//		return daoProvider;
//	}

}
