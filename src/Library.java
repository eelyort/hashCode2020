import java.util.*;
import java.io.*;

public class Library {
    Set<Book> bookSet = new HashSet<Book>();
    int numBooks;
    int numDays;
    int booksPerDay;
    PriorityQueue<Book> pQueue;
    int lastVal;
    public Library(Book[] books, int nB, int nD, int bPD){
        numBooks = nB;
        numDays = nD;
        booksPerDay = bPD;
        for (int i = 0; i < books.length; i++) {
            bookSet.add(books[i]);
        }
        pQueue = new PriorityQueue<Integer>();
        lastVal = 0;
    }
    public Book[] getTopN(int n){

    }

    public void remove(Set<Book> book)
    {
        
    }

    public Set<Book> score(int time)
    {

    }

    public int calcBookValues(Set<Book> book, int num)
    {
        PriorityQueue<Integer> pq = SetPQ(book);
        Book a;
        int sum = 0;
        for(int x = 0; x<num; x++)
        {
            a = pq.poll();
            sum += a.getValue();
        }
        return sum;
    }

    public PriorityQueue<Integer> SetPQ(Set<Book> book)
    {
        Iterator<Integer> itr = book.Iterator();
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        while(itr.hasNext())
        {
            pq.add(itr);
        }
        return pq;
    }

    public int getBooks()
    {
        return numBooks;
    }

    public int getDays()
    {
        return numDays;
    }

    public int getBPD()
    {
        return booksPerDay;
    }
}
