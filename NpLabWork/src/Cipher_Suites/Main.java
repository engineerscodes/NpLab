/**
 * 
 */
package Cipher_Suites;

/**
 * @author M.NAVEEN
 * RANDOM CODER'S
 *
 */
import javax.net.ssl.SSLContext;
import java.security.NoSuchAlgorithmException;

public class Main {

    public static void main(String[] args) {

        System.out.println("Supported Cipher Suites:");

        try {
            String[] ciphers = SSLContext.getDefault().getSocketFactory().getSupportedCipherSuites();
            for (int i = 1; i < ciphers.length; i++) {
                System.out.println(" " + i + ". " + ciphers[i]);
            }
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Failed to get default SSL context.");
        }
    }
}