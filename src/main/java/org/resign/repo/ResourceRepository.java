package org.resign.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(collectionResourceRel = "resource", path = "resource")
public interface ResourceRepository extends MongoRepository<Resource, String> {

//	@Override
//    @RestResource(exported = false)
//    public Page<Resource> findAll(Pageable pageable);
	
//    https://docs.mongodb.com/manual/reference/operator/query/regex/
//    @Query(value = "{'address': {$regex : ?0, $options: 'i'}}")
//    public List<Customer> findByAddressRegex(String address);
//    
//    @PreAuthorize("hasRole('ADMIN')")
//    @Query(value = "{'$or' : [{'address': {$regex : ?0, $options: 'i'}},{'accountNumber': {$gt : ?1}}]}")
//    public List<Customer> findByAddressRegexOrAccountNumberGreater(@Param(value = "address") String address, @Param(value = "accountNumber") Integer accountNumber);
//    
//    @Query(value = "{'$or' : [{'address': {$regex : ?0, $options: 'i'}},{'accountNumber': {$gt : ?1}}]}")
//    public Stream<Customer> streamByAddressRegexOrAccountNumberGreater(String address, Integer accountNumber);
//    
}