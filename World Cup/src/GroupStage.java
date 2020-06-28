import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// edo tha trexei to group stage tou tournoua
public class GroupStage {
	
	public void GroupA(){
		
		String home = "SELECT * FROM `group a`";
		String away = "SELECT * FROM `group a`";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = null;
			conn = DriverManager.getConnection("jdbc:mysql://localhost/worldcup", "root", "");
			// System.out.print("Database is connected !");
			PreparedStatement hpst = conn.prepareStatement(home);
			ResultSet hrs = hpst.executeQuery();

			while (hrs.next()) {
				
			}

			conn.close();
		} catch (Exception e) {
			System.out.print("Do not connect to DB - Error:" + e);
		}

		
	}
	
}
