package com.pluralsight.mvc.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.pluralsight.mvc.model.Ride;
import com.pluralsight.mvc.util.RideRowMapper;

@Repository
public class RideRepositoryImpl implements RideRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Ride> getRides() {
//		List<Ride> rides = new ArrayList<>();
//		Ride ride = new Ride();
//		ride.setName("Corner Canyon");
//		ride.setDuration(120);
//		rides.add(ride);

		List<Ride> rides = jdbcTemplate.query("select * from ride", new RideRowMapper());

		return rides;
	}

	@Override
	public Ride createRide(Ride ride) {
//		jdbcTemplate.update("insert into ride(name, duration) values (?, ?)", ride.getName(), ride.getDuration());
		/*
		 * SimpleJdbcInsert insrt = new SimpleJdbcInsert(jdbcTemplate);
		 * 
		 * List<String> columns = new ArrayList<>(); columns.add("name");
		 * columns.add("duration");
		 * 
		 * // insrt.setSchemaName("ride_tracker"); insrt.setTableName("ride");
		 * insrt.setColumnNames(columns);
		 * 
		 * Map<String, Object> data = new HashMap<>(); data.put("name", ride.getName());
		 * data.put("duration", ride.getDuration());
		 * 
		 * insrt.setGeneratedKeyName("id");
		 * 
		 * Number key = insrt.executeAndReturnKey(data); System.out.println("----> " +
		 * key);
		 */
		KeyHolder kh = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement("insert into ride(name, duration) values (?, ?)",
						new String[] { "id" });
				ps.setString(1, ride.getName());
				ps.setInt(2, ride.getDuration());
				return ps;
			}
		}, kh);
		Number id = kh.getKey();
		return getRide(id.intValue());
	}

	private Ride getRide(int intValue) {
		return jdbcTemplate.queryForObject("select * from ride where id = ?", new RideRowMapper(), intValue);
	}

}