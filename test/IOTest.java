import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class IOTest {

    @Test
    void writeFileTest() throws IOException {
        final int NUM_TESTS = 100;
        final String filename = "test.txt";
        IO.writeFile(filename, "");
        String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

        for(int i = 0; i < NUM_TESTS; i++) {
            // make a random string
            StringBuilder strb = new StringBuilder();
            Random rnd = new Random();
            while (strb.length() < 100) { // length of the random string.
                int index = (int) (rnd.nextFloat() * CHARS.length());
                strb.append(CHARS.charAt(index));
            }
            String str = strb.toString();

            // write the string to a file
            IO.writeFile(filename, str);

            // read the file and check if the string is written
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            assertEquals(str, line);
            reader.close();
        }


        // delete the file
        File file = new File(filename);
        file.delete();
    }

    @Test
    void readFileTest() throws IOException {
        final int NUM_TESTS = 100;
        final String filename = "test.txt";
        IO.writeFile(filename, "");
        String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

        for(int i = 0; i < NUM_TESTS; i++) {
            // make a random string
            StringBuilder strb = new StringBuilder();
            Random rnd = new Random();
            while (strb.length() < 100) { // length of the random string.
                int index = (int) (rnd.nextFloat() * CHARS.length());
                strb.append(CHARS.charAt(index));
            }
            String str = strb.toString();

            // write the string to a file
            IO.writeFile(filename, str);

            // read the file and check if the string is written
            String result = IO.readFile(filename);
            assertEquals(str, result);
        }


        // delete the file
        File file = new File(filename);
        file.delete();
    }

    @Test
    void writeEncryptedFile() throws IOException {
        final int NUM_TESTS = 10;
        final String filename = "test.txt";
        String password;
        String str = "myPassword";
        String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

        for(int i = 0; i < NUM_TESTS; i++) {
            // make a random string
            StringBuilder strb = new StringBuilder();
            Random rnd = new Random();
            while (strb.length() < 100) { // length of the random string.
                int index = (int) (rnd.nextFloat() * CHARS.length());
                strb.append(CHARS.charAt(index));
            }
            password = str;
            str = strb.toString();

            // write the string to a file
            IO.writeEncryptedFile(filename, str, password);

            // read the file and check if the string is written
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String fileContents = reader.readLine();
            String decrypted = Crypto.decrypt(fileContents, password);
            assertEquals(str, decrypted);
            reader.close();
        }

        // delete the file
        File file = new File(filename);
        file.delete();
    }

    @Test
    void readEncryptedFile() throws IOException {
        final int NUM_TESTS = 10;
        final String filename = "test.txt";
        String str = "myString";
        String password = str;
        String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

        for(int i = 0; i < NUM_TESTS; i++) {
            // make a random string
            StringBuilder strb = new StringBuilder();
            Random rnd = new Random();
            while (strb.length() < 100) { // length of the random string.
                int index = (int) (rnd.nextFloat() * CHARS.length());
                strb.append(CHARS.charAt(index));
            }
            password = str;
            str = strb.toString();

            // write the string to a file
            IO.writeEncryptedFile(filename, str, password);

            // read the file and check if the string is written
            String result = IO.readEncryptedFile(filename, password);
            assertEquals(str, result);
        }

        // delete the file
        File file = new File(filename);
        file.delete();
    }
}