package com.example.plantera_1_1;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class World
{
    public static Stage stage = new Stage();
    public static Stage stage2 = new Stage();
    public static Image imgWorld;
    public static Image imgMenu;
    public static Group group = new Group();
    public static Group groupMenu = new Group();
    public static Scene world = new Scene(group, 1000, 1000);
    public static Scene Menu = new Scene(groupMenu, 1074, 523);
    ImageView imvWorld;
    ImageView imvMenu;
    public void World()
    {

        imgWorld = new Image(HelloApplication.class.getResource("Світ.png").toString(), 1000, 1000,false,false);
        System.out.println(HelloApplication.class.getResource("Світ.png").toString());
        imvWorld = new ImageView(imgWorld);


        imgMenu = new Image(HelloApplication.class.getResource("Menu.png").toString(), 1074, 523, false, false);
        System.out.println(HelloApplication.class.getResource("Menu.png").toString());
        imvMenu = new ImageView(imgMenu);

        Button Start = new Button("Start");
        Start.setFont(Font.font("Harrington", 25));
        Start.setTextFill(Color.DARKGREEN);
        Start.setBackground(Background.fill(Color.LIGHTGREEN));
        Start.setPrefSize(300, 50);
        Start.setLayoutX(387);
        Start.setLayoutY(365);

        Button Exit = new Button("Exit");
        Exit.setFont(Font.font("Harrington", 25));
        Exit.setTextFill(Color.BLACK);
        Exit.setBackground(Background.fill(Color.PALEVIOLETRED));
        Exit.setPrefSize(300, 50);
        Exit.setLayoutX(387);
        Exit.setLayoutY(440);


        Start.setOnAction(e -> {
            stage2.setScene(world);
            stage2.show();
            stage.close();
        });

        Exit.setOnAction(e -> {
            stage.close();
        });

        groupMenu.getChildren().addAll(imvMenu, Start, Exit);
        stage.setScene(groupMenu.getScene());
        //stage.setScene(HelloApplication.imvMenu.getScene());

        group.getChildren().add(imvWorld);


//        stage.setScene(world);
        stage.setTitle("Tanki Ofline 1.3");
        stage2.setTitle("Game 1.3");
        stage.show();
    }
}
