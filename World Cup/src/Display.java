import java.sql.*;
import java.util.*;

public class Display {

	public static void MainMenu() {
		// Main Menu
		System.out.println("\tWorld Cup\n" 
				+ "1. Team Menu\n" // Insert countries
				+ "2. Schedule\n" // show the schedule, groups, knockout stage
				+ "3. FIFA Ranking\n" // fifa ranking
				+ "4. Simulate Menu\n" // simulate menu
				+ "5. Reset\n"
				+ "6. End\n");
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
		System.out.println("\tTeam Menu\n"
				+ "1. Insert teams\n" // Insert countries
				+ "2. Display teams\n" // show the schedule of the tournament
				+ "3. Go Back!\n");
	}

	// Display Groups

	public static void ShowGroups() {

		char groups[] = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h' };

		for (int i = 0; i < groups.length; i++) {

			String q = "SELECT Position, Team, Played, Wins, Draws, Loses, `Goals for`, `Goals against`, `Goal difference`, Points FROM `group "
					+ groups[i] + "` ORDER BY Position";

			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = null;
				conn = DriverManager.getConnection("jdbc:mysql://localhost/worldcup", "root", "");
				conn.setAutoCommit(false);

				PreparedStatement pst = conn.prepareStatement(q);
				ResultSet rs = pst.executeQuery();
				System.out.println();
				System.out.println("\tGroup " + groups[i]);
				System.out.printf("%1s %15s %2s %2s %2s %2s %2s %2s %2s %2s\n", " POS|", "TEAM|", "P|", "W|", "D|",
						"L|", "FOR|", "AGAINST|", "DIFF|", "POINTS|");

				while (rs.next()) {
					System.out.printf("%4d %15s %2d %2d %2d %2d %4d %8d %5d %7d\n", rs.getInt(1), rs.getString(2),
							rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8),
							rs.getInt(9), rs.getInt(10));
				}
				conn.close();
			} catch (Exception e) {
				System.out.print("Do not connect to DB - Error:" + e);
			}

		}
	}
	
	public static void Schedule() {
		System.out.println("\tSchedule Menu\n" 
				+ "1. Group Schedule\n"
				+ "2. Round-of-16 Schedule\n" 
				+ "3. Quarter-Finals Schedule\n"
				+ "4. Semi-Finals Schedule\n"
				+ "5. Final Schedule\n"
				+ "6. Go Back!\n");
	}
	
	public static void Simulate() {
		System.out.println("\tSimulate Menu\n" 
				+ "1. Group Simulate\n" 
				+ "2. Round-of-16 Simulate\n" 
				+ "3. Quarter-Finals Simulate\n"
				+ "4. Semi-Finals Simulate\n"
				+ "5. Final Simulate\n"
				+ "6. Go Back!\n");
	}

	public static void Reset() {
		System.out.println("Do you want to reset the tournament?\n"
				+ "1. Yes.\n"
				+ "2. No.\n");
	}
}