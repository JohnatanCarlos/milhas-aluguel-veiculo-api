package com.milhas.core.agency.infra.db.repository;

import com.milhas.core.agency.infra.db.entity.Agency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AgencyRepository extends JpaRepository<Agency, UUID> {
}
