package com.krootix.microservices.networkobject.entity;

import com.krootix.microservices.networkobject.util.StringListConverter;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "network_object")
public class NetworkObject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "ips")
    @Convert(converter = StringListConverter.class)
    private List<String> ips;

    @Column(name = "netmask")
    private String netmask;

    private NetworkObject() {

    }

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getIps() {
        return ips;
    }

    public void setIps(List<String> ips) {
        this.ips = ips;
    }

    public String getNetmask() {
        return netmask;
    }

    public void setNetmask(String netmask) {
        this.netmask = netmask;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NetworkObject that = (NetworkObject) o;
        return id.equals(that.id) &&
                name.equals(that.name) &&
                Objects.equals(type, that.type) &&
                Objects.equals(ips, that.ips) &&
                Objects.equals(netmask, that.netmask);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type, ips, netmask);
    }
}