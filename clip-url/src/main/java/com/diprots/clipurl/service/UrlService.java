package com.diprots.clipurl.service;

import com.diprots.clipurl.model.LongUrl;
import com.diprots.clipurl.model.Url;
import com.diprots.clipurl.repository.UrlRepository;
import com.diprots.clipurl.utils.UrlUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Service
public class UrlService {

    @Autowired
    UrlRepository urlRepository;

    @Autowired
    UrlUtils urlUtils;

    @Value("${url.default.prefix}")
    private String urlPrefix;

    public Url getUrl(final String shortUrl) {
        if (StringUtils.isEmpty(shortUrl)) {
            return Url.builder().build();
        }
        Optional<Url> url = urlRepository.findById(shortUrl);
        if (!url.isPresent()) {
            return Url.builder().build();
        }
        return url.get();
    }

    public Url postUrl(final LongUrl longUrl) {
        final String shortUrl = urlUtils.getHash(longUrl);
        if (urlRepository.existsById(shortUrl)) {
            return urlRepository.findById(shortUrl).orElse(null);
        }
        Url url = Url.builder()
                .shortUrl(shortUrl)
                .longUrl(longUrl.getUrl())
                .customizedUrl(urlPrefix + shortUrl)
                .creationDate(System.currentTimeMillis()).build();
        urlRepository.save(url);
        return url;
    }
}
