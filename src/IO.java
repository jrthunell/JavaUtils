import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class IO {

    public static void writeFile(String filename, String fileContents) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        writer.write(fileContents);
        writer.close();
    }

    public static String readFileToString(String filename) throws IOException{
        byte[] bytes = Files.readAllBytes(Paths.get(filename));
        return new String(bytes);
    }
}
