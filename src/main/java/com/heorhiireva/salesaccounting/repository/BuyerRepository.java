package com.heorhiireva.salesaccounting.repository;

import com.heorhiireva.salesaccounting.persistence.entity.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BuyerRepository extends JpaRepository<Buyer, UUID> {
}
