package com.fiap.mypass.project.passwords;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PasswordsService {

    @Autowired
    PasswordsRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<Passwords> findAll(){
        return repository.findAll();
    }

    public Passwords create(Passwords passwords){
        passwords.setPassword(passwordEncoder.encode(passwords.getPassword()));
        return repository.save(passwords);
    }
}
