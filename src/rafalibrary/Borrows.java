/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rafalibrary;

/**
 *
 * @author rafaelaalves
 */
public class Borrows {
    
    int idReader;
    String nameBook;
    String dateBorrow;
    
    public Borrows(int idReader, String nameBook, String date){
        this.idReader = idReader;
        this.nameBook = nameBook;
        this.dateBorrow = date;
}

    Borrows(String part) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String toString(){
        return "Reader Id: " + idReader + "\n" +
                "Book: " + nameBook + "\n" +  
                "Borrowing on: " + dateBorrow + "\n";
    }
    
    
}
