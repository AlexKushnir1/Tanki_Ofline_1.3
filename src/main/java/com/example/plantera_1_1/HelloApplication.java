package com.example.plantera_1_1;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HelloApplication extends Application {
    public static Image imgSmok;
    public static boolean flg;

    public static ArrayList<Smok> tanks = new ArrayList<>();

    public static List<Smok> activeTanks = new ArrayList<>(); // Список активних об'єктів

    public static void createNewSmok(String sName, String sWeight, String sHealth, String sX, String sY )
    {
        if( sName.equals("") )
        {
            sName = "Smok";
        }

        if( sWeight.equals("") )
        {
            sWeight = "0";
        }

        int h;
        try {
            h= Integer.parseInt(sHealth);
        }
        catch(Exception e){
            h=0;
        }

        double x;
        try {
            x= Double.parseDouble(sX);
        }
        catch(Exception e){
            x=0.0;
        }


        double y;
        try {
            y= Double.parseDouble(sY);
        }
        catch(Exception e){
            y=0.0;
        }
        HelloApplication.tanks.add(new Smok(sName,sWeight, h, x, y));
    }

    public static ArrayList<String> getNames()
    {
        ArrayList<String> arr = new ArrayList<>();

        for( Smok c:tanks )
        {
            arr.add(c.toString() );
        }

        return arr;
    }

    public static ArrayList<String> getParamsToChange( int index )
    {
        Smok c = tanks.get(index);

        ArrayList<String> arr= new ArrayList<String>();
        arr.add( c.getName() );
        arr.add( c.getHealth() );
        arr.add( c.getX() );
        arr.add( c.getY() );
        arr.add(c.getWeight());

        return arr;
    }

    public static void changeSmok(int smokIndex, String sName, String sWeight, String sHealth, String sX, String sY){
        Smok c= tanks.get(smokIndex);

        c.setName(sName);
        c.setWeight(sWeight);
        c.setHealth(sHealth);
        c.setX(sX);
        c.setY(sY);
    }

    @Override
    public void start(Stage stage) throws IOException
    {


        imgSmok = new Image(HelloApplication.class.getResource("SmokTurnUp0.png").toString(),70,75,false,false);
        System.out.println(HelloApplication.class.getResource("SmokTurnUp0.png").toString());

        World.world.setOnMouseClicked(mouseEvent -> {
            if (mouseEvent.getButton().equals(MouseButton.SECONDARY)) {
                ChooseTankToChange.display(mouseEvent.getX(), mouseEvent.getY());
            } else
            {

                flg = false;
                for (Smok c : tanks) {
                    if (c.mouseActivate(mouseEvent.getX(), mouseEvent.getY())) {
                        flg = true;
                        if (activeTanks.contains(c)) {
                            activeTanks.remove(c); // Видалити зі списку, якщо вже активний
                        } else {
                            activeTanks.add(c); // Додати до списку, якщо неактивний
                        }
                    }
                }
                if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
                    if (!flg) {
                        SmokParams.display(mouseEvent.getX(), mouseEvent.getY());
                    }
                }

                if (mouseEvent.getButton().equals(MouseButton.BACK)) {
                    World.stage.setScene(World.Menu);
                }
            }
        });
        World.world.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode().equals(KeyCode.TAB) )
            {
                Information.display();
            }

            if (keyEvent.getCode().equals(KeyCode.DELETE)) {
                Iterator<Smok> iterator = tanks.iterator();
                while (iterator.hasNext()) {
                    Smok s = iterator.next();
                    if (s.isActive()) {
                        iterator.remove();
                        s.DELETE();
                        if (s == activeTanks) { // Якщо видаляємо активний об'єкт, знімаємо активність
                            activeTanks = null;
                        }
                    }
                }
            }
        });

         World World = new World();
         World.World();
    }
    public static void main(String[] args) {
        launch();
    }
}