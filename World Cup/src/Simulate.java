import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

public class Simulate {
	
	static double resultH =0;
	static double resultA =0;
	static int important =0;
	static double pointsbH =0;
   	static double pointsbA =0;
   	
	public static void PointsFromRaking() {
		
		//thelo na paro tous pontous apo thn xora kai na tous balo se mia timi
		//oste na bro tous kainourious kai na tous epistrepso piso
		
		String hname ="";
		String aname= "";
		String queryh = "SELECT name, points FROM fifaranking WHERE Name = '" + hname + "'";
		String querya = "SELECT name, points FROM fifaranking WHERE Name = '" + aname + "'";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = null;
			conn = DriverManager.getConnection("jdbc:mysql://localhost/worldcup","root", "");
			//System.out.print("Database is connected !");
			PreparedStatement psth = conn.prepareStatement(queryh);
			ResultSet rsh = psth.executeQuery();
			
			PreparedStatement psta = conn.prepareStatement(querya);
			ResultSet rsa = psta.executeQuery();

			System.out.println("test points");
			
			while (rsh.next()) {
				if (rsh.getString(1).equals(hname)) {
					pointsbH = rsh.getInt(2);
					System.out.println("The points for the home team are: " + pointsbH);
				}
			}
			
			while (rsa.next()) {
				if (rsa.getString(1).equals(aname)) {
					pointsbA = rsa.getInt(2);
					System.out.println("The points for the away team are: " + pointsbA);
				}
			}
			
			System.out.println();
			conn.close();
		}
		catch(Exception e)
		{
			System.out.print("Do not connect to DB - Error:"+e);
		}

	}
    public static void GroupStageScore() {
    	
    	//prepei na ginei kai ananeosi ton ponton stous omilous.

        Random n=new Random();
        int h=n.nextInt(6);
        int a=n.nextInt(6);
        System.out.println("The final score is: "+ h +" - " + a);
        important =50;
        
        if (h>a) {
        	resultH =1;
        	resultA =0;
        	setNewFIFAPoints();
        	
        }else if(h==a){
        	resultH =0.5;
        	resultA =0.5;
        	setNewFIFAPoints();
        }else {
        	resultH =0;
        	resultA =1;
        	setNewFIFAPoints();
        }
        
    }
    
    public static void Roundof16(){
    	
        Random n=new Random();
        int h=n.nextInt(6);
        int a=n.nextInt(6);
        important =50;
        KnockoutStageScoreCheck(h,a);

    }
    
    public static void QuarterFinals(){
    	
        Random n=new Random();
        int h=n.nextInt(6);
        int a=n.nextInt(6);
        important =60;
        KnockoutStageScoreCheck(h,a);
    }
    
    public static void KnockoutStageScoreCheck(int h, int a) {
        Random n=new Random();
    	int ph, pa;
        
        if (h>a) { //winner h in 90'
        	resultH =1;
        	resultA =0;
            System.out.println("The winner is Home team in 90' and the score is: "+ h +" - " + a);
        	setNewFIFAPoints();
        }else if(h==a){ //draw in 90'
            int hh=n.nextInt(4);
            int aa=n.nextInt(4);
            if (hh>aa) { // winner h in 120'
            	resultH =1;
            	resultA =0;
                System.out.println("The score in 90' was: "+ h +" - " + a);
                System.out.println("The winner is Home team in 120' and the score is: "+ (hh+h) +" - " + (aa+a));
            	setNewFIFAPoints();
            }else if(hh==aa){ //draw in 120'
            	do {
                    ph=n.nextInt(6);
                    pa=n.nextInt(6);
            	}while (ph==pa);
            	
            	if(ph>pa) {
                	resultH =0.75;
                	resultA =0.5;
                    System.out.println("The score in 90' was: "+ h +" - " + a);
                    System.out.println("The winner is Home team in Penalty shoot-out and the score is: "+ (hh+h) +"("+ph+") - " + (aa+a) +"("+pa+")");
                	setNewFIFAPoints();
            	}
            	else {
                	resultH =0.5;
                	resultA =0.75;
                    System.out.println("The score in 90' was: "+ h +" - " + a);
                    System.out.println("The winner is Away team in Penalty shoot-out and the score is: "+ (hh+h) +"("+ph+") - " + (aa+a) +"("+pa+")");
                	setNewFIFAPoints();
            	}
            	
            }else {// winner a in 120'
            	resultH =0;
            	resultA =1;
                System.out.println("The score in 90' was: "+ h +" - " + a);
                System.out.println("The winner is Away team in 120' and the score is: "+ (hh+h) +" - " + (aa+a));
            	setNewFIFAPoints();
            }
            
        }else { //winner a in 90'
        	resultH =0;
        	resultA =1;
            System.out.println("The winner is Away team in 90' and the score is: "+ h +" - " + a);
        	setNewFIFAPoints();
        }
    }
    
    public static void setNewFIFAPoints() {    	
    	//need the correct points here and it's ready
    	double expectedrH = 1/(Math.pow(10,-(pointsbH-pointsbA)/600)+1);
    	double expectedrA = 1/(Math.pow(10,-(pointsbA-pointsbH)/600)+1);
    	
    	pointsbH = (int) Math.round(pointsbH + (important * (resultH - expectedrH)));
    	pointsbA = (int) Math.round(pointsbA + (important * (resultA - expectedrA)));

    	System.out.println("Home team new points: " + pointsbH);
    	System.out.println("Away team new points: " + pointsbA);
    }
    
    public static void Run() {
    	//edo tha trexei to tournoua, afou ftiakso to draw prota
    }
    
 //   public static void Draw(TeamRanking[] rank, Groups[] A, Groups[] B,Groups[] C, Groups[] D, Groups[] E) { //5 groups of 2 teams just to test it
    public static void Draw() { //real thing

    	//klirosi: 32 omades -> 8 groups -> 4 omades se kathe group
    	
 /*   	int c=0;
    	for(int i=0; i<2; i++) {
    		A[i] = new Groups(rank[c].getRName(), 0,0,0);
    		c++;
    		B[i] = new Groups(rank[c].getRName(), 0,0,0);
    		c++;
    		C[i] = new Groups(rank[c].getRName(), 0,0,0);
    		c++;
    		D[i] = new Groups(rank[c].getRName(), 0,0,0);
    		c++;
    		E[i] = new Groups(rank[c].getRName(), 0,0,0);
    		c++;
    	}
    	for(int i = 0; i<2; i++){
    		System.out.println("Group A: "+ A[i].getName());
    		System.out.println("Group B: "+ B[i].getName());
    		System.out.println("Group C: "+ C[i].getName());
    		System.out.println("Group D: "+ D[i].getName());
    		System.out.println("Group E: "+ E[i].getName());
    	}
   */ 	
    	
        Random n=new Random();
        int rid=0;
    	
		String query = "SELECT team FROM worldcupfinal WHERE ID = '" + rid + "'";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = null;
			conn = DriverManager.getConnection("jdbc:mysql://localhost/worldcup","root", "");
			//System.out.print("Database is connected !");
			PreparedStatement pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			
			System.out.println("test draw");
			
			while (rs.next()) {
				rid=n.nextInt(8-1);
			}
			
			conn.close();
		}
		catch(Exception e)
		{
			System.out.print("Do not connect to DB ------------------ Error:"+e);
		}
    }
}