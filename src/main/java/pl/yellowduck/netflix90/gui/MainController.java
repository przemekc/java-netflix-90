package pl.yellowduck.netflix90.gui;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

  @FXML
  FlowPane mainPanel;

  public void quit(ActionEvent actionEvent) {
    Platform.exit();
  }

  public void films(ActionEvent actionEvent) {

  }

  public void categories(ActionEvent actionEvent) throws IOException {
    Parent categories = FXMLLoader.load(getClass().getClassLoader().getResource("views/categories.fxml"));
    mainPanel.getChildren().clear();
    mainPanel.getChildren().add(categories);

    Stage stage = new Stage();
    Scene scene = new Scene(categories, 1200, 800);
    stage.setScene(scene);
    stage.show();
  }
}
