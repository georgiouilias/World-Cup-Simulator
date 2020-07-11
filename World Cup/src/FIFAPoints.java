import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FIFAPoints {
	public static void setPoints(int id, int important, double resultH, double resultA) {


			String q1 = "SELECT * FROM schedule WHERE Match_ID= " + id;
			String h = "SELECT * FROM fifaranking WHERE Name=?";
			String a = "SELECT * FROM fifaranking WHERE Name=?";
			String u = "UPDATE `fifaranking` SET `Points` = ? WHERE `fifaranking`.`Name` = ?";

			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = null;
				conn = DriverManager.getConnection("jdbc:mysql://localhost/worldcup", "root", "");
				// System.out.print("Database is connected !");
				PreparedStatement pst1 = conn.prepareStatement(q1);
				ResultSet rs1 = pst1.executeQuery();

				PreparedStatement psth = conn.prepareStatement(h);
				PreparedStatement psta = conn.prepareStatement(a);

				PreparedStatement up = conn.prepareStatement(u);

				while (rs1.next()) {

					System.out.println();
					System.out.println("Match: " + id);
					System.out.println(rs1.getString(2) + " vs " + rs1.getString(3));

					psth.setString(1, rs1.getString(2));
					ResultSet hrs = psth.executeQuery();

					psta.setString(1, rs1.getString(3));
					ResultSet ars = psta.executeQuery();

					while (hrs.next()) {
						while (ars.next()) {

							double pointsbH = hrs.getInt(4);
							double pointsbA = ars.getInt(4);

							double expectedrH = 1 / (Math.pow(10, -(pointsbH - pointsbA) / 600) + 1);
							double expectedrA = 1 / (Math.pow(10, -(pointsbA - pointsbH) / 600) + 1);

							pointsbH = (int) Math.round(pointsbH + (important * (resultH - expectedrH)));
							pointsbA = (int) Math.round(pointsbA + (important * (resultA - expectedrA)));

							System.out.println("New points for " + hrs.getString(2) + ": " + pointsbH);
							System.out.println("New points for " + ars.getString(2) + ": " + pointsbA);

							// up.setDouble(1, pointsbH); //home update
							// up.setString(2, hrs.getString(2));
							// up.executeUpdate();

							// up.setDouble(1, pointsbA); //away update
							// up.setString(2, hrs.getString(2));
							// up.executeUpdate();

						}
					}
				}
				conn.close();
			} catch (Exception e) {
				System.out.print("Do not connect to DB - Error:" + e);
			}
		}
	}
}