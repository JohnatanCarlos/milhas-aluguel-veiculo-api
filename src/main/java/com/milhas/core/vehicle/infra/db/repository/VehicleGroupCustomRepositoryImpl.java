package com.milhas.core.vehicle.infra.db.repository;

import com.milhas.core.reservation.infra.db.entity.Reservation;
import com.milhas.core.vehicle.infra.db.entity.VehicleGroup;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class VehicleGroupCustomRepositoryImpl implements VehicleGroupCustomRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<VehicleGroup> findAvailableVehicleGroups(LocalDateTime dateDeparture, LocalDateTime dateReturn) {
        // Inicializa o CriteriaBuilder
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        // Cria a consulta para a entidade VehicleGroup
        CriteriaQuery<VehicleGroup> criteriaQuery = criteriaBuilder.createQuery(VehicleGroup.class);
        Root<VehicleGroup> vehicleGroupRoot = criteriaQuery.from(VehicleGroup.class);

        // Subquery para verificar reservas existentes
        Subquery<UUID> subquery = criteriaQuery.subquery(UUID.class);
        Root<Reservation> reservationRoot = subquery.from(Reservation.class);

        // Condição da subquery para grupos de veículos com reservas conflitantes
        Predicate conflictPredicate = criteriaBuilder.and(
                criteriaBuilder.equal(vehicleGroupRoot.get("id"), reservationRoot.get("vehicleGroup").get("id")),
                criteriaBuilder.or(
                        criteriaBuilder.between(reservationRoot.get("departureDateTime"), dateDeparture, dateReturn),
                        criteriaBuilder.between(reservationRoot.get("returnDateTime"), dateDeparture, dateReturn),
                        criteriaBuilder.and(
                                criteriaBuilder.lessThanOrEqualTo(reservationRoot.get("departureDateTime"), dateDeparture),
                                criteriaBuilder.greaterThanOrEqualTo(reservationRoot.get("returnDateTime"), dateReturn)
                        )
                )
        );


        subquery.select(reservationRoot.get("vehicleGroup").get("id")).where(conflictPredicate);

        // Condição principal para grupos de veículos disponíveis
        Predicate availablePredicate = criteriaBuilder.not(vehicleGroupRoot.get("id").in(subquery));

        criteriaQuery.select(vehicleGroupRoot).where(availablePredicate);

        // Executa a consulta e retorna os resultados
        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}
