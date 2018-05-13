package org.resign.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.resign.assembler.ResourceTagAssembler;
import org.resign.assembler.ResourceTagResource;
import org.resign.config.TagProcessor;
import org.resign.embedded.ResourceTag;
import org.resign.repo.Resource;
import org.resign.repo.ResourceRepository;
import org.resign.repo.Tag;
import org.resign.repo.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.rest.webmvc.PersistentEntityResource;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.config.EnableEntityLinks;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
//@ExposesResourceFor(value = Tag.class)
@RequestMapping(value="/resource")
public class ResourceTagsController {

	@Autowired
	ResourceRepository resourceRepository;
	
	@Autowired
	TagRepository tagRepository;
	
//	@Autowired
//	TagProcessor tagProcessor;
	
	@Autowired
	ResourceTagAssembler resourceTagAssembler;
	
//	@RequestMapping(value="{resourceId}/tags", method=RequestMethod.GET)
//	public ResponseEntity<List<ResourceTagResource>> resourceTags(@PathVariable String resourceId){
//		
//		Optional<Resource> r = resourceRepository.findById(resourceId);
//		if(r.isPresent()) {
//			
//			Iterable<Tag> tags = null;
//			if(r.get().getTags() != null) {
//				List<String> tagIds = new ArrayList<>();
//				for(ResourceTag rt: r.get().getTags()) {
//					tagIds.add(rt.getId());
//				}
//				tags = tagRepository.findAllById(tagIds);
//			}
//			
//			if(tags != null) {
//				return new ResponseEntity<List<ResourceTagResource>>(resourceTagAssembler.toResources(tags), HttpStatus.OK);
//			}
//		} 
//		return new ResponseEntity<List<ResourceTagResource>>(HttpStatus.NOT_FOUND);
//	}
	
	@RequestMapping(value="{resourceId}/tags/{tagId}", method=RequestMethod.GET)
	public ResponseEntity<ResourceTagResource> self(@PathVariable String resourceId, @PathVariable String tagId){
		
		Optional<Resource> r = resourceRepository.findById(resourceId);
		if(r.isPresent()) {
			
			if(r.get().getTags() != null) {
				for(ResourceTag rt: r.get().getTags()) {
					if(rt.getId().equals(tagId)) {
						if(StringUtils.isEmpty(rt.getResourceId())) {
							rt.setResourceId(resourceId);
						}
						return new ResponseEntity<ResourceTagResource>(resourceTagAssembler.toResource(rt), HttpStatus.OK);
					}
				}
			}
		} 
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="{resourceId}/tags/{tagId}", method=RequestMethod.DELETE)
	public ResponseEntity<ResourceTagResource> deleteResourceTag(@PathVariable String resourceId, @PathVariable String tagId){
		
		Optional<Resource> r = resourceRepository.findById(resourceId);
		if(r.isPresent()) {
			
			return new ResponseEntity<ResourceTagResource>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<ResourceTagResource>(HttpStatus.NOT_FOUND);
	}
	
	
}
