/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rafalibrary;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author rafaelaalves
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
      
        Infos data = new Infos();
        
       ArrayList<Books> myBooks = data.loadBooks();
       ArrayList<Readers> myReaders = data.loadReaders();
       Scanner sc = new Scanner(System.in);
       Boolean loop = true;
       
       
       //Setting library menu:
       do{
           System.out.println(" Welcome to Rafa's Library System ");
           System.out.println("***********************************");
           System.out.println(" 1 | Searching a book by author ");
           System.out.println(" 2 | Searching a book by title ");
           System.out.println(" 3 | Listing a book by author ");
           System.out.println(" 4 | Listing a book by title ");
           System.out.println(" 5 | Searching a reader by name ");
           System.out.println(" 6 | Searching a reader by Id ");
           System.out.println(" 7 | Listing a reader by Id ");
           System.out.println(" 8 | Listing a reader by name ");
           System.out.println(" 9 | Borrowing a book ");
           System.out.println("10 | Returning a book ");
           System.out.println("11 | Reader's borrow list ");
           System.out.println("0 | Exit ");
           System.out.println("***********************************");
           System.out.println("Please choose an option in the menu");
           try{
               int input = Integer.parseInt(sc.nextLine());
               switch (input){
                   
                   
                   //CASES SETS//
                
                    //Searching a book by author
                    case 1:
                       System.out.println("Please enter the author's name:");
                       String author = sc.nextLine();
                       System.out.println(data.searchBookByAuthor(myBooks, author));
                       break;
                       
                       
                    //Searching a book by title   
                    case 2:
                       System.out.println("Please enter a book title:");
                       String title = sc.nextLine();
                       System.out.println(data.searchBookByTitle(myBooks, title));
                       break;
                       
                       
                    //Listing a book by author    
                    case 3:
                       System.out.println("Listing every books by author:");
                       System.out.println(data.sortBooksByAuthor(myBooks));
                       break;
                       
                       
                    //Listing a book by title    
                    case 4:
                       System.out.println("Listing books by title:");
                       System.out.println(data.sortBooksByAuthor(myBooks));
                       break;
                       
                       
                    //Searching a reader by name   
                   case 5:
                        System.out.println("Please enter the reader's name:");
                        String name = sc.nextLine();
                        System.out.println(data.searchReaderByName(myReaders, name));
                        break;
                    
                        
                    //Searching a reader by Id     
                    case 6:
                        System.out.println("Please enter the reader's Id:");
                        String id = sc.nextLine();
                        System.out.println(data.searchReaderById(myReaders, Integer.parseInt(id)));
                        break;
                   
                        
                    //Listing a reader by Id    
                    case 7:
                        System.out.println("Listing the readers:");
                        System.out.println(data.sortReadersById(myReaders));
                        break;
                   
                        
                    //Listing a reader by name     
                    case 8:
                        System.out.println("Listing the readers by name:");
                        System.out.println(data.sortReadersByName(myReaders));
                        break;
                        
                        
                    //Borrowing a book    
                    case 9:
                       System.out.println("Please enter the reader's Id:");
                       String idReader = sc.nextLine();
                       
                       System.out.println("Please enter the book's name:");
                       String Namebook = sc.nextLine();
                       
                       DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                       LocalDateTime now = LocalDateTime.now();
                       String dateStr = dt.format(now);
                       
                       String[] array = {idReader, Namebook, dateStr};
                               
                               data.registerBorrow(array);
                               break;
                               
                     
                    //Returning a book           
                    case 10:
                       System.out.println("Please enter the reader's Id:");
                       String readerId = sc.nextLine();
                       
                       System.out.println("Please enter the book's name:");
                       String bookName = sc.nextLine();
                       
                       DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                       LocalDateTime dateNow = LocalDateTime.now();
                       String strDate = date.format(dateNow);
                       
                       String[] arrayToReturn = {readerId, bookName, strDate};
                               
                               data.registerReturn(arrayToReturn);
                               break;
                               
                               
                    //Reader's borrow list           
                    case 11:
                       System.out.println("Please enter the reader's Id:");
                       String borrowReaderId = sc.nextLine();
                       System.out.println(data.BorrowsList(Integer.parseInt(borrowReaderId)));
                       break;
                               
                       
                    //Exit           
                    case 0: 
                       loop = false;
                        break;
                                 
               }
           }catch(NumberFormatException e){
               System.out.println(e);
               
           }
       }while(loop);
      
      
 
    }
    
}