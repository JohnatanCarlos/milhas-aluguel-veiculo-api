package com.milhas.core.agency.infra.db.repository;

import com.milhas.core.agency.infra.db.entity.Agency;
import com.milhas.core.user.infra.db.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class AgencyRepositoryCustomImpl implements AgencyRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Agency> findAllCustom(String name) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Agency> query = cb.createQuery(Agency.class);
        Root<Agency> agency = query.from(Agency.class);

        List<Predicate> predicates = new ArrayList<>();

        if (StringUtils.hasText(name)) {
            predicates.add(cb.like(cb.lower(agency.get("name")), "%" + name.toLowerCase() + "%"));
        }

        query.where(predicates.toArray(new Predicate[0]));

        return entityManager.createQuery(query).getResultList();
    }
}
