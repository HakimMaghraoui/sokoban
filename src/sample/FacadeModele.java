package sample;

import javafx.scene.input.KeyCode;

public class FacadeModele {
    ModeleConcret modele = new ModeleConcret();

    public boolean win() { return modele.win(); }

    public void move(String m, boolean b) {
        modele.move(m,b);
    }

    public void undo() {  modele.undo(); }

    public void redo() {  modele.redo(); }

    public void reset() {
        modele.reset();
    }

    public String[][] getEtat() {
        return modele.getEtat();
    }


    public String getDirection(){
        return modele.getDirection();
    }

}
