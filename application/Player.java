/** Program: Player
 * File: Player.java
 * Summary: Player class for NFL Draft Program
 * Author: Richard Boyd
 * Date:January 14th, 2018
 */

package application;

public abstract class Player {
	
	private String name;  //defines properties
	private String position;
	private String number;
	private int age; 
	
	
	public Player() {	//no argument constructor
	}
	
	public Player(String name1, String position1, String number1, int age1) {
		name = name1;
		position = position1;   //constructor with all arguments
		number = number1;
		age = age1;
	}
	
	public String getName() {   //getters and setters
		return this.name;
	}
	public void setName(String newName) {
		this.name = newName;
	}
	
	public String getPosition() {
		return this.position;
	}
	public void setPosition(String newPosition) {
		this.position = newPosition;
	}
	
	public String getNumber() {
		return this.number;
	}
	
	public void setNumber(String newNumber) {
		this.number = newNumber;
	}
	
	public int getAge() {
		return this.age;
	}
	public void setAge(int newAge) {
		this.age = newAge;
	}
	
	public String toString() {   //toString method
		return name + ", " + position + ", " + number + ", " + age;
	}
	
}
