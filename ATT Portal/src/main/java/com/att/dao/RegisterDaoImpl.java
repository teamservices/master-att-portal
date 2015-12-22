package com.att.dao;

import com.att.domain.User;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

public class RegisterDaoImpl implements RegisterDao {

	@Autowired
	DataSource dataSource;

	@Override
	@Transactional
	public void registerUser(User login) {
		String sql = "insert into app_user(username,password,state) values(?,?,?)";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sql, new Object[] { login.getUsername(), login.getPassword(), true });

		String sqlRole = "insert into user_profile(username,type) values(?,?)";

		jdbcTemplate.update(sqlRole, new Object[] { login.getUsername(), login.getUserRole() });

	}

}
