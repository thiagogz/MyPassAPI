package com.fiap.mypass.project.passwords;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/pass")
public class PasswordsController {
    @Autowired
    PasswordsService service;

    @GetMapping
    public List<Passwords> findAll() {
        return service.findAll();
    }

    @PostMapping
    public ResponseEntity<Passwords> create(@RequestBody Passwords password, UriComponentsBuilder uriBuilder) {
        service.create(password);

        var uri = uriBuilder
                .path("/users/{id}")
                .buildAndExpand(password.getId())
                .toUri();

        return ResponseEntity
                .created(uri)
                .body(password);

    }
}
