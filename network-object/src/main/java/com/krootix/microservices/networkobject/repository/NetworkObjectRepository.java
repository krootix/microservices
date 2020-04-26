package com.krootix.microservices.networkobject.repository;

import com.krootix.microservices.networkobject.entity.NetworkObject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NetworkObjectRepository extends CrudRepository<NetworkObject, Long> {
    Optional<NetworkObject> findByName(String name);
}
