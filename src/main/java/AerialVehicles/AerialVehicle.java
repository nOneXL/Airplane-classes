package AerialVehicles;

import Entities.Coordinates;
import Missions.Mission;
import Missions.MissionTypeException;


public abstract class AerialVehicle implements AerialVehicleService {
    private String pilotName;
    private Mission AerialVehicleMission;
    private int flightTimeBeforeLastFix;
    private Boolean readyToFly;

    public AerialVehicle(String pilotName, Mission aerialVehicleMission, int flightTimeBeforeLastFix, Boolean readyToFly) {
        this.pilotName = pilotName;
        AerialVehicleMission = aerialVehicleMission;
        this.flightTimeBeforeLastFix = flightTimeBeforeLastFix;
        this.readyToFly = readyToFly;
    }

    @Override
    public void flyTo() {
        System.out.println("Flying to: " + this.AerialVehicleMission.getMissionCoordinates().getLongitude() +
                                           this.AerialVehicleMission.getMissionCoordinates().getLatitude());
    }

    @Override
    public void land() {
        System.out.println("Landing");
    }

    @Override
    public void repair() {
        this.setReadyToFly(true);
        this.setFlightTimeBeforeLastFix(0);
    }

    public String getPilotName() {
        return pilotName;
    }

    public void setPilotName(String pilotName) throws MissionTypeException {
        this.pilotName = pilotName;
    }

    public Mission getAerialVehicleMission() {
        return AerialVehicleMission;
    }

    public void setAerialVehicleMission(Mission aerialVehicleMission) throws MissionTypeException {
        AerialVehicleMission = aerialVehicleMission;
    }

    public int getFlightTimeBeforeLastFix() {
        return flightTimeBeforeLastFix;
    }

    public void setFlightTimeBeforeLastFix(int flightTimeBeforeLastFix) {
        this.flightTimeBeforeLastFix = flightTimeBeforeLastFix;
    }

    public Boolean getReadyToFly() {
        return readyToFly;
    }

    public void setReadyToFly(Boolean readyToFly) {
        this.readyToFly = readyToFly;
    }


}
