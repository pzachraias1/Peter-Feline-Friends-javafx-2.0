
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ViewMyAccountInfoController {

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField birthdayTextField;

    @FXML
    private TextField eAddressTextField;

    @FXML
    private TextField sAddressTextfField;

    @FXML
    private Button editButton;

    public accountMethod c;

    public void setAccountData(accountMethod account) {
        c = account;
        nameTextField.setText(c.getNameFirst() + " " + c.getNameLast());
        birthdayTextField.setText(c.getDob());
        eAddressTextField.setText(c.getEmail());
        sAddressTextfField.setText(c.getStAddress() + ", " + c.getState()
                + ", " + c.getCity() + ", " + c.getZip());
    }

    public void edit(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("signInPage.fxml"));
        Parent root = loader.load();
        
        SignInPageController control = loader.getController();
        control.setData(c);

        Scene scene = new Scene(root);
        String css = projectMain.class.getResource("pff.css").toExternalForm();
        scene.getStylesheets().add(css);
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

}
