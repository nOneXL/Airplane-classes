import AerialVehicles.Zik;
import Entities.Coordinates;
import Missions.AttackMission;
import Missions.BdaMission;
import Missions.IntelligenceMission;
import Missions.MissionTypeException;
import org.junit.Test;

import static org.junit.Assert.*;

public class testZik {
    Coordinates coordinatesToAttack = new Coordinates(31.389906, 34.330190);
    AttackMission attackMission = new AttackMission("suspect house", coordinatesToAttack);
    BdaMission bdaMission = new BdaMission("suspect house", coordinatesToAttack);
    IntelligenceMission intelligenceMission = new IntelligenceMission("Deir al Balah", coordinatesToAttack);
    private Zik zik = new Zik("Fireman Sam", bdaMission, 14, true, "elint", "thermal");

    @Test
    public void testAttackImplementedInZik() throws MissionTypeException {
        try{
            Zik.class.getMethod("attack", (Class<?>[]) null);
            fail();
        } catch (NoSuchMethodException | SecurityException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testCollectIntelligence() throws MissionTypeException {
        zik.setAerialVehicleMission(intelligenceMission);
        String expectedMessage = "Fireman Sam: Zik Collecting Data in Deir al Balah with sensor type: elint";
        String message = zik.collectIntelligence();
        assertEquals(message,expectedMessage);
    }

    @Test
    public void testBda() throws MissionTypeException {
        zik.setAerialVehicleMission(bdaMission);
        String expectedMessage = "Fireman Sam: Zik taking pictures of suspect house with: thermal camera";
        String message = zik.preformBda();
        assertEquals(message,expectedMessage);
    }

    @Test
    public void testRepairZik(){
        zik.setFlightTimeBeforeLastFix(75);
        zik.check();
        assertEquals(zik.getFlightTimeBeforeLastFix(),75);
        zik.setFlightTimeBeforeLastFix(102);
        zik.check();
        assertEquals(zik.getFlightTimeBeforeLastFix(),0);
    }
}
