package com.github.vcoelho.resources;

import com.github.vcoelho.entities.Country;
import com.github.vcoelho.repositories.CountryRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryResource {

	private final CountryRepository repository;

	public CountryResource(final CountryRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/countries")
	public List<Country> cities() {
		return repository.findAll();
	}

	@GetMapping("/countries/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Country findById(@PathVariable Long id) throws Exception {
		return repository.findById(id).orElseThrow(() -> new Exception("countries not id: " + id));
	}
}
