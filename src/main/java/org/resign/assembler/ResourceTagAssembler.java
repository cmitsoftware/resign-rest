package org.resign.assembler;

import org.resign.controller.ResourceTagsController;
import org.resign.embedded.ResourceTag;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
public class ResourceTagAssembler extends ResourceAssemblerSupport<ResourceTag, ResourceTagResource> {

//	public ResourceTagAssembler(Class<ResourceTagsController> controllerClass, Class<ResourceTagResource> resourceType) {
//		super(controllerClass, resourceType);
//	}
	public ResourceTagAssembler() {
		super(ResourceTagsController.class, ResourceTagResource.class);
	}

	@Override
	public ResourceTagResource toResource(ResourceTag rt) {
		ResourceTagResource rtr = createResource(rt);
		rtr.add(linkTo(methodOn(ResourceTagsController.class).self(rt.getResourceId(), rt.getId())).withRel("self"));
		return rtr;
	}
	
	private ResourceTagResource createResource(ResourceTag resourceTag) {
		ResourceTagResource rtr = new ResourceTagResource();
		rtr.setTagId(resourceTag.getId());
		rtr.setName(resourceTag.getName());
		return rtr;
	}
}
