package com.krootix.microservices.securitypolicy.proxy;

import com.krootix.microservices.securitypolicy.beans.NetworkObject;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "networkobject-service")
@RibbonClient(name = "networkobject-service")
public interface NetworkObjectServiceProxy {

    @GetMapping("/network-object/{name}")
    NetworkObject retrieveNetworkObject
            (@PathVariable("name") String name);
}
