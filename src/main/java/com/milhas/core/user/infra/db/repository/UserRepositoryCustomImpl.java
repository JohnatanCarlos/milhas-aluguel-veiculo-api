package com.milhas.core.user.infra.db.repository;

import com.milhas.core.user.infra.db.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryCustomImpl implements  UserRepositoryCustom{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> findAllCustom(String name, String documentNumber, String nationality, String passport) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = cb.createQuery(User.class);
        Root<User> user = query.from(User.class);

        List<Predicate> predicates = new ArrayList<>();

        if (StringUtils.hasText(name)) {
            predicates.add(cb.equal(user.get("name"), name));
        }
        if (StringUtils.hasText(documentNumber)) {
            predicates.add(cb.equal(user.get("documentNumber"), documentNumber));
        }
        if (StringUtils.hasText(nationality)) {
            predicates.add(cb.equal(user.get("nationality"), nationality));
        }
        if (StringUtils.hasText(passport)) {
            predicates.add(cb.equal(user.get("passport"), passport));
        }

        query.where(predicates.toArray(new Predicate[0]));

        return entityManager.createQuery(query).getResultList();
    }
}
