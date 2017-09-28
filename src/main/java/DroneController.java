public class DroneController {
    private Drone drone;

    public DroneController() {
        this.drone = new Drone();
    }

    public Drone getDrone() {
        return drone;
    }

    public void instructDrone(String input) {
        String[] instructions = input.split("");
        for (String instruction :
                instructions) {
            switch (instruction) {
                case "A":
                    drone.move();
                    break;
                case "D":
                    drone.turnRight();
                    break;
                case "I":
                    drone.turnLeft();
                    break;
            }
        }
    }
}
