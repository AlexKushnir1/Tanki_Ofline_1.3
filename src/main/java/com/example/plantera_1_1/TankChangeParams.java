package com.example.plantera_1_1;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;

public class TankChangeParams {

    public static void display(int collectorIndex) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Введіть параметри нового Танка!");
        window.setMinWidth(250);
        ArrayList<String> paramsTochange = HelloApplication.getParamsToChange( collectorIndex );

        VBox layout = new VBox(11);
        //layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);
//---------------------------------------------------------z
        Label nameLabel=new Label();
        nameLabel.setFont(Font.font("Harrington", 23));
        nameLabel.setText("Name:");
        TextField nameText = new TextField();
        nameLabel.setTextFill(Color.BLACK);
        nameText.setFont(Font.font("Times New Romane", 17));
        nameText.setText(paramsTochange.get(0));

        Label _ArmortLabel=new Label();
        _ArmortLabel.setFont(Font.font("Harrington", 23));
        _ArmortLabel.setText("Armor:");
        TextField _WeightText = new TextField();
        _ArmortLabel.setTextFill(Color.BLACK);
        _WeightText.setFont(Font.font("Times New Romane", 17));
        _WeightText.setText(paramsTochange.get(1));

        Label healthLabel=new Label();
        healthLabel.setFont(Font.font("Harrington", 23));
        healthLabel.setText("Health:");
        healthLabel.setTextFill(Color.BLACK);
        TextField healthText = new TextField();
        healthText.setFont(Font.font("Times New Romane", 17));
        healthText.setText(paramsTochange.get(2));

        Label xLabel=new Label();
        xLabel.setFont(Font.font("Harrington", 23));
        xLabel.setText("X:");
        xLabel.setTextFill(Color.BLACK);
        TextField xText = new TextField();
        xText.setFont(Font.font("Times New Romane", 17));
        xText.setText(paramsTochange.get(3));

        Label yLabel=new Label();
        yLabel.setFont(Font.font("Harrington", 23));
        yLabel.setText("Y:");
        yLabel.setTextFill(Color.BLACK);
        TextField yText = new TextField();
        yText.setFont(Font.font("Times New Romane", 17));
        yText.setText(paramsTochange.get(4));

        Button CollectorLVL1=new Button("Change");
        CollectorLVL1.setTextFill(Color.BLACK);
        CollectorLVL1.setFont(Font.font("Harrington", 23));
        CollectorLVL1.setStyle("-fx-background-color: lightgreen ");

        CollectorLVL1.setOnAction(e->
        {

            String sName= nameText.getText();
            String sArmor = _WeightText.getText();
            String sHealth= healthText.getText();
            String sX = xText.getText();
            String sY = yText.getText();


            HelloApplication.changeSmok(collectorIndex,sName,sArmor, sHealth, sX, sY);

            System.out.println("Було змiнено параметри: sName: " + sName + ", _Weight: " + sArmor + ", sHealth: " + sHealth + ", sX: " +sX + ", sY: " + sY);
            window.close();
        });



        layout.getChildren().addAll(nameLabel, nameText,_ArmortLabel, _WeightText, healthLabel, healthText, xLabel, xText, yLabel, yText, CollectorLVL1);

        Scene scene=new Scene(layout,500,500);
        window.setScene(scene);
        window.showAndWait();

    }

}
