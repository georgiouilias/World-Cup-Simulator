import java.util.Random;

public class Simulate {
	
	static double resultH =0;
	static double resultA =0;
	static int important =0;
	static double pointsbH =0;
   	static double pointsbA =0;
	
    public static void GroupStageScore() {
    	
    	//works fine.
    	//give the result to the setNewPoints

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
        important =25;
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
        	setNewFIFAPoints();
            System.out.println("The winner is Home team in 90' and the score is: "+ h +" - " + a);
        }else if(h==a){ //draw in 90'
            int hh=n.nextInt(4);
            int aa=n.nextInt(4);
            if (hh>aa) { // winner h in 120'
            	resultH =1;
            	resultA =0;
            	setNewFIFAPoints();
                System.out.println("The score in 90' was: "+ h +" - " + a);
                System.out.println("The winner is Home team in 120' and the score is: "+ (hh+h) +" - " + (aa+a));
            }else if(hh==aa){ //draw in 120'
            	do {
                    ph=n.nextInt(6);
                    pa=n.nextInt(6);
            	}while (ph==pa);
            	
            	if(ph>pa) {
                	resultH =0.75;
                	resultA =0.5;
                	setNewFIFAPoints();
                    System.out.println("The score in 90' was: "+ h +" - " + a);
                    System.out.println("The winner is Home team in Penalty shoot-out and the score is: "+ (hh+h) +"("+ph+") - " + (aa+a) +"("+pa+")");
            	}
            	else {
                	resultH =0.5;
                	resultA =0.75;
                	setNewFIFAPoints();
                    System.out.println("The score in 90' was: "+ h +" - " + a);
                    System.out.println("The winner is Away team in Penalty shoot-out and the score is: "+ (hh+h) +"("+ph+") - " + (aa+a) +"("+pa+")");
            	}
            	
            }else {// winner a in 120'
            	resultH =0;
            	resultA =1;
            	setNewFIFAPoints();
                System.out.println("The score in 90' was: "+ h +" - " + a);
                System.out.println("The winner is Away team in 120' and the score is: "+ (hh+h) +" - " + (aa+a));
            }
            
        }else { //winner a in 90'
        	resultH =0;
        	resultA =1;
        	setNewFIFAPoints();
            System.out.println("The winner is Away team in 90' and the score is: "+ h +" - " + a);
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
    	
    }
    
    public static void Draw(TeamRanking[] rank, Groups[] A, Groups[] B,Groups[] C, Groups[] D, Groups[] E) { //5 groups of 2 teams just to test it
    	int c=0;
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

    }

}
