import java.net.Socket;

public class Main {

  public static void main(String[] args) throws Exception {
    Proxy proxy = new Proxy(Integer.parseInt(args[0]));
    
    while (true) {
      try {
        Socket socket = proxy.accept();
        Client client = new Client(socket);
        
        while (client.isOpen()) {
          Connection.connection(proxy, client);
        }
      } catch (Exception e) {
        System.out.println(e);
      }
    }
  }
}
