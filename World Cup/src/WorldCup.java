import java.util.*;

public class WorldCup {

	public static void main(String[] args) {
		
		int s1=0; //Selection number from Main Menu
		int s2=0; //Selection number from Insert Teams Menu
		
		Teams teams[] = new Teams[2];//32 Countries in the tournament
		TeamRanking rank[] = new TeamRanking[10]; //210 SINOLO
		TeamRanking.Ranking(rank);
		
    	Groups A[] = new Groups[2];
    	Groups B[] = new Groups[2];
    	Groups C[] = new Groups[2];
    	Groups D[] = new Groups[2];
    	Groups E[] = new Groups[2];

		
		do {
			//main menu
			Display.MainMenu();
			s1 = UserInput.getInteger();
			
			switch(s1) {
			case 1://insert teams
				do{
					Display.TeamMenu();
					s2 = UserInput.getInteger();
					
					switch(s2) {
					case 1: 
						if(Teams.isEmpty(teams) == true) {
							Display.InsertTeams(teams);
							break;
						}
						else {
							System.out.println("Teams are already inserted");
							break;
						}
					case 2:
						Display.ShowTeams();
						break;
						}
				}while(s2!=3);
				break;
				
			case 2://Schedule of the tournament
				System.out.println("Under construction! I need to create the ranking system first!");
				break;
				
			case 3://ranking
				Display.ShowRanking();
				break;
				
			case 4: //Simulate Menu
			//  System.out.println("Under construction! I need to create the ranking system first!");
			//	Simulate.GroupStageScore();
			//	Simulate.setNewPoints();
			//	Simulate.Roundof16();
			//	Simulate.Draw(rank,A,B,C,D,E);
				break;
			}
		}while(s1!=5);
	}
}