package AerialVehicles;

import Missions.IntelligenceMission;
import Missions.Mission;

import java.text.MessageFormat;

public abstract class UAVs extends AerialVehicle implements AerialIntelligenceVehicle {
    private String sensorType;

    public UAVs(String pilotName, Mission aerialVehicleMission, int flightTimeBeforeLastFix, Boolean readyToFly, String sensorType) {
        super(pilotName, aerialVehicleMission, flightTimeBeforeLastFix, readyToFly);
        this.sensorType = sensorType;
    }

    @Override
    public String collectIntelligence() {
        return MessageFormat.format(("{0}: {1} Collecting Data in {2} with sensor type: {3}"),
                super.getPilotName(), this.getClass().getSimpleName(),
                ((IntelligenceMission) this.getAerialVehicleMission()).getRegion(), this.sensorType);
    }

    public String getSensorType() {
        return sensorType;
    }

    public void setSensorType(String sensorType) {
        this.sensorType = sensorType;
    }
}
