package com.example.ManyToOneHiberneteSaveAndFetchData.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "country")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int countryId;
    private String countryName;

    private String population;
    @ManyToOne(cascade = CascadeType.ALL)

    private AllStateInIndia allStateInIndia;

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public AllStateInIndia getAllStateInIndia() {
        return allStateInIndia;
    }

    public void setAllStateInIndia(AllStateInIndia allStateInIndia) {
        this.allStateInIndia = allStateInIndia;
    }
}
