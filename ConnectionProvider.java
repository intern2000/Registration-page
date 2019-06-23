package login.submit.register;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider implements MyProvider {

  static Connection con = null;
  
  public static Connection getCon() {
	  try {
		  Class.forName("org.postgresql.Driver");
		  con = DriverManager.getConnection(connectionURL,username, password);
		  System.out.println("connected1");
	  } catch(Exception e) {
		  System.out.println(e); 
	  }
	  
	  return con;
  }
  
}
 