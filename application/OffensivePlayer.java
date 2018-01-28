/** Program: Offensive Player
 * File: OffensivePlayer.java
 * Summary: Extends the Player class for offensive players
 * Author: Richard Boyd
 * Date: January 21, 2018
 */

package application;

public class OffensivePlayer extends Player {
	//Offensive Properties
	private int passAtt; //Pass Attempts  
	private int passCmp; //Passes Completed
	private int rushAtt; //Rush Attempts
	private int rushYrds; //Rushing Yards
	private int rec;      //Receptions
	private int recYrds;  //Receiving Yards
	
	public OffensivePlayer() { //Constructor
	}
	
	public int getPassAtt() {  //getters and setters
		return this.passAtt;
	}
	public void setPassAtt(int newPassAtt) {
		this.passAtt = newPassAtt;
	}
	
	public int getPassCmp() {
		return this.passCmp;
	}
	public void setPassCmp(int newPassCmp) {
		this.passCmp = newPassCmp;
	}
	
	public int getRushAtt() {
		return this.rushAtt;
	}
	public void setRushAtt(int newRushAtt) {
		this.rushAtt = newRushAtt;
	}
	
	public int getRushYrds() {
		return this.rushYrds;
	}
	public void setRushYrds(int newRushYrds) {
		this.rushYrds = newRushYrds;
	}
	
	public int getRec() {
		return this.rec;
	}
	public void setRec(int newRec) {
		this.rec = newRec;
	}
	
	public int getRecYrds() {
		return this.recYrds;
	}
	public void setRecYrds(int newRecYrds) {
		this.recYrds = newRecYrds;
	}
	
	public float getPassCmpPercent() {   //three getter methods that return a value calculated from other properties
		return ((((float)this.passCmp)/((float)this.passAtt))*100);
	}
	
	public float getYrdsPerRush() {
		return ((((float)this.rushYrds)/((float)this.rushAtt)));
	}
	
	public float getYrdsPerRec() {
		return ((((float)this.recYrds)/((float)this.rec)));
	}
	
	public String toString() {   //toString method
		return getName() + ", " + getPosition() + ", " + getNumber() + ", " + getAge() + ", " + passAtt + ", " + passCmp + ", " + rushAtt + ", " + rushYrds + ", " + rec + ", " + recYrds;
	}
}
