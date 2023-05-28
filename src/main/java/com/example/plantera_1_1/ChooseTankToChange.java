package com.example.plantera_1_1;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ChooseTankToChange {

    public static void display(double x, double y) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Виберiть для змiни");
        window.setMinWidth(250);

        ArrayList<String> collectors = HelloApplication.getNames();

        Label label = new Label("Оберіть об\'єкт для змін:");

        ComboBox cBox = new ComboBox();

        int count = 1;
        for (String s : collectors)
        {
            cBox.getItems().add(Integer.toString(count) + " " + s);
            count++;
        }

        VBox layout = new VBox(13);
        //layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);


        Button chooseButton = new Button("Choose");
        chooseButton.setPrefSize(250, 50);
        chooseButton.setTextFill(Color.BLACK);
        chooseButton.setFont(Font.font("Harrington", 23));
        chooseButton.setStyle("-fx-background-color: lavender ");
        chooseButton.setOnAction(e ->
        {
            if (cBox.getValue() != null)
            {
                String[] strChoice = cBox.getValue().toString().split(" ");
                //System.out.println("Message from String.split:"+ Arrays.toString(strChoice));

                TankChangeParams.display(Integer.parseInt(strChoice[0]) - 1);
            }

            window.close();
        });

        Button delete = new Button("Dellete");
        delete.setPrefSize(250, 50);
        delete.setTextFill(Color.BLACK);
        delete.setFont(Font.font("Harrington", 23));
        delete.setStyle("-fx-background-color: lavender ");

        delete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ArrayList<Smok> del = new ArrayList<>();

                for (Smok c : HelloApplication.tanks)
                {
                    if (c.isActive() == true)
                    {
                        c.DELETE();
                    }
                    else
                    {
                        del.add(c);
                    }
                    HelloApplication.tanks = del;
                }
            }
        });

        layout.getChildren().addAll(label, cBox, chooseButton, delete);
        Scene scene = new Scene(layout, 300, 350);
        window.setScene(scene);
        window.showAndWait();

    }

}
