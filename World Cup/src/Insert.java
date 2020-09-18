import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Savepoint;

public class Insert {
	public static void InsertTeams() {
		int teams = 2;
		for (int i = 0; i < teams; i++) {
			int j = i + 1;
			int c = 0;

			System.out.println("Give the name of the team! (" + j + "/" + teams + ")\n");
			String cname = UserInput.getString();

			String query0 = "INSERT INTO worldcupfinal (ID, Team, Confederation) " + "VALUES (?, ?, ?)";
			String query1 = "SELECT Team, Confederation FROM worldcupfinal WHERE Team = '" + cname + "'";
			String query2 = "SELECT Name, Confederation FROM fifaranking WHERE Name = '" + cname + "'";

			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = null;
				conn = DriverManager.getConnection("jdbc:mysql://localhost/worldcup", "root", "");
				conn.setAutoCommit(false);
				PreparedStatement pst0 = conn.prepareStatement(query0);
				// pst0.executeQuery();

				PreparedStatement pst1 = conn.prepareStatement(query1);
				ResultSet rs1 = pst1.executeQuery();

				PreparedStatement pst2 = conn.prepareStatement(query2);
				ResultSet rs2 = pst2.executeQuery();

				Savepoint svp1 = conn.setSavepoint();

				while (rs2.next()) {
					if (rs2.getString(1).equals(cname)) {// checks if the team is in the fifa ranking
						System.out.println("Check after if and after first sql check!\n");
						if (rs1.next() == false) {
							pst0.setInt(1, j);
							pst0.setString(2, cname);
							pst0.setString(3, rs2.getString(2));
							pst0.execute();

							System.out.println("Team added! (" + j + "/" + teams + ")\n");

						} else {
							System.out.println("Check else!\n");
							System.out.println("Check before if and after second sql check!\n");
							if (rs1.getString(1).equals(cname)) {
								System.out.println("This team has been added already!\n");
								conn.rollback(svp1);
								conn.commit();
							} else {
								System.out.println("ekso apo tin eisodo\n");
								pst0.setInt(1, j);
								pst0.setString(2, cname);
								pst0.setString(3, rs2.getString(2));
								pst0.execute();

								System.out.println("Team added! (" + j + "/" + teams + ")\n");
							}
						}
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

}
