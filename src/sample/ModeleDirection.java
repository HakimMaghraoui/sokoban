package sample;

import javafx.scene.input.KeyCode;

public class ModeleDirection implements Modele {
    String direction= "bottom";
    Modele modele;


    public ModeleDirection(Modele modele) {
        this.modele = modele;
    }

    public String getDirection(){
        return direction;
    }
    @Override
    public String[][] getEtat() {
        return modele.getEtat();
    }

    @Override
    public void chargerNiveau(String[][] mapTmp) {
        modele.chargerNiveau(mapTmp);
    }

    @Override
    public void move(String m, boolean b) {
        switch (m){
            case "u":
                direction = "top";
                break;
            case "U":
                direction = "top";
                break;
            case "d":
                direction = "bottom";
                break;
            case "D":
                direction = "bottom";
                break;
            case "l":
                direction = "left";
                break;
            case "L":
                direction = "left";
                break;
            case "r":
                direction = "right";
                break;
            case "R":
                direction = "right";
                break;
        }
        modele.move(m,b);
    }

    @Override
    public void reset() {
        modele.reset();
    }
}
