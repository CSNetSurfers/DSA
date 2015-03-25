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
	
	//shows the next item on the list. 
	//If there are no more items on the list, then shows items from the beginning of the list
	public Listable nextHouse(){
	Listable next = list[currentIndex];
	if (currentIndex == numHouses-1)
	currentIndex = 0;
	else
	currentIndex++;
	return next.copy();
	}
	
	//returns whether a house that we are searching for, is in the list or not
	public boolean find (Listable searchedHouse){
	int compareResult;
	int mid;
	int first = 0;
	int last = numHouses - 1;
	boolean searchFlag = (first <= last);
	boolean found = false;
	while (searchFlag && !found)
	{
	mid = (first + last) / 2;
	compareResult = searchedHouse.compareTo(list[mid]);
	if (compareResult == 0)
	found = true;
	else if (compareResult < 0) // item is less than element at location
	{
	last = mid - 1;
	searchFlag = (first <= last);
	}
	else // item is greater than element at location
	{
	first = mid + 1;
	searchFlag = (first <= last);
	}
	}
	return found;
	}
	
	//returns the exact copy of a given item, if it is in the list
	public Listable getHouse (Listable searchedHouse){
	int compareResult;
	int first = 0;
	int last = numHouses - 1;
	int mid = (first + last) / 2;
	boolean found = false;
	while (!found)
	{
	mid = (first + last) / 2;
	compareResult = searchedHouse.compareTo(list[mid]);
	if (compareResult == 0)
	found = true;
	else if (compareResult < 0) // item is less than element at location
	last = mid - 1;
	else // item is greater than element at location
	first = mid + 1;
	}
	return list[mid].copy();
	}
	
	//Adds a copy of the new item to the list
	public void add (Listable searchedHouse)
	
	{
	int location = 0;
	boolean searchFlag = (location < numHouses);
	while (searchFlag)
	{
	if (searchedHouse.compareTo(list[location]) < 0) // item is less
	searchFlag = false;
	else // item is more
	{
	location++;
	searchFlag = (location < numHouses);
	}
	}
	for (int index = numHouses; index > location; index--)
	list[index] = list[index - 1];
	list[location] = searchedHouse.copy();
	numHouses++;
	}
	
	//deletes a given item from the list.
	public void delete (Listable searchedHouse){
	int location = 0;
	while (searchedHouse.compareTo(list[location]) != 0)
	location++;
	for (int index = location + 1; index < numHouses; index++)
	list[index - 1] = list[index];
	numHouses--;
	}
}
