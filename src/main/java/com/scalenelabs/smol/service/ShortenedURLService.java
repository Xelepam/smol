package com.scalenelabs.smol.service;

import com.scalenelabs.smol.model.ShortenedURL;
import com.scalenelabs.smol.repository.ShortenedURLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ShortenedURLService {

    @Autowired
    private ShortenedURLRepository shortenedURLRepository;

    public ShortenedURLService(ShortenedURLRepository shortenedURLRepository) {
        this.shortenedURLRepository = shortenedURLRepository;
    }

    public String shorten(String URL) {
        ShortenedURL shortURL = new ShortenedURL();
        shortURL.setOriginalURL(URL);
        ShortenedURL savedURL = shortenedURLRepository.save(shortURL);

        List<String> stack = new ArrayList<>();

        // id is base 10
        // we need to make it base 62
        // [a-z] (26) + [A-Z] (26) + [0-9] (10) = 62
        // Shortening Algorithm Starts Here
        int id = 12345;
        int base = 62;
        String baseChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        char[] baseArr = baseChars.toCharArray();

        // Loop
        while (id >= 1) {
            String digit = String.valueOf(baseArr[id%base]);
            stack.add(digit);
            id = Math.floorDiv(id, base);
        }
        System.out.println(reverseArray(stack));
        return reverseArray(stack);
    }

    private String reverseArray( List<String> stack) {
        List<String> list = new ArrayList<>();
        for(int i = stack.size()-1; i >= 0; i--){
            list.add(stack.get(i));
        }
        return String.join(",", list).replace(",", "");
    }
}
