package com.pluralsight.mvc;

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

import com.pluralsight.mvc.repository.AppUserRepository;
import com.pluralsight.mvc.service.AppUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@ComponentScan(basePackageClasses = { AppUserDetailsService.class, AppUserRepository.class })
//@EnableJpaRepositories(basePackageClasses = AppUserRepository.class)
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private AppUserDetailsService userDetailsService;

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
		http.authorizeRequests().antMatchers("/login*").permitAll().antMatchers("/EventTracker/**", "/**")
				.hasRole("USER")
// 				.antMatchers("/**").permitAll()
				.anyRequest().authenticated().and().formLogin().permitAll(); // set permitAll for all URLs associated
																				// with Form Login
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
