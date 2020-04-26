package com.krootix.microservices.securitypolicy.proxy;

import com.krootix.microservices.securitypolicy.beans.NetworkService;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "networkservice-service")
@RibbonClient(name = "networkservice-service")
public interface NetworkServiceServiceProxy {

    @GetMapping("/network-service/{name}")
    NetworkService retrieveNetworkService
            (@PathVariable("name") String name);
}
