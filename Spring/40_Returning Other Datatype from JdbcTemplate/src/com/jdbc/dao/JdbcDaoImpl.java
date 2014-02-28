package com.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.jdbc.model.Circle;

@Component
public class JdbcDaoImpl {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public int getCircleCount() {
		String sql = "select count(*) from circle";
		// jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate.queryForInt(sql);

	}

	public String getCircleName(int circleId) {
		String sql = "select name from circle where id = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] { circleId }, String.class);

	}

	public Circle getCircleforId(int circleId) {
		String sql = "select * from circle where id = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] { circleId }, new CircleMapper());

	}

	public List<Circle> getAllCircle() {
		String sql = "select * from circle";
		return jdbcTemplate.query(sql, new CircleMapper());

	}

	private static final class CircleMapper implements RowMapper<Circle> {

		@Override
		public Circle mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			Circle circle = new Circle();
			circle.setId(resultSet.getInt("ID"));
			circle.setName(resultSet.getString("NAME"));
			return circle;
		}

	}

	public DataSource getDataSource() {
		return dataSource;
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
