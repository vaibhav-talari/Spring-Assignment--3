package spring.core.mvc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import spring.core.mvc.model.Subject;

@Transactional
@Repository
public class SubjectRepo {
	
	@PersistenceContext
	EntityManager manager;
	
	@Transactional
	public boolean addSubject(Subject subject)
	{		
		 manager.persist(subject); 
		 return true;
	}
	
	@Transactional
	public boolean deleteSubject(long refid)
	{
		Subject subject=manager.find(Subject.class, refid);
		manager.remove(subject);
		return true;
	}
	
	@Transactional
	public Subject getSubject(long refid)
	{
		Subject subject=manager.find(Subject.class, refid);
		return subject;
	}
	
	@Transactional
	public List<Subject> getAllSubjects()
	{
		String sqlquery="select s from Subject s";
		Query hquery = manager.createQuery(sqlquery);
		@SuppressWarnings("unchecked")
		List<Subject> allsubjects=hquery.getResultList();
		return allsubjects;
	}

}
