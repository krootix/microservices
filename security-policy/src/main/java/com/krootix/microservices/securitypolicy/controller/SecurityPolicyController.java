package com.krootix.microservices.securitypolicy.controller;

import com.krootix.microservices.securitypolicy.beans.NetworkObject;
import com.krootix.microservices.securitypolicy.beans.NetworkService;
import com.krootix.microservices.securitypolicy.beans.RootObject;
import com.krootix.microservices.securitypolicy.beans.SecurityPolicy;
import com.krootix.microservices.securitypolicy.objectutil.SecurityPolicyFactory;
import com.krootix.microservices.securitypolicy.proxy.NetworkObjectServiceProxy;
import com.krootix.microservices.securitypolicy.proxy.NetworkServiceServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@RestController
public class SecurityPolicyController {

    @Autowired
    private NetworkObjectServiceProxy networkObjectServiceProxy;

    @Autowired
    private NetworkServiceServiceProxy networkServiceServiceProxy;

    @Autowired
    SecurityPolicyFactory securityPolicyFactory;

    private static String ACTION_ACCEPT = "accept";
    private static String SOURCE = "http://localhost:8000/network-object/";
    private static String SOURCE_NAME = "source";
    private static String DESTINATION = "http://localhost:8000/network-object/";
    private static String DESTINATION_NAME = "destination";
    private static String SERVICE = "http://localhost:8001/network-service/";
    private static String SERVICE_NAME = "service";
    private static String LEFT_CURLY_BRACE = "{";
    private static String RIGHT_CURLY_BRACE = "}";


    @GetMapping("/security-policy/name/{name}/source/{source}/destination/{destination}/service/{service}")
    public SecurityPolicy createPolicy(/*@PathVariable Long id,*/ @PathVariable String name, @PathVariable String source, @PathVariable String destination,
                                                                  @PathVariable String service) {

        RequestProvider<? extends RootObject> requestProvider = (url, pointer, value, clazz) ->
                new RestTemplate()
                        .getForEntity(url + LEFT_CURLY_BRACE + pointer + RIGHT_CURLY_BRACE,
                                clazz, Collections.singletonMap(pointer, value))
                        .getBody();

        NetworkObject networkObjectSource = (NetworkObject) requestProvider.request(SOURCE, SOURCE_NAME, source, NetworkObject.class);
        NetworkObject networkObjectDestination = (NetworkObject) requestProvider.request(DESTINATION, DESTINATION_NAME, destination, NetworkObject.class);
        NetworkService networkService = (NetworkService) requestProvider.request(SERVICE, SERVICE_NAME, service, NetworkService.class);

        return securityPolicyFactory.create(/*id,*/ name, networkObjectSource,
                networkObjectDestination, networkService, ACTION_ACCEPT);
    }

    @GetMapping("/security-policy-feign/name/{name}/source/{source}/destination/{destination}/service/{service}")
    public SecurityPolicy createPolicyFeign(/*@PathVariable Long id, */@PathVariable String name, @PathVariable String source, @PathVariable String destination,
                                                                       @PathVariable String service) {

        NetworkObject networkObjectSourceResponse = networkObjectServiceProxy.retrieveNetworkObject(source);
        NetworkObject networkObjectDestinationResponse = networkObjectServiceProxy.retrieveNetworkObject(destination);
        NetworkService networkServiceResponse = networkServiceServiceProxy.retrieveNetworkService(service);

        return securityPolicyFactory.create(/*id,*/ name, networkObjectSourceResponse,
                networkObjectDestinationResponse, networkServiceResponse, ACTION_ACCEPT);
    }
}
