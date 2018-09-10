import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Request {
  private String url;
  Scanner s;
  public Request(Client client, boolean b) throws Exception {
    try {
      InputStream is = client.getInputStream();
      s = new Scanner(is); 
      if(s.hasNextLine()) {
        String[] absURL = s.nextLine().split(" ");
        
        if(!absURL[0].equals("GET")) {
          PrintWriter printWriter = new PrintWriter(client.getOutputStream());
          printWriter.print("HTTP/1.0 501 Not Implemented" + "\r\n\r\n");
          printWriter.flush();
          printWriter.close();
          throw new Exception("error, http method should be 'GET'");
        }
        
        if(!absURL[1].substring(0, 7).equals("http://")) {
          System.out.println("the url was: " + absURL[1]);
          absURL[1] = "http://" + absURL[1] + "/"; 
        }
        
        url = absURL[1];
        if(!absURL[2].equals("HTTP/1.0")) {
          throw new Exception("error, http version should be 'HTTP/1.0'");
        }
        
      }else {
        b = false;
      }
           
    }catch(Exception e) {
      b = false;
      throw new Exception("error in request: " + e);
    }
  }
  
  public String getURL() {
    return url;
  }
  
  public void closeScanner() {
    s.close();
  }
}
