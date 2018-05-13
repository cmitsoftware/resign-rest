package org.resign.config;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.resign.controller.ResourceTagsController;
import org.resign.repo.Resource;
import org.resign.repo.ResourceRepository;
import org.resign.repo.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class ResourceProcessor implements org.springframework.hateoas.ResourceProcessor<org.springframework.hateoas.Resource<Resource>>{

	public org.springframework.hateoas.Resource<Resource> process(org.springframework.hateoas.Resource<Resource> resource) {
		//link to resource tags
//		resource.add(linkTo(
//				methodOn(ResourceTagsController.class).resourceTags(resource.getContent().getId())
//				).withRel("tags"));
		
		//link to resource owner
//		try {
//			resource.add(linkTo(UserRepository.class.getMethod("findById", String.class), resource.getContent().getId()).withRel("user"));
//		} catch (NoSuchMethodException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SecurityException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		return resource;
	}
}
