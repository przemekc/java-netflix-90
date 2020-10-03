package pl.yellowduck.netflix90.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import pl.yellowduck.netflix90.films.Category;

public class CategoriesController {

    @FXML
    TableView<Category> categoriesTable;

    public void loadData(ActionEvent event) {
        categoriesTable.getItems()
                .add(new Category("TEST", "TEST DESCRPTION"));
        categoriesTable.refresh();
    }
}
