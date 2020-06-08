package AerialVehicles;

import Missions.AttackMission;
import Missions.BdaMission;
import Missions.Mission;

import java.text.MessageFormat;

public abstract class HermesVehicle extends UAVs implements AerialBdaVehicle {
    private final int HoursLimitToBeFixed = 100;
    private String cameraType;

    public HermesVehicle(String pilotName, Mission aerialVehicleMission, int flightTimeBeforeLastFix, Boolean readyToFly, String sensorType, String cameraType) {
        super(pilotName, aerialVehicleMission, flightTimeBeforeLastFix, readyToFly, sensorType);
        this.cameraType = cameraType;
    }

    @Override
    public void check() {
        if (super.getFlightTimeBeforeLastFix() >= this.HoursLimitToBeFixed) {
            super.repair();
        }
    }

    @Override
    public String preformBda() {
        return MessageFormat.format(("{0}: {1} taking pictures of {2} with: {3}"),
                super.getPilotName(), this.getClass().getName(),
                ((BdaMission) this.getAerialVehicleMission()).getObjective(), this.cameraType);
    }

    public String getCameraType() {
        return cameraType;
    }

    public void setCameraType(String cameraType) {
        this.cameraType = cameraType;
    }
}
