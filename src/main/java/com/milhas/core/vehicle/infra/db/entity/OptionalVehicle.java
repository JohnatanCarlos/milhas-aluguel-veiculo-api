//package com.milhas.core.vehicle.infra.db.entity;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import java.util.UUID;
//
//@Entity
//@Getter
//@Setter
//@NoArgsConstructor
//@Table(name = "optional_vehicle")
//public class OptionalVehicle {
//    @Id
//    @GeneratedValue(strategy = GenerationType.UUID)
//    @Column(name = "id_optional_vehicle", nullable = false, unique = true)
//    private UUID id;
//
//    @Column(name = "armored")
//    private boolean armored;
//
//    @Column(name = "gear")
//    private String gear;
//
//    @Column(name = "airConditioning")
//    private boolean airConditioning;
//
//    @Column(name = "airBag")
//    private boolean airBag;
//
//    @Column(name = "doors")
//    private short doors;
//
//    @Column(name = "numberSuitcases")
//    private short numberSuitcases;
//
//    @Column(name = "numberPeople")
//    private short numberPeople;
//
//    @Column(name = "leatherSeat")
//    private boolean leatherSeat;
//
//    @Column(name = "electricGlass")
//    private boolean electricGlass;
//
//    @Column(name = "steering")
//    private String steering;
//
//    @Column(name = "abs")
//    private boolean abs;
//
//    @Column(name = "fourByFour")
//    private boolean fourByFour;
//
//    @Column(name = "fuel")
//    private String fuel;
//
//    @Column(name = "sunroof")
//    private boolean sunroof;
//}
