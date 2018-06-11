package org.resign.repo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

@Repository
public class ResourceRepositoryCustomImpl implements ResourceRepositoryCustom {
	
	@Autowired
	MongoOperations mongoTemplate;
	
	@Override
	public Resource save(Resource r) {
		
		r.setCreation(new Date());
		
		mongoTemplate.save(r, "resource");
		return r;
	}

}
