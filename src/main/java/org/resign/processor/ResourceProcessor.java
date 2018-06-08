package org.resign.processor;

import org.resign.config.RestConfiguration;
import org.resign.repo.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Component;

@Component
public class ResourceProcessor implements org.springframework.hateoas.ResourceProcessor<org.springframework.hateoas.Resource<Resource>>{

	@Autowired
	RestConfiguration restConfiguration;
	
	public org.springframework.hateoas.Resource<Resource> process(org.springframework.hateoas.Resource<Resource> resource) {
		
		/*
		 * Add image to resource
		 */
		resource.add(new Link(
				restConfiguration.getResignImagesHost() 
				+ restConfiguration.getResignImagesContext() 
				+ "/resources/" + resource.getContent().getId() + "/add"
				+ "?{image,name,desc}", "addImage"));
		
		/*
		 * Update resource image 
		 */
		resource.add(new Link(
				restConfiguration.getResignImagesHost() 
				+ restConfiguration.getResignImagesContext() 
				+ "/resources/" + resource.getContent().getId() + "/update"
				+ "?{imageId, image,name,desc}", "updateImage"));

		/*
		 * Delete resource image 
		 */
		resource.add(new Link(
				restConfiguration.getResignImagesHost() 
				+ restConfiguration.getResignImagesContext() 
				+ "/resources/" + resource.getContent().getId() + "/delete"
				+ "?{imageId}", "deleteImage"));
		
		/*
		 * Update resource image 
		 */
		resource.add(new Link(
				restConfiguration.getResignImagesHost() 
				+ restConfiguration.getResignImagesContext() 
				+ "/view/{imageId}","viewImage"));
		
        return resource;
	}
}
