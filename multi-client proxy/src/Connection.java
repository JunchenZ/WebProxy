
public class Connection {
  public static void connection(Proxy proxy, Client client) throws Exception {
    boolean success = true;
    Request request = new Request(client, success);
    if(success) {
      new Response(proxy, request, client);
    }
  }
}
