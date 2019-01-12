package com.scalenelabs.smol.model;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class ShortenedURL{

    private Long id;
    private String originalURL;
    private String shortURL;
    private Long hits;

    public ShortenedURL() {

    }

    @Override
    public String toString() {
        return "ShortenedURL{" +
                "id=" + id +
                ", originalURL='" + originalURL + '\'' +
                ", shortURL='" + shortURL + '\'' +
                ", hits=" + hits +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShortenedURL that = (ShortenedURL) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(originalURL, that.originalURL) &&
                Objects.equals(shortURL, that.shortURL) &&
                Objects.equals(hits, that.hits);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, originalURL, shortURL, hits);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOriginalURL() {
        return originalURL;
    }

    public void setOriginalURL(String originalURL) {
        this.originalURL = originalURL;
    }

    public String getShortURL() {
        return shortURL;
    }

    public void setShortURL(String shortURL) {
        this.shortURL = shortURL;
    }

    public Long getHits() {
        return hits;
    }

    public void setHits(Long hits) {
        this.hits = hits;
    }
}
