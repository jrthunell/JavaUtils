import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class CryptoTest {

    @Test
    void encryptAndDecryptTest() {
        String str = "abc";
        String password = "myPassword123";
        String encStr = Crypto.encrypt(str, password);

        assertNotEquals(str, Crypto.decrypt(encStr, "notMyPassword")); // wrong password
        assertNotEquals(str, encStr); // str and encStr not equal
        assertEquals(str, Crypto.decrypt(encStr, password));

        final int NUM_TESTS = 10;
        final String filename = "test.txt";
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
            encStr = Crypto.encrypt(str, password);
            assertNotEquals(str, Crypto.decrypt(encStr, "notMyPassword")); // wrong password
            assertNotEquals(str, encStr); // str and encStr not equal
            assertEquals(str, Crypto.decrypt(encStr, password));
        }
    }
}