import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Random;

import static java.awt.SystemColor.text;

/**
 * Created by Kuba on 2017-03-24.
 *
 * Usage of app:
 * User is asked to translate word from english to polish or the opposite
 * if the translation is wrong than "0" is added to stats, if opposite "1" is added
 * The program first want user to translate words the have the worst stats
 */
public class Main extends Application {

    Stage window;
    Button bClose;
    word currentWord;

    public static void main(String[] args) {
        launch(args);
    }

    public static String polOrEng(word w){
        Random rnd = new Random();

        if(rnd.nextInt()%2 == 0){
            return w.getEngWord();
        }
        else{
            return w.getPolWord();
        }
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;

        WordDatabase wordDatabase = new WordDatabase("words.txt");
        Random rnd = new Random();
        String message = new String();


        bClose = new Button("exit");

        bClose.setOnAction(e-> window.close());


        VBox center = new VBox(10);
        Button bSubmit = new Button("submit");
        TextField txtField = new TextField();
        Label text = new Label();
        //txtField.setPromptText("enter your answer here...");

        currentWord = wordDatabase.randomWord();

        text.setText(polOrEng(currentWord));


        bSubmit.setOnAction(e->{

            if(text.getText().equals(currentWord.getEngWord())){

                if(!txtField.getText().equals(currentWord.getPolWord())){

                    AlertBox.display("false", "false");
                    currentWord.add0();
                }
                else{
                    currentWord.add1();
                }
                if(!AlertBox.isAgain()) {
                    currentWord = wordDatabase.randomWord();

                    text.setText(polOrEng(currentWord));
                }
            }
            else {
                if(!txtField.getText().equals(currentWord.getEngWord())){
                    AlertBox.display("false", "false");
                    currentWord.add0();
                }
                else{
                    currentWord.add1();
                }
                if(!AlertBox.isAgain()) {

                    currentWord = wordDatabase.randomWord();

                    text.setText(polOrEng(currentWord));
                }
            }

        });

        center.getChildren().addAll(text, txtField, bSubmit);

        StackPane bottom = new StackPane();
        bottom.getChildren().add(bClose);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(center);
        borderPane.setBottom(bottom);

        Scene scene = new Scene(borderPane, 300 , 200);
        window.setScene(scene);
        window.show();

    }
}
