package com.krootix.microservices.networkobject.service;

import com.krootix.microservices.networkobject.entity.NetworkObject;
import com.krootix.microservices.networkobject.repository.NetworkObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class NetworkObjectService {

    @Autowired
    private NetworkObjectRepository repository;

    public NetworkObject findByName(String name) {

        return repository.findByName(name).orElseThrow(EntityNotFoundException::new);

    }
}
