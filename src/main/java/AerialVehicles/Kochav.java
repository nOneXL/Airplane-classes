package AerialVehicles;

import Missions.AttackMission;
import Missions.Mission;
import Missions.MissionTypeException;

import java.text.MessageFormat;

public class Kochav extends HermesVehicle implements AerialAttackVehicle {
    private int missleAmount;
    private String missleType;

    public Kochav(String pilotName, Mission aerialVehicleMission, int flightTimeBeforeLastFix, Boolean readyToFly, String sensorType, String cameraType, int missleAmount, String missleType) {
        super(pilotName, aerialVehicleMission, flightTimeBeforeLastFix, readyToFly, sensorType, cameraType);
        this.missleAmount = missleAmount;
        this.missleType = missleType;
    }

    @Override
    public String attack() {
        return MessageFormat.format(("{0}: {1} Attacking {2} with: {3}X{4}"),
                super.getPilotName(), this.getClass().getSimpleName(),
                ((AttackMission) this.getAerialVehicleMission()).getTarget(), this.missleType, this.missleAmount);
    }
}
