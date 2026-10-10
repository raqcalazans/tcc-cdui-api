package com.cdui.amantesdofutebol.repository;

import com.cdui.amantesdofutebol.model.Fan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface FanRepository extends JpaRepository<Fan, Long> {
    boolean existsByEmailIgnoreCase(String email);
    Optional<Fan> findByEmailIgnoreCase(String email);
}
