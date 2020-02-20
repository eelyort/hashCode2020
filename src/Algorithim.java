import java.util.*;
import java.io.*;

public class Algorithim {
    public static void main(String[] args) throws Exception {
        // ReadsInput --------------------------------------------------
        int booktotal, numlib, totalDays, numbooks, signupdays, ship;

        // Open file
        File aex = new File("a_example.txt");
        Scanner input_file = new Scanner(aex);

        // Read gen info
        String data_string = input_file.nextLine();
        String[] data = data_string.split(" ", 3);

        // Stores gen info
        booktotal = Integer.parseInt(data[0]);
        totalDays = Integer.parseInt(data[2]);
        numlib = Integer.parseInt(data[1]);
        Library[] libraries = new Library[numlib];

        Book[] x = new Book[booktotal];
        String score_string = input_file.nextLine();
        String score[] = score_string.split(" ", booktotal);

        // Reads through library information
        for (int i = 0; i < numlib; i++) {

            // Reads and stores general library info
            data_string = input_file.nextLine();
            String lib_data[] = data_string.split(" ", 3);
            numbooks = Integer.parseInt(lib_data[0]);
            signupdays = Integer.parseInt(lib_data[2]);
            ship = Integer.parseInt(lib_data[1]);

            // Reads books info line
            data_string = input_file.nextLine();
            String lib_book_data[] = data_string.split(" ", numbooks);

            // Creates array of books in library
            Book[] y = new Book[numbooks];
            for (int j = 0; j < numbooks; j++) {
                int book_id = Integer.parseInt(lib_book_data[j]);
                y[j] = new Book(book_id, Integer.parseInt(score[book_id]));
            }
            libraries[i] = new Library(i, x, numbooks, signupdays, ship);
        }

        // Close file
        input_file.close();
        // ------------------------------------
        
        PriorityQueue<Library> pQ = new PriorityQueue<Library>();
        Set<Library> completed = new HashSet<Library>();
        Set<Library> notProcessed = new HashSet<Library>();

        long currentScore = 0;

        // in order list of which libraries in order
        LinkedList<Library> libAns = new LinkedList<Library>();
        LinkedList<Set<Book>> booksFromLib = new LinkedList<Set<Book>>();

        // find best
        for (int i = 0; i < libraries.length; i++) {
            libraries[i].score(totalDays);               // TODO
            pQ.offer(libraries[i]);
            notProcessed.add(libraries[i]);
        }
        Library currLib = pQ.poll();
        pQ.clear();
        // process best
//        completed.add(currLib);
//        libAns.add(currLib);
        while(totalDays > 0){
            // process current node
            completed.add(currLib);
            notProcessed.remove(currLib);
            libAns.add(currLib);
            totalDays -= currLib.numDays;
            currentScore += currLib.lastVal;
            Set<Book> booksOut = currLib.score(totalDays);
            booksFromLib.add(booksOut);

            // update adjacent nodes
            // intersect the sets, get new score, and update pQ
            Iterator it = notProcessed.iterator();
            while(it.hasNext()){
                Library i = (Library)it.next();
                long previousScore = i.lastVal;
                // intersect and update new score
                i.remove(booksOut);
                i.score(totalDays);
                long newScore = currentScore + i.lastVal;
                // re-sort if score changed
                if (newScore > previousScore || !pQ.contains(i)) {
                    pQ.remove(i);
                    i.lastVal = newScore;
                    pQ.offer(i);
                }
                else{
                    i.lastVal = previousScore;
                }
            }

            // get next node
            currLib = pQ.poll();
        }

    }
}
