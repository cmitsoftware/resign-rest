package org.resign.config;

import org.resign.repo.Tag;
import org.springframework.hateoas.Resource;
import org.springframework.stereotype.Component;

@Component
public class TagProcessor implements org.springframework.hateoas.ResourceProcessor<org.springframework.hateoas.Resource<Tag>>{

	@Override
	public Resource<Tag> process(Resource<Tag> resource) {

//		for(Link l: resource.getLinks()) {
//			System.out.println(l.getHref());
//		}
		
		return resource;
	}

	
}
