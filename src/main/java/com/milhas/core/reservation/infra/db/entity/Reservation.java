package com.milhas.core.reservation.infra.db.entity;
import com.milhas.core.agency.infra.db.entity.Agency;
import com.milhas.core.user.infra.db.entity.User;
import com.milhas.core.vehicle.infra.db.entity.GroupVehicle;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "reservation", schema = "milhas")
public class Reservation {
        @Id
        @Column(name = "id_reservation", columnDefinition = "uuid")
        private UUID idReservation;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "id_user", nullable = false)
        private User user;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "id_group_vehicle", nullable = false)
        private GroupVehicle vehicleGroup;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "id_agency_departure", nullable = false)
        private Agency agencyDeparture;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "id_agency_return", nullable = false)
        private Agency agencyReturn;

        @Column(name = "departure_date_time", nullable = false)
        private LocalDateTime departureDateTime;

        @Column(name = "return_date_time", nullable = false)
        private LocalDateTime returnDateTime;

        @Column(name = "status", nullable = false, length = 30)
        private String status;

        @Column(name = "create_date", nullable = false, columnDefinition = "timestamp default CURRENT_TIMESTAMP")
        private LocalDateTime createDate;

        @Column(name = "update_date")
        private LocalDateTime updateDate;

        @Column(name = "is_active", nullable = false)
        private boolean isActive;

        @Column(name = "is_same_return_agency", nullable = false)
        private boolean isSameReturnAgency;

}
