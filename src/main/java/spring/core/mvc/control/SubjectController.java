package spring.core.mvc.control;

import java.util.Collections;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spring.core.mvc.model.Subject;
import spring.core.mvc.service.SubjectService;

@Controller
@RequestMapping("/library")
public class SubjectController {

	@Autowired
	private SubjectService subjectService;

	@ModelAttribute("subjectadd")
	public Subject create() {
		return new Subject();
	}

	@GetMapping("/addsubject")
	public ModelAndView addSubjectView() {
		return new ModelAndView("subject/addsubject");
	}

	@PostMapping("/addsubject")
	public ModelAndView addSubjectSave(@Valid @ModelAttribute("subjectadd") Subject subject,BindingResult result )
	{

		ModelAndView modelsubject=null;
		if(result.hasErrors())
		{
			modelsubject=new ModelAndView("subject/addsubject","subjectattribute",subject);
		}
		else
		{
			subjectService.addSubject(subject);
			modelsubject=new ModelAndView("redirect:/library/viewsubjects");
		}
		return modelsubject;
	}

	@GetMapping("/viewsubjects")
	public ModelAndView listSubjects() {
		ModelAndView searchmodel = new ModelAndView("subject/showsubjects", "subjectlist",
				subjectService.getAllSubjects());
		return searchmodel;
	}

	@GetMapping("/searchsubject")
	public ModelAndView searchSubjectview() {
		return new ModelAndView("subject/searchsubject");
	}

	@PostMapping("/searchsubject")
	public ModelAndView searchSubject(@RequestParam Long subjectid) {
		Set<Subject> subject = Collections.singleton(subjectService.getSubject(subjectid));
		return new ModelAndView("subject/searchsubject", "singlesubject", subject);
	}

	@GetMapping("/deletesubject")
	public ModelAndView deleteSubject(@RequestParam(value = "subjectid") Long subjectid) {
		subjectService.deleteSubject(subjectid);
		ModelAndView searchmodel = new ModelAndView("subject/showsubjects", "subjectlist",
				subjectService.getAllSubjects());
		return searchmodel.addObject("redirect:/library/viewsubjects");
	}

	@GetMapping("/deletesub")
	public ModelAndView deleteSubject() {
		ModelAndView searchmodel = new ModelAndView("subject/deletesubject", "subjectlist",
				subjectService.getAllSubjects());
		return searchmodel;
	}

}
