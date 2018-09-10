import java.net.ServerSocket;
import java.net.Socket;

public class Proxy {
  private ServerSocket ss;
  
  public Proxy(int port) throws Exception {
    try {
      ss = new ServerSocket(port);
    }catch(Exception e) {
      System.out.println("Proxy Error: " + e);
    }
  }
   
  public Socket accept() throws Exception {
    return ss.accept();
  }
  
}
