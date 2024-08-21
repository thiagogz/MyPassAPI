package com.fiap.mypass.project.passwords;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PasswordsRepository extends JpaRepository<Passwords, Long> {
    Optional<Passwords> findByUsername(String username);
}
