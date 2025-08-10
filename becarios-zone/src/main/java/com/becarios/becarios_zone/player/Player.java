package com.becarios.becarios_zone.player;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "players")
public class Player {
    @Id
    @Column(name = "playerID") // Specify the correct column name with the exact casing
    private Integer playerId;

    private String name;
    private String sport;
    private String country;
    private String major;
    private String college;
    private String state;

    public Player() {
    }

    public Player(Integer playerId, String name, String sport, String country, String major, String college, String state) {
        this.playerId = playerId;
        this.name = name;
        this.sport = sport;
        this.country = country;
        this.major = major;
        this.college = college;
        this.state = state;
    }

    public Player(String name) {
        this.name = name;
    }

    // Getters and Setters...
    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
