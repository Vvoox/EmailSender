package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.*;
import java.io.*;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class Controller {
        public static DriverManager MySQLConnection;
        public static List<String> EmailList = new ArrayList<>();

        @FXML
        private javafx.scene.control.Button closeButton;
        @FXML
        private javafx.scene.control.Button insert;
        @FXML
        private javafx.scene.control.TextArea emailslist;
        @FXML
        public  javafx.scene.control.TextArea message;

        @FXML
        private javafx.scene.control.TextField login;
        @FXML
        private javafx.scene.control.TextField emailsender;
        @FXML
        private javafx.scene.control.PasswordField passwordsender;
        @FXML
        private javafx.scene.control.TextField subjectsender;

        @FXML
        private javafx.scene.control.TextField password;
        @FXML
        private javafx.scene.control.TextField nm;
        @FXML
        private javafx.scene.control.TextField em;
        @FXML
        private javafx.scene.control.PasswordField ps;
        @FXML
        private javafx.scene.control.PasswordField reps;

        static Stage primaryStage = new Stage();
        static String Name = "";


        private void closelastButtonAction(){

                Stage stage = (Stage) closeButton.getScene().getWindow();

                stage.close();

        }

        public void closeButtonAction() {

                Stage stage = (Stage) closeButton.getScene().getWindow();
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Warnning");
                alert.setHeaderText("You want to close the program ?");
                alert.setContentText("Select Ok for closing");

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                        stage.close();
                } else {
                        alert.close();

                }
        }

        public void check() throws Exception {

                String email = login.getText();
                String ps = password.getText();
                if(DBConnection.isConnected(email,ps)){

                        Stage stage = (Stage) closeButton.getScene().getWindow();
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setTitle("Information");
                        alert.setHeaderText("Welcome " + DBConnection.getname(email));
                        alert.setContentText("For continue select Ok");

                        Optional<ButtonType> result = alert.showAndWait();
                        if (result.get() == ButtonType.OK) {
                                stage.close();
                                home();
                        } else {
                                alert.close();

                        }
                }
                else{

                        Stage stage = (Stage) closeButton.getScene().getWindow();
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Warning");
                        alert.setHeaderText("You insert incorrect Email/Password");
                        alert.setContentText("For continue select Ok");

                        Optional<ButtonType> result = alert.showAndWait();
                        if (result.get() == ButtonType.OK) {
                                alert.close();
                        } else {
                                alert.close();

                        }
                }

                //signup();
//                JavaEmail.email
            //JavaEmail test = new JavaEmail();

        }
        public void home() throws Exception{
                primaryStage.close();
                closelastButtonAction();
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                int screenHeight = screenSize.height;
                int screenWidth = screenSize.width;
                Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
                javafx.scene.image.Image icon = new Image(Main.class.getResourceAsStream("Image/1.png"));
                primaryStage.getIcons().add(icon);
                primaryStage.setTitle("EmailSender");
                primaryStage.setScene(new Scene(root, screenWidth, screenHeight));
                primaryStage.show();
        }
        public void start() throws Exception{
                primaryStage.close();
                closelastButtonAction();
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                int screenHeight = screenSize.height;
                int screenWidth = screenSize.width;
                Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
                javafx.scene.image.Image icon = new Image(Main.class.getResourceAsStream("Image/1.png"));
                primaryStage.getIcons().add(icon);
                primaryStage.setTitle("EmailSender");
                primaryStage.setScene(new Scene(root, screenWidth, screenHeight));
                primaryStage.show();
        }
        public void signup() throws Exception{
                primaryStage.close();
                closelastButtonAction();
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                int screenHeight = screenSize.height;
                int screenWidth = screenSize.width;
                Parent root = FXMLLoader.load(getClass().getResource("signup.fxml"));
                javafx.scene.image.Image icon = new Image(Main.class.getResourceAsStream("Image/1.png"));
                primaryStage.getIcons().add(icon);
                primaryStage.setTitle("EmailSender");
                primaryStage.setScene(new Scene(root, screenWidth, screenHeight));
                primaryStage.show();
        }
        public void isSignUp() throws Exception {
                String name = nm.getText();
                String email = em.getText();
                String password = ps.getText();
                String repassword = reps.getText();

                if(name.equals("") || email.equals("") || password.equals("") || repassword.equals("")){
                        Stage stage = (Stage) closeButton.getScene().getWindow();
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Warning");
                        alert.setHeaderText("Some field is empty !!");
                        alert.setContentText("For continue select Ok");

                        Optional<ButtonType> result = alert.showAndWait();
                        if (result.get() == ButtonType.OK) {
                                stage.close();
                        } else {
                                alert.close();

                        }
                }
                else{if(password.equals(repassword)){

                if(DBConnection.isSignup(name, email,password)) {

                        Stage stage = (Stage) closeButton.getScene().getWindow();
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setTitle("Information");
                        alert.setHeaderText("Your inforamtion is saved");
                        alert.setContentText("For continue select Ok");

                        Optional<ButtonType> result = alert.showAndWait();
                        if (result.get() == ButtonType.OK) {
                                stage.close();
                                start();
                        } else {
                                alert.close();

                        }
                }
                else{
                        Stage stage = (Stage) closeButton.getScene().getWindow();
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Warning");
                        alert.setHeaderText("Should insert the same password in rePassword field !");
                        alert.setContentText("For continue select Ok");

                        Optional<ButtonType> result = alert.showAndWait();
                        if (result.get() == ButtonType.OK) {
                                alert.close();
                        } else {
                                alert.close();

                        }
                }}}
        }

        public void insertedFile(){

                FileChooser fileChooser = new FileChooser();
                Stage stage1 = (Stage) insert.getScene().getWindow();
                File selectedFile = fileChooser.showOpenDialog(stage1);
                String lines="";
                String line;
                try {
                        FileReader fileReader = new FileReader(selectedFile);

                        BufferedReader bufferedReader = new BufferedReader(fileReader);

                        while ((line = bufferedReader.readLine()) != null) {

                                lines += line;
                                EmailList.add(line);
                                lines += "\n";




                        }
                        emailslist.setText(lines);
                        System.out.println(EmailList);

                        //split(lines);
                } catch (FileNotFoundException ex) {
                        System.out.println(
                                "Unable to open file '");
                } catch (IOException e) {
                        e.printStackTrace();
                }
        }

        public void send(){
                JavaEmail.email=emailsender.getText();
                JavaEmail.password=passwordsender.getText();
//                JavaEmail.to=emailslist.getText();
                JavaEmail.subject = subjectsender.getText();
                JavaEmail.text=message.getText();

                //
                String[] tab = emailslist.getText().split("\n");
                for(int i = 0 ; i<tab.length ; i++){
                       try{
                               JavaEmail.to=tab[i];
                               JavaEmail test = new JavaEmail();

                       }catch(Exception e){
                               message.setText(String.valueOf(e));
                        }
                }
                message.setText(JavaEmail.OUTPUT);

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Information");
                alert.setHeaderText("DONE");
                alert.setContentText("For continue select Ok");

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                        alert.close();
                } else {
                        alert.close();

                }



        }
        public void Logout() throws Exception {
                closelastButtonAction();
                start();
        }



}
