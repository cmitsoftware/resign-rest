package org.resign.repo;

import java.util.Date;

import org.resign.config.DatabaseConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

public class ResourceRepositoryCustomImpl implements ResourceRepositoryCustom{
	
	@SuppressWarnings("resource")
	@Override
	public Resource save(Resource r) {
		
		ApplicationContext ctx = 
	             new AnnotationConfigApplicationContext(DatabaseConfiguration.class);
		MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
		
		r.setCreation(new Date());
		
		mongoOperation.save(r, "resource");
		return r;
	}

}
