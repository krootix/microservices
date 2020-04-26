package com.krootix.microservices.networkobject.controller;

import com.krootix.microservices.networkobject.entity.NetworkObject;
import com.krootix.microservices.networkobject.service.NetworkObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;

@RestController
public class NetworkObjectController {

    @Autowired
    private NetworkObjectService service;

    @GetMapping("/network-object/{name}")
    public NetworkObject getNetworkObject(@PathVariable String name) {
        try {
            return service.findByName(name);
        } catch (EntityNotFoundException ex) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "NetworkObject " + name + " Not Found", ex);
        }
    }
}