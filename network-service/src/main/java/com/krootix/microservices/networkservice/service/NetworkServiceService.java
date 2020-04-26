package com.krootix.microservices.networkservice.service;

import com.krootix.microservices.networkservice.entity.NetworkService;
import com.krootix.microservices.networkservice.repository.NetworkServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class NetworkServiceService {

    @Autowired
    private NetworkServiceRepository repository;

    public NetworkService findByName(String name) {

        return repository.findByName(name).orElseThrow(EntityNotFoundException::new);

    }
}
