package com.roushan.demo.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.roushan.demo.entity.Interview;

@Repository
public class InterviewDao {
	
	@Autowired
	JdbcTemplate template;
	
	
	
	public List<Interview> getInterviews() {
		String sql="select * from interview";
		return template.query(sql, new BeanPropertyRowMapper<>(Interview.class));
	}
	
	public List<Interview> getInterviewById(String id)
	{
		String sql="select * from interview where interviewId="+id;
		return template.query(sql, new BeanPropertyRowMapper<>(Interview.class));
	}
}

