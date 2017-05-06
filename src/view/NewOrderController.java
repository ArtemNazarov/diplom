package view;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NewOrderController {

    public TextField toyTitleField;
    public TextField orderSumField;
    public TextField curField;
    public TextField amountField;
    public DatePicker dateField;


    public void preOrder(ActionEvent actionEvent) {

    }

    public void cancelOrder(ActionEvent actionEvent) {
        Stage stageTheEventSourceNodeBelongs = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stageTheEventSourceNodeBelongs.close();
    }
}
