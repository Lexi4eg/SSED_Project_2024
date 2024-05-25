package com.example.swp_backend.leaderboard;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:5138")
@RestController
@RequestMapping("/api/v1/leaderboard")
public class LeaderboardController {
    private final LeaderboardService leaderboardService;

    public LeaderboardController(LeaderboardService leaderboardService) {
        this.leaderboardService = leaderboardService;
    }

    @GetMapping
    public List<Leaderboard> getLeaderboards() {
        return leaderboardService.getLeaderboard();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Leaderboard createLeaderboard(@RequestBody Leaderboard leaderboard) {
        return leaderboardService.createLeaderboard(leaderboard);
    }

    @PutMapping("/{id}")
    public Leaderboard updateLeaderboard(@PathVariable Long id, @RequestBody Leaderboard leaderboard) {
        return leaderboardService.updateLeaderboard(id, leaderboard);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLeaderboard(@PathVariable Long id) {
        leaderboardService.deleteLeaderboard(id);
    }
}