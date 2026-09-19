package com.cdui.brasileirao_api.repository;

import com.cdui.brasileirao_api.model.Fan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FanRepository extends JpaRepository<Fan, Long> {}