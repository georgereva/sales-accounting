package com.heorhiireva.salesaccounting.service;

import com.heorhiireva.salesaccounting.persistence.entity.Buyer;
import com.heorhiireva.salesaccounting.repository.BuyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BuyerService {

    private BuyerRepository buyerRepository;

    public Buyer getOne(UUID buyerId) {
        return buyerRepository.getOne(buyerId);
    }

    public List<Buyer> getAll() {
        return buyerRepository.findAll();
    }

    @Autowired
    public void setBuyerRepository(BuyerRepository buyerRepository) {
        this.buyerRepository = buyerRepository;
    }
}
