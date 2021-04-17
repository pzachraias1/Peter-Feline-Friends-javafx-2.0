
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class BookAnAppointmentNowController implements Initializable {

    
    @FXML
    private DatePicker datePickAppointment;

    @FXML
    private GridPane grid;
    
    @FXML
    private Label dateSelect;

    @FXML
    private Label locationSelected;

    @FXML
    private Label catSelect;

    @FXML
    private ChoiceBox<String> pickLocation;

    @FXML
    void submitButton(ActionEvent e) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Confirmation.fxml"));
        Parent root = loader.load();
        
        ConfirmationController control = loader.getController();     
        control.setCatData(theCat);
        control.setClientData(theClient);
        control.setLocation(theLoc);

        Scene scene = new Scene(root);
        String css = projectMain.class.getResource("pff.css").toExternalForm();
        scene.getStylesheets().add(css);
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
         
    }
    
    public myListener myListener;
    public myLocationListener myLocationListener;

    public catList theCat;
    public locationMethod theLoc;
    public accountMethod theClient;
    
    public void setAccountData(accountMethod account){
        theClient = account;
    }
    
    public List<catList> catList = new ArrayList<>();
    public List <locationMethod> locationList = new ArrayList<>(); 

    public List<catList> getData() {
        List<catList> catListArray = new ArrayList<>();
        catList cat;

        cat = new catList();
        cat.setName("John Wick");
        cat.setAge("4");
        cat.setBreed("Bulldog");
        cat.setColor("Brown");
        cat.setImgSrc("poppy.jpg");
        cat.setDescription("Wonderful loving cat");
        catListArray.add(cat);

        cat = new catList();
        cat.setName("Dwight");
        cat.setAge("3");
        cat.setBreed("Elephant");
        cat.setColor("Green");
        cat.setImgSrc("taro.jpg");
        cat.setDescription("Best of them best");
        catListArray.add(cat);

        cat = new catList();
        cat.setName("Shaq");
        cat.setAge("2");
        cat.setBreed("Lion");
        cat.setColor("white");
        cat.setImgSrc("truly.jpg");
        cat.setDescription("This is fake, do not believe me LOL");
        catListArray.add(cat);

        return catListArray;
    }
    
    public List<locationMethod> getLocation(){
        List<locationMethod> locationArray = new ArrayList<>();
        locationMethod loc;
        
        loc = new locationMethod();
        loc.setStreet("55 Fort Street Mall");
        loc.setState("HI");
        loc.setCity("Honolulu");
        loc.setZip("96960");
        locationArray.add(loc);
        
        loc = new locationMethod();
        loc.setStreet("738 Ala Moana");
        loc.setState("HI");
        loc.setCity("Honolulu");
        loc.setZip("98788");
        locationArray.add(loc);
        
        return locationArray;
    }
    
    public void datePicked(ActionEvent e){
        LocalDate myDate = datePickAppointment.getValue();
        String formatDate = myDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        dateSelect.setText(formatDate);
    }
    
    public void getLocationData(ActionEvent e){
        String loc = pickLocation.getValue();
        
        for (int i =0; i<locationList.size();i++){
            if (locationList.get(i).getStreet().equalsIgnoreCase(loc)){
                locationSelected.setText(
                        locationList.get(i).getStreet() + " " +
                        locationList.get(i).getState() + ", " + 
                        locationList.get(i).getCity()+
                        ", " + locationList.get(i).getZip()
                );
                theLoc = locationList.get(i);
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        catList.addAll(getData());
        locationList.addAll(getLocation());
        
        for (int i = 0; i<locationList.size(); i++){
            pickLocation.getItems().add(locationList.get(i).getStreet());
        }
        
        pickLocation.setOnAction(this::getLocationData);
        
        int column = 0;
        int row = 0;
        
        if (catList.size() > 0) {
            myListener = (catList cat) -> {
                catSelect.setText(cat.name);
                theCat = cat;
            };
        }

        try {
            for (int i = 0; i < catList.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation((getClass().getResource("ListingOfCats.fxml")));
                AnchorPane anchorPane = fxmlLoader.load();

                catListingController catlistingController = fxmlLoader.getController();
                catlistingController.setData(catList.get(i), myListener);

                if (column == 3) {
                    column = 0;
                    row++;
                }
                grid.add(anchorPane, column++, row);

                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(15));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }    
    
}
