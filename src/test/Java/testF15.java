import AerialVehicles.FighterJets.F15;
import AerialVehicles.FighterJets.F16;
import Entities.Coordinates;
import Missions.AttackMission;
import Missions.BdaMission;
import Missions.IntelligenceMission;
import Missions.MissionTypeException;
import org.junit.Test;

import static org.junit.Assert.*;

public class testF15 {
    Coordinates coordinatesToAttack = new Coordinates(31.389906, 34.330190);
    AttackMission attackMission = new AttackMission("suspect house", coordinatesToAttack);
    BdaMission bdaMission = new BdaMission("suspect house", coordinatesToAttack);
    IntelligenceMission intelligenceMission = new IntelligenceMission("Deir al Balah", coordinatesToAttack);
    private F15 f15 = new F15("elint", 2, "Spice250", "Donald Duck", attackMission, 10, true);

    @Test
    public void testAttack(){
        String expectedMessage = "Donald Duck: F15 Attacking suspect house with: Spice250X2";
        String message = f15.attack();
        assertEquals(message,expectedMessage);
    }

    @Test
    public void testCollectIntelligence() throws MissionTypeException {
        f15.setMission(intelligenceMission);
        String expectedMessage = "Donald Duck: F15 Collecting Data in Deir al Balah with sensor type: elint";
        String message = f15.collectIntelligence();
        assertEquals(message,expectedMessage);
    }

    @Test
    public void testBdaNotImplemented(){
        try{
            F15.class.getMethod("preformBda", (Class<?>[]) null);
            fail();
        } catch (NoSuchMethodException | SecurityException e) {
            assertTrue(true);
        }
    }
}
