import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Reset {
	
	public static void Reset() {
		GroupsReset();
		//System.out.println("Group Table are empty");

	}

	public static void GroupsReset() {
		char groups[] = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h' };

		for (int i = 0; i < groups.length; i++) {

			String q = "TRUNCATE ` group " + groups[i] + "` ";

			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = null;
				conn = DriverManager.getConnection("jdbc:mysql://localhost/worldcup", "root", "");
				conn.setAutoCommit(false);

				PreparedStatement pst = conn.prepareStatement(q);
				pst.executeUpdate();
				
				System.out.println("Group " + groups[i] + " is empty!");
				
				conn.close();
			} catch (Exception e) {
				System.out.print("Do not connect to DB - Error:" + e);
			}

		}
	}
	
	public static void ScheduleReset() {

			String q = "TRUNCATE `schedule` ";
			String qq = "ALTER TABLE `schedule` AUTO_INCREMENT = 101";

			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = null;
				conn = DriverManager.getConnection("jdbc:mysql://localhost/worldcup", "root", "");
				conn.setAutoCommit(false);

				PreparedStatement pst = conn.prepareStatement(q);
				pst.executeUpdate();
				
				System.out.println("Schedule is empty!");
				
				PreparedStatement qpst = conn.prepareStatement(qq);
				qpst.execute();
				
				conn.close();
			} catch (Exception e) {
				System.out.print("Do not connect to DB - Error:" + e);
			}

		}
	
	public static void WolrdCupFinalReset() {

		String q = "TRUNCATE `worldcupfinal` ";
		String qq = "ALTER TABLE `worldcupfinal` AUTO_INCREMENT = 1";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = null;
			conn = DriverManager.getConnection("jdbc:mysql://localhost/worldcup", "root", "");
			conn.setAutoCommit(false);

			PreparedStatement pst = conn.prepareStatement(q);
			pst.executeUpdate();
			
			System.out.println("World Cup Final is empty!");
			
			PreparedStatement qpst = conn.prepareStatement(qq);
			qpst.execute();
			
			conn.close();
		} catch (Exception e) {
			System.out.print("Do not connect to DB - Error:" + e);
		}

	}


}
