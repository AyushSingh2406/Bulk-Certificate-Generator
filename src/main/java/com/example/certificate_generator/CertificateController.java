package com.example.certificate_generator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.certificate_generator.model.Participant;
import com.example.certificate_generator.repository.ParticipantRepository;

@Controller
public class CertificateController {

    @Autowired
    private ParticipantRepository participantRepository;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/submit")
    public String submit(
            @RequestParam("firstName") String firstName, 
            @RequestParam("lastName") String lastName, 
            @RequestParam("university") String university,
            Model model) {
        
        Participant participant = new Participant();
        participant.setFirstName(firstName);
        participant.setLastName(lastName);
        participant.setUniversity(university);
        participant.setCreatedAt(java.time.LocalDateTime.now());
        
        participantRepository.save(participant);
        
        model.addAttribute("participant", participant);
        return "certificate";
    }
}

