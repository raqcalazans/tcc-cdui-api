package com.cdui.brasileirao_api.repository;

import com.cdui.brasileirao_api.model.GameEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameEventRepository extends JpaRepository<GameEvent, Integer> {}
