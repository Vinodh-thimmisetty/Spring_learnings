package com.pluralsight.mvc.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.PreparedStatementCreator;

public class RideCreateStatement implements PreparedStatementCreator {

	@Override
	public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
		PreparedStatement ps = con.prepareStatement("insert into ride(name, duration) values (?, ?)", new String[] {"id"});
		ps.setString(1, "");
		ps.setInt(2, 1);
		return ps;
	}
}
