package com.atamertc.repository;

import com.atamertc.repository.entity.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Long> {

    Optional<Score> findByUserid(Long userid);

    List<Score> findAllByOrderByScoreDesc();
}
