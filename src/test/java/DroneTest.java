import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DroneTest {
    public Drone drone;

    @BeforeEach
    public void setUp() throws Exception {
        drone = new Drone();
    }

    @Test
    @DisplayName("Should create an instance of Drone")
    public void createInstance() throws Exception {
        assertNotNull(drone);
    }

    @Test
    @DisplayName("Should get the default drone position (0,0)")
    public void getInitialPosition() throws Exception {
        assertArrayEquals(drone.getPosition(), new int[]{0, 0});
    }

    @Test
    @DisplayName("Should set the drone position to (1,1)")
    public void setPosition() throws Exception {
        drone.setPosition(new int[]{1, 1});

        assertArrayEquals(drone.getPosition(), new int[]{1, 1});
    }

    @Test
    @DisplayName("Should move drone to position (0,0)")
    public void moveDrone() throws Exception {
        drone.move();
        assertArrayEquals(drone.getPosition(), new int[]{0, 1});
    }

    @Test
    @DisplayName("Should move drone twice to position (0,2)")
    public void moveDroneTwice() throws Exception {
        drone.move();
        drone.move();

        assertArrayEquals(drone.getPosition(), new int[]{0, 2});
    }

    @Test
    @DisplayName("Should turn drone left so direction should be West")
    public void turnLeftDrone() throws Exception {
        drone.turnLeft();

        assertEquals(drone.getDirection(), Direction.West);
    }

    @Test
    @DisplayName("Should turn drone left twice so direction should be South")
    public void turnLeftDroneTwice() throws Exception {
        drone.turnLeft();
        drone.turnLeft();

        assertEquals(drone.getDirection(), Direction.South);
    }

    @Test
    @DisplayName("Should turn drone left three times so direction should be East")
    public void turnLeftDroneThreeTimes() throws Exception {
        drone.turnLeft();
        drone.turnLeft();
        drone.turnLeft();

        assertEquals(drone.getDirection(), Direction.East);
    }

    @Test
    @DisplayName("Should turn drone left four times so direction should be North")
    public void turnLeftDroneFourTimes() throws Exception {
        drone.turnLeft();
        drone.turnLeft();
        drone.turnLeft();
        drone.turnLeft();

        assertEquals(drone.getDirection(), Direction.North);
    }

    @Test
    @DisplayName("Should turn drone right so direction should be East")
    public void turnRightDrone() throws Exception {
        drone.turnRight();
        assertEquals(drone.getDirection(), Direction.East);
    }

    @Test
    @DisplayName("Should turn drone right twice so direction should be South")
    public void turnRightDroneTwice() throws Exception {
        drone.turnRight();
        drone.turnRight();
        assertEquals(drone.getDirection(), Direction.South);
    }

    @Test
    @DisplayName("Should turn drone right four times so direction should be West")
    public void turnRightDroneThreeTimes() throws Exception {
        drone.turnRight();
        drone.turnRight();
        drone.turnRight();
        assertEquals(drone.getDirection(), Direction.West);
    }

    @Test
    @DisplayName("Should turn drone right four times so direction should be North")
    public void turnRightDroneFourTimes() throws Exception {
        drone.turnRight();
        drone.turnRight();
        drone.turnRight();
        drone.turnRight();
        assertEquals(drone.getDirection(), Direction.North);
    }

    @Test
    @DisplayName("Should turn drone right and move so position should be (1, 0) and direction should be East")
    public void turnRightAndMoveDrone() throws Exception {
        drone.turnRight();
        drone.move();
        assertAll(
                () -> assertEquals(drone.getDirection(), Direction.East),
                () -> assertArrayEquals(drone.getPosition(), new int[]{1, 0})
        );
    }

    @Test
    @DisplayName("Should turn drone left and move so position should be (-1, 0) and direction should be West")
    public void turnLeftAndMoveDrone() throws Exception {
        drone.turnLeft();
        drone.move();
        assertAll(
                () -> assertEquals(drone.getDirection(), Direction.West),
                () -> assertArrayEquals(drone.getPosition(), new int[]{-1, 0})
        );
    }

    @Test
    @DisplayName("Should turn drone left twice and move so position should be (0, -1) and direction should be South")
    public void turnLeftTwiceAndMoveDrone() throws Exception {
        drone.turnLeft();
        drone.turnLeft();
        drone.move();
        assertAll(
                () -> assertEquals(drone.getDirection(), Direction.South),
                () -> assertArrayEquals(drone.getPosition(), new int[]{0, -1})
        );
    }

    @Test
    @DisplayName("Should turn drone left twice and move so position should be (1, 0) and direction should be East")
    public void turnLeftThreeTimesAndMoveDrone() throws Exception {
        drone.turnLeft();
        drone.turnLeft();
        drone.turnLeft();
        drone.move();
        assertAll(
                () -> assertEquals(drone.getDirection(), Direction.East),
                () -> assertArrayEquals(drone.getPosition(), new int[]{1, 0})
        );
    }

    @Test
    @DisplayName("Should turn drone left twice and move so position should be (0, 1) and direction should be North")
    public void turnLeftFourTimesAndMoveDrone() throws Exception {
        drone.turnLeft();
        drone.turnLeft();
        drone.turnLeft();
        drone.turnLeft();
        drone.move();
        assertAll(
                () -> assertEquals(drone.getDirection(), Direction.North),
                () -> assertArrayEquals(drone.getPosition(), new int[]{0, 1})
        );
    }

    @Test
    @DisplayName("Should return string position and direction")
    public void getStringPositionDirection() throws Exception {
        assertEquals(drone.getStringPositionDirection(), "(0,0) dirección Norte");
    }

}