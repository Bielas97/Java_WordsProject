import java.io.*;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

/**
 * Created by Kuba on 2017-03-24.
 */
public class WordDatabase {

    private Vector<word> wordVector;


    public Vector<word> getWordVector() {
        return wordVector;
    }

    public void setWordTab(Vector<word> wordTab) {
        this.wordVector.addAll(wordTab);
    }

    //pick the worst word
    public word randomWord(){

        word x = wordVector.elementAt(0);
        double d;
        double maxD = 0.0;
        double zeroCounter = 0.0;

        Vector<Integer> vec = new Vector<>();


        for (int i = 0; i < wordVector.size(); i++) {
            for (int j = 0; j < wordVector.elementAt(i).getStats().length(); j++) {
                vec.add(Character.getNumericValue(wordVector.elementAt(i).getStats().charAt(j)));
                if(Character.getNumericValue(wordVector.elementAt(i).getStats().charAt(j)) == 0) zeroCounter++;
            }
            d = zeroCounter / vec.size();
            if(d > maxD) {
                maxD = d;
                x = wordVector.elementAt(i);
            }

            zeroCounter = 0.0;
            vec.clear();

        }
        return x;
    }

    /*public void saveFile(String fileName){
        try {
            FileWriter file = new FileWriter(fileName, false);
            PrintWriter pw = new PrintWriter(file);
            for (int i = 0; i < wordVector.size(); i++) {
                //jak to zapisac zeby bylo tak jak aktualnie jest w pliku words.txt
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/



    //get words form txt
    public WordDatabase(String fileName){

        try {
            FileReader read = new FileReader(fileName);
            Scanner scan = new Scanner(read);

            wordVector = new Vector<word>();

            while(scan.hasNextLine()){
                String[] line = scan.nextLine().split(" ");
                wordVector.add(new word(line[0], line[1], line[2], line[3], line[4]));
            }

            scan.close();

            /*for(word w : wordVector ){
                System.out.println(w + " ");
            }*/

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


}
