import java.util.*;
import java.io.*;

public class Library {
    Set<Book> bookSet = new HashSet<Book>();
    int numBooks;
    int numDays;
    int booksPerDay;
    PriorityQueue<Book> pQueue;
    public Library(Book[] books, int nB, int nD, int bPD){
        numBooks = nB;
        numDays = nD;
        booksPerDay = bPD;
        for (int i = 0; i < books.length; i++) {
            bookSet.add(books[i]);
        }
        pQueue = new PriorityQueue<Integer>();
    }
    public Book[] getTopN(int n){

    }

    public void remove(Set<Book> book)
    {

    }
}
