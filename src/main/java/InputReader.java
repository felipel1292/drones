import io.reactivex.ObservableSource;
import io.reactivex.Observer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

class InputReader implements ObservableSource<String> {

    File file;

    InputReader(File file) {
        this.file = file;
    }

    @Override
    public void subscribe(Observer<? super String> observer) {
        try {
            Files.lines(file.toPath()).forEach(observer::onNext);
            observer.onComplete();
        } catch (IOException e) {
            observer.onError(e);
        }
    }
}
