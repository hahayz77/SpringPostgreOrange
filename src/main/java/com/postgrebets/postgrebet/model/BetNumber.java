package com.postgrebets.postgrebet.model;

import javax.persistence.*;

@Entity(name = "betnumbers")
public class BetNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Bet bet;

    private int num;
    private int order;

    public BetNumber(Bet bet, int num, int order) {
        this.bet = bet;
        this.num = num;
        this.order = order;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Bet getBet() {
        return bet;
    }

    public void setBet(Bet bet) {
        this.bet = bet;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
