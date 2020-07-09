import java.sql.*;
import java.util.*;

public class Display {

	public static void MainMenu() {
		// Main Menu
		System.out.println("\tWorld Cup\n" + "1. Team Menu\n" // Insert countries
				+ "2. Tournament Infos\n" // show the schedule, groups, knockout stage
				+ "3. Rankings\n" // fifa ranking
				+ "4. Simulate Menu\n" // simulate menu
				+ "5. End\n\n");
	}

	public static void InsertTeams() {
		int teams = 32;
		for (int i = 0; i < teams; i++) {
			int j = i + 1;
			int c = 0;

			System.out.println("Give the name of the team! (" + j + "/" + teams + ")\n");
			String cname = UserInput.getString();

			String query0 = "INSERT INTO worldcupfinal (ID, Team, Confederation) " + "VALUES (?, ?, ?)";
			String query2 = "SELECT Name, Confederation FROM fifaranking WHERE Name = '" + cname + "'";

			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = null;
				conn = DriverManager.getConnection("jdbc:mysql://localhost/worldcup", "root", "");
				conn.setAutoCommit(false);
				PreparedStatement pst0 = conn.prepareStatement(query0);
				// pst0.executeQuery();

				PreparedStatement pst2 = conn.prepareStatement(query2);
				ResultSet rs2 = pst2.executeQuery();

				Savepoint svp1 = conn.setSavepoint();

				while (rs2.next()) {
					if (rs2.getString(1).equals(cname)) {

						pst0.setInt(1, j);
						pst0.setString(2, cname);
						pst0.setString(3, rs2.getString(2));
						pst0.execute();

						System.out.println("Team added! (" + j + "/" + teams + ")\n");
					}
					c++;
				}
				conn.setAutoCommit(false);
				Savepoint svp2 = conn.setSavepoint();

				if (c == 0) {
					System.out.println("Wrong name. Try again\n");
					i--;
					conn.rollback(svp1);
					conn.commit();
				} else {
					conn.rollback(svp2);
					conn.commit();
				}
				conn.close();
			} catch (Exception e) {
				System.out.print("Do not connect to DB - Error:" + e);
			}
		}
	}

	public static void ShowTeams() {

		String query = "SELECT * FROM worldcupfinal";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = null;
			conn = DriverManager.getConnection("jdbc:mysql://localhost/worldcup", "root", "");
			// System.out.print("Database is connected !");
			PreparedStatement pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			System.out.printf("%2s %30s %12s\n", " #|", "COUNTRY NAME|", "CONFEDERATION|");

			while (rs.next()) {
				System.out.printf("%2d %30s %14s\n", rs.getInt(1), rs.getString(2), rs.getString(3));
			}
			System.out.println();
			conn.close();
		} catch (Exception e) {
			System.out.print("Do not connect to DB - Error:" + e);
		}
	}

	public static void ShowRanking() {

		String query = "SELECT Rank, Name, Confederation, Points, Wins FROM fifaranking ORDER BY Rank";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = null;
			conn = DriverManager.getConnection("jdbc:mysql://localhost/worldcup", "root", "");
			// System.out.print("Database is connected !");
			PreparedStatement pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			System.out.printf("%1s %30s %12s %5s %5s\n", "RANK|", "COUNTRY NAME|", "CONFEDERATION|", "POINTS|",
					"WINS|");

			while (rs.next()) {
				System.out.printf("%4d %30s %14s %7d %5d\n", rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getInt(4), rs.getInt(5));
			}
			System.out.println();
			conn.close();
		} catch (Exception e) {
			System.out.print("Do not connect to DB - Error:" + e);
		}
	}

	public static void TeamMenu() {
		System.out.println("\tTeam Menu\n" + "1. Insert teams\n" // Insert countries
				+ "2. Display teams\n" // show the schedule of the tournament
				+ "3. Go Back!\n\n");
	}

	// Display Groups

	/*
				System.out.printf("%1s %15s %2s %2s %2s %2s %2s %2s %2s %2s\n", " POS|", "TEAM|", "P|", "W|", "D|", "L|", "FOR|", "AGAINST|", "DIFF|", "POINTS|");

				while (rs.next()) {
					System.out.printf("%4d %15s %2d %2d %2d %2d %4d %8d %5d %7d\n", rs.getInt(1), rs.getString(2), rs.getInt(3),
							rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10));
				}
	 */

}