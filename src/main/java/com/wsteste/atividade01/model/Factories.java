package com.wsteste.atividade01.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "TB_FACTORIES")
public class Factories implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MARCA_ID", nullable = false)
    private long factory_id;
    @Column(name = "MARCA_NOME", nullable = false)
    private String factory_name;
    @Column(name = "COUNTRY", nullable = false)
    private String factory_country;

    public Factories(String factory_name, String factory_country) {
        this.factory_name = factory_name;
        this.factory_country = factory_country;
    }

    public Factories() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Factories factories = (Factories) o;
        return factory_id == factories.factory_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(factory_id);
    }

    public Long getFactory_id() {
        return factory_id;
    }

    public void setFactory_id(Long factory_id) {
        this.factory_id = factory_id;
    }

    public String getFactory_name() {
        return factory_name;
    }

    public void setFactory_name(String factory_name) {
        this.factory_name = factory_name;
    }

    public String getFactory_country() {
        return factory_country;
    }

    public void setFactory_country(String factory_country) {
        this.factory_country = factory_country;
    }
}
