package com.krootix.microservices.securitypolicy.beans;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

import static java.util.Objects.isNull;

public class SecurityPolicy extends RootObject {

    private static final AtomicLong count = new AtomicLong(0);

    private NetworkObject source;

    private NetworkObject destination;

    private NetworkService service;

    private String action;

    SecurityPolicy(RootObject.Builder<?> builder) {
        super(builder);
    }

    public NetworkObject getSource() {
        return source;
    }

    public NetworkObject getDestination() {
        return destination;
    }

    public NetworkService getService() {
        return service;
    }

    public String getAction() {
        return action;
    }

    public static class Builder extends RootObject.Builder<Builder> {

        private NetworkObject source;
        private NetworkObject destination;
        private NetworkService service;
        private String action;

        public Builder() {
        }

        public Builder autoId() {
            this.id = count.incrementAndGet();
            return this;
        }

        public Builder withSource(NetworkObject source) {
            this.source = source;
            return this;
        }

        public Builder withDestination(NetworkObject destination) {
            this.destination = destination;
            return this;
        }

        public Builder withService(NetworkService service) {
            this.service = service;
            return this;
        }

        public Builder withAction(String action) {
            this.action = action;
            return this;
        }

        @Override
        public SecurityPolicy build() {
            return new SecurityPolicy(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    private SecurityPolicy(Builder builder) {
        super(builder);
        this.source = builder.source;
        this.destination = builder.destination;
        this.service = builder.service;
        this.action = builder.action;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SecurityPolicy that = (SecurityPolicy) o;
        return source.equals(that.source)
                && destination.equals(that.destination)
                && service.equals(that.service);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), source, destination, service);
    }

    @Override
    boolean isEmpty() {
        return super.isEmpty()
                && (isNull(this.source))
                && (isNull(this.destination))
                && (isNull(this.service));
    }
}
