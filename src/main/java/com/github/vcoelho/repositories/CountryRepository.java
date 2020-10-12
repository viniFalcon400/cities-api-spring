package com.github.vcoelho.repositories;

import com.github.vcoelho.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
