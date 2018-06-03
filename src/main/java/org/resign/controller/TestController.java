package org.resign.controller;

import java.util.Date;

import org.resign.repo.Resource;
import org.resign.repo.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/test")
public class TestController {

//	@Autowired
//	ResourceRepository resourceRepository;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Resource> testInsertResource(){
		
		Resource r = new Resource();
		r.setName("Test");
		r.setDesc("Test");
//		r.setVisibilityStart(new Date());
//		r.setVisibilityEnd(new Date());
//		resourceRepository.save(r);
		
		return new ResponseEntity<Resource>(r, HttpStatus.OK);
 	}
}
