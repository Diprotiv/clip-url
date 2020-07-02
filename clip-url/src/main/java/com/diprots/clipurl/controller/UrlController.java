package com.diprots.clipurl.controller;

import com.diprots.clipurl.model.LongUrl;
import com.diprots.clipurl.model.Url;
import com.diprots.clipurl.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class UrlController {

    @Autowired
    UrlService urlService;

    @GetMapping("/urls/{shortUrl}")
    public Url getUrl(@PathVariable("shortUrl") final String shortUrl) {
        return urlService.getUrl(shortUrl);
    }

    @PostMapping("/urls")
    public Url postUrl(@RequestBody LongUrl longUrl) {
        return urlService.postUrl(longUrl);
    }

    @RequestMapping("/{shortUrl}")
    public RedirectView handleFoo(@PathVariable("shortUrl") final String shortUrl) {
        final Url url = urlService.getUrl(shortUrl);
        String redirectedUrl = "/";
        if (!StringUtils.isEmpty(url.getLongUrl())) {
            redirectedUrl = url.getLongUrl();
        }
        return new RedirectView(redirectedUrl);
    }
}
