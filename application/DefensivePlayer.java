/** Program: Defensive Player
 * File: DefensivePlayer.java
 * Summary: Extends the Player class for defensive players
 * Author: Richard Boyd
 * Date: January 21, 2018
 */

package application;

public class DefensivePlayer extends Player {
	//Defensive Properties
	private int inter; //interceptions
	private int intYrds; //interception yards
	private int sacks; 
	private int tackles;
	
	public DefensivePlayer() { //Constructor
	}
	
	public int getInter() { //getters and setters
		return this.inter;
	}
	
	public void setInter(int newInter) {
		this.inter = newInter;
	}
	
	public int getIntYrds() {
		return this.intYrds;
	}
	
	public void setIntYrds(int newIntYrds) {
		this.intYrds = newIntYrds;
	}
	
	public int getSacks() {
		return this.sacks;
	}
	
	public void setSacks(int newSacks) {
		this.sacks = newSacks;
	}
	
	public int getTackles() {
		return this.tackles;
	}
	
	public void setTackles(int newTackles) {
		this.tackles = newTackles;
	}
	
	public String toString() {   //toString method
		return getName() + ", " + getPosition() + ", " + getNumber() + ", " + getAge() + ", " + inter + ", " + intYrds + ", " + sacks + ", " + tackles;
	}
}
