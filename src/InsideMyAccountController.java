
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class InsideMyAccountController implements Initializable {

    @FXML
    private Label myAccountLabel;

    @FXML
    private BorderPane detailBox;

    @FXML
    void BookAnAppointmentButton(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation((getClass().getResource("bookAnAppointmentNow.fxml")));
            detailBox.setCenter(fxmlLoader.load());
            
            BookAnAppointmentNowController control = fxmlLoader.getController();
            control.setAccountData(acc);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    void viewMyAccountButton(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation((getClass().getResource("viewMyAccountInfo.fxml")));
            
            detailBox.setCenter(fxmlLoader.load());
            ViewMyAccountInfoController control = fxmlLoader.getController();
            control.setAccountData(acc);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public accountMethod acc;
    public String email;

    public void setAccountData(accountMethod account) {
        acc = account;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

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
