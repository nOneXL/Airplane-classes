package AerialVehicles;

import Missions.AttackMission;
import Missions.Mission;

import java.text.MessageFormat;

public abstract class FighterAircraft extends AerialVehicle implements AerialAttackVehicle {
    private final int HoursLimitToBeFixed = 250;
    private int missleAmount;
    private String missleType;

    public FighterAircraft(String pilotName, Mission aerialVehicleMission, int flightTimeBeforeLastFix, Boolean readyToFly, int missleAmount, String missleType) {
        super(pilotName, aerialVehicleMission, flightTimeBeforeLastFix, readyToFly);
        this.missleAmount = missleAmount;
        this.missleType = missleType;
    }

    @Override
    public void check() {
        if (super.getFlightTimeBeforeLastFix() >= this.HoursLimitToBeFixed) {
            super.repair();
        }
    }

    @Override
    public String attack() {
        return MessageFormat.format(("{0}: {1} Attacking {2} with: {3}X{4}"),
                super.getPilotName(), this.getClass().getSimpleName(),
                ((AttackMission) this.getAerialVehicleMission()).getTarget(), this.missleType, this.missleAmount);
    }

    public int getMissleAmount() {
        return missleAmount;
    }

    public void setMissleAmount(int missleAmount) {
        this.missleAmount = missleAmount;
    }

    public String getMissleType() {
        return missleType;
    }

    public void setMissleType(String missleType) {
        this.missleType = missleType;
    }
}
