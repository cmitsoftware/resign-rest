package org.resign.embedded;

/**
 * Utility class to store tags on resources as embedded items
 * The id is stored to reflect updates occurred on the corresponding tag
 * 
 * @author cerri
 */
public class ResourceTag {

	public ResourceTag() {}
	
	String tagId;
//	String id;
	String name;

	public String getTagId() {
		return tagId;
	}
	public void setTagId(String tagId) {
		this.tagId = tagId;
	}
	//	public String getId() {
//		return id;
//	}
//	public void setId(String id) {
//		this.id = id;
//	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
