
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class accountPageController{
    
    @FXML
    private TextField emailAddressLogin;

    @FXML
    private Button loginButton;
    
    @FXML
    private Label errorMessage;
    
    public List<accountMethod> clientList = new ArrayList<>();

    public List<accountMethod> getData() {
        List<accountMethod> clientArray = new ArrayList<>();
        accountMethod client;
        
        client = new accountMethod();
        client.setNameFirst("Pete Chee");
        client.setNameMiddle("Junjun");
        client.setNameLast("Zachraias");
        client.setDob("5-Jan-1999");
        client.setPhone("8081234567");
        client.setStAddress("55 Fort Street Mall");
        client.setState("HI");
        client.setCity("Honolulu");
        client.setEmail("pzachraias1@my.hpu.edu");
        client.setZip("96960");
        clientArray.add(client);
        
        return clientArray;
    }
    
    public void emailLoginButton (ActionEvent e) throws IOException{
        clientList.addAll(getData());
        
        String emailValue = emailAddressLogin.getText().toString();
        ArrayList <String> emailArray = new ArrayList<>();

        
        
        for (int i = 0; i < clientList.size(); i++){
            emailArray.add(clientList.get(i).email);
        }
        
        if (emailValue == null){
            return;
        }
        else {
            if (emailArray.contains(emailValue)){
                for (int i = 0; i < emailArray.size(); i++){
                    if (emailArray.get(i).equalsIgnoreCase(emailValue)){   
                        
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("insideMyAccount.fxml"));
                        Parent root = loader.load();
                        InsideMyAccountController control = loader.getController();
                        control.setAccountData(clientList.get(i));
                        
                        Scene scene = new Scene(root);
                        String css = projectMain.class.getResource("pff.css").toExternalForm();
                        scene.getStylesheets().add(css);
                        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
                        stage.setScene(scene);
                        stage.show();
                    }  
                }
            }
            else {
                errorMessage.setVisible(true);
            }
        }
    }
    
    public void signInButton (ActionEvent e) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("signInPage.fxml"));

        Scene scene = new Scene(root);
        String css = projectMain.class.getResource("pff.css").toExternalForm();
        scene.getStylesheets().add(css);
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    //-----------------Buttons---------------------
    public void pffButtonPage(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("pffFXML.fxml"));

        Scene scene = new Scene(root);
        String css = projectMain.class.getResource("pff.css").toExternalForm();
        scene.getStylesheets().add(css);
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void aboutUsButtonPage(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("aboutUsPage.fxml"));

        Scene scene = new Scene(root);
        String css = projectMain.class.getResource("pff.css").toExternalForm();
        scene.getStylesheets().add(css);
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void adoptionButtonPage(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("adoptionPage.fxml"));

        Scene scene = new Scene(root);
        String css = projectMain.class.getResource("pff.css").toExternalForm();
        scene.getStylesheets().add(css);
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void accountButtonPage(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("accountPage.fxml"));

        Scene scene = new Scene(root);
        String css = projectMain.class.getResource("pff.css").toExternalForm();
        scene.getStylesheets().add(css);
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void contactButtonPage(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("contactPage.fxml"));

        Scene scene = new Scene(root);
        String css = projectMain.class.getResource("pff.css").toExternalForm();
        scene.getStylesheets().add(css);
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
}
