package com.scalenelabs.smol.repository;

import com.scalenelabs.smol.model.ShortenedURL;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShortenedURLRepository extends JpaRepository<ShortenedURL, Long> {

}
