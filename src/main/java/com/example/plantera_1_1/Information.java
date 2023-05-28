package com.example.plantera_1_1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class Information {
    public static Text names;
    public static void display() {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Iнформація");

        window.setMinWidth(250);

        ComboBox Box = new ComboBox();
        names = new Text();

        int count = 1;
        ListView<String> listView = null;
        listView = new ListView<>();
        for (String s : HelloApplication.getNames())
        {
            //Box.getItems().add(Integer.toString(count)+" "+ s);
            ObservableList<String> items = FXCollections.observableArrayList(Integer.toString(count) + " " + s);
            listView.getItems().add(count + " " + s);
            count++;
        }

        VBox layout = new VBox(11);
        layout.setAlignment(Pos.CENTER);

        layout.getChildren().addAll(listView);
        Scene scene = new Scene(layout, 500, 500);
        window.setScene(scene);
        window.showAndWait();
    }

}
