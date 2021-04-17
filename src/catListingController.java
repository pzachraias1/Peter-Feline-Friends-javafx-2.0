

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class catListingController {

    @FXML
    private ImageView previewCatImage;

    @FXML
    private Label previewCatName;

    @FXML
    private AnchorPane catPreview;

    @FXML
    private void click(MouseEvent e){
        myListener.onClickListener(catlist);
    }

    public catList catlist;

    public myListener myListener;

    public void setData(catList catlist, myListener myListener) {
        this.catlist = catlist;
        this.myListener = myListener;

        previewCatName.setText(catlist.getName());

        Image img = new Image(getClass().getResourceAsStream(catlist.getImgSrc()));
        previewCatImage.setImage(img);
    }

}
