package com.postgrebets.postgrebet.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity(name = "ganblers")
public class Ganbler {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id;

    @NotNull
    private String email;

    @OneToMany
    private List<Bet> betList;

    public Ganbler(String email, List<Bet> betList) {
        this.email = email;
        this.betList = betList;
    }

    public Ganbler() {   }

    public Ganbler(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Bet> getBetList() {
        return betList;
    }

    public void setBetList(List<Bet> betList) {
        this.betList = betList;
    }
}
