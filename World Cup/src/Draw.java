import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

//klirosi ton omilon
public class Draw {

	public static void setGroups(int[] riddd, int t) {

		for (int i = 0; i < riddd.length; i++) {

			String query = "SELECT ID, Team FROM worldcupfinal ORDER BY ID";
			String findq = "SELECT ID, Team FROM worldcupfinal WHERE ID = ?";

			String inserta = "INSERT INTO `group a` (Position, Team, Played, Wins, Draws, Loses, `Goals for`, `Goals against`, `Goal difference`, Points) "
					+ "VALUES (?, ?, 0, 0, 0, 0, 0, 0, 0, 0)";
			String insertb = "INSERT INTO `group b` (Position, Team, Played, Wins, Draws, Loses, `Goals for`, `Goals against`, `Goal difference`, Points) "
					+ "VALUES (?, ?, 0, 0, 0, 0, 0, 0, 0, 0)";
			String insertc = "INSERT INTO `group c` (Position, Team, Played, Wins, Draws, Loses, `Goals for`, `Goals against`, `Goal difference`, Points) "
					+ "VALUES (?, ?, 0, 0, 0, 0, 0, 0, 0, 0)";
			String insertd = "INSERT INTO `group d` (Position, Team, Played, Wins, Draws, Loses, `Goals for`, `Goals against`, `Goal difference`, Points) "
					+ "VALUES (?, ?, 0, 0, 0, 0, 0, 0, 0, 0)";
			String inserte = "INSERT INTO `group e` (Position, Team, Played, Wins, Draws, Loses, `Goals for`, `Goals against`, `Goal difference`, Points) "
					+ "VALUES (?, ?, 0, 0, 0, 0, 0, 0, 0, 0)";
			String insertf = "INSERT INTO `group f` (Position, Team, Played, Wins, Draws, Loses, `Goals for`, `Goals against`, `Goal difference`, Points) "
					+ "VALUES (?, ?, 0, 0, 0, 0, 0, 0, 0, 0)";
			String insertg = "INSERT INTO `group g` (Position, Team, Played, Wins, Draws, Loses, `Goals for`, `Goals against`, `Goal difference`, Points) "
					+ "VALUES (?, ?, 0, 0, 0, 0, 0, 0, 0, 0)";
			String inserth = "INSERT INTO `group h` (Position, Team, Played, Wins, Draws, Loses, `Goals for`, `Goals against`, `Goal difference`, Points) "
					+ "VALUES (?, ?, 0, 0, 0, 0, 0, 0, 0, 0)";

			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = null;
				conn = DriverManager.getConnection("jdbc:mysql://localhost/worldcup", "root", "");
				// System.out.print("Database is connected !");

				PreparedStatement pst = conn.prepareStatement(query);
				ResultSet rs = pst.executeQuery();

				PreparedStatement find = conn.prepareStatement(findq);
				PreparedStatement groupa = conn.prepareStatement(inserta);
				PreparedStatement groupb = conn.prepareStatement(insertb);
				PreparedStatement groupc = conn.prepareStatement(insertc);
				PreparedStatement groupd = conn.prepareStatement(insertd);
				PreparedStatement groupe = conn.prepareStatement(inserte);
				PreparedStatement groupf = conn.prepareStatement(insertf);
				PreparedStatement groupg = conn.prepareStatement(insertg);
				PreparedStatement grouph = conn.prepareStatement(inserth);

				while (rs.next()) {
					if (rs.getInt(1) == riddd[i]) {
						find.setInt(1, riddd[i]);
						ResultSet frs = find.executeQuery();
						while (frs.next()) {
							System.out.println();
							System.out.println("Rank: " + rs.getInt(1) + " Team: " + frs.getString(2));

							switch (i) {
							case 0:
								groupa.setInt(1, t);
								groupa.setString(2, rs.getString(2));
								groupa.execute();

								System.out.println(" -> Group A ");
								break;
							case 1:
								groupb.setInt(1, t);
								groupb.setNString(2, rs.getNString(2));
								groupb.execute();

								System.out.println(" -> Group B ");
								break;
							case 2:
								groupc.setInt(1, t);
								groupc.setNString(2, rs.getNString(2));
								groupc.execute();

								System.out.println(" -> Group C ");
								break;
							case 3:
								groupd.setInt(1, t);
								groupd.setNString(2, rs.getNString(2));
								groupd.execute();

								System.out.println(" -> Group D ");
								break;
							case 4:
								groupe.setInt(1, t);
								groupe.setNString(2, rs.getNString(2));
								groupe.execute();

								System.out.println(" -> Group E ");
								break;
							case 5:
								groupf.setInt(1, t);
								groupf.setNString(2, rs.getNString(2));
								groupf.execute();

								System.out.println(" -> Group F ");
								break;
							case 6:
								groupg.setInt(1, t);
								groupg.setNString(2, rs.getNString(2));
								groupg.execute();

								System.out.println(" -> Group G ");
								break;
							case 7:
								grouph.setInt(1, t);
								grouph.setNString(2, rs.getNString(2));
								grouph.execute();

								System.out.println(" -> Group H ");
								break;
							}
						}
					}
				}

				conn.close();
			} catch (Exception e) {
				System.out.print("Do not connect to DB ------------------ Error:" + e);
			}

		}
	}

	public static void Pots(int[] pottest, int m) {

		Random r = new Random();

		for (int i = 0; i < 8; i++) {
			boolean newNumber = false;
			int rid = 0;
			while (!newNumber) {
				newNumber = true;
				rid = r.nextInt(8) + m; // me to m na einai 1 gia 1o pot, 9 gia 2o pot, 17 gia trito pot, 25 gia gia 4o pot

				for (int k = 0; (k < pottest.length && newNumber); k++) {
					if (pottest[k] == rid) {
						newNumber = false;
					}
				}

			}

			pottest[i] = rid;
		}

	}

	public static void DrawGroup() {
		// 32 omades se 8 group ton 4 omadon

		int riddd[] = new int[8];
		int m = 1;
		for (int t = 1; t <= 4; t++) {

			Pots(riddd, m);
			System.out.println("Pot: " + t);
			System.out.println("-------");

			setGroups(riddd, t);
			m = m + 8;
		}
	}

}
