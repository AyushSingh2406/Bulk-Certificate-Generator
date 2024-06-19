package com.example.certificate_generator.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.certificate_generator.model.Participant;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {
}
