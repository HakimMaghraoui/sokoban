package sample;

import java.util.ArrayList;

public class ModeleUndoRedo implements Modele {
    ModeleConcret m;

    public ModeleUndoRedo(ModeleConcret modeleConcret) {
        m=modeleConcret;
    }

    public void undo(){
        if(m.getIndice()>=0) {
            if (m.getTabMove().get(m.getIndice()).equals("U") || m.getTabMove().get(m.getIndice()).equals("D") || m.getTabMove().get(m.getIndice()).equals("L") || m.getTabMove().get(m.getIndice()).equals("R")) {
                move(m.getTabMove().get(m.getIndice()), true);
            } else {
                switch (m.getTabMove().get(m.getIndice())) {
                    case "u":
                        move("d", true);
                        break;
                    case "d":
                        move("u", true);
                        break;
                    case "r":
                        move("l", true);
                        break;
                    case "l":
                        move("r", true);
                        break;
                    default:
                        break;
                }
            }
            m.setIndice(m.getIndice()-1);
        }
    }

    public void redo(){
        if(m.getIndice()<m.getTabMove().size()-1){
            switch(m.getTabMove().get(m.getIndice()+1)){
                case "U":
                    move("u", true);
                    break;
                case "D":
                    move("d", true);
                    break;
                case "L":
                    move("l", true);
                    break;
                case "R":
                    move("r", true);
                    break;
                default:
                    move(m.getTabMove().get(m.getIndice()+1),true);
                    break;
            }
            m.setIndice(m.getIndice()+1);
        }
    }

    public String [][] getEtat() {
        return m.getEtat();
    }

    @Override
    public void chargerNiveau(String[][] mapTmp) {
        m.chargerNiveau(mapTmp);
    }

    @Override
    public void move(String mm, boolean b) {
        m.move(mm,b);
    }

    @Override
    public void reset() {
        m.reset();
    }

}
