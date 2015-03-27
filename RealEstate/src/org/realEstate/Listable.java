/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.realEstate;

/**
 *
 * @author user
 */
public interface Listable {
        //compares the current Listable object to other object, 
	//if those two objects are equal, this method returns a zero.
	//if current object is < other object, returns a negative value.
	//if current object is > other object, returns a positive value.
	public abstract int compareTo(Listable other);
	
	//returns a copy of the current Listable object
	public abstract Listable copy();
            
        
}
