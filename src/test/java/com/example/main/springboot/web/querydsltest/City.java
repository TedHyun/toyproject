package com.example.main.springboot.web.querydsltest;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;


@Getter
@NoArgsConstructor
@Entity
@Table(name = "cities")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 500, nullable = false)
    private String name;

    @Column
    private int population;

    @Builder
    public City(String name,int population){

        this.name = name;
        this.population = population;
    }

    @Override
    public int hashCode(){
        int hash =7;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.name);
        hash = 79 * hash + this.population;
        return hash;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }

        if (obj == null){
            return false;
        }
        if (getClass() != getClass()){
            return false;
        }
        final City other = (City) obj;

        if (this.population != other.population){
            return false;
        }

        if (!Objects.equals(this.name, other.name)){
            return false;
        }
        return Objects.equals(this.id, other.id);
    }
}
