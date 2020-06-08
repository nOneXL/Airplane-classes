
import AerialVehicles.Eitan;
import Entities.Coordinates;
import Missions.AttackMission;
import Missions.BdaMission;
import Missions.IntelligenceMission;
import Missions.MissionTypeException;
import org.junit.Test;

import static org.junit.Assert.*;

public class testEitan {
    Coordinates coordinatesToAttack = new Coordinates(31.389906, 34.330190);
    AttackMission attackMission = new AttackMission("suspect house", coordinatesToAttack);
    BdaMission bdaMission = new BdaMission("suspect house", coordinatesToAttack);
    IntelligenceMission intelligenceMission = new IntelligenceMission("Deir al Balah", coordinatesToAttack);
    private Eitan eitan = new Eitan("Sheleg", attackMission, 52, true, "elint", 1, "nimrod");

    @Test
    public void testAttack(){
        String expectedMessage = "Sheleg: Eitan Attacking suspect house with: nimrodX1";
        String message = eitan.attack();
        assertEquals(message, expectedMessage);
    }

    @Test
    public void testCollectIntelligence() throws MissionTypeException {
        eitan.setAerialVehicleMission(intelligenceMission);
        String expectedMessage = "Sheleg: Eitan Collecting Data in Deir al Balah with sensor type: elint";
        String message = eitan.collectIntelligence();
        assertEquals(message,expectedMessage);
    }

    @Test
    public void testBdaNotImplemented(){
        try{
            Eitan.class.getMethod("preformBda", (Class<?>[]) null);
            fail();
        } catch (NoSuchMethodException | SecurityException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testRepairEitan(){
        eitan.setFlightTimeBeforeLastFix(125);
        eitan.check();
        assertEquals(eitan.getFlightTimeBeforeLastFix(),125);
        eitan.setFlightTimeBeforeLastFix(155);
        eitan.check();
        assertEquals(eitan.getFlightTimeBeforeLastFix(),0);
    }
}
