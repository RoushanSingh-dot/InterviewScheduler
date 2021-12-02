package com.roushan.demo.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.roushan.demo.entity.Participant;

@Repository
public class ParticipantDao {
	
	@Autowired
	JdbcTemplate template;
	
	
	public List<Participant> getAllParticipants() {
		String sql="select * from Participant";
		return template.query(sql, new BeanPropertyRowMapper<>(Participant.class));
	}
}
