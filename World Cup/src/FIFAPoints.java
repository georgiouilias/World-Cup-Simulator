import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FIFAPoints {
	public static void GroupStagePoints() {
		
		double resultH = 0;
		double resultA = 0;

		for (int id = 101; id <= 102; id++) {

			String q1 = "SELECT * FROM schedule WHERE Match_ID= " + id;
			String h = "SELECT * FROM fifaranking2 WHERE Name=?";
			String a = "SELECT * FROM fifaranking2 WHERE Name=?";
			String u = "UPDATE `fifaranking2` SET `Points` = ? WHERE `fifaranking2`.`Name` = ?";

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
						System.out.println("Match: " +id);
						System.out.println(rs1.getString(2) + " vs " + rs1.getString(3));

						psth.setString(1, rs1.getString(2));
						ResultSet hrs = psth.executeQuery();

						psta.setString(1, rs1.getString(3));
						ResultSet ars = psta.executeQuery();

						while(hrs.next()) {
							while(ars.next()) {
							
							if(rs1.getInt(4)>rs1.getInt(5)) {
								System.out.println("Winner is:" + hrs.getString(2));
								resultH = 1;
								resultA = 0;
	
							}else if(rs1.getInt(4)==rs1.getInt(5)) {
								System.out.println("Draw");
								resultH = 0.5;
								resultA = 0.5;
								
							}else {
								System.out.println("Winner is:" + ars.getString(2));
								resultH = 0;
								resultA = 1;

							}
							
							double pointsbH = hrs.getInt(4);
							double pointsbA = ars.getInt(4);
							int important = 50;
							
							double expectedrH = 1 / (Math.pow(10, -(pointsbH - pointsbA) / 600) + 1);
							double expectedrA = 1 / (Math.pow(10, -(pointsbA - pointsbH) / 600) + 1);

							pointsbH = (int) Math.round(pointsbH + (important * (resultH - expectedrH)));
							pointsbA = (int) Math.round(pointsbA + (important * (resultA - expectedrA)));

							System.out.println("New points for " +hrs.getString(2)+ ": " + pointsbH);
							System.out.println("New points for " +ars.getString(2)+ ": " + pointsbA);



						//	up.setInt(1, rs2.getInt(4)+hp);
						//	up.setString(2, rs2.getString(2));
						//	up.executeUpdate();
						}
						}
					}				
				conn.close();
			} catch (Exception e) {
				System.out.print("Do not connect to DB - Error:" + e);
			}
		}

	}

	public static void setNewFIFAPoints() {
		// need the correct points here and it's ready
		int pointsbH = 0;
		int pointsbA = 0;
		int important = 0;
		int resultH = 0;
		int resultA = 0;
		
		double expectedrH = 1 / (Math.pow(10, -(pointsbH - pointsbA) / 600) + 1);
		double expectedrA = 1 / (Math.pow(10, -(pointsbA - pointsbH) / 600) + 1);

		pointsbH = (int) Math.round(pointsbH + (important * (resultH - expectedrH)));
		pointsbA = (int) Math.round(pointsbA + (important * (resultA - expectedrA)));

		System.out.println("Home team new points: " + pointsbH);
		System.out.println("Away team new points: " + pointsbA);
	}
}