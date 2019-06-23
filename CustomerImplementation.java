package login.submit.register;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CustomerImplementation implements ICustomer {
	
	static Connection con;
	static PreparedStatement ps;

	//Method to insert a customer into the databse 
	@Override
	public int insertCustomer(Customer customer) {
		
		int status = 0;
		try {
			
			con = ConnectionProvider.getCon(); //Starts connection
			System.out.println("connected28");
			 
			//Sets up database: layout, and picks data to be stores
			ps = con.prepareStatement("insert into customer values(?,?)"); //SQL request
			ps.setString(1, customer.getName());
			ps.setString(2, customer.getUsername());
			ps.setString(3, customer.getPassword());
			
			status = ps.executeUpdate(); //Executes the insertion i.e. the client's request
			con.close(); //Closes connection 
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		return status;

	}

	@Override
	public Customer getCustomer(String name, String username, String password) {
		
		Customer c = new Customer();
		
		try {
			
			con = ConnectionProvider.getCon(); // Sets up connection
			ps = con.prepareStatement("select * from customer where username=? and password=?"); //SQL query
			
			//Database set up
			ps.setString(1, name);
			ps.setString(2, username);
			ps.setString(3, password);
			
			ResultSet rs = ps.executeQuery(); //Executes query
			
			while (rs.next()) {
				c.setName(rs.getString(1));
				c.setUsername(rs.getString(2));
				c.setPassword(rs.getString(3));
			}
			
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		
		return c;
	}

}
