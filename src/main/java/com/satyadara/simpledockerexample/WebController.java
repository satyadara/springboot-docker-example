package com.satyadara.simpledockerexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class WebController {
    @Autowired
    private ExampleRepository exampleRepository;

    @GetMapping("/hello-world")
    public String helloWorld() {
        return "hello world!";
    }

    @GetMapping(value = "/create", produces = APPLICATION_JSON_VALUE)
    public String create(@RequestParam String name) {
        return name.isEmpty() ? "Name is Empty!" : exampleRepository.save(
                ExampleEntity.builder().name(name).build()
        ).toString();
    }

    @GetMapping(value = "/list", produces = APPLICATION_JSON_VALUE)
    public List<ExampleEntity> getAll() {
        return exampleRepository.findAll();
    }
}
