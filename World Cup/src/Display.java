import java.sql.*;
import java.util.*;

public class Display {
	
	public static void MainMenu() {
		//Main Menu
		System.out.println("\tWorld Cup\n"
				+ "1. Team Menu\n" //Insert countries
				+ "2. Tournament Infos\n" //show the schedule, groups, knockout stage
				+ "3. Rankings\n" //fifa ranking
				+ "4. Simulate Menu\n" //simulate menu
				+ "5. End\n\n");
	}

	public static void InsertTeams(Teams[] teams) {

		for(int i=0; i<teams.length; i++) {
			int j=i+1;
			int c =0;
			
			System.out.println("Give the name of the team! (" +j+ "/" + teams.length + ")\n");
			String cname = UserInput.getString();
			
	/*		for(TeamRanking b : ranks) {                                   //this is working fine
				if(b.getRName().contains(cname)){
					teams[i] = new Teams(cname);
					System.out.println("Team added! (" +j+ "/" + teams.length + ")\n");
					break;
				}
				else {	
					c++;
				}
			}
			if (c == ranks.length) {
				System.out.println("That's not a team!\nTry again!");
				i--;
			}
*/			String conf ="";
	    	String query0 = "INSERT INTO worldcupfinal (ID, Team, Confederation) "+"VALUES (?, ?, ?)";
			String query2 = "SELECT Name, Confederation FROM fifaranking WHERE Name = '" + cname + "'"; //gia na paro to confederation

			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = null;
				conn = DriverManager.getConnection("jdbc:mysql://localhost/worldcup","root", "");
				PreparedStatement pst0 = conn.prepareStatement(query0);
				//pst0.executeQuery();

				PreparedStatement pst2 = conn.prepareStatement(query2);
				ResultSet rs2 = pst2.executeQuery();
				
	//     		pst0.setInt(1, 98); //thelo na mpainei NULL. exo dilvsei stin basi AUTO_INCREMENT 
		//		pst0.setString(2, "Gdsaf"); //pairnei to onoma pou exei dosei apo to pliktrologio
		//		pst0.setString(3, "asfsa"); //pairnei to confederation analoga me to onoma pou exei dosei.
		//		pst0.execute(); //gia na balei tis times stin basi

				
			    conn.setAutoCommit(false);
				Savepoint svp1 = conn.setSavepoint();
							
				boolean nameExists=false;
				while (rs2.next()) {
					if (rs2.getString(1).equals(cname)) {
						nameExists =true;
						//fail eisagogi stin worldcupfinal basi						
						pst0.setInt(1, 44); //thelo na mpainei NULL. exo dilvsei stin basi AUTO_INCREMENT 
						pst0.setString(2, "fddsg"); //pairnei to onoma pou exei dosei apo to pliktrologio
						pst0.setString(3, "rsdf"); //pairnei to confederation analoga me to onoma pou exei dosei.
						pst0.execute(); //gia na balei tis times stin basi
												
						// elenxos gia tin eisagogi ston pinaka COMPLE
						teams[i] = new Teams(cname);
						OldShowTeams(teams);
						System.out.println("Team added! (" +j+ "/" + teams.length + ")\n");
						conf= rs2.getString(2);
						//einai adios
						ShowTeams();
					}
					c++;
				}
				conn.setAutoCommit(false);
				Savepoint svp2 = conn.setSavepoint();
				
	/*			if (nameExists) {
					Connection conn2 = null;
					conn2 = DriverManager.getConnection("jdbc:mysql://localhost/worldcup","root", "");
		//			PreparedStatement pst0 = conn.prepareStatement(query0);
					System.out.println("In name exists");

					
				//meta ton elenxo tha kano tin eisagogi
					pst0.setInt(1, 88); //thelo na mpainei NULL. exo dilvsei stin basi AUTO_INCREMENT 
					pst0.setString(2, "fddsg"); //pairnei to onoma pou exei dosei apo to pliktrologio
					pst0.setString(3, "rsdf"); //pairnei to confederation analoga me to onoma pou exei dosei.
					pst0.execute(); //gia na balei tis times stin basi
				
					ShowTeams();

				teams[i] = new Teams(cname);
				OldShowTeams(teams);
				
		//	    conn.setAutoCommit(false);


				}
				else*/
				
				if (c==0){
					System.out.println("Wrong name. Try again\n");
					i--;
					conn.rollback(svp1);
					conn.commit();
				}
				if(c!=0) {
					conn.rollback(svp2);
					conn.commit();

				}
				
				conn.close();
			}
			catch(Exception e) {
				System.out.print("Do not connect to DB - Error1111111111111:"+e);
			}
		}
	}	
	
	public static void ShowTeams() {
			//show the inserted teams     -------------------------  confederation  is missing

	//	System.out.printf("%3s %12s \n", "#|", "COUNTRY NAME|");
	//	for(int i = 0; i<teams.length; i++){
	//		System.out.printf("%2s %12s \n", (i+1), teams[i]); //+ " CONFEDERATION: " + ranks[i].getRRank());
  //		  	}
		
		String query = "SELECT * FROM worldcupfinal";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = null;
			conn = DriverManager.getConnection("jdbc:mysql://localhost/worldcup","root", "");
			//System.out.print("Database is connected !");
			PreparedStatement pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			System.out.printf("%1s %30s %12s\n", "#|", "COUNTRY NAME|", "CONFEDERATION|");
			
			while (rs.next()) {
				System.out.printf("%4d %30s %14s\n", rs.getInt(1), rs.getString(2), rs.getString(3));
				}
			System.out.println();
			conn.close();
			}
		catch(Exception e)
		{
			System.out.print("Do not connect to DB - Error:"+e);
			}

		
		}
	
	public static void ShowRanking() {
	/*	System.out.printf("%1s %11s %10s\n", "RANK|", "COUNTRY NAME|", "CONFEDERATION|");
		System.out.println("----------------------------------");
		for(int i = 0; i<ranks.length; i++){
			System.out.printf("%1d. %12s %12s\n", ranks[i].getRRank(), ranks[i].getRName(), ranks[i].getRConfederation());
  		  	}
  	*/
		
		String query = "SELECT Rank, Name, Confederation, Points, Wins FROM fifaranking ORDER BY Rank";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = null;
			conn = DriverManager.getConnection("jdbc:mysql://localhost/worldcup","root", "");
			//System.out.print("Database is connected !");
			PreparedStatement pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			System.out.printf("%1s %30s %12s %5s %5s\n", "RANK|", "COUNTRY NAME|", "CONFEDERATION|", "POINTS|", "WINS|");
			
			while (rs.next()) {
				System.out.printf("%4d %30s %14s %7d %5d\n", rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
				}
			System.out.println();
			conn.close();
			}
		catch(Exception e)
		{
			System.out.print("Do not connect to DB - Error:"+e);
			}

		}

	public static void TeamMenu() {
		System.out.println("\tTeam Menu\n"
				+ "1. Insert teams\n" //Insert countries
				+ "2. Display teams\n" //show the schedule of the tournament
				+ "3. Go Back!\n\n");
	}
	
	public static void OldShowTeams(Teams[] teams) {
		//show the inserted teams     -------------------------  confederation  is missing

	System.out.printf("%3s %12s \n", "#|", "COUNTRY NAME|");
	for(int i = 0; i<teams.length; i++){
		System.out.printf("%2s %12s \n", (i+1), teams[i]); //+ " CONFEDERATION: " + ranks[i].getRRank());
		  	}
		
	}

	
}