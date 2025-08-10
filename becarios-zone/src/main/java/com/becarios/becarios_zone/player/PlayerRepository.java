package com.becarios.becarios_zone.player;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {
    List<Player> findByName(String name);
    List<Player> findByCountry(String country);
    List<Player> findByMajor(String major);
    List<Player> findByCollege(String college);
    List<Player> findByState(String state);
}

