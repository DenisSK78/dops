package com.dops.dops.dao;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@ToString
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "city_column_1_seq")
    @SequenceGenerator(name = "city_column_1_seq", sequenceName = "city_column_1_seq", allocationSize = 1)
    Long id;
    String name;

    public City(String name) {
        this.name = name;
    }
}
