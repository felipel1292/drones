import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DroneControllerTest {
    DroneController droneController;

    @BeforeEach
    void setUp() {
        droneController = new DroneController();
    }

    @Test
    @DisplayName("Should create an instance of DroneController")
    public void createInstance() throws Exception {
        assertNotNull(droneController);
    }

    @Test
    @DisplayName("DroneController should have a drone instance")
    public void getDroneInstance() throws Exception {
        assertNotNull(droneController.getDrone());
    }

    @Test
    @DisplayName("DroneController should change drone position using an input String")
    public void moveDroneUp() throws Exception {
        droneController.instructDrone("A");
        assertArrayEquals(droneController.getDrone().getPosition(), new int[]{1, 0});
    }

    @Test
    @DisplayName("DroneController should change drone direction using an input String")
    public void orderDroneTurnLeft() throws Exception {
        droneController.instructDrone("I");
        assertEquals(droneController.getDrone().getDirection(), Direction.West);
    }

    @Test
    @DisplayName("DroneController should change drone direction and move using an input String")
    public void orderDroneTurnLeftMove() throws Exception {
        droneController.instructDrone("IA");
        assertAll(
                () -> assertEquals(droneController.getDrone().getDirection(), Direction.West),
                () -> assertArrayEquals(droneController.getDrone().getPosition(), new int[]{0, -1})
        );
    }

}