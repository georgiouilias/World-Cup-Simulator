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
						// Display.InsertTeams();
						break;

					case 2:
						Checks.isEmpty();
						// Display.ShowTeams();
						break;
					}
				} while (s2 != 3);
				break;

			case 2: // Schedule of the tournament
				// Schedule.Groups();
				// Schedule.RoundOf16();
				// Schedule.QuarterFinals();
				// Schedule.SemiFinals();
				// Schedule.Final();
				// Schedule.ShowSchedule();
				break;

			case 3: // ranking
				// Display.ShowRanking();
				FIFAPoints.GroupStagePoints();
				break;

			case 4: // Simulate Menu
				// GroupStage.GroupPointsUpdate();
				// GroupStage.OrderByPoints();
				// Simulate.GroupStageScore();
				// Simulate.setNewPoints();
				// Simulate.Roundof16();
				// Simulate.QuarterFinals();
				// Simulate.SemiFinals();
				// Simulate.Final();
				// Draw.DrawGroup();
				break;
			}
		} while (s1 != 5);
		System.out.println("Bye! See you soon!");
	}
}