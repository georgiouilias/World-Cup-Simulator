import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Checks {

	public static void isEmpty() {

		String query = "SELECT * FROM worldcupfinal";
		// to confederation

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = null;
			conn = DriverManager.getConnection("jdbc:mysql://localhost/worldcup", "root", "");

			PreparedStatement pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();

			if (rs.next() == false) {
				System.out.println("Teams are not inserted!");
			} else {
				Display.ShowTeams();
			}

			conn.close();
		} catch (Exception e) {
			System.out.print("Do not connect to DB - Error:" + e);
		}
	}
	
	public static void isFull() {

		String query = "SELECT * FROM worldcupfinal";
		// to confederation

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = null;
			conn = DriverManager.getConnection("jdbc:mysql://localhost/worldcup", "root", "");

			PreparedStatement pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();

			if (rs.next() == false) {
				Display.InsertTeams();
			} else {
				System.out.println("Teams are inserted!");
			}

			conn.close();
		} catch (Exception e) {
			System.out.print("Do not connect to DB - Error:" + e);
		}
	}

}