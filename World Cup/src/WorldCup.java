import java.util.*;

public class WorldCup {

	public static void main(String[] args) {

		int s1 = 0; // Selection number from Main Menu
		int s2 = 0; // Selection number from Insert Teams Menu

		do {
			// main menu
			Display.MainMenu();
			s1 = UserInput.getInteger();

			switch (s1) {
			case 1:// insert teams
				do {
					Display.TeamMenu();
					s2 = UserInput.getInteger();

					switch (s2) {
					case 1:
						Checks.isFull();
					//	Display.InsertTeams();
						break;

					case 2:
						Checks.isEmpty();
						//Display.ShowTeams();
						break;
					}
				} while (s2 != 3);
				break;

			case 2:// Schedule of the tournament
				System.out.println("Under construction! I need to create the ranking system first!");
				break;

			case 3:// ranking
				Display.ShowRanking();
				break;

			case 4: // Simulate Menu
				// Simulate.GroupStageScore();
				// Simulate.setNewPoints();
				// Simulate.Roundof16();
				// Simulate.QuarterFinals();
				// Draw.DrawGroup();
			//	Schedule.GroupA();
				Schedule.ShowSchedule();
				break;
			}
		} while (s1 != 5);
		System.out.println("Bye! See you soon!");
	}
}