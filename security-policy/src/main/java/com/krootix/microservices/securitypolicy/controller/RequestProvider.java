package com.krootix.microservices.securitypolicy.controller;

import com.krootix.microservices.securitypolicy.beans.RootObject;

@FunctionalInterface
public interface RequestProvider<T extends RootObject> {

    T request(String nameOfObject, String pointer, String value, Class<? extends RootObject> clazz);

}
