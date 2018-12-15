package sample;

import javafx.scene.input.KeyCode;

import java.util.ArrayList;

public interface Modele {
     String[][] getEtat();
     void chargerNiveau(String [][]mapTmp);
     void move(String m, boolean b);
     void reset();

}
