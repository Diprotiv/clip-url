package com.diprots.clipurl.utils;

import com.diprots.clipurl.model.LongUrl;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class UrlUtils {

    public static final String CODE = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public String getHash(LongUrl longUrl) {
        int randomNumber = new Random().nextInt();
        StringBuilder sb = new StringBuilder();
        while (randomNumber > 0) {
            sb.append(CODE.charAt(randomNumber % CODE.length()));
            randomNumber /= CODE.length();
        }
        return sb.toString();
    }




}
