import io.reactivex.Observable;

import java.io.File;

public class App {
    public static void main(String[] args) {
        DroneController droneController = new DroneController();
        File file = new File(droneController.getClass().getResource("in.txt").getPath());
        final Observable<String> observable = Observable.defer(() -> new InputReader(file));

        observable.subscribe(
                line -> {
                    droneController.instructDrone(line);
                    System.out.println(droneController.getDrone().getStringPositionDirection());
                },
                Throwable::printStackTrace/*,
                () -> System.out.println(droneController.getDrone().getStringPositionDirection())*/
        );
    }
}
