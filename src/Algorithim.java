import java.util.*;
import java.io.*;

public class Algorithim {
    public static void main(String[] args) throws Exception {
        Library[] libraries = {};   // TODO
        int days = 10; // TODO
        PriorityQueue<Library> pQ = new PriorityQueue<Library>();
        Set<Library> completed = new HashSet<Library>();
        Set<Library> notProcessed = new HashSet<Library>();

        long currentScore = 0;
        // in order list of which libraries in order
        LinkedList<Library> libAns = new LinkedList<Library>();

        // find best
        for (int i = 0; i < libraries.length; i++) {
            pQ.getScore(days);               // TODO
            pQ.offer(libraries[i]);
            notProcessed.add(libraries[i]);
        }
        Library currLib = pQ.poll();
        pQ.clear();
        // process best
//        completed.add(currLib);
//        libAns.add(currLib);
        while(days > 0){
            // process current node
            completed.add(currLib);
            notProcessed.remove(currLib);
            libAns.add(currLib);
            days -= currLib.numDays;
            currentScore += currLib.score;                  // TODO
            Set<Book> booksOut = currLib.getScore();        // TODO

            // update adjacent nodes
            // intersect the sets, get new score, and update pQ
            Iterator it = notProcessed.iterator();
            while(it.hasNext()){
                Library i = (Library)it.next();
                long previousScore = i.score;               // TODO
                // intersect and update new score
                i.intersect(booksOut);                      // TODO
                i.getScore(days);                           // TODO
                long newScore = currentScore + i.score;     // TODO
                // re-sort if score changed
                if (newScore > previousScore || !pQ.contains(i)) {
                    pQ.remove(i);
                    i.score = newScore;                     // TODO
                    pQ.offer(i);
                }
                else{
                    i.score = previousScore;                // TODO
                }
            }

            // get next node
            currLib = pQ.poll();
        }
    }
}
