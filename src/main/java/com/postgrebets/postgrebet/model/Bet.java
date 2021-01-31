package com.postgrebets.postgrebet.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "bets")
public class Bet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date date;

    @OneToMany(mappedBy = "bet")
    private List<BetNumber> betNumbers;

    public Bet(Date date, List<BetNumber> betNumbers) {
        this.date = date;
        this.betNumbers = betNumbers;
    }

    public Bet() {    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
