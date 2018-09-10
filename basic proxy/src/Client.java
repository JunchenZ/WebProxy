import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
  private Socket client;
  
  public Client(Socket socket) throws Exception {
    try{
      client = socket; 
    }catch(Exception e) {
      System.out.println("Client Error" + e);
    }
  }
  
  public InputStream getInputStream() throws Exception {
    return client.getInputStream();
  }
  
  public OutputStream getOutputStream() throws Exception {
    return client.getOutputStream();
  }
  
  public boolean isOpen() {
    return !client.isClosed();
  }
  
}
