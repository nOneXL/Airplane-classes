import AerialVehicles.UAVs.Haron.Eitan;
import AerialVehicles.UAVs.Haron.Shoval;
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
    private Shoval shoval = new Shoval("B&W", 2, "Spice250", "commint", "Lagertha", bdaMission, 41, true);

    @Test
    public void testAttack() throws MissionTypeException {
        shoval.setMission(attackMission);
        String expectedMessage = "Lagertha: Shoval Attacking suspect house with: Spice250X2";
        String message = shoval.attack();
        assertEquals(message, expectedMessage);
    }

    @Test
    public void testCollectIntelligence() throws MissionTypeException {
        shoval.setMission(intelligenceMission);
        String expectedMessage = "Lagertha: Shoval Collecting Data in Deir al Balah with sensor type: commint";
        String message = shoval.collectIntelligence();
        assertEquals(message,expectedMessage);
    }

    @Test
    public void testBda() throws MissionTypeException {
        shoval.setMission(bdaMission);
        String expectedMessage = "Lagertha: Shoval taking pictures of suspect house with: B&W camera";
        String message = shoval.preformBda();
        assertEquals(message,expectedMessage);
    }

    @Test
    public void testRepairShoval(){
        shoval.setHoursOfFlightSinceLastRepair(125);
        shoval.check();
        assertEquals(shoval.getHoursOfFlightSinceLastRepair(),125);
        shoval.setHoursOfFlightSinceLastRepair(155);
        shoval.check();
        assertEquals(shoval.getHoursOfFlightSinceLastRepair(),0);
    }
}
