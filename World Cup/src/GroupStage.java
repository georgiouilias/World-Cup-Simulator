import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class GroupStage {

	public static void GroupPointsUpdate() { // ipologismos ponton stous omilous

		char groups[] = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h' };

		for (int id = 101; id <= 148; id++) { // 148 group games
			for (int i = 0; i < groups.length; i++) {

				String g = "SELECT `Home`,`Away`,`HScore`,`AScore` FROM schedule WHERE Match_ID = " + id;

				String q = "SELECT * FROM `group " + groups[i] + "`";

				String u = "UPDATE `group " + groups[i]
						+ "` SET `Played` = ?, `Wins` = ?, `Draws` = ?, `Loses` = ?, `Goals for` = ?, `Goals against` = ?, `Goal difference` = ?, `Points` = ? WHERE Team = ?";

				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = null;
					conn = DriverManager.getConnection("jdbc:mysql://localhost/worldcup", "root", "");
					// System.out.print("Database is connected !");
					PreparedStatement pst = conn.prepareStatement(g);
					ResultSet rs = pst.executeQuery();

					PreparedStatement qpst = conn.prepareStatement(q);
					ResultSet qrs = qpst.executeQuery();

					PreparedStatement up = conn.prepareStatement(u);

					while (rs.next()) {
						if (rs.getInt(3) > rs.getInt(4)) { // Home Team won

							while (qrs.next()) {
								if (rs.getString(1).equals(qrs.getString(2))) { // Home team

									up.setString(9, rs.getString(1)); // dino onoma omadas sto where
									up.setInt(1, qrs.getInt(3) + 1); // played
									up.setInt(2, qrs.getInt(4) + 1); // wins
									up.setInt(3, qrs.getInt(5) + 0); // draws
									up.setInt(4, qrs.getInt(6) + 0); // loses
									up.setInt(5, qrs.getInt(7) + rs.getInt(3)); // Goals for
									up.setInt(6, qrs.getInt(8) + rs.getInt(4)); // Goals against
									up.setInt(7, qrs.getInt(9) + (rs.getInt(3) - rs.getInt(4))); // Goals diff
									up.setInt(8, qrs.getInt(10) + 3); // points
									up.executeUpdate();
								}
								if (rs.getString(2).equals(qrs.getString(2))) { // Away team

									up.setString(9, rs.getString(2)); // dino onoma omadas sto where
									up.setInt(1, qrs.getInt(3) + 1); // played
									up.setInt(2, qrs.getInt(4) + 0); // wins
									up.setInt(3, qrs.getInt(5) + 0); // draws
									up.setInt(4, qrs.getInt(6) + 1); // loses
									up.setInt(5, qrs.getInt(7) + rs.getInt(4)); // Goals for
									up.setInt(6, qrs.getInt(8) + rs.getInt(3)); // Goals against
									up.setInt(7, qrs.getInt(9) + (rs.getInt(4) - rs.getInt(3))); // Goals diff
									up.setInt(8, qrs.getInt(10) + 0); // points
									up.executeUpdate();
								}
							}
						} else if (rs.getInt(3) == rs.getInt(4)) { // Draw

							while (qrs.next()) {
								if (rs.getString(1).equals(qrs.getString(2))) { // Home team

									up.setString(9, rs.getString(1)); // dino onoma omadas sto where
									up.setInt(1, qrs.getInt(3) + 1); // played
									up.setInt(2, qrs.getInt(4) + 0); // wins
									up.setInt(3, qrs.getInt(5) + 1); // draws
									up.setInt(4, qrs.getInt(6) + 0); // loses
									up.setInt(5, qrs.getInt(7) + rs.getInt(3)); // Goals for
									up.setInt(6, qrs.getInt(8) + rs.getInt(4)); // Goals against
									up.setInt(7, qrs.getInt(9) + (0)); // Goals diff
									up.setInt(8, qrs.getInt(10) + 1); // points
									up.executeUpdate();
								}
								if (rs.getString(2).equals(qrs.getString(2))) { // Away team

									up.setString(9, rs.getString(2)); // dino onoma omadas sto where
									up.setInt(1, qrs.getInt(3) + 1); // played
									up.setInt(2, qrs.getInt(4) + 0); // wins
									up.setInt(3, qrs.getInt(5) + 1); // draws
									up.setInt(4, qrs.getInt(6) + 0); // loses
									up.setInt(5, qrs.getInt(7) + rs.getInt(4)); // Goals for
									up.setInt(6, qrs.getInt(8) + rs.getInt(3)); // Goals against
									up.setInt(7, qrs.getInt(9) + (0)); // Goals diff
									up.setInt(8, qrs.getInt(10) + 1); // points
									up.executeUpdate();
								}
							}
						} else if (rs.getInt(3) < rs.getInt(4)) { // Away Team Won
							while (qrs.next()) {
								if (rs.getString(1).equals(qrs.getString(2))) { // Home team

									up.setString(9, rs.getString(1)); // dino onoma omadas sto where
									up.setInt(1, qrs.getInt(3) + 1); // played
									up.setInt(2, qrs.getInt(4) + 0); // wins
									up.setInt(3, qrs.getInt(5) + 0); // draws
									up.setInt(4, qrs.getInt(6) + 1); // loses
									up.setInt(5, qrs.getInt(7) + rs.getInt(3)); // Goals for
									up.setInt(6, qrs.getInt(8) + rs.getInt(4)); // Goals against
									up.setInt(7, qrs.getInt(9) + (rs.getInt(3) - rs.getInt(4))); // Goals diff
									up.setInt(8, qrs.getInt(10) + 0); // points
									up.executeUpdate();
								}
								if (rs.getString(2).equals(qrs.getString(2))) { // Away team

									up.setString(9, rs.getString(2)); // dino onoma omadas sto where
									up.setInt(1, qrs.getInt(3) + 1); // played
									up.setInt(2, qrs.getInt(4) + 1); // wins
									up.setInt(3, qrs.getInt(5) + 0); // draws
									up.setInt(4, qrs.getInt(6) + 0); // loses
									up.setInt(5, qrs.getInt(7) + rs.getInt(4)); // Goals for
									up.setInt(6, qrs.getInt(8) + rs.getInt(3)); // Goals against
									up.setInt(7, qrs.getInt(9) + (rs.getInt(4) - rs.getInt(3))); // Goals diff
									up.setInt(8, qrs.getInt(10) + 3); // points
									up.executeUpdate();
								}
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

	public static void OrderByPoints() { // allazei i seira analoga me tous pontous

		char groups[] = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h' };

		for (int i = 0; i < groups.length; i++) {
			String t1 = "SELECT Position, Team, Played, Wins, Draws, Loses, `Goals for`, `Goals against`, `Goal difference`, Points FROM `group "
					+ groups[i] + "` ORDER BY Points DESC, `Goal difference` DESC LIMIT 1"; // 1h omada sto group
			String t2 = "SELECT Position, Team, Played, Wins, Draws, Loses, `Goals for`, `Goals against`, `Goal difference`, Points FROM `group "
					+ groups[i] + "` ORDER BY Points DESC, `Goal difference` DESC LIMIT 1,1"; // 2h omada sto group
			String t3 = "SELECT Position, Team, Played, Wins, Draws, Loses, `Goals for`, `Goals against`, `Goal difference`, Points FROM `group "
					+ groups[i] + "` ORDER BY Points ASC, `Goal difference` ASC LIMIT 1,1"; // 3h omada sto group
			String t4 = "SELECT Position, Team, Played, Wins, Draws, Loses, `Goals for`, `Goals against`, `Goal difference`, Points FROM `group "
					+ groups[i] + "` ORDER BY Points ASC, `Goal difference` ASC LIMIT 1"; // 4h omada sto group

			String u = "UPDATE `group " + groups[i] + "` SET `Position` = ? WHERE Team = ?";

			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = null;
				conn = DriverManager.getConnection("jdbc:mysql://localhost/worldcup", "root", "");
				// System.out.print("Database is connected !");
				PreparedStatement pst = conn.prepareStatement(t1);
				ResultSet rs = pst.executeQuery();

				PreparedStatement pst2 = conn.prepareStatement(t2);
				ResultSet rs2 = pst2.executeQuery();

				PreparedStatement pst3 = conn.prepareStatement(t3);
				ResultSet rs3 = pst3.executeQuery();

				PreparedStatement pst4 = conn.prepareStatement(t4);
				ResultSet rs4 = pst4.executeQuery();

				PreparedStatement up = conn.prepareStatement(u);

				while (rs.next()) {
					while (rs2.next()) {
						while (rs3.next()) {
							while (rs4.next()) {

								up.setInt(1, 1);
								up.setString(2, rs.getString(2));
								up.executeUpdate();

								up.setInt(1, 2);
								up.setString(2, rs2.getString(2));
								up.executeUpdate();

								up.setInt(1, 3);
								up.setString(2, rs3.getString(2));
								up.executeUpdate();

								up.setInt(1, 4);
								up.setString(2, rs4.getString(2));
								up.executeUpdate();
							}
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