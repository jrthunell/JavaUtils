import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class IO {

    /**
     * Writes the given string to the specified file.
     * @param filename The path of the file to write to, relative to the currenct directory
     * @param fileContents The string to write to the file
     * @throws IOException Thrown if the file can't be written
     */
    public static void writeFile(String filename, String fileContents) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        writer.write(fileContents);
        writer.close();
    }

    /**
     * Reads the contents of the specified file to a string, and returns that string.
     * @param filename The path of the file to read, relative to the current directory
     * @return The contents of the file
     * @throws IOException If the file can't be found or can't be opened
     */
    public static String readFile(String filename) throws IOException{
        byte[] bytes = Files.readAllBytes(Paths.get(filename));
        return new String(bytes);
    }

    /**
     * Encrypts the fileContents string using AES encryption, with the given password as key, and writes the encrypted
     * text to the specified file.
     * @param filename The path of the file to write to
     * @param fileContents The string to encrypt and write to the file
     * @param password The password to encrypt the file contents with
     * @throws IOException If the file can't be opened or written to
     * @throws RuntimeException If an error occurs during encryption
     */
    public static void writeEncryptedFile(String filename, String fileContents, String password) throws IOException {
        String encryptedString = Crypto.encrypt(fileContents, password);
        writeFile(filename, encryptedString);
    }

    /**
     * Reads and decrypts the contents of the given file and returns the decrypted text as a String. Only works on files
     * encrypted with writeEncryptedFile (or strings encrypted with Crypto.encrypt).
     * @param filename The path of the file to write to
     * @param password The password to decrypt the file contents with
     * @return The decrypted contents of the file, or null if the password is incorrect or another error occurs during encryption.
     * @throws IOException If the file can't be found or opened
     */
    public static String readEncryptedFile(String filename, String password) throws IOException {
        String encryptedString = readFile(filename);
        return Crypto.decrypt(encryptedString, password);
    }
}
