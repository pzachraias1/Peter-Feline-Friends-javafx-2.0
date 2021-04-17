
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class adoptionPageController implements Initializable {

    @FXML
    private ScrollPane catScrollPane;

    @FXML
    private GridPane catGridPane;

    @FXML
    private VBox detailBox;

    @FXML
    private ImageView catImage;

    @FXML
    private VBox catInfo;

    @FXML
    private Label catName;

    @FXML
    private Label catAge;

    @FXML
    private Label catBreed;

    @FXML
    private Label catColor;

    @FXML
    private TextArea catDescription;

    @FXML
    private TextField searchCatName;
    

    public myListener myListener;

    public List<catList> catList = new ArrayList<>();

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

    private void setdetailBox(catList catlist) {
        catName.setText(catlist.getName());
        catAge.setText(catlist.getAge());
        catBreed.setText(catlist.getBreed());
        catColor.setText(catlist.getColor());
        catDescription.setText(catlist.getDescription());
        Image img = new Image(getClass().getResourceAsStream(catlist.getImgSrc()));
        catImage.setImage(img);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        catList.addAll(getData());

        if (catList.size() > 0) {
            setdetailBox(catList.get(0));
            myListener = (catList cat) -> {
                setdetailBox(cat);
            };
        }

        int column = 0;
        int row = 0;

        try {
            for (int i = 0; i < catList.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation((getClass().getResource("ListingOfCats.fxml")));
                AnchorPane anchorPane = fxmlLoader.load();

                catListingController catlistingController = fxmlLoader.getController();
                catlistingController.setData(catList.get(i), myListener);

                if (column == 2) {
                    column = 0;
                    row++;
                }
                catGridPane.add(anchorPane, column++, row);

                catGridPane.setMinWidth(Region.USE_COMPUTED_SIZE);
                catGridPane.setPrefWidth(Region.USE_COMPUTED_SIZE);
                catGridPane.setMaxWidth(Region.USE_PREF_SIZE);

                catGridPane.setMinHeight(Region.USE_COMPUTED_SIZE);
                catGridPane.setPrefHeight(Region.USE_COMPUTED_SIZE);
                catGridPane.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
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

    public void searchNameButton(ActionEvent e) throws IOException {
        String searchValue = searchCatName.getText().toString().toLowerCase();
        ArrayList <String> catListString = new ArrayList<>();
        
        for (int i = 0; i<catList.size();i++){
            catListString.add(catList.get(i).name.toLowerCase());
        }

        if (searchValue == null || searchValue.isEmpty()) {
            return;
        } 
        else {  
            if (catListString.contains(searchValue)){
                for (int i = 0; i<catListString.size();i++){
                    if (catListString.get(i).equalsIgnoreCase(searchValue)){
                        setdetailBox(catList.get(i));
                    }
                }
            }
            else
                return;
        }
    }
}

