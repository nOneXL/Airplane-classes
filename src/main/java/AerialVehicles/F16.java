package AerialVehicles;

import Missions.*;

import java.text.MessageFormat;

public class F16 extends FighterAircraft implements AerialBdaVehicle {
    private String cameraType;

    public F16(String pilotName, Mission aerialVehicleMission, int flightTimeBeforeLastFix, Boolean readyToFly, int missleAmount, String missleType, String cameraType) {
        super(pilotName, aerialVehicleMission, flightTimeBeforeLastFix, readyToFly, missleAmount, missleType);
        this.cameraType = cameraType;
    }

    @Override
    public String preformBda() {
        return MessageFormat.format(("{0}: {1} taking pictures of {2} with: {3}"),
                super.getPilotName(), this.getClass().getName(),
                ((BdaMission) this.getAerialVehicleMission()).getObjective(), this.cameraType);
    }

    @Override
    public void setAerialVehicleMission(Mission aerialVehicleMission) throws MissionTypeException {
        if (aerialVehicleMission instanceof AttackMission || aerialVehicleMission instanceof BdaMission) {
            super.setAerialVehicleMission(aerialVehicleMission);
        } else {
            throw new MissionTypeException("Cant take this type of mission");
        }

    }
}
