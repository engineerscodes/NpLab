/**
 * 
 */
package CAT3;

/**
 * @author M.NAVEEN
 * RANDOM CODER'S
 *
 */
import javax.net.ssl.HandshakeCompletedEvent;
import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

class MyHandshakeListener implements HandshakeCompletedListener {
    public void handshakeCompleted(HandshakeCompletedEvent e) {
        System.out.println("Using cipher suite: " + e.getCipherSuite());
    }//  w   w  w  .   de  m    o 2   s  .c    o m 
}

public class Main {
    public static void main(String[] args) throws Exception {
        SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        SSLSocket socket = (SSLSocket) factory.createSocket("www.google.com", 443);
        String[] suites = socket.getSupportedCipherSuites();
        socket.setEnabledCipherSuites(suites);
        socket.addHandshakeCompletedListener(new MyHandshakeListener());
        socket.startHandshake();
        System.out.println("Just connected to " + socket.getRemoteSocketAddress());
    }
}
