/**
 * @author alexanderpontier - ampontier1
 * CIS175 - Spring 2021
 * Sep 16, 2021
 */
package model;


public class Dinosaur {
	
	
	//initializing variables
	private int id;
	private String species;
	private String color;
	
	//constructors
	public Dinosaur() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Dinosaur(String species, String color) {
		super();
		this.species = species;
		this.color = color;
	}
	
	//getters and setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSpecies() {
		return species;
	}
	public void setSpecies(String species) {
		this.species = species;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	//methods
	public String returnDinos() {
		return this.species + ": " + this.color;
	}
	

}
