package com.krootix.microservices.securitypolicy.objectutil;

import com.krootix.microservices.securitypolicy.beans.NetworkObject;
import com.krootix.microservices.securitypolicy.beans.NetworkService;

public interface AbstractFactory<T> {

    T create(/*Long id, */String name, NetworkObject source, NetworkObject destination,
                          NetworkService service, String action);
}