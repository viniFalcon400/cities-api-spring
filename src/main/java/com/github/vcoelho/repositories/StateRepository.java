package com.github.vcoelho.repositories;

import com.github.vcoelho.entities.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Long> {
}
