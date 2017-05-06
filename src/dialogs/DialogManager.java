package dialogs;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.util.Optional;

/**
 * Created by Artem on 21.12.2015.
 */
public class DialogManager {


    public static void showCloseDialog(WindowEvent event){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("\u041F\u043E\u0434\u0442\u0432\u0435\u0440\u0436\u0434\u0435\u043D\u0438\u0435");
        alert.setHeaderText("\u0414\u0435\u0439\u0441\u0442\u0432\u0438\u0442\u0435\u043B\u044C\u043D\u043E \u0432\u044B\u0439\u0442\u0438");
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image(("file:resources/icons/question.png")));
        ButtonType yesButton = new ButtonType("\u041D\u0435\u0442");
        ButtonType noButton = new ButtonType("\u0414\u0430");
        alert.getButtonTypes().setAll(yesButton, noButton);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == noButton)
            event.consume();
    }

    public static void showErrorDialog(String text){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("\u041E\u0448\u0438\u0431\u043A\u0430!");
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image(("file:resources/icons/warning.png")));
        alert.setContentText(text);
        alert.setHeaderText("");
        alert.showAndWait();
    }

    public static void showInformationDialog(String text){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Информация");
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        alert.setContentText(text);
        alert.setHeaderText("");
        alert.showAndWait();
    }


}
