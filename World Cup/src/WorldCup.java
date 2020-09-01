import java.util.*;

public class WorldCup {

	public static void main(String[] args) {

		int s1 = 0; // Selection number for Main Menu
		int s11 = 0; // Selection number for Insert Team Menu
		int s2 = 0; // Selection number for Schedule Menu
		int s4 = 0; // Selection number for Simulate Menu
		int s5 = 0; // Selection number for Reset Menu

		do {
			// main menu
			Display.MainMenu();
			s1 = UserInput.getInteger();

			switch (s1) {
			case 1:// insert teams
				do {
					Display.TeamMenu();
					s11 = UserInput.getInteger();

					switch (s11) {
					case 1:
						Checks.isFull();
						// Display.InsertTeams();
						break;

					case 2:
						Checks.isEmpty();
						// Display.ShowTeams();
						break;
					}
				} while (s11 != 3);
				break;

			case 2: // Schedule of the tournament
				do { // na balo elegxous
					Display.Schedule();
					s2 = UserInput.getInteger();

					switch (s2) {
					case 1:
						Draw.DrawGroup();
						Schedule.Groups();
						break;
					case 2:
						Schedule.RoundOf16();
						break;
					case 3:
						Schedule.QuarterFinals();
						break;
					case 4:
						Schedule.SemiFinals();
						break;
					case 5:
						Schedule.Final();
						break;
					}
				} while (s2 != 6);
				break;

			case 3: // ranking
				Display.ShowRanking();
				break;

			case 4: // Simulate Menu
				do { // na balo elegxous
					Display.Simulate();
					s4 = UserInput.getInteger();

					switch (s4) {
					case 1:
						Simulate.GroupStageScore();
						GroupStage.GroupPointsUpdate();
						GroupStage.OrderByPoints();
						break;
					case 2:
						Simulate.Roundof16();
						break;
					case 3:
						Simulate.QuarterFinals();
						break;
					case 4:
						Simulate.SemiFinals();
						break;
					case 5:
						Simulate.Final();
						break;
					}
				} while (s4 != 6);
				break;

			case 5:
				Display.Reset();
				s5 = UserInput.getInteger();
				if (s5 == 1) {
					Reset.ResetAll();
				}
			}
		} while (s1 != 6);
		System.out.println("Bye! See you soon!");
	}
}