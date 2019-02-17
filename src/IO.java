import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class IO {

    public static void writeFile(String filename, String fileContents) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        writer.write(fileContents);
        writer.close();
    }
}
