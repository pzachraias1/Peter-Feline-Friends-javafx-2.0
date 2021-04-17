
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ConfirmationController implements Initializable {
    
    @FXML
    private Label clientName;

    @FXML
    private Label catName;

    @FXML
    private Label location;

    @FXML
    private Label date;
    
    @FXML
    void homeButton(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("pffFXML.fxml"));

        Scene scene = new Scene(root);
        String css = projectMain.class.getResource("pff.css").toExternalForm();
        scene.getStylesheets().add(css);
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }  
    
    public void setCatData (catList cat){
        catName.setText(cat.getName());
    }
    
    public void setClientData(accountMethod client){
        clientName.setText(client.getNameFirst() + " " + client.getNameLast());
    }
    
    public void setLocation (locationMethod loc){
        location.setText(loc.getStreet() + " " + loc.getState() + " " + loc.getCity() +
                 " " + loc.getZip());
    }
    
}
