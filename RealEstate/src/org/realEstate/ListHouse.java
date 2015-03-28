/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.realEstate;

/**
 *
 * @author user
 */
public class ListHouse implements Listable {
//Variable to store information in the house
    private int lotNumber;
    private String firstName;
    private String lastName;
    private int price;
    private int squareFeet;
    private int bedRooms;
   // Declare a Listable objects
    protected Listable list[];
    //Variabe to store the number of items in the list
    protected int numHouses;
    //Variable to store the current position that has been accessed, of the list
    protected int currentIndex;
    
    
    //Constructor which assign the house information to the variables
    public ListHouse(int lotNumber, String firstName, String lastName,
            int price, int squareFeet, int bedRooms){
  
    this.lotNumber = lotNumber;
    this.firstName = firstName;
    this.lastName = lastName;
    this.price = price;
    this.squareFeet = squareFeet;
    this.bedRooms = bedRooms;
   
    }
    
   // Default constructor.Initializes the number of items and the list  
    public ListHouse(){
        numHouses = 0;
        list = new Listable[100];
    }
    
    @Override
    
    // Compares to the Current Listable object to the other objects,
    //if those two objects are equal. this methods returns a zero.
    //if current object is < other object,returns a negative value.
    //if the current objects is > other object, returns a positive value.
    public int compareTo(Listable otherListHouse){
        
      ListHouse other = (ListHouse) otherListHouse;
      return(this.lotNumber - other.lotNumber);
    }
            
    @Override        
     //returns the copy of the current Listable object        
      public Listable copy(){
       ListHouse houseCopy = new ListHouse(lotNumber,firstName,lastName,price,
               squareFeet,bedRooms);
       return houseCopy;
    }    
            
    // returns the respective house information values        
     public String getLastName(){
        return lastName; 
     }       
     public String getFirstName(){
         return firstName;
     }
     public int getLotNumber(){
         return lotNumber;
     }
     public int getPrice(){
         return price;
     }
     public int getSquareFeet(){
         return squareFeet;
     }
     public int getBedRooms(){
         return bedRooms;
     }
}
