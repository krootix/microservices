package com.krootix.microservices.networkservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class NetworkService {

    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "portprotocol")
    private String portProtocol;

    @Column(name = "protocoltype")
    private String protocolType;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getPortProtocol() {
        return portProtocol;
    }

    public String getProtocolType() {
        return protocolType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NetworkService that = (NetworkService) o;
        return id.equals(that.id) &&
                name.equals(that.name) &&
                Objects.equals(type, that.type) &&
                Objects.equals(portProtocol, that.portProtocol) &&
                Objects.equals(protocolType, that.protocolType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type, portProtocol, protocolType);
    }

    @Override
    public String toString() {
        return "Service{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", portProtocol='" + portProtocol + '\'' +
                '}';
    }

    public static class Builder {

        private Long id;
        private String name;
        private String type;
        private String portProtocol;
        private String protocolType;

        public Builder() {
            // just needed
        }

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
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

        public NetworkService build() {

            NetworkService networkService = new NetworkService();

            networkService.id = this.id;
            networkService.name = this.name;
            networkService.type = this.type;
            networkService.portProtocol = this.portProtocol;
            networkService.protocolType = this.protocolType;

            return networkService;
        }
    }
}
