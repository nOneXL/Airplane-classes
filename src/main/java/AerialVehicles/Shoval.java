package AerialVehicles;

import Missions.BdaMission;
import Missions.Mission;
import Missions.MissionTypeException;

import java.text.MessageFormat;

public class Shoval extends HaronVehicle implements AerialBdaVehicle{
    private String cameraType;

    public Shoval(String pilotName, Mission aerialVehicleMission, int flightTimeBeforeLastFix, Boolean readyToFly, String sensorType, int missleAmount, String missleType, String cameraType) {
        super(pilotName, aerialVehicleMission, flightTimeBeforeLastFix, readyToFly, sensorType, missleAmount, missleType);
        this.cameraType = cameraType;
    }

    @Override
    public String preformBda() {
        return MessageFormat.format(("{0}: {1} taking pictures of {2} with: {3}"),
                super.getPilotName(), this.getClass().getName(),
                ((BdaMission) this.getAerialVehicleMission()).getObjective(), this.cameraType);
    }
}

