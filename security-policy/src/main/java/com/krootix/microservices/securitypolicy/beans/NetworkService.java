package com.krootix.microservices.securitypolicy.beans;

import java.util.Objects;

public class NetworkService extends RootObject {

    private String type;
    private String portProtocol;
    private String protocolType;

    public String getType() {
        return type;
    }

    public String getPortProtocol() {
        return portProtocol;
    }

    public String getProtocolType() {
        return protocolType;
    }

    NetworkService() {
        super();
    }

    private NetworkService(Builder builder) {
        super(builder);
        this.type = builder.type;
        this.portProtocol = builder.portProtocol;
        this.protocolType = builder.protocolType;
    }

    public static class Builder extends RootObject.Builder<Builder> {

        private String type;
        private String portProtocol;
        private String protocolType;

        public Builder() {
//            this.id = id;
        }

        public Builder withType(String type) {
            this.type = type;
            return this;
        }

        public Builder withPortProtocol(String portProtocol) {
            this.portProtocol = portProtocol;
            return this;
        }

        public Builder withProtocolType(String protocolType) {
            this.protocolType = protocolType;
            return this;
        }

        @Override
        public NetworkService build() {
            return new NetworkService(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        NetworkService that = (NetworkService) o;
        return type.equals(that.type)
                && Objects.equals(portProtocol, that.portProtocol)
                && Objects.equals(protocolType, that.protocolType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), type, portProtocol, protocolType);
    }
}
