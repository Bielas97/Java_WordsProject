import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Created by Kuba on 2017-03-24.
 */
public class AlertBox {

    static boolean again;

    public static boolean isAgain() {
        return again;
    }

    public static void display(String title, String message){


        Stage window = new Stage();



        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);



        Label label = new Label(message);
        Button bAgain = new Button("again");
        Button bNext = new Button("next!");
        bAgain.setOnAction(e-> {
            again = true;
            window.close();
        });
        bNext.setOnAction(e -> {
            again = false;
            window.close();
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, bAgain, bNext);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }
}
