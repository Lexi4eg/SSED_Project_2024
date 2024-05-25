package com.example.swp_backend.leaderboard;


import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaderboardService {

    private final LeaderboardRepository leaderboardRepository;

    @Autowired
    public LeaderboardService(LeaderboardRepository leaderboardRepository) {
        this.leaderboardRepository = leaderboardRepository;
    }

    public List<Leaderboard> getLeaderboard() {
        return leaderboardRepository.findAll();
    }

    public Leaderboard createLeaderboard(Leaderboard leaderboard) {
        return leaderboardRepository.save(leaderboard);
    }

    public Leaderboard updateLeaderboard(Long id, Leaderboard leaderboardDetails) {
        Leaderboard leaderboard = leaderboardRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Leaderboard"));

        leaderboard.setScore(leaderboardDetails.getScore());
        leaderboard.setUsername(leaderboardDetails.getUsername());

        return leaderboardRepository.save(leaderboard);
    }

    public void deleteLeaderboard(Long id) {
        Leaderboard leaderboard = leaderboardRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Leaderboard"));

        leaderboardRepository.delete(leaderboard);
    }

}
