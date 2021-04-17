package com.heorhiireva.salesaccounting.service;

import com.heorhiireva.salesaccounting.persistence.entity.Supplier;
import com.heorhiireva.salesaccounting.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SupplierService {

    private SupplierRepository supplierRepository;

    public Supplier save(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    public Supplier getOne(UUID supplierId) {
        return supplierRepository.getOne(supplierId);
    }

    public List<Supplier> getAll() {
        return supplierRepository.findAll();
    }

    public void deleteById(UUID supplierId) {
        supplierRepository.deleteById(supplierId);
    }

    @Autowired
    public void setSupplierRepository(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }
}
