import AerialVehicles.UAVs.Haron.Shoval;
import AerialVehicles.UAVs.Hermes.Kochav;
import Entities.Coordinates;
import Missions.AttackMission;
import Missions.BdaMission;
import Missions.IntelligenceMission;
import Missions.MissionTypeException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class testKochav {
    Coordinates coordinatesToAttack = new Coordinates(31.389906, 34.330190);
    AttackMission attackMission = new AttackMission("suspect house", coordinatesToAttack);
    BdaMission bdaMission = new BdaMission("suspect house", coordinatesToAttack);
    IntelligenceMission intelligenceMission = new IntelligenceMission("Deir al Balah", coordinatesToAttack);
    private Kochav kochav = new Kochav(3, "Dlila", "thermal", "commint", "Snoop", attackMission, 31, true);

    @Test
    public void testAttack() throws MissionTypeException {
        kochav.setMission(attackMission);
        String expectedMessage = "Snoop: Kochav Attacking suspect house with: DlilaX3";
        String message = kochav.attack();
        assertEquals(message, expectedMessage);
    }

    @Test
    public void testCollectIntelligence() throws MissionTypeException {
        kochav.setMission(intelligenceMission);
        String expectedMessage = "Snoop: Kochav Collecting Data in Deir al Balah with sensor type: commint";
        String message = kochav.collectIntelligence();
        assertEquals(message,expectedMessage);
    }

    @Test
    public void testBda() throws MissionTypeException {
        kochav.setMission(bdaMission);
        String expectedMessage = "Snoop: Kochav taking pictures of suspect house with: thermal camera";
        String message = kochav.preformBda();
        assertEquals(message,expectedMessage);
    }

    @Test
    public void testRepairZik(){
        kochav.setHoursOfFlightSinceLastRepair(75);
        kochav.check();
        assertEquals(kochav.getHoursOfFlightSinceLastRepair(),75);
        kochav.setHoursOfFlightSinceLastRepair(102);
        kochav.check();
        assertEquals(kochav.getHoursOfFlightSinceLastRepair(),0);
    }
}
