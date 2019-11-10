package com.heorhiireva.salesaccounting.service;

import com.heorhiireva.salesaccounting.persistence.entity.Sale;
import com.heorhiireva.salesaccounting.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SaleService {

    private SaleRepository saleRepository;

    public Long count() {
        return saleRepository.count();
    }

    public Sale save(Sale sale) {
        return saleRepository.save(sale);
    }

    public Sale getOne(UUID saleId) {
        return saleRepository.getOne(saleId);
    }

    public List<Sale> getAll() {
        return saleRepository.findAll();
    }

    @Autowired
    public void setSaleRepository(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }
}
