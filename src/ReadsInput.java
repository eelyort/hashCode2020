import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class ReadsInput {
    public static void main(String[] args) throws FileNotFoundException {
        int booktotal, numlib, numdays, numbooks, signupdays, ship;

        File aex = new File("a_example.txt");
        Scanner input_file = new Scanner(aex);
        String data_string = input_file.nextLine();
        String[] data = data_string.split(" ", 3);
        booktotal = Integer.parseInt(data[0]);
        numdays = Integer.parseInt(data[2]);
        numlib = Integer.parseInt(data[1]);
        Book[] x = new Book[booktotal];
        String score_string = input_file.nextLine();
        String score[] = data_string.split(" ", booktotal);


        for (int i = 0; i < numlib; i++) {
            data_string = input_file.nextLine();
            String lib_data[] = data_string.split(" ", 3);
            numbooks = Integer.parseInt(lib_data[0]);
            signupdays = Integer.parseInt(lib_data[2]);
            ship = Integer.parseInt(lib_data[1]);
            data_string = input_file.nextLine();
            String lib_book_data[] = data_string.split(" ", numbooks);
            Book[] y = new Book[numbooks];
            for (int j = 0; j < numbooks; j++) {
                int book_id = Integer.parseInt(lib_book_data[j]);
                y[j] = new Book(book_id, Integer.parseInt(score[book_id]));
            }
            Library z = new Library(x, numbooks, signupdays, ship);
        }
        input_file.close();
    }
}
