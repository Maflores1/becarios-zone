package com.becarios.becarios_zone.player;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {
    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    // Get all players
    public List<Player> getPlayers() {
        return playerRepository.findAll();
    }

    // Get players by name (exact match)
    public List<Player> getPlayersByName(String name) {
        return playerRepository.findByName(name);
    }

    // Get players by country (exact match)
    public List<Player> getPlayersByCountry(String country) {
        return playerRepository.findByCountry(country);
    }

    // Get players by major (exact match)
    public List<Player> getPlayersByMajor(String major) {
        return playerRepository.findByMajor(major);
    }

    // Get players by college (exact match)
    public List<Player> getPlayersByCollege(String college) {
        return playerRepository.findByCollege(college);
    }

    // Get players by state (exact match)
    public List<Player> getPlayersByState(String state) {
        return playerRepository.findByState(state);
    }

    // Add new player
    @Transactional
    public Player addPlayer(Player player) {
        return playerRepository.save(player);
    }

    // Update existing player
    @Transactional
    public Player updatePlayer(Player player) {
        Optional<Player> existingPlayerOpt = playerRepository.findById(player.getPlayerId());

        if (existingPlayerOpt.isPresent()) {
            Player existingPlayer = existingPlayerOpt.get();
            // Update all fields except ID
            existingPlayer.setName(player.getName());
            existingPlayer.setSport(player.getSport());
            existingPlayer.setCountry(player.getCountry());
            existingPlayer.setMajor(player.getMajor());
            existingPlayer.setCollege(player.getCollege());
            existingPlayer.setState(player.getState());
            return playerRepository.save(existingPlayer);
        }
        return null; // Consider throwing a custom exception here
    }

    // Delete player by ID
    @Transactional
    public void deletePlayer(Integer playerId) {
        playerRepository.deleteById(playerId);
    }
}
