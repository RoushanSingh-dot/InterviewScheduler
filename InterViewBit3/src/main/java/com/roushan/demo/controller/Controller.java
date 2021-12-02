package com.roushan.demo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.roushan.demo.dao.InterviewDao;
import com.roushan.demo.dao.ParticipantDao;
import com.roushan.demo.dao.ParticipantInterviewRelationDao;
import com.roushan.demo.entity.Interview;
import com.roushan.demo.entity.Participant;
import com.roushan.demo.entity.ParticipantInterviewRelation;

@org.springframework.stereotype.Controller
public class Controller {
	
	@Autowired
	InterviewDao interviewDao;
	
	@Autowired
	ParticipantDao participantDao;
	
	@Autowired
	ParticipantInterviewRelationDao participantInterviewRelationDao;
	
	@GetMapping("/")
	public String home(Model m) {
		m.addAttribute("interviews", interviewDao.getInterviews());
		List<Interview> list=interviewDao.getInterviews();
		for(Interview curr:list)
			System.out.println(curr.getInterviewName());
//		System.out.println("Till here");
		return "index";
	}
	
	@GetMapping("/participants")
	public String participants() {
//		m.addAttribute("interviews", interviewDao.getInterviews());
//		System.out.println("Till here");
		List<Participant> list=participantDao.getAllParticipants();
//		m.addAttribute("participants",list);
//		System.out.println(list);
		return "index";
	}
	
	@GetMapping("/createInterview")
	public String createInterview(Model m) {
		List<Participant> list=participantDao.getAllParticipants();
		m.addAttribute("participants",list);
		return "createInterview";
	}
	
	@PostMapping("/createInterview")
	public String checkForValidation(String interviewId,String interviewName,Date start,Date end,List<Participant> selected)
	{
		System.out.println("In here for validation");
		HashSet<String> validEmails=new HashSet<>();
		for(Participant curr:selected)
		{
			validEmails.add(curr.getEmailId());
		}
		List<ParticipantInterviewRelation> list=participantInterviewRelationDao.getAll();
		List<Interview> validInterviews=new ArrayList<>();
		for(ParticipantInterviewRelation relation:list)
		{
			if(validEmails.contains(relation.getEmailId()))
			{
				validInterviews.addAll(interviewDao.getInterviewById(relation.getInterviewId()));
			}
		}
		boolean canSchedule=true;
		Date currDate=new Date();
		for(Interview currInterview:validInterviews)
		{
			if(currDate.after(currInterview.getStartTime()) && currDate.before(currInterview.getEndTime())) {
			    // In between
				canSchedule=false;
				break;
			}
		}
		if(!canSchedule)
			return null;
		return "index";
	}
}
