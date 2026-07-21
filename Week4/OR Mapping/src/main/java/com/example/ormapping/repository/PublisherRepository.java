package com.example.ormapping.repository;

import com.example.ormapping.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "publishers")
public interface PublisherRepository extends JpaRepository<Publisher, Long> {
}
