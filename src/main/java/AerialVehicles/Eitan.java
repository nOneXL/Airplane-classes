package AerialVehicles;

import Missions.*;

public class Eitan extends HaronVehicle {

    public Eitan(String pilotName, Mission aerialVehicleMission, int flightTimeBeforeLastFix, Boolean readyToFly, String sensorType, int missleAmount, String missleType) {
        super(pilotName, aerialVehicleMission, flightTimeBeforeLastFix, readyToFly, sensorType, missleAmount, missleType);
    }

    @Override
    public void setAerialVehicleMission(Mission aerialVehicleMission) throws MissionTypeException {
        if (aerialVehicleMission instanceof IntelligenceMission || aerialVehicleMission instanceof AttackMission) {
            super.setAerialVehicleMission(aerialVehicleMission);
        } else {
            throw new MissionTypeException("Cant take this type of mission");
        }

    }
}
