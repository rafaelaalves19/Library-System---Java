/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rafalibrary;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


/**
 *
 * @author rafaelaalves
 */
public class Infos {
    
    
    //Method to load the complete books list
    public ArrayList<Books> loadBooks() throws FileNotFoundException {
        FileInputStream file = new FileInputStream("books.txt");
        String strline = "";
        ArrayList<Books> books = new ArrayList<>();
        try ( BufferedReader br = new BufferedReader(new InputStreamReader(file))) {
            strline = br.readLine();
            while (strline != null) {
                String[] parts = strline.split(",");
                books.add(new Books(Integer.parseInt(parts[0]), parts[1], parts[2]));
                strline = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return books;
    }

     
    //Method to load all the readers
    public ArrayList<Readers> loadReaders() throws FileNotFoundException {
        FileInputStream file = new FileInputStream("readers.txt");
        String strline = "";
        ArrayList<Readers> readers = new ArrayList<Readers>();
        try ( BufferedReader br = new BufferedReader(new InputStreamReader(file))) {
            strline = br.readLine();
            while (strline != null) {
                String[] parts = strline.split(",");
                readers.add(new Readers(Integer.parseInt(parts[0]), parts[1], parts[2]));
                strline = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return readers;
    }
    
    
    //Method to list all the books which are borrowed
    public ArrayList<Borrows> BorrowsList(int id) throws FileNotFoundException {
        FileInputStream file = new FileInputStream("borrows.txt");
        String strline = "";
        ArrayList<Borrows> borrows = new ArrayList<Borrows>();
        ArrayList<Borrows> newList = new ArrayList<Borrows>();
        try ( BufferedReader br = new BufferedReader(new InputStreamReader(file))) {
            strline = br.readLine();
            while (strline != null) {
                String[] parts = strline.split(",");
                borrows.add(new Borrows(Integer.parseInt(parts[0]), parts[1], parts[2]));
                strline = br.readLine();
            }
            for (int i = 0; i< borrows.size(); i++){
                if (id == borrows.get(i).idReader ){
                    newList.add(borrows.get(i));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return borrows;
    }
        

    //Method to search a book by title
    public boolean searchBookByTitle(ArrayList<Books> book, String title) {
        boolean found = false;
        for (Books b : book) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                System.out.println(b);
                found = true;
            }
        }
        if (found == false) {
            System.out.println("Book not found");
        }
        return found;
    }

    
    //Method to search a book by author
    public boolean searchBookByAuthor(ArrayList<Books> book, String author) {
        boolean found = false;
        for (Books b : book) {
            if (b.getAuthor().equalsIgnoreCase(author)) {
                System.out.println(b);
                found = true;
            }
        }
        if (found == false) {
            System.out.println("Author not found");
        }
        return found;
    } 

    
    //Method to search a reader by name 
    public boolean searchReaderByName(ArrayList<Readers> reader, String name) {
        boolean found = false;
        for (Readers r : reader) {
            if (r.getName().equalsIgnoreCase(name)) {
                System.out.println(r);
                return found = true;
            }
        }
        if (found == false) {
            System.out.println("Reader not found");
            return found;
        }
        return found;
    }

    
    //Method to search a reader by Id 
    public boolean searchReaderById(ArrayList<Readers> reader, int id) {
        boolean found = false;
        for (Readers r : reader) {
            if (r.getId() == id) {
                System.out.println(r);
                return found = true;
            }
        }
        if (found == false) {
            System.out.println("Reader not found");
            return found;
        }
        return found;
    }

    
    //Method to list a book by title
    public ArrayList<Books> sortBooksByTitle(ArrayList<Books> books) {
        for (int i = 0; i < books.size(); i++) {
            for (int j = 0; j < books.size() -1; j++) {
                if ( books.get(j).getTitle().compareTo(books.get(j + 1).getTitle())>0 ) {
                    Books temp = books.get(j);
                    books.set(j, books.get(j + 1));
                    books.set(j + 1, temp);
                }
            }
        }
        return books;
    }
    
    
    //Method to list a book by author
    public ArrayList<Books> sortBooksByAuthor(ArrayList<Books> books) {
        for (int i = 0; i < books.size(); i++) {
            for (int j = 0; j < books.size() -1; j++) {
                if ( books.get(j).getAuthor().compareTo(books.get(j + 1).getAuthor())>0 ) {
                    Books temp = books.get(j);
                    books.set(j, books.get(j + 1));
                    books.set(j + 1, temp);
                }
            }
        }
        return books;
    } 
    
    
    //Method to list the readers by Id
    public ArrayList<Readers> sortReadersById(ArrayList<Readers> readers) {
        for (int i = 0; i < readers.size(); i++) {
            for (int j = 0; j < readers.size() - 1; j++) {
                if(readers.get(j).getId() > readers.get(j + 1).getId()){
                    Readers temp = readers.get(j);
                    readers.set(j, readers.get(j + 1));
                    readers.set(j + 1, temp);
                }
            }
        }
        return readers;
    }


    //Method to list the readers by name
    public ArrayList<Readers> sortReadersByName(ArrayList<Readers> readers) {
        for (int i = 0; i < readers.size(); i++) {
            for (int j = 0; j < readers.size() -1; j++) {
                if (readers.get(j).getName().compareTo(readers.get(j + 1).getName())>0 ) {
                    Readers temp = readers.get(j);
                    readers.set(j, readers.get(j + 1));
                    readers.set(j + 1, temp);
                }
            }
        }
        return readers;
    }


    //Method to borrow a book 
    public String registerBorrow(String[] borrows) throws IOException {
        try {
            BufferedWriter writeBorrow = new BufferedWriter(new FileWriter("borrows.txt", true));
            writeBorrow.write(borrows[0] + "," + borrows[1] + "," + borrows[2] + "\n");
            writeBorrow.close();
        } catch (IOException e) {
            System.out.println("An error has ocurred");
            e.printStackTrace();
        }
        return "Sucessful borrow. Enjoy your reading!";
    }


    //Method to return a book
    public String registerReturn(String[] returnArray) throws IOException {
        try {
            BufferedWriter writeReturn = new BufferedWriter(new FileWriter("returns.txt", true));
            writeReturn.write(returnArray[0] + "," + returnArray[1] + "," + returnArray[2] + "\n");
            writeReturn.close();
        } catch (IOException e) {
            System.out.println("An error has ocurred");
            e.printStackTrace();
        }
        return "Sucessful return. Thank you!";
    }
}
