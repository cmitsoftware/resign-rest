package org.resign.repo;

import org.springframework.stereotype.Repository;

@Repository
public interface ResourceRepositoryCustom {

	public Resource save(Resource r);
}