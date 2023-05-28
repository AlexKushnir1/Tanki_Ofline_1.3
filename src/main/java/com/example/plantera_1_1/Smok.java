package com.example.plantera_1_1;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;

import static com.example.plantera_1_1.HelloApplication.activeTanks;

public class Smok {
    private final Rectangle _rectangle;
    private Text name;
    private int health;
    //-----------------------------------------
//    private double dmg;
//    private double speed = 5;
    //-----------------------------------------
    private Line _health;

    private Text _Armor;

    private ImageView imvSmok;

//    private static List<Smok> activeTanks = new ArrayList<>();

    private double x, y;


    private boolean active;

    //---------------------------------- ----------------------------------------
    {
        imvSmok = new ImageView(HelloApplication.imgSmok);
        System.out.println("Не статичний блок");
    }

    //--------------------------------------------------------------------------
    static {
        System.out.println("Статичний блок");
    }

    //---------------------------------------------------------------------------
    public Smok(String n, String w, int h, double _x, double _y) {
        x = _x;
        y = _y;

        _rectangle = new Rectangle(x, y, HelloApplication.imgSmok.getWidth() + 10, HelloApplication.imgSmok.getHeight() + 10);
        _rectangle.setFill(Color.TRANSPARENT);
        _rectangle.setStroke(Color.DARKGOLDENROD);
        _rectangle.setStrokeWidth(2);

        name = new Text(n);
        name.setLayoutX(x + 15);
        name.setLayoutY(y + 13);
        name.setFont(Font.font("Harrington", 14));

        _Armor = new Text(w);
        _Armor.setLayoutX(x + 15);
        _Armor.setLayoutY(y + 25);
        _Armor.setFont(Font.font("Harrington", 14));

        health = h;
        _health = new Line(x + 15, y + 29, x - 17 + health, y + 29);
        _health.setStrokeWidth(5);
        _health.setStroke(Color.DARKGREEN);

        imvSmok.setX(x);
        imvSmok.setY(y + 15 + 7);
        imvSmok.setRotate(90);

        active = false;
        World.group.getChildren().addAll(name, _health, imvSmok, this._Armor);
    }

    public void DELETE() {
        setActive(false);
        World.group.getChildren().removeAll(name, _health, imvSmok, _Armor);
    }

    public boolean isActive() {
        return active;
    }

    public boolean flipActivation() {
        if (isActive()) {
            World.group.getChildren().remove(_rectangle);
            World.world.setOnKeyPressed(null);
        } else {
            World.world.setOnKeyPressed(new EventHandler<KeyEvent>() {

                @Override
                public void handle(KeyEvent keyEvent) {
                    for (Smok s : HelloApplication.tanks) {
                        if (s.isActive()) {

                            double activex = 0.0;
                            double activey = 0.0;

                            if (keyEvent.getCode().equals(KeyCode.W)) {
                                activey = -10.0;
                                imvSmok.setScaleX(1);
                                imvSmok.setRotate(0);
                            }
                            if (keyEvent.getCode().equals(KeyCode.A)) {
                                activex = -10.0;
                                imvSmok.setScaleX(-1);
                                imvSmok.setRotate(270);
                            }

                            if (keyEvent.getCode().equals(KeyCode.Q)) {
                                activex = -15.0;
                                activey = -15.0;
                                imvSmok.setScaleX(-1);
                                imvSmok.setRotate(315);
                            }

                            if (keyEvent.getCode().equals(KeyCode.C)) {
                                activex = +15.0;
                                activey = +15.0;
                                imvSmok.setScaleX(1);
                                imvSmok.setRotate(135);
                            }

                            if (keyEvent.getCode().equals(KeyCode.E)) {
                                activex = +15.0;
                                activey = -15.0;
                                imvSmok.setScaleX(1);
                                imvSmok.setRotate(45);
                            }
                            if (keyEvent.getCode().equals(KeyCode.Z)) {
                                activex = -15.0;
                                activey = +15.0;
                                imvSmok.setScaleX(-1);
                                imvSmok.setRotate(225);
                            }

                            if (keyEvent.getCode().equals(KeyCode.S)) {
                                activey = +10.0;
                                imvSmok.setScaleX(1);
                                imvSmok.setRotate(180);
                            }
                            if (keyEvent.getCode().equals(KeyCode.D)) {
                                activex = +10.0;
                                imvSmok.setScaleX(1);
                                imvSmok.setRotate(90);
                            }
                            if(HelloApplication.flg)
                            {
                                for( Smok c:HelloApplication.tanks )
                                {
                                    if(c.isActive())
                                    {
                                        c.move(activex, activey);
                                    }
                                }
                            }
                        }

                        }

                }

            });
            World.group.getChildren().add(_rectangle);
            // обновлюємо координати прямокутника відносно координат об'єкта
            _rectangle.setX(imvSmok.getX() + imvSmok.getFitWidth() / 2 - _rectangle.getWidth() / 2);
            _rectangle.setY(imvSmok.getY() + imvSmok.getFitHeight() / 2 - _rectangle.getHeight() / 2);
            // створюємо таймер, який буде оновлювати координати прямокутника разом з об'єктом
            AnimationTimer timer = new AnimationTimer() {
                @Override
                public void handle(long l) {
                    _rectangle.setX(imvSmok.getX() - 5);
                    _rectangle.setY(imvSmok.getY() - 5);
                }
            };
            timer.start();

        }
        active = !active;
        return active;
    }

    public boolean mouseActivate(double mx, double my) {
        if (imvSmok.boundsInParentProperty().get().contains(mx, my)) {
            if (activeTanks.size() == 1) {
                // якщо лише один елемент, робимо його активним
                setActive(true);
            } else {
                boolean isActive = activeTanks.contains(this);
                if (isActive) {
                    // якщо об'єкт уже активний, видаляємо його зі списку
                    activeTanks.remove(this);
                    setActive(false);
                } else {
                    // якщо об'єкт неактивний, додаємо його до списку
                    activeTanks.add(this);
                    setActive(true);
                }
            }
            return true;
        }
        return false;
    }

    public void setActive(boolean active) {
        if (active) {
            // додаємо елемент до списку активних об'єктів
            activeTanks.add(this);
            flipActivation();
        } else {
            // видаляємо елемент із списку активних об'єктів
            HelloApplication.activeTanks.remove(this);
            flipActivation();
        }
    }

    @Override
    public String toString() {
        return "Smok{" +
                "name = " + name.getText() +
                ", _Weight = " + _Armor.getText() +
                ", health = " + health +
                ", x = " + x +
                ", y = " + y +
                '}';
    }

    public String getName() {
        return name.getText();
    }

    public String getWeight() {
        return _Armor.getText();
    }

    public void setWeight(String w) {
        _Armor.setText(w);
    }

    public void setName(String n) {
        name.setText(n);
    }

    public String getHealth() {
        return Double.toString(health);
    }

    public void setHealth(String h) {

        try {
            health = Integer.parseInt(h);
        } catch (Exception e) {
            health = 0;
        }
        _health.setStartX(x + 15);
        _health.setStartY(y + 29);
        _health.setEndX(x - 17 + health);
        _health.setEndY(y + 29);

//        HelloApplication.group.getChildren().remove(life);
//        life=new Line(x,y+15, x+health,y+15);
//        life.setStrokeWidth(5);
//        life.setStroke(Color.LIGHTGREEN);
//        HelloApplication.group.getChildren().add(life);
    }

    public void setCoordinates() {
        name.setLayoutX(x + 15);
        name.setLayoutY(y + 13);

        _Armor.setLayoutX(x + 15);
        _Armor.setLayoutY(y + 25);

        _health.setStartX(x + 15);
        _health.setStartY(y + 29);
        _health.setEndX(x - 17 + health);
        _health.setEndY(y + 29);

        //        HelloApplication.group.getChildren().remove(life);
//        life=new Line(x,y+15, x+health,y+15);
//        life.setStrokeWidth(5);
//        life.setStroke(Color.LIGHTGREEN);
//        HelloApplication.group.getChildren().add(life);

        imvSmok.setX(x);
        imvSmok.setY(y + 15 + 7);
    }

    public String getX() {
        return Double.toString(x);
    }

    public void setX(double _x) {
        x = _x;
        setCoordinates();
    }

    public void setX(String sX) {
        try {
            x = Double.parseDouble(sX);
        } catch (Exception e) {
            x = 0.0;
        }

        setX(x);
    }

    public String getY() {
        return Double.toString(y);
    }

    public void setY(double _y) {
        y = _y;

        setCoordinates();
    }

    public void setY(String sY) {
        try {
            y = Double.parseDouble(sY);
        } catch (Exception e) {
            y = 0.0;
        }

        setY(y);
    }


    public void move(double dx, double dy) {
        x = x + dx;
        y = y + dy;
        setCoordinates();
    }
}
