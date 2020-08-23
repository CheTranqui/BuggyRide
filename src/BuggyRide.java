//	Created by: CheTranqui / Chaz Peterson
//	Enclosed is a text-based MUD experience.
//	Which option is "correct" depends upon the character you choose.
//	One of the three choices is ALWAYS wrong.
//	Current development: StageOne is complete.
//	If you want to see the correct answers, they are on the very last lines of this file.


import java.util.*;

public class BuggyRide {

	private static String character;

	public static void main(String[] args){
		
		setCharacterName();
		System.out.println("");
		System.out.println("You have selected " + character + ".");
		System.out.println("");
		
		
		boolean stageOneSuccess = stageOne();
		if (stageOneSuccess) {
			System.out.println("");
			System.out.println("Congratulations! You have selected properly.");
//			Display success message - check if Trinity or Neo first.
			if (character.equalsIgnoreCase("Trinity")) {
//				Trinity's win:
				System.out.println("Relying upon your strength, you boldly approach the bandit camp to the east.");
			} else {
//				Neo's win:
				System.out.println("Relying upon your intellect, you keep a distance from the fire and settle in to sleep.");
			}
			System.out.println("...more story to come in future weeks.");
			System.out.println("");

//			If stageOne is successful, proceed to stageTwo
			boolean stageTwoSuccess = stageTwo();

			if (stageTwoSuccess) {
				if (character.equalsIgnoreCase("Trinity")) {
//					Trinity's Stage Two Win message
					System.out.println("Relying upon what strength remains, you sprint wildly to the north.");
				} else {
//					Neo's Stage Two Win message
					System.out.println("Relying upon your wisdom, you turn off the game trail in search");
					System.out.println("of some berries and a place to rest for the night.");
				}

				//			If stageTwo is successful, proceed to stageThree
				boolean stageThreeSuccess = stageThree();
			}
		}
	}
	
//	Return the character chosen by the user.
	private static void setCharacterName() {
		System.out.println("");
		System.out.println("    T T T T     N    N");
		System.out.println("       T        N N  N");
		System.out.println("       T        N  N N");
		System.out.println("       T        N    N");
		System.out.println("");
		
		System.out.println("   Trinity solves problems with her fists.");
		System.out.println("   Neo solves problems with his mind.");
		System.out.println("");
		System.out.println("What would you like play as Trinity(1) or Neo(2)?");

//		create scanner and get string input from user
		String charChoice = getInput();

		if (charChoice.equalsIgnoreCase("1")
			|| charChoice.equalsIgnoreCase("Trinity")
			|| charChoice.equalsIgnoreCase("t")) {

			character = "Trinity";
		}
		else {
			character = "Neo";
		}
	}

	private static String getInput() {
		Scanner input = new Scanner(System.in);
		return input.next().toString();
	}
	
//	Each stage needs 3 choices:
//		1 bad one for both
//		1 good one for Trinity
//		1 good one for Neo
	private static boolean stageOne() {
//		stageOne's dialogue:
		System.out.println("");
		System.out.println("[Trailhead: Outcropping]");
		System.out.println("   Exhausted from a long day's travel, the sun is about to set");
		System.out.println("and the hunger pangs have become impossible to ignore. Sounds of");
		System.out.println("small wildlife come from the north. A rock outcropping with what");
		System.out.println("looks to be a long abandoned bedroll stands to your west and a");
		System.out.println("ribbon of smoke betrays a fire pit to the east.");
		System.out.println("    1. Go NORTH and investigate the wildlife");
		System.out.println("    2. Go WEST and set up camp in the rock outcropping");
		System.out.println("    3. Go EAST to investigate the fire pit and make dinner");
		
		String action = getInput();
		
//		First option is Neo's win.
		if (action.equalsIgnoreCase("1") || action.equalsIgnoreCase("NORTH")) {
			if (character.equalsIgnoreCase("Neo")){
				return true;
			}
			else {
				int option = 1;
				failStageOne(option);
				return false;
			}
		}
//		Third option is Trinity's win.
		if (action.equalsIgnoreCase("3") || action.equalsIgnoreCase("EAST")) {
			if (character.equalsIgnoreCase("Trinity")){
				return true;
			}
			else {
				int option = 2;
				failStageOne(option);
				return false;
			}
		}
//		Second option is failure for everyone.
//		if neither of the previous cases are returned:
		int option = 2;
		failStageOne(option);
		return false;
	}

	private static void failStageOne(int option){
		if (option == 1){
//			Trinity's failure on Stage 1:
			System.out.println("");
			System.out.println("[Northern Game Trail]");
			System.out.println("   Your attention drawn to the sounds of what seems to be a wild hog");
			System.out.println("in the distance, you failed to notice an edge of stone that rises");
			System.out.println("above the rest. You trip and attempt to catch yourself, but land hard");
			System.out.println("on your wrist. The hog gets scared off by your loud yelp. All that");
			System.out.println("remains now is to go back, sleep it off, and try again tomorrow.");
			System.out.println("");
			System.out.println("(Attempt failed - The answer is out there.)");
		}
		else if (option == 3) {
//			Neo's failure on Stage 1:
			System.out.println("");
			System.out.println("[Bandit Camp - Fire Pit]");
			System.out.println("   Scouting to the east you quickly catch wind of voices rising");
			System.out.println("from what seems to be a nightly feast. Smoke rises from a skewer");
			System.out.println("of rabbit and squirrel roasting over a small fire.");
			System.out.println("   After listening in on their conversation, you quickly realize");
			System.out.println("that this is the crew of bandits that slaughtered the family back in");
			System.out.println("Riverhaven. You quickly decide to get as far away as you can tonight,");
			System.out.println("but as you turn away a loud *SNAP* emanates from a dry twig underneath");
			System.out.println("your foot. The race is on! The bandits jump into action, spilling their");
			System.out.println("stew as they chase you down and haul you back to camp as prisoner.");
			System.out.println("");
			System.out.println("(Attempt failed - Should have chosen the other pill, Neo.)");

		}
//			Everyone's fail on Stage 1:
		else{
			System.out.println("");
			System.out.println("[Abandoned Outcropping]");
			System.out.println("   A summary investigation of the outcropping shows it to be abandoned.");
			System.out.println("Removing your pack and bedroll, you quickly settle in for a night's");
			System.out.println("sleep, but find it difficult with such a rumbling stomach. In time");
			System.out.println("you fall into a deep sleep.");
			System.out.println("   In the deepest dark of night you are rudely awoken by bandits who");
			System.out.println("have stumbled upon your tidy little outcropping. They quickly bind your");
			System.out.println("hands and haul you off to their camp near the fire pit to the east.");
			System.out.println("");
			System.out.println("(Attempt failed - Remember, it isn't the spoon that bends.)");
		}
	}

	private static boolean stageTwo(){
		if (character.equalsIgnoreCase("Trinity")){
			return stageTwoTrinity();
		}
		else {
			return stageTwoNeo();
		}
	}

	private static boolean stageTwoTrinity(){
		System.out.println("");
		System.out.println("[Bandit Camp - Fire Pit]");
		System.out.println("   Scouting to the east you quickly catch wind of voices rising");
		System.out.println("from what seems to be a nightly feast. Smoke rises from a skewer");
		System.out.println("of rabbit and squirrel roasting over a small fire.");
		System.out.println("   One of the bandits advances toward you as you enter the firelight");
		System.out.println("and loudly declares, \"Well what have we got here?\"");
		System.out.println("   Your reflexive instinct kicks into action and you clout the bandit");
		System.out.println("hard upside the head, causing him to fall to the side unconscious.");
		System.out.println("Taking advantage of the others' shock, you:");
		System.out.println("    1. Sprint NORTH and search for a place to hide along the local game trail");
		System.out.println("    2. Boldly PROCLAIM, \"Anybody else have a problem with me being here?\"");
		System.out.println("    3. BARTER your amulet for dinner");
		System.out.println("");

		String action = getInput();

//		Trinity's successful response:
		if (action.equalsIgnoreCase("1")
			|| action.equalsIgnoreCase("north")
			|| action.equalsIgnoreCase("hide")){
			return true;
		}
		else if (action.equalsIgnoreCase("2")
			|| action.equalsIgnoreCase("proclaim")){
			System.out.println("");
			System.out.println("[Bandit Camp - Fire Pit]");
			System.out.println("   Their leader grins at you, stands, and declares to the entire camp,");
			System.out.println("\"It looks like we have a visitor tonight, gentlemen. Let's say 'hi'.\"");
			System.out.println("Without warning, the entire camp turns on you and within moments you find");
			System.out.println("yourself on your back with the wind knocked out of you. The bandit on top");
			System.out.println("of you whispers in your ear, \"Say 'goodnight' sweetheart.\" and your vision");
			System.out.println("immediately goes black.");
			System.out.println("");
			System.out.println("(Attempt failed - The answer is out there, and it's looking for you.)");
			System.out.println("");
			return false;
		}
		else{
			System.out.println("");
			System.out.println("[Bandit Camp - Fire Pit");
			System.out.println("   With a quick jerk, you pull off your amulet and hold it out toward");
			System.out.println("the fire and declare, \"I need a meal. This should more than pay for it.\"");
			System.out.println("The bandit leader stands and waves you over, reaching out his hand for");
			System.out.println("the amulet. The moment your hand reaches his, he grasps it firmly and throws");
			System.out.println("you recklessly into a few others surrounding the fire. As if he were about");
			System.out.println("yours, boys!\"");
			System.out.println("");
			System.out.println("(Attempt failed - The answer is out there, and it's looking for you.)");
			return false;
		}
	}

	private static boolean stageTwoNeo(){
		System.out.println("");
		System.out.println("[Northern Game Trail]");
		System.out.println("   Recognizing your need for food, you continue down the game trail");
		System.out.println("in search of berries and small game. Coming across a small clearing");
		System.out.println("you realize that the sun is now almost completely set and it is almost");
		System.out.println("impossible to see the other side, despite it being only a few meters");
		System.out.println("across. There are what appear to be deer tracks heading to the west.");
		System.out.println("The sound of crickets rises all around you, the snuffling that drew");
		System.out.println("you here initially is no longer audible.");
		System.out.println("    1. CLIMB a tree, nock an arrow and wait for a deer to pass");
		System.out.println("    2. Find a place to REST nearby");
		System.out.println("    3. CONTINUE north along the game trail in search of berries");
		System.out.println("");

//		Get user's choice
		String action = getInput();
//		actions 1 and 3 are failures, 2 is the correct choice
		if (action.equalsIgnoreCase("1")
			|| action.equalsIgnoreCase("climb")) {
			System.out.println("");
			System.out.println("[Northern Game Trail - Birch Tree]");
			System.out.println("   Skirting the game trail for a good fifty meters, you find a");
			System.out.println("well formed birch tree with a good perch to rest on. Hiding your");
			System.out.println("pack among the underbrush, you climb up.");
			System.out.println("   A few hours drag on with no game wandering through and you drift");
			System.out.println("to sleep. Suddenly you're awoken by a snort from below. Forgetting");
			System.out.println("that you're in a tree, you promptly lose balance and fall several");
			System.out.println("meters landing hard on your side. A brief touch to your injured side");
			System.out.println("shows a small stream of blood coming from the puncture.");
			System.out.println("");
			System.out.println("(Attempt failed - Fate, it seems, is not without a sense of irony.");

			return false;
		}
		else{
			return true;
		}

	}

	private static boolean stageThree(){
//		if (character.equalsIgnoreCase("Trinity")){
//			return stageThreeTrinity();
//		}
//		else {
//			return stageThreeNeo();
//		}
//		temporary return statement to end program properly for now:
		return false;
	}


//		Trinity's Success Path:  1 (East to Bandits), 1 (North to Run),
//		Neo's Success Path:  1 (North toward wildlife), 2 or 3 (Rest or Berries)
}