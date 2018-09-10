import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

public class Response {
  
  public Response(Proxy proxy, Request request, Client client) throws Exception {
    URL url;
    try {
      url = new URL(request.getURL());
      URLConnection uc = url.openConnection();
      BufferedReader br = new BufferedReader(new InputStreamReader(
          uc.getInputStream()));
      
      String inputLine;
      OutputStream outputStream = client.getOutputStream();
      PrintWriter printWriter = new PrintWriter(outputStream);
      
      while ((inputLine = br.readLine()) != null)      
        printWriter.print(inputLine);  
      
      br.close();
      printWriter.close();
      outputStream.close();
    } catch (Exception e) {
      throw new Exception("error in response: " + e);
    }
  }  
}
