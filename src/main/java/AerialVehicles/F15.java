package AerialVehicles;

import Missions.*;

import java.text.MessageFormat;

public class F15 extends FighterAircraft implements AerialIntelligenceVehicle {
    private String sensorType;

    public F15(String pilotName, Mission aerialVehicleMission, int flightTimeBeforeLastFix, Boolean readyToFly, int missleAmount, String missleType, String sensorType) {
        super(pilotName, aerialVehicleMission, flightTimeBeforeLastFix, readyToFly, missleAmount, missleType);
        this.sensorType = sensorType;
    }

    @Override
    public String collectIntelligence() {
        return MessageFormat.format(("{0}: {1} Collecting Data in {2} with sensor type: {3}"),
                super.getPilotName(), this.getClass().getSimpleName(),
                ((IntelligenceMission) this.getAerialVehicleMission()).getRegion(), this.sensorType);
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
