package com.cdui.amantesdofutebol.repository;

import com.cdui.amantesdofutebol.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, String> {
}
