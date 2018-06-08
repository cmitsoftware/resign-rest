package org.resign.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(collectionResourceRel = "image", path = "image")
public interface ImageRepository extends MongoRepository<Image, String> {

	/*
    * Prevents POST /people and PATCH/PUT /resource/:id(non-Javadoc)
    * @see org.springframework.data.repository.CrudRepository#save(S)
    */
    @SuppressWarnings("unchecked")
	@Override
    @RestResource(exported = false)
    public Image save(Image r);

    /*
     * Prevents DELETE /resource/:id(non-Javadoc)
     * @see org.springframework.data.repository.CrudRepository#delete(java.lang.Object)
     */
    @Override
    @RestResource(exported = false)
    public void delete(Image r);
}