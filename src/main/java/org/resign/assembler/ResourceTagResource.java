package org.resign.assembler;

import org.springframework.hateoas.ResourceSupport;

public class ResourceTagResource extends ResourceSupport {
	
	String tagId;
	String name;
	
	public String getTagId() {
		return tagId;
	}
	public void setTagId(String tagId) {
		this.tagId = tagId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
