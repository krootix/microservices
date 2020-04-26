package com.krootix.microservices.securitypolicy.beans;

import java.util.List;

import static java.util.Objects.isNull;
import static org.apache.commons.lang.StringUtils.EMPTY;

public class NetworkObject extends RootObject {

    private String type;
    private List<String> ips;
    private String netmask;

    public NetworkObject() {
        super();
    }

    private NetworkObject(Builder builder) {
        super(builder);
        this.type = builder.type;
        this.ips = builder.ips;
        this.netmask = builder.netmask;
    }

    public String getType() {
        return type;
    }

    public List<String> getIps() {
        return ips;
    }

    public String getNetmask() {
        return netmask;
    }

    @Override
    public String toString() {
        return super.toString() +
                "NetworkObject{" +
                "id='" + id + '\'' +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", ips='" + ips + '\'' +
                '}';
    }

    @Override
    public boolean isEmpty() {
        return super.isEmpty()
                && (isNull(this.getIps()) || this.getIps().isEmpty())
                && (isNull(this.getType()) || this.getType().equals(EMPTY))
                && (isNull(this.getNetmask()) || this.getNetmask().equals(EMPTY));
    }

    public static class Builder extends RootObject.Builder<Builder> {

        private String type;
        private List<String> ips;
        private String netmask;

        public Builder() {
            // just needed
        }

        public Builder withType(String type) {
            this.type = type;
            return this;
        }

        public Builder withIps(List<String> ips) {
            this.ips = ips;
            return this;
        }

        public Builder withNetmask(String netmask) {
            this.netmask = netmask;
            return this;
        }

        @Override
        public NetworkObject build() {
            return new NetworkObject(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

}