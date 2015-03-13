package org.realEstate;

public class SortedList extends ListHouse {

	//Constructor which takes and passes values of house information to super class constructor.
		public SortedList(String lastName, String firstName, int lotNumber,
				int price, int squareFeet, int bedRooms) {
			super(lastName, firstName, lotNumber, price, squareFeet, bedRooms);
		
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
		public int lengthIs(){
		return numHouses;
		}
		
		//sets the current position of the list to its beginning
		public void reset(){
		currentIndex = 0;
		}
		
		//shows the next item on the list. 
		//If there are no more items on the list, then shows items from the beginning of the list
		public Listable getNextItem (){
		Listable next = list[currentIndex];
		if (currentIndex == numHouses-1)
		currentIndex = 0;
		else
		currentIndex++;
		return next.copy();
		}
		
		//returns whether a house that we are searching for, is in the list or not
		public boolean isThere (Listable searchedHouse){
		int compareResult;
		int midPoint;
		int first = 0;
		int last = numHouses - 1;
		boolean moreToSearch = (first <= last);
		boolean found = false;
		while (moreToSearch && !found)
		{
		midPoint = (first + last) / 2;
		compareResult = searchedHouse.compareTo(list[midPoint]);
		if (compareResult == 0)
		found = true;
		else if (compareResult < 0) // item is less than element at location
		{
		last = midPoint - 1;
		moreToSearch = (first <= last);
		}
		else // item is greater than element at location
		{
		first = midPoint + 1;
		moreToSearch = (first <= last);
		}
		}
		return found;
		}
		
		//returns the exact copy of a given item, if it is in the list
		public Listable retrieve (Listable searchedHouse){
		int compareResult;
		int first = 0;
		int last = numHouses - 1;
		int midPoint = (first + last) / 2;
		boolean found = false;
		while (!found)
		{
		midPoint = (first + last) / 2;
		compareResult = searchedHouse.compareTo(list[midPoint]);
		if (compareResult == 0)
		found = true;
		else if (compareResult < 0) // item is less than element at location
		last = midPoint - 1;
		else // item is greater than element at location
		first = midPoint + 1;
		}
		return list[midPoint].copy();
		}
		
		//Adds a copy of the new item to the list
		public void insert (Listable searchedHouse)
		
		{
		int location = 0;
		boolean moreToSearch = (location < numHouses);
		while (moreToSearch)
		{
		if (searchedHouse.compareTo(list[location]) < 0) // item is less
		moreToSearch = false;
		else // item is more
		{
		location++;
		moreToSearch = (location < numHouses);
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
