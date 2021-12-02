package com.roushan.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.roushan.demo.entity.Interview;
import com.roushan.demo.entity.ParticipantInterviewRelation;

@Repository
public class ParticipantInterviewRelationDao {
	
	@Autowired
	JdbcTemplate template;
	
	public void save(String interviewId, List<String> participants) {
		String sql="insert into ParticipantInterviewRelation(emailId, interviewId) values(?, ?)";
		for (String participant: participants) {
			template.update(sql, participant, interviewId);
		}
	}
	public List<ParticipantInterviewRelation> getAll()
	{
		String sql="select * from participantinterviewrelation";
		return template.query(sql, new BeanPropertyRowMapper<>(ParticipantInterviewRelation.class));
	}
}
