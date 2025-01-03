package com.milhas.core.vehicle.app.dto.response;

//import com.milhas.core.vehicle.infra.db.entity.OptionalVehicle;
import lombok.Data;

import java.util.UUID;

@Data
public class OptionalVehicleResponseDTO {
    private UUID id;
    private boolean armored;
    private String gear;
    private boolean airConditioning;
    private boolean airBag;
    private short doors;
    private short numberSuitcases;
    private short numberPeople;
    private boolean leatherSeat;
    private boolean electricGlass;
    private String steering;
    private boolean abs;
    private boolean fourByFour;
    private String fuel;
    private boolean sunroof;

//    public OptionalVehicleResponseDTO(OptionalVehicle optionalVehicle) {
//        this.id = optionalVehicle.getId();
//        this.armored = optionalVehicle.isArmored();
//        this.gear = optionalVehicle.getGear();
//        this.airConditioning = optionalVehicle.isAirConditioning();
//        this.airBag = optionalVehicle.isAirBag();
//        this.doors = optionalVehicle.getDoors();
//        this.numberSuitcases = optionalVehicle.getNumberSuitcases();
//        this.numberPeople = optionalVehicle.getNumberPeople();
//        this.leatherSeat = optionalVehicle.isLeatherSeat();
//        this.electricGlass = optionalVehicle.isElectricGlass();
//        this.steering = optionalVehicle.getSteering();
//        this.abs = optionalVehicle.isAbs();
//        this.fourByFour = optionalVehicle.isFourByFour();
//        this.fuel = optionalVehicle.getFuel();
//        this.sunroof = optionalVehicle.isSunroof();
//    }
}