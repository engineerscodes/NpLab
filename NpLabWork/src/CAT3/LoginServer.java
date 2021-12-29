/**
 * 
 */
package CAT3;

/**
 * @author M.NAVEEN
 * RANDOM CODER'S
 *
 */
import java.io.*;

//Java extension packages
import javax.net.ssl.*;

public class LoginServer {
private static final String CORRECT_USER_NAME = "VIT";
private static final String CORRECT_PASSWORD = "VIT-AP";
private SSLServerSocket serverSocket;

// LoginServer constructor
public LoginServer() throws Exception
{       
   // SSLServerSocketFactory for building SSLServerSockets
   SSLServerSocketFactory socketFactory = 
      ( SSLServerSocketFactory ) 
         SSLServerSocketFactory.getDefault(); 
    // create SSLServerSocket on specified port
   serverSocket = ( SSLServerSocket ) 
      socketFactory.createServerSocket( 443 );   
   
} // end LoginServer constructor   
private void runServer()
{
   // perpetually listen for clients
   while ( true ) {
      // wait for client connection and check login information
      try {
            System.err.println( "Waiting for connection..." );
             // create new SSLSocket for client
            SSLSocket socket =  ( SSLSocket ) serverSocket.accept();
           // open BufferedReader for reading data from client
           BufferedReader input = new BufferedReader( 
              new InputStreamReader( socket.getInputStream() ) );
           // open PrintWriter for writing data to client
          PrintWriter output = new PrintWriter( 
            new OutputStreamWriter(socket.getOutputStream() ) );
          String userName = input.readLine();
          String password = input.readLine();
           if ( userName.equals( CORRECT_USER_NAME ) && 
              password.equals( CORRECT_PASSWORD ) ) {
            output.println( "Welcome, " + userName );
         }
         else {
            output.println( "Login Failed." );
         }         
         output.close();
         input.close();
         //socket.close();
         
      } // end try
      
      // handle exception communicating with client
      catch ( IOException ioException ) {
         ioException.printStackTrace();
      }
      
   } // end while      

} // end method runServer

// execute application
public static void main( String args[] ) throws Exception
{
   LoginServer server = new LoginServer();
   server.runServer();
}
} //end LoginServer class

