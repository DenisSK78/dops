package com.dops.dops.dao;

import javax.persistence.*;

@Entity
@Table(name = "city", schema = "dops")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "city_column_1_seq")
    @SequenceGenerator(name = "city_column_1_seq",
            sequenceName = "city_column_1_seq", allocationSize = 1)
    Long id;
    String name;

    public City() {
    }

    public City(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
