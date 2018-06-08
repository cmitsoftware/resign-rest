package org.resign.config;

import org.resign.repo.Category;
import org.resign.repo.Resource;
import org.resign.repo.Tag;
import org.resign.repo.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

@Configuration
@EnableMongoRepositories(basePackages = {"org.resign.repo"})
@PropertySource(
		value = {"file:${spring.config.additional-location}/resign-services.properties"},
		ignoreResourceNotFound = true)
public class RestConfiguration extends RepositoryRestConfigurerAdapter {

	@Value("${resign.images.host}")
    String resignImagesHost;
	
	@Value("${resign.images.context}")
    String resignImagesContext;
	
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Resource.class);
        config.exposeIdsFor(Tag.class);
        config.exposeIdsFor(User.class);
        config.exposeIdsFor(Category.class);
//        config.exposeIdsFor(ResourceTag.class);
        
        config.setReturnBodyOnCreate(true);
        config.setReturnBodyOnUpdate(true);
    }

	public String getResignImagesHost() {
		return resignImagesHost;
	}

	public void setResignImagesHost(String resignImagesHost) {
		this.resignImagesHost = resignImagesHost;
	}

	public String getResignImagesContext() {
		return resignImagesContext;
	}

	public void setResignImagesContext(String resignImagesContext) {
		this.resignImagesContext = resignImagesContext;
	}
    
}