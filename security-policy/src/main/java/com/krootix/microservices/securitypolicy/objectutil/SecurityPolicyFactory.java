package com.krootix.microservices.securitypolicy.objectutil;

import com.krootix.microservices.securitypolicy.beans.NetworkObject;
import com.krootix.microservices.securitypolicy.beans.NetworkService;
import com.krootix.microservices.securitypolicy.beans.SecurityPolicy;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class SecurityPolicyFactory implements AbstractFactory<SecurityPolicy> {

    @Override
    @Cacheable("securityPolicy")
    public SecurityPolicy create(/*Long id,*/ String name, NetworkObject source, NetworkObject destination,
                                              NetworkService service, String action) {

        return new SecurityPolicy.Builder(/*id*/)
                .autoId(/*id*/)
                .withName(name)
                .withSource(source)
                .withDestination(destination)
                .withService(service)
                .withAction(action)
                .build();
    }
}
