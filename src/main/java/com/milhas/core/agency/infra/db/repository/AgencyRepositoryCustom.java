package com.milhas.core.agency.infra.db.repository;

import com.milhas.core.agency.infra.db.entity.Agency;

import java.util.List;

public interface AgencyRepositoryCustom {
    List<Agency> findAllCustom(String name);
}
