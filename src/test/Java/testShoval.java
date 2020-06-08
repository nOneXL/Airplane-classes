import AerialVehicles.Shoval;
import Entities.Coordinates;
import Missions.AttackMission;
import Missions.BdaMission;
import Missions.IntelligenceMission;
import Missions.MissionTypeException;
import org.junit.Test;

import static org.junit.Assert.*;

public class testShoval {
    Coordinates coordinatesToAttack = new Coordinates(31.389906, 34.330190);
    AttackMission attackMission = new AttackMission("suspect house", coordinatesToAttack);
    BdaMission bdaMission = new BdaMission("suspect house", coordinatesToAttack);
    IntelligenceMission intelligenceMission = new IntelligenceMission("Deir al Balah", coordinatesToAttack);
    private Shoval shoval = new Shoval("Lagertha", bdaMission, 41, true, "commint", 2, "Spice250", "B&W");

    @Test
    public void testAttack() throws MissionTypeException {
        shoval.setAerialVehicleMission(attackMission);
        String expectedMessage = "Lagertha: Shoval Attacking suspect house with: Spice250X2";
        String message = shoval.attack();
        assertEquals(message, expectedMessage);
    }

    @Test
    public void testCollectIntelligence() throws MissionTypeException {
        shoval.setAerialVehicleMission(intelligenceMission);
        String expectedMessage = "Lagertha: Shoval Collecting Data in Deir al Balah with sensor type: commint";
        String message = shoval.collectIntelligence();
        assertEquals(message,expectedMessage);
    }

    @Test
    public void testBda() throws MissionTypeException {
        shoval.setAerialVehicleMission(bdaMission);
        String expectedMessage = "Lagertha: Shoval taking pictures of suspect house with: B&W camera";
        String message = shoval.preformBda();
        assertEquals(message,expectedMessage);
    }

    @Test
    public void testRepairShoval(){
        shoval.setFlightTimeBeforeLastFix(125);
        shoval.check();
        assertEquals(shoval.getFlightTimeBeforeLastFix(),125);
        shoval.setFlightTimeBeforeLastFix(155);
        shoval.check();
        assertEquals(shoval.getFlightTimeBeforeLastFix(),0);
    }
}
