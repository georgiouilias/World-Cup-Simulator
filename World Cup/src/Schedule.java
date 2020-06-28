import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//programma tournoua
public class Schedule {

	public static void GroupA() {
		int home = 1;
		int away = 2;

		String hquerry = "SELECT Position, Team FROM `group a` WHERE Position = '" + home + "'";
		String aquerry = "SELECT Position, Team FROM `group a` WHERE Position = '" + away + "'";
		String insert = "INSERT INTO schedule (Match_ID, Home, Away, HScore, AScore) " + "VALUES (?, ?, ?, 0, 0)";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = null;
			conn = DriverManager.getConnection("jdbc:mysql://localhost/worldcup", "root", "");
			// System.out.print("Database is connected !");
			PreparedStatement hpst = conn.prepareStatement(hquerry);
			ResultSet hrs = hpst.executeQuery();

			PreparedStatement apst = conn.prepareStatement(aquerry);
			ResultSet ars = apst.executeQuery();

			PreparedStatement insrt = conn.prepareStatement(insert);

			while (hrs.next()) {
				while (ars.next()) { //thelei na ginei sosto insert me olous tous agones
					insrt.setInt(1, 101);
					insrt.setString(2, hrs.getString(2));
					insrt.setString(3, ars.getString(2));
					insrt.execute();	
				}
			}
			conn.close();
		} catch (Exception e) {
			System.out.print("Do not connect to DB - Error:" + e);
		}

	}

	public static void ShowSchedule() {

		String query = "SELECT * FROM schedule";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = null;
			conn = DriverManager.getConnection("jdbc:mysql://localhost/worldcup", "root", "");
			// System.out.print("Database is connected !");
			PreparedStatement pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			System.out.printf("%2s %15s %15s %6s %6s\n", " ID|", "HOME|", "AWAY|", "HSCORE|", "ASCORE|");

			while (rs.next()) {
				System.out.printf("%2d %15s %15s %7d %7d\n", rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
			}
			System.out.println();
			conn.close();
		} catch (Exception e) {
			System.out.print("Do not connect to DB - Error:" + e);
		}
	}

}
