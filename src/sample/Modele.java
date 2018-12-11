package sample;

import javafx.scene.input.KeyCode;

public interface Modele {
     String [][] getEtat();

     boolean win();
     void move(String m, boolean b);
     void reset();
     void undo();
     void redo();
}
