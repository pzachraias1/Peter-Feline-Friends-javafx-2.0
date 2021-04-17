
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
//import java.sql.Date;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class SignInPageController {

    @FXML
    private TextField firstName;

    @FXML
    private TextField middleName;

    @FXML
    private TextField lastName;

    @FXML
    private TextField emailAddress;

    @FXML
    private TextField phoneNumber;

    @FXML
    private TextField streetAddress;

    @FXML
    private TextField state;

    @FXML
    private TextField city;

    @FXML
    private TextField zip;

    @FXML
    private DatePicker dateOfBirth;

    @FXML
    private Button submitButtonName;

    public String getDate(ActionEvent e) {
        LocalDate myDate = dateOfBirth.getValue();
        String formatDate = myDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        return formatDate;
    }

    private List<accountMethod> newAccount = new ArrayList<>();
    public accountMethod cc;

    private List<accountMethod> getData() {
        List<accountMethod> newAccountArray = new ArrayList<>();
        accountMethod newAccount;

        String first, middle, last, city, zip, state, email, street;

        first = firstName.getText().toString();
        middle = middleName.getText().toString();
        last = lastName.getText().toString();
        city = this.city.getText().toString();
        zip = this.zip.getText().toString();
        state = this.state.getText().toString();
        email = emailAddress.getText().toString();
        street = streetAddress.getText().toString();

        newAccount = new accountMethod();
        newAccount.setNameFirst(first);
        newAccount.setNameMiddle(middle);
        newAccount.setNameLast(last);
        newAccount.setCity(city);
        newAccount.setZip(zip);
        newAccount.setState(state);
        newAccount.setStAddress(street);
        newAccount.setEmail(email);
        newAccount.setPhone(phoneNumber.getText().toString());
        newAccountArray.add(newAccount);

        return newAccountArray;
    }

    public void setData(accountMethod account) {
        cc = account;

        //SimpleDateFormat formatter=new SimpleDateFormat("dd-MMM-yyyy");
        //Date d =formatter.parse(cc.getDob());  
        //Instant instant = d.toInstant();
        //LocalDate date = 
        firstName.setText(account.getNameFirst());
        middleName.setText(account.getNameMiddle());
        lastName.setText(account.getNameLast());
        city.setText(account.getCity());
        state.setText(account.getState());
        zip.setText(account.getZip());
        streetAddress.setText(account.getStAddress());
        phoneNumber.setText(account.getPhone());
        emailAddress.setText(account.getEmail());
        //dateOfBirth.setValue(date);
    }

    public void submitButton(ActionEvent e) throws IOException {
        newAccount.addAll(getData());
        
        cc = newAccount.get(0);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("insideMyAccount.fxml"));
        Parent root = loader.load();
        InsideMyAccountController control = loader.getController();
        control.setAccountData(cc);

        Scene scene = new Scene(root);
        String css = projectMain.class.getResource("pff.css").toExternalForm();
        scene.getStylesheets().add(css);
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void keyReleased(KeyEvent event) {
        String fname = firstName.getText();
        String lname = lastName.getText();
        String email = emailAddress.getText();
        String street = streetAddress.getText();
        String state = this.state.getText();
        String city = this.city.getText();
        String zip = this.zip.getText();

        Boolean isDisable = (fname.isEmpty() || lname.isEmpty()
                || email.isEmpty() || street.isEmpty() || state.isEmpty()
                || city.isEmpty() || zip.isEmpty());
        submitButtonName.setDisable(isDisable);
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
