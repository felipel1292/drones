public class Drone {
    private int[] position;
    private Direction direction;

    Drone(){
        position = new int[] {0,0};
        direction = Direction.North;
    }

    public int[] getPosition() {
        return position;
    }

    public void setPosition(int[] position) {
        this.position = position;
    }


    public void move() {
        switch (direction) {
            case North:
                position[1] += 1;
                break;
            case West:
                position[0] -= 1;
                break;
            case South:
                position[1] -= 1;
                break;
            case East:
                position[0] += 1;
                break;
        }
    }

    public void turnLeft() {
        switch (direction) {
            case North:
                direction = Direction.West;
                break;
            case West:
                direction = Direction.South;
                break;
            case South:
                direction = Direction.East;
                break;
            case East:
                direction = Direction.North;
                break;
        }
    }

    public void turnRight() {
        switch (direction) {
            case North:
                direction = Direction.East;
                break;
            case West:
                direction = Direction.North;
                break;
            case South:
                direction = Direction.West;
                break;
            case East:
                direction = Direction.South;
                break;
        }
    }

    public Direction getDirection() {
        return direction;
    }

    public String getStringPositionDirection() {
        return "("+position[0]+","+position[1]+") dirección "+direction.getSpanish();
    }
}
