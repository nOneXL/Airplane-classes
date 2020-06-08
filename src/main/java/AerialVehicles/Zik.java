package AerialVehicles;

import Missions.BdaMission;
import Missions.IntelligenceMission;
import Missions.Mission;
import Missions.MissionTypeException;

public class Zik extends HermesVehicle {

    public Zik(String pilotName, Mission aerialVehicleMission, int flightTimeBeforeLastFix, Boolean readyToFly, String sensorType, String cameraType) {
        super(pilotName, aerialVehicleMission, flightTimeBeforeLastFix, readyToFly, sensorType, cameraType);
    }

    @Override
    public void setAerialVehicleMission(Mission aerialVehicleMission) throws MissionTypeException {
        if (aerialVehicleMission instanceof IntelligenceMission || aerialVehicleMission instanceof BdaMission) {
            super.setAerialVehicleMission(aerialVehicleMission);
        } else {
            throw new MissionTypeException("Cant take this type of mission");
        }

    }
}
