package com.heorhiireva.salesaccounting.service;

import com.heorhiireva.salesaccounting.persistence.entity.Personal;
import com.heorhiireva.salesaccounting.repository.PersonalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PersonalService {

    private PersonalRepository personalRepository;

    public Personal getOne(UUID personalId) {
        return personalRepository.getOne(personalId);
    }

    public List<Personal> getAll() {
        return personalRepository.findAll();
    }

    @Autowired
    public void setPersonalRepository(PersonalRepository personalRepository) {
        this.personalRepository = personalRepository;
    }
}
