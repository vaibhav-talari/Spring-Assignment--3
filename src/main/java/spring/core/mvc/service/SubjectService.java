package spring.core.mvc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.core.mvc.model.Subject;
import spring.core.mvc.dao.SubjectRepo;

@Service
public class SubjectService {
	@Autowired
	private SubjectRepo dao;
	
	@Transactional
	public boolean addSubject(Subject subject)
	{
		return dao.addSubject(subject);
	}
	
	@Transactional
	public Subject getSubject(long refid)
	{
		return dao.getSubject(refid);
	}
	
	@Transactional
	public boolean deleteSubject(long refid)
	{
		return dao.deleteSubject(refid);
	}
	
	@Transactional
	public List<Subject> getAllSubjects()
	{
		return dao.getAllSubjects();
	}
	

}
