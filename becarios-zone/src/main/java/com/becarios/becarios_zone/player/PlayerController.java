package com.becarios.becarios_zone.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping(path = "api/v1/player")
public class PlayerController {

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public List<Player> getPlayers(@RequestParam(required = false) String name,
                                   @RequestParam(required = false) String country,
                                   @RequestParam(required = false) String major,
                                   @RequestParam(required = false) String college,
                                   @RequestParam(required = false) String state) {
        if (name != null) {
            return playerService.getPlayersByName(name);
        } else if (country != null) {
            return playerService.getPlayersByCountry(country);
        } else if (major != null) {
            return playerService.getPlayersByMajor(major);
        } else if (college != null) {
            return playerService.getPlayersByCollege(college);
        } else if (state != null) {
            return playerService.getPlayersByState(state);
        } else {
            return playerService.getPlayers(); // Return all players if no filters are applied
        }
    }

    @PostMapping
    public ResponseEntity<Player> addPlayer(@RequestBody Player player) {
        Player createdPlayer = playerService.addPlayer(player);
        return new ResponseEntity<>(createdPlayer, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Player> updatePlayer(@PathVariable Integer id, @RequestBody Player player) {
        player.setPlayerId(id); // Set the ID for the player to update
        Player updatedPlayer = playerService.updatePlayer(player);
        return updatedPlayer != null ? ResponseEntity.ok(updatedPlayer) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable Integer id) {
        playerService.deletePlayer(id);
        return ResponseEntity.noContent().build();
    }
}
