package com.krootix.microservices.networkservice.controller;

import com.krootix.microservices.networkservice.entity.NetworkService;
import com.krootix.microservices.networkservice.service.NetworkServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;

@RestController
public class NetworkServiceController {

    @Autowired
    private NetworkServiceService service;

    @GetMapping("/network-service/{name}")
    public NetworkService getNetworkService(@PathVariable String name) {
        try {
            return service.findByName(name);
        } catch (EntityNotFoundException ex) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "NetworkService " + name + " Not Found", ex);
        }
    }
}
