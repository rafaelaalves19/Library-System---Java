/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rafalibrary;

import java.util.Date;

/**
 *
 * @author rafaelaalves
 */
public class Returns {
    int idReader;
    String nameBook;
    Date dateReturn;
    
    public Returns(int idReader, String nameBook, Date date){
        this.idReader = idReader;
        this.nameBook = nameBook;
        this.dateReturn = date;
    }
    
    @Override
    public String toString(){
        return "Reader Id: " + idReader + "\n" +
                "Book: " + nameBook + "\n" +
                "Returning on: " + dateReturn;
        
        
        
    }
}
