import AerialVehicles.FighterJets.F15;
import AerialVehicles.FighterJets.F16;
import AerialVehicles.UAVs.Haron.Eitan;
import AerialVehicles.UAVs.Haron.Shoval;
import AerialVehicles.UAVs.Hermes.Kochav;
import AerialVehicles.UAVs.Hermes.Zik;
import Entities.Coordinates;
import Missions.AttackMission;
import Missions.BdaMission;
import Missions.IntelligenceMission;
import Missions.MissionTypeException;
import org.junit.Test;

import static org.junit.Assert.*;

public class testF16 {
    Coordinates coordinatesToAttack = new Coordinates(31.389906, 34.330190);
    AttackMission attackMission = new AttackMission("suspect house", coordinatesToAttack);
    BdaMission bdaMission = new BdaMission("suspect house", coordinatesToAttack);
    IntelligenceMission intelligenceMission = new IntelligenceMission("Deir al Balah", coordinatesToAttack);
    private F16 f16 = new F16("thermal", 2, "Spice250", "Tuli", attackMission, 5, true);

    @Test
    public void testAttack(){
        String expectedMessage = "Tuli: F16 Attacking suspect house with: Spice250X2";
        String message = f16.attack();
        assertEquals(message,expectedMessage);
    }

    @Test
    public void testBda() throws MissionTypeException {
        f16.setMission(bdaMission);
        String expectedMessage = "Tuli: F16 taking pictures of suspect house with: thermal camera";
        String message = f16.preformBda();
        assertEquals(message,expectedMessage);
    }

    @Test
    public void testIntelligenceNotImplemented(){
        try{
            F16.class.getMethod("collectIntelligence", (Class<?>[]) null);
            fail();
        } catch (NoSuchMethodException | SecurityException e) {
            assertTrue(true);
        }
    }
}
