package org.resign.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "tag", path = "tag")
public interface TagRepository extends MongoRepository<Tag, String> {

//	public Tag findByName(String name);
//    public Tag findByCategory(String category);
    
}