package org.resign.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import com.mongodb.MongoClient;

@Configuration
@PropertySource(
		value = {"file:${spring.config.additional-location}db.properties"},
//		value = {"file:${spring.config.location}db.properties"},
		ignoreResourceNotFound = false)
public class DatabaseConfiguration extends AbstractMongoConfiguration {
	
	private static final Logger log = LoggerFactory.getLogger(DatabaseConfiguration.class);
	
	@Value("${db.host}")
    String host;
	
	@Value("${db.port}")
	Integer port;
	
	@Value("${db.name}")
    String name;
	
    @Override
    protected String getDatabaseName() {
    	log.debug("Database name {}", name);
        return name;
    }

	@Override
	public MongoClient mongoClient() {
		log.debug("Mongo client {}:{}", host, port);
		return new MongoClient(host, port);
	}
}