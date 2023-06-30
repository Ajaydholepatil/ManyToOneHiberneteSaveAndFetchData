package com.example.ManyToOneHiberneteSaveAndFetchData.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "allStateInIndia")
public class AllStateInIndia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int allStateInIndiaId;

    private String stateName;

    private String statePopulation;

    public int getAllStateInIndiaId() {
        return allStateInIndiaId;
    }

    public void setAllStateInIndiaId(int allStateInIndiaId) {
        this.allStateInIndiaId = allStateInIndiaId;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getStatePopulation() {
        return statePopulation;
    }

    public void setStatePopulation(String statePopulation) {
        this.statePopulation = statePopulation;
    }
}
