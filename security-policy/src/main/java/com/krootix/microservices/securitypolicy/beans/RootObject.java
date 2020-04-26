package com.krootix.microservices.securitypolicy.beans;

import java.util.Objects;

import static java.util.Objects.isNull;
import static org.apache.commons.lang.StringUtils.EMPTY;

public abstract class RootObject {


    protected Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    boolean isEmpty() {
        return (isNull(this.id) || this.id.equals(EMPTY))
                && (isNull(this.name) || this.name.equals(EMPTY));
    }

    RootObject() {
    }

    RootObject(Builder<?> builder) {
        this.id = builder.id;
        this.name = builder.name;
    }

    abstract static class Builder<T extends Builder<T>> {

        protected Long id;
        protected String name;

        public T withId(Long id) {
            this.id = id;
            return self();
        }

        public T withName(String name) {
            this.name = name;
            return self();
        }

        abstract RootObject build();

        protected abstract T self();

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RootObject that = (RootObject) o;
        return id.equals(that.id)
                && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
