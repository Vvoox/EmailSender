package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;

public class Main extends Application {



    @Override
    public void start(Stage primaryStage) throws Exception{
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Image icon = new Image(Main.class.getResourceAsStream("Image/1.png"));
        primaryStage.getIcons().add(icon);
        primaryStage.setTitle("Email Sender");
        primaryStage.setScene(new Scene(root, screenWidth, screenHeight));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

