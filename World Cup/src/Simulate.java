import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

public class Simulate {

	public static void GroupStageScore() {
		Random n = new Random();
		for (int id = 101; id <= 148; id++) {
			String q = "SELECT * FROM schedule WHERE Match_ID= " + id;
			String u = "UPDATE `schedule` SET `HScore` = ?, `AScore` = ? WHERE `schedule`.`Match_ID` =?";

			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = null;
				conn = DriverManager.getConnection("jdbc:mysql://localhost/worldcup", "root", "");
				// System.out.print("Database is connected !");
				PreparedStatement pst = conn.prepareStatement(q);
				ResultSet rs = pst.executeQuery();

				PreparedStatement up = conn.prepareStatement(u);

				while (rs.next()) {
					int h = n.nextInt(6);
					int a = n.nextInt(6);

					System.out.println();
					System.out.println("Match: " + (id - 100));
					System.out.println(rs.getString(2) + " vs " + rs.getString(3));
					System.out.println("Final score: " + h + " - " + a);

					up.setInt(1, h);
					up.setInt(2, a);
					up.setInt(3, id);
					up.executeUpdate();

					if (h > a) {
						System.out.println("The winner is " + rs.getString(2));

					} else if (h == a) {
						System.out.println("Draw");

					} else {
						System.out.println("The winner is " + rs.getString(3));

					}
				}

				conn.close();
			} catch (Exception e) {
				System.out.print("Do not connect to DB - Error:" + e);
			}
		}
	}

	public static void Roundof16() {
		for (int id = 149; id <= 156; id++) {
			KnockOutScore(id);
		}
	}

	public static void QuarterFinals() {
		for (int id = 157; id <= 160; id++) {
			KnockOutScore(id);
		}
	}

	public static void SemiFinals() {
		for (int id = 161; id <= 162; id++) {
			KnockOutScore(id);
		}
	}

	public static void Final() {
		for (int id = 163; id <= 164; id++) {
			KnockOutScore(id);
		}
	}

	public static void KnockOutScore(int id) {
		Random n = new Random();

		String q = "SELECT * FROM schedule WHERE Match_ID= " + id;
		String u = "UPDATE `schedule` SET `HScore` = ?, `AScore` = ? WHERE `schedule`.`Match_ID` =?";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = null;
			conn = DriverManager.getConnection("jdbc:mysql://localhost/worldcup", "root", "");
			// System.out.print("Database is connected !");
			PreparedStatement pst = conn.prepareStatement(q);
			ResultSet rs = pst.executeQuery();

			PreparedStatement up = conn.prepareStatement(u);

			while (rs.next()) {
				int h = n.nextInt(6);
				int a = n.nextInt(6);
				int ph, pa;
				System.out.println();
				System.out.println("Match: " + (id - 100));
				System.out.println(rs.getString(2) + " vs " + rs.getString(3));

				if (h > a) { // winner h in 90'
					System.out
							.println("The winner is " + rs.getString(2) + " in 90' and the score is: " + h + " - " + a);

					up.setInt(1, h);
					up.setInt(2, a);
					up.setInt(3, id);
					up.executeUpdate();
				} else if (h == a) { // draw in 90'
					int hh = n.nextInt(4);
					int aa = n.nextInt(4);
					if (hh > aa) { // winner h in 120'
						System.out.println("The score in 90' was: " + h + " - " + a);
						System.out.println("The winner is " + rs.getString(2) + " in 120' and the score is: " + (hh + h)
								+ " - " + (aa + a));

						up.setInt(1, hh + h);
						up.setInt(2, aa + a);
						up.setInt(3, id);
						up.executeUpdate();
					} else if (hh == aa) { // draw in 120'
						do {
							ph = n.nextInt(6);
							pa = n.nextInt(6);
						} while (ph == pa);

						if (ph > pa) {
							System.out.println("The score in 90' was: " + h + " - " + a);
							System.out.println(
									"The winner is " + rs.getString(2) + " in Penalty shoot-out and the score is: "
											+ (hh + h) + "(" + ph + ") - " + (aa + a) + "(" + pa + ")");

							up.setInt(1, ((hh + h) + 1));
							up.setInt(2, aa + a);
							up.setInt(3, id);
							up.executeUpdate();
						} else {
							System.out.println("The score in 90' was: " + h + " - " + a);
							System.out.println(
									"The winner is " + rs.getString(3) + " in Penalty shoot-out and the score is: "
											+ (hh + h) + "(" + ph + ") - " + (aa + a) + "(" + pa + ")");

							up.setInt(1, hh + h);
							up.setInt(2, ((aa + a) + 1));
							up.setInt(3, id);
							up.executeUpdate();
						}
					} else {// winner a in 120'
						System.out.println("The score in 90' was: " + h + " - " + a);
						System.out.println("The winner is " + rs.getString(3) + " in 120' and the score is: " + (hh + h)
								+ " - " + (aa + a));

						up.setInt(1, hh + h);
						up.setInt(2, aa + a);
						up.setInt(3, id);
						up.executeUpdate();
					}
				} else { // winner a in 90'
					System.out
							.println("The winner is " + rs.getString(3) + " in 90' and the score is: " + h + " - " + a);
					up.setInt(1, h);
					up.setInt(2, a);
					up.setInt(3, id);
					up.executeUpdate();
				}
			}
			conn.close();
		} catch (Exception e) {
			System.out.print("Do not connect to DB - Error:" + e);
		}
	}
}