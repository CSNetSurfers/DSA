/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.realEstate;

/**
 *
 * @author user
 */
public class SortedList extends ListHouse{
    
    //Constructor which takes and passes values of house information to super class constructor.
	public SortedList(int lotNumber, String firstName, String lastName,
			int price, int squareFeet, int bedRooms) {
		super(lotNumber, firstName, lastName, price, squareFeet, bedRooms);
	
	}
	
	//default constructor
	public SortedList(){
		super();
	}
	
	//returns whether the list is full
	public boolean isFull(){
		return (list.length == numHouses);
	}

	//returns the length of the list
	public int size(){
	return numHouses;
	}
	
	//sets the current position of the list to its beginning
	public void reset(){
	currentIndex = 0;
	}

    
}
