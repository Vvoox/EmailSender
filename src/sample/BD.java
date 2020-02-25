    package sample;
    import javafx.scene.control.Alert;
    import javafx.scene.control.ButtonType;

    import java.sql.*;
    import java.util.Optional;

    import static sample.Controller.MySQLConnection;

    class DBConnection {
        static private String url = "jdbc:mysql://remotemysql.com:3306/Va02f8tjwa";
        static private String user = "Va02f8tjwa";
        static private String password = "pwmv7RcwG7";
        static private String  NAME = "ADMIN";
        static String name="";

        public static void DBConnection() throws SQLException, ClassNotFoundException {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection myConn = DriverManager.getConnection(url, user, password);

        }

        public static boolean isSignup(String Name , String Email, String Password) throws ClassNotFoundException {
            boolean stat = false;
            Connection myConn = null;
            PreparedStatement pst = null;
            try {

                myConn = MySQLConnection.getConnection(url, user, password);
                pst = myConn.prepareStatement("insert into users values(?,?,?)");
                pst.setString(1, Name);
                pst.setString(2, Email);
                pst.setString(3, Password);
                int i = pst.executeUpdate();
                if (i > 0) {
                    stat = true;
                }
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("DATA Information");
                alert.setHeaderText("Your error is : " + e);
                alert.setContentText("Press OK to continue");
                alert.showAndWait();
                stat = false;
            }

            return stat;

        }

        public static String getname(String Email){
            boolean stat = false;


            try{


                Connection myConn = MySQLConnection.getConnection(url,user,password);
                String mySqlQuery =
                        "SELECT  Name FROM users WHERE Email = '"+
                                Email+
                                "'";
                PreparedStatement preparedStatement = myConn.prepareStatement(mySqlQuery);
                ResultSet resultSet = preparedStatement.executeQuery();

                while(resultSet.next()){
                    name = resultSet.getString("Name");
                    stat=true;

                }

            }catch (Exception exception){

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("DATA Information");
                alert.setHeaderText("Your error is : "+exception);
                alert.setContentText("Pres OK to continue");
                alert.showAndWait();
            }

            return name;

        }
        public static boolean isConnected(String Email, String Password) {
            boolean etatname = false;
            boolean etatpassword =false;
            try {
                Connection myConn = DriverManager.getConnection(url, user, password);
                String mySqlQuery =
                        "SELECT  Email,Password FROM users WHERE Email = '" +
                                Email +
                                "' AND Password = '" +
                                Password +
                                "'";
                PreparedStatement preparedStatement = myConn.prepareStatement(mySqlQuery);
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    Email = resultSet.getString("Email");
                    Password = resultSet.getString("Password");
                    etatname = true;
                }


            } catch (Exception exception) {
                System.out.println(exception);
            }

            return etatname;
        }

    }

