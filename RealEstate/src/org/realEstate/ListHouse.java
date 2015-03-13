package org.realEstate;

public class ListHouse implements Listable {
	//Variables to store information of a house
	private String lastName;
	private String firstName;
	private int lotNumber;
	private int price;
	private int squareFeet;
	private int bedRooms;
	
	//Declare a list of Listable objects
	protected Listable list[];
	
	//Variable to store the number of items in the list
	protected int numHouses;
	
	//variable to store the current position that has been accessed, of the list
	protected int currentIndex;
	
	//Constructor which assign the house information to variables
	public ListHouse(String lastName, String firstName, int lotNumber,int price, int squareFeet, int bedRooms )
	{
		this.lastName = lastName;
		this.firstName = firstName;
		this.lotNumber = lotNumber;
		this.price = price;
		this.squareFeet = squareFeet;
		this.bedRooms = bedRooms;
	}
	
	//default constructor initializes the number of  items and list
	public ListHouse(){
		numHouses=0;
		list = new Listable[100];
	}
	
	//compare the current Listable object to other object,
	//if those two objects are equal,this method returns a zero.
	//if current object is < other object, returns a negative value.
	//if current object is > other object, returns a positive value.
	public int compareTo(Listable otherListHouse){
		ListHouse other = (ListHouse)otherListHouse;
		return (this.lotNumber - other.lotNumber);
	}
	
	//returns a copy of the current listable object
	public Listable copy(){
		ListHouse result = new ListHouse(lastName, firstName, lotNumber, price, squareFeet, bedRooms);
		return result;
	}
	
	//returns the respective house information values.
	public String lastName()
	{
		return lastName;
	}
	
	public String firstName()
	{
		return firstName;
	}
	public int price()
	{
		return price;
	}
	public int sqareFeet()
	{
		return squareFeet;
	}
	public int bedRooms()
	{
		return bedRooms;
	}
}
