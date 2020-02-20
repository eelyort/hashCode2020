import java.util.*;
import java.io.*;


public class Library {
    Set<Book> bookSet = new HashSet<Book>();
    int id;
    int numBooks;
    int numDays;
    int booksPerDay;
    long lastVal;
    public Library(int libID, Book[] books, int nB, int nD, int bPD){
        id = libID;
        numBooks = nB;
        numDays = nD;
        booksPerDay = bPD;
        for (int i = 0; i < books.length; i++) {
            bookSet.add(books[i]);
        }
        lastVal = 0;
    }

    public void remove(Set<Book> book)
    {
        Set<Book> temp = book;
        Iterator<Book> itr = temp.iterator();
        while(itr.hasNext())
        {
            if(bookSet.contains(itr.next()))
            {
                bookSet.remove(itr.next());
            }
        }
        lastVal = calcTotalValue();
    }

    public Set<Book> score(int time)
    {
        time-=numDays;
        int num = time*booksPerDay;
        PriorityQueue<Book> pq = SetPQ(bookSet);
        Set<Book> ret = new HashSet<Book>();
        for(int x = 0; x<num; x++)
        {
            ret.add(pq.poll());
        }
        lastVal = calcTotalValue();
        return ret;
    }

    public long calcTotalValue()
    {
        Iterator<Book> itr = bookSet.iterator();
        long sum = 0;
        while(itr.hasNext())
        {
            Book temp = itr.next();
            sum+=temp.getValue();
        }
        return sum;
    }
    //i forgot what this does lol
    /*
    public int calcBookValues(Set<Book> book, int num)
    {
        PriorityQueue<Integer> pq = SetPQ(book);
        Book a;
        int sum = 0;
        num*=booksPerDay;
        for(int x = 0; x<num; x++)
        {
            a = pq.poll();
            sum += a.getValue();
        }
        return sum;
    }
    */
    public PriorityQueue<Book> SetPQ(Set<Book> book)
    {
        Iterator<Book> itr = book.iterator();
        PriorityQueue<Book> pq = new PriorityQueue<Book>();
        while(itr.hasNext())
        {
            pq.add(itr.next());
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

    public int getID()
    {
        return id;
    }

    public String toString()
    {
        String ret = "LibID: " + id + "\nnumBooks: " + numBooks + "\nnumDays: " + numDays + "\nbooksPerDay: " + booksPerDay + "\nLastValue: " + lastVal;
        return ret;
    }
}
