package com.example.swp_backend.leaderboard;
import com.example.swp_backend.leaderboard.Leaderboard;
import org.springframework.data.jpa.repository.JpaRepository;
public interface LeaderboardRepository extends JpaRepository<Leaderboard, Long> {

}
