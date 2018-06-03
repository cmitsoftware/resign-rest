package org.resign.config;

import org.resign.embedded.ResourceTag;
import org.resign.repo.Category;
import org.resign.repo.Resource;
import org.resign.repo.Tag;
import org.resign.repo.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

@Configuration
@EnableMongoRepositories(basePackages = {"org.resign.repo"})
public class RestConfiguration extends RepositoryRestConfigurerAdapter {

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
    
}