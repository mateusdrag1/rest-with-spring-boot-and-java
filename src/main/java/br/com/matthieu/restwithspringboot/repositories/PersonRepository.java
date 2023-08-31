package br.com.matthieu.restwithspringboot.repositories;

import br.com.matthieu.restwithspringboot.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
