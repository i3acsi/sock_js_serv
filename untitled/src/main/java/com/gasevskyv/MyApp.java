package com.gasevskyv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;

import java.util.Collections;

@SpringBootApplication
@ServletComponentScan
@EnableConfigurationProperties
public class MyApp {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(MyApp.class);
        app.setDefaultProperties(Collections
                .singletonMap("server.port", "7080"));
        app.run(args);
    }
}
