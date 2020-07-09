import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//programma tournoua
public class Schedule {

	public static void Groups() {
		char groups[] = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h' };
		int home[] = { 1, 3, 1, 2, 2, 4 };
		int away[] = { 4, 2, 3, 4, 1, 3 };

		for (int i = 0; i < groups.length; i++) {
			for (int j = 0; j < home.length; j++) {

				String hquerry = "SELECT Position, Team FROM `group " + groups[i] + "` WHERE Position = " + home[j];
				String aquerry = "SELECT Position, Team FROM `group " + groups[i] + "` WHERE Position = " + away[j];
				String insert = "INSERT INTO schedule (Match_ID, Home, Away, HScore, AScore) "
						+ "VALUES (?, ?, ?, 0, 0)";

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
						while (ars.next()) { // allagi home kai away teams
							insrt.setNull(1, java.sql.Types.INTEGER);
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
				System.out.printf("%2d %15s %15s %7d %7d\n", rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getInt(4), rs.getInt(5));
			}
			System.out.println();
			conn.close();
		} catch (Exception e) {
			System.out.print("Do not connect to DB - Error:" + e);
		}
	}

	public static void RoundOf16() { // match gia tin fasi ton 16
		char home[] = { 'a', 'c', 'e', 'g', 'b', 'd', 'f', 'h' };
		char away[] = { 'b', 'd', 'f', 'h', 'a', 'c', 'e', 'g' };

		for (int i = 0; i < home.length; i++) {

			String hquerry = "SELECT Position, Team FROM `group " + home[i] + "` WHERE Position = 1";
			String aquerry = "SELECT Position, Team FROM `group " + away[i] + "` WHERE Position = 2";
			String insert = "INSERT INTO schedule (Match_ID, Home, Away, HScore, AScore) VALUES (?, ?, ?, 0, 0)";

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
					while (ars.next()) {
						insrt.setNull(1, java.sql.Types.INTEGER);
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
	}

	public static void QuarterFinals() {
		int home[] = { 149, 151, 153, 155 };
		int away[] = { 150, 152, 154, 156 };

		for (int i = 0; i < home.length; i++) {

			String hquerry = "SELECT * FROM schedule WHERE Match_ID = " + home[i];
			String aquerry = "SELECT * FROM schedule WHERE Match_ID = " + away[i];
			String insert = "INSERT INTO schedule (Match_ID, Home, Away, HScore, AScore) VALUES (?, ?, ?, 0, 0)";

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
					while (ars.next()) {
						insrt.setNull(1, java.sql.Types.INTEGER);

						if (hrs.getInt(4) > hrs.getInt(5)) {
							insrt.setString(2, hrs.getString(2));
						} else {
							insrt.setString(2, hrs.getString(3));
						}

						if (ars.getInt(4) > ars.getInt(5)) {
							insrt.setString(3, ars.getString(2));
						} else {
							insrt.setString(3, ars.getString(3));
						}

						insrt.execute();
					}
				}

				conn.close();
			} catch (Exception e) {
				System.out.print("Do not connect to DB - Error:" + e);
			}
		}

	}

	public static void SemiFinals() {
		int home[] = { 157, 159 };
		int away[] = { 158, 160 };

		for (int i = 0; i < home.length; i++) {

			String hquerry = "SELECT * FROM schedule WHERE Match_ID = " + home[i];
			String aquerry = "SELECT * FROM schedule WHERE Match_ID = " + away[i];
			String insert = "INSERT INTO schedule (Match_ID, Home, Away, HScore, AScore) VALUES (?, ?, ?, 0, 0)";

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
					while (ars.next()) {
						insrt.setNull(1, java.sql.Types.INTEGER);

						if (hrs.getInt(4) > hrs.getInt(5)) {
							insrt.setString(2, hrs.getString(2));
						} else {
							insrt.setString(2, hrs.getString(3));
						}

						if (ars.getInt(4) > ars.getInt(5)) {
							insrt.setString(3, ars.getString(2));
						} else {
							insrt.setString(3, ars.getString(3));
						}

						insrt.execute();
					}
				}

				conn.close();
			} catch (Exception e) {
				System.out.print("Do not connect to DB - Error:" + e);
			}
		}
	}

	public static void Final() {

		for (int i = 0; i < 2; i++) {

			String hquerry = "SELECT * FROM schedule WHERE Match_ID = 161";
			String aquerry = "SELECT * FROM schedule WHERE Match_ID = 162";
			String insert = "INSERT INTO schedule (Match_ID, Home, Away, HScore, AScore) VALUES (?, ?, ?, 0, 0)";

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
					while (ars.next()) {
						insrt.setNull(1, java.sql.Types.INTEGER);
						switch (i) {
						case 0:
							if (hrs.getInt(4) < hrs.getInt(5)) {
								insrt.setString(2, hrs.getString(2));
							} else {
								insrt.setString(2, hrs.getString(3));
							}

							if (ars.getInt(4) < ars.getInt(5)) {
								insrt.setString(3, ars.getString(2));
							} else {
								insrt.setString(3, ars.getString(3));
							}

							insrt.execute();
							break;

						case 1:
							if (hrs.getInt(4) > hrs.getInt(5)) {
								insrt.setString(2, hrs.getString(2));
							} else {
								insrt.setString(2, hrs.getString(3));
							}

							if (ars.getInt(4) > ars.getInt(5)) {
								insrt.setString(3, ars.getString(2));
							} else {
								insrt.setString(3, ars.getString(3));
							}

							insrt.execute();
							break;
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
