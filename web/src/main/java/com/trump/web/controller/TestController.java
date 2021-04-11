package com.trump.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

@RestController
@Slf4j
@PropertySource(value = {"classpath:application.properties"}, encoding = "UTF-8")
public class TestController {
    @Value("${title}")
    private String title;

    @GetMapping("/getTitle")
    public String getString() throws UnsupportedEncodingException {
        log.info("title:"+title);
        String titleUtf = new String(title.getBytes("ISO-8859-1"), "UTF-8");
        log.info("title.utf-8:"+titleUtf);
        return titleUtf;
    }
}
