import io.reactivex.Observable;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class InputReaderTest {
    InputReader inputReader;
    File file;

    @BeforeEach
    void setUp() throws IOException {
        file = File.createTempFile( "tmpin", "txt");

        FileOutputStream fop=new FileOutputStream(file,true);
        fop.write("AAAAIAAD".getBytes());
        fop.write("\nDDAIAD".getBytes());
        fop.write("\nAAIADAD".getBytes());
        fop.flush();
        fop.close();

        inputReader = new InputReader(file);
    }

    @AfterEach
    void exit() {
        file.delete();
    }

    @Test
    @DisplayName("Should create an instance of InputReader")
    public void createInstance() throws Exception {
        assertNotNull(inputReader);
    }

    @Test
    public void firstLine() {
        final Observable<String> observable = Observable.defer(() -> new InputReader(file));
        observable.subscribe(
                line -> {
                    assertEquals(line, "AAAAIAAD");
                },
                Throwable::printStackTrace,
                () -> System.out.println("finished")
        );
    }
}