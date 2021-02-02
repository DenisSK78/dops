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
    @GeneratedValue(strategy= GenerationType.AUTO)
    Integer id;
    String name;

    public City(String name) {
        this.name = name;
    }
}
