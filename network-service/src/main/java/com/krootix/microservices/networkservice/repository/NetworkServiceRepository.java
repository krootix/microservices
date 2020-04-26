package com.krootix.microservices.networkservice.repository;

import com.krootix.microservices.networkservice.entity.NetworkService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NetworkServiceRepository extends JpaRepository<NetworkService, Long> {
    Optional<NetworkService> findByName(String name);
}
