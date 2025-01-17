package javapokemon;

import java.util.*; // imports scanner class (for user input) , random class (for pokemon random hijinx) 

 
// This is where we get the information for pokemon
//possible pokemon list (insert possible pokemon array here (commented out)

  /*	String[] possiblepokemon = {"metagross", "gliscor", "excadrill", "arcanine", "krookodile", "feraligatr", "gyarados",
			"starmie", "gengar", "espeon", "jolteon", "glaceon", "archeops",
			"umbreon", "leafeon", "vaporeon", "flareon", "sylveon", "scizor", "hydreigon",
			"meloetta", "crobat", "manaphy", "jirachi", "melmetal", "machamp", "milotic",
			"kingdra", "salamence", "dragonite", "chandelure", "greninja",
			"zeraora", "togekiss", "volcarona",
			"pikachu", "mimikyu",
			"noivern", "hawlucha",
			"zoroark",
			"garchomp", "tyranitar", "lucario", "flygon", "dragapult",
			"goodra",
			"golisopod", "sceptile", "roserade", "mewtwo", "charizard",
			"talonflame", "snorlax",
			"infernape", "weavile",
			"giratina-altered", "giratina-origin",
			"rayquaza", "kyogre", "groudon",
			"gardevoir", "gallade",





			};

*/
public class pokemon {

	// the core requirements (pokemon stats) of the pokemon class
	int attack;  //A pokemon's attack stat
	double hp;   // A pokeomn's hp stat
	int speed; // A pokemon's speed stat
	int def; // A pokemon's defense stat
	int spdef;    // A pokemon's special defense stat
	int spa;  // A pokemon's special attack stat
	String type1; // pokemon type
	String type2; // pokemon second type
	String pokename; // name of the pokemon

	double maxhp; // maximum hp (for healing moves)
	String ability;  // ability
	String abilityexplain; // their ability explained
	String status = " No status conditions"; // Status contition (Poisoned, Paralyzed, Frozen, Burned, Toxic)

	int toxiccounter = 1; // How many turns the user has been poisoned


	boolean guts = false; // shows whether guts is activated
	boolean marvelscale = false; // shows whether marvelscale has activated
	boolean quickfeet = false; // shows whether quick feet ability activates

	boolean confused = false;  // based value of confusion
	boolean flinched = false; // flinch
	boolean roost = false; // whether you lose your flying type or not during roost
	boolean aquaring = false;    // whether you have an aquaring or not
	boolean drowsy = false; // Whether yawn makes you sleep
	boolean charging = false; // whether someone is recharging from hyperbeam
	boolean relic = false; //whether meloetta is in its aria or parriouette form
	boolean bounce = false; //whether you are bounced in the air when using bounce, broken for now, bounce can not be used due to bugs
	boolean intimidate = false;  // checks if a pokemon's intimidate has taken affect yet

	boolean disguise = true; // used for the ability disguise
	String call = "";

	boolean endtheme = false;
	int frozencounter = 0; // how many turns you're frozen
	int sleepcounter = 0; // how many turns your'e asleep
	// names of the moves, not the moves themselves
	String move1name;  // Names of the four moves of the pokemon
	String move2name;
	String move3name;
	String move4name;


	//  String status;
	// boolean status;   This could be a variable to see the status conditions the user has (like bouncing in the air, poison, confuse, paralysis, burn, flinch, sleep,

	// move objects????

	move move1; // Move objects (with move properties as outlined in the move.java file)
	move move2;
	move move3;
	move move4;


	static Scanner scan = new Scanner(System.in); // makes a new scanner called scan , it is static meaning that it is used in every function in this java file


	// this tests if the move or abbreviation is in the arrays that are sent to this legit move function

	private boolean legitmove1(String[] possiblemoves, String[] abbreviations, String testmove) { // It is so cool that I can pass arrays as arguments in java, sadly i cant do it in c++ lol
		boolean test = false;

		for (int i = 0; i < abbreviations.length; i++) {

			if (possiblemoves[i].equals(testmove)) {

				test = true;
				break;

			} else if (abbreviations[i].equals(testmove)) {
				test = true;
				break;

			}


		}


		return test;

	}


	// different move constructors for each move

	public String getmovename(String player, String pokemonname) {


		String mv1 = "one"; // this is the way i tested how different constructors worked, mv stands for move name

		System.out.println(player + "'s " + pokemonname + " has the ability to learn four of these moves. Please input a move or the letters next to the move");
		System.out.println("For example: [meteormash mm] (You can input 'meteormash' or 'mm') \n ");


		if (pokemonname.equals("metagross")) {

			String[] possiblemoves = {"meteormash", "zenheadbut", "thunderpunch", "icepunch", "rockslide", "return", "earthquake", "bulletpunch"}; // array of possible moves for this pokemon
			String[] abbreviated = {"mm", "zh", "tp", "ip", "rs", "re", "ea", "bp"};// array of the abbreviated moves
			String[] explain = {"[A 90 base power physical steel move with 90 accuracy and has a 10 percent chance to increase attack]", "[ A 85 base physical psychic move with 90 accuracy]", "[A punch of electricity, has a 10 percent chance to paralyze]", "[a punch of icy coldness, 10 percent chance to freeze]", "[a lot of rocks are slammed on the opponent , 30% chance to flinch ]", "[a 102 base power normal physical attack]", "[a 100 base ground move]", "[User ussually goes first in dishing out the 40 power steel bash]"};
			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv1 = scan.nextLine();

			while (legitmove1(possiblemoves, abbreviated, mv1) != true) { // sends arrays and the mv1 input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv1 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv1.equals(abbreviated[o])) {

					mv1 = possiblemoves[o];
				}


			}

		} else if (pokemonname.equals("gliscor")) {

			String[] possiblemoves = {"toxic", "earthquake", "rockslide", "firefang", "thunderfang", "icefang", "swordsdance"}; // array of possible moves for this pokemon
			String[] abbreviated = {"tx", "ea", "rs", "ff", "tf", "if", "sd"};// array of the abbreviated moves
			String[] explain = {"[this move poisons the opponent and the poison damage increases over time(poison types can't miss)]", "[a 100 base power physical ground move]", "[a 75 power, 95 accuracy rock move that can flinch 30 % of the time, user slams rocks on opponent.] ", " [a 65 power physical fire move (95 accuracy) 10 percent chance to burn or flinch]", " [a 65 power physical electric move (95 accuracy) 10 percent chance to paralyze or flinch] ", " [a 65 power physical ice move (95 accuracy) 10 percent chance to freeze or flinch ]", "[sharply raises user's attack ]"};

			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv1 = scan.nextLine();

			while (legitmove1(possiblemoves, abbreviated, mv1) != true) { // sends arrays and the mv1 input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv1 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv1.equals(abbreviated[o])) {

					mv1 = possiblemoves[o];
				}


			}

		} else if (pokemonname.equals("excadrill")) {

			String[] possiblemoves = {"honeclaws", "earthquake", "ironhead", "rockslide", "horndrill", "brickbreak", "swordsdance", "poisonjab"}; // array of possible moves for this pokemon
			String[] abbreviated = {"hc", "ea", "ih", "rs", "hd", "bb", "sd", "pj"};// array of the abbreviated moves
			String[] explain = {"[Raises accuracy of attacks and increases their power]", " [a 100 base power physical ground move]", "[an 80 power steel move with a 30% chance to flinch ]", "[a lot of rocks are slammed on the opponent , 30% chance to flinch ] ", " [Has a 30 percent chance to one-shot the opponent, can't hit ghosts]", "[ a 75 base power fighting move] ", " [sharply raises the user's attack] ", "[the user jabs the opponent with poison, 30 % chance to poison] "};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv1 = scan.nextLine();

			while (legitmove1(possiblemoves, abbreviated, mv1) != true) { // sends arrays and the mv1 input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv1 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv1.equals(abbreviated[o])) {

					mv1 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("arcanine")) {

			String[] possiblemoves = {"closecombat", "flareblitz", "crunch", "extremespeed", "willowisp", "morningsun", "ironhead", "wildcharge"}; // array of possible moves for this pokemon
			String[] abbreviated = {"cc", "fb", "cr", "es", "ww", "ms", "ih", "wc"};// array of the abbreviated moves
			String[] explain = {"[A 120 power fighting move, reduces the user's defense and special defense]", "[A 120 base power physical fire move but the user takes 1/3 of the damage as recoil] ", " [an 80 power dark physical move that has a 20 percent chance for a defense drop] ", " [80 base power normal move that always moves first] ", " [has a 90 percent chance to burn the opponent] ", " [heals user by half of its max hp] ", " [an 80 power steel move with a 30% chance to flinch ] ", " [A 90 power electric physical attack, user takes 1/3 recoil]"};

			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv1 = scan.nextLine();

			while (legitmove1(possiblemoves, abbreviated, mv1) != true) { // sends arrays and the mv1 input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv1 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv1.equals(abbreviated[o])) {

					mv1 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("krookodile")) {

			String[] possiblemoves = {"firefang", "thunderfang", "dragonclaw", "rockslide", "brickbreak", "earthquake", "crunch"}; // array of possible moves for this pokemon
			String[] abbreviated = {"ff", "tf", "dc", "rs", "bb", "ea", "cr"};// array of the abbreviated moves
			String[] explain = {"[a 65 power physical fire move (95 accuracy) 10 percent chance to burn or flinch]", "  [a 65 power physical electric move (95 accuracy) 10 percent chance to paralyze or flinch] ", " [an 80 base power dragon type move] ", " [a lot of rocks are slammed on the opponent , 30% chance to flinch ] ", " [ a 75 base power fighting move] ", " [a 100 base ground move] ", " [an 80 power dark move that crunches opponent, 20 percent chance for defense drop] "};

			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv1 = scan.nextLine();

			while (legitmove1(possiblemoves, abbreviated, mv1) != true) { // sends arrays and the mv1 input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv1 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv1.equals(abbreviated[o])) {

					mv1 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("feraligatr")) {

			String[] possiblemoves = {"dragondance", "aquajet", "superpower", "waterfall", "icepunch", "earthquake", "dragonclaw", "crunch"}; // array of possible moves for this pokemon
			String[] abbreviated = {"dd", "aj", "sp", "wf", "ip", "ea", "dc", "cr"};// array of the abbreviated moves
			String[] explain = {"[boosts attack and speed]", " [a 40 base power physical priority water move]  ", " [a 120 base power fighting move that reduces attack and defense of the user] ", " [an 80 base power water move (with sheerforce it will be 110)] ", " [a punch of icy coldness, 10 percent chance to freeze] ", "[a 100 base power physical ground move]  ", " [an 80 base power dragon move] ", " [an 80 base power dark move and it has a 20 percent chance to reduce defense] "};

			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv1 = scan.nextLine();

			while (legitmove1(possiblemoves, abbreviated, mv1) != true) { // sends arrays and the mv1 input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv1 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv1.equals(abbreviated[o])) {

					mv1 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("gyarados")) {
			String[] possiblemoves = {"dragondance", "icefang", "waterfall", "return", "irontail", "stoneedge", "earthquake"}; // array of possible moves for this pokemon
			String[] abbreviated = {"dd", "if", "wf", "re", "it", "se", "ea"};// array of the abbreviated moves
			String[] explain = {"[boosts attack and speed]", "[a 65 power physical ice move (95 accuracy) 10 percent chance to freeze or flinch ] ", "  [an 80 base power water move with a 20 percent chance to flinch] ", " [a 102 base power normal physical attack] ", " [A steel move that has 75 percent accuracy ]",
					"[The user snipes the opponent with stones (rock move, 100 base power, 80 accuracy]  ", " [ A 100 base power ground type move  with 100 accuracy] "};


		for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv1 = scan.nextLine();

			while (legitmove1(possiblemoves, abbreviated, mv1) != true) { // sends arrays and the mv1 input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv1 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv1.equals(abbreviated[o])) {

					mv1 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("starmie")) {
			String[] possiblemoves = {"thunderbolt", "psychic", "hydropump", "surf", "icebeam", "confuseray", "recover"}; // array of possible moves for this pokemon
			String[] abbreviated = {"tb", "ps", "hp", "su", "ib", "cr", "re"};// array of the abbreviated moves
			String[] explain = {"[The user zaps the opponent with electricity, 90 base power move, 10 % chance to paralyze]", " [90 base power psychic move with 100 accuracy] ", " [A 110 power water move that has 80 accuracy] ", "[A 95 power water move with 100 accuracy]  ", " [An icy beam is shot at the opponent, ice type 90 base power, 10% chance to freeze] ", " [confuses the opponent ]  ", " The user heals itself by 1/2 of its max hp] "};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv1 = scan.nextLine();

			while (legitmove1(possiblemoves, abbreviated, mv1) != true) { // sends arrays and the mv1 input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv1 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv1.equals(abbreviated[o])) {

					mv1 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("gengar")) {

			String[] possiblemoves = {"toxic", "confuseray", "shadowball", "sludgebomb", "suckerpunch", "focusblast", "thunderbolt",}; // array of possible moves for this pokemon
			String[] abbreviated = {"tx", "cr", "sb", "su", "sp", "fb", "tb"};// array of the abbreviated moves
			String[] explain = {"[this move poisons the opponent and the poison damage increases over time(poison types can't miss)]", " [confuses the opponent]", " [an 80 power ghost move , 30 % chance for opposing spdef reduction] ", "[an 85 base power poison move with a 30% chance to poison]  ", " [An 80 base power move that only works if the opponent uses an attack]", " [A 120 base power fighting move with 70 accuracy] ", " [ A zap of electricity at the opponent, a 90 power electic move with 100 accuracy]"};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv1 = scan.nextLine();

			while (legitmove1(possiblemoves, abbreviated, mv1) != true) { // sends arrays and the mv1 input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv1 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv1.equals(abbreviated[o])) {

					mv1 = possiblemoves[o];
				}


			}

		} else if (pokemonname.equals("espeon")) {
			String[] possiblemoves = {"psychic", "shadowball", "quickattack", "calmmind", "dazzlinggleam", "hiddenpower", "morningsun"}; // array of possible moves for this pokemon
			String[] abbreviated = {"ps", "sb", "qa", "cm", "dg", "hp", "ms"};// array of the abbreviated moves
			String[] explain = {" [A 90 base power psychic move with a 10% chance of a reduction in opponent's spdef] ", " [an 80 base power ghost move with a 30% chance to reduce opponent spdef] ", " [a 40 base power move that usually hits first] ", "[raises special attack and special defense] ", "[An 80 base power fairy move]  ", "[A 60 base power move that can be any type the user desires] ", " [User heals itself by 1/2 of its max hp ]"};

			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv1 = scan.nextLine();

			while (legitmove1(possiblemoves, abbreviated, mv1) != true) { // sends arrays and the mv1 input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv1 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv1.equals(abbreviated[o])) {

					mv1 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("jolteon")) {

			String[] possiblemoves = {"thunderbolt", "shadowball", "hiddenpower", "toxic", "pinmissle", "doublekick", "thunderwave"}; // array of possible moves for this pokemon
			String[] abbreviated = {"tb", "sb", "hp", "tx", "pm", "dk", "tw"};// array of the abbreviated moves
			String[] explain = {" [A 90 base power electric attack with a 10 % chance of paralysis]", "[a 80 power ghost special move with a 30 percent chance to reduce spdef]  ", " [A 60 base power move that can be any type the user desires]  ", " [this move poisons the opponent and the poison damage increases over time(poison types can't miss)] ", " [A physical bug move that can be 15,30,45,60,0r 75 base power]  ", " [A 60 base power physical fighting move] ", " [Has a 90 percent chance to paralyze opponent] "};

			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv1 = scan.nextLine();

			while (legitmove1(possiblemoves, abbreviated, mv1) != true) { // sends arrays and the mv1 input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv1 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv1.equals(abbreviated[o])) {

					mv1 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("glaceon")) {
			String[] possiblemoves = {"icebeam", "hiddenpower", "shadowball", "iceshard", "waterpulse", "blizzard", "toxic"}; // array of possible moves for this pokemon
			String[] abbreviated = {"ib", "hp", "sb", "is", "wp", "bz", "tx"};// array of the abbreviated moves
			String[] explain = {" [A beam of ice that is shot at the opponent, 90 base power ,10% chance to freeze] ", "[A 60 base power move that can be any type the user desires] ", "[ An 80 base power ghost move with a 30 % chance to spdef drop]  ", "[A fast ice type physical attack, 40 base power]  ", "[A  60 base power water move with a 20 percent chance to confuse the opponent]  ", "[A 110 base power ice move with 70 accuracy] ", "[this move poisons the opponent and the poison damage increases over time(poison types can't miss)]  "};

			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv1 = scan.nextLine();

			while (legitmove1(possiblemoves, abbreviated, mv1) != true) { // sends arrays and the mv1 input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv1 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv1.equals(abbreviated[o])) {

					mv1 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("sylveon")) {
			String[] possiblemoves = {"moonblast", "hyperbeam", "shadowball", "calmmind", "toxic", "dazzlinggleam", "hiddenpower"}; // array of possible moves for this pokemon
			String[] abbreviated = {"mb", "hb", "sb", "cm", "tx", "dg", "hp"};// array of the abbreviated moves
			String[] explain = {"[A 95 base power fairy move with a 30% chance to reduce special attack] ", " [A fairy beam (reference to pixilate) is shot at the opponent, 150 base power, 90 accuracy , one turn recharge]  ", " [An 80 power ghost move that reduces spdef 30% of the time] ", " [raises special attack and special defense] ", " [this move poisons the opponent and the poison damage increases over time(poison types can't miss)] ", "[ An 80 base power fairy move] ", " [A 60 base power move that can be any type the user desires]  "};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv1 = scan.nextLine();

			while (legitmove1(possiblemoves, abbreviated, mv1) != true) { // sends arrays and the mv1 input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv1 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv1.equals(abbreviated[o])) {

					mv1 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("umbreon")) {
			String[] possiblemoves = {"toxic", "moonlight", "quickattack", "confuseray", "hiddenpower", "darkpulse", "foulplay"}; // array of possible moves for this pokemon
			String[] abbreviated = {"tx", "ml", "qa", "cr", "hp", "dp", "fp"};// array of the abbreviated moves
			String[] explain = {" [this move poisons the opponent and the poison damage increases over time(poison types can't miss)] ", " [[Heals user by 1/2 of max hp] ", " [40 base power fast normal move] ", " [confuses the opponent] ", "[A 60 base power move that can be any type the user desires]   ", " [An 80 base power dark move with a 10% chance to flinch] ", " [An 80 base power move that uses the opponents attack]"};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv1 = scan.nextLine();

			while (legitmove1(possiblemoves, abbreviated, mv1) != true) { // sends arrays and the mv1 input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv1 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv1.equals(abbreviated[o])) {

					mv1 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("leafeon")) {

			String[] possiblemoves = {"swordsdance", "leafblade", "toxic", "return", "xscissor", "synthesis", "aerialace"}; // array of possible moves for this pokemon
			String[] abbreviated = {"sd", "lb", "tx", "re", "xs", "sy", "aa"};// array of the abbreviated moves
			String[] explain = {"[Sharply raises attack]", " [A grass attack with a higher chance of crits, 70 base power] ", " [this move poisons the opponent and the poison damage increases over time(poison types can't miss)] ", "[a 102 base power normal physical attack]  ", "[80 base power bug move]  ", " [User recovers 1/2 of its max hp] ", " [60 base power flying move that never misses] "};
			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv1 = scan.nextLine();

			while (legitmove1(possiblemoves, abbreviated, mv1) != true) { // sends arrays and the mv1 input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv1 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv1.equals(abbreviated[o])) {

					mv1 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("vaporeon")) {


			String[] possiblemoves = {"hydropump", "icebeam", "aquaring", "toxic", "hiddenpower", "shadowball", "surf"}; // array of possible moves for this pokemon
			String[] abbreviated = {"hd", "ib", "ar", "tx", "hp", "sb", "su"};// array of the abbreviated moves
			String[] explain = {"[A 110 base power water move, 80 accuracy]   ", " [A 90 base power ice move with 10% chance to freeze] ", " [The user starts gaining a little hp every turn] ", " [this move poisons the opponent and the poison damage increases over time(poison types can't miss)] ", " [A 60 base power move that can be any type the user desires]  ", " [A base 80 power ghost move, 30% chance to reduce spdef] ", " [A 95 base power water move] "};
			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv1 = scan.nextLine();

			while (legitmove1(possiblemoves, abbreviated, mv1) != true) { // sends arrays and the mv1 input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv1 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv1.equals(abbreviated[o])) {

					mv1 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("flareon")) {
			String[] possiblemoves = {"flareblitz", "bulkup", "toxic", "willowisp", "return", "hiddenpower", "superpower"}; // array of possible moves for this pokemon
			String[] abbreviated = {"fb", "bu", "tx", "ww", "re", "hp", "sp"};// array of the abbreviated moves
			String[] explain = {" [A 120 base power physical fire move but the user takes 1/3 of the damage as recoil] ", " [raises this pokemon's attack and defense] ", " [this move poisons the opponent and the poison damage increases over time(poison types can't miss)] ", " [burns the opponent 85 percent of the time] ", " [a 102 base power normal physical attack] ", " [A 60 base power move that can be any type the user desires]  ", " [A 120 power fighting move that reduces the user's attack and defense] "};
			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv1 = scan.nextLine();

			while (legitmove1(possiblemoves, abbreviated, mv1) != true) { // sends arrays and the mv1 input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv1 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv1.equals(abbreviated[o])) {

					mv1 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("scizor")) {


			String[] possiblemoves = {"bulletpunch", "nightslash", "xscissor", "slash", "quickattack", "gigaimpact", "swordsdance"}; // array of possible moves for this pokemon
			String[] abbreviated = {"bp", "ns", "xs", "s", "qa", "qi", "sd"};// array of the abbreviated moves
			String[] explain = {" [A 40 base power steel move that often moves first] ", "  [A 70 base power dark move with a higher chance of crits]  ", " [An 80 base power bug move] ", " [A 70 base power normal move with a higher chance of crits] ", "  [A 40 base power normal move that often moves first]", "[A 150 base power normal move, recharge required]  ", " [Sharply raises attack] "};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv1 = scan.nextLine();

			while (legitmove1(possiblemoves, abbreviated, mv1) != true) { // sends arrays and the mv1 input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv1 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv1.equals(abbreviated[o])) {

					mv1 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("hydreigon")) {
			String[] possiblemoves = {"nastyplot", "dragonpulse", "flashcannon", "flamethrower", "surf", "darkpulse", "dracometeor"}; // array of possible moves for this pokemon
			String[] abbreviated = {"np", "dp", "fc", "ft", "su", "dpu", "dm"};// array of the abbreviated moves
			String[] explain = {" [Sharply raises special attack] ", "[An 80 power base dragon move]  ", " [A 90 base power steel move] ", " [A 95 base power fire move with a 10% chance to burn] ", " [A 95 base power water move] ", " [An 80 base power dark move with a chance to flinch(20 %)] ", " [A 120 base power special dragon move, reduces the user's special attack] "};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv1 = scan.nextLine();

			while (legitmove1(possiblemoves, abbreviated, mv1) != true) { // sends arrays and the mv1 input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv1 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv1.equals(abbreviated[o])) {

					mv1 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("meloetta")) {
			String[] possiblemoves = {"workup", "relicsong", "psychic", "closecombat", "thunderbolt", "icepunch", "firepunch"}; // array of possible moves for this pokemon
			String[] abbreviated = {"wu", "rs", "ps", "cc", "tb", "ip", "fp"};// array of the abbreviated moves
			String[] explain = {" [increases attack and special attack]", "[A 80 base power move that changes meloetta to pirouette form with different stats] ", " [A 90 base power psychic move with a 10 % to reduce spdef] ", " [A 120 base power fighting move that reduces spdef and def] ", "[A zap of electricity (90 power); 10% chance to paralyze ", "[a punch of icy coldness, 75 base power; 10 percent chance to freeze]  ", "[A punch of fiery wrath;75 base power; 10 percent chance to burn]  "};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv1 = scan.nextLine();

			while (legitmove1(possiblemoves, abbreviated, mv1) != true) { // sends arrays and the mv1 input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv1 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv1.equals(abbreviated[o])) {

					mv1 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("archeops")) {
			String[] possiblemoves = {"honeclaws", "earthquake", "rockslide", "stoneedge", "crunch", "dragonclaw", "aquatail"}; // array of possible moves for this pokemon
			String[] abbreviated = {"hc", "ea", "rs", "se", "cr", "dc", "at"};// array of the abbreviated moves
			String[] explain = {" [Raises attack and accuracy] ", " [A 100 base power ground move] ", " [a lot of rocks are slammed on the opponent , 30% chance to flinch ] ", " [A 100 base power rock move with a higher chance of crits and 80 accuracy] ", " [An 80 base power dark move; 10% chance to flinch] ", " [An 80 base power dragon pulse] ", " [A move that has a 90% chance to hit with 90 water based power]"};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv1 = scan.nextLine();

			while (legitmove1(possiblemoves, abbreviated, mv1) != true) { // sends arrays and the mv1 input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv1 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv1.equals(abbreviated[o])) {

					mv1 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("crobat")) {


			String[] possiblemoves = {"bravebird", "crosspoison", "confuseray", "toxic", "superfang", "leechlife", "steelwing", "roost"}; // array of possible moves for this pokemon
			String[] abbreviated = {"bb", "cp", "cr", "tx", "sf", "ll", "sw", "ro"};// array of the abbreviated moves
			String[] explain = {" [A 120 base power flying move, user takes 1/3 recoil]", "[an 80 base power poison move with a high crit rate ]", "[Confuses the opponent]", "[the opponent is poisoned and takes more damage over time  ] ", " [The opponent loses half of its health ]", "[ a 80 base power bug move, user regains 1/2 of damage as hp] ", " [sharp steel wings are slashed at the opponent, 70 power 90 accuracy] ", "[the user roosts and regains hp, user loses flying temporarily] "};

			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv1 = scan.nextLine();

			while (legitmove1(possiblemoves, abbreviated, mv1) != true) { // sends arrays and the mv1 input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv1 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv1.equals(abbreviated[o])) {

					mv1 = possiblemoves[o];
				}


			}

		} else if (pokemonname.equals("manaphy")) {

			String[] possiblemoves = {"tailglow", "surf", "energyball",  "shadowball", "psychic", "dazzlinggleam", "icebeam"}; // array of possible moves for this pokemon
			String[] abbreviated = {"tg", "su", "eb", "sb", "ps", "dg", "ib"};// array of the abbreviated moves
			String[] explain = {" [An over powered move that boosts the special attack of the user. Manaphy's secret weapon]",
					"[A wave of water washes the opponent, 95 power move ]",
					"[A ball of grassy naturs hits the opponent, 90 power, 20% of a spdef drop]",
					" [A shadowball sniped the opponent, ghost 80 power move with a 30% chance of a spdef drop]", "[ A psychic wave is shot at the opponent, 90 power, 10% for a special def drop] ", " [A bright light hits the opponent, an 80 power fairy move] ", "[An icy beam hits the oponent, 90 power, 20% chance of freeze] "};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv1 = scan.nextLine();

			while (legitmove1(possiblemoves, abbreviated, mv1) != true) { // sends arrays and the mv1 input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv1 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv1.equals(abbreviated[o])) {

					mv1 = possiblemoves[o];
				}


			}

		} else if (pokemonname.equals("jirachi")) {


			String[] possiblemoves = {"thunderwave", "ironhead", "firepunch", "icepunch", "thunderbolt", "psychic", "dazzlinggleam", "calmmind"}; // array of possible moves for this pokemon
			String[] abbreviated = {"tw", "ih", "fp", "ip", "tb", "ps", "dg", "cm"};// array of the abbreviated moves
			String[] explain = {" [paralyzes the opponent, Can help in para-flinching]", "[user bashes opponent with a steel head, 80 power move, 30% chance to flinch]", "[The opponent is hit with a fiery punch, 75 power 20% chance to burn]", "[the user hits the opponent with an icy punch, 75 power 20% chance to freeze] ", " [The opponent is hit with a lightningbolt 90 power 20% chance to paralyze]", "[ A psychic wave is shot at the opponent, 90 power, 10% for a special def drop] ", " [A bright light hits the opponent, an 80 power fairy move] ", "[The user focuses and increases its special attack and special defense] "};

			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv1 = scan.nextLine();

			while (legitmove1(possiblemoves, abbreviated, mv1) != true) { // sends arrays and the mv1 input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv1 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv1.equals(abbreviated[o])) {

					mv1 = possiblemoves[o];
				}


			}

		} else if (pokemonname.equals("melmetal")) {


			String[] possiblemoves = {"thunderpunch", "thunderwave", "doubleironbash", "superpower", "icepunch", "earthquake", "rockslide"}; // array of possible moves for this pokemon
			String[] abbreviated = {"tp", "tw", "db", "sp", "ip", "e", "rs"};// array of the abbreviated moves
			String[] explain = {"[The opponent is hit with an electriv punch, 75 power, 10% chance to paralyze]", " [paralyzes the opponent, Can help in para-flinching]", "[user bashes opponent with big boi arms , 120 power move]", "[The opponent is hit with secret fighting power, 120 power, reduces attack and defense]", "[the user hits the opponent with an icy punch, 75 power 20% chance to freeze] ", " [The opponent is hit with an earthquake]", "[ The user slams rocks on the opponent, 75 power, 30% chance to flinch, 95 accuracy] "};

			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv1 = scan.nextLine();

			while (legitmove1(possiblemoves, abbreviated, mv1) != true) { // sends arrays and the mv1 input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv1 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv1.equals(abbreviated[o])) {

					mv1 = possiblemoves[o];
				}


			}

		} else if (pokemonname.equals("kingdra")) {



			String[] possiblemoves = {"waterfall", "dragondance", "hydropump", "dragonpulse", "flashcannon", "bodyslam", "yawn", "focusenergy"}; // array of possible moves for this pokemon
			String[] abbreviated = {"wf","dd", "hp", "dp", "fc", "bs", "y", "fe"};// array of the abbreviated moves
			String[] explain = {"[An 80 base power physical water move]", "[boosts attack and speed]", "[user hits the target with a 110 power water type move]", "[An 80 power dragon move]", "[The opponent is hit with a steel beam, 90 power, has a chance of reducing spdef]", "[the user hits the opponent with its body, 80 power 30% chance to paralyse the opponent] ", " [The user makes the opponent tired and sleep after one turn]", "[ Increases the chances of crits] "};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv1 = scan.nextLine();

			while (legitmove1(possiblemoves, abbreviated, mv1) != true) { // sends arrays and the mv1 input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv1 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv1.equals(abbreviated[o])) {

					mv1 = possiblemoves[o];
				}


			}

		} else if (pokemonname.equals("machamp")) {

			String[] possiblemoves = {"bulkup", "dynamicpunch", "crosschop", "bulletpunch", "firepunch", "icepunch", "thunderpunch", "focusenergy"}; // array of possible moves for this pokemon
			String[] abbreviated = {"bu", "dp", "cc", "bp", "fp", "ip", "tp", "fe"};// array of the abbreviated moves
			String[] explain = {"[raises attack and defense]", " [Machamp bashes its opponent with a 100 power move that confuses the opponent]", "[user hits the target with a 100 power fighting type high crit rate move]", "[An 40 power steel priority move]", "[The opponent is hit with a fiery punch, 75 power, 10% chance to burn]", "[the user hits an icy punch, 75 power, 10% chance to freeze] ", " [The user uses an electric punch to hit the opponent, 75 power; 10% chance to paralyze]", "[ Increases the chances of crits] "};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv1 = scan.nextLine();

			while (legitmove1(possiblemoves, abbreviated, mv1) != true) { // sends arrays and the mv1 input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv1 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv1.equals(abbreviated[o])) {

					mv1 = possiblemoves[o];
				}


			}

		} else if (pokemonname.equals("milotic")) {

			String[] possiblemoves = {"hydropump", "aquaring", "toxic", "confuseray", "icebeam", "recover", "hiddenpower"}; // array of possible moves for this pokemon
			String[] abbreviated = {"hy", "aq", "tx", "cr", "ib", "re", "hp"};// array of the abbreviated moves
			String[] explain = {" [the user attacks with a 110 water power move]", "[user starts regaining hp every turn]", "[Poisons the opponent and makes them take more damage over time]", "[ Confuses the opponent]", "[the user hits an icy beam, 90 power, 10% chance to freeze] ", " [User regains half of its max hp]", "[ A 60 power move that can be any type the user desires] "};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv1 = scan.nextLine();

			while (legitmove1(possiblemoves, abbreviated, mv1) != true) { // sends arrays and the mv1 input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv1 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv1.equals(abbreviated[o])) {

					mv1 = possiblemoves[o];
				}


			}

		} else if (pokemonname.equals("chandelure")) {

			String[] possiblemoves = {"energyball", "flamethrower", "calmmind", "confuseray", "shadowball", "willowisp", "psychic"}; // array of possible moves for this pokemon
			String[] abbreviated = {"eb", "ft", "cm", "cr", "sb", "ww", "ps"};// array of the abbreviated moves
			String[] explain = {" [the user attacks with a 90 grass power move with a 10 percent chance to reduce spdef]", "[user shoots fire at the opponent, 90 power 10% chance to burn]", "[User increases its spa and Spdef stats]", "[ Confuses the opponent]", "[the user hits a ball of shadow, 80 power, 30% chance to drop spdef of opponent] ", " [Burns the opponent 90 percent of the time]", "[ A 90 power psychic move that hits for 90 power and has a 10% for a spdef drop] "};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv1 = scan.nextLine();

			while (legitmove1(possiblemoves, abbreviated, mv1) != true) { // sends arrays and the mv1 input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv1 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv1.equals(abbreviated[o])) {

					mv1 = possiblemoves[o];
				}


			}

		} else if (pokemonname.equals("dragonite")) {

			String[] possiblemoves = {"extremespeed", "dragondance", "thunderwave", "dragonclaw", "dracometeor", "firepunch", "icepunch", "thunderpunch", "superpower"}; // array of possible moves for this pokemon
			String[] abbreviated = {"es", "dd", "tw", "dc", "dm", "fp", "ip", "tp", "sp"};// array of the abbreviated moves
			String[] explain = {"[an 80 base power normal move that hits fast and hard]", "[boosts attack and speed]", " [paralyzes opponent]", "[user hits the target with 80 power dragon power]", "[An 120 power dragon move that reduces special attack of the user ]", "[The opponent is hit with a fiery punch, 75 power, 10% chance to burn]", "[the user hits an icy punch, 75 power, 10% chance to freeze] ", " [The user uses an electric punch to hit the opponent, 75 power; 10% chance to paralyze]", "[ user attacks with 120 power of fighting power, reduces attack and defense of the user] "};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv1 = scan.nextLine();

			while (legitmove1(possiblemoves, abbreviated, mv1) != true) { // sends arrays and the mv1 input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv1 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv1.equals(abbreviated[o])) {

					mv1 = possiblemoves[o];
				}


			}

		} else if (pokemonname.equals("salamence")) {

			String[] possiblemoves = {"dragondance", "earthquake", "dragonclaw", "dracometeor", "rockslide", "flamethrower", "airslash", "focusenergy"}; // array of possible moves for this pokemon
			String[] abbreviated = {"dd", "eq", "dc", "dm", "rs", "ft", "as", "fe"};// array of the abbreviated moves
			String[] explain = {"[boosts attack and speed]", " [A 100 power ground move]", "[user hits the target with 80 power dragon power]", "[An 120 power dragon move that reduces special attack of the user ]", "[The opponent is hit with a lot of rocks, 75 power, 30% chance to flinch]", "[the user hits the opponent with flames 90 power, 10% chance to burn] ", " [ The user slashes air at the opponent, 30% chance to flinch]", "[ increases the user's chances of a crit] "};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv1 = scan.nextLine();

			while (legitmove1(possiblemoves, abbreviated, mv1) != true) { // sends arrays and the mv1 input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv1 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv1.equals(abbreviated[o])) {

					mv1 = possiblemoves[o];
				}


			}

		} else if (pokemonname.equals("greninja")) {
			String[] possiblemoves = {"watershuriken", "extrasensory", "hydropump", "surf", "icebeam", "gunkshot", "darkpulse", "hiddenpower"}; // array of possible moves for this pokemon
			String[] abbreviated = {"ws", "ex", "hpu", "su", "ib", "gs", "dp", "hp"};// array of the abbreviated moves
			String[] explain = {"[The pokemon yeets some shurikens at the opponent, usually goes first]",
					" [80 base power psychic move with 100 accuracy, can sometimes flinch] ",
					" [A 110 power water move that has 80 accuracy] ",
					"[A 95 power water move with 100 accuracy]  ",
					" [An icy beam is shot at the opponent, ice type 90 base power, 10% chance to freeze] ",
					" [A toxic blast is shot at the opponent, has a 30% chance to poison the opponent]  ",
					" [A dark aura is projected at the opponent, has a 20% chance to flinch] ",
					" [A mysterious blast is shot at the opponent, the user chooses its type]"};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv1 = scan.nextLine();

			while (legitmove1(possiblemoves, abbreviated, mv1) != true) { // sends arrays and the mv1 input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv1 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv1.equals(abbreviated[o])) {

					mv1 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("zeraora")) {
			String[] possiblemoves = {"bulkup", "thunderwave", "toxic", "closecombat", "plasmafists", "drainpunch", "firepunch", "playrough"}; // array of possible moves for this pokemon
			String[] abbreviated = {"bu", "tw", "tx", "cc", "pf", "dp", "fp", "pr"};// array of the abbreviated moves
			String[] explain = {" [increases attack and defense]",
					"[paralyzes opponent] ",
					" [poisons opponent, opponent takes damage every turn, they're screwed if they can't win quickly] ",
					" [A 120 base power fighting move that reduces spdef and def] ",
					"[A mega-powerful electric punch, based 100 power] ",
					"[a punch of toxicity, 75 base power; the user gains some health back]  ",
					"[A punch of fiery wrath;75 base power; 10 percent chance to burn]  ",
					"[A 90 base power fairy move, has a chance to reduce the opponent's attack]"};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv1 = scan.nextLine();

			while (legitmove1(possiblemoves, abbreviated, mv1) != true) { // sends arrays and the mv1 input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv1 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv1.equals(abbreviated[o])) {

					mv1 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("togekiss")) {

			String[] possiblemoves = {"dazzlinggleam", "roost", "aurasphere", "flamethrower", "nastyplot",
					"thunderwave", "shadowball", "airslash", "psychic", "extremespeed"}; // array of possible moves for this pokemon
			String[] abbreviated = {"dg", "roo", "asp", "ft", "np", "tw", "sb", "as", "ps", "es"};// array of the abbreviated moves
			String[] explain = {"[An 80 base power fairy move]",
					"[Heals user but the user loses their flying type for a turn]",
					"[the user attacks with an 80 power fighting move that never misses]",
					"[user shoots fire at the opponent, 90 power 10% chance to burn]",
					"[User sharply increases its special attack]",
					"[paralyzes the opponent, 90 accuracy]",
					"[the user hits a ball of shadow, 80 power, 30% chance to drop spdef of opponent] ",
					"[The opponent gets slashed with some crisp clean air, 30% flinch rate]",
					"[ A 90 power psychic move that hits for 90 power and has a 10% for a spdef drop] ",
					"[The fastest move in the game, always moves first, 80 base power, it is speed, gotta go fast]"};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv1 = scan.nextLine();

			while (legitmove1(possiblemoves, abbreviated, mv1) != true) { // sends arrays and the mv1 input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv1 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv1.equals(abbreviated[o])) {

					mv1 = possiblemoves[o];
				}


			}

		} else if (pokemonname.equals("volcarona")) {

			String[] possiblemoves = {"hiddenpower", "flamethrower", "calmmind", "quiverdance", "bugbuzz", "wildcharge", "psychic"}; // array of possible moves for this pokemon
			String[] abbreviated = {"hp", "ft", "cm", "qd", "bb", "wc", "ps"};// array of the abbreviated moves
			String[] explain = {" [the user attacks with a 60 base power special attack of any type]",
					"[user shoots fire at the opponent, 90 power 10% chance to burn]",
					"[User increases its spa and Spdef stats]",
					"[ calm mind on steroids: also boosts speed, is super overpowered]",
					"[the user screeches reeeeeeeee, 90 power, 10% chance to drop spdef of opponent] ",
					"[hits the opponent with a 90 power physical electric type attack, hurts user as well]",
					"[A 90 power psychic move that hits for 90 power and has a 10% for a spdef drop] "};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv1 = scan.nextLine();

			while (legitmove1(possiblemoves, abbreviated, mv1) != true) { // sends arrays and the mv1 input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv1 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv1.equals(abbreviated[o])) {

					mv1 = possiblemoves[o];
				}


			}

		} else if (pokemonname.equals("pikachu")) {

			String[] possiblemoves = {"honeclaws", "thunderbolt", "volttackle", "hiddenpower", "toxic", "extremespeed", "quickattack", "thunderwave", "surf", "horndrill"}; // array of possible moves for this pokemon
			String[] abbreviated = {"hc", "tb", "vt", "hp", "tx", "es", "qa", "tw", "su", "hd"};// array of the abbreviated moves
			String[] explain = {"[Raises accuracy of attacks and increases their power] (I gave it to pikachu cause I felt like it)", " [A 90 base power electric attack with a 10 % chance of paralysis]",
					" [a 120 base power electric tackle attack, causes recoil but it goes hard]  ",
					" [A 60 base power move that can be any type the user desires]  ",
					" [this move poisons the opponent and the poison damage increases over time(poison types can't miss)] ",
					" [ha ha fast pikachu goes brrr (an 80 base power move that ussually hits first)]  ",
					" [A weaker extremespeed (just use extremespeed)] ",
					" [Has a 90 percent chance to paralyze opponent] ",
					" [A 90 base power watermove, yup I let pikachu learn this with lightball boosting its stats, it needs all the help it can get]",
					" [A move with a 30% chance to one-shot the opponent, pikachu shouldn't be able to learn this but I just want to see the power of friendship lol."};

			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv1 = scan.nextLine();

			while (legitmove1(possiblemoves, abbreviated, mv1) != true) { // sends arrays and the mv1 input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv1 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv1.equals(abbreviated[o])) {

					mv1 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("mimikyu")) {
			String[] possiblemoves = {"swordsdance", "thunderwave", "toxic", "bulkup", "leechlife", "drainpunch", "shadowclaw", "playrough", "shadowsneak"}; // array of possible moves for this pokemon
			String[] abbreviated = {"sd", "tw", "tx", "bu", "ll", "dp", "sc", "pr", "ss"};// array of the abbreviated moves
			String[] explain = {" [sharply increases attack]",
					"[paralyzes opponent] ",
					"[poisons opponent, opponent takes damage every turn, they're screwed if they can't win quickly] ",
					"[raises attack and defense] ",
					"[An 80 power bug move that drains the opponent's hp and heals you] ",
					"[a punch of toxicity, 75 base power; the user gains some health back]  ",
					"[A slash of sinister intent, 75 power, high crit rate]  ",
					"[A 90 base power fairy move, has a chance to reduce the opponent's attack]",
					"[You hit the opponent with a 40 base power ghostly sneak attack like they owe you money]"};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv1 = scan.nextLine();

			while (legitmove1(possiblemoves, abbreviated, mv1) != true) { // sends arrays and the mv1 input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv1 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv1.equals(abbreviated[o])) {

					mv1 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("noivern")) {
			String[] possiblemoves = {"boomburst", "dragonpulse", "moonlight", "flamethrower", "toxic", "darkpulse", "dracometeor", "psychic", "superfang"}; // array of possible moves for this pokemon
			String[] abbreviated = {"bb", "dp", "ml", "ft", "tx", "dpu", "dm", "ps", "sf"};// array of the abbreviated moves
			String[] explain = {" [a 150 power normal move, loud noise go brrrr] ",
					"[An 80 power base dragon move]  ",
					" [the user heals some of their health back] ",
					" [A 95 base power fire move with a 10% chance to burn] ",
					" [poisons the opponent with a toxin] ",
					" [An 80 base power dark move with a chance to flinch(20 %)] ",
					" [A 120 base power special dragon move, reduces the user's special attack] ",
					" [Mind melt, 90 power psychic move, can reduce special defense]",
					" [Halves the opponent's hp, slicey dicey]"};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv1 = scan.nextLine();

			while (legitmove1(possiblemoves, abbreviated, mv1) != true) { // sends arrays and the mv1 input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv1 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv1.equals(abbreviated[o])) {

					mv1 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("hawlucha")) {

			String[] possiblemoves = {"bravebird", "ironhead", "rockslide", "honeclaws", "brickbreak", "swordsdance", "poisonjab", "roost"}; // array of possible moves for this pokemon
			String[] abbreviated = {"bbi", "ih", "rs", "hc", "bb", "sd", "pj", "roo"};// array of the abbreviated moves
			String[] explain = {" [a 120 base power flying move, hurts the user too tho]", "[an 80 power steel move with a 30% chance to flinch ]", "[a lot of rocks are slammed on the opponent , 30% chance to flinch ] ", " [Boosts the user's attack and accuracy]", "[ a 75 base power fighting move] ", " [sharply raises the user's attack] ", "[the user jabs the opponent with poison, 30 % chance to poison] ", "[Heals the user but they lose their flying type for a turn]"};

			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv1 = scan.nextLine();

			while (legitmove1(possiblemoves, abbreviated, mv1) != true) { // sends arrays and the mv1 input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv1 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv1.equals(abbreviated[o])) {

					mv1 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("zoroark")) {

			String[] possiblemoves = {"honeclaws", "brickbreak", "nastyplot", "nightslash", "darkpulse", "shadowball", "sludgebomb", "suckerpunch", "focusblast", "flamethrower",}; // array of possible moves for this pokemon
			String[] abbreviated = {"hc", "bb", "np", "ns", "dpu", "sba", "sb", "sp", "fb", "ft"};// array of the abbreviated moves
			String[] explain = {"[A move that raises physical attack and accuracy]",
					"[A 75 base power fighting move]",
					"[This move sharply raises special attack]",
					"[a base 75 power dark slashing move, someone's getting sniped]",
					" [a dark aura is shot at the opponent, a chance to flinch is present]",
					" [an 80 power ghost move , 30 % chance for opposing spdef reduction] ",
					"[an 85 base power poison move with a 30% chance to poison]  ",
					" [An 80 base power move that only works if the opponent uses an attack]",
					" [A 120 base power fighting move with 70 accuracy] ",
					" [ Your opponent gets hit with fire, a 90 power fire move with 100 accuracy]"};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv1 = scan.nextLine();

			while (legitmove1(possiblemoves, abbreviated, mv1) != true) { // sends arrays and the mv1 input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv1 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv1.equals(abbreviated[o])) {

					mv1 = possiblemoves[o];
				}


			}

		} else if (pokemonname.equals("garchomp")) {

			String[] possiblemoves = {"firefang", "flamethrower", "dragonclaw", "rockslide", "brickbreak",
					"earthquake", "crunch", "swordsdance", "ironhead", "poisonjab", "dracometeor"}; // array of possible moves for this pokemon
			String[] abbreviated = {"ff", "ft", "dc", "rs", "bb",
					"ea", "cr", "sd", "ih", "pj", "dm"};// array of the abbreviated moves
			String[] explain = {"[a 65 power physical fire move (95 accuracy) 10 percent chance to burn or flinch]",
					"  [a 90 power special fire move (100 accuracy) 10 percent chance to burn] ",
					" [an 80 base power dragon type move] ",
					" [a lot of rocks are slammed on the opponent , 30% chance to flinch ] ",
					" [ a 75 base power fighting move] ",
					" [a 100 base ground move] ",
					" [an 80 power dark move that crunches opponent, 20 percent chance for defense drop] ",
					" [Boosts attack, makes a pokemon go from good to overpowered in one turn]",
					" [An 80 base power steel move wrecks fairies and ice pokemon]",
					" [An 85 base power toxic jab that can poison the opponent]",
					" [Asteroids fall from the sky and obliterate all in their path, 120 base power, harshly reduces special attack]"
			};

			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv1 = scan.nextLine();

			while (legitmove1(possiblemoves, abbreviated, mv1) != true) { // sends arrays and the mv1 input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv1 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv1.equals(abbreviated[o])) {

					mv1 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("tyranitar")) {

			String[] possiblemoves = {"icepunch", "flamethrower", "surf", "rockslide",
					"brickbreak", "earthquake", "crunch", "dragondance", "darkpulse", "thunderbolt"}; // array of possible moves for this pokemon
			String[] abbreviated = {"ip", "ft", "su", "rs",
					"bb", "ea", "cr", "dd", "dp", "tb"};// array of the abbreviated moves
			String[] explain = {
					"[a 75 base power ice move, dragons hate it lol]",
					"  [a 90 power special fire move (100 accuracy) 10 percent chance to burn] ",
					" [a 90 base power water move] ",
					" [a lot of rocks are slammed on the opponent , 30% chance to flinch ] ",
					" [ a 75 base power fighting move] ",
					" [a 100 base ground move] ",
					" [an 80 power dark move that crunches opponent, 20 percent chance for defense drop] ",
					" [Boosts attack, makes a pokemon go from good to overpowered in one turn, raises attack and speed]",
					" [An 80 base power dark move wrecks psychic and ghost pokemon]",
					" [An 90 base power electric shock that can paralyze the opponent]"
			};

			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv1 = scan.nextLine();

			while (legitmove1(possiblemoves, abbreviated, mv1) != true) { // sends arrays and the mv1 input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv1 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv1.equals(abbreviated[o])) {

					mv1 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("lucario")) {

			String[] possiblemoves = {"calmmind", "dragonpulse", "aurasphere", "closecombat", "swordsdance",
					"bulletpunch", "shadowball", "meteormash", "psychic", "extremespeed", "flashcannon"}; // array of possible moves for this pokemon
			String[] abbreviated = {"cm", "dpu", "asp", "cc", "sd", "bp", "sb", "mm", "ps", "es", "fc"};// array of the abbreviated moves
			String[] explain = {"[boosts special attack and special defense]",
					"[User expels their inner dragon, 80 base power special attack]",
					"[the user attacks with an 80 power fighting move that never misses]",
					"[user hits the opponent up close, the opponent gets jumped, the user's defenses lower however]",
					"[User sharply increases its physical attack]",
					"[a punch as fast as my internet, 40 base power steel move]",
					"[the user hits a ball of shadow, 80 power, 30% chance to drop spdef of opponent] ",
					"[The opponent gets mashed with some crisp clean steel, may raise attack but also may miss]",
					"[ A psychic move that hits for 90 power and has a 10% for a spdef drop] ",
					"[The fastest move in the game, always moves first, 80 base power, it is speed, gotta go fast]",
					"[A steel beam is shot at the opponent, 90 base power, can reduce spdef]"};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv1 = scan.nextLine();

			while (legitmove1(possiblemoves, abbreviated, mv1) != true) { // sends arrays and the mv1 input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv1 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv1.equals(abbreviated[o])) {

					mv1 = possiblemoves[o];
				}


			}

		} else if (pokemonname.equals("flygon")) {

			String[] possiblemoves = {"dragondance", "earthquake", "dragonclaw", "dracometeor",
					"rockslide", "flamethrower", "boomburst", "crunch", "bugbuzz"}; // array of possible moves for this pokemon
			String[] abbreviated = {"dd", "eq", "dc", "dm",
					"rs", "ft", "bb", "cr", "bu"};// array of the abbreviated moves
			String[] explain = {"[boosts attack and speed]", " [A 100 power ground move]", "[user hits the target with 80 power dragon power]", "[An 120 power dragon move that reduces special attack of the user ]"
					, "[The opponent is hit with a lot of rocks, 75 power, 30% chance to flinch]", "[the user hits the opponent with flames 90 power, 10% chance to burn] ", " [ The user screeches reeeeeee, a 150 base power normal move]", "[ An 80 base power dark move that can reduce defense] ", "[The user screeches reeee in bug language, a 90 power bug type attack]"};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv1 = scan.nextLine();

			while (legitmove1(possiblemoves, abbreviated, mv1) != true) { // sends arrays and the mv1 input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv1 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv1.equals(abbreviated[o])) {

					mv1 = possiblemoves[o];
				}


			}

		} else if (pokemonname.equals("dragapult")) {

			String[] possiblemoves = {"dragondance", "willowisp", "dragonclaw", "dracometeor",
					"bodyslam", "thunderbolt", "confuseray", "suckerpunch", "shadowball", "surf"}; // array of possible moves for this pokemon
			String[] abbreviated = {"dd", "ww", "dc", "dm",
					"bs", "tb", "cr", "sp", "sb", "su"};// array of the abbreviated moves
			String[] explain = {"[boosts attack and speed]", " [burns the opponent]",
					"[user hits the target with 80 power dragon power]", "[An 120 power dragon move that reduces special attack of the user ]"
					, "[The opponent is slammed with a lot of force, 80 power, 30% chance to paralyze]",
					"[the user hits the opponent with electricity 90 power, 10% chance to paralyze] ",
					"[user confuses the opponent]"
					, "[The user sneak attacks the opponent before the opponent can attack]",
					" [ The user throws a ball of shadow energy, 80 base power]",
					"[ A 90 base power water move]"};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv1 = scan.nextLine();

			while (legitmove1(possiblemoves, abbreviated, mv1) != true) { // sends arrays and the mv1 input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv1 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv1.equals(abbreviated[o])) {

					mv1 = possiblemoves[o];
				}


			}

		} else if (pokemonname.equals("goodra")) {
			String[] possiblemoves = {"sludgebomb", "focusblast", "hydropump", "dragonpulse", "flashcannon", "flamethrower", "surf", "darkpulse", "dracometeor"}; // array of possible moves for this pokemon
			String[] abbreviated = {"sb", "fb", "hp", "dp", "fc", "ft", "su", "dpu", "dm"};// array of the abbreviated moves
			String[] explain = {"[An 80 base power poison move, 30% chance to poison]", "[A 120 base power fighting special attack, 70 accuracy]", "[A hard hitting 110 base power water move with 80 accuracy] ", "[An 80 power base dragon move]  ", " [A 90 base power steel move] ", " [A 95 base power fire move with a 10% chance to burn] ", " [A 95 base power water move] ", " [An 80 base power dark move with a chance to flinch(20 %)] ", " [A 120 base power special dragon move, reduces the user's special attack] "};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv1 = scan.nextLine();

			while (legitmove1(possiblemoves, abbreviated, mv1) != true) { // sends arrays and the mv1 input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv1 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv1.equals(abbreviated[o])) {

					mv1 = possiblemoves[o];
				}


			}


		}
		else if (pokemonname.equals("charizard")) {

			String[] possiblemoves = {"dragonpulse", "dragondance", "earthquake", "dragonclaw", "flareblitz", "rockslide", "flamethrower", "airslash", "thunderpunch"}; // array of possible moves for this pokemon
			String[] abbreviated = {"dp", "dd", "eq", "dc", "fb", "rs", "ft", "as", "tp"};// array of the abbreviated moves
			String[] explain = {"[user unleashes their inner dragon, 85 base power]", "[boosts attack and speed]", " [A 100 power ground move]", "[user hits the target with base 80 physical dragon power]", "[An 120 power fire move that reduces the hp of the user as well]", "[The opponent is hit with a lot of rocks, 75 power, 30% chance to flinch]", "[the user hits the opponent with flames 90 power, 10% chance to burn] ", " [ The user slashes air at the opponent, 30% chance to flinch]", "[ the user hits with electric power] "};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv1 = scan.nextLine();

			while (legitmove1(possiblemoves, abbreviated, mv1) != true) { // sends arrays and the mv1 input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv1 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv1.equals(abbreviated[o])) {

					mv1 = possiblemoves[o];
				}


			}

		}
		else if (pokemonname.equals("golisopod")) {
			String[] possiblemoves = {"swordsdance", "bulkup", "suckerpunch", "aquajet", "closecombat",
					"leechlife", "poisonjab", "rockslide", "aerialace"}; // array of possible moves for this pokemon
			String[] abbreviated = {"sd", "bu", "sp", "aj", "cc",
					"ll", "pj","rs",  "aa"};// array of the abbreviated moves
			String[] explain = {" [sharply raises the user's attack]",
					"[raises attack and defense ]",
					"[user sneaks the opponent like college sneaked my bank account, base 80 power, only works if the opponent is about to attack] "
					, " [User hits with a jet stream of water, base 40 power]", "[ A 120 base power fighting move that reduces the defenses of the user] ",
					" [a base 75 power bug move that can heal the user] ", "[the user jabs the opponent with poison, 30 % chance to poison] ",
					"[User hits the foe with rocks, rocks may miss but may also flinch]",
					"[user slashes with an aerial technique that always hits]"};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv1 = scan.nextLine();

			while (legitmove1(possiblemoves, abbreviated, mv1) != true) { // sends arrays and the mv1 input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv1 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv1.equals(abbreviated[o])) {

					mv1 = possiblemoves[o];
				}


			}


		}
		else if (pokemonname.equals("roserade")) {

			String[] possiblemoves = {"toxic", "extrasensory", "shadowball", "sludgebomb", "energyball", "dazzlinggleam", "hiddenpower",}; // array of possible moves for this pokemon
			String[] abbreviated = {"tx", "ex", "sb", "sb", "eb", "dg", "hp"};// array of the abbreviated moves
			String[] explain = {"[this move poisons the opponent and the poison damage increases over time(poison types can't miss)]",
					" [opponent is hit with a base 80 psychic power]",
					" [an 80 power ghost move , 30 % chance for opposing spdef reduction] ",
					"[an 85 base power poison move with a 30% chance to poison]  ",
					" [An 90 base power grass move that hits hard]", " [A 80 base power fairy move with 100 accuracy] ",
					" [A move that can be of any type the user desires, base 60 power]"};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv1 = scan.nextLine();

			while (legitmove1(possiblemoves, abbreviated, mv1) != true) { // sends arrays and the mv1 input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv1 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv1.equals(abbreviated[o])) {

					mv1 = possiblemoves[o];
				}


			}

		}
		else if (pokemonname.equals("sceptile")) {
			String[] possiblemoves = {"quickattack", "swordsdance", "leafblade", "energyball", "return", "xscissor", "hiddenpower", "aerialace"}; // array of possible moves for this pokemon
			String[] abbreviated = {"qa","sd", "lb", "eb", "re", "xs", "hp", "aa"};// array of the abbreviated moves
			String[] explain = {"[Hits fast and usually hits first]", "[Sharply raises attack]",
					" [A grass attack with a higher chance of crits, 70 base power] ",
					" [This is a 90 base power move that hits hard] ",
					"[a 102 base power normal physical attack]  ",
					"[80 base power bug move]  ",
					" [A special attack that can be any type the user desires(60 base power) ] ",
					" [60 base power flying move that never misses] "};



			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv1 = scan.nextLine();

			while (legitmove1(possiblemoves, abbreviated, mv1) != true) { // sends arrays and the mv1 input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv1 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv1.equals(abbreviated[o])) {

					mv1 = possiblemoves[o];
				}


			}


		}
		else if (pokemonname.equals("mewtwo")) {
			String[] possiblemoves = {"calmmind", "thunderbolt", "psychic", "shadowball", "flamethrower", "icebeam", "aurasphere", "recover", "toxic"}; // array of possible moves for this pokemon
			String[] abbreviated = {"cm", "tb", "ps", "sb", "ft", "ib", "as", "re", "tx"};// array of the abbreviated moves
			String[] explain = {"[raises special attack and special defense]", "[The user zaps the opponent with electricity," +
					" 90 base power move, 10 % chance to paralyze]",
					" [90 base power psychic move with 100 accuracy] ",
					" [A 80 power ghost move that has 100 accuracy] ",
					"[A 95 power fire move with 100 accuracy]  ",
					" [An icy beam is shot at the opponent, ice type 90 base power, 10% chance to freeze] ",
					" [A 80 base power fighting special attack no one can dodge ]  ",
					" [The user heals itself by 1/2 of its max hp] ", "[poisons opponent, RIP the other player lol]"};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv1 = scan.nextLine();

			while (legitmove1(possiblemoves, abbreviated, mv1) != true) { // sends arrays and the mv1 input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv1 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv1.equals(abbreviated[o])) {

					mv1 = possiblemoves[o];
				}


			}


		}
		else if (pokemonname.equals("talonflame")) {


			String[] possiblemoves = {"bravebird", "flareblitz", "quickattack",
					"return", "gigaimpact", "swordsdance", "steelwing", "roost"}; // array of possible moves for this pokemon
			String[] abbreviated = {"bb", "fb", "qa",
					"re", "gi", "sd", "sw", "ro"};// array of the abbreviated moves
			String[] explain = {" [A 120 base power flying move, user takes 1/3 recoil]",
					"[an 120 base power fire move, user takes 1/3 recoil ]",
					"[user hits fast with a 40 base power normal move]",
					"[the opponent is hit with a 102 base power normal move  ] ",
					"[User hits the opponent with a 150 base power normal move but has to recharge]",
					"[sharply raises attack] ",
					"[sharp steel wings are slashed at the opponent, 70 power 90 accuracy] ",
					"[the user roosts and regains hp, user loses flying temporarily] "};

			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv1 = scan.nextLine();

			while (legitmove1(possiblemoves, abbreviated, mv1) != true) { // sends arrays and the mv1 input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv1 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv1.equals(abbreviated[o])) {

					mv1 = possiblemoves[o];
				}


			}

		}
		else if (pokemonname.equals("snorlax")) {

			String[] possiblemoves = {"return", "crunch", "earthquake",
					"zenheadbut", "firepunch", "icepunch",
					"thunderpunch", "hyperbeam"}; // array of possible moves for this pokemon
			String[] abbreviated = {"re", "cr", "eq",
					"zh", "fp", "ip",
					"tp", "hb"};// array of the abbreviated moves
			String[] explain = {"[a 102 base power normal move]", " [snorlax attacks with 80 base power darkness]", "[user hits the target with a 100 power ground high crit rate move]",
					"[an 85 base power psychic  move, can miss but can also flinch]", "[The opponent is hit with a fiery punch, 75 power, 10% chance to burn]", "[the user hits an icy punch, 75 power, 10% chance to freeze] ",
					" [The user uses an electric punch to hit the opponent, 75 power; 10% chance to paralyze]", "[ a 150 base power move (special attack) , forces one to recharge] "};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv1 = scan.nextLine();

			while (legitmove1(possiblemoves, abbreviated, mv1) != true) { // sends arrays and the mv1 input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv1 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv1.equals(abbreviated[o])) {

					mv1 = possiblemoves[o];
				}


			}

		}
		else if (pokemonname.equals("infernape")) {

			String[] possiblemoves = {"closecombat", "flareblitz", "swordsdance",
					"stoneedge", "flamethrower", "focusblast",
					"thunderpunch", "earthquake",
					"nastyplot","hiddenpower"}; // array of possible moves for this pokemon
			String[] abbreviated = {"cc", "fb", "sd",
					"se", "ft", "fb",
					"tb", "eq" ,
					"np","hp"};// array of the abbreviated moves
			String[] explain = {"[A 120 power fighting move, reduces the user's defense and special defense]", "[A 120 base power physical fire move but the user takes 1/3 of the damage as recoil] ", " [sharply boosts attack] ",
					" [a base 100 power rock move, can crit but also can miss] ", " [a 90 base power fire move that can burn the opponent] ", " [a 120 base power fighting blast that can reduce the opponent's special defense] ",
					" [A 75 base power electric move, may paralyze opponent] ", " [A 100 base power ground move]",
					"[sharply boosts special attack]","[aa 60 base power move that can be any type the user desires]"};

			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv1 = scan.nextLine();

			while (legitmove1(possiblemoves, abbreviated, mv1) != true) { // sends arrays and the mv1 input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv1 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv1.equals(abbreviated[o])) {

					mv1 = possiblemoves[o];
				}


			}


		}
		else if (pokemonname.equals("weavile")) {
			String[] possiblemoves = {"icepunch", "nightslash",
					"brickbreak",
					"iceshard", "slash",
					"poisonjab", "swordsdance"}; // array of possible moves for this pokemon
			String[] abbreviated = {"ip", "ns",
					"bb",
					"is", "s",
					"pj", "sd"};// array of the abbreviated moves
			String[] explain = {" [The user hits the opponent with an icy 75 base power punch ,10% chance to freeze] ", "[A 75 base power dark move, high crit rate] ",
					"[ A 75 base power fighting move ]  ",
					"[A fast ice type physical attack, 40 base power]  ", "[A 75 base power normal move, high crit rate]  ",
					"[A 85 base power ice move with a 30% chance to poison ] ", "[sharply raises attack]  "};

			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv1 = scan.nextLine();

			while (legitmove1(possiblemoves, abbreviated, mv1) != true) { // sends arrays and the mv1 input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv1 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv1.equals(abbreviated[o])) {

					mv1 = possiblemoves[o];
				}


			}


		}
		else if (pokemonname.equals("groudon")) {

			String[] possiblemoves = {"bulkup", "dragonclaw", "earthquake",
					"focusblast", "rockslide",
					"flamethrower", "brickbreak",
					"swordsdance", "poisonjab", "thunderbolt"}; // array of possible moves for this pokemon
			String[] abbreviated = {"bu", "dc", "ea",
					"fb", "rs",
					"ft", "bb",
					"sd", "pj", "tb"};// array of the abbreviated moves
			String[] explain = {"[raises attack and defense]", "[An 80 base power dragon move]", " [a 100 base power physical ground move]",
					"[an 120 power fighting move with a chance to reduce spdef ]", "[a lot of rocks are slammed on the opponent , 30% chance to flinch ] ",
					" [user expels flames that can burn the opponent, 90 base power]", "[ a 75 base power fighting move] ",
					" [sharply raises the user's attack] ", "[the user jabs the opponent with poison, 30 % chance to poison] ", "[User hits with a 95 base power electric move, with a chance to paralyze]"};

			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv1 = scan.nextLine();

			while (legitmove1(possiblemoves, abbreviated, mv1) != true) { // sends arrays and the mv1 input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv1 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv1.equals(abbreviated[o])) {

					mv1 = possiblemoves[o];
				}


			}


		}
		else if (pokemonname.equals("kyogre")) {

			String[] possiblemoves = {"calmmind", "hyperbeam", "surf",
					"hydropump", "icebeam",
					"blizzard", "brickbreak",
					"aquaring", "thunderwave", "thunderbolt"}; // array of possible moves for this pokemon
			String[] abbreviated = {"cm", "hb", "su",
					"hp", "ib",
					"bli", "bri",
					"aq", "tw", "tb"};// array of the abbreviated moves
			String[] explain = {"[raises special attack and special defense]", "[An 150 base power normal move that requires a recharge turn]", " [a 95 base power special water move]",
					"[an 120 power water move with 80 accuracy]", "[an icy beam with a chance to freeze is launched at the opponent ] ",
					" [a 120 base power ice move with 70 accuracy]", "[ a 75 base power fighting move] ",
					" [a veil of water is used to let the user gain a little hp every turn] ", "[the user paralyzes the opponent] ", "[User hits with a 95 base power electric move, with a chance to paralyze]"};

			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv1 = scan.nextLine();

			while (legitmove1(possiblemoves, abbreviated, mv1) != true) { // sends arrays and the mv1 input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv1 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv1.equals(abbreviated[o])) {

					mv1 = possiblemoves[o];
				}


			}


		}
		else if (pokemonname.equals("rayquaza")) {

			String[] possiblemoves = {"dragondance", "earthquake",
					"dragonclaw", "dracometeor",
					"rockslide", "flamethrower",
					"airslash", "hyperbeam"}; // array of possible moves for this pokemon
			String[] abbreviated = {"dd", "eq",
					"dc", "dm",
					"rs", "ft",
					"as", "hb"};// array of the abbreviated moves
			String[] explain = {"[boosts attack and speed]", " [A 100 power ground move]",
					"[user hits the target with 80 power dragon power]", "[An 120 power dragon move that reduces special attack of the user ]",
					"[The opponent is hit with a lot of rocks, 75 power, 30% chance to flinch]", "[the user hits the opponent with flames 90 power, 10% chance to burn] ",
					" [ The user slashes air at the opponent, 30% chance to flinch]", "[A beam is shot at the opponent, 150 base power, requres a recharge turn] "};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv1 = scan.nextLine();

			while (legitmove1(possiblemoves, abbreviated, mv1) != true) { // sends arrays and the mv1 input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv1 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv1.equals(abbreviated[o])) {

					mv1 = possiblemoves[o];
				}


			}

		}
		else if (pokemonname.equals("giratina-altered")) {

			String[] possiblemoves = {"calmmind", "willowisp",
					"dragonclaw", "dracometeor",
					"aurasphere",
					"darkpulse",
					"energyball",
					"earthquake",
					"shadowball",
					"shadowsneak"}; // array of possible moves for this pokemon
			String[] abbreviated = {"cm", "ww",
					"dc", "dm",
					"as",
					"dp",
					"eb",
					"eq",
					"sb",
					"ss"};// array of the abbreviated moves
			String[] explain = {"[boosts special attack and special defense]", " [burns the opponent]",
					"[user hits the target with 80 power dragon power]", "[An 120 power dragon move that reduces special attack of the user ]"
					, "[The opponent is slammed with an 80 power fighting move that never misses]",
					"[the user hits the opponent with a dark type 80 power with a chance to flinch] ",
					"[the user hits the opponent with a grass type 90 power with a chance to reduce spdef]"
					, "[A 100 base power ground move]",
					" [The user throws a ball of shadow energy, 80 base power]",
					"[User sneaks the opponent, 40 base ghost power]"};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv1 = scan.nextLine();

			while (legitmove1(possiblemoves, abbreviated, mv1) != true) { // sends arrays and the mv1 input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv1 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv1.equals(abbreviated[o])) {

					mv1 = possiblemoves[o];
				}


			}

		}
		else if (pokemonname.equals("giratina-origin")) {

			String[] possiblemoves = {"calmmind", "willowisp",
					"dragonclaw", "dracometeor",
					"aurasphere",
					"darkpulse",
					"energyball",
					"earthquake",
					"shadowball",
					"shadowsneak"}; // array of possible moves for this pokemon
			String[] abbreviated = {"cm", "ww",
					"dc", "dm",
					"as",
					"dp",
					"eb",
					"eq",
					"sb",
					"ss"};// array of the abbreviated moves
			String[] explain = {"[boosts special attack and special defense]", " [burns the opponent]",
					"[user hits the target with 80 power dragon power]", "[An 120 power dragon move that reduces special attack of the user ]"
					, "[The opponent is slammed with an 80 power fighting move that never misses]",
					"[the user hits the opponent with a dark type 80 power with a chance to flinch] ",
					"[the user hits the opponent with a grass type 90 power with a chance to reduce spdef]"
					, "[A 100 base power ground move]",
					" [The user throws a ball of shadow energy, 80 base power]",
					"[User sneaks the opponent, 40 base ghost power]"};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv1 = scan.nextLine();

			while (legitmove1(possiblemoves, abbreviated, mv1) != true) { // sends arrays and the mv1 input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv1 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv1.equals(abbreviated[o])) {

					mv1 = possiblemoves[o];
				}


			}

		}
		else if (pokemonname.equals("gardevoir")) {
			String[] possiblemoves = {"psychic", "shadowball", "thunderbolt",
					"calmmind", "dazzlinggleam", "hiddenpower", "energyball"}; // array of possible moves for this pokemon
			String[] abbreviated = {"ps", "sb", "tb",
					"cm", "dg", "hp", "eb"};// array of the abbreviated moves
			String[] explain = {" [A 90 base power psychic move with a 10% chance of a reduction in opponent's spdef] ", " [an 80 base power ghost move with a 30% chance to reduce opponent spdef] ", " [a 90 base power electric move that can paralyze the opponent] ",
					"[raises special attack and special defense] ", "[An 80 base power fairy move]  ", "[A 60 base power move that can be any type the user desires] ", " [A 90 base power grass move that can reduce spdef ]"};

			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv1 = scan.nextLine();

			while (legitmove1(possiblemoves, abbreviated, mv1) != true) { // sends arrays and the mv1 input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv1 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv1.equals(abbreviated[o])) {

					mv1 = possiblemoves[o];
				}


			}


		}
		else if (pokemonname.equals("gallade")) {
			String[] possiblemoves = {"bulkup", "nightslash", "psychic", "closecombat",
					"swordsdance", "poisonjab", "rockslide", "earthquake"}; // array of possible moves for this pokemon
			String[] abbreviated = {"bu", "ns", "ps", "cc",
					"sd", "pj", "rs", "eq"};// array of the abbreviated moves
			String[] explain = {" [increases attack and defense]",
					"[A 75 base power dark move with a high crit rate] ",
					" [A 90 base power psychic move with a 10 % to reduce spdef] ",
					" [A 120 base power fighting move that reduces spdef and def] ",
					"[sharply boosts attack] ",
					"[a punch of toxicity , 85 base power; 30 percent chance to poison]  ",
					"[A lot of rocks launched at the opponent, there is a chance to flinch as well]  ",
					"[A 100 base power ground move]"};

			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv1 = scan.nextLine();

			while (legitmove1(possiblemoves, abbreviated, mv1) != true) { // sends arrays and the mv1 input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv1 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv1.equals(abbreviated[o])) {

					mv1 = possiblemoves[o];
				}


			}


		}




		return mv1;

	}


	// this tests if the move or abbreviation is in the arrays that are sent to this legit move function and or if the move is the same as another move

	private boolean legitmove2(String[] possiblemoves, String[] abbreviations, String testmove, String dupe) { // It is so cool that I can pass arrays as arguments in java, sadly i cant do it in c++ lol
		boolean test = false;

		for (int i = 0; i < abbreviations.length; i++) {

			if (possiblemoves[i].equals(testmove)) {

				test = true;
				break;

			} else if (abbreviations[i].equals(testmove)) {
				test = true;
				break;

			}


		}

		for (int j = 0; j < abbreviations.length; j++) {

			if (abbreviations[j].equals(testmove)) {

				testmove = possiblemoves[j];
			}
		}

		if (testmove.equals(dupe)) {

			test = false;
		}


		return test;

	}


	// this is for a second move, this will make sure that the player doesn't input multiple moves lol


	public String getmovename(String player, String pokemonname, String move1) {
		String mv2 = "two";// this is the way i tested how different constructors worked

		System.out.println("\n Input a second move, DO NOT INPUT THE SAME PREVIOUS MOVE" + player + ".");
		System.out.println("For example: [meteormash mm] (You can input 'meteormash' or 'mm') \n ");


		if (pokemonname.equals("metagross")) {

			String[] possiblemoves = {"meteormash", "zenheadbut", "thunderpunch", "icepunch", "rockslide", "return", "earthquake", "bulletpunch"}; // array of possible moves for this pokemon
			String[] abbreviated = {"mm", "zh", "tp", "ip", "rs", "re", "ea", "bp"};// array of the abbreviated moves
			String[] explain = {"[A 90 base power physical steel move with 90 accuracy and has a 10 percent chance to increase attack]", "[ A 85 base physical psychic move with 90 accuracy]", "[A punch of electricity, has a 10 percent chance to paralyze]", "[a punch of icy coldness, 10 percent chance to freeze]", "[a lot of rocks are slammed on the opponent , 30% chance to flinch ]", "[a 102 base power normal physical attack]", "[a 100 base ground move]", "[User ussually goes first in dishing out the 40 power steel bash]"};

			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv2 = scan.nextLine();

			while (legitmove2(possiblemoves, abbreviated, mv2, move1) != true) { // sends arrays and the mv2 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv2 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv2.equals(abbreviated[o])) {

					mv2 = possiblemoves[o];
				}


			}

		} else if (pokemonname.equals("gliscor")) {

			String[] possiblemoves = {"toxic", "earthquake", "rockslide", "firefang", "thunderfang", "icefang", "swordsdance"}; // array of possible moves for this pokemon
			String[] abbreviated = {"tx", "ea", "rs", "ff", "tf", "if", "sd"};// array of the abbreviated moves
			String[] explain = {"[this move poisons the opponent and the poison damage increases over time(poison types can't miss)]", "[a 100 base power physical ground move]", "[a 75 power, 95 accuracy rock move that can flinch, user slams rocks on opponent.] ", " [a 65 power physical fire move (95 accuracy) 10 percent chance to burn or flinch]", " [a 65 power physical electric move (95 accuracy) 10 percent chance to paralyze or flinch] ", " [a 65 power physical ice move (95 accuracy) 10 percent chance to freeze or flinch ]", "[sharply raises user's attack ]"};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv2 = scan.nextLine();

			while (legitmove2(possiblemoves, abbreviated, mv2, move1) != true) { // sends arrays and the mv2 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv2 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv2.equals(abbreviated[o])) {

					mv2 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("excadrill")) {

			String[] possiblemoves = {"honeclaws", "earthquake", "ironhead", "rockslide", "horndrill", "brickbreak", "swordsdance", "poisonjab"}; // array of possible moves for this pokemon
			String[] abbreviated = {"hc", "ea", "ih", "rs", "hd", "bb", "sd", "pj"};// array of the abbreviated moves
			String[] explain = {"[Raises accuracy of attacks and increases their power]", " [a 100 base power physical ground move]", "[an 80 power steel move with a 30% chance to flinch ]", "[a lot of rocks are slammed on the opponent , 30% chance to flinch ] ", " [Has a 30 percent chance to one-shot the opponent, can't hit ghosts]", "[ a 75 base power fighting move] ", " [sharply raises the user's attack] ", "[the user jabs the opponent with poison, 30 % chance to poison] "};

			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv2 = scan.nextLine();

			while (legitmove2(possiblemoves, abbreviated, mv2, move1) != true) { // sends arrays and the mv2 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv2 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv2.equals(abbreviated[o])) {

					mv2 = possiblemoves[o];
				}


			}

		} else if (pokemonname.equals("arcanine")) {


			String[] possiblemoves = {"closecombat", "flareblitz", "crunch", "extremespeed", "willowisp", "morningsun", "ironhead", "wildcharge"}; // array of possible moves for this pokemon
			String[] abbreviated = {"cc", "fb", "cr", "es", "ww", "ms", "ih", "wc"};// array of the abbreviated moves
			String[] explain = {"[A 120 power fighting move, reduces the user's defense and special defense]", "[A 120 base power physical fire move but the user takes 1/3 of the damage as recoil] ", " [an 80 power dark physical move that has a 20 percent chance for a defense drop] ", " [80 base power normal move that always moves first] ", " [has a 90 percent chance to burn the opponent] ", " [heals user by half of its max hp] ", " [an 80 power steel move with a 30% chance to flinch ] ", " [A 90 power electric physical attack, user takes 1/3 recoil]"};

			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv2 = scan.nextLine();

			while (legitmove2(possiblemoves, abbreviated, mv2, move1) != true) { // sends arrays and the mv2 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv2 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv2.equals(abbreviated[o])) {

					mv2 = possiblemoves[o];
				}


			}

		} else if (pokemonname.equals("krookodile")) {

			String[] possiblemoves = {"firefang", "thunderfang", "dragonclaw", "rockslide", "brickbreak", "earthquake", "crunch"}; // array of possible moves for this pokemon
			String[] abbreviated = {"ff", "tf", "dc", "rs", "bb", "ea", "cr"};// array of the abbreviated moves
			String[] explain = {"[a 65 power physical fire move (95 accuracy) 10 percent chance to burn or flinch]", "  [a 65 power physical electric move (95 accuracy) 10 percent chance to paralyze or flinch] ", " [an 80 base power dragon type move] ", " [a lot of rocks are slammed on the opponent , 30% chance to flinch ] ", " [ a 75 base power fighting move] ", " [a 100 base ground move] ", " [an 80 power dark move that crunches opponent, 20 percent chance for defense drop] "};

			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv2 = scan.nextLine();

			while (legitmove2(possiblemoves, abbreviated, mv2, move1) != true) { // sends arrays and the mv2 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv2 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv2.equals(abbreviated[o])) {

					mv2 = possiblemoves[o];
				}


			}

		} else if (pokemonname.equals("feraligatr")) {

			String[] possiblemoves = {"dragondance", "aquajet", "superpower", "waterfall", "icepunch", "earthquake", "dragonclaw", "crunch"}; // array of possible moves for this pokemon
			String[] abbreviated = {"dd", "aj", "sp", "wf", "ip", "ea", "dc", "cr"};// array of the abbreviated moves
			String[] explain = {"[boosts attack and speed]", " [a 40 base power physical priority water move]  ", " [a 120 base power fighting move that reduces attack and defense of the user] ", " [an 80 base power water move (with sheerforce it will be 110)] ", " [a punch of icy coldness, 10 percent chance to freeze] ", "[a 100 base power physical ground move]  ", " [an 80 base power dragon move] ", " [an 80 base power dark move and it has a 20 percent chance to reduce defense] "};

			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv2 = scan.nextLine();

			while (legitmove2(possiblemoves, abbreviated, mv2, move1) != true) { // sends arrays and the mv2 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv2 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv2.equals(abbreviated[o])) {

					mv2 = possiblemoves[o];
				}


			}

		} else if (pokemonname.equals("gyarados")) {

			String[] possiblemoves = {"dragondance", "icefang", "waterfall", "return", "irontail", "stoneedge", "earthquake"}; // array of possible moves for this pokemon
			String[] abbreviated = {"dd", "if", "wf", "re", "it", "se", "ea"};// array of the abbreviated moves
			String[] explain = {"[boosts attack and speed]", "[a 65 power physical ice move (95 accuracy) 10 percent chance to freeze or flinch ] ", "  [an 80 base power water move with a 20 percent chance to flinch] ", " [a 102 base power normal physical attack] ", " [A steel move that has 75 percent accuracy ]",
					"[The user snipes the opponent with stones (rock move, 100 base power, 80 accuracy]  ", " [ A 100 base power ground type move  with 100 accuracy] "};

			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv2 = scan.nextLine();

			while (legitmove2(possiblemoves, abbreviated, mv2, move1) != true) { // sends arrays and the mv2 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv2 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv2.equals(abbreviated[o])) {

					mv2 = possiblemoves[o];
				}


			}

		} else if (pokemonname.equals("starmie")) {
			String[] possiblemoves = {"thunderbolt", "psychic", "hydropump", "surf", "icebeam", "confuseray", "recover"}; // array of possible moves for this pokemon
			String[] abbreviated = {"tb", "ps", "hp", "su", "ib", "cr", "re"};// array of the abbreviated moves
			String[] explain = {"[The user zaps the opponent with electricity, 90 base power move, 10 % chance to paralyze]", " [90 base power psychic move with 100 accuracy] ", " [A 110 power water move that has 80 accuracy] ", "[A 95 power water move with 100 accuracy]  ", " [An icy beam is shot at the opponent, ice type 90 base power, 10% chance to freeze] ", " [confuses the opponent ]  ", " The user heals itself by 1/2 of its max hp] "};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv2 = scan.nextLine();

			while (legitmove2(possiblemoves, abbreviated, mv2, move1) != true) { // sends arrays and the mv2 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv2 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv2.equals(abbreviated[o])) {

					mv2 = possiblemoves[o];
				}


			}

		} else if (pokemonname.equals("gengar")) {

			String[] possiblemoves = {"toxic", "confuseray", "shadowball", "sludgebomb", "suckerpunch", "focusblast", "thunderbolt",}; // array of possible moves for this pokemon
			String[] abbreviated = {"tx", "cr", "sb", "su", "sp", "fb", "tb"};// array of the abbreviated moves
			String[] explain = {"[this move poisons the opponent and the poison damage increases over time(poison types can't miss)]", " [confuses the opponent]", " [an 80 power ghost move , 30 % chance for opposing spdef reduction] ", "[an 85 base power poison move with a 30% chance to poison]  ", " [An 80 base power move that only works if the opponent uses an attack]", " [A 120 base power fighting move with 70 accuracy] ", " [ A zap of electricity at the opponent, a 90 power electic move with 100 accuracy]"};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv2 = scan.nextLine();

			while (legitmove2(possiblemoves, abbreviated, mv2, move1) != true) { // sends arrays and the mv2 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv2 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv2.equals(abbreviated[o])) {

					mv2 = possiblemoves[o];
				}


			}

		} else if (pokemonname.equals("espeon")) {
			String[] possiblemoves = {"psychic", "shadowball", "quickattack", "calmmind", "dazzlinggleam", "hiddenpower", "morningsun"}; // array of possible moves for this pokemon
			String[] abbreviated = {"ps", "sb", "qa", "cm", "dg", "hp", "ms"};// array of the abbreviated moves
			String[] explain = {" [A 90 base power psychic move with a 10% chance of a reduction in opponent's spdef] ", " [an 80 base power ghost move with a 30% chance to reduce opponent spdef] ", " [a 40 base power move that usually hits first] ", "[raises special attack and special defense] ", "[An 80 base power fairy move]  ", "[A 60 base power move that can be any type the user desires] ", " [User heals itself by 1/2 of its max hp ]"};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv2 = scan.nextLine();

			while (legitmove2(possiblemoves, abbreviated, mv2, move1) != true) { // sends arrays and the mv2 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv2 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv2.equals(abbreviated[o])) {

					mv2 = possiblemoves[o];
				}


			}

		} else if (pokemonname.equals("jolteon")) {

			String[] possiblemoves = {"thunderbolt", "shadowball", "hiddenpower", "toxic", "pinmissle", "doublekick", "thunderwave"}; // array of possible moves for this pokemon
			String[] abbreviated = {"tb", "sb", "hp", "tx", "pm", "dk", "tw"};// array of the abbreviated moves
			String[] explain = {" [A 90 base power electric attack with a 10 % chance of paralysis]", "[a 80 power ghost special move with a 30 percent chance to reduce spdef]  ", " [A 60 base power move that can be any type the user desires]  ", " [this move poisons the opponent and the poison damage increases over time(poison types can't miss)] ", " [A physical bug move that can be 15,30,45,60,0r 75 base power]  ", " [A 60 base power physical fighting move] ", " [Has a 90 percent chance to paralyze opponent] "};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv2 = scan.nextLine();

			while (legitmove2(possiblemoves, abbreviated, mv2, move1) != true) { // sends arrays and the mv2 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv2 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv2.equals(abbreviated[o])) {

					mv2 = possiblemoves[o];
				}


			}

		} else if (pokemonname.equals("glaceon")) {
			String[] possiblemoves = {"icebeam", "hiddenpower", "shadowball", "iceshard", "waterpulse", "blizzard", "toxic"}; // array of possible moves for this pokemon
			String[] abbreviated = {"ib", "hp", "sb", "is", "wp", "bz", "tx"};// array of the abbreviated moves
			String[] explain = {" [A beam of ice that is shot at the opponent, 90 base power ,10% chance to freeze] ", "[A 60 base power move that can be any type the user desires] ", "[ An 80 base power ghost move with a 30 % chance to spdef drop]  ", "[A fast ice type physical attack, 40 base power]  ", "[A  60 base power water move with a 20 percent chance to confuse the opponent]  ", "[A 110 base power ice move with 70 accuracy] ", "[this move poisons the opponent and the poison damage increases over time(poison types can't miss)]  "};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv2 = scan.nextLine();

			while (legitmove2(possiblemoves, abbreviated, mv2, move1) != true) { // sends arrays and the mv2 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv2 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv2.equals(abbreviated[o])) {

					mv2 = possiblemoves[o];
				}


			}

		} else if (pokemonname.equals("sylveon")) {
			String[] possiblemoves = {"moonblast", "hyperbeam", "shadowball", "calmmind", "toxic", "dazzlinggleam", "hiddenpower"}; // array of possible moves for this pokemon
			String[] abbreviated = {"mb", "hb", "sb", "cm", "tx", "dg", "hp"};// array of the abbreviated moves
			String[] explain = {"[A 95 base power fairy move with a 30% chance to reduce special attack] ", " [A fairy beam is shot at the opponent, 150 base power, 90 accuracy , one turn recharge]  ", " [An 80 power ghost move that reduces spdef 30% of the time] ", " [raises special attack and special defense] ", " [this move poisons the opponent and the poison damage increases over time(poison types can't miss)] ", "[ An 80 base power fairy move] ", " [A 60 base power move that can be any type the user desires]  "};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv2 = scan.nextLine();

			while (legitmove2(possiblemoves, abbreviated, mv2, move1) != true) { // sends arrays and the mv2 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv2 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv2.equals(abbreviated[o])) {

					mv2 = possiblemoves[o];
				}


			}

		} else if (pokemonname.equals("umbreon")) {
			String[] possiblemoves = {"toxic", "moonlight", "quickattack", "confuseray", "hiddenpower", "darkpulse", "foulplay"}; // array of possible moves for this pokemon
			String[] abbreviated = {"tx", "ml", "qa", "cr", "hp", "dp", "fp"};// array of the abbreviated moves
			String[] explain = {" [this move poisons the opponent and the poison damage increases over time(poison types can't miss)] ", " [[Heals user by 1/2 of max hp] ", " [40 base power fast normal move] ", " [confuses the opponent] ", "[A 60 base power move that can be any type the user desires]   ", " [An 80 base power dark move with a 10% chance to flinch] ", " [An 80 base power move that uses the opponents attack]"};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv2 = scan.nextLine();

			while (legitmove2(possiblemoves, abbreviated, mv2, move1) != true) { // sends arrays and the mv2 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv2 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv2.equals(abbreviated[o])) {

					mv2 = possiblemoves[o];
				}


			}

		} else if (pokemonname.equals("leafeon")) {
			String[] possiblemoves = {"swordsdance", "leafblade", "toxic", "return", "xscissor", "synthesis", "aerialace"}; // array of possible moves for this pokemon
			String[] abbreviated = {"sd", "lb", "tx", "re", "xs", "sy", "aa"};// array of the abbreviated moves
			String[] explain = {"[Sharply raises attack]", " [A grass attack with a higher chance of crits, 70 base power] ", " [this move poisons the opponent and the poison damage increases over time(poison types can't miss)] ", "[a 102 base power normal physical attack]  ", "[80 base power bug move]  ", " [User recovers 1/2 of its max hp] ", " [60 base power flying move that never misses] "};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv2 = scan.nextLine();

			while (legitmove2(possiblemoves, abbreviated, mv2, move1) != true) { // sends arrays and the mv2 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv2 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv2.equals(abbreviated[o])) {

					mv2 = possiblemoves[o];
				}


			}

		} else if (pokemonname.equals("vaporeon")) {
			String[] possiblemoves = {"hydropump", "icebeam", "aquaring", "toxic", "hiddenpower", "shadowball", "surf"}; // array of possible moves for this pokemon
			String[] abbreviated = {"hd", "ib", "ar", "tx", "hp", "sb", "su"};// array of the abbreviated moves
			String[] explain = {"[A 110 base power water move, 80 accuracy]   ", " [A 90 base power ice move with 10% chance to freeze] ", " [The user starts gaining a little hp every turn] ", " [this move poisons the opponent and the poison damage increases over time(poison types can't miss)] ", " [A 60 base power move that can be any type the user desires]  ", " [A base 80 power ghost move, 30% chance to reduce spdef] ", " [A 95 base power water move] "};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv2 = scan.nextLine();

			while (legitmove2(possiblemoves, abbreviated, mv2, move1) != true) { // sends arrays and the mv2 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv2 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv2.equals(abbreviated[o])) {

					mv2 = possiblemoves[o];
				}


			}

		} else if (pokemonname.equals("flareon")) {
			String[] possiblemoves = {"flareblitz", "bulkup", "toxic", "willowisp", "return", "hiddenpower", "superpower"}; // array of possible moves for this pokemon
			String[] abbreviated = {"fb", "bu", "tx", "ww", "re", "hp", "sp"};// array of the abbreviated moves
			String[] explain = {" [A 120 base power physical fire move but the user takes 1/3 of the damage as recoil] ", " [raises this pokemon's attack and defense] ", " [this move poisons the opponent and the poison damage increases over time(poison types can't miss)] ", " [burns the opponent 85 percent of the time] ", " [a 102 base power normal physical attack] ", " [A 60 base power move that can be any type the user desires]  ", " [A 120 power fighting move that reduces the user's attack and defense] "};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv2 = scan.nextLine();

			while (legitmove2(possiblemoves, abbreviated, mv2, move1) != true) { // sends arrays and the mv2 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv2 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv2.equals(abbreviated[o])) {

					mv2 = possiblemoves[o];
				}


			}

		} else if (pokemonname.equals("scizor")) {

			String[] possiblemoves = {"bulletpunch", "nightslash", "xscissor", "slash", "quickattack", "gigaimpact", "swordsdance"}; // array of possible moves for this pokemon
			String[] abbreviated = {"bp", "ns", "xs", "s", "qa", "qi", "sd"};// array of the abbreviated moves
			String[] explain = {" [A 40 base power steel move that often moves first] ", "  [A 70 base power dark move with a higher chance of crits]  ", " [An 80 base power bug move] ", " [A 70 base power normal move with a higher chance of crits] ", "  [A 40 base power normal move that often moves first]", "[A 150 base power normal move, recharge required]  ", " [Sharply raises attack] "};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv2 = scan.nextLine();

			while (legitmove2(possiblemoves, abbreviated, mv2, move1) != true) { // sends arrays and the mv2 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv2 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv2.equals(abbreviated[o])) {

					mv2 = possiblemoves[o];
				}


			}

		} else if (pokemonname.equals("hydreigon")) {
			String[] possiblemoves = {"nastyplot", "dragonpulse", "flashcannon", "flamethrower", "surf", "darkpulse", "dracometeor"}; // array of possible moves for this pokemon
			String[] abbreviated = {"np", "dp", "fc", "ft", "su", "dpu", "dm"};// array of the abbreviated moves
			String[] explain = {" [Sharply raises special attack] ", "[An 80 power base dragon move]  ", " [A 90 base power steel move] ", " [A 95 base power fire move with a 10% chance to burn] ", " [A 95 base power water move] ", " [An 80 base power dark move with a chance to flinch(20 %)] ", " [A 120 base power special dragon move, reduces the user's special attack] "};

			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv2 = scan.nextLine();

			while (legitmove2(possiblemoves, abbreviated, mv2, move1) != true) { // sends arrays and the mv2 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv2 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv2.equals(abbreviated[o])) {

					mv2 = possiblemoves[o];
				}


			}

		} else if (pokemonname.equals("meloetta")) {
			String[] possiblemoves = {"workup", "relicsong", "psychic", "closecombat", "thunderbolt", "icepunch", "firepunch"}; // array of possible moves for this pokemon
			String[] abbreviated = {"wu", "rs", "ps", "cc", "tb", "ip", "fp"};// array of the abbreviated moves
			String[] explain = {" [increases attack and special attack]", "[A 80 base power move that changes meloetta to pirouette form with different stats] ", " [A 90 base power psychic move with a 10 % to reduce spdef] ", " [A 120 base power fighting move that reduces spdef and def] ", "[A zap of electricity (90 power); 10% chance to paralyze ", "[a punch of icy coldness, 75 base power; 10 percent chance to freeze]  ", "[A punch of fiery wrath;75 base power; 10 percent chance to burn]  "};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv2 = scan.nextLine();

			while (legitmove2(possiblemoves, abbreviated, mv2, move1) != true) { // sends arrays and the mv2 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv2 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv2.equals(abbreviated[o])) {

					mv2 = possiblemoves[o];
				}


			}

		} else if (pokemonname.equals("archeops")) {
			String[] possiblemoves = {"honeclaws", "earthquake", "rockslide", "stoneedge", "crunch", "dragonclaw", "aquatail"}; // array of possible moves for this pokemon
			String[] abbreviated = {"hc", "ea", "rs", "se", "cr", "dc", "at"};// array of the abbreviated moves
			String[] explain = {" [Raises attack and accuracy] ", " [A 100 base power ground move] ", " [a lot of rocks are slammed on the opponent , 30% chance to flinch ] ", " [A 100 base power rock move with a higher chance of crits and 80 accuracy] ", " [An 80 base power dark move; 10% chance to flinch] ", " [An 80 base power dragon pulse] ", " [A move that has a 90% chance to hit with 90 water based power]"};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv2 = scan.nextLine();

			while (legitmove2(possiblemoves, abbreviated, mv2, move1) != true) { // sends arrays and the mv2 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv2 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv2.equals(abbreviated[o])) {

					mv2 = possiblemoves[o];
				}


			}

		} else if (pokemonname.equals("crobat")) {


			String[] possiblemoves = {"bravebird", "crosspoison", "confuseray", "toxic", "superfang", "leechlife", "steelwing", "roost"}; // array of possible moves for this pokemon
			String[] abbreviated = {"bb", "cp", "cr", "tx", "sf", "ll", "sw", "ro"};// array of the abbreviated moves
			String[] explain = {" [A 120 base power flying move, user takes 1/3 recoil]", "[an 80 base power poison move with a high crit rate ]", "[Confuses the opponent]", "[the opponent is poisoned and takes more damage over time  ] ", " [The opponent loses half of its health ]", "[ a 80 base power bug move, user regains 1/2 of damage as hp] ", " [sharp steel wings are slashed at the opponent, 70 power 90 accuracy] ", "[the user roosts and regains hp, user loses flying temporarily] "};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv2 = scan.nextLine();

			while (legitmove2(possiblemoves, abbreviated, mv2, move1) != true) { // sends arrays and the mv2 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv2 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv2.equals(abbreviated[o])) {

					mv2 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("manaphy")) {

			String[] possiblemoves = {"tailglow", "surf", "energyball",  "shadowball", "psychic", "dazzlinggleam", "icebeam"}; // array of possible moves for this pokemon
			String[] abbreviated = {"tg", "su", "eb", "sb", "ps", "dg", "ib"};// array of the abbreviated moves
			String[] explain = {" [An over powered move that boosts the special attack of the user. Manaphy's secret weapon]",
					"[A wave of water washes the opponent, 95 power move ]",
					"[A ball of grassy naturs hits the opponent, 90 power, 20% of a spdef drop]",
					" [A shadowball sniped the opponent, ghost 80 power move with a 30% chance of a spdef drop]", "[ A psychic wave is shot at the opponent, 90 power, 10% for a special def drop] ", " [A bright light hits the opponent, an 80 power fairy move] ", "[An icy beam hits the oponent, 90 power, 20% chance of freeze] "};



			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv2 = scan.nextLine();

			while (legitmove2(possiblemoves, abbreviated, mv2, move1) != true) { // sends arrays and the mv2 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv2 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv2.equals(abbreviated[o])) {

					mv2 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("jirachi")) {

			String[] possiblemoves = {"thunderwave", "ironhead", "firepunch", "icepunch", "thunderbolt", "psychic", "dazzlinggleam", "calmmind"}; // array of possible moves for this pokemon
			String[] abbreviated = {"tw", "ih", "fp", "ip", "tb", "ps", "dg", "cm"};// array of the abbreviated moves
			String[] explain = {" [paralyzes the opponent, Can help in para-flinching]", "[user bashes opponent with a steel head, 80 power move, 30% chance to flinch]", "[The opponent is hit with a fiery punch, 75 power 20% chance to burn]", "[the user hits the opponent with an icy punch, 75 power 20% chance to freeze] ", " [The opponent is hit with a lightningbolt 90 power 20% chance to paralyze]", "[ A psychic wave is shot at the opponent, 90 power, 10% for a special def drop] ", " [A bright light hits the opponent, an 80 power fairy move] ", "[The user focuses and increases its special attack and special defense] "};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv2 = scan.nextLine();

			while (legitmove2(possiblemoves, abbreviated, mv2, move1) != true) { // sends arrays and the mv2 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv2 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv2.equals(abbreviated[o])) {

					mv2 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("melmetal")) {

			String[] possiblemoves = {"thunderpunch", "thunderwave", "doubleironbash", "superpower", "icepunch", "earthquake", "rockslide"}; // array of possible moves for this pokemon
			String[] abbreviated = {"tp", "tw", "db", "sp", "ip", "e", "rs"};// array of the abbreviated moves
			String[] explain = {"[The opponent is hit with an electriv punch, 75 power, 10% chance to paralyze]", " [paralyzes the opponent, Can help in para-flinching]", "[user bashes opponent with big boi arms , 120 power move]", "[The opponent is hit with secret fighting power, 120 power, reduces attack and defense]", "[the user hits the opponent with an icy punch, 75 power 20% chance to freeze] ", " [The opponent is hit with an earthquake]", "[ The user slams rocks on the opponent, 75 power, 30% chance to flinch, 95 accuracy] "};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv2 = scan.nextLine();

			while (legitmove2(possiblemoves, abbreviated, mv2, move1) != true) { // sends arrays and the mv2 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv2 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv2.equals(abbreviated[o])) {

					mv2 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("kingdra")) {


			String[] possiblemoves = {"waterfall", "dragondance", "hydropump", "dragonpulse", "flashcannon", "bodyslam", "yawn", "focusenergy"}; // array of possible moves for this pokemon
			String[] abbreviated = {"wf","dd", "hp", "dp", "fc", "bs", "y", "fe"};// array of the abbreviated moves
			String[] explain = {"[An 80 base power physical water move]", "[boosts attack and speed]", "[user hits the target with a 110 power water type move]", "[An 80 power dragon move]", "[The opponent is hit with a steel beam, 90 power, has a chance of reducing spdef]", "[the user hits the opponent with its body, 80 power 30% chance to paralyse the opponent] ", " [The user makes the opponent tired and sleep after one turn]", "[ Increases the chances of crits] "};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv2 = scan.nextLine();

			while (legitmove2(possiblemoves, abbreviated, mv2, move1) != true) { // sends arrays and the mv2 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv2 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv2.equals(abbreviated[o])) {

					mv2 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("machamp")) {


			String[] possiblemoves = {"bulkup", "dynamicpunch", "crosschop", "bulletpunch", "firepunch", "icepunch", "thunderpunch", "focusenergy"}; // array of possible moves for this pokemon
			String[] abbreviated = {"bu", "dp", "cc", "bp", "fp", "ip", "tp", "fe"};// array of the abbreviated moves
			String[] explain = {"[raises attack and defense]", " [Machamp bashes its opponent with a 100 power move that confuses the opponent]", "[user hits the target with a 100 power fighting type high crit rate move]", "[An 40 power steel priority move]", "[The opponent is hit with a fiery punch, 75 power, 10% chance to burn]", "[the user hits an icy punch, 75 power, 10% chance to freeze] ", " [The user uses an electric punch to hit the opponent, 75 power; 10% chance to paralyze]", "[ Increases the chances of crits] "};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv2 = scan.nextLine();

			while (legitmove2(possiblemoves, abbreviated, mv2, move1) != true) { // sends arrays and the mv2 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv2 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv2.equals(abbreviated[o])) {

					mv2 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("milotic")) {

			String[] possiblemoves = {"hydropump", "aquaring", "toxic", "confuseray", "icebeam", "recover", "hiddenpower"}; // array of possible moves for this pokemon
			String[] abbreviated = {"hy", "aq", "tx", "cr", "ib", "re", "hp"};// array of the abbreviated moves
			String[] explain = {" [the user attacks with a 110 water power move]", "[user starts regaining hp every turn]", "[Poisons the opponent and makes them take more damage over time]", "[ Confuses the opponent]", "[the user hits an icy beam, 90 power, 10% chance to freeze] ", " [User regains half of its max hp]", "[ A 60 power move that can be any type the user desires] "};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv2 = scan.nextLine();

			while (legitmove2(possiblemoves, abbreviated, mv2, move1) != true) { // sends arrays and the mv2 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv2 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv2.equals(abbreviated[o])) {

					mv2 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("chandelure")) {

			String[] possiblemoves = {"energyball", "flamethrower", "calmmind", "confuseray", "shadowball", "willowisp", "psychic"}; // array of possible moves for this pokemon
			String[] abbreviated = {"eb", "ft", "cm", "cr", "sb", "ww", "ps"};// array of the abbreviated moves
			String[] explain = {" [the user attacks with a 90 grass power move with a 10 percent chance to reduce spdef]", "[user shoots fire at the opponent, 90 power 10% chance to burn]", "[User increases its spa and Spdef stats]", "[ Confuses the opponent]", "[the user hits a ball of shadow, 80 power, 30% chance to drop spdef of opponent] ", " [Burns the opponent 90 percent of the time]", "[ A 90 power psychic move that hits for 90 power and has a 10% for a spdef drop] "};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv2 = scan.nextLine();

			while (legitmove2(possiblemoves, abbreviated, mv2, move1) != true) { // sends arrays and the mv2 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv2 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv2.equals(abbreviated[o])) {

					mv2 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("dragonite")) {

			String[] possiblemoves = {"extremespeed", "dragondance", "thunderwave", "dragonclaw", "dracometeor", "firepunch", "icepunch", "thunderpunch", "superpower"}; // array of possible moves for this pokemon
			String[] abbreviated = {"es", "dd", "tw", "dc", "dm", "fp", "ip", "tp", "sp"};// array of the abbreviated moves
			String[] explain = {"[an 80 base power normal move that hits fast and hard]", "[boosts attack and speed]", " [paralyzes opponent]", "[user hits the target with 80 power dragon power]", "[An 120 power dragon move that reduces special attack of the user ]", "[The opponent is hit with a fiery punch, 75 power, 10% chance to burn]", "[the user hits an icy punch, 75 power, 10% chance to freeze] ", " [The user uses an electric punch to hit the opponent, 75 power; 10% chance to paralyze]", "[ user attacks with 120 power of fighting power, reduces attack and defense of the user] "};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv2 = scan.nextLine();

			while (legitmove2(possiblemoves, abbreviated, mv2, move1) != true) { // sends arrays and the mv2 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv2 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv2.equals(abbreviated[o])) {

					mv2 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("salamence")) {

			String[] possiblemoves = {"dragondance", "earthquake", "dragonclaw", "dracometeor", "rockslide", "flamethrower", "airslash", "focusenergy"}; // array of possible moves for this pokemon
			String[] abbreviated = {"dd", "eq", "dc", "dm", "rs", "ft", "as", "fe"};// array of the abbreviated moves
			String[] explain = {"[boosts attack and speed]", " [A 100 power ground move]", "[user hits the target with 80 power dragon power]", "[An 120 power dragon move that reduces special attack of the user ]", "[The opponent is hit with a lot of rocks, 75 power, 30% chance to flinch]", "[the user hits the opponent with flames 90 power, 10% chance to burn] ", " [ The user slashes air at the opponent, 30% chance to flinch]", "[ increases the user's chances of a crit] "};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv2 = scan.nextLine();

			while (legitmove2(possiblemoves, abbreviated, mv2, move1) != true) { // sends arrays and the mv2 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv2 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv2.equals(abbreviated[o])) {

					mv2 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("greninja")) {
			String[] possiblemoves = {"watershuriken", "extrasensory", "hydropump", "surf", "icebeam", "gunkshot", "darkpulse", "hiddenpower"}; // array of possible moves for this pokemon
			String[] abbreviated = {"ws", "ex", "hpu", "su", "ib", "gs", "dp", "hp"};// array of the abbreviated moves
			String[] explain = {"[The pokemon yeets some shurikens at the opponent, usually goes first]",
					" [80 base power psychic move with 100 accuracy, can sometimes flinch] ",
					" [A 110 power water move that has 80 accuracy] ",
					"[A 95 power water move with 100 accuracy]  ",
					" [An icy beam is shot at the opponent, ice type 90 base power, 10% chance to freeze] ",
					" [A poison blast is shot at the opponent, has a 30% chance to poison the opponent]  ",
					" [A dark aura is projected at the opponent, has a 20% chance to flinch] ",
					" [A mysterious blast is shot at the opponent, the user chooses its type]"};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv2 = scan.nextLine();

			while (legitmove2(possiblemoves, abbreviated, mv2, move1) != true) { // sends arrays and the mv2 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv2 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv2.equals(abbreviated[o])) {

					mv2 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("zeraora")) {
			String[] possiblemoves = {"bulkup", "thunderwave", "toxic", "closecombat", "plasmafists", "drainpunch", "firepunch", "playrough"}; // array of possible moves for this pokemon
			String[] abbreviated = {"bu", "tw", "tx", "cc", "pf", "dp", "fp", "pr"};// array of the abbreviated moves
			String[] explain = {" [increases attack and defense]",
					"[paralyzes opponent] ",
					" [poisons opponent, opponent takes damage every turn, they're screwed if they can't win quickly] ",
					" [A 120 base power fighting move that reduces spdef and def] ",
					"[A mega-powerful electric punch, based 100 power] ",
					"[a punch of toxicity, 75 base power; the user gains some health back]  ",
					"[A punch of fiery wrath;75 base power; 10 percent chance to burn]  ",
					"[A 90 base power fairy move, has a chance to reduce the opponent's attack]"};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv2 = scan.nextLine();

			while (legitmove2(possiblemoves, abbreviated, mv2, move1) != true) { // sends arrays and the mv2 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv2 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv2.equals(abbreviated[o])) {

					mv2 = possiblemoves[o];
				}


			}

		} else if (pokemonname.equals("togekiss")) {

			String[] possiblemoves = {"dazzlinggleam", "roost", "aurasphere", "flamethrower", "nastyplot",
					"thunderwave", "shadowball", "airslash", "psychic", "extremespeed"}; // array of possible moves for this pokemon
			String[] abbreviated = {"dg", "roo", "asp", "ft", "np", "tw", "sb", "as", "ps", "es"};// array of the abbreviated moves
			String[] explain = {"[An 80 base power fairy move]",
					"[Heals user but the user loses their flying type for a turn]",
					"[the user attacks with an 80 power fighting move that never misses]",
					"[user shoots fire at the opponent, 90 power 10% chance to burn]",
					"[User sharply increases its special attack]",
					"[paralyzes the opponent, 90 accuracy]",
					"[the user hits a ball of shadow, 80 power, 30% chance to drop spdef of opponent] ",
					"[The opponent gets slashed with some crisp clean air, 30% flinch rate]",
					"[ A 90 power psychic move that hits for 90 power and has a 10% for a spdef drop] ",
					"[The fastest move in the game, always moves first, 80 base power, it is speed, gotta go fast]"};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv2 = scan.nextLine();

			while (legitmove2(possiblemoves, abbreviated, mv2, move1) != true) { // sends arrays and the mv2 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv2 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv2.equals(abbreviated[o])) {

					mv2 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("volcarona")) {

			String[] possiblemoves = {"hiddenpower", "flamethrower", "calmmind", "quiverdance", "bugbuzz", "wildcharge", "psychic"}; // array of possible moves for this pokemon
			String[] abbreviated = {"hp", "ft", "cm", "qd", "bb", "wc", "ps"};// array of the abbreviated moves
			String[] explain = {" [the user attacks with a 60 base power special attack of any type]",
					"[user shoots fire at the opponent, 90 power 10% chance to burn]",
					"[User increases its spa and Spdef stats]",
					"[ calm mind on steroids: also boosts speed, is super overpowered]",
					"[the user screeches reeeeeeeee, 90 power, 10% chance to drop spdef of opponent] ",
					"[hits the opponent with a 90 power physical electric type attack, hurts user as well]",
					"[A 90 power psychic move that hits for 90 power and has a 10% for a spdef drop] "};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv2 = scan.nextLine();

			while (legitmove2(possiblemoves, abbreviated, mv2, move1) != true) { // sends arrays and the mv2 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv2 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv2.equals(abbreviated[o])) {

					mv2 = possiblemoves[o];
				}


			}

		} else if (pokemonname.equals("pikachu")) {

			String[] possiblemoves = {"honeclaws", "thunderbolt", "volttackle", "hiddenpower", "toxic", "extremespeed", "quickattack", "thunderwave", "surf", "horndrill"}; // array of possible moves for this pokemon
			String[] abbreviated = {"hc", "tb", "vt", "hp", "tx", "es", "qa", "tw", "su", "hd"};// array of the abbreviated moves
			String[] explain = {"[Raises accuracy of attacks and increases their power] (I gave it to pikachu cause I felt like it)", " [A 90 base power electric attack with a 10 % chance of paralysis]",
					" [a 120 base power electric tackle attack, causes recoil but it goes hard]  ",
					" [A 60 base power move that can be any type the user desires]  ",
					" [this move poisons the opponent and the poison damage increases over time(poison types can't miss)] ",
					" [ha ha fast pikachu goes brrr (an 80 base power move that ussually hits first)]  ",
					" [A weaker extremespeed (just use extremespeed)] ",
					" [Has a 90 percent chance to paralyze opponent] ",
					" [A 90 base power watermove, yup I let pikachu learn this with lightball boosting its stats, it needs all the help it can get]",
					" [A move with a 30% chance to one-shot the opponent, pikachu shouldn't be able to learn this but I just want to see the power of friendship lol."};

			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv2 = scan.nextLine();

			while (legitmove2(possiblemoves, abbreviated, mv2, move1) != true) { // sends arrays and the mv2 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv2 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv2.equals(abbreviated[o])) {

					mv2 = possiblemoves[o];
				}


			}

		} else if (pokemonname.equals("mimikyu")) {
			String[] possiblemoves = {"swordsdance", "thunderwave", "toxic", "bulkup", "leechlife", "drainpunch", "shadowclaw", "playrough", "shadowsneak"}; // array of possible moves for this pokemon
			String[] abbreviated = {"sd", "tw", "tx", "bu", "ll", "dp", "sc", "pr", "ss"};// array of the abbreviated moves
			String[] explain = {" [sharply increases attack]",
					"[paralyzes opponent] ",
					"[poisons opponent, opponent takes damage every turn, they're screwed if they can't win quickly] ",
					"[raises attack and defense] ",
					"[An 80 power bug move that drains the opponent's hp and heals you] ",
					"[a punch of toxicity, 75 base power; the user gains some health back]  ",
					"[A slash of sinister intent, 75 power, high crit rate]  ",
					"[A 90 base power fairy move, has a chance to reduce the opponent's attack]",
					"[You hit the opponent with a 40 base power ghostly sneak attack like they owe you money]"};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv2 = scan.nextLine();

			while (legitmove2(possiblemoves, abbreviated, mv2, move1) != true) { // sends arrays and the mv2 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv2 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv2.equals(abbreviated[o])) {

					mv2 = possiblemoves[o];
				}


			}

		} else if (pokemonname.equals("noivern")) {
			String[] possiblemoves = {"boomburst", "dragonpulse", "moonlight", "flamethrower", "toxic", "darkpulse", "dracometeor", "psychic", "superfang"}; // array of possible moves for this pokemon
			String[] abbreviated = {"bb", "dp", "ml", "ft", "tx", "dpu", "dm", "ps", "sf"};// array of the abbreviated moves
			String[] explain = {" [a 150 power normal move, loud noise go brrrr] ",
					"[An 80 power base dragon move]  ",
					" [the user heals some of their health back] ",
					" [A 95 base power fire move with a 10% chance to burn] ",
					" [poisons the opponent with a toxin] ",
					" [An 80 base power dark move with a chance to flinch(20 %)] ",
					" [A 120 base power special dragon move, reduces the user's special attack] ",
					" [Mind melt, 90 power psychic move, can reduce special defense]",
					" [Halves the opponent's hp, slicey dicey]"};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv2 = scan.nextLine();

			while (legitmove2(possiblemoves, abbreviated, mv2, move1) != true) { // sends arrays and the mv2 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv2 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv2.equals(abbreviated[o])) {

					mv2 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("hawlucha")) {

			String[] possiblemoves = {"bravebird", "ironhead", "rockslide", "honeclaws", "brickbreak", "swordsdance", "poisonjab", "roost"}; // array of possible moves for this pokemon
			String[] abbreviated = {"bbi", "ih", "rs", "hc", "bb", "sd", "pj", "roo"};// array of the abbreviated moves
			String[] explain = {" [a 120 base power flying move, hurts the user too tho]", "[an 80 power steel move with a 30% chance to flinch ]", "[a lot of rocks are slammed on the opponent , 30% chance to flinch ] ", " [Boosts the user's attack and accuracy]", "[ a 75 base power fighting move] ", " [sharply raises the user's attack] ", "[the user jabs the opponent with poison, 30 % chance to poison] ", "[Heals the user but they lose their flying type for a turn]"};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv2 = scan.nextLine();

			while (legitmove2(possiblemoves, abbreviated, mv2, move1) != true) { // sends arrays and the mv2 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv2 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv2.equals(abbreviated[o])) {

					mv2 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("zoroark")) {

			String[] possiblemoves = {"honeclaws", "brickbreak", "nastyplot", "nightslash", "darkpulse", "shadowball", "sludgebomb", "suckerpunch", "focusblast", "flamethrower",}; // array of possible moves for this pokemon
			String[] abbreviated = {"hc", "bb", "np", "ns", "dpu", "sba", "sb", "sp", "fb", "ft"};// array of the abbreviated moves
			String[] explain = {"[A move that raises physical attack and accuracy]",
					"[A 75 base power fighting move]",
					"[This move sharply raises special attack]",
					"[a base 75 power dark slashing move, someone's getting sniped]",
					" [a dark aura is shot at the opponent, a chance to flinch is present]",
					" [an 80 power ghost move , 30 % chance for opposing spdef reduction] ",
					"[an 85 base power poison move with a 30% chance to poison]  ",
					" [An 80 base power move that only works if the opponent uses an attack]",
					" [A 120 base power fighting move with 70 accuracy] ",
					" [ Your opponent gets hit with fire, a 90 power fire move with 100 accuracy]"};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv2 = scan.nextLine();

			while (legitmove2(possiblemoves, abbreviated, mv2, move1) != true) { // sends arrays and the mv2 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv2 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv2.equals(abbreviated[o])) {

					mv2 = possiblemoves[o];
				}


			}

		} else if (pokemonname.equals("garchomp")) {

			String[] possiblemoves = {"firefang", "flamethrower", "dragonclaw", "rockslide", "brickbreak",
					"earthquake", "crunch", "swordsdance", "ironhead", "poisonjab", "dracometeor"}; // array of possible moves for this pokemon
			String[] abbreviated = {"ff", "ft", "dc", "rs", "bb",
					"ea", "cr", "sd", "ih", "pj", "dm"};// array of the abbreviated moves
			String[] explain = {"[a 65 power physical fire move (95 accuracy) 10 percent chance to burn or flinch]",
					"  [a 90 power special fire move (100 accuracy) 10 percent chance to burn] ",
					" [an 80 base power dragon type move] ",
					" [a lot of rocks are slammed on the opponent , 30% chance to flinch ] ",
					" [ a 75 base power fighting move] ",
					" [a 100 base ground move] ",
					" [an 80 power dark move that crunches opponent, 20 percent chance for defense drop] ",
					" [Boosts attack, makes a pokemon go from good to overpowered in one turn]",
					" [An 80 base power steel move wrecks fairies and ice pokemon]",
					" [An 85 base power toxic jab that can poison the opponent]",
					" [Asteroids fall from the sky and obliterate all in their path, 120 base power, harshly reduces special attack]"
			};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv2 = scan.nextLine();

			while (legitmove2(possiblemoves, abbreviated, mv2, move1) != true) { // sends arrays and the mv2 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv2 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv2.equals(abbreviated[o])) {

					mv2 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("tyranitar")) {

			String[] possiblemoves = {"icepunch", "flamethrower", "surf", "rockslide",
					"brickbreak", "earthquake", "crunch", "dragondance", "darkpulse", "thunderbolt"}; // array of possible moves for this pokemon
			String[] abbreviated = {"ip", "ft", "su", "rs",
					"bb", "ea", "cr", "dd", "dp", "tb"};// array of the abbreviated moves
			String[] explain = {
					"[a 75 base power ice move, dragons hate it lol]",
					"  [a 90 power special fire move (100 accuracy) 10 percent chance to burn] ",
					" [a 90 base power water move] ",
					" [a lot of rocks are slammed on the opponent , 30% chance to flinch ] ",
					" [ a 75 base power fighting move] ",
					" [a 100 base ground move] ",
					" [an 80 power dark move that crunches opponent, 20 percent chance for defense drop] ",
					" [Boosts attack, makes a pokemon go from good to overpowered in one turn, raises attack and speed]",
					" [An 80 base power dark move wrecks psychic and ghost pokemon]",
					" [An 90 base power electric shock that can paralyze the opponent]"
			};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv2 = scan.nextLine();

			while (legitmove2(possiblemoves, abbreviated, mv2, move1) != true) { // sends arrays and the mv2 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv2 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv2.equals(abbreviated[o])) {

					mv2 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("lucario")) {

			String[] possiblemoves = {"calmmind", "dragonpulse", "aurasphere", "closecombat", "swordsdance",
					"bulletpunch", "shadowball", "meteormash", "psychic", "extremespeed", "flashcannon"}; // array of possible moves for this pokemon
			String[] abbreviated = {"cm", "dpu", "asp", "cc", "sd", "bp", "sb", "mm", "ps", "es", "fc"};// array of the abbreviated moves
			String[] explain = {"[boosts special attack and special defense]",
					"[User expels their inner dragon, 80 base power special attack]",
					"[the user attacks with an 80 power fighting move that never misses]",
					"[user hits the opponent up close, the opponent gets jumped, the user's defenses lower however]",
					"[User sharply increases its physical attack]",
					"[a punch as fast as my internet, 40 base power steel move]",
					"[the user hits a ball of shadow, 80 power, 30% chance to drop spdef of opponent] ",
					"[The opponent gets mashed with some crisp clean steel, may raise attack but also may miss]",
					"[ A psychic move that hits for 90 power and has a 10% for a spdef drop] ",
					"[The fastest move in the game, always moves first, 80 base power, it is speed, gotta go fast]",
					"[A steel beam is shot at the opponent, 90 base power, can reduce spdef]"};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv2 = scan.nextLine();

			while (legitmove2(possiblemoves, abbreviated, mv2, move1) != true) { // sends arrays and the mv2 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv2 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv2.equals(abbreviated[o])) {

					mv2 = possiblemoves[o];
				}


			}
		} else if (pokemonname.equals("flygon")) {

			String[] possiblemoves = {"dragondance", "earthquake", "dragonclaw", "dracometeor",
					"rockslide", "flamethrower", "boomburst", "crunch", "bugbuzz"}; // array of possible moves for this pokemon
			String[] abbreviated = {"dd", "eq", "dc", "dm",
					"rs", "ft", "bb", "cr", "bu"};// array of the abbreviated moves
			String[] explain = {"[boosts attack and speed]", " [A 100 power ground move]", "[user hits the target with 80 power dragon power]", "[An 120 power dragon move that reduces special attack of the user ]"
					, "[The opponent is hit with a lot of rocks, 75 power, 30% chance to flinch]", "[the user hits the opponent with flames 90 power, 10% chance to burn] ", " [ The user screeches reeeeeee, a 150 base power normal move]", "[ An 80 base power dark move that can reduce defense] ", "[The user screeches reeee in bug language, a 90 power bug type attack]"};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv2 = scan.nextLine();

			while (legitmove2(possiblemoves, abbreviated, mv2, move1) != true) { // sends arrays and the mv2 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv2 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv2.equals(abbreviated[o])) {

					mv2 = possiblemoves[o];
				}


			}

		} else if (pokemonname.equals("dragapult")) {

			String[] possiblemoves = {"dragondance", "willowisp", "dragonclaw", "dracometeor",
					"bodyslam", "thunderbolt", "confuseray", "suckerpunch", "shadowball", "surf"}; // array of possible moves for this pokemon
			String[] abbreviated = {"dd", "ww", "dc", "dm",
					"bs", "tb", "cr", "sp", "sb", "su"};// array of the abbreviated moves
			String[] explain = {"[boosts attack and speed]", " [burns the opponent]",
					"[user hits the target with 80 power dragon power]", "[An 120 power dragon move that reduces special attack of the user ]"
					, "[The opponent is slammed with a lot of force, 80 power, 30% chance to paralyze]",
					"[the user hits the opponent with electricity 90 power, 10% chance to paralyze] ",
					"[user confuses the opponent]"
					, "[The user sneak attacks the opponent before the opponent can attack]",
					" [ The user throws a ball of shadow energy, 80 base power]",
					"[ A 90 base power water move]"};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv2 = scan.nextLine();

			while (legitmove2(possiblemoves, abbreviated, mv2, move1) != true) { // sends arrays and the mv2 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv2 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv2.equals(abbreviated[o])) {

					mv2 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("goodra")) {
			String[] possiblemoves = {"sludgebomb", "focusblast", "hydropump", "dragonpulse", "flashcannon", "flamethrower", "surf", "darkpulse", "dracometeor"}; // array of possible moves for this pokemon
			String[] abbreviated = {"sb", "fb", "hp", "dp", "fc", "ft", "su", "dpu", "dm"};// array of the abbreviated moves
			String[] explain = {"[An 80 base power poison move, 30% chance to poison]", "[A 120 base power fighting special attack, 70 accuracy]", "[A hard hitting 110 base power water move with 80 accuracy] ", "[An 80 power base dragon move]  ", " [A 90 base power steel move] ", " [A 95 base power fire move with a 10% chance to burn] ", " [A 95 base power water move] ", " [An 80 base power dark move with a chance to flinch(20 %)] ", " [A 120 base power special dragon move, reduces the user's special attack] "};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv2 = scan.nextLine();

			while (legitmove2(possiblemoves, abbreviated, mv2, move1) != true) { // sends arrays and the mv2 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv2 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv2.equals(abbreviated[o])) {

					mv2 = possiblemoves[o];
				}


			}

		}
		else if (pokemonname.equals("charizard")) {

			String[] possiblemoves = {"dragonpulse", "dragondance", "earthquake", "dragonclaw", "flareblitz", "rockslide", "flamethrower", "airslash", "thunderpunch"}; // array of possible moves for this pokemon
			String[] abbreviated = {"dp", "dd", "eq", "dc", "fb", "rs", "ft", "as", "tp"};// array of the abbreviated moves
			String[] explain = {"[user unleashes their inner dragon, 85 base power]", "[boosts attack and speed]", " [A 100 power ground move]", "[user hits the target with base 80 physical dragon power]", "[An 120 power fire move that reduces the hp of the user as well]", "[The opponent is hit with a lot of rocks, 75 power, 30% chance to flinch]", "[the user hits the opponent with flames 90 power, 10% chance to burn] ", " [ The user slashes air at the opponent, 30% chance to flinch]", "[ the user hits with electric power] "};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv2 = scan.nextLine();

			while (legitmove2(possiblemoves, abbreviated, mv2, move1) != true) { // sends arrays and the mv2 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv2 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv2.equals(abbreviated[o])) {

					mv2 = possiblemoves[o];
				}


			}

		}
		else if (pokemonname.equals("golisopod")) {

			String[] possiblemoves = {"swordsdance", "bulkup", "suckerpunch", "aquajet", "closecombat",
					"leechlife", "poisonjab", "rockslide", "aerialace"}; // array of possible moves for this pokemon
			String[] abbreviated = {"sd", "bu", "sp", "aj", "cc", "ll", "pj","rs",  "aa"};// array of the abbreviated moves
			String[] explain = {" [sharply raises the user's attack]",
					"[raises attack and defense ]",
					"[user sneaks the opponent like college sneaked my bank account, base 80 power, only works if the opponent is about to attack] "
					, " [User hits with a jet stream of water, base 40 power]", "[ A 120 base power fighting move that reduces the defenses of the user] ",
					" [a base 75 power bug move that can heal the user] ", "[the user jabs the opponent with poison, 30 % chance to poison] ",
					"[User hits the foe with rocks, rocks may miss but may also flinch]",
					"[user slashes with an aerial technique that always hits]"};

			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv2 = scan.nextLine();

			while (legitmove2(possiblemoves, abbreviated, mv2, move1) != true) { // sends arrays and the mv2 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv2 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv2.equals(abbreviated[o])) {

					mv2 = possiblemoves[o];
				}


			}


		}
		else if (pokemonname.equals("roserade")) {

			String[] possiblemoves = {"toxic", "extrasensory", "shadowball", "sludgebomb", "energyball", "dazzlinggleam", "hiddenpower",}; // array of possible moves for this pokemon
			String[] abbreviated = {"tx", "ex", "sb", "sb", "eb", "dg", "hp"};// array of the abbreviated moves
			String[] explain = {"[this move poisons the opponent and the poison damage increases over time(poison types can't miss)]",
					" [opponent is hit with a base 80 psychic power]",
					" [an 80 power ghost move , 30 % chance for opposing spdef reduction] ",
					"[an 85 base power poison move with a 30% chance to poison]  ",
					" [An 90 base power grass move that hits hard]", " [A 80 base power fairy move with 100 accuracy] ",
					" [A move that can be of any type the user desires, base 60 power]"};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv2 = scan.nextLine();

			while (legitmove2(possiblemoves, abbreviated, mv2, move1) != true) { // sends arrays and the mv2 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv2 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv2.equals(abbreviated[o])) {

					mv2 = possiblemoves[o];
				}


			}

		}
		else if (pokemonname.equals("sceptile")) {
			String[] possiblemoves = {"quickattack", "swordsdance", "leafblade", "energyball", "return", "xscissor", "hiddenpower", "aerialace"}; // array of possible moves for this pokemon
			String[] abbreviated = {"qa","sd", "lb", "eb", "re", "xs", "hp", "aa"};// array of the abbreviated moves
			String[] explain = {"[Hits fast and usually hits first]", "[Sharply raises attack]",
					" [A grass attack with a higher chance of crits, 70 base power] ",
					" [This is a 90 base power move that hits hard] ",
					"[a 102 base power normal physical attack]  ",
					"[80 base power bug move]  ",
					" [A special attack that can be any type the user desires(60 base power) ] ",
					" [60 base power flying move that never misses] "};



			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv2 = scan.nextLine();

			while (legitmove2(possiblemoves, abbreviated, mv2, move1) != true) { // sends arrays and the mv2 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv2 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv2.equals(abbreviated[o])) {

					mv2 = possiblemoves[o];
				}


			}


		}
		else if (pokemonname.equals("mewtwo")) {
			String[] possiblemoves = {"calmmind", "thunderbolt", "psychic", "shadowball", "flamethrower", "icebeam", "aurasphere", "recover", "toxic"}; // array of possible moves for this pokemon
			String[] abbreviated = {"cm", "tb", "ps", "sb", "ft", "ib", "as", "re", "tx"};// array of the abbreviated moves
			String[] explain = {"[raises special attack and special defense]", "[The user zaps the opponent with electricity," +
					" 90 base power move, 10 % chance to paralyze]",
					" [90 base power psychic move with 100 accuracy] ",
					" [A 80 power ghost move that has 100 accuracy] ",
					"[A 95 power fire move with 100 accuracy]  ",
					" [An icy beam is shot at the opponent, ice type 90 base power, 10% chance to freeze] ",
					" [A 80 base power fighting special attack no one can dodge ]  ",
					" [The user heals itself by 1/2 of its max hp] ", "[poisons opponent, RIP the other player lol]"};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv2 = scan.nextLine();

			while (legitmove2(possiblemoves, abbreviated, mv2, move1) != true) { // sends arrays and the mv2 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv2 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv2.equals(abbreviated[o])) {

					mv2 = possiblemoves[o];
				}


			}



		}
		else if (pokemonname.equals("talonflame")) {


			String[] possiblemoves = {"bravebird", "flareblitz", "quickattack",
					"return", "gigaimpact", "swordsdance", "steelwing", "roost"}; // array of possible moves for this pokemon
			String[] abbreviated = {"bb", "fb", "qa",
					"re", "gi", "sd", "sw", "ro"};// array of the abbreviated moves
			String[] explain = {" [A 120 base power flying move, user takes 1/3 recoil]",
					"[an 120 base power fire move, user takes 1/3 recoil ]",
					"[user hits fast with a 40 base power normal move]",
					"[the opponent is hit with a 102 base power normal move  ] ",
					"[User hits the opponent with a 150 base power normal move but has to recharge]",
					"[sharply raises attack] ",
					"[sharp steel wings are slashed at the opponent, 70 power 90 accuracy] ",
					"[the user roosts and regains hp, user loses flying temporarily] "};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv2 = scan.nextLine();

			while (legitmove2(possiblemoves, abbreviated, mv2, move1) != true) { // sends arrays and the mv2 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv2 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv2.equals(abbreviated[o])) {

					mv2 = possiblemoves[o];
				}


			}


		}
		else if (pokemonname.equals("snorlax")) {

			String[] possiblemoves = {"return", "crunch", "earthquake",
					"zenheadbut", "firepunch", "icepunch",
					"thunderpunch", "hyperbeam"}; // array of possible moves for this pokemon
			String[] abbreviated = {"re", "cr", "eq",
					"zh", "fp", "ip",
					"tp", "hb"};// array of the abbreviated moves
			String[] explain = {"[a 102 base power normal move]", " [snorlax attacks with 80 base power darkness]", "[user hits the target with a 100 power ground high crit rate move]",
					"[an 85 base power psychic  move, can miss but can also flinch]", "[The opponent is hit with a fiery punch, 75 power, 10% chance to burn]", "[the user hits an icy punch, 75 power, 10% chance to freeze] ",
					" [The user uses an electric punch to hit the opponent, 75 power; 10% chance to paralyze]", "[ a 150 base power move (special attack) , forces one to recharge] "};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv2 = scan.nextLine();

			while (legitmove2(possiblemoves, abbreviated, mv2, move1) != true) { // sends arrays and the mv2 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv2 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv2.equals(abbreviated[o])) {

					mv2 = possiblemoves[o];
				}


			}

		}
		else if (pokemonname.equals("infernape")) {

			String[] possiblemoves = {"closecombat", "flareblitz", "swordsdance",
					"stoneedge", "flamethrower", "focusblast",
					"thunderpunch", "earthquake",
					"nastyplot","hiddenpower"}; // array of possible moves for this pokemon
			String[] abbreviated = {"cc", "fb", "sd",
					"se", "ft", "fb",
					"tb", "eq" ,
					"np","hp"};// array of the abbreviated moves
			String[] explain = {"[A 120 power fighting move, reduces the user's defense and special defense]", "[A 120 base power physical fire move but the user takes 1/3 of the damage as recoil] ", " [sharply boosts attack] ",
					" [a base 100 power rock move, can crit but also can miss] ", " [a 90 base power fire move that can burn the opponent] ", " [a 120 base power fighting blast that can reduce the opponent's special defense] ",
					" [A 75 base power electric move, may paralyze opponent] ", " [A 100 base power ground move]",
					"[sharply boosts special attack]","[aa 60 base power move that can be any type the user desires]"};




			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv2 = scan.nextLine();

			while (legitmove2(possiblemoves, abbreviated, mv2, move1) != true) { // sends arrays and the mv2 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv2 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv2.equals(abbreviated[o])) {

					mv2 = possiblemoves[o];
				}


			}

		}
		else if (pokemonname.equals("weavile")) {
			String[] possiblemoves = {"icepunch", "nightslash",
					"brickbreak",
					"iceshard", "slash",
					"poisonjab", "swordsdance"}; // array of possible moves for this pokemon
			String[] abbreviated = {"ip", "ns",
					"bb",
					"is", "s",
					"pj", "sd"};// array of the abbreviated moves
			String[] explain = {" [The user hits the opponent with an icy 75 base power punch ,10% chance to freeze] ", "[A 75 base power dark move, high crit rate] ",
					"[ A 75 base power fighting move ]  ",
					"[A fast ice type physical attack, 40 base power]  ", "[A 75 base power normal move, high crit rate]  ",
					"[A 85 base power ice move with a 30% chance to poison ] ", "[sharply raises attack]  "};





			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv2 = scan.nextLine();

			while (legitmove2(possiblemoves, abbreviated, mv2, move1) != true) { // sends arrays and the mv2 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv2 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv2.equals(abbreviated[o])) {

					mv2 = possiblemoves[o];
				}


			}

		}
		else if (pokemonname.equals("groudon")) {

			String[] possiblemoves = {"bulkup", "dragonclaw", "earthquake",
					"focusblast", "rockslide",
					"flamethrower", "brickbreak",
					"swordsdance", "poisonjab", "thunderbolt"}; // array of possible moves for this pokemon
			String[] abbreviated = {"bu", "dc", "ea",
					"fb", "rs",
					"ft", "bb",
					"sd", "pj", "tb"};// array of the abbreviated moves
			String[] explain = {"[raises attack and defense]", "[An 80 base power dragon move]", " [a 100 base power physical ground move]",
					"[an 120 power fighting move with a chance to reduce spdef ]", "[a lot of rocks are slammed on the opponent , 30% chance to flinch ] ",
					" [user expels flames that can burn the opponent, 90 base power]", "[ a 75 base power fighting move] ",
					" [sharply raises the user's attack] ", "[the user jabs the opponent with poison, 30 % chance to poison] ", "[User hits with a 95 base power electric move, with a chance to paralyze]"};






			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv2 = scan.nextLine();

			while (legitmove2(possiblemoves, abbreviated, mv2, move1) != true) { // sends arrays and the mv2 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv2 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv2.equals(abbreviated[o])) {

					mv2 = possiblemoves[o];
				}


			}



		}
		else if (pokemonname.equals("kyogre")) {

			String[] possiblemoves = {"calmmind", "hyperbeam", "surf",
					"hydropump", "icebeam",
					"blizzard", "brickbreak",
					"aquaring", "thunderwave", "thunderbolt"}; // array of possible moves for this pokemon
			String[] abbreviated = {"cm", "hb", "su",
					"hp", "ib",
					"bli", "bri",
					"aq", "tw", "tb"};// array of the abbreviated moves
			String[] explain = {"[raises special attack and special defense]", "[An 150 base power normal move that requires a recharge turn]", " [a 95 base power special water move]",
					"[an 120 power water move with 80 accuracy]", "[an icy beam with a chance to freeze is launched at the opponent ] ",
					" [a 120 base power ice move with 70 accuracy]", "[ a 75 base power fighting move] ",
					" [a veil of water is used to let the user gain a little hp every turn] ", "[the user paralyzes the opponent] ", "[User hits with a 95 base power electric move, with a chance to paralyze]"};






			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv2 = scan.nextLine();

			while (legitmove2(possiblemoves, abbreviated, mv2, move1) != true) { // sends arrays and the mv2 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv2 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv2.equals(abbreviated[o])) {

					mv2 = possiblemoves[o];
				}


			}





		}
		else if (pokemonname.equals("rayquaza")) {

			String[] possiblemoves = {"dragondance", "earthquake",
					"dragonclaw", "dracometeor",
					"rockslide", "flamethrower",
					"airslash", "hyperbeam"}; // array of possible moves for this pokemon
			String[] abbreviated = {"dd", "eq",
					"dc", "dm",
					"rs", "ft",
					"as", "hb"};// array of the abbreviated moves
			String[] explain = {"[boosts attack and speed]", " [A 100 power ground move]",
					"[user hits the target with 80 power dragon power]", "[An 120 power dragon move that reduces special attack of the user ]",
					"[The opponent is hit with a lot of rocks, 75 power, 30% chance to flinch]", "[the user hits the opponent with flames 90 power, 10% chance to burn] ",
					" [ The user slashes air at the opponent, 30% chance to flinch]", "[A beam is shot at the opponent, 150 base power, requres a recharge turn] "};




			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv2 = scan.nextLine();

			while (legitmove2(possiblemoves, abbreviated, mv2, move1) != true) { // sends arrays and the mv2 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv2 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv2.equals(abbreviated[o])) {

					mv2 = possiblemoves[o];
				}


			}



		}
		else if (pokemonname.equals("giratina-altered")) {

			String[] possiblemoves = {"calmmind", "willowisp",
					"dragonclaw", "dracometeor",
					"aurasphere",
					"darkpulse",
					"energyball",
					"earthquake",
					"shadowball",
					"shadowsneak"}; // array of possible moves for this pokemon
			String[] abbreviated = {"cm", "ww",
					"dc", "dm",
					"as",
					"dp",
					"eb",
					"eq",
					"sb",
					"ss"};// array of the abbreviated moves
			String[] explain = {"[boosts special attack and special defense]", " [burns the opponent]",
					"[user hits the target with 80 power dragon power]", "[An 120 power dragon move that reduces special attack of the user ]"
					, "[The opponent is slammed with an 80 power fighting move that never misses]",
					"[the user hits the opponent with a dark type 80 power with a chance to flinch] ",
					"[the user hits the opponent with a grass type 90 power with a chance to reduce spdef]"
					, "[A 100 base power ground move]",
					" [The user throws a ball of shadow energy, 80 base power]",
					"[User sneaks the opponent, 40 base ghost power]"};




			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv2 = scan.nextLine();

			while (legitmove2(possiblemoves, abbreviated, mv2, move1) != true) { // sends arrays and the mv2 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv2 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv2.equals(abbreviated[o])) {

					mv2 = possiblemoves[o];
				}


			}

		}
		else if (pokemonname.equals("giratina-origin")) {

			String[] possiblemoves = {"calmmind", "willowisp",
					"dragonclaw", "dracometeor",
					"aurasphere",
					"darkpulse",
					"energyball",
					"earthquake",
					"shadowball",
					"shadowsneak"}; // array of possible moves for this pokemon
			String[] abbreviated = {"cm", "ww",
					"dc", "dm",
					"as",
					"dp",
					"eb",
					"eq",
					"sb",
					"ss"};// array of the abbreviated moves
			String[] explain = {"[boosts special attack and special defense]", " [burns the opponent]",
					"[user hits the target with 80 power dragon power]", "[An 120 power dragon move that reduces special attack of the user ]"
					, "[The opponent is slammed with an 80 power fighting move that never misses]",
					"[the user hits the opponent with a dark type 80 power with a chance to flinch] ",
					"[the user hits the opponent with a grass type 90 power with a chance to reduce spdef]"
					, "[A 100 base power ground move]",
					" [The user throws a ball of shadow energy, 80 base power]",
					"[User sneaks the opponent, 40 base ghost power]"};



			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv2 = scan.nextLine();

			while (legitmove2(possiblemoves, abbreviated, mv2, move1) != true) { // sends arrays and the mv2 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv2 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv2.equals(abbreviated[o])) {

					mv2 = possiblemoves[o];
				}


			}


		}
		else if (pokemonname.equals("gardevoir")) {
			String[] possiblemoves = {"psychic", "shadowball", "thunderbolt",
					"calmmind", "dazzlinggleam", "hiddenpower", "energyball"}; // array of possible moves for this pokemon
			String[] abbreviated = {"ps", "sb", "tb",
					"cm", "dg", "hp", "eb"};// array of the abbreviated moves
			String[] explain = {" [A 90 base power psychic move with a 10% chance of a reduction in opponent's spdef] ", " [an 80 base power ghost move with a 30% chance to reduce opponent spdef] ", " [a 90 base power electric move that can paralyze the opponent] ",
					"[raises special attack and special defense] ", "[An 80 base power fairy move]  ", "[A 60 base power move that can be any type the user desires] ", " [A 90 base power grass move that can reduce spdef ]"};





			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv2 = scan.nextLine();

			while (legitmove2(possiblemoves, abbreviated, mv2, move1) != true) { // sends arrays and the mv2 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv2 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv2.equals(abbreviated[o])) {

					mv2 = possiblemoves[o];
				}


			}

		}
		else if (pokemonname.equals("gallade")) {
			String[] possiblemoves = {"bulkup", "nightslash", "psychic", "closecombat",
					"swordsdance", "poisonjab", "rockslide", "earthquake"}; // array of possible moves for this pokemon
			String[] abbreviated = {"bu", "ns", "ps", "cc",
					"sd", "pj", "rs", "eq"};// array of the abbreviated moves
			String[] explain = {" [increases attack and defense]",
					"[A 75 base power dark move with a high crit rate] ",
					" [A 90 base power psychic move with a 10 % to reduce spdef] ",
					" [A 120 base power fighting move that reduces spdef and def] ",
					"[sharply boosts attack] ",
					"[a punch of toxicity , 85 base power; 30 percent chance to poison]  ",
					"[A lot of rocks launched at the opponent, there is a chance to flinch as well]  ",
					"[A 100 base power ground move]"};




			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv2 = scan.nextLine();

			while (legitmove2(possiblemoves, abbreviated, mv2, move1) != true) { // sends arrays and the mv2 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv2 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv2.equals(abbreviated[o])) {

					mv2 = possiblemoves[o];
				}


			}


		}


		return mv2;


	}


	private boolean legitmove3(String[] possiblemoves, String[] abbreviations, String testmove, String dupe, String dupe2) { // It is so cool that I can pass arrays as arguments in java, sadly i cant do it in c++ lol
		boolean test = false;

		for (int i = 0; i < abbreviations.length; i++) {

			if (possiblemoves[i].equals(testmove)) {

				test = true;
				break;

			} else if (abbreviations[i].equals(testmove)) {
				test = true;
				break;

			}


		}

		for (int j = 0; j < abbreviations.length; j++) {

			if (abbreviations[j].equals(testmove)) {

				testmove = possiblemoves[j];
			}
		}


		if (testmove.equals(dupe)) {

			test = false;
		} else if (testmove.equals(dupe2)) {

			test = false;
		}


		return test;

	} // checks if a pokemon move is in the array, abbreviations, and to make sure it isnt a duplicate move


	//no dupes
	public String getmovename(String player, String pokemonname, String move1, String move2) {

		String mv3 = "three";// this is the way i tested how different constructors worked


		System.out.println("\n Input a third move, DO NOT INPUT THE SAME PREVIOUS MOVE" + player + ".");
		System.out.println("For example: [meteormash mm] (You can input 'meteormash' or 'mm') \n ");


		if (pokemonname.equals("metagross")) {

			String[] possiblemoves = {"meteormash", "zenheadbut", "thunderpunch", "icepunch", "rockslide", "return", "earthquake", "bulletpunch"}; // array of possible moves for this pokemon
			String[] abbreviated = {"mm", "zh", "tp", "ip", "rs", "re", "ea", "bp"};// array of the abbreviated moves
			String[] explain = {"[A 90 base power physical steel move with 90 accuracy and has a 10 percent chance to increase attack]", "[ A 85 base physical psychic move with 90 accuracy]", "[A punch of electricity, has a 10 percent chance to paralyze]", "[a punch of icy coldness, 10 percent chance to freeze]", "[a lot of rocks are slammed on the opponent , 30% chance to flinch ]", "[a 102 base power normal physical attack]", "[a 100 base ground move]", "[User ussually goes first in dishing out the 40 power steel bash]"};
			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv3 = scan.nextLine();

			while (legitmove3(possiblemoves, abbreviated, mv3, move1, move2) != true) { // sends arrays and the mv3 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv3 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv3.equals(abbreviated[o])) {

					mv3 = possiblemoves[o];
				}


			} // algorithm to get a move that is legit

		} else if (pokemonname.equals("gliscor")) {

			String[] possiblemoves = {"toxic", "earthquake", "rockslide", "firefang", "thunderfang", "icefang", "swordsdance"}; // array of possible moves for this pokemon
			String[] abbreviated = {"tx", "ea", "rs", "ff", "tf", "if", "sd"};// array of the abbreviated moves

			String[] explain = {"[this move poisons the opponent and the poison damage increases over time(poison types can't miss)]", "[a 100 base power physical ground move]", "[a 75 power, 95 accuracy rock move that can flinch, user slams rocks on opponent.] ", " [a 65 power physical fire move (95 accuracy) 10 percent chance to burn or flinch]", " [a 65 power physical electric move (95 accuracy) 10 percent chance to paralyze or flinch] ", " [a 65 power physical ice move (95 accuracy) 10 percent chance to freeze or flinch ]", "[sharply raises user's attack ]"};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv3 = scan.nextLine();

			while (legitmove3(possiblemoves, abbreviated, mv3, move1, move2) != true) { // sends arrays and the mv3 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv3 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv3.equals(abbreviated[o])) {

					mv3 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("excadrill")) {

			String[] possiblemoves = {"honeclaws", "earthquake", "ironhead", "rockslide", "horndrill", "brickbreak", "swordsdance", "poisonjab"}; // array of possible moves for this pokemon
			String[] abbreviated = {"hc", "ea", "ih", "rs", "hd", "bb", "sd", "pj"};// array of the abbreviated moves
			String[] explain = {"[Raises accuracy of attacks and increases their power]", " [a 100 base power physical ground move]", "[an 80 power steel move with a 30% chance to flinch ]", "[a lot of rocks are slammed on the opponent , 30% chance to flinch ] ", " [Has a 30 percent chance to one-shot the opponent, can't hit ghosts]", "[ a 75 base power fighting move] ", " [sharply raises the user's attack] ", "[the user jabs the opponent with poison, 30 % chance to poison] "};

			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv3 = scan.nextLine();

			while (legitmove3(possiblemoves, abbreviated, mv3, move1, move2) != true) { // sends arrays and the mv3 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv3 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv3.equals(abbreviated[o])) {

					mv3 = possiblemoves[o];
				}


			}

		} else if (pokemonname.equals("arcanine")) {

			String[] possiblemoves = {"flareblitz", "crunch", "extremespeed", "willowisp", "morningsun", "ironhead", "wildcharge"}; // array of possible moves for this pokemon
			String[] abbreviated = {"fb", "cr", "es", "ww", "ms", "ih", "wc"};// array of the abbreviated moves

			String[] explain = {"[A 120 base power physical fire move but the user takes 1/3 of the damage as recoil] ", " [an 80 power dark physical move that has a 20 percent chance for a defense drop] ", " [80 base power normal move that always moves first] ", " [has a 90 percent chance to burn the opponent] ", " [heals user by half of its max hp] ", " [an 80 power steel move with a 30% chance to flinch ] ", " [A 90 power electric physical attack, user takes 1/3 recoil]"};

			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv3 = scan.nextLine();

			while (legitmove3(possiblemoves, abbreviated, mv3, move1, move2) != true) { // sends arrays and the mv3 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv3 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv3.equals(abbreviated[o])) {

					mv3 = possiblemoves[o];
				}


			}

		} else if (pokemonname.equals("krookodile")) {
			String[] possiblemoves = {"firefang", "thunderfang", "dragonclaw", "rockslide", "brickbreak", "earthquake", "crunch"}; // array of possible moves for this pokemon
			String[] abbreviated = {"ff", "tf", "dc", "rs", "bb", "ea", "cr"};// array of the abbreviated moves

			String[] explain = {"[a 65 power physical fire move (95 accuracy) 10 percent chance to burn or flinch]", "  [a 65 power physical electric move (95 accuracy) 10 percent chance to paralyze or flinch] ", " [an 80 base power dragon type move] ", " [a lot of rocks are slammed on the opponent , 30% chance to flinch ] ", " [ a 75 base power fighting move] ", " [a 100 base ground move] ", " [an 80 power dark move that crunches opponent, 20 percent chance for defense drop] "};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv3 = scan.nextLine();

			while (legitmove3(possiblemoves, abbreviated, mv3, move1, move2) != true) { // sends arrays and the mv3 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv3 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv3.equals(abbreviated[o])) {

					mv3 = possiblemoves[o];
				}


			}

		} else if (pokemonname.equals("feraligatr")) {

			String[] possiblemoves = {"dragondance", "aquajet", "superpower", "waterfall", "icepunch", "earthquake", "dragonclaw", "crunch"}; // array of possible moves for this pokemon
			String[] abbreviated = {"dd", "aj", "sp", "wf", "ip", "ea", "dc", "cr"};// array of the abbreviated moves
			String[] explain = {"[boosts attack and speed]", " [a 40 base power physical priority water move]  ", " [a 120 base power fighting move that reduces attack and defense of the user] ", " [an 80 base power water move (with sheerforce it will be 110)] ", " [a punch of icy coldness, 10 percent chance to freeze] ", "[a 100 base power physical ground move]  ", " [an 80 base power dragon move] ", " [an 80 base power dark move and it has a 20 percent chance to reduce defense] "};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv3 = scan.nextLine();

			while (legitmove3(possiblemoves, abbreviated, mv3, move1, move2) != true) { // sends arrays and the mv3 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv3 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv3.equals(abbreviated[o])) {

					mv3 = possiblemoves[o];
				}


			}

		} else if (pokemonname.equals("gyarados")) {

			String[] possiblemoves = {"dragondance", "icefang", "waterfall", "return", "irontail", "stoneedge", "earthquake"}; // array of possible moves for this pokemon
			String[] abbreviated = {"dd", "if", "wf", "re", "it", "se", "ea"};// array of the abbreviated moves
			String[] explain = {"[boosts attack and speed]", "[a 65 power physical ice move (95 accuracy) 10 percent chance to freeze or flinch ] ", "  [an 80 base power water move with a 20 percent chance to flinch] ", " [a 102 base power normal physical attack] ", " [A steel move that has 75 percent accuracy ]",
					"[The user snipes the opponent with stones (rock move, 100 base power, 80 accuracy]  ", " [ A 100 base power ground type move  with 100 accuracy] "};

			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv3 = scan.nextLine();

			while (legitmove3(possiblemoves, abbreviated, mv3, move1, move2) != true) { // sends arrays and the mv3 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv3 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv3.equals(abbreviated[o])) {

					mv3 = possiblemoves[o];
				}


			}

		} else if (pokemonname.equals("starmie")) {
			String[] possiblemoves = {"thunderbolt", "psychic", "hydropump", "surf", "icebeam", "confuseray", "recover"}; // array of possible moves for this pokemon
			String[] abbreviated = {"tb", "ps", "hp", "su", "ib", "cr", "re"};// array of the abbreviated moves
			String[] explain = {"[The user zaps the opponent with electricity, 90 base power move, 10 % chance to paralyze]", " [90 base power psychic move with 100 accuracy] ", " [A 110 power water move that has 80 accuracy] ", "[A 95 power water move with 100 accuracy]  ", " [An icy beam is shot at the opponent, ice type 90 base power, 10% chance to freeze] ", " [confuses the opponent ]  ", " The user heals itself by 1/2 of its max hp] "};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv3 = scan.nextLine();

			while (legitmove3(possiblemoves, abbreviated, mv3, move1, move2) != true) { // sends arrays and the mv3 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv3 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv3.equals(abbreviated[o])) {

					mv3 = possiblemoves[o];
				}


			}

		} else if (pokemonname.equals("gengar")) {

			String[] possiblemoves = {"toxic", "confuseray", "shadowball", "sludgebomb", "suckerpunch", "focusblast", "thunderbolt",}; // array of possible moves for this pokemon
			String[] abbreviated = {"tx", "cr", "sb", "su", "sp", "fb", "tb"};// array of the abbreviated moves
			String[] explain = {"[this move poisons the opponent and the poison damage increases over time(poison types can't miss)]", " [confuses the opponent]", " [an 80 power ghost move , 30 % chance for opposing spdef reduction] ", "[an 85 base power poison move with a 30% chance to poison]  ", " [An 80 base power move that only works if the opponent uses an attack]", " [A 120 base power fighting move with 70 accuracy] ", " [ A zap of electricity at the opponent, a 90 power electic move with 100 accuracy]"};

			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv3 = scan.nextLine();

			while (legitmove3(possiblemoves, abbreviated, mv3, move1, move2) != true) { // sends arrays and the mv3 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv3 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv3.equals(abbreviated[o])) {

					mv3 = possiblemoves[o];
				}


			}

		} else if (pokemonname.equals("espeon")) {
			String[] possiblemoves = {"psychic", "shadowball", "quickattack", "calmmind", "dazzlinggleam", "hiddenpower", "morningsun"}; // array of possible moves for this pokemon
			String[] abbreviated = {"ps", "sb", "qa", "cm", "dg", "hp", "ms"};// array of the abbreviated moves

			String[] explain = {" [A 90 base power psychic move with a 10% chance of a reduction in opponent's spdef] ", " [an 80 base power ghost move with a 30% chance to reduce opponent spdef] ", " [a 40 base power move that usually hits first] ", "[raises special attack and special defense] ", "[An 80 base power fairy move]  ", "[A 60 base power move that can be any type the user desires] ", " [User heals itself by 1/2 of its max hp ]"};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv3 = scan.nextLine();

			while (legitmove3(possiblemoves, abbreviated, mv3, move1, move2) != true) { // sends arrays and the mv3 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv3 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv3.equals(abbreviated[o])) {

					mv3 = possiblemoves[o];
				}


			}

		} else if (pokemonname.equals("jolteon")) {

			String[] possiblemoves = {"thunderbolt", "shadowball", "hiddenpower", "toxic", "pinmissle", "doublekick", "thunderwave"}; // array of possible moves for this pokemon
			String[] abbreviated = {"tb", "sb", "hp", "tx", "pm", "dk", "tw"};// array of the abbreviated moves

			String[] explain = {" [A 90 base power electric attack with a 10 % chance of paralysis]", "[a 80 power ghost special move with a 30 percent chance to reduce spdef]  ", " [A 60 base power move that can be any type the user desires]  ", " [this move poisons the opponent and the poison damage increases over time(poison types can't miss)] ", " [A physical bug move that can be 15,30,45,60,0r 75 base power]  ", " [A 60 base power physical fighting move] ", " [Has a 90 percent chance to paralyze opponent] "};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv3 = scan.nextLine();

			while (legitmove3(possiblemoves, abbreviated, mv3, move1, move2) != true) { // sends arrays and the mv3 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv3 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv3.equals(abbreviated[o])) {

					mv3 = possiblemoves[o];
				}


			}

		} else if (pokemonname.equals("glaceon")) {
			String[] possiblemoves = {"icebeam", "hiddenpower", "shadowball", "iceshard", "waterpulse", "blizzard", "toxic"}; // array of possible moves for this pokemon
			String[] abbreviated = {"ib", "hp", "sb", "is", "wp", "bz", "tx"};// array of the abbreviated moves


			String[] explain = {" [A beam of ice that is shot at the opponent, 90 base power ,10% chance to freeze] ", "[A 60 base power move that can be any type the user desires] ", "[ An 80 base power ghost move with a 30 % chance to spdef drop]  ", "[A fast ice type physical attack, 40 base power]  ", "[A  60 base power water move with a 20 percent chance to confuse the opponent]  ", "[A 110 base power ice move with 70 accuracy] ", "[this move poisons the opponent and the poison damage increases over time(poison types can't miss)]  "};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv3 = scan.nextLine();

			while (legitmove3(possiblemoves, abbreviated, mv3, move1, move2) != true) { // sends arrays and the mv3 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv3 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv3.equals(abbreviated[o])) {

					mv3 = possiblemoves[o];
				}


			}

		} else if (pokemonname.equals("sylveon")) {
			String[] possiblemoves = {"moonblast", "hyperbeam", "shadowball", "calmmind", "toxic", "dazzlinggleam", "hiddenpower"}; // array of possible moves for this pokemon
			String[] abbreviated = {"mb", "hb", "sb", "cm", "tx", "dg", "hp"};// array of the abbreviated moves
			String[] explain = {"[A 95 base power fairy move with a 30% chance to reduce special attack] ", " [A fairy beam is shot at the opponent, 150 base power, 90 accuracy , one turn recharge]  ", " [An 80 power ghost move that reduces spdef 30% of the time] ", " [raises special attack and special defense] ", " [this move poisons the opponent and the poison damage increases over time(poison types can't miss)] ", "[ An 80 base power fairy move] ", " [A 60 base power move that can be any type the user desires]  "};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv3 = scan.nextLine();

			while (legitmove3(possiblemoves, abbreviated, mv3, move1, move2) != true) { // sends arrays and the mv3 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv3 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv3.equals(abbreviated[o])) {

					mv3 = possiblemoves[o];
				}


			}

		} else if (pokemonname.equals("umbreon")) {
			String[] possiblemoves = {"toxic", "moonlight", "quickattack", "confuseray", "hiddenpower", "darkpulse", "foulplay"}; // array of possible moves for this pokemon
			String[] abbreviated = {"tx", "ml", "qa", "cr", "hp", "dp", "fp"};// array of the abbreviated moves
			String[] explain = {" [this move poisons the opponent and the poison damage increases over time(poison types can't miss)] ", " [[Heals user by 1/2 of max hp] ", " [40 base power fast normal move] ", " [confuses the opponent] ", "[A 60 base power move that can be any type the user desires]   ", " [An 80 base power dark move with a 10% chance to flinch] ", " [An 80 base power move that uses the opponents attack]"};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv3 = scan.nextLine();

			while (legitmove3(possiblemoves, abbreviated, mv3, move1, move2) != true) { // sends arrays and the mv3 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv3 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv3.equals(abbreviated[o])) {

					mv3 = possiblemoves[o];
				}


			}

		} else if (pokemonname.equals("leafeon")) {
			String[] possiblemoves = {"swordsdance", "leafblade", "toxic", "return", "xscissor", "synthesis", "aerialace"}; // array of possible moves for this pokemon
			String[] abbreviated = {"sd", "lb", "tx", "re", "xs", "sy", "aa"};// array of the abbreviated moves
			String[] explain = {"[Sharply raises attack]", " [A grass attack with a higher chance of crits, 70 base power] ", " [this move poisons the opponent and the poison damage increases over time(poison types can't miss)] ", "[a 102 base power normal physical attack]  ", "[80 base power bug move]  ", " [User recovers 1/2 of its max hp] ", " [60 base power flying move that never misses] "};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv3 = scan.nextLine();

			while (legitmove3(possiblemoves, abbreviated, mv3, move1, move2) != true) { // sends arrays and the mv3 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv3 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv3.equals(abbreviated[o])) {

					mv3 = possiblemoves[o];
				}


			}

		} else if (pokemonname.equals("vaporeon")) {
			String[] possiblemoves = {"hydropump", "icebeam", "aquaring", "toxic", "hiddenpower", "shadowball", "surf"}; // array of possible moves for this pokemon
			String[] abbreviated = {"hd", "ib", "ar", "tx", "hp", "sb", "su"};// array of the abbreviated moves
			String[] explain = {"[A 110 base power water move, 80 accuracy]   ", " [A 90 base power ice move with 10% chance to freeze] ", " [The user starts gaining a little hp every turn] ", " [this move poisons the opponent and the poison damage increases over time(poison types can't miss)] ", " [A 60 base power move that can be any type the user desires]  ", " [A base 80 power ghost move, 30% chance to reduce spdef] ", " [A 95 base power water move] "};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv3 = scan.nextLine();

			while (legitmove3(possiblemoves, abbreviated, mv3, move1, move2) != true) { // sends arrays and the mv3 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv3 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv3.equals(abbreviated[o])) {

					mv3 = possiblemoves[o];
				}


			}

		} else if (pokemonname.equals("flareon")) {
			String[] possiblemoves = {"flareblitz", "bulkup", "toxic", "willowisp", "return", "hiddenpower", "superpower"}; // array of possible moves for this pokemon
			String[] abbreviated = {"fb", "bu", "tx", "ww", "re", "hp", "sp"};// array of the abbreviated moves

			String[] explain = {" [A 120 base power physical fire move but the user takes 1/3 of the damage as recoil] ", " [raises this pokemon's attack and defense] ", " [this move poisons the opponent and the poison damage increases over time(poison types can't miss)] ", " [burns the opponent 85 percent of the time] ", " [a 102 base power normal physical attack] ", " [A 60 base power move that can be any type the user desires]  ", " [A 120 power fighting move that reduces the user's attack and defense] "};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv3 = scan.nextLine();

			while (legitmove3(possiblemoves, abbreviated, mv3, move1, move2) != true) { // sends arrays and the mv3 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv3 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv3.equals(abbreviated[o])) {

					mv3 = possiblemoves[o];
				}


			}

		} else if (pokemonname.equals("scizor")) {

			String[] possiblemoves = {"bulletpunch", "nightslash", "xscissor", "slash", "quickattack", "gigaimpact", "swordsdance"}; // array of possible moves for this pokemon
			String[] abbreviated = {"bp", "ns", "xs", "s", "qa", "qi", "sd"};// array of the abbreviated moves
			String[] explain = {" [A 40 base power steel move that often moves first] ", "  [A 70 base power dark move with a higher chance of crits]  ", " [An 80 base power bug move] ", " [A 70 base power normal move with a higher chance of crits] ", "  [A 40 base power normal move that often moves first]", "[A 150 base power normal move, recharge required]  ", " [Sharply raises attack] "};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv3 = scan.nextLine();

			while (legitmove3(possiblemoves, abbreviated, mv3, move1, move2) != true) { // sends arrays and the mv3 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv3 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv3.equals(abbreviated[o])) {

					mv3 = possiblemoves[o];
				}


			}

		} else if (pokemonname.equals("hydreigon")) {
			String[] possiblemoves = {"nastyplot", "dragonpulse", "flashcannon", "flamethrower", "surf", "darkpulse", "dracometeor"}; // array of possible moves for this pokemon
			String[] abbreviated = {"np", "dp", "fc", "ft", "su", "dpu", "dm"};// array of the abbreviated moves

			String[] explain = {" [Sharply raises special attack] ", "[An 80 power base dragon move]  ", " [A 90 base power steel move] ", " [A 95 base power fire move with a 10% chance to burn] ", " [A 95 base power water move] ", " [An 80 base power dark move with a chance to flinch(20 %)] ", " [A 120 base power special dragon move, reduces the user's special attack] "};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv3 = scan.nextLine();

			while (legitmove3(possiblemoves, abbreviated, mv3, move1, move2) != true) { // sends arrays and the mv3 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv3 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv3.equals(abbreviated[o])) {

					mv3 = possiblemoves[o];
				}


			}

		} else if (pokemonname.equals("meloetta")) {
			String[] possiblemoves = {"workup", "relicsong", "psychic", "closecombat", "thunderbolt", "icepunch", "firepunch"}; // array of possible moves for this pokemon
			String[] abbreviated = {"wu", "rs", "ps", "cc", "tb", "ip", "fp"};// array of the abbreviated moves
			String[] explain = {" [increases attack and special attack]", "[A 80 base power move that changes meloetta to pirouette form with different stats] ", " [A 90 base power psychic move with a 10 % to reduce spdef] ", " [A 120 base power fighting move that reduces spdef and def] ", "[A zap of electricity (90 power); 10% chance to paralyze ", "[a punch of icy coldness, 75 base power; 10 percent chance to freeze]  ", "[A punch of fiery wrath;75 base power; 10 percent chance to burn]  "};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv3 = scan.nextLine();

			while (legitmove3(possiblemoves, abbreviated, mv3, move1, move2) != true) { // sends arrays and the mv3 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv3 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv3.equals(abbreviated[o])) {

					mv3 = possiblemoves[o];
				}


			}

		} else if (pokemonname.equals("archeops")) {
			String[] possiblemoves = {"honeclaws", "earthquake", "rockslide", "stoneedge", "crunch", "dragonclaw", "aquatail"}; // array of possible moves for this pokemon
			String[] abbreviated = {"hc", "ea", "rs", "se", "cr", "dc", "at"};// array of the abbreviated moves
			String[] explain = {" [Raises attack and accuracy] ", " [A 100 base power ground move] ", " [a lot of rocks are slammed on the opponent , 30% chance to flinch ] ", " [A 100 base power rock move with a higher chance of crits and 80 accuracy] ", " [An 80 base power dark move; 10% chance to flinch] ", " [An 80 base power dragon pulse] ", " [A move that has a 90% chance to hit with 90 water based power]"};

			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv3 = scan.nextLine();

			while (legitmove3(possiblemoves, abbreviated, mv3, move1, move2) != true) { // sends arrays and the mv3 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv3 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv3.equals(abbreviated[o])) {

					mv3 = possiblemoves[o];
				}


			}

		} else if (pokemonname.equals("crobat")) {


			String[] possiblemoves = {"bravebird", "crosspoison", "confuseray", "toxic", "superfang", "leechlife", "steelwing", "roost"}; // array of possible moves for this pokemon
			String[] abbreviated = {"bb", "cp", "cr", "tx", "sf", "ll", "sw", "ro"};// array of the abbreviated moves
			String[] explain = {" [A 120 base power flying move, user takes 1/3 recoil]", "[an 80 base power poison move with a high crit rate ]", "[Confuses the opponent]", "[the opponent is poisoned and takes more damage over time  ] ", " [The opponent loses half of its health ]", "[ a 80 base power bug move, user regains 1/2 of damage as hp] ", " [sharp steel wings are slashed at the opponent, 70 power 90 accuracy] ", "[the user roosts and regains hp, user loses flying temporarily] "};

			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv3 = scan.nextLine();

			while (legitmove3(possiblemoves, abbreviated, mv3, move1, move2) != true) { // sends arrays and the mv3 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv3 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv3.equals(abbreviated[o])) {

					mv3 = possiblemoves[o];
				}


			}

		} else if (pokemonname.equals("manaphy")) {


			String[] possiblemoves = {"tailglow", "surf", "energyball",  "shadowball", "psychic", "dazzlinggleam", "icebeam"}; // array of possible moves for this pokemon
			String[] abbreviated = {"tg", "su", "eb", "sb", "ps", "dg", "ib"};// array of the abbreviated moves
			String[] explain = {" [An over powered move that boosts the special attack of the user. Manaphy's secret weapon]",
					"[A wave of water washes the opponent, 95 power move ]",
					"[A ball of grassy naturs hits the opponent, 90 power, 20% of a spdef drop]",
					" [A shadowball sniped the opponent, ghost 80 power move with a 30% chance of a spdef drop]", "[ A psychic wave is shot at the opponent, 90 power, 10% for a special def drop] ", " [A bright light hits the opponent, an 80 power fairy move] ", "[An icy beam hits the oponent, 90 power, 20% chance of freeze] "};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv3 = scan.nextLine();

			while (legitmove3(possiblemoves, abbreviated, mv3, move1, move2) != true) { // sends arrays and the mv3 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv3 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv3.equals(abbreviated[o])) {

					mv3 = possiblemoves[o];
				}


			}

		} else if (pokemonname.equals("jirachi")) {


			String[] possiblemoves = {"thunderwave", "ironhead", "firepunch", "icepunch", "thunderbolt", "psychic", "dazzlinggleam", "calmmind"}; // array of possible moves for this pokemon
			String[] abbreviated = {"tw", "ih", "fp", "ip", "tb", "ps", "dg", "cm"};// array of the abbreviated moves
			String[] explain = {" [paralyzes the opponent, Can help in para-flinching]", "[user bashes opponent with a steel head, 80 power move, 30% chance to flinch]", "[The opponent is hit with a fiery punch, 75 power 20% chance to burn]", "[the user hits the opponent with an icy punch, 75 power 20% chance to freeze] ", " [The opponent is hit with a lightningbolt 90 power 20% chance to paralyze]", "[ A psychic wave is shot at the opponent, 90 power, 10% for a special def drop] ", " [A bright light hits the opponent, an 80 power fairy move] ", "[The user focuses and increases its special attack and special defense] "};

			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv3 = scan.nextLine();

			while (legitmove3(possiblemoves, abbreviated, mv3, move1, move2) != true) { // sends arrays and the mv3 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv3 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv3.equals(abbreviated[o])) {

					mv3 = possiblemoves[o];
				}


			}

		} else if (pokemonname.equals("melmetal")) {


			String[] possiblemoves = {"thunderpunch", "thunderwave", "doubleironbash", "superpower", "icepunch", "earthquake", "rockslide"}; // array of possible moves for this pokemon
			String[] abbreviated = {"tp", "tw", "db", "sp", "ip", "e", "rs"};// array of the abbreviated moves
			String[] explain = {"[The opponent is hit with an electriv punch, 75 power, 10% chance to paralyze]", " [paralyzes the opponent, Can help in para-flinching]", "[user bashes opponent with big boi arms , 120 power move]", "[The opponent is hit with secret fighting power, 120 power, reduces attack and defense]", "[the user hits the opponent with an icy punch, 75 power 20% chance to freeze] ", " [The opponent is hit with an earthquake]", "[ The user slams rocks on the opponent, 75 power, 30% chance to flinch, 95 accuracy] "};

			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv3 = scan.nextLine();

			while (legitmove3(possiblemoves, abbreviated, mv3, move1, move2) != true) { // sends arrays and the mv3 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv3 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv3.equals(abbreviated[o])) {

					mv3 = possiblemoves[o];
				}


			}

		} else if (pokemonname.equals("kingdra")) {



			String[] possiblemoves = {"waterfall", "dragondance", "hydropump", "dragonpulse", "flashcannon", "bodyslam", "yawn", "focusenergy"}; // array of possible moves for this pokemon
			String[] abbreviated = {"wf","dd", "hp", "dp", "fc", "bs", "y", "fe"};// array of the abbreviated moves
			String[] explain = {"[An 80 base power physical water move]", "[boosts attack and speed]", "[user hits the target with a 110 power water type move]", "[An 80 power dragon move]", "[The opponent is hit with a steel beam, 90 power, has a chance of reducing spdef]", "[the user hits the opponent with its body, 80 power 30% chance to paralyse the opponent] ", " [The user makes the opponent tired and sleep after one turn]", "[ Increases the chances of crits] "};

			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv3 = scan.nextLine();

			while (legitmove3(possiblemoves, abbreviated, mv3, move1, move2) != true) { // sends arrays and the mv3 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv3 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv3.equals(abbreviated[o])) {

					mv3 = possiblemoves[o];
				}


			}

		} else if (pokemonname.equals("machamp")) {


			String[] possiblemoves = {"bulkup", "dynamicpunch", "crosschop", "bulletpunch", "firepunch", "icepunch", "thunderpunch", "focusenergy"}; // array of possible moves for this pokemon
			String[] abbreviated = {"bu", "dp", "cc", "bp", "fp", "ip", "tp", "fe"};// array of the abbreviated moves
			String[] explain = {"[raises attack and defense]", " [Machamp bashes its opponent with a 100 power move that confuses the opponent]", "[user hits the target with a 100 power fighting type high crit rate move]", "[An 40 power steel priority move]", "[The opponent is hit with a fiery punch, 75 power, 10% chance to burn]", "[the user hits an icy punch, 75 power, 10% chance to freeze] ", " [The user uses an electric punch to hit the opponent, 75 power; 10% chance to paralyze]", "[ Increases the chances of crits] "};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv3 = scan.nextLine();

			while (legitmove3(possiblemoves, abbreviated, mv3, move1, move2) != true) { // sends arrays and the mv3 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv3 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv3.equals(abbreviated[o])) {

					mv3 = possiblemoves[o];
				}


			}

		} else if (pokemonname.equals("milotic")) {


			String[] possiblemoves = {"hydropump", "aquaring", "toxic", "confuseray", "icebeam", "recover", "hiddenpower"}; // array of possible moves for this pokemon
			String[] abbreviated = {"hy", "aq", "tx", "cr", "ib", "re", "hp"};// array of the abbreviated moves
			String[] explain = {" [the user attacks with a 110 water power move]", "[user starts regaining hp every turn]", "[Poisons the opponent and makes them take more damage over time]", "[ Confuses the opponent]", "[the user hits an icy beam, 90 power, 10% chance to freeze] ", " [User regains half of its max hp]", "[ A 60 power move that can be any type the user desires] "};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv3 = scan.nextLine();

			while (legitmove3(possiblemoves, abbreviated, mv3, move1, move2) != true) { // sends arrays and the mv3 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv3 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv3.equals(abbreviated[o])) {

					mv3 = possiblemoves[o];
				}


			}

		} else if (pokemonname.equals("chandelure")) {


			String[] possiblemoves = {"energyball", "flamethrower", "calmmind", "confuseray", "shadowball", "willowisp", "psychic"}; // array of possible moves for this pokemon
			String[] abbreviated = {"eb", "ft", "cm", "cr", "sb", "ww", "ps"};// array of the abbreviated moves
			String[] explain = {" [the user attacks with a 90 grass power move with a 10 percent chance to reduce spdef]", "[user shoots fire at the opponent, 90 power 10% chance to burn]", "[User increases its spa and Spdef stats]", "[ Confuses the opponent]", "[the user hits a ball of shadow, 80 power, 30% chance to drop spdef of opponent] ", " [Burns the opponent 90 percent of the time]", "[ A 90 power psychic move that hits for 90 power and has a 10% for a spdef drop] "};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv3 = scan.nextLine();

			while (legitmove3(possiblemoves, abbreviated, mv3, move1, move2) != true) { // sends arrays and the mv3 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv3 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv3.equals(abbreviated[o])) {

					mv3 = possiblemoves[o];
				}


			}

		} else if (pokemonname.equals("dragonite")) {


			String[] possiblemoves = {"extremespeed", "dragondance", "thunderwave", "dragonclaw", "dracometeor", "firepunch", "icepunch", "thunderpunch", "superpower"}; // array of possible moves for this pokemon
			String[] abbreviated = {"es", "dd", "tw", "dc", "dm", "fp", "ip", "tp", "sp"};// array of the abbreviated moves
			String[] explain = {"[an 80 base power normal move that hits fast and hard]", "[boosts attack and speed]", " [paralyzes opponent]", "[user hits the target with 80 power dragon power]", "[An 120 power dragon move that reduces special attack of the user ]", "[The opponent is hit with a fiery punch, 75 power, 10% chance to burn]", "[the user hits an icy punch, 75 power, 10% chance to freeze] ", " [The user uses an electric punch to hit the opponent, 75 power; 10% chance to paralyze]", "[ user attacks with 120 power of fighting power, reduces attack and defense of the user] "};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv3 = scan.nextLine();

			while (legitmove3(possiblemoves, abbreviated, mv3, move1, move2) != true) { // sends arrays and the mv3 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv3 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv3.equals(abbreviated[o])) {

					mv3 = possiblemoves[o];
				}


			}

		} else if (pokemonname.equals("salamence")) {

			String[] possiblemoves = {"dragondance", "earthquake", "dragonclaw", "dracometeor", "rockslide", "flamethrower", "airslash", "focusenergy"}; // array of possible moves for this pokemon
			String[] abbreviated = {"dd", "eq", "dc", "dm", "rs", "ft", "as", "fe"};// array of the abbreviated moves
			String[] explain = {"[boosts attack and speed]", " [A 100 power ground move]", "[user hits the target with 80 power dragon power]", "[An 120 power dragon move that reduces special attack of the user ]", "[The opponent is hit with a lot of rocks, 75 power, 30% chance to flinch]", "[the user hits the opponent with flames 90 power, 10% chance to burn] ", " [ The user slashes air at the opponent, 30% chance to flinch]", "[ increases the user's chances of a crit] "};

			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv3 = scan.nextLine();

			while (legitmove3(possiblemoves, abbreviated, mv3, move1, move2) != true) { // sends arrays and the mv3 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv3 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv3.equals(abbreviated[o])) {

					mv3 = possiblemoves[o];
				}


			}

		} else if (pokemonname.equals("greninja")) {
			String[] possiblemoves = {"watershuriken", "extrasensory", "hydropump", "surf", "icebeam", "gunkshot", "darkpulse", "hiddenpower"}; // array of possible moves for this pokemon
			String[] abbreviated = {"ws", "ex", "hpu", "su", "ib", "gs", "dp", "hp"};// array of the abbreviated moves
			String[] explain = {"[The pokemon yeets some shurikens at the opponent, usually goes first]",
					" [80 base power psychic move with 100 accuracy, can sometimes flinch] ",
					" [A 110 power water move that has 80 accuracy] ",
					"[A 95 power water move with 100 accuracy]  ",
					" [An icy beam is shot at the opponent, ice type 90 base power, 10% chance to freeze] ",
					" [A poison blast is shot at the opponent, has a 30% chance to poison the opponent]  ",
					" [A dark aura is projected at the opponent, has a 20% chance to flinch] ",
					" [A mysterious blast is shot at the opponent, the user chooses its type]"};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv3 = scan.nextLine();

			while (legitmove3(possiblemoves, abbreviated, mv3, move1, move2) != true) { // sends arrays and the mv3 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv3 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv3.equals(abbreviated[o])) {

					mv3 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("zeraora")) {
			String[] possiblemoves = {"bulkup", "thunderwave", "toxic", "closecombat", "plasmafists", "drainpunch", "firepunch", "playrough"}; // array of possible moves for this pokemon
			String[] abbreviated = {"bu", "tw", "tx", "cc", "pf", "dp", "fp", "pr"};// array of the abbreviated moves
			String[] explain = {" [increases attack and defense]",
					"[paralyzes opponent] ",
					" [poisons opponent, opponent takes damage every turn, they're screwed if they can't win quickly] ",
					" [A 120 base power fighting move that reduces spdef and def] ",
					"[A mega-powerful electric punch, based 100 power] ",
					"[a punch of toxicity, 75 base power; the user gains some health back]  ",
					"[A punch of fiery wrath;75 base power; 10 percent chance to burn]  ",
					"[A 90 base power fairy move, has a chance to reduce the opponent's attack]"};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv3 = scan.nextLine();

			while (legitmove3(possiblemoves, abbreviated, mv3, move1, move2) != true) { // sends arrays and the mv3 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv3 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv3.equals(abbreviated[o])) {

					mv3 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("togekiss")) {

			String[] possiblemoves = {"dazzlinggleam", "roost", "aurasphere", "flamethrower", "nastyplot",
					"thunderwave", "shadowball", "airslash", "psychic", "extremespeed"}; // array of possible moves for this pokemon
			String[] abbreviated = {"dg", "roo", "asp", "ft", "np", "tw", "sb", "as", "ps", "es"};// array of the abbreviated moves
			String[] explain = {"[An 80 base power fairy move]",
					"[Heals user but the user loses their flying type for a turn]",
					"[the user attacks with an 80 power fighting move that never misses]",
					"[user shoots fire at the opponent, 90 power 10% chance to burn]",
					"[User sharply increases its special attack]",
					"[paralyzes the opponent, 90 accuracy]",
					"[the user hits a ball of shadow, 80 power, 30% chance to drop spdef of opponent] ",
					"[The opponent gets slashed with some crisp clean air, 30% flinch rate]",
					"[ A 90 power psychic move that hits for 90 power and has a 10% for a spdef drop] ",
					"[The fastest move in the game, always moves first, 80 base power, it is speed, gotta go fast]"};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv3 = scan.nextLine();

			while (legitmove3(possiblemoves, abbreviated, mv3, move1, move2) != true) { // sends arrays and the mv3 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv3 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv3.equals(abbreviated[o])) {

					mv3 = possiblemoves[o];
				}


			}

		} else if (pokemonname.equals("volcarona")) {

			String[] possiblemoves = {"hiddenpower", "flamethrower", "calmmind", "quiverdance", "bugbuzz", "wildcharge", "psychic"}; // array of possible moves for this pokemon
			String[] abbreviated = {"hp", "ft", "cm", "qd", "bb", "wc", "ps"};// array of the abbreviated moves
			String[] explain = {" [the user attacks with a 60 base power special attack of any type]",
					"[user shoots fire at the opponent, 90 power 10% chance to burn]",
					"[User increases its spa and Spdef stats]",
					"[ calm mind on steroids: also boosts speed, is super overpowered]",
					"[the user screeches reeeeeeeee, 90 power, 10% chance to drop spdef of opponent] ",
					"[hits the opponent with a 90 power physical electric type attack, hurts user as well]",
					"[A 90 power psychic move that hits for 90 power and has a 10% for a spdef drop] "};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv3 = scan.nextLine();

			while (legitmove3(possiblemoves, abbreviated, mv3, move1, move2) != true) { // sends arrays and the mv3 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv3 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv3.equals(abbreviated[o])) {

					mv3 = possiblemoves[o];
				}


			}
		} else if (pokemonname.equals("pikachu")) {
			String[] possiblemoves = {"honeclaws", "thunderbolt", "volttackle", "hiddenpower", "toxic", "extremespeed", "quickattack", "thunderwave", "surf", "horndrill"}; // array of possible moves for this pokemon
			String[] abbreviated = {"hc", "tb", "vt", "hp", "tx", "es", "qa", "tw", "su", "hd"};// array of the abbreviated moves
			String[] explain = {"[Raises accuracy of attacks and increases their power] (I gave it to pikachu cause I felt like it)", " [A 90 base power electric attack with a 10 % chance of paralysis]",
					" [a 120 base power electric tackle attack, causes recoil but it goes hard]  ",
					" [A 60 base power move that can be any type the user desires]  ",
					" [this move poisons the opponent and the poison damage increases over time(poison types can't miss)] ",
					" [ha ha fast pikachu goes brrr (an 80 base power move that ussually hits first)]  ",
					" [A weaker extremespeed (just use extremespeed)] ",
					" [Has a 90 percent chance to paralyze opponent] ",
					" [A 90 base power watermove, yup I let pikachu learn this with lightball boosting its stats, it needs all the help it can get]",
					" [A move with a 30% chance to one-shot the opponent, pikachu shouldn't be able to learn this but I just want to see the power of friendship lol."};

			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv3 = scan.nextLine();

			while (legitmove3(possiblemoves, abbreviated, mv3, move1, move2) != true) { // sends arrays and the mv3 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv3 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv3.equals(abbreviated[o])) {

					mv3 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("mimikyu")) {
			String[] possiblemoves = {"swordsdance", "thunderwave", "toxic", "bulkup", "leechlife", "drainpunch", "shadowclaw", "playrough", "shadowsneak"}; // array of possible moves for this pokemon
			String[] abbreviated = {"sd", "tw", "tx", "bu", "ll", "dp", "sc", "pr", "ss"};// array of the abbreviated moves
			String[] explain = {" [sharply increases attack]",
					"[paralyzes opponent] ",
					"[poisons opponent, opponent takes damage every turn, they're screwed if they can't win quickly] ",
					"[raises attack and defense] ",
					"[An 80 power bug move that drains the opponent's hp and heals you] ",
					"[a punch of toxicity, 75 base power; the user gains some health back]  ",
					"[A slash of sinister intent, 75 power, high crit rate]  ",
					"[A 90 base power fairy move, has a chance to reduce the opponent's attack]",
					"[You hit the opponent with a 40 base power ghostly sneak attack like they owe you money]"};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv3 = scan.nextLine();

			while (legitmove3(possiblemoves, abbreviated, mv3, move1, move2) != true) { // sends arrays and the mv3 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv3 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv3.equals(abbreviated[o])) {

					mv3 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("noivern")) {
			String[] possiblemoves = {"boomburst", "dragonpulse", "moonlight", "flamethrower", "toxic", "darkpulse", "dracometeor", "psychic", "superfang"}; // array of possible moves for this pokemon
			String[] abbreviated = {"bb", "dp", "ml", "ft", "tx", "dpu", "dm", "ps", "sf"};// array of the abbreviated moves
			String[] explain = {" [a 150 power normal move, loud noise go brrrr] ",
					"[An 80 power base dragon move]  ",
					" [the user heals some of their health back] ",
					" [A 95 base power fire move with a 10% chance to burn] ",
					" [poisons the opponent with a toxin] ",
					" [An 80 base power dark move with a chance to flinch(20 %)] ",
					" [A 120 base power special dragon move, reduces the user's special attack] ",
					" [Mind melt, 90 power psychic move, can reduce special defense]",
					" [Halves the opponent's hp, slicey dicey]"};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv3 = scan.nextLine();

			while (legitmove3(possiblemoves, abbreviated, mv3, move1, move2) != true) { // sends arrays and the mv3 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv3 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv3.equals(abbreviated[o])) {

					mv3 = possiblemoves[o];
				}


			}

		} else if (pokemonname.equals("hawlucha")) {

			String[] possiblemoves = {"bravebird", "ironhead", "rockslide", "honeclaws", "brickbreak", "swordsdance", "poisonjab", "roost"}; // array of possible moves for this pokemon
			String[] abbreviated = {"bbi", "ih", "rs", "hc", "bb", "sd", "pj", "roo"};// array of the abbreviated moves
			String[] explain = {" [a 120 base power flying move, hurts the user too tho]", "[an 80 power steel move with a 30% chance to flinch ]", "[a lot of rocks are slammed on the opponent , 30% chance to flinch ] ", " [Boosts the user's attack and accuracy]", "[ a 75 base power fighting move] ", " [sharply raises the user's attack] ", "[the user jabs the opponent with poison, 30 % chance to poison] ", "[Heals the user but they lose their flying type for a turn]"};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv3 = scan.nextLine();

			while (legitmove3(possiblemoves, abbreviated, mv3, move1, move2) != true) { // sends arrays and the mv3 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv3 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv3.equals(abbreviated[o])) {

					mv3 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("zoroark")) {

			String[] possiblemoves = {"honeclaws", "brickbreak", "nastyplot", "nightslash", "darkpulse", "shadowball", "sludgebomb", "suckerpunch", "focusblast", "flamethrower",}; // array of possible moves for this pokemon
			String[] abbreviated = {"hc", "bb", "np", "ns", "dpu", "sba", "sb", "sp", "fb", "ft"};// array of the abbreviated moves
			String[] explain = {"[A move that raises physical attack and accuracy]",
					"[A 75 base power fighting move]",
					"[This move sharply raises special attack]",
					"[a base 75 power dark slashing move, someone's getting sniped]",
					" [a dark aura is shot at the opponent, a chance to flinch is present]",
					" [an 80 power ghost move , 30 % chance for opposing spdef reduction] ",
					"[an 85 base power poison move with a 30% chance to poison]  ",
					" [An 80 base power move that only works if the opponent uses an attack]",
					" [A 120 base power fighting move with 70 accuracy] ",
					" [ Your opponent gets hit with fire, a 90 power fire move with 100 accuracy]"};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv3 = scan.nextLine();

			while (legitmove3(possiblemoves, abbreviated, mv3, move1, move2) != true) { // sends arrays and the mv3 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv3 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv3.equals(abbreviated[o])) {

					mv3 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("garchomp")) {

			String[] possiblemoves = {"firefang", "flamethrower", "dragonclaw", "rockslide", "brickbreak",
					"earthquake", "crunch", "swordsdance", "ironhead", "poisonjab", "dracometeor"}; // array of possible moves for this pokemon
			String[] abbreviated = {"ff", "ft", "dc", "rs", "bb",
					"ea", "cr", "sd", "ih", "pj", "dm"};// array of the abbreviated moves
			String[] explain = {"[a 65 power physical fire move (95 accuracy) 10 percent chance to burn or flinch]",
					"  [a 90 power special fire move (100 accuracy) 10 percent chance to burn] ",
					" [an 80 base power dragon type move] ",
					" [a lot of rocks are slammed on the opponent , 30% chance to flinch ] ",
					" [ a 75 base power fighting move] ",
					" [a 100 base ground move] ",
					" [an 80 power dark move that crunches opponent, 20 percent chance for defense drop] ",
					" [Boosts attack, makes a pokemon go from good to overpowered in one turn]",
					" [An 80 base power steel move wrecks fairies and ice pokemon]",
					" [An 85 base power toxic jab that can poison the opponent]",
					" [Asteroids fall from the sky and obliterate all in their path, 120 base power, harshly reduces special attack]"
			};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv3 = scan.nextLine();

			while (legitmove3(possiblemoves, abbreviated, mv3, move1, move2) != true) { // sends arrays and the mv3 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv3 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv3.equals(abbreviated[o])) {

					mv3 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("tyranitar")) {

			String[] possiblemoves = {"icepunch", "flamethrower", "surf", "rockslide",
					"brickbreak", "earthquake", "crunch", "dragondance", "darkpulse", "thunderbolt"}; // array of possible moves for this pokemon
			String[] abbreviated = {"ip", "ft", "su", "rs",
					"bb", "ea", "cr", "dd", "dp", "tb"};// array of the abbreviated moves
			String[] explain = {
					"[a 75 base power ice move, dragons hate it lol]",
					"  [a 90 power special fire move (100 accuracy) 10 percent chance to burn] ",
					" [a 90 base power water move] ",
					" [a lot of rocks are slammed on the opponent , 30% chance to flinch ] ",
					" [ a 75 base power fighting move] ",
					" [a 100 base ground move] ",
					" [an 80 power dark move that crunches opponent, 20 percent chance for defense drop] ",
					" [Boosts attack, makes a pokemon go from good to overpowered in one turn, raises attack and speed]",
					" [An 80 base power dark move wrecks psychic and ghost pokemon]",
					" [An 90 base power electric shock that can paralyze the opponent]"
			};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv3 = scan.nextLine();

			while (legitmove3(possiblemoves, abbreviated, mv3, move1, move2) != true) { // sends arrays and the mv3 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv3 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv3.equals(abbreviated[o])) {

					mv3 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("lucario")) {

			String[] possiblemoves = {"calmmind", "dragonpulse", "aurasphere", "closecombat", "swordsdance",
					"bulletpunch", "shadowball", "meteormash", "psychic", "extremespeed", "flashcannon"}; // array of possible moves for this pokemon
			String[] abbreviated = {"cm", "dpu", "asp", "cc", "sd", "bp", "sb", "mm", "ps", "es", "fc"};// array of the abbreviated moves
			String[] explain = {"[boosts special attack and special defense]",
					"[User expels their inner dragon, 80 base power special attack]",
					"[the user attacks with an 80 power fighting move that never misses]",
					"[user hits the opponent up close, the opponent gets jumped, the user's defenses lower however]",
					"[User sharply increases its physical attack]",
					"[a punch as fast as my internet, 40 base power steel move]",
					"[the user hits a ball of shadow, 80 power, 30% chance to drop spdef of opponent] ",
					"[The opponent gets mashed with some crisp clean steel, may raise attack but also may miss]",
					"[ A psychic move that hits for 90 power and has a 10% for a spdef drop] ",
					"[The fastest move in the game, always moves first, 80 base power, it is speed, gotta go fast]",
					"[A steel beam is shot at the opponent, 90 base power, can reduce spdef]"};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv3 = scan.nextLine();

			while (legitmove3(possiblemoves, abbreviated, mv3, move1, move2) != true) { // sends arrays and the mv3 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv3 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv3.equals(abbreviated[o])) {

					mv3 = possiblemoves[o];
				}


			}

		} else if (pokemonname.equals("flygon")) {

			String[] possiblemoves = {"dragondance", "earthquake", "dragonclaw", "dracometeor",
					"rockslide", "flamethrower", "boomburst", "crunch", "bugbuzz"}; // array of possible moves for this pokemon
			String[] abbreviated = {"dd", "eq", "dc", "dm",
					"rs", "ft", "bb", "cr", "bu"};// array of the abbreviated moves
			String[] explain = {"[boosts attack and speed]", " [A 100 power ground move]", "[user hits the target with 80 power dragon power]", "[An 120 power dragon move that reduces special attack of the user ]"
					, "[The opponent is hit with a lot of rocks, 75 power, 30% chance to flinch]", "[the user hits the opponent with flames 90 power, 10% chance to burn] ", " [ The user screeches reeeeeee, a 150 base power normal move]", "[ An 80 base power dark move that can reduce defense] ", "[The user screeches reeee in bug language, a 90 power bug type attack]"};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv3 = scan.nextLine();

			while (legitmove3(possiblemoves, abbreviated, mv3, move1, move2) != true) { // sends arrays and the mv3 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv3 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv3.equals(abbreviated[o])) {

					mv3 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("dragapult")) {

			String[] possiblemoves = {"dragondance", "willowisp", "dragonclaw", "dracometeor",
					"bodyslam", "thunderbolt", "confuseray", "suckerpunch", "shadowball", "surf"}; // array of possible moves for this pokemon
			String[] abbreviated = {"dd", "ww", "dc", "dm",
					"bs", "tb", "cr", "sp", "sb", "su"};// array of the abbreviated moves
			String[] explain = {"[boosts attack and speed]", " [burns the opponent]",
					"[user hits the target with 80 power dragon power]", "[An 120 power dragon move that reduces special attack of the user ]"
					, "[The opponent is slammed with a lot of force, 80 power, 30% chance to paralyze]",
					"[the user hits the opponent with electricity 90 power, 10% chance to paralyze] ",
					"[user confuses the opponent]"
					, "[The user sneak attacks the opponent before the opponent can attack]",
					" [ The user throws a ball of shadow energy, 80 base power]",
					"[ A 90 base power water move]"};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv3 = scan.nextLine();

			while (legitmove3(possiblemoves, abbreviated, mv3, move1, move2) != true) { // sends arrays and the mv3 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv3 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv3.equals(abbreviated[o])) {

					mv3 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("goodra")) {
			String[] possiblemoves = {"sludgebomb", "focusblast", "hydropump", "dragonpulse", "flashcannon", "flamethrower", "surf", "darkpulse", "dracometeor"}; // array of possible moves for this pokemon
			String[] abbreviated = {"sb", "fb", "hp", "dp", "fc", "ft", "su", "dpu", "dm"};// array of the abbreviated moves
			String[] explain = {"[An 80 base power poison move, 30% chance to poison]", "[A 120 base power fighting special attack, 70 accuracy]", "[A hard hitting 110 base power water move with 80 accuracy] ", "[An 80 power base dragon move]  ", " [A 90 base power steel move] ", " [A 95 base power fire move with a 10% chance to burn] ", " [A 95 base power water move] ", " [An 80 base power dark move with a chance to flinch(20 %)] ", " [A 120 base power special dragon move, reduces the user's special attack] "};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv3 = scan.nextLine();

			while (legitmove3(possiblemoves, abbreviated, mv3, move1, move2) != true) { // sends arrays and the mv3 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv3 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv3.equals(abbreviated[o])) {

					mv3 = possiblemoves[o];
				}


			}


		}
		else if (pokemonname.equals("charizard")) {

			String[] possiblemoves = {"dragonpulse", "dragondance", "earthquake", "dragonclaw", "flareblitz", "rockslide", "flamethrower", "airslash", "thunderpunch"}; // array of possible moves for this pokemon
			String[] abbreviated = {"dp", "dd", "eq", "dc", "fb", "rs", "ft", "as", "tp"};// array of the abbreviated moves
			String[] explain = {"[user unleashes their inner dragon, 85 base power]", "[boosts attack and speed]", " [A 100 power ground move]", "[user hits the target with base 80 physical dragon power]", "[An 120 power fire move that reduces the hp of the user as well]", "[The opponent is hit with a lot of rocks, 75 power, 30% chance to flinch]", "[the user hits the opponent with flames 90 power, 10% chance to burn] ", " [ The user slashes air at the opponent, 30% chance to flinch]", "[ the user hits with electric power] "};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv3 = scan.nextLine();

			while (legitmove3(possiblemoves, abbreviated, mv3, move1, move2) != true) { // sends arrays and the mv3 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv3 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv3.equals(abbreviated[o])) {

					mv3 = possiblemoves[o];
				}


			}
		}
		else if (pokemonname.equals("golisopod")) {

			String[] possiblemoves = {"swordsdance", "bulkup", "suckerpunch", "aquajet", "closecombat",
					"leechlife", "poisonjab", "rockslide", "aerialace"}; // array of possible moves for this pokemon
			String[] abbreviated = {"sd", "bu", "sp", "aj", "cc", "ll", "pj","rs",  "aa"};// array of the abbreviated moves
			String[] explain = {" [sharply raises the user's attack]",
					"[raises attack and defense ]",
					"[user sneaks the opponent like college sneaked my bank account, base 80 power, only works if the opponent is about to attack] "
					, " [User hits with a jet stream of water, base 40 power]", "[ A 120 base power fighting move that reduces the defenses of the user] ",
					" [a base 75 power bug move that can heal the user] ", "[the user jabs the opponent with poison, 30 % chance to poison] ",
					"[User hits the foe with rocks, rocks may miss but may also flinch]",
					"[user slashes with an aerial technique that always hits]"};

			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv3 = scan.nextLine();

			while (legitmove3(possiblemoves, abbreviated, mv3, move1, move2) != true) { // sends arrays and the mv3 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv3 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv3.equals(abbreviated[o])) {

					mv3 = possiblemoves[o];
				}


			}


		}

		else if (pokemonname.equals("roserade")) {

			String[] possiblemoves = {"toxic", "extrasensory", "shadowball", "sludgebomb", "energyball", "dazzlinggleam", "hiddenpower",}; // array of possible moves for this pokemon
			String[] abbreviated = {"tx", "ex", "sb", "sb", "eb", "dg", "hp"};// array of the abbreviated moves
			String[] explain = {"[this move poisons the opponent and the poison damage increases over time(poison types can't miss)]",
					" [opponent is hit with a base 80 psychic power]",
					" [an 80 power ghost move , 30 % chance for opposing spdef reduction] ",
					"[an 85 base power poison move with a 30% chance to poison]  ",
					" [An 90 base power grass move that hits hard]", " [A 80 base power fairy move with 100 accuracy] ",
					" [A move that can be of any type the user desires, base 60 power]"};



			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv3 = scan.nextLine();

			while (legitmove3(possiblemoves, abbreviated, mv3, move1, move2) != true) { // sends arrays and the mv3 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv3 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv3.equals(abbreviated[o])) {

					mv3 = possiblemoves[o];
				}


			}

		}
		else if (pokemonname.equals("sceptile")) {
			String[] possiblemoves = {"quickattack", "swordsdance", "leafblade", "energyball", "return", "xscissor", "hiddenpower", "aerialace"}; // array of possible moves for this pokemon
			String[] abbreviated = {"qa","sd", "lb", "eb", "re", "xs", "hp", "aa"};// array of the abbreviated moves
			String[] explain = {"[Hits fast and usually hits first]", "[Sharply raises attack]",
					" [A grass attack with a higher chance of crits, 70 base power] ",
					" [This is a 90 base power move that hits hard] ",
					"[a 102 base power normal physical attack]  ",
					"[80 base power bug move]  ",
					" [A special attack that can be any type the user desires(60 base power) ] ",
					" [60 base power flying move that never misses] "};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv3 = scan.nextLine();

			while (legitmove3(possiblemoves, abbreviated, mv3, move1, move2) != true) { // sends arrays and the mv3 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv3 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv3.equals(abbreviated[o])) {

					mv3 = possiblemoves[o];
				}


			}

		}
		else if (pokemonname.equals("mewtwo")) {
			String[] possiblemoves = {"calmmind", "thunderbolt", "psychic", "shadowball", "flamethrower", "icebeam", "aurasphere", "recover", "toxic"}; // array of possible moves for this pokemon
			String[] abbreviated = {"cm", "tb", "ps", "sb", "ft", "ib", "as", "re", "tx"};// array of the abbreviated moves
			String[] explain = {"[raises special attack and special defense]", "[The user zaps the opponent with electricity," +
					" 90 base power move, 10 % chance to paralyze]",
					" [90 base power psychic move with 100 accuracy] ",
					" [A 80 power ghost move that has 100 accuracy] ",
					"[A 95 power fire move with 100 accuracy]  ",
					" [An icy beam is shot at the opponent, ice type 90 base power, 10% chance to freeze] ",
					" [A 80 base power fighting special attack no one can dodge ]  ",
					" [The user heals itself by 1/2 of its max hp] ", "[poisons opponent, RIP the other player lol]"};



			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv3 = scan.nextLine();

			while (legitmove3(possiblemoves, abbreviated, mv3, move1, move2) != true) { // sends arrays and the mv3 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv3 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv3.equals(abbreviated[o])) {

					mv3 = possiblemoves[o];
				}


			}


		}
		else if (pokemonname.equals("talonflame")) {


			String[] possiblemoves = {"bravebird", "flareblitz", "quickattack",
					"return", "gigaimpact", "swordsdance", "steelwing", "roost"}; // array of possible moves for this pokemon
			String[] abbreviated = {"bb", "fb", "qa",
					"re", "gi", "sd", "sw", "ro"};// array of the abbreviated moves
			String[] explain = {" [A 120 base power flying move, user takes 1/3 recoil]",
					"[an 120 base power fire move, user takes 1/3 recoil ]",
					"[user hits fast with a 40 base power normal move]",
					"[the opponent is hit with a 102 base power normal move  ] ",
					"[User hits the opponent with a 150 base power normal move but has to recharge]",
					"[sharply raises attack] ",
					"[sharp steel wings are slashed at the opponent, 70 power 90 accuracy] ",
					"[the user roosts and regains hp, user loses flying temporarily] "};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv3 = scan.nextLine();

			while (legitmove3(possiblemoves, abbreviated, mv3, move1, move2) != true) { // sends arrays and the mv3 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv3 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv3.equals(abbreviated[o])) {

					mv3 = possiblemoves[o];
				}


			}




		}
		else if (pokemonname.equals("snorlax")) {

			String[] possiblemoves = {"return", "crunch", "earthquake",
					"zenheadbut", "firepunch", "icepunch",
					"thunderpunch", "hyperbeam"}; // array of possible moves for this pokemon
			String[] abbreviated = {"re", "cr", "eq",
					"zh", "fp", "ip",
					"tp", "hb"};// array of the abbreviated moves
			String[] explain = {"[a 102 base power normal move]", " [snorlax attacks with 80 base power darkness]", "[user hits the target with a 100 power ground high crit rate move]",
					"[an 85 base power psychic  move, can miss but can also flinch]", "[The opponent is hit with a fiery punch, 75 power, 10% chance to burn]", "[the user hits an icy punch, 75 power, 10% chance to freeze] ",
					" [The user uses an electric punch to hit the opponent, 75 power; 10% chance to paralyze]", "[ a 150 base power move (special attack) , forces one to recharge] "};




			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv3 = scan.nextLine();

			while (legitmove3(possiblemoves, abbreviated, mv3, move1, move2) != true) { // sends arrays and the mv3 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv3 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv3.equals(abbreviated[o])) {

					mv3 = possiblemoves[o];
				}


			}


		}
		else if (pokemonname.equals("infernape")) {

			String[] possiblemoves = {"closecombat", "flareblitz", "swordsdance",
					"stoneedge", "flamethrower", "focusblast",
					"thunderpunch", "earthquake",
					"nastyplot","hiddenpower"}; // array of possible moves for this pokemon
			String[] abbreviated = {"cc", "fb", "sd",
					"se", "ft", "fb",
					"tb", "eq" ,
					"np","hp"};// array of the abbreviated moves
			String[] explain = {"[A 120 power fighting move, reduces the user's defense and special defense]", "[A 120 base power physical fire move but the user takes 1/3 of the damage as recoil] ", " [sharply boosts attack] ",
					" [a base 100 power rock move, can crit but also can miss] ", " [a 90 base power fire move that can burn the opponent] ", " [a 120 base power fighting blast that can reduce the opponent's special defense] ",
					" [A 75 base power electric move, may paralyze opponent] ", " [A 100 base power ground move]",
					"[sharply boosts special attack]","[aa 60 base power move that can be any type the user desires]"};




			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv3 = scan.nextLine();

			while (legitmove3(possiblemoves, abbreviated, mv3, move1, move2) != true) { // sends arrays and the mv3 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv3 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv3.equals(abbreviated[o])) {

					mv3 = possiblemoves[o];
				}


			}


		}
		else if (pokemonname.equals("weavile")) {
			String[] possiblemoves = {"icepunch", "nightslash",
					"brickbreak",
					"iceshard", "slash",
					"poisonjab", "swordsdance"}; // array of possible moves for this pokemon
			String[] abbreviated = {"ip", "ns",
					"bb",
					"is", "s",
					"pj", "sd"};// array of the abbreviated moves
			String[] explain = {" [The user hits the opponent with an icy 75 base power punch ,10% chance to freeze] ", "[A 75 base power dark move, high crit rate] ",
					"[ A 75 base power fighting move ]  ",
					"[A fast ice type physical attack, 40 base power]  ", "[A 75 base power normal move, high crit rate]  ",
					"[A 85 base power ice move with a 30% chance to poison ] ", "[sharply raises attack]  "};






			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv3 = scan.nextLine();

			while (legitmove3(possiblemoves, abbreviated, mv3, move1, move2) != true) { // sends arrays and the mv3 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv3 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv3.equals(abbreviated[o])) {

					mv3 = possiblemoves[o];
				}


			}

		}
		else if (pokemonname.equals("groudon")) {

			String[] possiblemoves = {"bulkup", "dragonclaw", "earthquake",
					"focusblast", "rockslide",
					"flamethrower", "brickbreak",
					"swordsdance", "poisonjab", "thunderbolt"}; // array of possible moves for this pokemon
			String[] abbreviated = {"bu", "dc", "ea",
					"fb", "rs",
					"ft", "bb",
					"sd", "pj", "tb"};// array of the abbreviated moves
			String[] explain = {"[raises attack and defense]", "[An 80 base power dragon move]", " [a 100 base power physical ground move]",
					"[an 120 power fighting move with a chance to reduce spdef ]", "[a lot of rocks are slammed on the opponent , 30% chance to flinch ] ",
					" [user expels flames that can burn the opponent, 90 base power]", "[ a 75 base power fighting move] ",
					" [sharply raises the user's attack] ", "[the user jabs the opponent with poison, 30 % chance to poison] ", "[User hits with a 95 base power electric move, with a chance to paralyze]"};








			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv3 = scan.nextLine();

			while (legitmove3(possiblemoves, abbreviated, mv3, move1, move2) != true) { // sends arrays and the mv3 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv3 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv3.equals(abbreviated[o])) {

					mv3 = possiblemoves[o];
				}


			}

		}
		else if (pokemonname.equals("kyogre")) {

			String[] possiblemoves = {"calmmind", "hyperbeam", "surf",
					"hydropump", "icebeam",
					"blizzard", "brickbreak",
					"aquaring", "thunderwave", "thunderbolt"}; // array of possible moves for this pokemon
			String[] abbreviated = {"cm", "hb", "su",
					"hp", "ib",
					"bli", "bri",
					"aq", "tw", "tb"};// array of the abbreviated moves
			String[] explain = {"[raises special attack and special defense]", "[An 150 base power normal move that requires a recharge turn]", " [a 95 base power special water move]",
					"[an 120 power water move with 80 accuracy]", "[an icy beam with a chance to freeze is launched at the opponent ] ",
					" [a 120 base power ice move with 70 accuracy]", "[ a 75 base power fighting move] ",
					" [a veil of water is used to let the user gain a little hp every turn] ", "[the user paralyzes the opponent] ", "[User hits with a 95 base power electric move, with a chance to paralyze]"};









			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv3 = scan.nextLine();

			while (legitmove3(possiblemoves, abbreviated, mv3, move1, move2) != true) { // sends arrays and the mv3 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv3 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv3.equals(abbreviated[o])) {

					mv3 = possiblemoves[o];
				}


			}





		}
		else if (pokemonname.equals("rayquaza")) {

			String[] possiblemoves = {"dragondance", "earthquake",
					"dragonclaw", "dracometeor",
					"rockslide", "flamethrower",
					"airslash", "hyperbeam"}; // array of possible moves for this pokemon
			String[] abbreviated = {"dd", "eq",
					"dc", "dm",
					"rs", "ft",
					"as", "hb"};// array of the abbreviated moves
			String[] explain = {"[boosts attack and speed]", " [A 100 power ground move]",
					"[user hits the target with 80 power dragon power]", "[An 120 power dragon move that reduces special attack of the user ]",
					"[The opponent is hit with a lot of rocks, 75 power, 30% chance to flinch]", "[the user hits the opponent with flames 90 power, 10% chance to burn] ",
					" [ The user slashes air at the opponent, 30% chance to flinch]", "[A beam is shot at the opponent, 150 base power, requres a recharge turn] "};









			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv3 = scan.nextLine();

			while (legitmove3(possiblemoves, abbreviated, mv3, move1, move2) != true) { // sends arrays and the mv3 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv3 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv3.equals(abbreviated[o])) {

					mv3 = possiblemoves[o];
				}


			}



		}
		else if (pokemonname.equals("giratina-altered")) {

			String[] possiblemoves = {"calmmind", "willowisp",
					"dragonclaw", "dracometeor",
					"aurasphere",
					"darkpulse",
					"energyball",
					"earthquake",
					"shadowball",
					"shadowsneak"}; // array of possible moves for this pokemon
			String[] abbreviated = {"cm", "ww",
					"dc", "dm",
					"as",
					"dp",
					"eb",
					"eq",
					"sb",
					"ss"};// array of the abbreviated moves
			String[] explain = {"[boosts special attack and special defense]", " [burns the opponent]",
					"[user hits the target with 80 power dragon power]", "[An 120 power dragon move that reduces special attack of the user ]"
					, "[The opponent is slammed with an 80 power fighting move that never misses]",
					"[the user hits the opponent with a dark type 80 power with a chance to flinch] ",
					"[the user hits the opponent with a grass type 90 power with a chance to reduce spdef]"
					, "[A 100 base power ground move]",
					" [The user throws a ball of shadow energy, 80 base power]",
					"[User sneaks the opponent, 40 base ghost power]"};







			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv3 = scan.nextLine();

			while (legitmove3(possiblemoves, abbreviated, mv3, move1, move2) != true) { // sends arrays and the mv3 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv3 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv3.equals(abbreviated[o])) {

					mv3 = possiblemoves[o];
				}


			}




		}
		else if (pokemonname.equals("giratina-origin")) {

			String[] possiblemoves = {"calmmind", "willowisp",
					"dragonclaw", "dracometeor",
					"aurasphere",
					"darkpulse",
					"energyball",
					"earthquake",
					"shadowball",
					"shadowsneak"}; // array of possible moves for this pokemon
			String[] abbreviated = {"cm", "ww",
					"dc", "dm",
					"as",
					"dp",
					"eb",
					"eq",
					"sb",
					"ss"};// array of the abbreviated moves
			String[] explain = {"[boosts special attack and special defense]", " [burns the opponent]",
					"[user hits the target with 80 power dragon power]", "[An 120 power dragon move that reduces special attack of the user ]"
					, "[The opponent is slammed with an 80 power fighting move that never misses]",
					"[the user hits the opponent with a dark type 80 power with a chance to flinch] ",
					"[the user hits the opponent with a grass type 90 power with a chance to reduce spdef]"
					, "[A 100 base power ground move]",
					" [The user throws a ball of shadow energy, 80 base power]",
					"[User sneaks the opponent, 40 base ghost power]"};







			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv3 = scan.nextLine();

			while (legitmove3(possiblemoves, abbreviated, mv3, move1, move2) != true) { // sends arrays and the mv3 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv3 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv3.equals(abbreviated[o])) {

					mv3 = possiblemoves[o];
				}


			}



		}

		else if (pokemonname.equals("gardevoir")) {
			String[] possiblemoves = {"psychic", "shadowball", "thunderbolt",
					"calmmind", "dazzlinggleam", "hiddenpower", "energyball"}; // array of possible moves for this pokemon
			String[] abbreviated = {"ps", "sb", "tb",
					"cm", "dg", "hp", "eb"};// array of the abbreviated moves
			String[] explain = {" [A 90 base power psychic move with a 10% chance of a reduction in opponent's spdef] ", " [an 80 base power ghost move with a 30% chance to reduce opponent spdef] ", " [a 90 base power electric move that can paralyze the opponent] ",
					"[raises special attack and special defense] ", "[An 80 base power fairy move]  ", "[A 60 base power move that can be any type the user desires] ", " [A 90 base power grass move that can reduce spdef ]"};






			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv3 = scan.nextLine();

			while (legitmove3(possiblemoves, abbreviated, mv3, move1, move2) != true) { // sends arrays and the mv3 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv3 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv3.equals(abbreviated[o])) {

					mv3 = possiblemoves[o];
				}


			}



		}
		else if (pokemonname.equals("gallade")) {
			String[] possiblemoves = {"bulkup", "nightslash", "psychic", "closecombat",
					"swordsdance", "poisonjab", "rockslide", "earthquake"}; // array of possible moves for this pokemon
			String[] abbreviated = {"bu", "ns", "ps", "cc",
					"sd", "pj", "rs", "eq"};// array of the abbreviated moves
			String[] explain = {" [increases attack and defense]",
					"[A 75 base power dark move with a high crit rate] ",
					" [A 90 base power psychic move with a 10 % to reduce spdef] ",
					" [A 120 base power fighting move that reduces spdef and def] ",
					"[sharply boosts attack] ",
					"[a punch of toxicity , 85 base power; 30 percent chance to poison]  ",
					"[A lot of rocks launched at the opponent, there is a chance to flinch as well]  ",
					"[A 100 base power ground move]"};





			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv3 = scan.nextLine();

			while (legitmove3(possiblemoves, abbreviated, mv3, move1, move2) != true) { // sends arrays and the mv3 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid) \n");
				mv3 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv3.equals(abbreviated[o])) {

					mv3 = possiblemoves[o];
				}


			}



		}



		return mv3;

	}


	// tests if a move is a duplicate or is in the move array


	private boolean legitmove4(String[] possiblemoves, String[] abbreviations, String testmove, String dupe, String dupe2, String dupe3) { // It is so cool that I can pass arrays as arguments in java, sadly i cant do it in c++ lol
		boolean test = false;

		for (int i = 0; i < abbreviations.length; i++) {

			if (possiblemoves[i].equals(testmove)) {

				test = true;
				break;

			} else if (abbreviations[i].equals(testmove)) {
				test = true;
				break;

			}


		}

		for (int j = 0; j < abbreviations.length; j++) {

			if (abbreviations[j].equals(testmove)) {

				testmove = possiblemoves[j];
			}
		}


		if (testmove.equals(dupe)) {

			test = false;
		} else if (testmove.equals(dupe2)) {

			test = false;
		} else if (testmove.equals(dupe3)) {

			test = false;
		}


		return test;

	}


	// no dupes


	public String getmovename(String player, String pokemonname, String move1, String move2, String move3) {
		String mv4 = "four";


		System.out.println("\n Input a fourth move, DO NOT INPUT THE SAME PREVIOUS MOVE" + player + ".");
		System.out.println("For example: [meteormash mm] (You can input 'meteormash' or 'mm') \n ");


		if (pokemonname.equals("metagross")) {

			String[] possiblemoves = {"meteormash", "zenheadbut", "thunderpunch", "icepunch", "rockslide", "return", "earthquake", "bulletpunch"}; // array of possible moves for this pokemon
			String[] abbreviated = {"mm", "zh", "tp", "ip", "rs", "re", "ea", "bp"};// array of the abbreviated moves
			String[] explain = {"[A 90 base power physical steel move with 90 accuracy and has a 10 percent chance to increase attack]", "[ A 85 base physical psychic move with 90 accuracy]", "[A punch of electricity, has a 10 percent chance to paralyze]", "[a punch of icy coldness, 10 percent chance to freeze]", "[a lot of rocks are slammed on the opponent , 30% chance to flinch ]", "[a 102 base power normal physical attack]", "[a 100 base ground move]", "[User ussually goes first in dishing out the 40 power steel bash]"};

			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);
			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv4 = scan.nextLine();

			while (legitmove4(possiblemoves, abbreviated, mv4, move1, move2, move3) != true) { // sends arrays and the mv4 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid)  \n");
				mv4 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv4.equals(abbreviated[o])) {

					mv4 = possiblemoves[o];
				}


			}

		} else if (pokemonname.equals("gliscor")) {

			String[] possiblemoves = {"toxic", "earthquake", "rockslide", "firefang", "thunderfang", "icefang", "swordsdance"}; // array of possible moves for this pokemon
			String[] abbreviated = {"tx", "ea", "rs", "ff", "tf", "if", "sd"};// array of the abbreviated moves
			String[] explain = {"[this move poisons the opponent and the poison damage increases over time(poison types can't miss)]", "[a 100 base power physical ground move]", "[a 75 power, 95 accuracy rock move that can flinch, user slams rocks on opponent.] ", " [a 65 power physical fire move (95 accuracy) 10 percent chance to burn or flinch]", " [a 65 power physical electric move (95 accuracy) 10 percent chance to paralyze or flinch] ", " [a 65 power physical ice move (95 accuracy) 10 percent chance to freeze or flinch ]", "[sharply raises user's attack ]"};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv4 = scan.nextLine();

			while (legitmove4(possiblemoves, abbreviated, mv4, move1, move2, move3) != true) { // sends arrays and the mv4 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid)  \n");
				mv4 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv4.equals(abbreviated[o])) {

					mv4 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("excadrill")) {
			String[] possiblemoves = {"honeclaws", "earthquake", "ironhead", "rockslide", "horndrill", "brickbreak", "swordsdance", "poisonjab"}; // array of possible moves for this pokemon
			String[] abbreviated = {"hc", "ea", "ih", "rs", "hd", "bb", "sd", "pj"};// array of the abbreviated moves
			String[] explain = {"[Raises accuracy of attacks and increases their power]", " [a 100 base power physical ground move]", "[an 80 power steel move with a 30% chance to flinch ]", "[a lot of rocks are slammed on the opponent , 30% chance to flinch ] ", " [Has a 30 percent chance to one-shot the opponent, can't hit ghosts]", "[ a 75 base power fighting move] ", " [sharply raises the user's attack] ", "[the user jabs the opponent with poison, 30 % chance to poison] "};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv4 = scan.nextLine();

			while (legitmove4(possiblemoves, abbreviated, mv4, move1, move2, move3) != true) { // sends arrays and the mv4 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid)  \n");
				mv4 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv4.equals(abbreviated[o])) {

					mv4 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("arcanine")) {


			String[] possiblemoves = {"closecombat", "flareblitz", "crunch", "extremespeed", "willowisp", "morningsun", "ironhead", "wildcharge"}; // array of possible moves for this pokemon
			String[] abbreviated = {"cc", "fb", "cr", "es", "ww", "ms", "ih", "wc"};// array of the abbreviated moves
			String[] explain = {"[A 120 power fighting move, reduces the user's defense and special defense]", "[A 120 base power physical fire move but the user takes 1/3 of the damage as recoil] ", " [an 80 power dark physical move that has a 20 percent chance for a defense drop] ", " [80 base power normal move that always moves first] ", " [has a 90 percent chance to burn the opponent] ", " [heals user by half of its max hp] ", " [an 80 power steel move with a 30% chance to flinch ] ", " [A 90 power electric physical attack, user takes 1/3 recoil]"};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv4 = scan.nextLine();

			while (legitmove4(possiblemoves, abbreviated, mv4, move1, move2, move3) != true) { // sends arrays and the mv4 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid)  \n");
				mv4 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv4.equals(abbreviated[o])) {

					mv4 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("krookodile")) {

			String[] possiblemoves = {"firefang", "thunderfang", "dragonclaw", "rockslide", "brickbreak", "earthquake", "crunch"}; // array of possible moves for this pokemon
			String[] abbreviated = {"ff", "tf", "dc", "rs", "bb", "ea", "cr"};// array of the abbreviated moves

			String[] explain = {"[a 65 power physical fire move (95 accuracy) 10 percent chance to burn or flinch]", "  [a 65 power physical electric move (95 accuracy) 10 percent chance to paralyze or flinch] ", " [an 80 base power dragon type move] ", " [a lot of rocks are slammed on the opponent , 30% chance to flinch ] ", " [ a 75 base power fighting move] ", " [a 100 base ground move] ", " [an 80 power dark move that crunches opponent, 20 percent chance for defense drop] "};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv4 = scan.nextLine();

			while (legitmove4(possiblemoves, abbreviated, mv4, move1, move2, move3) != true) { // sends arrays and the mv4 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid)  \n");
				mv4 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv4.equals(abbreviated[o])) {

					mv4 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("feraligatr")) {
			String[] possiblemoves = {"dragondance", "aquajet", "superpower", "waterfall", "icepunch", "earthquake", "dragonclaw", "crunch"}; // array of possible moves for this pokemon
			String[] abbreviated = {"dd", "aj", "sp", "wf", "ip", "ea", "dc", "cr"};// array of the abbreviated moves

			String[] explain = {"[boosts attack and speed]", " [a 40 base power physical priority water move]  ", " [a 120 base power fighting move that reduces attack and defense of the user] ", " [an 80 base power water move (with sheerforce it will be 110)] ", " [a punch of icy coldness, 10 percent chance to freeze] ", "[a 100 base power physical ground move]  ", " [an 80 base power dragon move] ", " [an 80 base power dark move and it has a 20 percent chance to reduce defense] "};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv4 = scan.nextLine();

			while (legitmove4(possiblemoves, abbreviated, mv4, move1, move2, move3) != true) { // sends arrays and the mv4 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid)  \n");
				mv4 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv4.equals(abbreviated[o])) {

					mv4 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("gyarados")) {

			String[] possiblemoves = {"dragondance", "icefang", "waterfall", "return", "irontail", "stoneedge", "earthquake"}; // array of possible moves for this pokemon
			String[] abbreviated = {"dd", "if", "wf", "re", "it", "se", "ea"};// array of the abbreviated moves
			String[] explain = {"[boosts attack and speed]", "[a 65 power physical ice move (95 accuracy) 10 percent chance to freeze or flinch ] ", "  [an 80 base power water move with a 20 percent chance to flinch] ", " [a 102 base power normal physical attack] ", " [A steel move that has 75 percent accuracy ]",
				"[The user snipes the opponent with stones (rock move, 100 base power, 80 accuracy]  ", " [ A 100 base power ground type move  with 100 accuracy] "};

			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv4 = scan.nextLine();

			while (legitmove4(possiblemoves, abbreviated, mv4, move1, move2, move3) != true) { // sends arrays and the mv4 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid)  \n");
				mv4 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv4.equals(abbreviated[o])) {

					mv4 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("starmie")) {
			String[] possiblemoves = {"thunderbolt", "psychic", "hydropump", "surf", "icebeam", "confuseray", "recover"}; // array of possible moves for this pokemon
			String[] abbreviated = {"tb", "ps", "hp", "su", "ib", "cr", "re"};// array of the abbreviated moves


			String[] explain = {"[The user zaps the opponent with electricity, 90 base power move, 10 % chance to paralyze]", " [90 base power psychic move with 100 accuracy] ", " [A 110 power water move that has 80 accuracy] ", "[A 95 power water move with 100 accuracy]  ", " [An icy beam is shot at the opponent, ice type 90 base power, 10% chance to freeze] ", " [confuses the opponent ]  ", " The user heals itself by 1/2 of its max hp] "};

			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv4 = scan.nextLine();

			while (legitmove4(possiblemoves, abbreviated, mv4, move1, move2, move3) != true) { // sends arrays and the mv4 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid)  \n");
				mv4 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv4.equals(abbreviated[o])) {

					mv4 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("gengar")) {

			String[] possiblemoves = {"toxic", "confuseray", "shadowball", "sludgebomb", "suckerpunch", "focusblast", "thunderbolt",}; // array of possible moves for this pokemon
			String[] abbreviated = {"tx", "cr", "sb", "su", "sp", "fb", "tb"};// array of the abbreviated moves
			String[] explain = {"[this move poisons the opponent and the poison damage increases over time(poison types can't miss)]", " [confuses the opponent]", " [an 80 power ghost move , 30 % chance for opposing spdef reduction] ", "[an 85 base power poison move with a 30% chance to poison]  ", " [An 80 base power move that only works if the opponent uses an attack]", " [A 120 base power fighting move with 70 accuracy] ", " [ A zap of electricity at the opponent, a 90 power electic move with 100 accuracy]"};

			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv4 = scan.nextLine();

			while (legitmove4(possiblemoves, abbreviated, mv4, move1, move2, move3) != true) { // sends arrays and the mv4 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid)  \n");
				mv4 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv4.equals(abbreviated[o])) {

					mv4 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("espeon")) {
			String[] possiblemoves = {"psychic", "shadowball", "quickattack", "calmmind", "dazzlinggleam", "hiddenpower", "morningsun"}; // array of possible moves for this pokemon
			String[] abbreviated = {"ps", "sb", "qa", "cm", "dg", "hp", "ms"};// array of the abbreviated moves
			String[] explain = {" [A 90 base power psychic move with a 10% chance of a reduction in opponent's spdef] ", " [an 80 base power ghost move with a 30% chance to reduce opponent spdef] ", " [a 40 base power move that usually hits first] ", "[raises special attack and special defense] ", "[An 80 base power fairy move]  ", "[A 60 base power move that can be any type the user desires] ", " [User heals itself by 1/2 of its max hp ]"};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv4 = scan.nextLine();

			while (legitmove4(possiblemoves, abbreviated, mv4, move1, move2, move3) != true) { // sends arrays and the mv4 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid)  \n");
				mv4 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv4.equals(abbreviated[o])) {

					mv4 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("jolteon")) {

			String[] possiblemoves = {"thunderbolt", "shadowball", "hiddenpower", "toxic", "pinmissle", "doublekick", "thunderwave"}; // array of possible moves for this pokemon
			String[] abbreviated = {"tb", "sb", "hp", "tx", "pm", "dk", "tw"};// array of the abbreviated moves
			String[] explain = {" [A 90 base power electric attack with a 10 % chance of paralysis]", "[a 80 power ghost special move with a 30 percent chance to reduce spdef]  ", " [A 60 base power move that can be any type the user desires]  ", " [this move poisons the opponent and the poison damage increases over time(poison types can't miss)] ", " [A physical bug move that can be 15,30,45,60,0r 75 base power]  ", " [A 60 base power physical fighting move] ", " [Has a 90 percent chance to paralyze opponent] "};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv4 = scan.nextLine();

			while (legitmove4(possiblemoves, abbreviated, mv4, move1, move2, move3) != true) { // sends arrays and the mv4 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid)  \n");
				mv4 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv4.equals(abbreviated[o])) {

					mv4 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("glaceon")) {
			String[] possiblemoves = {"icebeam", "hiddenpower", "shadowball", "iceshard", "waterpulse", "blizzard", "toxic"}; // array of possible moves for this pokemon
			String[] abbreviated = {"ib", "hp", "sb", "is", "wp", "bz", "tx"};// array of the abbreviated moves
			String[] explain = {" [A beam of ice that is shot at the opponent, 90 base power ,10% chance to freeze] ", "[A 60 base power move that can be any type the user desires] ", "[ An 80 base power ghost move with a 30 % chance to spdef drop]  ", "[A fast ice type physical attack, 40 base power]  ", "[A  60 base power water move with a 20 percent chance to confuse the opponent]  ", "[A 110 base power ice move with 70 accuracy] ", "[this move poisons the opponent and the poison damage increases over time(poison types can't miss)]  "};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv4 = scan.nextLine();

			while (legitmove4(possiblemoves, abbreviated, mv4, move1, move2, move3) != true) { // sends arrays and the mv4 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid)  \n");
				mv4 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv4.equals(abbreviated[o])) {

					mv4 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("sylveon")) {
			String[] possiblemoves = {"moonblast", "hyperbeam", "shadowball", "calmmind", "toxic", "dazzlinggleam", "hiddenpower"}; // array of possible moves for this pokemon
			String[] abbreviated = {"mb", "hb", "sb", "cm", "tx", "dg", "hp"};// array of the abbreviated moves


			String[] explain = {"[A 95 base power fairy move with a 30% chance to reduce special attack] ", " [A fairy beam is shot at the opponent, 150 base power, 90 accuracy , one turn recharge]  ", " [An 80 power ghost move that reduces spdef 30% of the time] ", " [raises special attack and special defense] ", " [this move poisons the opponent and the poison damage increases over time(poison types can't miss)] ", "[ An 80 base power fairy move] ", " [A 60 base power move that can be any type the user desires]  "};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv4 = scan.nextLine();

			while (legitmove4(possiblemoves, abbreviated, mv4, move1, move2, move3) != true) { // sends arrays and the mv4 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid)  \n");
				mv4 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv4.equals(abbreviated[o])) {

					mv4 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("umbreon")) {
			String[] possiblemoves = {"toxic", "moonlight", "quickattack", "confuseray", "hiddenpower", "darkpulse", "foulplay"}; // array of possible moves for this pokemon
			String[] abbreviated = {"tx", "ml", "qa", "cr", "hp", "dp", "fp"};// array of the abbreviated moves

			String[] explain = {" [this move poisons the opponent and the poison damage increases over time(poison types can't miss)] ", " [[Heals user by 1/2 of max hp] ", " [40 base power fast normal move] ", " [confuses the opponent] ", "[A 60 base power move that can be any type the user desires]   ", " [An 80 base power dark move with a 10% chance to flinch] ", " [An 80 base power move that uses the opponents attack]"};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv4 = scan.nextLine();

			while (legitmove4(possiblemoves, abbreviated, mv4, move1, move2, move3) != true) { // sends arrays and the mv4 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid)  \n");
				mv4 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv4.equals(abbreviated[o])) {

					mv4 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("leafeon")) {
			String[] possiblemoves = {"swordsdance", "leafblade", "toxic", "return", "xscissor", "synthesis", "aerialace"}; // array of possible moves for this pokemon
			String[] abbreviated = {"sd", "lb", "tx", "re", "xs", "sy", "aa"};// array of the abbreviated moves
			String[] explain = {"[Sharply raises attack]", " [A grass attack with a higher chance of crits, 70 base power] ", " [this move poisons the opponent and the poison damage increases over time(poison types can't miss)] ", "[a 102 base power normal physical attack]  ", "[80 base power bug move]  ", " [User recovers 1/2 of its max hp] ", " [60 base power flying move that never misses] "};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv4 = scan.nextLine();

			while (legitmove4(possiblemoves, abbreviated, mv4, move1, move2, move3) != true) { // sends arrays and the mv4 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid)  \n");
				mv4 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv4.equals(abbreviated[o])) {

					mv4 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("vaporeon")) {
			String[] possiblemoves = {"hydropump", "icebeam", "aquaring", "toxic", "hiddenpower", "shadowball", "surf"}; // array of possible moves for this pokemon
			String[] abbreviated = {"hd", "ib", "ar", "tx", "hp", "sb", "su"};// array of the abbreviated moves
			String[] explain = {"[A 110 base power water move, 80 accuracy]   ", " [A 90 base power ice move with 10% chance to freeze] ", " [The user starts gaining a little hp every turn] ", " [this move poisons the opponent and the poison damage increases over time(poison types can't miss)] ", " [A 60 base power move that can be any type the user desires]  ", " [A base 80 power ghost move, 30% chance to reduce spdef] ", " [A 95 base power water move] "};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv4 = scan.nextLine();

			while (legitmove4(possiblemoves, abbreviated, mv4, move1, move2, move3) != true) { // sends arrays and the mv4 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid)  \n");
				mv4 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv4.equals(abbreviated[o])) {

					mv4 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("flareon")) {
			String[] possiblemoves = {"flareblitz", "bulkup", "toxic", "willowisp", "return", "hiddenpower", "superpower"}; // array of possible moves for this pokemon
			String[] abbreviated = {"fb", "bu", "tx", "ww", "re", "hp", "sp"};// array of the abbreviated moves
			String[] explain = {" [A 120 base power physical fire move but the user takes 1/3 of the damage as recoil] ", " [raises this pokemon's attack and defense] ", " [this move poisons the opponent and the poison damage increases over time(poison types can't miss)] ", " [burns the opponent 85 percent of the time] ", " [a 102 base power normal physical attack] ", " [A 60 base power move that can be any type the user desires]  ", " [A 120 power fighting move that reduces the user's attack and defense] "};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv4 = scan.nextLine();

			while (legitmove4(possiblemoves, abbreviated, mv4, move1, move2, move3) != true) { // sends arrays and the mv4 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid)  \n");
				mv4 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv4.equals(abbreviated[o])) {

					mv4 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("scizor")) {

			String[] possiblemoves = {"bulletpunch", "nightslash", "xscissor", "slash", "quickattack", "gigaimpact", "swordsdance"}; // array of possible moves for this pokemon
			String[] abbreviated = {"bp", "ns", "xs", "s", "qa", "qi", "sd"};// array of the abbreviated moves
			String[] explain = {" [A 40 base power steel move that often moves first] ", "  [A 70 base power dark move with a higher chance of crits]  ", " [An 80 base power bug move] ", " [A 70 base power normal move with a higher chance of crits] ", "  [A 40 base power normal move that often moves first]", "[A 150 base power normal move, recharge required]  ", " [Sharply raises attack] "};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv4 = scan.nextLine();

			while (legitmove4(possiblemoves, abbreviated, mv4, move1, move2, move3) != true) { // sends arrays and the mv4 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid)  \n");
				mv4 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv4.equals(abbreviated[o])) {

					mv4 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("hydreigon")) {
			String[] possiblemoves = {"nastyplot", "dragonpulse", "flashcannon", "flamethrower", "surf", "darkpulse", "dracometeor"}; // array of possible moves for this pokemon
			String[] abbreviated = {"np", "dp", "fc", "ft", "su", "dpu", "dm"};// array of the abbreviated moves

			String[] explain = {" [Sharply raises special attack] ", "[An 80 power base dragon move]  ", " [A 90 base power steel move] ", " [A 95 base power fire move with a 10% chance to burn] ", " [A 95 base power water move] ", " [An 80 base power dark move with a chance to flinch(20 %)] ", " [A 120 base power special dragon move, reduces the user's special attack] "};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv4 = scan.nextLine();

			while (legitmove4(possiblemoves, abbreviated, mv4, move1, move2, move3) != true) { // sends arrays and the mv4 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid)  \n");
				mv4 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv4.equals(abbreviated[o])) {

					mv4 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("meloetta")) {
			String[] possiblemoves = {"workup", "relicsong", "psychic", "closecombat", "thunderbolt", "icepunch", "firepunch"}; // array of possible moves for this pokemon
			String[] abbreviated = {"wu", "rs", "ps", "cc", "tb", "ip", "fp"};// array of the abbreviated moves

			String[] explain = {" [increases attack and special attack]", "[A 80 base power move that changes meloetta to pirouette form with different stats] ", " [A 90 base power psychic move with a 10 % to reduce spdef] ", " [A 120 base power fighting move that reduces spdef and def] ", "[A zap of electricity (90 power); 10% chance to paralyze ", "[a punch of icy coldness, 75 base power; 10 percent chance to freeze]  ", "[A punch of fiery wrath;75 base power; 10 percent chance to burn]  "};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv4 = scan.nextLine();

			while (legitmove4(possiblemoves, abbreviated, mv4, move1, move2, move3) != true) { // sends arrays and the mv4 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid)  \n");
				mv4 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv4.equals(abbreviated[o])) {

					mv4 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("archeops")) {
			String[] possiblemoves = {"honeclaws", "earthquake", "rockslide", "stoneedge", "crunch", "dragonclaw", "aquatail"}; // array of possible moves for this pokemon
			String[] abbreviated = {"hc", "ea", "rs", "se", "cr", "dc", "at"};// array of the abbreviated moves
			String[] explain = {" [Raises attack and accuracy] ", " [A 100 base power ground move] ", " [a lot of rocks are slammed on the opponent , 30% chance to flinch ] ", " [A 100 base power rock move with a higher chance of crits and 80 accuracy] ", " [An 80 base power dark move; 10% chance to flinch] ", " [An 80 base power dragon pulse] ", " [A move that has a 90% chance to hit with 90 water based power]"};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv4 = scan.nextLine();

			while (legitmove4(possiblemoves, abbreviated, mv4, move1, move2, move3) != true) { // sends arrays and the mv4 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid)  \n");
				mv4 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv4.equals(abbreviated[o])) {

					mv4 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("crobat")) {


			String[] possiblemoves = {"bravebird", "crosspoison", "confuseray", "toxic", "superfang", "leechlife", "steelwing", "roost"}; // array of possible moves for this pokemon
			String[] abbreviated = {"bb", "cp", "cr", "tx", "sf", "ll", "sw", "ro"};// array of the abbreviated moves
			String[] explain = {" [A 120 base power flying move, user takes 1/3 recoil]", "[an 80 base power poison move with a high crit rate ]", "[Confuses the opponent]", "[the opponent is poisoned and takes more damage over time  ] ", " [The opponent loses half of its health ]", "[ a 80 base power bug move, user regains 1/2 of damage as hp] ", " [sharp steel wings are slashed at the opponent, 70 power 90 accuracy] ", "[the user roosts and regains hp, user loses flying temporarily] "};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv4 = scan.nextLine();

			while (legitmove4(possiblemoves, abbreviated, mv4, move1, move2, move3) != true) { // sends arrays and the mv4 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid)  \n");
				mv4 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv4.equals(abbreviated[o])) {

					mv4 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("manaphy")) {


			String[] possiblemoves = {"tailglow", "surf", "energyball",  "shadowball", "psychic", "dazzlinggleam", "icebeam"}; // array of possible moves for this pokemon
			String[] abbreviated = {"tg", "su", "eb", "sb", "ps", "dg", "ib"};// array of the abbreviated moves
			String[] explain = {" [An over powered move that boosts the special attack of the user. Manaphy's secret weapon]",
					"[A wave of water washes the opponent, 95 power move ]",
					"[A ball of grassy naturs hits the opponent, 90 power, 20% of a spdef drop]",
					 " [A shadowball sniped the opponent, ghost 80 power move with a 30% chance of a spdef drop]", "[ A psychic wave is shot at the opponent, 90 power, 10% for a special def drop] ", " [A bright light hits the opponent, an 80 power fairy move] ", "[An icy beam hits the oponent, 90 power, 20% chance of freeze] "};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv4 = scan.nextLine();

			while (legitmove4(possiblemoves, abbreviated, mv4, move1, move2, move3) != true) { // sends arrays and the mv4 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid)  \n");
				mv4 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv4.equals(abbreviated[o])) {

					mv4 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("jirachi")) {


			String[] possiblemoves = {"thunderwave", "ironhead", "firepunch", "icepunch", "thunderbolt", "psychic", "dazzlinggleam", "calmmind"}; // array of possible moves for this pokemon
			String[] abbreviated = {"tw", "ih", "fp", "ip", "tb", "ps", "dg", "cm"};// array of the abbreviated moves
			String[] explain = {" [paralyzes the opponent, Can help in para-flinching]", "[user bashes opponent with a steel head, 80 power move, 30% chance to flinch]", "[The opponent is hit with a fiery punch, 75 power 20% chance to burn]", "[the user hits the opponent with an icy punch, 75 power 20% chance to freeze] ", " [The opponent is hit with a lightningbolt 90 power 20% chance to paralyze]", "[ A psychic wave is shot at the opponent, 90 power, 10% for a special def drop] ", " [A bright light hits the opponent, an 80 power fairy move] ", "[The user focuses and increases its special attack and special defense] "};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv4 = scan.nextLine();

			while (legitmove4(possiblemoves, abbreviated, mv4, move1, move2, move3) != true) { // sends arrays and the mv4 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid)  \n");
				mv4 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv4.equals(abbreviated[o])) {

					mv4 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("melmetal")) {

			String[] possiblemoves = {"thunderpunch", "thunderwave", "doubleironbash", "superpower", "icepunch", "earthquake", "rockslide"}; // array of possible moves for this pokemon
			String[] abbreviated = {"tp", "tw", "db", "sp", "ip", "e", "rs"};// array of the abbreviated moves
			String[] explain = {"[The opponent is hit with an electriv punch, 75 power, 10% chance to paralyze]", " [paralyzes the opponent, Can help in para-flinching]", "[user bashes opponent with big boi arms , 120 power move]", "[The opponent is hit with secret fighting power, 120 power, reduces attack and defense]", "[the user hits the opponent with an icy punch, 75 power 20% chance to freeze] ", " [The opponent is hit with an earthquake]", "[ The user slams rocks on the opponent, 75 power, 30% chance to flinch, 95 accuracy] "};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv4 = scan.nextLine();

			while (legitmove4(possiblemoves, abbreviated, mv4, move1, move2, move3) != true) { // sends arrays and the mv4 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid)  \n");
				mv4 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv4.equals(abbreviated[o])) {

					mv4 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("kingdra")) {


			String[] possiblemoves = {"waterfall", "dragondance", "hydropump", "dragonpulse", "flashcannon", "bodyslam", "yawn", "focusenergy"}; // array of possible moves for this pokemon
			String[] abbreviated = {"wf","dd", "hp", "dp", "fc", "bs", "y", "fe"};// array of the abbreviated moves
			String[] explain = {"[An 80 base power physical water move]", "[boosts attack and speed]", "[user hits the target with a 110 power water type move]", "[An 80 power dragon move]", "[The opponent is hit with a steel beam, 90 power, has a chance of reducing spdef]", "[the user hits the opponent with its body, 80 power 30% chance to paralyse the opponent] ", " [The user makes the opponent tired and sleep after one turn]", "[ Increases the chances of crits] "};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv4 = scan.nextLine();

			while (legitmove4(possiblemoves, abbreviated, mv4, move1, move2, move3) != true) { // sends arrays and the mv4 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid)  \n");
				mv4 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv4.equals(abbreviated[o])) {

					mv4 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("machamp")) {


			String[] possiblemoves = {"bulkup", "dynamicpunch", "crosschop", "bulletpunch", "firepunch", "icepunch", "thunderpunch", "focusenergy"}; // array of possible moves for this pokemon
			String[] abbreviated = {"bu", "dp", "cc", "bp", "fp", "ip", "tp", "fe"};// array of the abbreviated moves
			String[] explain = {"[raises attack and defense]", " [Machamp bashes its opponent with a 100 power move that confuses the opponent]", "[user hits the target with a 100 power fighting type high crit rate move]", "[An 40 power steel priority move]", "[The opponent is hit with a fiery punch, 75 power, 10% chance to burn]", "[the user hits an icy punch, 75 power, 10% chance to freeze] ", " [The user uses an electric punch to hit the opponent, 75 power; 10% chance to paralyze]", "[ Increases the chances of crits] "};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv4 = scan.nextLine();

			while (legitmove4(possiblemoves, abbreviated, mv4, move1, move2, move3) != true) { // sends arrays and the mv4 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid)  \n");
				mv4 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv4.equals(abbreviated[o])) {

					mv4 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("milotic")) {


			String[] possiblemoves = {"hydropump", "aquaring", "toxic", "confuseray", "icebeam", "recover", "hiddenpower"}; // array of possible moves for this pokemon
			String[] abbreviated = {"hy", "aq", "tx", "cr", "ib", "re", "hp"};// array of the abbreviated moves
			String[] explain = {" [the user attacks with a 110 water power move]", "[user starts regaining hp every turn]", "[Poisons the opponent and makes them take more damage over time]", "[ Confuses the opponent]", "[the user hits an icy beam, 90 power, 10% chance to freeze] ", " [User regains half of its max hp]", "[ A 60 power move that can be any type the user desires] "};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv4 = scan.nextLine();

			while (legitmove4(possiblemoves, abbreviated, mv4, move1, move2, move3) != true) { // sends arrays and the mv4 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid)  \n");
				mv4 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv4.equals(abbreviated[o])) {

					mv4 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("chandelure")) {


			String[] possiblemoves = {"energyball", "flamethrower", "calmmind", "confuseray", "shadowball", "willowisp", "psychic"}; // array of possible moves for this pokemon
			String[] abbreviated = {"eb", "ft", "cm", "cr", "sb", "ww", "ps"};// array of the abbreviated moves
			String[] explain = {" [the user attacks with a 90 grass power move with a 10 percent chance to reduce spdef]", "[user shoots fire at the opponent, 90 power 10% chance to burn]", "[User increases its spa and Spdef stats]", "[ Confuses the opponent]", "[the user hits a ball of shadow, 80 power, 30% chance to drop spdef of opponent] ", " [Burns the opponent 90 percent of the time]", "[ A 90 power psychic move that hits for 90 power and has a 10% for a spdef drop] "};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv4 = scan.nextLine();

			while (legitmove4(possiblemoves, abbreviated, mv4, move1, move2, move3) != true) { // sends arrays and the mv4 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid)  \n");
				mv4 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv4.equals(abbreviated[o])) {

					mv4 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("dragonite")) {

			String[] possiblemoves = {"extremespeed", "dragondance", "thunderwave", "dragonclaw", "dracometeor", "firepunch", "icepunch", "thunderpunch", "superpower"}; // array of possible moves for this pokemon
			String[] abbreviated = {"es", "dd", "tw", "dc", "dm", "fp", "ip", "tp", "sp"};// array of the abbreviated moves
			String[] explain = {"[an 80 base power normal move that hits fast and hard]", "[boosts attack and speed]", " [paralyzes opponent]", "[user hits the target with 80 power dragon power]", "[An 120 power dragon move that reduces special attack of the user ]", "[The opponent is hit with a fiery punch, 75 power, 10% chance to burn]", "[the user hits an icy punch, 75 power, 10% chance to freeze] ", " [The user uses an electric punch to hit the opponent, 75 power; 10% chance to paralyze]", "[ user attacks with 120 power of fighting power, reduces attack and defense of the user] "};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv4 = scan.nextLine();

			while (legitmove4(possiblemoves, abbreviated, mv4, move1, move2, move3) != true) { // sends arrays and the mv4 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid)  \n");
				mv4 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv4.equals(abbreviated[o])) {

					mv4 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("salamence")) {

			String[] possiblemoves = {"dragondance", "earthquake", "dragonclaw", "dracometeor", "rockslide", "flamethrower", "airslash", "focusenergy"}; // array of possible moves for this pokemon
			String[] abbreviated = {"dd", "eq", "dc", "dm", "rs", "ft", "as", "fe"};// array of the abbreviated moves
			String[] explain = {"[boosts attack and speed]", " [A 100 power ground move]", "[user hits the target with 80 power dragon power]", "[An 120 power dragon move that reduces special attack of the user ]", "[The opponent is hit with a lot of rocks, 75 power, 30% chance to flinch]", "[the user hits the opponent with flames 90 power, 10% chance to burn] ", " [ The user slashes air at the opponent, 30% chance to flinch]", "[ increases the user's chances of a crit] "};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv4 = scan.nextLine();

			while (legitmove4(possiblemoves, abbreviated, mv4, move1, move2, move3) != true) { // sends arrays and the mv4 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid)  \n");
				mv4 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv4.equals(abbreviated[o])) {

					mv4 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("greninja")) {
			String[] possiblemoves = {"watershuriken", "extrasensory", "hydropump", "surf", "icebeam", "gunkshot", "darkpulse", "hiddenpower"}; // array of possible moves for this pokemon
			String[] abbreviated = {"ws", "ex", "hpu", "su", "ib", "gs", "dp", "hp"};// array of the abbreviated moves
			String[] explain = {"[The pokemon yeets some shurikens at the opponent, usually goes first]",
					" [80 base power psychic move with 100 accuracy, can sometimes flinch] ",
					" [A 110 power water move that has 80 accuracy] ",
					"[A 95 power water move with 100 accuracy]  ",
					" [An icy beam is shot at the opponent, ice type 90 base power, 10% chance to freeze] ",
					" [A poison blast is shot at the opponent, has a 30% chance to poison the opponent]  ",
					" [A dark aura is projected at the opponent, has a 20% chance to flinch] ",
					" [A mysterious blast is shot at the opponent, the user chooses its type]"};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv4 = scan.nextLine();

			while (legitmove4(possiblemoves, abbreviated, mv4, move1, move2, move3) != true) { // sends arrays and the mv4 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid)  \n");
				mv4 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv4.equals(abbreviated[o])) {

					mv4 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("zeraora")) {
			String[] possiblemoves = {"bulkup", "thunderwave", "toxic", "closecombat", "plasmafists", "drainpunch", "firepunch", "playrough"}; // array of possible moves for this pokemon
			String[] abbreviated = {"bu", "tw", "tx", "cc", "pf", "dp", "fp", "pr"};// array of the abbreviated moves
			String[] explain = {" [increases attack and defense]",
					"[paralyzes opponent] ",
					" [poisons opponent, opponent takes damage every turn, they're screwed if they can't win quickly] ",
					" [A 120 base power fighting move that reduces spdef and def] ",
					"[A mega-powerful electric punch, based 100 power] ",
					"[a punch of toxicity, 75 base power; the user gains some health back]  ",
					"[A punch of fiery wrath;75 base power; 10 percent chance to burn]  ",
					"[A 90 base power fairy move, has a chance to reduce the opponent's attack]"};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv4 = scan.nextLine();

			while (legitmove4(possiblemoves, abbreviated, mv4, move1, move2, move3) != true) { // sends arrays and the mv4 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid)  \n");
				mv4 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv4.equals(abbreviated[o])) {

					mv4 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("togekiss")) {

			String[] possiblemoves = {"dazzlinggleam", "roost", "aurasphere", "flamethrower", "nastyplot",
					"thunderwave", "shadowball", "airslash", "psychic", "extremespeed"}; // array of possible moves for this pokemon
			String[] abbreviated = {"dg", "roo", "asp", "ft", "np", "tw", "sb", "as", "ps", "es"};// array of the abbreviated moves
			String[] explain = {"[An 80 base power fairy move]",
					"[Heals user but the user loses their flying type for a turn]",
					"[the user attacks with an 80 power fighting move that never misses]",
					"[user shoots fire at the opponent, 90 power 10% chance to burn]",
					"[User sharply increases its special attack]",
					"[paralyzes the opponent, 90 accuracy]",
					"[the user hits a ball of shadow, 80 power, 30% chance to drop spdef of opponent] ",
					"[The opponent gets slashed with some crisp clean air, 30% flinch rate]",
					"[ A 90 power psychic move that hits for 90 power and has a 10% for a spdef drop] ",
					"[The fastest move in the game, always moves first, 80 base power, it is speed, gotta go fast]"};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv4 = scan.nextLine();

			while (legitmove4(possiblemoves, abbreviated, mv4, move1, move2, move3) != true) { // sends arrays and the mv4 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid)  \n");
				mv4 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv4.equals(abbreviated[o])) {

					mv4 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("volcarona")) {

			String[] possiblemoves = {"hiddenpower", "flamethrower", "calmmind", "quiverdance", "bugbuzz", "wildcharge", "psychic"}; // array of possible moves for this pokemon
			String[] abbreviated = {"hp", "ft", "cm", "qd", "bb", "wc", "ps"};// array of the abbreviated moves
			String[] explain = {" [the user attacks with a 60 base power special attack of any type]",
					"[user shoots fire at the opponent, 90 power 10% chance to burn]",
					"[User increases its spa and Spdef stats]",
					"[ calm mind on steroids: also boosts speed, is super overpowered]",
					"[the user screeches reeeeeeeee, 90 power, 10% chance to drop spdef of opponent] ",
					"[hits the opponent with a 90 power physical electric type attack, hurts user as well]",
					"[A 90 power psychic move that hits for 90 power and has a 10% for a spdef drop] "};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv4 = scan.nextLine();

			while (legitmove4(possiblemoves, abbreviated, mv4, move1, move2, move3) != true) { // sends arrays and the mv4 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid)  \n");
				mv4 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv4.equals(abbreviated[o])) {

					mv4 = possiblemoves[o];
				}


			}

		} else if (pokemonname.equals("pikachu")) {
			String[] possiblemoves = {"honeclaws", "thunderbolt", "volttackle", "hiddenpower", "toxic", "extremespeed", "quickattack", "thunderwave", "surf", "horndrill"}; // array of possible moves for this pokemon
			String[] abbreviated = {"hc", "tb", "vt", "hp", "tx", "es", "qa", "tw", "su", "hd"};// array of the abbreviated moves
			String[] explain = {"[Raises accuracy of attacks and increases their power] (I gave it to pikachu cause I felt like it)", " [A 90 base power electric attack with a 10 % chance of paralysis]",
					" [a 120 base power electric tackle attack, causes recoil but it goes hard]  ",
					" [A 60 base power move that can be any type the user desires]  ",
					" [this move poisons the opponent and the poison damage increases over time(poison types can't miss)] ",
					" [ha ha fast pikachu goes brrr (an 80 base power move that ussually hits first)]  ",
					" [A weaker extremespeed (just use extremespeed)] ",
					" [Has a 90 percent chance to paralyze opponent] ",
					" [A 90 base power watermove, yup I let pikachu learn this with lightball boosting its stats, it needs all the help it can get]",
					" [A move with a 30% chance to one-shot the opponent, pikachu shouldn't be able to learn this but I just want to see the power of friendship lol."};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv4 = scan.nextLine();

			while (legitmove4(possiblemoves, abbreviated, mv4, move1, move2, move3) != true) { // sends arrays and the mv4 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid)  \n");
				mv4 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv4.equals(abbreviated[o])) {

					mv4 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("mimikyu")) {
			String[] possiblemoves = {"swordsdance", "thunderwave", "toxic", "bulkup", "leechlife", "drainpunch", "shadowclaw", "playrough", "shadowsneak"}; // array of possible moves for this pokemon
			String[] abbreviated = {"sd", "tw", "tx", "bu", "ll", "dp", "sc", "pr", "ss"};// array of the abbreviated moves
			String[] explain = {" [sharply increases attack]",
					"[paralyzes opponent] ",
					"[poisons opponent, opponent takes damage every turn, they're screwed if they can't win quickly] ",
					"[raises attack and defense] ",
					"[An 80 power bug move that drains the opponent's hp and heals you] ",
					"[a punch of toxicity, 75 base power; the user gains some health back]  ",
					"[A slash of sinister intent, 75 power, high crit rate]  ",
					"[A 90 base power fairy move, has a chance to reduce the opponent's attack]",
					"[You hit the opponent with a 40 base power ghostly sneak attack like they owe you money]"};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv4 = scan.nextLine();

			while (legitmove4(possiblemoves, abbreviated, mv4, move1, move2, move3) != true) { // sends arrays and the mv4 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid)  \n");
				mv4 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv4.equals(abbreviated[o])) {

					mv4 = possiblemoves[o];
				}


			}
		} else if (pokemonname.equals("noivern")) {
			String[] possiblemoves = {"boomburst", "dragonpulse", "moonlight", "flamethrower", "toxic", "darkpulse", "dracometeor", "psychic", "superfang"}; // array of possible moves for this pokemon
			String[] abbreviated = {"bb", "dp", "ml", "ft", "tx", "dpu", "dm", "ps", "sf"};// array of the abbreviated moves
			String[] explain = {" [a 150 power normal move, loud noise go brrrr] ",
					"[An 80 power base dragon move]  ",
					" [the user heals some of their health back] ",
					" [A 95 base power fire move with a 10% chance to burn] ",
					" [poisons the opponent with a toxin] ",
					" [An 80 base power dark move with a chance to flinch(20 %)] ",
					" [A 120 base power special dragon move, reduces the user's special attack] ",
					" [Mind melt, 90 power psychic move, can reduce special defense]",
					" [Halves the opponent's hp, slicey dicey]"};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv4 = scan.nextLine();

			while (legitmove4(possiblemoves, abbreviated, mv4, move1, move2, move3) != true) { // sends arrays and the mv4 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid)  \n");
				mv4 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv4.equals(abbreviated[o])) {

					mv4 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("hawlucha")) {

			String[] possiblemoves = {"bravebird", "ironhead", "rockslide", "honeclaws", "brickbreak", "swordsdance", "poisonjab", "roost"}; // array of possible moves for this pokemon
			String[] abbreviated = {"bbi", "ih", "rs", "hc", "bb", "sd", "pj", "roo"};// array of the abbreviated moves
			String[] explain = {" [a 120 base power flying move, hurts the user too tho]", "[an 80 power steel move with a 30% chance to flinch ]", "[a lot of rocks are slammed on the opponent , 30% chance to flinch ] ", " [Boosts the user's attack and accuracy]", "[ a 75 base power fighting move] ", " [sharply raises the user's attack] ", "[the user jabs the opponent with poison, 30 % chance to poison] ", "[Heals the user but they lose their flying type for a turn]"};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv4 = scan.nextLine();

			while (legitmove4(possiblemoves, abbreviated, mv4, move1, move2, move3) != true) { // sends arrays and the mv4 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid)  \n");
				mv4 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv4.equals(abbreviated[o])) {

					mv4 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("zoroark")) {

			String[] possiblemoves = {"honeclaws", "brickbreak", "nastyplot", "nightslash", "darkpulse", "shadowball", "sludgebomb", "suckerpunch", "focusblast", "flamethrower",}; // array of possible moves for this pokemon
			String[] abbreviated = {"hc", "bb", "np", "ns", "dpu", "sba", "sb", "sp", "fb", "ft"};// array of the abbreviated moves
			String[] explain = {"[A move that raises physical attack and accuracy]",
					"[A 75 base power fighting move]",
					"[This move sharply raises special attack]",
					"[a base 75 power dark slashing move, someone's getting sniped]",
					" [a dark aura is shot at the opponent, a chance to flinch is present]",
					" [an 80 power ghost move , 30 % chance for opposing spdef reduction] ",
					"[an 85 base power poison move with a 30% chance to poison]  ",
					" [An 80 base power move that only works if the opponent uses an attack]",
					" [A 120 base power fighting move with 70 accuracy] ",
					" [ Your opponent gets hit with fire, a 90 power fire move with 100 accuracy]"};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv4 = scan.nextLine();

			while (legitmove4(possiblemoves, abbreviated, mv4, move1, move2, move3) != true) { // sends arrays and the mv4 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid)  \n");
				mv4 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv4.equals(abbreviated[o])) {

					mv4 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("garchomp")) {

			String[] possiblemoves = {"firefang", "flamethrower", "dragonclaw", "rockslide", "brickbreak",
					"earthquake", "crunch", "swordsdance", "ironhead", "poisonjab", "dracometeor"}; // array of possible moves for this pokemon
			String[] abbreviated = {"ff", "ft", "dc", "rs", "bb",
					"ea", "cr", "sd", "ih", "pj", "dm"};// array of the abbreviated moves
			String[] explain = {"[a 65 power physical fire move (95 accuracy) 10 percent chance to burn or flinch]",
					"  [a 90 power special fire move (100 accuracy) 10 percent chance to burn] ",
					" [an 80 base power dragon type move] ",
					" [a lot of rocks are slammed on the opponent , 30% chance to flinch ] ",
					" [ a 75 base power fighting move] ",
					" [a 100 base ground move] ",
					" [an 80 power dark move that crunches opponent, 20 percent chance for defense drop] ",
					" [Boosts attack, makes a pokemon go from good to overpowered in one turn]",
					" [An 80 base power steel move wrecks fairies and ice pokemon]",
					" [An 85 base power toxic jab that can poison the opponent]",
					" [Asteroids fall from the sky and obliterate all in their path, 120 base power, harshly reduces special attack]"
			};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv4 = scan.nextLine();

			while (legitmove4(possiblemoves, abbreviated, mv4, move1, move2, move3) != true) { // sends arrays and the mv4 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid)  \n");
				mv4 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv4.equals(abbreviated[o])) {

					mv4 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("tyranitar")) {

			String[] possiblemoves = {"icepunch", "flamethrower", "surf", "rockslide",
					"brickbreak", "earthquake", "crunch", "dragondance", "darkpulse", "thunderbolt"}; // array of possible moves for this pokemon
			String[] abbreviated = {"ip", "ft", "su", "rs",
					"bb", "ea", "cr", "dd", "dp", "tb"};// array of the abbreviated moves
			String[] explain = {
					"[a 75 base power ice move, dragons hate it lol]",
					"  [a 90 power special fire move (100 accuracy) 10 percent chance to burn] ",
					" [a 90 base power water move] ",
					" [a lot of rocks are slammed on the opponent , 30% chance to flinch ] ",
					" [ a 75 base power fighting move] ",
					" [a 100 base ground move] ",
					" [an 80 power dark move that crunches opponent, 20 percent chance for defense drop] ",
					" [Boosts attack, makes a pokemon go from good to overpowered in one turn, raises attack and speed]",
					" [An 80 base power dark move wrecks psychic and ghost pokemon]",
					" [An 90 base power electric shock that can paralyze the opponent]"
			};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv4 = scan.nextLine();

			while (legitmove4(possiblemoves, abbreviated, mv4, move1, move2, move3) != true) { // sends arrays and the mv4 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid)  \n");
				mv4 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv4.equals(abbreviated[o])) {

					mv4 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("lucario")) {

			String[] possiblemoves = {"calmmind", "dragonpulse", "aurasphere", "closecombat", "swordsdance",
					"bulletpunch", "shadowball", "meteormash", "psychic", "extremespeed", "flashcannon"}; // array of possible moves for this pokemon
			String[] abbreviated = {"cm", "dpu", "asp", "cc", "sd", "bp", "sb", "mm", "ps", "es", "fc"};// array of the abbreviated moves
			String[] explain = {"[boosts special attack and special defense]",
					"[User expels their inner dragon, 80 base power special attack]",
					"[the user attacks with an 80 power fighting move that never misses]",
					"[user hits the opponent up close, the opponent gets jumped, the user's defenses lower however]",
					"[User sharply increases its physical attack]",
					"[a punch as fast as my internet, 40 base power steel move]",
					"[the user hits a ball of shadow, 80 power, 30% chance to drop spdef of opponent] ",
					"[The opponent gets mashed with some crisp clean steel, may raise attack but also may miss]",
					"[ A psychic move that hits for 90 power and has a 10% for a spdef drop] ",
					"[The fastest move in the game, always moves first, 80 base power, it is speed, gotta go fast]",
					"[A steel beam is shot at the opponent, 90 base power, can reduce spdef]"};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv4 = scan.nextLine();

			while (legitmove4(possiblemoves, abbreviated, mv4, move1, move2, move3) != true) { // sends arrays and the mv4 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid)  \n");
				mv4 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv4.equals(abbreviated[o])) {

					mv4 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("flygon")) {

			String[] possiblemoves = {"dragondance", "earthquake", "dragonclaw", "dracometeor",
					"rockslide", "flamethrower", "boomburst", "crunch", "bugbuzz"}; // array of possible moves for this pokemon
			String[] abbreviated = {"dd", "eq", "dc", "dm",
					"rs", "ft", "bb", "cr", "bu"};// array of the abbreviated moves
			String[] explain = {"[boosts attack and speed]", " [A 100 power ground move]", "[user hits the target with 80 power dragon power]", "[An 120 power dragon move that reduces special attack of the user ]"
					, "[The opponent is hit with a lot of rocks, 75 power, 30% chance to flinch]", "[the user hits the opponent with flames 90 power, 10% chance to burn] ", " [ The user screeches reeeeeee, a 150 base power normal move]", "[ An 80 base power dark move that can reduce defense] ", "[The user screeches reeee in bug language, a 90 power bug type attack]"};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv4 = scan.nextLine();

			while (legitmove4(possiblemoves, abbreviated, mv4, move1, move2, move3) != true) { // sends arrays and the mv4 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid)  \n");
				mv4 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv4.equals(abbreviated[o])) {

					mv4 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("dragapult")) {

			String[] possiblemoves = {"dragondance", "willowisp", "dragonclaw", "dracometeor",
					"bodyslam", "thunderbolt", "confuseray", "suckerpunch", "shadowball", "surf"}; // array of possible moves for this pokemon
			String[] abbreviated = {"dd", "ww", "dc", "dm",
					"bs", "tb", "cr", "sp", "sb", "su"};// array of the abbreviated moves
			String[] explain = {"[boosts attack and speed]", " [burns the opponent]",
					"[user hits the target with 80 power dragon power]", "[An 120 power dragon move that reduces special attack of the user ]"
					, "[The opponent is slammed with a lot of force, 80 power, 30% chance to paralyze]",
					"[the user hits the opponent with electricity 90 power, 10% chance to paralyze] ",
					"[user confuses the opponent]"
					, "[The user sneak attacks the opponent before the opponent can attack]",
					" [ The user throws a ball of shadow energy, 80 base power]",
					"[ A 90 base power water move]"};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv4 = scan.nextLine();

			while (legitmove4(possiblemoves, abbreviated, mv4, move1, move2, move3) != true) { // sends arrays and the mv4 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid)  \n");
				mv4 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv4.equals(abbreviated[o])) {

					mv4 = possiblemoves[o];
				}


			}


		} else if (pokemonname.equals("goodra")) {
			String[] possiblemoves = {"sludgebomb", "focusblast", "hydropump", "dragonpulse", "flashcannon", "flamethrower", "surf", "darkpulse", "dracometeor"}; // array of possible moves for this pokemon
			String[] abbreviated = {"sb", "fb", "hp", "dp", "fc", "ft", "su", "dpu", "dm"};// array of the abbreviated moves
			String[] explain = {"[An 80 base power poison move, 30% chance to poison]", "[A 120 base power fighting special attack, 70 accuracy]", "[A hard hitting 110 base power water move with 80 accuracy] ", "[An 80 power base dragon move]  ", " [A 90 base power steel move] ", " [A 95 base power fire move with a 10% chance to burn] ", " [A 95 base power water move] ", " [An 80 base power dark move with a chance to flinch(20 %)] ", " [A 120 base power special dragon move, reduces the user's special attack] "};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv4 = scan.nextLine();

			while (legitmove4(possiblemoves, abbreviated, mv4, move1, move2, move3) != true) { // sends arrays and the mv4 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid)  \n");
				mv4 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv4.equals(abbreviated[o])) {

					mv4 = possiblemoves[o];
				}


			}

		}
		else if (pokemonname.equals("charizard")) {

			String[] possiblemoves = {"dragonpulse", "dragondance", "earthquake", "dragonclaw", "flareblitz", "rockslide", "flamethrower", "airslash", "thunderpunch"}; // array of possible moves for this pokemon
			String[] abbreviated = {"dp", "dd", "eq", "dc", "fb", "rs", "ft", "as", "tp"};// array of the abbreviated moves
			String[] explain = {"[user unleashes their inner dragon, 85 base power]", "[boosts attack and speed]", " [A 100 power ground move]", "[user hits the target with base 80 physical dragon power]", "[An 120 power fire move that reduces the hp of the user as well]", "[The opponent is hit with a lot of rocks, 75 power, 30% chance to flinch]", "[the user hits the opponent with flames 90 power, 10% chance to burn] ", " [ The user slashes air at the opponent, 30% chance to flinch]", "[ the user hits with electric power] "};

			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv4 = scan.nextLine();

			while (legitmove4(possiblemoves, abbreviated, mv4, move1, move2, move3) != true) { // sends arrays and the mv4 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid)  \n");
				mv4 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv4.equals(abbreviated[o])) {

					mv4 = possiblemoves[o];
				}


			}

		}
		else if (pokemonname.equals("golisopod")) {

			String[] possiblemoves = {"swordsdance", "bulkup", "suckerpunch", "aquajet", "closecombat",
					"leechlife", "poisonjab", "rockslide", "aerialace"}; // array of possible moves for this pokemon
			String[] abbreviated = {"sd", "bu", "sp", "aj", "cc", "ll", "pj","rs",  "aa"};// array of the abbreviated moves
			String[] explain = {" [sharply raises the user's attack]",
					"[raises attack and defense ]",
					"[user sneaks the opponent like college sneaked my bank account, base 80 power, only works if the opponent is about to attack] "
					, " [User hits with a jet stream of water, base 40 power]", "[ A 120 base power fighting move that reduces the defenses of the user] ",
					" [a base 75 power bug move that can heal the user] ", "[the user jabs the opponent with poison, 30 % chance to poison] ",
					"[User hits the foe with rocks, rocks may miss but may also flinch]",
					"[user slashes with an aerial technique that always hits]"};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv4 = scan.nextLine();

			while (legitmove4(possiblemoves, abbreviated, mv4, move1, move2, move3) != true) { // sends arrays and the mv4 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid)  \n");
				mv4 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv4.equals(abbreviated[o])) {

					mv4 = possiblemoves[o];
				}


			}


		}
		else if (pokemonname.equals("roserade")) {

			String[] possiblemoves = {"toxic", "extrasensory", "shadowball", "sludgebomb", "energyball", "dazzlinggleam", "hiddenpower",}; // array of possible moves for this pokemon
			String[] abbreviated = {"tx", "ex", "sb", "sb", "eb", "dg", "hp"};// array of the abbreviated moves
			String[] explain = {"[this move poisons the opponent and the poison damage increases over time(poison types can't miss)]",
					" [opponent is hit with a base 80 psychic power]",
					" [an 80 power ghost move , 30 % chance for opposing spdef reduction] ",
					"[an 85 base power poison move with a 30% chance to poison]  ",
					" [An 90 base power grass move that hits hard]", " [A 80 base power fairy move with 100 accuracy] ",
					" [A move that can be of any type the user desires, base 60 power]"};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv4 = scan.nextLine();

			while (legitmove4(possiblemoves, abbreviated, mv4, move1, move2, move3) != true) { // sends arrays and the mv4 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid)  \n");
				mv4 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv4.equals(abbreviated[o])) {

					mv4 = possiblemoves[o];
				}


			}




		}
		else if (pokemonname.equals("sceptile")) {
			String[] possiblemoves = {"quickattack", "swordsdance", "leafblade", "energyball", "return", "xscissor", "hiddenpower", "aerialace"}; // array of possible moves for this pokemon
			String[] abbreviated = {"qa","sd", "lb", "eb", "re", "xs", "hp", "aa"};// array of the abbreviated moves
			String[] explain = {"[Hits fast and usually hits first]", "[Sharply raises attack]",
					" [A grass attack with a higher chance of crits, 70 base power] ",
					" [This is a 90 base power move that hits hard] ",
					"[a 102 base power normal physical attack]  ",
					"[80 base power bug move]  ",
					" [A special attack that can be any type the user desires(60 base power) ] ",
					" [60 base power flying move that never misses] "};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv4 = scan.nextLine();

			while (legitmove4(possiblemoves, abbreviated, mv4, move1, move2, move3) != true) { // sends arrays and the mv4 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid)  \n");
				mv4 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv4.equals(abbreviated[o])) {

					mv4 = possiblemoves[o];
				}


			}


		}
		else if (pokemonname.equals("mewtwo")) {
			String[] possiblemoves = {"calmmind", "thunderbolt", "psychic", "shadowball", "flamethrower", "icebeam", "aurasphere", "recover", "toxic"}; // array of possible moves for this pokemon
			String[] abbreviated = {"cm", "tb", "ps", "sb", "ft", "ib", "as", "re", "tx"};// array of the abbreviated moves
			String[] explain = {"[raises special attack and special defense]", "[The user zaps the opponent with electricity," +
					" 90 base power move, 10 % chance to paralyze]",
					" [90 base power psychic move with 100 accuracy] ",
					" [A 80 power ghost move that has 100 accuracy] ",
					"[A 95 power fire move with 100 accuracy]  ",
					" [An icy beam is shot at the opponent, ice type 90 base power, 10% chance to freeze] ",
					" [A 80 base power fighting special attack no one can dodge ]  ",
					" [The user heals itself by 1/2 of its max hp] ", "[poisons opponent, RIP the other player lol]"};



			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv4 = scan.nextLine();

			while (legitmove4(possiblemoves, abbreviated, mv4, move1, move2, move3) != true) { // sends arrays and the mv4 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid)  \n");
				mv4 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv4.equals(abbreviated[o])) {

					mv4 = possiblemoves[o];
				}


			}



		}
		else if (pokemonname.equals("talonflame")) {


			String[] possiblemoves = {"bravebird", "flareblitz", "quickattack",
					"return", "gigaimpact", "swordsdance", "steelwing", "roost"}; // array of possible moves for this pokemon
			String[] abbreviated = {"bb", "fb", "qa",
					"re", "gi", "sd", "sw", "ro"};// array of the abbreviated moves
			String[] explain = {" [A 120 base power flying move, user takes 1/3 recoil]",
					"[an 120 base power fire move, user takes 1/3 recoil ]",
					"[user hits fast with a 40 base power normal move]",
					"[the opponent is hit with a 102 base power normal move  ] ",
					"[User hits the opponent with a 150 base power normal move but has to recharge]",
					"[sharply raises attack] ",
					"[sharp steel wings are slashed at the opponent, 70 power 90 accuracy] ",
					"[the user roosts and regains hp, user loses flying temporarily] "};



			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv4 = scan.nextLine();

			while (legitmove4(possiblemoves, abbreviated, mv4, move1, move2, move3) != true) { // sends arrays and the mv4 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid)  \n");
				mv4 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv4.equals(abbreviated[o])) {

					mv4 = possiblemoves[o];
				}


			}



		}
		else if (pokemonname.equals("snorlax")) {

			String[] possiblemoves = {"return", "crunch", "earthquake",
					"zenheadbut", "firepunch", "icepunch",
					"thunderpunch", "hyperbeam"}; // array of possible moves for this pokemon
			String[] abbreviated = {"re", "cr", "eq",
					"zh", "fp", "ip",
					"tp", "hb"};// array of the abbreviated moves
			String[] explain = {"[a 102 base power normal move]", " [snorlax attacks with 80 base power darkness]", "[user hits the target with a 100 power ground high crit rate move]",
					"[an 85 base power psychic  move, can miss but can also flinch]", "[The opponent is hit with a fiery punch, 75 power, 10% chance to burn]", "[the user hits an icy punch, 75 power, 10% chance to freeze] ",
					" [The user uses an electric punch to hit the opponent, 75 power; 10% chance to paralyze]", "[ a 150 base power move (special attack) , forces one to recharge] "};



			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv4 = scan.nextLine();

			while (legitmove4(possiblemoves, abbreviated, mv4, move1, move2, move3) != true) { // sends arrays and the mv4 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid)  \n");
				mv4 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv4.equals(abbreviated[o])) {

					mv4 = possiblemoves[o];
				}


			}


		}
		else if (pokemonname.equals("infernape")) {

			String[] possiblemoves = {"closecombat", "flareblitz", "swordsdance",
					"stoneedge", "flamethrower", "focusblast",
					"thunderpunch", "earthquake",
					"nastyplot","hiddenpower"}; // array of possible moves for this pokemon
			String[] abbreviated = {"cc", "fb", "sd",
					"se", "ft", "fb",
					"tb", "eq" ,
					"np","hp"};// array of the abbreviated moves
			String[] explain = {"[A 120 power fighting move, reduces the user's defense and special defense]", "[A 120 base power physical fire move but the user takes 1/3 of the damage as recoil] ", " [sharply boosts attack] ",
					" [a base 100 power rock move, can crit but also can miss] ", " [a 90 base power fire move that can burn the opponent] ", " [a 120 base power fighting blast that can reduce the opponent's special defense] ",
					" [A 75 base power electric move, may paralyze opponent] ", " [A 100 base power ground move]",
					"[sharply boosts special attack]","[aa 60 base power move that can be any type the user desires]"};


			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv4 = scan.nextLine();

			while (legitmove4(possiblemoves, abbreviated, mv4, move1, move2, move3) != true) { // sends arrays and the mv4 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid)  \n");
				mv4 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv4.equals(abbreviated[o])) {

					mv4 = possiblemoves[o];
				}


			}

		}
		else if (pokemonname.equals("weavile")) {
			String[] possiblemoves = {"icepunch", "nightslash",
					"brickbreak",
					"iceshard", "slash",
					"poisonjab", "swordsdance"}; // array of possible moves for this pokemon
			String[] abbreviated = {"ip", "ns",
					"bb",
					"is", "s",
					"pj", "sd"};// array of the abbreviated moves
			String[] explain = {" [The user hits the opponent with an icy 75 base power punch ,10% chance to freeze] ", "[A 75 base power dark move, high crit rate] ",
					"[ A 75 base power fighting move ]  ",
					"[A fast ice type physical attack, 40 base power]  ", "[A 75 base power normal move, high crit rate]  ",
					"[A 85 base power ice move with a 30% chance to poison ] ", "[sharply raises attack]  "};




			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv4 = scan.nextLine();

			while (legitmove4(possiblemoves, abbreviated, mv4, move1, move2, move3) != true) { // sends arrays and the mv4 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid)  \n");
				mv4 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv4.equals(abbreviated[o])) {

					mv4 = possiblemoves[o];
				}


			}


		}
		else if (pokemonname.equals("groudon")) {

			String[] possiblemoves = {"bulkup", "dragonclaw", "earthquake",
					"focusblast", "rockslide",
					"flamethrower", "brickbreak",
					"swordsdance", "poisonjab", "thunderbolt"}; // array of possible moves for this pokemon
			String[] abbreviated = {"bu", "dc", "ea",
					"fb", "rs",
					"ft", "bb",
					"sd", "pj", "tb"};// array of the abbreviated moves
			String[] explain = {"[raises attack and defense]", "[An 80 base power dragon move]", " [a 100 base power physical ground move]",
					"[an 120 power fighting move with a chance to reduce spdef ]", "[a lot of rocks are slammed on the opponent , 30% chance to flinch ] ",
					" [user expels flames that can burn the opponent, 90 base power]", "[ a 75 base power fighting move] ",
					" [sharply raises the user's attack] ", "[the user jabs the opponent with poison, 30 % chance to poison] ", "[User hits with a 95 base power electric move, with a chance to paralyze]"};



			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv4 = scan.nextLine();

			while (legitmove4(possiblemoves, abbreviated, mv4, move1, move2, move3) != true) { // sends arrays and the mv4 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid)  \n");
				mv4 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv4.equals(abbreviated[o])) {

					mv4 = possiblemoves[o];
				}


			}



		}
		else if (pokemonname.equals("kyogre")) {

			String[] possiblemoves = {"calmmind", "hyperbeam", "surf",
					"hydropump", "icebeam",
					"blizzard", "brickbreak",
					"aquaring", "thunderwave", "thunderbolt"}; // array of possible moves for this pokemon
			String[] abbreviated = {"cm", "hb", "su",
					"hp", "ib",
					"bli", "bri",
					"aq", "tw", "tb"};// array of the abbreviated moves
			String[] explain = {"[raises special attack and special defense]", "[An 150 base power normal move that requires a recharge turn]", " [a 95 base power special water move]",
					"[an 120 power water move with 80 accuracy]", "[an icy beam with a chance to freeze is launched at the opponent ] ",
					" [a 120 base power ice move with 70 accuracy]", "[ a 75 base power fighting move] ",
					" [a veil of water is used to let the user gain a little hp every turn] ", "[the user paralyzes the opponent] ", "[User hits with a 95 base power electric move, with a chance to paralyze]"};






			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv4 = scan.nextLine();

			while (legitmove4(possiblemoves, abbreviated, mv4, move1, move2, move3) != true) { // sends arrays and the mv4 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid)  \n");
				mv4 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv4.equals(abbreviated[o])) {

					mv4 = possiblemoves[o];
				}


			}



		}
		else if (pokemonname.equals("rayquaza")) {

			String[] possiblemoves = {"dragondance", "earthquake",
					"dragonclaw", "dracometeor",
					"rockslide", "flamethrower",
					"airslash", "hyperbeam"}; // array of possible moves for this pokemon
			String[] abbreviated = {"dd", "eq",
					"dc", "dm",
					"rs", "ft",
					"as", "hb"};// array of the abbreviated moves
			String[] explain = {"[boosts attack and speed]", " [A 100 power ground move]",
					"[user hits the target with 80 power dragon power]", "[An 120 power dragon move that reduces special attack of the user ]",
					"[The opponent is hit with a lot of rocks, 75 power, 30% chance to flinch]", "[the user hits the opponent with flames 90 power, 10% chance to burn] ",
					" [ The user slashes air at the opponent, 30% chance to flinch]", "[A beam is shot at the opponent, 150 base power, requres a recharge turn] "};




			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv4 = scan.nextLine();

			while (legitmove4(possiblemoves, abbreviated, mv4, move1, move2, move3) != true) { // sends arrays and the mv4 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid)  \n");
				mv4 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv4.equals(abbreviated[o])) {

					mv4 = possiblemoves[o];
				}


			}




		}
		else if (pokemonname.equals("giratina-altered")) {

			String[] possiblemoves = {"calmmind", "willowisp",
					"dragonclaw", "dracometeor",
					"aurasphere",
					"darkpulse",
					"energyball",
					"earthquake",
					"shadowball",
					"shadowsneak"}; // array of possible moves for this pokemon
			String[] abbreviated = {"cm", "ww",
					"dc", "dm",
					"as",
					"dp",
					"eb",
					"eq",
					"sb",
					"ss"};// array of the abbreviated moves
			String[] explain = {"[boosts special attack and special defense]", " [burns the opponent]",
					"[user hits the target with 80 power dragon power]", "[An 120 power dragon move that reduces special attack of the user ]"
					, "[The opponent is slammed with an 80 power fighting move that never misses]",
					"[the user hits the opponent with a dark type 80 power with a chance to flinch] ",
					"[the user hits the opponent with a grass type 90 power with a chance to reduce spdef]"
					, "[A 100 base power ground move]",
					" [The user throws a ball of shadow energy, 80 base power]",
					"[User sneaks the opponent, 40 base ghost power]"};





			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv4 = scan.nextLine();

			while (legitmove4(possiblemoves, abbreviated, mv4, move1, move2, move3) != true) { // sends arrays and the mv4 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid)  \n");
				mv4 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv4.equals(abbreviated[o])) {

					mv4 = possiblemoves[o];
				}


			}






		}
		else if (pokemonname.equals("giratina-origin")) {

			String[] possiblemoves = {"calmmind", "willowisp",
					"dragonclaw", "dracometeor",
					"aurasphere",
					"darkpulse",
					"energyball",
					"earthquake",
					"shadowball",
					"shadowsneak"}; // array of possible moves for this pokemon
			String[] abbreviated = {"cm", "ww",
					"dc", "dm",
					"as",
					"dp",
					"eb",
					"eq",
					"sb",
					"ss"};// array of the abbreviated moves
			String[] explain = {"[boosts special attack and special defense]", " [burns the opponent]",
					"[user hits the target with 80 power dragon power]", "[An 120 power dragon move that reduces special attack of the user ]"
					, "[The opponent is slammed with an 80 power fighting move that never misses]",
					"[the user hits the opponent with a dark type 80 power with a chance to flinch] ",
					"[the user hits the opponent with a grass type 90 power with a chance to reduce spdef]"
					, "[A 100 base power ground move]",
					" [The user throws a ball of shadow energy, 80 base power]",
					"[User sneaks the opponent, 40 base ghost power]"};







			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv4 = scan.nextLine();

			while (legitmove4(possiblemoves, abbreviated, mv4, move1, move2, move3) != true) { // sends arrays and the mv4 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid)  \n");
				mv4 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv4.equals(abbreviated[o])) {

					mv4 = possiblemoves[o];
				}


			}





		}


		else if (pokemonname.equals("gardevoir")) {
			String[] possiblemoves = {"psychic", "shadowball", "thunderbolt",
					"calmmind", "dazzlinggleam", "hiddenpower", "energyball"}; // array of possible moves for this pokemon
			String[] abbreviated = {"ps", "sb", "tb",
					"cm", "dg", "hp", "eb"};// array of the abbreviated moves
			String[] explain = {" [A 90 base power psychic move with a 10% chance of a reduction in opponent's spdef] ", " [an 80 base power ghost move with a 30% chance to reduce opponent spdef] ", " [a 90 base power electric move that can paralyze the opponent] ",
					"[raises special attack and special defense] ", "[An 80 base power fairy move]  ", "[A 60 base power move that can be any type the user desires] ", " [A 90 base power grass move that can reduce spdef ]"};



			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv4 = scan.nextLine();

			while (legitmove4(possiblemoves, abbreviated, mv4, move1, move2, move3) != true) { // sends arrays and the mv4 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid)  \n");
				mv4 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv4.equals(abbreviated[o])) {

					mv4 = possiblemoves[o];
				}


			}





		}
		else if (pokemonname.equals("gallade")) {
			String[] possiblemoves = {"bulkup", "nightslash", "psychic", "closecombat",
					"swordsdance", "poisonjab", "rockslide", "earthquake"}; // array of possible moves for this pokemon
			String[] abbreviated = {"bu", "ns", "ps", "cc",
					"sd", "pj", "rs", "eq"};// array of the abbreviated moves
			String[] explain = {" [increases attack and defense]",
					"[A 75 base power dark move with a high crit rate] ",
					" [A 90 base power psychic move with a 10 % to reduce spdef] ",
					" [A 120 base power fighting move that reduces spdef and def] ",
					"[sharply boosts attack] ",
					"[a punch of toxicity , 85 base power; 30 percent chance to poison]  ",
					"[A lot of rocks launched at the opponent, there is a chance to flinch as well]  ",
					"[A 100 base power ground move]"};




			for (int i = 0; i < abbreviated.length; i++) {

				System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

			}

			System.out.println("\n Input a move or its abbreviation \n");
			mv4 = scan.nextLine();

			while (legitmove4(possiblemoves, abbreviated, mv4, move1, move2, move3) != true) { // sends arrays and the mv4 and the previous move input variable to the boolean tester function to see if the move is legit

				for (int i = 0; i < abbreviated.length; i++) {

					System.out.println("* " + possiblemoves[i] + "  " + abbreviated[i] + "  " + explain[i]);

				}

				System.out.println("\n Input a legitimate move or its abbreviation (Your previous input was invalid)  \n");
				mv4 = scan.nextLine();


			}


			for (int o = 0; o < abbreviated.length; o++) {

				if (mv4.equals(abbreviated[o])) {

					mv4 = possiblemoves[o];
				}


			}



		}




		return mv4;

	}


	//pokemon's first type

	public String gettype1(String pokemonname) {

		String type1 = "null";

		if (pokemonname.equals("metagross")) {
			type1 = "steel";

		} else if (pokemonname.equals("gliscor")) {
			type1 = "ground";

		} else if (pokemonname.equals("excadrill")) {
			type1 = "ground";

		} else if (pokemonname.equals("arcanine")) {
			type1 = "fire";

		} else if (pokemonname.equals("krookodile")) {
			type1 = "ground";

		} else if (pokemonname.equals("feraligatr")) {
			type1 = "water";

		} else if (pokemonname.equals("gyarados")) {
			type1 = "water";

		} else if (pokemonname.equals("starmie")) {
			type1 = "water";

		} else if (pokemonname.equals("gengar")) {
			type1 = "ghost";

		} else if (pokemonname.equals("espeon")) {
			type1 = "psychic";

		} else if (pokemonname.equals("jolteon")) {
			type1 = "electric";

		} else if (pokemonname.equals("glaceon")) {
			type1 = "ice";

		} else if (pokemonname.equals("sylveon")) {
			type1 = "fairy";

		} else if (pokemonname.equals("umbreon")) {
			type1 = "dark";

		} else if (pokemonname.equals("leafeon")) {
			type1 = "grass";

		} else if (pokemonname.equals("vaporeon")) {
			type1 = "water";

		} else if (pokemonname.equals("flareon")) {
			type1 = "fire";

		} else if (pokemonname.equals("scizor")) {
			type1 = "bug";

		} else if (pokemonname.equals("hydreigon")) {
			type1 = "dragon";

		} else if (pokemonname.equals("meloetta")) {
			type1 = "normal";

		} else if (pokemonname.equals("archeops")) {
			type1 = "flying";

		} else if (pokemonname.equals("crobat")) {
			type1 = "flying";

		} else if (pokemonname.equals("jirachi")) {
			type1 = "steel";

		} else if (pokemonname.equals("manaphy")) {
			type1 = "water";

		} else if (pokemonname.equals("melmetal")) {
			type1 = "steel";

		} else if (pokemonname.equals("milotic")) {
			type1 = "water";

		} else if (pokemonname.equals("kingdra")) {
			type1 = "water";

		} else if (pokemonname.equals("machamp")) {
			type1 = "fighting";

		} else if (pokemonname.equals("chandelure")) {
			type1 = "fire";

		} else if (pokemonname.equals("dragonite")) {
			type1 = "flying";

		} else if (pokemonname.equals("salamence")) {
			type1 = "flying";

		} else if (pokemonname.equals("greninja")) {
			type1 = "water";

		} else if (pokemonname.equals("zeraora")) {
			type1 = "electric";

		} else if (pokemonname.equals("togekiss")) {
			type1 = "fairy";

		} else if (pokemonname.equals("volcarona")) {
			type1 = "bug";

		} else if (pokemonname.equals("pikachu")) {
			type1 = "electric";

		} else if (pokemonname.equals("mimikyu")) {
			type1 = "ghost";

		} else if (pokemonname.equals("noivern")) {
			type1 = "flying";

		} else if (pokemonname.equals("hawlucha")) {
			type1 = "fighting";

		} else if (pokemonname.equals("zoroark")) {
			type1 = "dark";

		} else if (pokemonname.equals("garchomp")) {
			type1 = "dragon";

		} else if (pokemonname.equals("tyranitar")) {
			type1 = "rock";

		} else if (pokemonname.equals("lucario")) {
			type1 = "fighting";

		} else if (pokemonname.equals("flygon")) {
			type1 = "dragon";

		} else if (pokemonname.equals("dragapult")) {
			type1 = "dragon";

		} else if (pokemonname.equals("goodra")) {
			type1 = "dragon";

		} else if (pokemonname.equals("charizard")) {
			type1 = "fire";

		}
		else if (pokemonname.equals("golisopod")) {
			type1 = "bug";

		}
		else if (pokemonname.equals("roserade")) {
			type1 = "grass";

		}
		else if (pokemonname.equals("sceptile")) {
			type1 = "grass";

		}
		else if (pokemonname.equals("mewtwo")) {
			type1 = "psychic";

		}
		else if (pokemonname.equals("talonflame")) {
			type1 = "flying";

		}
		else if (pokemonname.equals("snorlax")) {
			type1 = "normal";

		}
		else if (pokemonname.equals("infernape")) {
			type1 = "fire";

		}
		else if (pokemonname.equals("weavile")) {
			type1 = "dark";

		}
		else if (pokemonname.equals("groudon")) {
			type1 = "ground";

		}
		else if (pokemonname.equals("kyogre")) {
			type1 = "water";

		}
		else if (pokemonname.equals("rayquaza")) {
			type1 = "dragon";

		}
		else if (pokemonname.equals("giratina-altered")) {
			type1 = "dragon";

		}
		else if (pokemonname.equals("giratina-origin")) {
			type1 = "dragon";

		}
		else if (pokemonname.equals("gardevoir")) {
			type1 = "psychic";

		}
		else if (pokemonname.equals("gallade")) {
			type1 = "psychic";

		}

		return type1;
	}


	// gets a pokemon second type

	public String gettype2(String pokemonname) {


		String type2 = "null";

		if (pokemonname.equals("metagross")) {
			type2 = "psychic";

		} else if (pokemonname.equals("gliscor")) {
			type2 = "flying";

		} else if (pokemonname.equals("excadrill")) {
			type2 = "steel";

		} else if (pokemonname.equals("arcanine")) {
			type2 = "null";

		} else if (pokemonname.equals("krookodile")) {
			type2 = "dark";

		} else if (pokemonname.equals("feraligatr")) {
			type2 = "null";

		} else if (pokemonname.equals("gyarados")) {
			type2 = "flying";

		} else if (pokemonname.equals("starmie")) {
			type2 = "psychic";

		} else if (pokemonname.equals("gengar")) {
			type2 = "poison";

		} else if (pokemonname.equals("espeon")) {
			type2 = "null";

		} else if (pokemonname.equals("jolteon")) {
			type2 = "null";

		} else if (pokemonname.equals("glaceon")) {
			type2 = "null";

		} else if (pokemonname.equals("sylveon")) {
			type2 = "null";

		} else if (pokemonname.equals("umbreon")) {
			type2 = "null";

		} else if (pokemonname.equals("leafeon")) {
			type2 = "null";

		} else if (pokemonname.equals("vaporeon")) {
			type2 = "null";

		} else if (pokemonname.equals("flareon")) {
			type2 = "null";

		} else if (pokemonname.equals("scizor")) {
			type2 = "steel";

		} else if (pokemonname.equals("hydreigon")) {
			type2 = "dark";

		} else if (pokemonname.equals("meloetta")) {
			type2 = "psychic";

		} else if (pokemonname.equals("archeops")) {
			type2 = "rock";

		} else if (pokemonname.equals("crobat")) {
			type2 = "poison";

		} else if (pokemonname.equals("jirachi")) {
			type2 = "psychic";

		} else if (pokemonname.equals("manaphy")) {
			type2 = "null";

		} else if (pokemonname.equals("melmetal")) {
			type2 = "null";

		} else if (pokemonname.equals("milotic")) {
			type2 = "null";

		} else if (pokemonname.equals("kingdra")) {
			type2 = "dragon";

		} else if (pokemonname.equals("machamp")) {
			type2 = "null";

		} else if (pokemonname.equals("chandelure")) {
			type2 = "ghost";

		} else if (pokemonname.equals("dragonite")) {
			type2 = "dragon";

		} else if (pokemonname.equals("salamence")) {
			type2 = "dragon";

		} else if (pokemonname.equals("greninja")) {
			type2 = "dark";

		} else if (pokemonname.equals("zeraora")) {
			type2 = "null";

		} else if (pokemonname.equals("togekiss")) {
			type2 = "flying";

		} else if (pokemonname.equals("volcarona")) {
			type2 = "fire";

		} else if (pokemonname.equals("pikachu")) {
			type2 = "null";

		} else if (pokemonname.equals("mimikyu")) {
			type2 = "fairy";

		} else if (pokemonname.equals("noivern")) {
			type2 = "dragon";

		} else if (pokemonname.equals("hawlucha")) {
			type2 = "flying";

		} else if (pokemonname.equals("zoroark")) {
			type2 = "null";

		} else if (pokemonname.equals("garchomp")) {
			type2 = "ground";

		} else if (pokemonname.equals("tyranitar")) {
			type2 = "dark";

		} else if (pokemonname.equals("lucario")) {
			type2 = "steel";

		} else if (pokemonname.equals("flygon")) {
			type2 = "ground";

		} else if (pokemonname.equals("dragapult")) {
			type2 = "ghost";

		} else if (pokemonname.equals("goodra")) {
			type2 = "null";

		} else if (pokemonname.equals("charizard")) {
			type2 = "flying";

		}
		else if (pokemonname.equals("golisopod")) {
			type2 = "water";

		}
		else if (pokemonname.equals("roserade")) {
			type2 = "poison";

		}
		else if (pokemonname.equals("sceptile")) {
			type2 = "null";

		}
		else if (pokemonname.equals("mewtwo")) {
			type2 = "null";

		}
		else if (pokemonname.equals("talonflame")) {
			type2 = "fire";

		}
		else if (pokemonname.equals("snorlax")) {
			type2 = "null";

		}
		else if (pokemonname.equals("infernape")) {
			type2 = "fighting";

		}
		else if (pokemonname.equals("weavile")) {
			type2 = "ice";

		}
		else if (pokemonname.equals("groudon")) {
			type2 = "null";

		}
		else if (pokemonname.equals("kyogre")) {
			type2 = "null";

		}
		else if (pokemonname.equals("rayquaza")) {
			type2 = "flying";

		}
		else if (pokemonname.equals("giratina-altered")) {
			type2 = "ghost";

		}
		else if (pokemonname.equals("giratina-origin")) {
			type2 = "ghost";

		}
		else if (pokemonname.equals("gardevoir")) {
			type2 = "fairy";

		}
		else if (pokemonname.equals("gallade")) {
			type2 = "fighting";

		}

		return type2;


	}
	//pokemon's ability

	public String getability(String pokemonname) {
		String ability = "null";

		if (pokemonname.equals("metagross")) {
			ability = "clearbody";

		} else if (pokemonname.equals("gliscor")) {
			ability = "hypercutter";

		} else if (pokemonname.equals("excadrill")) {
			ability = "moldbreaker";

		} else if (pokemonname.equals("arcanine")) {
			ability = "intimidate";

		} else if (pokemonname.equals("krookodile")) {
			ability = "intimidate";

		} else if (pokemonname.equals("feraligatr")) {
			ability = "sheerforce";

		} else if (pokemonname.equals("gyarados")) {
			ability = "intimidate";

		} else if (pokemonname.equals("starmie")) {
			ability = "magicbounce";

		} else if (pokemonname.equals("gengar")) {
			ability = "levitate";

		} else if (pokemonname.equals("espeon")) {
			ability = "magicbounce";

		} else if (pokemonname.equals("jolteon")) {
			ability = "quickfeet";

		} else if (pokemonname.equals("glaceon")) {
			ability = "magicbounce";

		} else if (pokemonname.equals("sylveon")) {
			ability = "pixilate";

		} else if (pokemonname.equals("umbreon")) {
			ability = "magicbounce";

		} else if (pokemonname.equals("leafeon")) {
			ability = "stamina";

		} else if (pokemonname.equals("vaporeon")) {
			ability = "waterabsorb";

		} else if (pokemonname.equals("flareon")) {
			ability = "guts";

		} else if (pokemonname.equals("scizor")) {
			ability = "technician";

		} else if (pokemonname.equals("hydreigon")) {
			ability = "levitate";

		} else if (pokemonname.equals("meloetta")) {
			ability = "serenegrace";

		} else if (pokemonname.equals("archeops")) {
			ability = "solidrock";

		} else if (pokemonname.equals("crobat")) {
			ability = "innerfocus";

		} else if (pokemonname.equals("jirachi")) {
			ability = "serenegrace";

		} else if (pokemonname.equals("manaphy")) {
			ability = "serenegrace";

		} else if (pokemonname.equals("melmetal")) {
			ability = "ironfist";

		} else if (pokemonname.equals("milotic")) {
			ability = "marvelscale";

		} else if (pokemonname.equals("kingdra")) {
			ability = "sniper";

		} else if (pokemonname.equals("machamp")) {
			ability = "noguard";

		} else if (pokemonname.equals("chandelure")) {
			ability = "flamebody";

		} else if (pokemonname.equals("dragonite")) {
			ability = "multiscale";

		} else if (pokemonname.equals("salamence")) {
			ability = "intimidate";

		} else if (pokemonname.equals("greninja")) {
			ability = "protean";

		} else if (pokemonname.equals("zeraora")) {
			ability = "toughclaws";

		} else if (pokemonname.equals("togekiss")) {
			ability = "serenegrace";

		} else if (pokemonname.equals("volcarona")) {
			ability = "flamebody";

		} else if (pokemonname.equals("pikachu")) {
			ability = "static";

		} else if (pokemonname.equals("mimikyu")) {
			ability = "disguise";

		} else if (pokemonname.equals("noivern")) {
			ability = "multiscale";

		} else if (pokemonname.equals("hawlucha")) {
			ability = "moldbreaker";

		} else if (pokemonname.equals("zoroark")) {
			ability = "disguise";

		} else if (pokemonname.equals("garchomp")) {
			ability = "roughskin";

		} else if (pokemonname.equals("tyranitar")) {
			ability = "solidrock";

		} else if (pokemonname.equals("lucario")) {
			ability = "innerfocus";

		} else if (pokemonname.equals("flygon")) {
			ability = "levitate";

		} else if (pokemonname.equals("dragapult")) {
			ability = "clearbody";

		} else if (pokemonname.equals("goodra")) {
			ability = "gooey";

		}
		else if (pokemonname.equals("charizard")) {
			ability = "toughclaws";

		}
		else if (pokemonname.equals("golisopod")) {
			ability = "toughclaws";

		}
		else if (pokemonname.equals("roserade")) {
			ability = "poisonpoint";

		}
		else if (pokemonname.equals("sceptile")) {
			ability = "protean";

		}
		else if (pokemonname.equals("mewtwo")) {
			ability = "multiscale";

		}
		else if (pokemonname.equals("talonflame")) {
			ability = "flamebody";

		}
		else if (pokemonname.equals("snorlax")) {
			ability = "roughskin";

		}
		else if (pokemonname.equals("infernape")) {
			ability = "toughclaws";

		}
		else if (pokemonname.equals("weavile")) {
			ability = "toughclaws";

		}
		else if (pokemonname.equals("groudon")) {
			ability = "toughclaws";

		}
		else if (pokemonname.equals("kyogre")) {
			ability = "multiscale";

		}
		else if (pokemonname.equals("rayquaza")) {
			ability = "multiscale";

		}
		else if (pokemonname.equals("giratina-altered")) {
			ability = "levitate";

		}
		else if (pokemonname.equals("giratina-origin")) {
			ability = "levitate";

		}
		else if (pokemonname.equals("gardevoir")) {
			ability = "magicbounce";

		}
		else if (pokemonname.equals("gallade")) {
			ability = "toughclaws";

		}

		return ability;

	}


	// this gets a pokemon's ability explanation
	public String getabilityexplain(String pokemonname) {
		String explain = "This ability,";

		if (pokemonname.equals("metagross")) {
			abilityexplain = "clearbody stops your stats from being reduced. Intimidate doesn't affect you. ";

		} else if (pokemonname.equals("gliscor")) {
			abilityexplain = "hypercutter stops your attack from being lowered. Intimidate doesn't affect you.";

		} else if (pokemonname.equals("excadrill")) {
			abilityexplain = "mold breaker makes sure that a pokemon's abilities don't stop your moves from hitting";

		} else if (pokemonname.equals("arcanine")) {
			abilityexplain = "intimidate lowers the opponent's attack";

		} else if (pokemonname.equals("krookodile")) {
			abilityexplain = "intimidate lowers the opponent's attack";

		} else if (pokemonname.equals("feraligatr")) {
			abilityexplain = "sheerforce powers up moves that have a chance for an affect to happen ";

		} else if (pokemonname.equals("gyarados")) {
			abilityexplain = "intimidate lowers the opponent's attack";

		} else if (pokemonname.equals("starmie")) {
			abilityexplain = "magicbounce basically sends status moves back to the user; you uno-reverse the opponent";

		} else if (pokemonname.equals("gengar")) {
			abilityexplain = "levitate makes you immune to ground moves";

		} else if (pokemonname.equals("espeon")) {
			abilityexplain = "magicbounce basically sends status moves back to the user; you uno-reverse the opponent";

		} else if (pokemonname.equals("jolteon")) {
			abilityexplain = "magicbounce basically sends status moves back to the user; you uno-reverse the opponent";

		} else if (pokemonname.equals("glaceon")) {
			abilityexplain = "magicbounce  basically sends status moves back to the user; you uno-reverse the opponent";

		} else if (pokemonname.equals("sylveon")) {
			abilityexplain = "pixilate makes all normal moves fairy type ";

		} else if (pokemonname.equals("umbreon")) {
			abilityexplain = " magic bounce basically sends status moves back to the user; you uno-reverse the opponent";

		} else if (pokemonname.equals("leafeon")) {
			abilityexplain = "stamina increases defense after every physicall attack you take ";

		} else if (pokemonname.equals("vaporeon")) {
			abilityexplain = "waterabsorb makes you immune to water moves";

		} else if (pokemonname.equals("flareon")) {
			abilityexplain = "guts makes you more powerful when you have a status condition";

		} else if (pokemonname.equals("scizor")) {
			abilityexplain = "technician gives a 30% boost to moves that are under 60 power";

		} else if (pokemonname.equals("hydreigon")) {
			abilityexplain = "levitate makes you immune to ground moves";

		} else if (pokemonname.equals("meloetta")) {
			abilityexplain = "serenegrace doubles chances for an effect to happen";

		} else if (pokemonname.equals("archeops")) {
			abilityexplain = "solidrock decreases damage from a super effective attack by 1/4";

		} else if (pokemonname.equals("crobat")) {
			abilityexplain = "inner focus makes your pokemon unflinchable";

		} else if (pokemonname.equals("jirachi")) {
			abilityexplain = "serenegrace doubles chances for an effect to happen";

		} else if (pokemonname.equals("manaphy")) {
			abilityexplain = "serenegrace doubles chances for an effect to happen";

		} else if (pokemonname.equals("melmetal")) {
			abilityexplain = "ironfist powers up punching moves";

		} else if (pokemonname.equals("milotic")) {
			abilityexplain = "if this pokemon has a status condition then its defense increases";

		} else if (pokemonname.equals("kingdra")) {
			abilityexplain = "sniper powers up moves that critically hit";

		} else if (pokemonname.equals("machamp")) {
			abilityexplain = "noguard makes all moves hit no matter what";

		} else if (pokemonname.equals("chandelure")) {
			abilityexplain = "flamebody has a chance of burning opponents on contact";

		} else if (pokemonname.equals("dragonite")) {
			abilityexplain = "multiscale boosts defense and special defense at full hp";

		} else if (pokemonname.equals("salamence")) {
			abilityexplain = "intimidate reduces the opponent's attack";

		} else if (pokemonname.equals("greninja")) {
			abilityexplain = "protean changes a pokemon''s type to match the attack it is about to use. The pokemon gets a slight boost to these attacks due to the same type attack bonus. ";

		} else if (pokemonname.equals("zeraora")) {
			abilityexplain = "tough claws powers up physical attacks by 30%";

		} else if (pokemonname.equals("togekiss")) {
			abilityexplain = "serenegrace doubles chances for an effect to happen";

		} else if (pokemonname.equals("pikachu")) {
			abilityexplain = "static has a chance of paralyzing opponents on contact";

		} else if (pokemonname.equals("volcarona")) {
			abilityexplain = "flamebody has a chance of burning opponents on contact";

		} else if (pokemonname.equals("mimikyu")) {
			abilityexplain = "disguise lets mimikyu avoid one attack before taking damage";

		} else if (pokemonname.equals("noivern")) {
			abilityexplain = "multiscale boosts defense and special defense at full hp";

		} else if (pokemonname.equals("hawlucha")) {
			abilityexplain = "mold breaker makes sure that a pokemon's abilities don't stop your moves from hitting";

		} else if (pokemonname.equals("zoroark")) {
			abilityexplain = "disguise lets zoroark avoid one attack before taking damage";

		} else if (pokemonname.equals("garchomp")) {
			abilityexplain = "roughskin makes it so that if someone touches your pokemon with the rough skin ability then they'll get hurt as well";

		} else if (pokemonname.equals("tyranitar")) {
			abilityexplain = "solidrock decreases damage from a super effective attack by 1/4";

		} else if (pokemonname.equals("lucario")) {
			abilityexplain = "inner focus makes your pokemon unflinchable";

		} else if (pokemonname.equals("flygon")) {
			abilityexplain = "levitate makes you immune to ground moves";

		}
		else if (pokemonname.equals("dragapult")) {
			abilityexplain = "clearbody stops your stats from being reduced. Intimidate doesn't affect you. ";

		}
		else if (pokemonname.equals("goodra")) {
			abilityexplain = "gooey reduces the speed of any pokemon that touches you. ";

		}
		else if (pokemonname.equals("charizard")) {
			abilityexplain = "tough claws powers up physical attacks by 30%";

		}
		else if (pokemonname.equals("golisopod")) {
			abilityexplain = "tough claws powers up physical attacks by 30%";

		}
		else if (pokemonname.equals("roserade")) {
			abilityexplain = "poisonpoint has a chance of poisoning opponents on contact";

		}else if (pokemonname.equals("sceptile")) {
			abilityexplain = "protean changes a pokemon''s type to match the attack it is about to use. The pokemon gets a slight boost to these attacks due to the same type attack bonus. ";

		}
		else if (pokemonname.equals("mewtwo")) {
			abilityexplain = "multiscale boosts defense and special defense at full hp";

		}
		else if (pokemonname.equals("talonflame")) {
			abilityexplain = "flamebody has a chance of burning opponents on contact";

		}
		else if (pokemonname.equals("snorlax")) {
			abilityexplain = "roughskin makes it so that if someone touches your pokemon with the rough skin ability then they'll get hurt as well";

		}
		else if (pokemonname.equals("infernape")) {
			abilityexplain = "tough claws powers up physical attacks by 30%";

		}
		else if (pokemonname.equals("weavile")) {
			abilityexplain = "tough claws powers up physical attacks by 30%";

		}

		else if (pokemonname.equals("kyogre")) {
			abilityexplain = "multiscale boosts defense and special defense at full hp";

		}
		else if (pokemonname.equals("rayquaza")) {
			abilityexplain = "multiscale boosts defense and special defense at full hp";

		}
		else if (pokemonname.equals("giratina-altered")) {
			abilityexplain = "levitate makes you immune to ground moves";

		}
		else if (pokemonname.equals("giratina-origin")) {
			abilityexplain = "levitate makes you immune to ground moves";

		}
		else if (pokemonname.equals("gardevoir")) {
			abilityexplain = "magicbounce basically sends status moves back to the user; you uno-reverse the opponent";

		}
		else if (pokemonname.equals("gallade")) {
			abilityexplain = "tough claws powers up physical attacks by 30%";

		}

		explain = explain + " " + abilityexplain;


		return explain;
	}


	// The following functions get the pokemon's stats
	// gets a pokemon's attack
	public int getattack(String pokemonname) {  //gets pokemon attack

		int attack = 0;

		if (pokemonname.equals("metagross")) {
			attack = 405;

		} else if (pokemonname.equals("gliscor")) {
			attack = 317;

		} else if (pokemonname.equals("excadrill")) {
			attack = 405;

		} else if (pokemonname.equals("arcanine")) {
			attack = 350;

		} else if (pokemonname.equals("krookodile")) {
			attack = 366;

		} else if (pokemonname.equals("feraligatr")) {
			attack = 339;

		} else if (pokemonname.equals("gyarados")) {
			attack = 383;

		} else if (pokemonname.equals("starmie")) {
			attack = 273;

		} else if (pokemonname.equals("gengar")) {
			attack = 251;

		} else if (pokemonname.equals("espeon")) {
			attack = 251;

		} else if (pokemonname.equals("jolteon")) {
			attack = 251;

		} else if (pokemonname.equals("glaceon")) {
			attack = 240;

		} else if (pokemonname.equals("sylveon")) {
			attack = 251;

		} else if (pokemonname.equals("umbreon")) {
			attack = 251;

		} else if (pokemonname.equals("leafeon")) {
			attack = 350;

		} else if (pokemonname.equals("vaporeon")) {
			attack = 251;

		} else if (pokemonname.equals("flareon")) {
			attack = 394;

		} else if (pokemonname.equals("scizor")) {
			attack = 394;

		} else if (pokemonname.equals("hydreigon")) {
			attack = 339;

		} else if (pokemonname.equals("meloetta")) {
			attack = 278;

		} else if (pokemonname.equals("archeops")) {
			attack = 416;

		} else if (pokemonname.equals("crobat")) {
			attack = 306;

		} else if (pokemonname.equals("jirachi")) {
			attack = 328;

		} else if (pokemonname.equals("manaphy")) {
			attack = 328;

		} else if (pokemonname.equals("melmetal")) {
			attack = 423;

		} else if (pokemonname.equals("kingdra")) {
			attack = 317;

		} else if (pokemonname.equals("machamp")) {
			attack = 394;

		} else if (pokemonname.equals("milotic")) {
			attack = 240;

		} else if (pokemonname.equals("salamence")) {
			attack = 405;

		} else if (pokemonname.equals("dragonite")) {
			attack = 403;

		} else if (pokemonname.equals("chandelure")) {
			attack = 229;

		} else if (pokemonname.equals("greninja")) {
			attack = 317;

		} else if (pokemonname.equals("zeraora")) {
			attack = 355;

		} else if (pokemonname.equals("togekiss")) {
			attack = 218;

		} else if (pokemonname.equals("volcarona")) {
			attack = 240;

		} else if (pokemonname.equals("pikachu")) {
			attack = (229 * 2);

		} else if (pokemonname.equals("mimikyu")) {
			attack = 306;

		} else if (pokemonname.equals("noivern")) {
			attack = 262;

		} else if (pokemonname.equals("hawlucha")) {
			attack = 311;

		} else if (pokemonname.equals("zoroark")) {
			attack = 339;

		} else if (pokemonname.equals("garchomp")) {
			attack = 394;

		} else if (pokemonname.equals("tyranitar")) {
			attack = 403;

		} else if (pokemonname.equals("lucario")) {
			attack = 350;

		} else if (pokemonname.equals("flygon")) {
			attack = 328;

		} else if (pokemonname.equals("dragapult")) {
			attack = 372;

		} else if (pokemonname.equals("goodra")) {
			attack = 328;

		}
		else if (pokemonname.equals("charizard")) {
			attack = 293;

		}
		else if (pokemonname.equals("golisopod")) {
			attack = 383;

		}
		else if (pokemonname.equals("roserade")) {
			attack = 262;

		}
		else if (pokemonname.equals("sceptile")) {
			attack = 295;

		}
		else if (pokemonname.equals("mewtwo")) {
			attack = 350;

		}
		else if (pokemonname.equals("talonflame")) {
			attack = 287;

		}
		else if (pokemonname.equals("snorlax")) {
			attack = 350;

		}
		else if (pokemonname.equals("infernape")) {
			attack = 337;

		}
		else if (pokemonname.equals("weavile")) {
			attack = 372;

		}
		else if (pokemonname.equals("groudon")) {
			attack = 438;

		}
		else if (pokemonname.equals("kyogre")) {
			attack = 328;

		}
		else if (pokemonname.equals("rayquaza")) {
			attack = 438;

		}
		else if (pokemonname.equals("giratina-altered")) {
			attack = 328;

		}
		else if (pokemonname.equals("giratina-origin")) {
			attack = 372;

		}
		else if (pokemonname.equals("gardevoir")) {
			attack = 251;

		}
		else if (pokemonname.equals("gallade")) {
			attack = 383;

		}

		return attack;

	}


	// gets a pokemon's hp
	public double gethp(String pokemonname) { // get pokemon hp


		double hp = 0;
		if (pokemonname.equals("metagross")) {
			hp = 364;

		} else if (pokemonname.equals("gliscor")) {
			hp = 354;

		} else if (pokemonname.equals("excadrill")) {
			hp = 424;

		} else if (pokemonname.equals("arcanine")) {
			hp = 384;

		} else if (pokemonname.equals("krookodile")) {
			hp = 394;

		} else if (pokemonname.equals("feraligatr")) {
			hp = 374;

		} else if (pokemonname.equals("gyarados")) {
			hp = 394;

		} else if (pokemonname.equals("starmie")) {
			hp = 324;

		} else if (pokemonname.equals("gengar")) {
			hp = 324;

		} else if (pokemonname.equals("espeon")) {
			hp = 334;

		} else if (pokemonname.equals("jolteon")) {
			hp = 334;

		} else if (pokemonname.equals("glaceon")) {
			hp = 334;

		} else if (pokemonname.equals("sylveon")) {
			hp = 394;

		} else if (pokemonname.equals("umbreon")) {
			hp = 394;

		} else if (pokemonname.equals("leafeon")) {
			hp = 334;

		} else if (pokemonname.equals("vaporeon")) {
			hp = 464;

		} else if (pokemonname.equals("flareon")) {
			hp = 334;

		} else if (pokemonname.equals("scizor")) {
			hp = 344;

		} else if (pokemonname.equals("hydreigon")) {
			hp = 388;

		} else if (pokemonname.equals("meloetta")) {
			hp = 404;

		} else if (pokemonname.equals("archeops")) {
			hp = 354;

		} else if (pokemonname.equals("crobat")) {
			hp = 374;

		} else if (pokemonname.equals("jirachi")) {
			hp = 404;

		} else if (pokemonname.equals("manaphy")) {
			hp = 404;

		} else if (pokemonname.equals("melmetal")) {
			hp = 474;

		} else if (pokemonname.equals("kingdra")) {
			hp = 354;

		} else if (pokemonname.equals("machamp")) {
			hp = 384;

		} else if (pokemonname.equals("milotic")) {
			hp = 394;

		} else if (pokemonname.equals("salamence")) {
			hp = 394;

		} else if (pokemonname.equals("dragonite")) {
			hp = 386;

		} else if (pokemonname.equals("chandelure")) {
			hp = 324;

		} else if (pokemonname.equals("greninja")) {
			hp = 348;

		} else if (pokemonname.equals("zeraora")) {
			hp = 380;

		} else if (pokemonname.equals("togekiss")) {
			hp = 374;

		} else if (pokemonname.equals("volcarona")) {
			hp = 374;

		} else if (pokemonname.equals("pikachu")) {
			hp = 274;

		} else if (pokemonname.equals("mimikyu")) {
			hp = 314;

		} else if (pokemonname.equals("noivern")) {
			hp = 374;

		} else if (pokemonname.equals("hawlucha")) {
			hp = 360;

		} else if (pokemonname.equals("zoroark")) {
			hp = 324;

		} else if (pokemonname.equals("garchomp")) {
			hp = 420;

		} else if (pokemonname.equals("tyranitar")) {
			hp = 404;

		} else if (pokemonname.equals("lucario")) {
			hp = 344;

		} else if (pokemonname.equals("flygon")) {
			hp = 364;

		} else if (pokemonname.equals("dragapult")) {
			hp = 380;

		} else if (pokemonname.equals("goodra")) {
			hp = 384;

		}
		else if (pokemonname.equals("charizard")) {
			hp = 360;

		}
		else if (pokemonname.equals("golisopod")) {
			hp = 354;

		}
		else if (pokemonname.equals("roserade")) {
			hp = 324;

		}
		else if (pokemonname.equals("sceptile")) {
			hp = 344;

		}
		else if (pokemonname.equals("mewtwo")) {
			hp = 416;

		}
		else if (pokemonname.equals("talonflame")) {
			hp = 360;

		}
		else if (pokemonname.equals("snorlax")) {
			hp = 524;

		}
		else if (pokemonname.equals("infernape")) {
			hp = 356;

		}
		else if (pokemonname.equals("weavile")) {
			hp = 344;

		}
		else if (pokemonname.equals("groudon")) {
			hp = 404;

		}
		else if (pokemonname.equals("kyogre")) {
			hp = 404;

		}
		else if (pokemonname.equals("rayquaza")) {
			hp = 414;

		}
		else if (pokemonname.equals("giratina-altered")) {
			hp = 504;

		}
		else if (pokemonname.equals("giratina-origin")) {
			hp = 504;

		}
		else if (pokemonname.equals("gardevoir")) {
			hp = 340;

		}
		else if (pokemonname.equals("gallade")) {
			hp = 340;

		}

		return hp;

	}


	// gets a pokemon's speed

	public int getspeed(String pokemonname) { //get pokemon speed
		int speed = 0;
		if (pokemonname.equals("metagross")) {
			speed = 262;

		} else if (pokemonname.equals("gliscor")) {
			speed = 317;

		} else if (pokemonname.equals("excadrill")) {
			speed = 302;

		} else if (pokemonname.equals("arcanine")) {
			speed = 317;

		} else if (pokemonname.equals("krookodile")) {
			speed = 311;

		} else if (pokemonname.equals("feraligatr")) {
			speed = 280;

		} else if (pokemonname.equals("gyarados")) {
			speed = 287;

		} else if (pokemonname.equals("starmie")) {
			speed = 361;

		} else if (pokemonname.equals("gengar")) {
			speed = 350;

		} else if (pokemonname.equals("espeon")) {
			speed = 350;

		} else if (pokemonname.equals("jolteon")) {
			speed = 394;

		} else if (pokemonname.equals("glaceon")) {
			speed = 251;

		} else if (pokemonname.equals("sylveon")) {
			speed = 240;

		} else if (pokemonname.equals("umbreon")) {
			speed = 251;

		} else if (pokemonname.equals("leafeon")) {
			speed = 317;

		} else if (pokemonname.equals("vaporeon")) {
			speed = 251;

		} else if (pokemonname.equals("flareon")) {
			speed = 251;

		} else if (pokemonname.equals("scizor")) {
			speed = 251;

		} else if (pokemonname.equals("hydreigon")) {
			speed = 324;

		} else if (pokemonname.equals("meloetta")) {
			speed = 306;

		} else if (pokemonname.equals("archeops")) {
			speed = 350;

		} else if (pokemonname.equals("crobat")) {
			speed = 394;

		} else if (pokemonname.equals("jirachi")) {
			speed = 328;

		} else if (pokemonname.equals("manaphy")) {
			speed = 328;

		} else if (pokemonname.equals("melmetal")) {
			speed = 183;

		} else if (pokemonname.equals("kingdra")) {
			speed = 295;

		} else if (pokemonname.equals("machamp")) {
			speed = 229;

		} else if (pokemonname.equals("milotic")) {
			speed = 287;

		} else if (pokemonname.equals("salamence")) {
			speed = 328;

		} else if (pokemonname.equals("dragonite")) {
			speed = 284;

		} else if (pokemonname.equals("chandelure")) {
			speed = 284;

		} else if (pokemonname.equals("greninja")) {
			speed = 377;

		} else if (pokemonname.equals("zeraora")) {
			speed = 423;

		} else if (pokemonname.equals("togekiss")) {
			speed = 284;

		} else if (pokemonname.equals("volcarona")) {
			speed = 328;

		} else if (pokemonname.equals("pikachu")) {
			speed = 306;

		} else if (pokemonname.equals("mimikyu")) {
			speed = 320;

		} else if (pokemonname.equals("noivern")) {
			speed = 379;

		} else if (pokemonname.equals("hawlucha")) {
			speed = 368;

		} else if (pokemonname.equals("zoroark")) {
			speed = 339;

		} else if (pokemonname.equals("garchomp")) {
			speed = 333;

		} else if (pokemonname.equals("tyranitar")) {
			speed = 243;

		} else if (pokemonname.equals("lucario")) {
			speed = 306;

		} else if (pokemonname.equals("flygon")) {
			speed = 328;

		} else if (pokemonname.equals("dragapult")) {
			speed = 421;

		} else if (pokemonname.equals("goodra")) {
			speed = 284;

		}
		else if (pokemonname.equals("charizard")) {
			speed = 328;

		}
		else if (pokemonname.equals("golisopod")) {
			speed = 196;

		}
		else if (pokemonname.equals("roserade")) {
			speed = 306;

		}
		else if (pokemonname.equals("sceptile")) {
			speed = 372;

		}
		else if (pokemonname.equals("mewtwo")) {
			speed = 394;

		}
		else if (pokemonname.equals("talonflame")) {
			speed = 386;

		}
		else if (pokemonname.equals("snorlax")) {
			speed = 174;

		}
		else if (pokemonname.equals("infernape")) {
			speed = 346;

		}
		else if (pokemonname.equals("weavile")) {
			speed = 383;

		}
		else if (pokemonname.equals("groudon")) {
			speed = 306;

		}
		else if (pokemonname.equals("kyogre")) {
			speed = 306;

		}
		else if (pokemonname.equals("rayquaza")) {
			speed = 317;

		}
		else if (pokemonname.equals("giratina-altered")) {
			speed = 306;

		}
		else if (pokemonname.equals("giratina-origin")) {
			speed = 306;

		}
		else if (pokemonname.equals("gardevoir")) {
			speed = 284;

		}
		else if (pokemonname.equals("gallade")) {
			speed = 284;

		}





		return speed;

	}


	// gets a pokemons defense
	public int getdefense(String pokemonname) { //gets pokemon  defense

		int def = 0;

		if (pokemonname.equals("metagross")) {
			def = 394;

		} else if (pokemonname.equals("gliscor")) {
			def = 383;

		} else if (pokemonname.equals("excadrill")) {
			def = 240;

		} else if (pokemonname.equals("arcanine")) {
			def = 284;

		} else if (pokemonname.equals("krookodile")) {
			def = 284;

		} else if (pokemonname.equals("feraligatr")) {
			def = 328;

		} else if (pokemonname.equals("gyarados")) {
			def = 282;

		} else if (pokemonname.equals("starmie")) {
			def = 295;

		} else if (pokemonname.equals("gengar")) {
			def = 240;

		} else if (pokemonname.equals("espeon")) {
			def = 240;

		} else if (pokemonname.equals("jolteon")) {
			def = 240;

		} else if (pokemonname.equals("glaceon")) {
			def = 350;

		} else if (pokemonname.equals("sylveon")) {
			def = 251;

		} else if (pokemonname.equals("umbreon")) {
			def = 350;

		} else if (pokemonname.equals("leafeon")) {
			def = 394;

		} else if (pokemonname.equals("vaporeon")) {
			def = 240;

		} else if (pokemonname.equals("flareon")) {
			def = 240;

		} else if (pokemonname.equals("scizor")) {
			def = 328;

		} else if (pokemonname.equals("hydreigon")) {
			def = 306;

		} else if (pokemonname.equals("meloetta")) {
			def = 278;

		} else if (pokemonname.equals("archeops")) {
			def = 251;

		} else if (pokemonname.equals("crobat")) {
			def = 284;

		} else if (pokemonname.equals("jirachi")) {
			def = 328;

		} else if (pokemonname.equals("manaphy")) {
			def = 328;

		} else if (pokemonname.equals("melmetal")) {
			def = 423;

		} else if (pokemonname.equals("kingdra")) {
			def = 317;

		} else if (pokemonname.equals("machamp")) {
			def = 284;

		} else if (pokemonname.equals("milotic")) {
			def = 282;

		} else if (pokemonname.equals("salamence")) {
			def = 284;

		} else if (pokemonname.equals("dragonite")) {
			def = 317;

		} else if (pokemonname.equals("chandelure")) {
			def = 306;

		} else if (pokemonname.equals("greninja")) {
			def = 256;

		} else if (pokemonname.equals("zeraora")) {
			def = 273;

		} else if (pokemonname.equals("togekiss")) {
			def = 317;

		} else if (pokemonname.equals("volcarona")) {
			def = 251;

		} else if (pokemonname.equals("pikachu")) {
			def = 196;

		} else if (pokemonname.equals("mimikyu")) {
			def = 284;

		} else if (pokemonname.equals("noivern")) {
			def = 284;

		} else if (pokemonname.equals("hawlucha")) {
			def = 273;

		} else if (pokemonname.equals("zoroark")) {
			def = 240;

		} else if (pokemonname.equals("garchomp")) {
			def = 317;

		} else if (pokemonname.equals("tyranitar")) {
			def = 350;

		} else if (pokemonname.equals("lucario")) {
			def = 262;

		} else if (pokemonname.equals("flygon")) {
			def = 284;

		} else if (pokemonname.equals("dragapult")) {
			def = 273;

		} else if (pokemonname.equals("goodra")) {
			def = 262;

		}
		else if (pokemonname.equals("charizard")) {
			def = 280;

		}
		else if (pokemonname.equals("golisopod")) {
			def = 416;

		}
		else if (pokemonname.equals("roserade")) {
			def = 251;

		}
		else if (pokemonname.equals("sceptile")) {
			def = 251;

		}
		else if (pokemonname.equals("mewtwo")) {
			def = 306;

		}
		else if (pokemonname.equals("talonflame")) {
			def = 265;

		}
		else if (pokemonname.equals("snorlax")) {
			def = 251;

		}
		else if (pokemonname.equals("infernape")) {
			def = 265;

		}
		else if (pokemonname.equals("weavile")) {
			def = 251;

		}
		else if (pokemonname.equals("groudon")) {
			def = 416;

		}
		else if (pokemonname.equals("kyogre")) {
			def = 306;

		}
		else if (pokemonname.equals("rayquaza")) {
			def = 306;

		}
		else if (pokemonname.equals("giratina-altered")) {
			def = 372;

		}
		else if (pokemonname.equals("giratina-origin")) {
			def = 328;

		}
		else if (pokemonname.equals("gardevoir")) {
			def = 251;

		}
		else if (pokemonname.equals("gallade")) {
			def = 361;

		}


		return def;

	}


	// gets a pokemons special defense
	public int getspecialdefense(String pokemonname) {


		int spdef = 0;

		if (pokemonname.equals("metagross")) {
			spdef = 306;

		} else if (pokemonname.equals("gliscor")) {
			spdef = 273;

		} else if (pokemonname.equals("excadrill")) {
			spdef = 251;

		}  else if (pokemonname.equals("arcanine")) {
			spdef = 284;

		} else if (pokemonname.equals("krookodile")) {
			spdef = 262;

		} else if (pokemonname.equals("feraligatr")) {
			spdef = 291;

		} else if (pokemonname.equals("gyarados")) {
			spdef = 328;

		} else if (pokemonname.equals("starmie")) {
			spdef = 295;

		} else if (pokemonname.equals("gengar")) {
			spdef = 273;

		} else if (pokemonname.equals("espeon")) {
			spdef = 317;

		} else if (pokemonname.equals("jolteon")) {
			spdef = 317;

		} else if (pokemonname.equals("glaceon")) {
			spdef = 317;

		} else if (pokemonname.equals("sylveon")) {
			spdef = 394;

		} else if (pokemonname.equals("umbreon")) {
			spdef = 394;

		} else if (pokemonname.equals("leafeon")) {
			spdef = 251;

		} else if (pokemonname.equals("vaporeon")) {
			spdef = 317;

		} else if (pokemonname.equals("flareon")) {
			spdef = 350;

		} else if (pokemonname.equals("scizor")) {
			spdef = 284;

		} else if (pokemonname.equals("hydreigon")) {
			spdef = 306;

		} else if (pokemonname.equals("meloetta")) {
			spdef = 390;

		} else if (pokemonname.equals("archeops")) {
			spdef = 251;

		} else if (pokemonname.equals("crobat")) {
			spdef = 284;

		} else if (pokemonname.equals("jirachi")) {
			spdef = 328;

		} else if (pokemonname.equals("manaphy")) {
			spdef = 328;

		} else if (pokemonname.equals("melmetal")) {
			spdef = 251;

		} else if (pokemonname.equals("kingdra")) {
			spdef = 317;

		} else if (pokemonname.equals("machamp")) {
			spdef = 229;

		} else if (pokemonname.equals("milotic")) {
			spdef = 287;

		} else if (pokemonname.equals("salamence")) {
			spdef = 284;

		} else if (pokemonname.equals("dragonite")) {
			spdef = 328;

		} else if (pokemonname.equals("chandelure")) {
			spdef = 306;

		} else if (pokemonname.equals("greninja")) {
			spdef = 265;

		} else if (pokemonname.equals("zeraora")) {
			spdef = 284;

		} else if (pokemonname.equals("togekiss")) {
			spdef = 361;

		} else if (pokemonname.equals("volcarona")) {
			spdef = 339;

		} else if (pokemonname.equals("pikachu")) {
			spdef = 218;

		} else if (pokemonname.equals("mimikyu")) {
			spdef = 339;

		} else if (pokemonname.equals("noivern")) {
			spdef = 284;

		} else if (pokemonname.equals("hawlucha")) {
			spdef = 247;

		} else if (pokemonname.equals("zoroark")) {
			spdef = 240;

		} else if (pokemonname.equals("garchomp")) {
			spdef = 295;

		} else if (pokemonname.equals("tyranitar")) {
			spdef = 328;

		} else if (pokemonname.equals("lucario")) {
			spdef = 262;

		} else if (pokemonname.equals("flygon")) {
			spdef = 284;

		} else if (pokemonname.equals("dragapult")) {
			spdef = 273;

		} else if (pokemonname.equals("goodra")) {
			spdef = 438;

		}
		else if (pokemonname.equals("charizard")) {
			spdef = 295;

		}
		else if (pokemonname.equals("golisopod")) {
			spdef = 306;

		}
		else if (pokemonname.equals("roserade")) {
			spdef = 339;

		}
		else if (pokemonname.equals("sceptile")) {
			spdef = 295;

		}
		else if (pokemonname.equals("mewtwo")) {
			spdef = 306;

		}
		else if (pokemonname.equals("talonflame")) {
			spdef = 260;

		}
		else if (pokemonname.equals("snorlax")) {
			spdef = 350;

		}
		else if (pokemonname.equals("infernape")) {
			spdef = 265;

		}
		else if (pokemonname.equals("weavile")) {
			spdef = 295;

		}
		else if (pokemonname.equals("groudon")) {
			spdef = 306;

		}
		else if (pokemonname.equals("kyogre")) {
			spdef = 416;

		}
		else if (pokemonname.equals("rayquaza")) {
			spdef = 306;

		}
		else if (pokemonname.equals("giratina-altered")) {
			spdef = 372;

		}
		else if (pokemonname.equals("giratina-origin")) {
			spdef = 328;

		}
		else if (pokemonname.equals("gardevoir")) {
			spdef = 361;

		}
		else if (pokemonname.equals("gallade")) {
			spdef = 361;

		}


		return spdef;

	}


	// gets a pokemon's special attack

	public int getspecialattack(String pokemonname) {

		int spa = 0;

		if (pokemonname.equals("metagross")) {
			spa = 317;

		} else if (pokemonname.equals("gliscor")) {
			spa = 207;

		} else if (pokemonname.equals("excadrill")) {
			spa = 218;

		} else if (pokemonname.equals("arcanine")) {
			spa = 328;

		}  else if (pokemonname.equals("krookodile")) {
			spa = 251;

		} else if (pokemonname.equals("feraligatr")) {
			spa = 282;

		} else if (pokemonname.equals("gyarados")) {
			spa = 240;

		} else if (pokemonname.equals("starmie")) {
			spa = 328;

		} else if (pokemonname.equals("gengar")) {
			spa = 394;

		} else if (pokemonname.equals("espeon")) {
			spa = 394;

		} else if (pokemonname.equals("jolteon")) {
			spa = 350;

		} else if (pokemonname.equals("glaceon")) {
			spa = 394;

		} else if (pokemonname.equals("sylveon")) {
			spa = 350;

		} else if (pokemonname.equals("umbreon")) {
			spa = 240;

		} else if (pokemonname.equals("leafeon")) {
			spa = 240;

		} else if (pokemonname.equals("vaporeon")) {
			spa = 350;

		} else if (pokemonname.equals("flareon")) {
			spa = 317;

		} else if (pokemonname.equals("scizor")) {
			spa = 229;

		} else if (pokemonname.equals("hydreigon")) {
			spa = 383;

		} else if (pokemonname.equals("meloetta")) {
			spa = 390;

		} else if (pokemonname.equals("archeops")) {
			spa = 355;

		} else if (pokemonname.equals("crobat")) {
			spa = 262;

		} else if (pokemonname.equals("jirachi")) {
			spa = 328;

		} else if (pokemonname.equals("manaphy")) {
			spa = 328;

		} else if (pokemonname.equals("melmetal")) {
			spa = 284;

		} else if (pokemonname.equals("kingdra")) {
			spa = 317;

		} else if (pokemonname.equals("machamp")) {
			spa = 251;

		} else if (pokemonname.equals("milotic")) {
			spa = 328;

		} else if (pokemonname.equals("salamence")) {
			spa = 350;

		} else if (pokemonname.equals("dragonite")) {
			spa = 328;

		} else if (pokemonname.equals("chandelure")) {
			spa = 427;

		} else if (pokemonname.equals("greninja")) {
			spa = 335;

		} else if (pokemonname.equals("zeraora")) {
			spa = 333;

		} else if (pokemonname.equals("togekiss")) {
			spa = 372;

		} else if (pokemonname.equals("volcarona")) {
			spa = 405;

		} else if (pokemonname.equals("pikachu")) {
			spa = (218 * 2);

		} else if (pokemonname.equals("mimikyu")) {
			spa = 218;

		} else if (pokemonname.equals("noivern")) {
			spa = 322;

		} else if (pokemonname.equals("hawlucha")) {
			spa = 271;

		} else if (pokemonname.equals("zoroark")) {
			spa = 372;

		} else if (pokemonname.equals("garchomp")) {
			spa = 284;

		} else if (pokemonname.equals("tyranitar")) {
			spa = 317;

		} else if (pokemonname.equals("lucario")) {
			spa = 361;

		} else if (pokemonname.equals("flygon")) {
			spa = 284;

		} else if (pokemonname.equals("dragapult")) {
			spa = 328;

		} else if (pokemonname.equals("goodra")) {
			spa = 350;

		}
		else if (pokemonname.equals("charizard")) {
			spa = 348;

		}
		else if (pokemonname.equals("golisopod")) {
			spa = 240;

		}
		else if (pokemonname.equals("roserade")) {
			spa = 383;

		}
		else if (pokemonname.equals("sceptile")) {
			spa = 339;

		}
		else if (pokemonname.equals("mewtwo")) {
			spa = 447;

		}
		else if (pokemonname.equals("talonflame")) {
			spa = 271;

		}
		else if (pokemonname.equals("snorlax")) {
			spa = 251;

		}
		else if (pokemonname.equals("infernape")) {
			spa = 337;

		}
		else if (pokemonname.equals("weavile")) {
			spa = 207;

		}
		else if (pokemonname.equals("groudon")) {
			spa = 328;

		}
		else if (pokemonname.equals("kyogre")) {
			spa = 438;

		}
		else if (pokemonname.equals("rayquaza")) {
			spa = 438;

		}
		else if (pokemonname.equals("giratina-altered")) {
			spa = 328;

		}
		else if (pokemonname.equals("giratina-origin")) {
			spa = 372;

		}
		else if (pokemonname.equals("gardevoir")) {
			spa = 383;

		}
		else if (pokemonname.equals("gallade")) {
			spa = 251;

		}



		return spa;

	}


	public String getcall(String pokemonname) {// all pokemon and files of their calls

		String call = "null";

		if (pokemonname.equals("metagross")) {
			call = "metagross.wav";

			//
		} else if (pokemonname.equals("gliscor")) {
			call = "gliscor.wav";
			//


		} else if (pokemonname.equals("excadrill")) {
			call = "excadrill.wav";

			//

		} else if (pokemonname.equals("arcanine")) {
			call = "arcanine.wav";

			//

		} else if (pokemonname.equals("krookodile")) {
			call = "krookodile.wav";


		}//
		else if (pokemonname.equals("feraligatr")) {
			call = "feraligatr.wav";

			//
		} else if (pokemonname.equals("gyarados")) {
			call = "gyarados.wav";

		}//
		else if (pokemonname.equals("starmie")) {
			call = "starmie.wav";

		}//
		else if (pokemonname.equals("gengar")) {
			call = "gengar.wav";
			//
		} else if (pokemonname.equals("espeon")) {
			call = "espeon.wav";
			//
		} else if (pokemonname.equals("jolteon")) {
			call = "jolteon.wav";
			//
		} else if (pokemonname.equals("glaceon")) {
			call = "glaceon.wav";
			//
		} else if (pokemonname.equals("sylveon")) {
			call = "sylveon.wav";//

		} else if (pokemonname.equals("umbreon")) {
			call = "umbreon.wav";//

		} else if (pokemonname.equals("leafeon")) {
			call = "leafeon.wav";//

		} else if (pokemonname.equals("vaporeon")) {
			call = "vaporeon.wav";
			///
		} else if (pokemonname.equals("flareon")) {
			call = "flareon.wav";

		}//
		else if (pokemonname.equals("scizor")) {
			call = "scizor.wav";
			//
		} else if (pokemonname.equals("hydreigon")) {
			call = "hydreigon.wav";
			//
		} else if (pokemonname.equals("meloetta")) {
			call = "meloetta.wav";
			//
		} else if (pokemonname.equals("archeops")) {
			call = "archeops.wav";
			//
		} else if (pokemonname.equals("crobat")) {
			call = "crobat.wav";
			//
		} else if (pokemonname.equals("jirachi")) {
			call = "jirachi.wav";
			//
		} else if (pokemonname.equals("manaphy")) {
			call = "manaphy.wav";
			//
		} else if (pokemonname.equals("melmetal")) {
			call = "melmetal.wav";
			//
		} else if (pokemonname.equals("milotic")) {
			call = "milotic.wav";
			//
		} else if (pokemonname.equals("kingdra")) {
			call = "kingdra.wav";
			//
		} else if (pokemonname.equals("machamp")) {
			call = "machamp.wav";
			//
		} else if (pokemonname.equals("chandelure")) {
			call = "chandelure.wav";
			//
		} else if (pokemonname.equals("dragonite")) {
			call = "dragonite.wav";
			//
		} else if (pokemonname.equals("salamence")) {
			call = "salamence.wav";//

		} else if (pokemonname.equals("greninja")) {
			call = "greninja.wav";//

		} else if (pokemonname.equals("zeraora")) {
			call = "zeraora.wav";//

		} else if (pokemonname.equals("togekiss")) {
			call = "togekiss.wav";//

		} else if (pokemonname.equals("volcarona")) {
			call = "volcarona.wav";//

		} else if (pokemonname.equals("pikachu")) {
			call = "pikachu.wav";//

		} else if (pokemonname.equals("noivern")) {
			call = "noivern.wav";//

		} else if (pokemonname.equals("mimikyu")) {
			call = "mimikyu.wav";//

		} else if (pokemonname.equals("hawlucha")) {
			call = "hawlucha.wav";//

		} else if (pokemonname.equals("zoroark")) {
			call = "zoroark.wav";//

		} else if (pokemonname.equals("garchomp")) {
			call = "garchomp.wav";//

		} else if (pokemonname.equals("tyranitar")) {
			call = "tyranitar.wav";//

		} else if (pokemonname.equals("lucario")) {
			call = "lucario.wav";//

		} else if (pokemonname.equals("flygon")) {
			call = "flygon.wav";//

		} else if (pokemonname.equals("dragapult")) {
			call = "dragapult.wav";//

		} else if (pokemonname.equals("goodra")) {
			call = "goodra.wav";//

		} else if (pokemonname.equals("charizard")) {
			call = "charizard.wav";//

		} else if (pokemonname.equals("golisopod")) {
			call = "golisopod.wav";//

		} else if (pokemonname.equals("roserade")) {
			call = "roserade.wav";//

		} else if (pokemonname.equals("sceptile")) {
			call = "sceptile.wav";//

		} else if (pokemonname.equals("mewtwo")) {
			call = "mewtwo.wav";//

		} else if (pokemonname.equals("talonflame")) {
			call = "talonflame.wav";//

		} else if (pokemonname.equals("snorlax")) {
			call = "snorlax.wav";//

		} else if (pokemonname.equals("infernape")) {
			call = "infernape.wav";//

		} else if (pokemonname.equals("weavile")) {
			call = "weavile.wav";//

		} else if (pokemonname.equals("giratina-altered")) {
			call = "giratina.wav";//

		} else if (pokemonname.equals("giratina-origin")) {
			call = "giratina.wav";//

		} else if (pokemonname.equals("groudon")) {
			call = "groudon.wav";//

		} else if (pokemonname.equals("kyogre")) {
			call = "kyogre.wav";//

		} else if (pokemonname.equals("rayquaza")) {
			call = "rayquaza.wav";//

		}
		else if (pokemonname.equals("gallade")) {
			call = "gallade.wav";//

		} else if (pokemonname.equals("gardevoir")) {
			call = "gardevoir.wav";//

		}




		return call;

	}


}
     // back up of pokemon and stats
     

 	// this is where all pokemon will get their stats (Whether player 1 or player 2 ) 
 	
     
     // every pokemon has at least 7 potential moves
     
 	// These are the pokemon of this simulator and their stats 
     /* Metagross:
      * HP: 364
      * Attack: 405
      * Defense: 394
      * Special Attack:  317
      * Special Defense: 306
      * Speed: 262
      * Ability: clearbody
      * Type1: steel
      * Type2: psychic
      * 
      * Gliscor
        HP: 354
      * Attack: 317
      * Defense: 383
      * Special Attack:  207
      * Special Defense: 273
      * Speed: 317
      * Ability: hypercutter
      * Type1: ground 
      * Type2: flying

        excadrill
        
       HP: 404
      * Attack: 405
      * Defense: 240
      * Special Attack:  218
      * Special Defense: 251
      * Speed: 302
      * Ability: moldbreaker
      * Type1: steel
      * Type2: ground
      * 
      * 
      *arcanine
      * HP: 384
      * Attack: 350
      * Defense: 284
      * Special Attack:  328
      * Special Defense: 284
      * Speed: 317
      * Ability: intimidate
      * Type1: fire
      * Type2: null
      * 
      * krookodile
      * HP: 394
      * Attack: 366
      * Defense: 284
      * Special Attack:  251
      * Special Defense: 262
      * Speed: 311
      * Ability: intimidate
      * Type1: ground
      * Type2: dark
      * 
      * feraligatr
      *  HP: 374
      * Attack: 339
      * Defense: 328
      * Special Attack:  282
      * Special Defense: 291
      * Speed: 280
      * Ability: sheerforce
      * Type1: water
      * Type2: null
      * 
      * gyarados
      * HP: 394
      * Attack: 383
      * Defense: 282
      * Special Attack:  240
      * Special Defense: 328
      * Speed: 287
      * Ability: intimidate
      * Type1: water
      * Type2: flying
      * 
      * Starmie
      * HP: 324
      * Attack: 273
      * Defense: 295
      * Special Attack:  328
      * Special Defense: 295
      * Speed: 361
      * Ability: (it is now magic guard)
      * Type1: water
      * Type2: psychic
      * 
      * 
      * gengar
      * HP: 324
      * Attack: 251
      * Defense: 240
      * Special Attack:  394
      * Special Defense: 273
      * Speed: 350
      * Ability: levitate
      * Type1: ghost
      * Type2: poison
      * 
      * espeon
      * HP: 334
      * Attack: 251
      * Defense: 240
      * Special Attack:  394
      * Special Defense: 317
      * Speed: 350
      * Ability: magicbounce
      * Type1: psychic
      * Type2: null
      * 
      * jolteon
      * HP: 334
      * Attack: 251
      * Defense: 240
      * Special Attack:  350
      * Special Defense: 317
      * Speed: 394
      * Ability: quickfeet
      * Type1: electric
      * Type2: null
      * 
      * glaceon
      * HP: 334
      * Attack: 240
      * Defense: 350
      * Special Attack:  394
      * Special Defense: 317
      * Speed: 251
      * Ability: magicbounce
      * Type1: ice
      * Type2: null
      * 
      * sylveon
      * HP: 394
      * Attack: 251
      * Defense: 251
      * Special Attack:  350
      * Special Defense: 394
      * Speed: 240
      * Ability: pixilate
      * Type1: fairy
      * Type2: null
      * 
      * umbreon
      * HP: 394
      * Attack: 251
      * Defense: 350
      * Special Attack:  240
      * Special Defense: 394
      * Speed: 251
      * Ability: magicbounce
      * Type1: dark
      * Type2: null
      * 
      * leafeon
      * HP: 334
      * Attack: 350
      * Defense: 394
      * Special Attack:  240
      * Special Defense: 251
      * Speed: 317
      * Ability: stamina
      * Type1: grass
      * Type2: null
      * 
      * vaporeon
      * HP: 464
      * Attack: 251
      * Defense: 240
      * Special Attack:  350
      * Special Defense: 317
      * Speed: 251
      * Ability: waterabsorb
      * Type1: water
      * Type2: null
      * 
      * flareon
      * HP: 334
      * Attack: 394
      * Defense: 240
      * Special Attack:  317
      * Special Defense: 350
      * Speed: 251
      * Ability: guts
      * Type1: fire
      * Type2: null
      * 
      * scizor
      * HP: 344
      * Attack: 394
      * Defense: 328
      * Special Attack:  229
      * Special Defense: 284
      * Speed: 251
      * Ability: technician
      * Type1: steel
      * Type2: bug
      * 
      * 
      * hydriegon
      * HP: 388
      * Attack: 339
      * Defense: 306
      * Special Attack:  383
      * Special Defense: 306
      * Speed: 324
      * Ability: levitate
      * Type1: dragon
      * Type2: dark
      * 
      * meloetta // We are going to use its aria form as its default form 
      * 
      * Aria Form:
      * HP: 404
      * Attack: 278
      * Defense: 278
      * Special Attack:  390
      * Special Defense: 390
      * Speed: 306
      * Ability: serenegrace
      * Type1: normal
      * Type2: psychic
      * 
      * Pirouete Form:
      * HP: 404
      * Attack: 390
      * Defense: 306
      * Special Attack:  278
      * Special Defense: 278
      * Speed: 390
      * Ability: serenegrace
      * Type1: normal
      * Type2: fighting
      * 
      * archeops:
      * HP: 354
      * Attack: 416
      * Defense: 251
      * Special Attack:  355
      * Special Defense: 251
      * Speed: 350
      * Ability: solidrock (Actual deafeatist)
      * Type1: rock
      * Type2: flying
      * 
      * 
      * 
      * 
      * crobat:
      * HP: 374
      * Attack: 306
      * Defense: 284
      * Special Attack:  262
      * Special Defense: 284
      * Speed: 394
      * Ability: inner focus 
      * Type1: poison
      * Type2: flying
      *
      * manaphy:
      * HP: 404
      * Attack: 328
      * Defense: 328
      * Special Attack:  328
      * Special Defense: 328
      * Speed: 328
      * Ability: marvel scale
      * Type1: water
      * Type2: null
      *
      *
      *
      * jirachi:
      * HP: 404
      * Attack: 328
      * Defense: 328
      * Special Attack:  328
      * Special Defense: 328
      * Speed: 328
      * Ability: serenegrace 
      * Type1: steel
      * Type2: psychic
      * 
      * melmetal:
      * HP: 423
      * Attack: 423
      * Defense: 423
      * Special Attack:  284
      * Special Defense: 251
      * Speed: 183
      * Ability: ironfist 
      * Type1: steel
      * Type2: null
      * 
      * Kingdra
      * HP: 354
      * Attack: 317
      * Defense: 317
      * Special Attack:  317
      * Special Defense: 317
      * Speed: 295
      * Ability: sniper
      * Type1: water
      * Type2: dragon
      * 
      * 
      * machamp
      * HP: 384
      * Attack: 394
      * Defense: 284
      * Special Attack:  251
      * Special Defense: 295
      * Speed: 229
      * Ability: noguard
      * Type1: fighting
      * Type2: null
      * 
      * milotic
      * HP: 394
      * Attack: 240
      * Defense: 282
      * Special Attack:  328
      * Special Defense: 383
      * Speed: 287
      * Ability: marvelscale
      * Type1: water
      * Type2: null
      * 
      * dragonite
      * HP: 386
      * Attack: 403
      * Defense: 317
      * Special Attack:  328
      * Special Defense: 328
      * Speed: 284
      * Ability: multiscale
      * Type1: flying
      * Type2: dragon
      * 
      * 
      * salamence
      * HP: 394
      * Attack: 405
      * Defense: 284
      * Special Attack:  350
      * Special Defense: 284
      * Speed: 328
      * Ability: intimidate
      * Type1: flying
      * Type2: dragon
      * 
      * * 
      * chandelure
      * HP: 324
      * Attack: 224
      * Defense: 306
      * Special Attack:  427
      * Special Defense: 306
      * Speed: 284
      * Ability: multiscale
      * Type1: fire
      * Type2: ghost
      * 
      * 
      * greninja
      * HP: 348
      * Attack: 317
      * Defense: 256
      * Special Attack:  335
      * Special Defense: 265
      * Speed: 377
      * Ability: protean
      * Type1: water
      * Type2: dark
      * 
      * zeraora
      * HP: 380
      * Attack: 355
      * Defense: 273
      * Special Attack:  333
      * Special Defense: 284
      * Speed: 423
      * Ability: tough claws
      * Type1: electric
      * Type2: null
      *
      * 
      * togekiss
      * HP: 374
      * Attack: 218
      * Defense: 317
      * Special Attack:  372
      * Special Defense: 361
      * Speed: 284
      * Ability: serenegrace
      * Type1: fairy
      * Type2: flying
      *
      * volcarona
      * HP: 374
      * Attack: 240
      * Defense: 251
      * Special Attack:  405
      * Special Defense: 339
      * Speed: 328
      * Ability: flamebody
      * Type1: bug
      * Type2: fire
      *
      * pikachu
      * HP: 274
      * Attack: ( 229 * 2) holds light ball
      * Defense: 196
      * Special Attack:  (218 * 2 )(holds light ball)
      * Special Defense: 218
      * Speed: 306
      * Ability: static
      * Type1: electric
      * Type2: null
      * 
      * mimikyu
      * HP: 314
      * Attack: 306
      * Defense: 284
      * Special Attack:  218
      * Special Defense: 339
      * Speed: 320
      * Ability: disguise
      * Type1: ghost
      * Type2: fairy
      * 
      * noivern
      * HP: 374
      * Attack: 262
      * Defense: 284
      * Special Attack:  322
      * Special Defense: 284
      * Speed: 379
      * Ability: multiscale
      * Type1: flying
      * Type2: dragon
      *
      *
      * hawlucha
      * HP: 360
      * Attack: 311
      * Defense: 273
      * Special Attack:  271
      * Special Defense: 247
      * Speed: 368
      * Ability: moldbreaker
      * Type1: fighting
      * Type2: flying
      *
      *
      *
      * zoroark
      * HP: 324
      * Attack: 339
      * Defense: 240
      * Special Attack:  372
      * Special Defense: 240
      * Speed: 339
      * Ability: disguise
      * Type1: dark
      * Type2: null
      *
      *
      *
      * garchomp
      * HP: 420
      * Attack: 394
      * Defense: 317
      * Special Attack:  284
      * Special Defense: 295
      * Speed: 333
      * Ability: roughskin
      * Type1: dragon
      * Type2: ground
      *
      *
      * tyranitar
      * HP: 404
      * Attack: 403
      * Defense: 350
      * Special Attack:  317
      * Special Defense: 328
      * Speed: 243
      * Ability: solidrock
      * Type1: rock
      * Type2: dark
      *
      *
      *
      * lucario
      * HP: 344
      * Attack: 350
      * Defense: 262
      * Special Attack:  361
      * Special Defense: 262
      * Speed: 306
      * Ability: innerfocus
      * Type1: fighting
      * Type2: steel
      *
      *
      * flygon
      * HP: 364
      * Attack: 328
      * Defense: 284
      * Special Attack:  284
      * Special Defense: 284
      * Speed: 328
      * Ability: levitate
      * Type1: dragon
      * Type2: ground
      *
      *
      * dragapult
      * HP: 380
      * Attack: 372
      * Defense: 273
      * Special Attack:  328
      * Special Defense: 273
      * Speed: 421
      * Ability: clearbody
      * Type1: dragon
      * Type2: ghost
      *
      * goodra
      * HP: 384
      * Attack: 328
      * Defense: 262
      * Special Attack:  350
      * Special Defense: 438
      * Speed: 284
      * Ability: gooey
      * Type1: dragon
      * Type2: null
      *
      *
      *
      *
      *
      *
      *
      *
      *
      *
      *
      *
      * charizard
      * HP: 360
      * Attack: 293
      * Defense: 280
      * Special Attack:  348
      * Special Defense: 295
      * Speed: 328
      * Ability: toughclaws
      * Type1: fire
      * Type2: flying
      *
      *
      * golisopod
      * HP: 354
      * Attack: 383
      * Defense: 416
      * Special Attack:  240
      * Special Defense: 306
      * Speed: 196
      * Ability: toughclaws
      * Type1: bug
      * Type2: water
      *
      *
      * roserade
      * HP: 324
      * Attack: 262
      * Defense: 251
      * Special Attack:  383
      * Special Defense: 339
      * Speed: 306
      * Ability: poisonpoint
      * Type1: grass
      * Type2: poison
      *
      *
      * sceptile
      * HP: 344
      * Attack: 295
      * Defense: 251
      * Special Attack:  339
      * Special Defense: 295
      * Speed: 372
      * Ability: protean
      * Type1: grass
      * Type2: null

      * mewtwo
      * HP: 416
      * Attack: 350
      * Defense: 306
      * Special Attack:  447
      * Special Defense: 306
      * Speed: 394
      * Ability: multiscale
      * Type1: psychic
      * Type2: null
      *
      *
      *
      *
      *
      *
      *
      *
      *
      *
      *
      *
      *
      *
      *
      *
      *
      *
      *
      *
      *
      *
      *
      *
      *
      *
      *
      *
      *
      * talonflame
      * HP: 360
      * Attack: 287
      * Defense: 265
      * Special Attack:  271
      * Special Defense: 260
      * Speed: 386
      * Ability: toughclaws
      * Type1: fire
      * Type2: flying
      *
      *
      * snorlax
      * HP: 524
      * Attack: 350
      * Defense: 251
      * Special Attack:  251
      * Special Defense: 350
      * Speed: 174
      * Ability: roughskin
      * Type1: normal
      * Type2: null
      *
      *
      * infernape
      * HP: 356
      * Attack: 337
      * Defense: 265
      * Special Attack:  337
      * Special Defense: 265
      * Speed: 346
      * Ability: toughclaws
      * Type1: fire
      * Type2: fighting
      *
      *
      * weavile
      * HP: 344
      * Attack: 372
      * Defense: 251
      * Special Attack:  207
      * Special Defense: 295
      * Speed: 383
      * Ability: toughclaws
      * Type1: dark
      * Type2: ice
      *
      *
      *
      *
      *
      *
      *
      *
      *
      *
      *
      *
      *
      *
      *
      * groudon
      * HP: 404
      * Attack: 438
      * Defense: 416
      * Special Attack:  328
      * Special Defense: 306
      * Speed: 306
      * Ability: solidrock
      * Type1: ground
      * Type2: null
      *
      *
      * kyogre
      * HP:404
      * Attack: 328
      * Defense: 306
      * Special Attack: 438
      * Special Defense: 416
      * Speed: 306
      * Ability: multiscale
      * Type1: water
      * Type2: null
      *
      *
      * rayquaza
      * HP: 414
      * Attack: 438
      * Defense: 306
      * Special Attack:  438
      * Special Defense: 306
      * Speed: 317
      * Ability: multiscale
      * Type1: dragon
      * Type2: flying
      *
      *
      * giratina-altered
      * HP: 504
      * Attack: 328
      * Defense: 372
      * Special Attack:  328
      * Special Defense: 372
      * Speed: 306
      * Ability: levitate
      * Type1: dragon
      * Type2: ghost

      * giratina-origin
      * HP: 504
      * Attack: 372
      * Defense: 328
      * Special Attack:  372
      * Special Defense: 328
      * Speed: 306
      * Ability: levitate
      * Type1: dragon
      * Type2: ghost
      *
      *
      *
      * gallade
      * HP: 340
      * Attack: 383
      * Defense: 251
      * Special Attack:  251
      * Special Defense: 361
      * Speed: 284
      * Ability: toughclaws
      * Type1: psychic
      * Type2: fighting

      * gardevoir
      * HP: 340
      * Attack: 251
      * Defense: 251
      * Special Attack:  383
      * Special Defense: 361
      * Speed: 284
      * Ability: magicbounce
      * Type1: psychic
      * Type2: fairy
      *
      *
      *
      *
      *
      *
      */
 	


