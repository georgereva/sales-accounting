package com.heorhiireva.salesaccounting.repository;

import com.heorhiireva.salesaccounting.persistence.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SaleRepository extends JpaRepository<Sale, UUID> {
}
