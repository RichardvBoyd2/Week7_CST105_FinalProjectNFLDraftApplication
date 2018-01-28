/** Program: Player Manager
 * File: PlayerManager.java
 * Summary: Creates a list of players and manages the info
 * Author: Richard Boyd
 * Date: January 14th 2018
 */

package application;
import java.util.ArrayList;

public class PlayerManager {
	
	ArrayList<OffensivePlayer> offensivelist = new ArrayList<OffensivePlayer>();  //Creates ArrayList
	ArrayList<DefensivePlayer> defensivelist = new ArrayList<DefensivePlayer>();
	
	public PlayerManager() {  //Constructor of the PlayerManager
		createOffensivePlayers(); //calls the createPlayers method
		createDefensivePlayers();
	}
	
	private ArrayList<OffensivePlayer> createOffensivePlayers() {  //Player names and stats hard coded into the createPlayers method
		OffensivePlayer manning = new OffensivePlayer(); //0
		manning.setName("Peyton Manning");
		manning.setPosition("Quarterback");
		manning.setNumber("18");
		manning.setAge(34);
		manning.setPassAtt(679);
		manning.setPassCmp(450);
		manning.setRushAtt(18);
		manning.setRushYrds(18);
		manning.setRec(0);
		manning.setRecYrds(0);
		offensivelist.add(manning);
		
		OffensivePlayer brown = new OffensivePlayer(); //1
		brown.setName("Donald Brown");
		brown.setPosition("Running Back");
		brown.setNumber("31");
		brown.setAge(23);
		brown.setPassAtt(0);
		brown.setPassCmp(0);
		brown.setRushAtt(129);
		brown.setRushYrds(497);
		brown.setRec(20);
		brown.setRecYrds(205);
		offensivelist.add(brown);
		 
		OffensivePlayer garcon = new OffensivePlayer(); //2
		garcon.setName("Pierre Garcon");
		garcon.setPosition("Wide Receiver");
		garcon.setNumber("85");
		garcon.setAge(24);
		garcon.setPassAtt(0);
		garcon.setPassCmp(0);
		garcon.setRushAtt(2);
		garcon.setRushYrds(6);
		garcon.setRec(67);
		garcon.setRecYrds(784);
		offensivelist.add(garcon);
		
		OffensivePlayer cutler = new OffensivePlayer(); //3
		cutler.setName("Jay Cutler");
		cutler.setPosition("Quarterback");
		cutler.setNumber("6");
		cutler.setAge(27);
		cutler.setPassAtt(432);
		cutler.setPassCmp(261);
		cutler.setRushAtt(50);
		cutler.setRushYrds(232);
		cutler.setRec(0);
		cutler.setRecYrds(0);
		offensivelist.add(cutler);
		
		OffensivePlayer forte = new OffensivePlayer(); //4
		forte.setName("Matt Forte");
		forte.setPosition("Running Back");
		forte.setNumber("22");
		forte.setAge(25);
		forte.setPassAtt(0);
		forte.setPassCmp(0);
		forte.setRushAtt(237);
		forte.setRushYrds(1069);
		forte.setRec(51);
		forte.setRecYrds(547);
		offensivelist.add(forte);
		
		OffensivePlayer knox = new OffensivePlayer(); //5
		knox.setName("Johnny Knox");
		knox.setPosition("Wide Receiver");
		knox.setNumber("13");
		knox.setAge(24);
		knox.setPassAtt(0);
		knox.setPassCmp(0);
		knox.setRushAtt(1);
		knox.setRushYrds(2);
		knox.setRec(51);
		knox.setRecYrds(960);
		offensivelist.add(knox);
		
		return offensivelist;
	}
	
	private ArrayList<DefensivePlayer> createDefensivePlayers() {
		
		DefensivePlayer bethea = new DefensivePlayer(); //0
		bethea.setName("Antoine Bethea");
		bethea.setPosition("Free Safety");
		bethea.setNumber("41");
		bethea.setAge(26);
		bethea.setInter(1);
		bethea.setIntYrds(31);
		bethea.setSacks(1);
		bethea.setTackles(77);
		defensivelist.add(bethea);
		
		DefensivePlayer powers = new DefensivePlayer(); //1
		powers.setName("Jerraud Powers");
		powers.setPosition("Right Cornerback");
		powers.setNumber("25");
		powers.setAge(23);
		powers.setInter(2);
		powers.setIntYrds(11);
		powers.setSacks(0);
		powers.setTackles(42);
		defensivelist.add(powers);
		
		DefensivePlayer harris = new DefensivePlayer(); //2
		harris.setName("Chris Harris");
		harris.setPosition("Free Safety");
		harris.setNumber("46");
		harris.setAge(28);
		harris.setInter(5);
		harris.setIntYrds(69);
		harris.setSacks(0);
		harris.setTackles(50);
		defensivelist.add(harris);
		
		DefensivePlayer tillman = new DefensivePlayer(); //3
		tillman.setName("Charles Tillman");
		tillman.setPosition("Right Cornerback");
		tillman.setNumber("33");
		tillman.setAge(29);
		tillman.setInter(5);
		tillman.setIntYrds(127);
		tillman.setSacks(0);
		tillman.setTackles(71);
		defensivelist.add(tillman);
				
		return defensivelist;
	}
	
	

	public String toString() { //the toString method for PlayerManager
		String roster = offensivelist.toString() + defensivelist.toString();
		return roster;
	}

}
