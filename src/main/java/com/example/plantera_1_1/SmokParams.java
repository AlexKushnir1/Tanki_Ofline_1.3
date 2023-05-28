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

public class SmokParams {
    public static void display(double x, double y) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Character menu");
        window.setMinWidth(250);

        VBox layout = new VBox(25);
        Scene scene = new Scene(layout, 375, 375);
//        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);

        Label nameLabel=new Label();
        nameLabel.setFont(Font.font("Harrington", 19));
        nameLabel.setText("Name:");
        nameLabel.setTextFill(Color.BLACK);
        TextField nameText = new TextField();
        nameText.setFont(Font.font("Times New Romane", 17));

        Label ArmorLabel=new Label();
        ArmorLabel.setFont(Font.font("Harrington", 19));
        ArmorLabel.setText("Armor:");
        ArmorLabel.setTextFill(Color.BLACK);
        TextField WeightText = new TextField();
        WeightText.setFont(Font.font("Times New Romane", 17));

        Label healthLabel=new Label();
        healthLabel.setFont(Font.font("Harrington", 19));
        healthLabel.setText("Health:");
        healthLabel.setTextFill(Color.BLACK);
        TextField healthText = new TextField();
        healthText.setFont(Font.font("Times New Romane", 17));

        Label xLabel=new Label();
        xLabel.setFont(Font.font("Harrington", 19));
        xLabel.setText("X:");
        xLabel.setTextFill(Color.BLACK);
        TextField xText = new TextField();
        xText.setText(Double.toString(x));
        xText.setFont(Font.font("Times New Romane", 17));

        Label yLabel=new Label();
        yLabel.setFont(Font.font("Harrington", 19));
        yLabel.setText("Y:");
        yLabel.setTextFill(Color.BLACK);
        TextField yText = new TextField();
        yText.setText(Double.toString(y));
        yText.setFont(Font.font("Times New Romane", 17));

        Button Smok;
        Smok= new Button("Spawn Smok");
        Smok.setPrefSize(275, 50);
        Smok.setFont(Font.font("Harrington", 23));
        Smok.setTextFill(Color.BLACK);
        Smok.setStyle("-fx-background-color: lavender ");
        Smok.getBackground();

        Button Grom;
        Grom= new Button("Spawn Grom");
        Grom.setPrefSize(275, 50);
        Grom.setFont(Font.font("Harrington", 23));
        Grom.setTextFill(Color.BLACK);
        Grom.setStyle("-fx-background-color: lavender ");
        Grom.getBackground();

        Button Relsa;
        Relsa= new Button("Spawn Relsa");
        Relsa.setPrefSize(275, 50);
        Relsa.setFont(Font.font("Harrington", 23));
        Relsa.setTextFill(Color.BLACK);
        Relsa.setStyle("-fx-background-color: lavender ");
        Relsa.getBackground();

        Smok.setOnAction(e->
        {
            String sX = xText.getText();
            String sY = yText.getText();
            TankSmokCharacter.display();
        });

        layout.getChildren().addAll(Smok, Grom, Relsa);

        window.setScene(scene);
        window.showAndWait();
    }
}
class TankSmokCharacter
{
    public static Button SmokLvL1;
    public static void display()
    {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Character menu");
        window.setMinWidth(250);

        VBox layout = new VBox(11);

        window.setTitle("TankSmokCharacter");
        //        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);

        Label nameLabel = new Label();
        nameLabel.setFont(Font.font("Harrington", 23));
        nameLabel.setTextFill(Color.BLACK);
        nameLabel.setText("Name: ");
        TextField nameText = new TextField();
        nameText.setFont(Font.font("Times New Romane", 17));

        Label ArmorLabel=new Label();
        ArmorLabel.setFont(Font.font("Harrington", 23));
        ArmorLabel.setTextFill((Color.BLACK));
        ArmorLabel.setText("Armor:");
        ArmorLabel.setTextFill(Color.BLACK);
        TextField ArmorText = new TextField();
        ArmorText.setFont(Font.font("Times New Romane", 17));

        Label healthLabel = new Label();
        healthLabel.setFont(Font.font("Harrington", 23));
        healthLabel.setTextFill((Color.BLACK));
        healthLabel.setText("Health: ");
        TextField healthText = new TextField();
        healthText.setFont(Font.font("Times New Romane", 17));

        Label xLabel = new Label();
        xLabel.setFont(Font.font("Harrington", 23));
        xLabel.setTextFill((Color.BLACK));
        xLabel.setText("X: ");
        TextField xText = new TextField();
        xText.setFont(Font.font("Times New Romane", 17));

        Label yLabel = new Label();
        yLabel.setFont(Font.font("Harrington", 23));
        yLabel.setTextFill((Color.BLACK));
        yLabel.setText("Y: ");
        TextField yText = new TextField();
        yText.setFont(Font.font("Times New Romane", 17));

        SmokLvL1 = new Button("Spawn");
        SmokLvL1.setPrefSize(275, 50);
        SmokLvL1.setFont(Font.font("Harrington", 23));
        SmokLvL1.setTextFill(Color.BLACK);
        SmokLvL1.setStyle("-fx-background-color: lavender ");
        SmokLvL1.getBackground();


        SmokLvL1.setOnAction(e->
        {
            String sName = nameText.getText();
            String sHealth = healthText.getText();
            String sX = xText.getText();
            String sY = yText.getText();
            String Armor = ArmorText.getText();

            HelloApplication.createNewSmok(sName, Armor ,sHealth, sX, sY);
            System.out.println("Було створено Smok з параметрами: Ім'я: " + sName + ", Броня танку: " + Armor + ", Здоров'я: " + sHealth + ", Координати по x та y: ( " +sX + " ; " + sY + " )");
            window.close();
        });

        layout.getChildren().addAll(nameLabel, nameText, ArmorLabel, ArmorText, healthLabel, healthText ,xLabel, xText, yLabel, yText, SmokLvL1);

        Scene scene = new Scene(layout, 500, 500);
        window.setScene(scene);
        window.showAndWait();
    }
}

//class CollecteLVL2Character
//{
//    public static Button CollectorLvL2;
//    public static void display(double x, double y)
//    {
//        Stage windowLVL2 = new Stage();
//        windowLVL2.initModality(Modality.APPLICATION_MODAL);
//        windowLVL2.setTitle("Character menu");
//        windowLVL2.setMinWidth(250);
//
//        VBox layout = new VBox();
//
//        windowLVL2.setTitle("CollecteLVL2Character");
//        //        layout.getChildren().addAll(label, closeButton);
//        layout.setAlignment(Pos.CENTER);
//
//        Label nameLabelLVL2 = new Label();
//        nameLabelLVL2.setText("Name: ");
//        TextField nameTextLVL2 = new TextField();
//
//        Label healthLabelLVL2 = new Label();
//        healthLabelLVL2.setText("Health: ");
//        TextField healthTextLVL2 = new TextField();
//
//        Label xLabelLVL2 = new Label();
//        xLabelLVL2.setText("X: ");
//        TextField xTextLVL2 = new TextField();
//
//        Label yLabelLVL2 = new Label();
//        yLabelLVL2.setText("Y: ");
//        TextField yTextLVL2 = new TextField();
//
//        CollectorLvL2 = new Button("OK");
//        CollectorLvL2.setMaxSize(350, 350);
//
//        CollectorLvL2.setOnAction(e->
//        {
//            String sName = nameTextLVL2.getText();
//            String sHealth = healthTextLVL2.getText();
//            String sX = xTextLVL2.getText();
//            String sY = yTextLVL2.getText();
//
//            HelloApplication.createNewCollector(sName, sHealth, sX, sY);
//            windowLVL2.close();
//        });
//
//        layout.getChildren().addAll(nameLabelLVL2, nameTextLVL2, healthLabelLVL2, healthTextLVL2 ,xLabelLVL2, xTextLVL2, yLabelLVL2, yTextLVL2, CollectorLvL2);
//
//        Scene scene = new Scene(layout, 300, 300);
//        windowLVL2.setScene(scene);
//        windowLVL2.showAndWait();
//    }
//}
//
//
