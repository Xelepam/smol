package com.scalenelabs.smol.service;


import com.scalenelabs.smol.repository.ShortenedURLRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ShortenedURLServiceTest {

    ShortenedURLService shortenedURLService;
    ShortenedURLRepository mockShortenedURLRepository;


    @Before
    public void setup() {
        mockShortenedURLRepository = Mockito.mock(ShortenedURLRepository.class);
        shortenedURLService = new ShortenedURLService(mockShortenedURLRepository);
    }

//    @Test
//    public void shortenCallsShortenURLRepo() {
//        shortenedURLService.shorten("google.com");
//
//    }

    @Test
    public void shortenReturnsShortenedURL() {
        String shortURL = shortenedURLService.shorten("google.com");
        boolean matches = shortURL.matches("^[a-zA-Z0-9]+$");
        assertTrue(matches);
    }
}
