package sample;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;

public class ModeleConcret implements Modele {
    private static String [][] map;//游戏操作的地图
    private static String [][] map2;//游戏操作的地图
    private static ArrayList<String> tabMove=new ArrayList<String>();
    private static String direction = "bottom";//玩家朝向  默认向下
    private int x=3;
    private int y=4;
    private int indice=-1;

    static {
        map = new String [][]{
                {"#","#","#","#","#","#","#","#","#","#"},
                {"#",".","$"," "," ","#",".","$"," ","#"},
                {"#"," "," "," "," ","#","#","#"," ","#"},
                {"#","#","#"," ","@"," "," "," "," ","#"},
                {"#"," "," "," "," "," ","#","#","#","#"},
                {"#",".","$"," "," "," "," ","$",".","#"},
                {"#","#","#","#","#","#","#","#","#","#"}
        };
        map2 = new String [][]{
                {"#","#","#","#","#","#","#","#","#","#"},
                {"#",".","$"," "," ","#",".","$"," ","#"},
                {"#"," "," "," "," ","#","#","#"," ","#"},
                {"#","#","#"," ","@"," "," "," "," ","#"},
                {"#"," "," "," "," "," ","#","#","#","#"},
                {"#",".","$"," "," "," "," ","$",".","#"},
                {"#","#","#","#","#","#","#","#","#","#"}
        };
    }



    public boolean win() {
        boolean win = true;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map2[i][j]=="."&&map[i][j]!="*") {
                    win = false;
                }
            }
        }
        return win;
    }

    public String[][] getEtat() {
        return map;
    }

    // m est une string qui peut etre egal a u,d,r,s,U,D,R,S.
    // b est une boolean qui indique si on enregistre le mouvement dans tabMove (true= on enregistre pas)
    public void move(String m, boolean b) {
        int f=0;
        int fb=0;
        switch (m) {
            case "u":
                direction = "top";
                if (map[x - 1][y].equals(" ") || map[x - 1][y].equals(".")) {
                    if(map[x - 1][y].equals(".")){
                        f=1;
                    }
                    if (map2[x][y].equals(".")) {
                        map[x][y] = ".";
                    } else {
                        map[x][y] = " ";
                    }
                    if (f==1){
                        map[x - 1][y] = "+";
                    }else {
                        map[x - 1][y] = "@";
                    }
                    x -= 1;
                    f=0;
                    if(!b){
                        tabMove.add("u");
                        indice++;
                    }
                }
                if (map[x - 1][y].equals("$") || map[x - 1][y].equals("*")) {
                    if (map[x - 2][y].equals(" ") || map[x - 2][y].equals(".")) {
                        if(map[x - 2][y].equals(".")){
                            fb=1;
                        }
                        if (map2[x][y].equals(".")) {
                            map[x][y] = ".";
                        } else {
                            map[x][y] = " ";
                        }
                        map[x - 1][y] = "@";
                        x -= 1;
                        if(fb==1){
                            map[x - 2][y] ="*";
                        }else {
                            map[x - 2][y] = "$";
                        }
                        fb=0;
                        if(!b){
                            tabMove.add("U");
                            indice++;
                        }
                    }
                }
                break;
            case "U":
                move("d",true);
                if(map2[x - 2][y].equals(".")){
                    map[x-2][y]=".";
                }else {
                    map[x-2][y]=" ";
                }
                break;
            case "d":
                direction = "bottom";
                if (map[x + 1][y].equals(" ") || map[x + 1][y].equals(".")) {
                    if(map[x + 1][y].equals(".")){
                        f=1;
                    }
                    if (map2[x][y].equals(".")) {
                        map[x][y] = ".";
                    } else {
                        map[x][y] = " ";
                    }
                    if(f==1){
                        map[x + 1][y] = "+";
                    }else {
                        map[x + 1][y] = "@";
                    }
                    x += 1;
                    f=0;
                    if(!b){
                        tabMove.add("d");
                        indice++;
                    }
                }
                if (map[x + 1][y].equals("$") || map[x + 1][y].equals("*")) {
                    if (map[x + 2][y].equals(" ") || map[x + 2][y].equals(".")) {
                        if(map[x + 2][y].equals(".")){
                            fb=1;
                        }
                        if (map2[x][y].equals(".")) {
                            map[x][y] = ".";
                        } else {
                            map[x][y] = " ";
                        }
                        map[x + 1][y] = "@";
                        x += 1;
                        if(fb==1){
                            map[x + 2][y] = "*";
                        }else {
                            map[x + 2][y] = "$";
                        }
                        fb=0;
                        if(!b){
                            tabMove.add("D");
                            indice++;
                        }

                    }
                }
                break;
            case "D":
                move("u",true);
                if(map2[x + 2][y].equals(".")){
                    map[x+2][y]=".";
                }else {
                    map[x+2][y]=" ";
                }
                break;
            case "l":
                direction = "left";
                if (map[x][y - 1].equals(" ") || map[x][y - 1].equals(".")) {
                    if(map[x][y - 1].equals(".")){
                        f=1;
                    }
                    if (map2[x][y].equals(".")) {
                        map[x][y] = ".";
                    } else {
                        map[x][y] = " ";
                    }
                    if(f==1){
                        map[x][y - 1] = "+";
                    }else {
                        map[x][y - 1] = "@";
                    }
                    y -= 1;
                    f=0;
                    if(!b){
                        tabMove.add("l");
                        indice++;
                    }
                    break;
                }
                if (map[x][y - 1].equals("$") || map[x][y - 1].equals("*")) {
                    if (map[x][y - 2].equals(" ") || map[x][y - 2].equals(".")) {
                        if(map[x][y - 2].equals(".")){
                            fb=1;
                        }
                        if (map2[x][y].equals(".")) {
                            map[x][y] = ".";
                        } else {
                            map[x][y] = " ";
                        }
                        map[x][y - 1] = "@";
                        if(fb==1){
                            map[x][y - 2] = "*";
                        }else {
                            map[x][y - 2] = "$";
                        }
                        y -= 1;
                        fb=0;
                        if(!b){
                            tabMove.add("L");
                            indice++;
                        }

                    }
                }
                break;
            case "L":
                move("r",true);
                if(map2[x][y - 2].equals(".")){
                    map[x][y-2]=".";
                }else {
                    map[x][y-2]=" ";
                }
                break;
            case "r":
                direction = "right";
                if (map[x][y + 1].equals(" ") || map[x][y + 1].equals(".")) {
                    if(map[x][y + 1].equals(".")){
                        f=1;
                    }
                    if (map2[x][y].equals(".")) {
                        map[x][y] = ".";
                    } else {
                        map[x][y] = " ";
                    }
                    if(f==1){
                        map[x][y + 1] = "@";
                    }else {
                        map[x][y + 1] = "@";
                    }
                    y += 1;
                    f=0;
                    if(!b){
                        tabMove.add("r");
                        indice++;
                    }
                    break;
                }
                if (map[x][y + 1].equals("$") || map[x][y + 1].equals("*")) {
                    if (map[x][y + 2].equals(" ") || map[x][y + 2].equals(".")) {
                        if (map[x][y + 2].equals(".")){
                            fb=1;
                        }
                        if (map2[x][y].equals(".")) {
                            map[x][y] = ".";
                        } else {
                            map[x][y] = " ";
                        }
                        map[x][y + 1] = "@";
                        if(fb==1){
                            map[x][y + 2] = "*";
                        }else {
                            map[x][y + 2] = "$";
                        }
                        y += 1;
                        fb=0;
                        if(!b){
                            tabMove.add("R");
                            indice++;
                        }

                    }
                }
                break;
            case "R":
                move("l",true);
                if(map2[x][y + 2].equals(".")){
                    map[x][y+2]=".";
                }else {
                    map[x][y+2]=" ";
                }
                break;
            default:
                break;
        }
    }

    //teste d'abord si on a le droit de faire undo (c-a-d si on a deja fait un coup).
    //apres in appelle la methode move avec les differente cas
    // lettre majuscule on a geré le cas
    // lettre minuscule on appelle move avec le mouvement opposé
    public void undo(){
        if(indice>=0) {
            if (tabMove.get(indice).equals("U") || tabMove.get(indice).equals("D") || tabMove.get(indice).equals("L") || tabMove.get(indice).equals("R")) {
                move(tabMove.get(indice), true);
            } else {
                switch (tabMove.get(indice)) {
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
            indice--;
        }
    }

    //on teste d'abord si on a le droit de faire redo(c-a-d si on a des mouvements stockée dans la liste apre l'indice)
    //si la lettre et majusucule on la convert en minuscule et on appelle move
    //sinon on appelle simplement move avec le symbole
    public void redo(){
        if(indice<tabMove.size()-1){
            switch(tabMove.get(indice+1)){
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
                    move(tabMove.get(indice+1),true);
                    break;
            }
            indice++;
        }
    }

    @Override
    public void reset() {
        map = new String [][]{
                {"#","#","#","#","#","#","#","#","#","#"},
                {"#",".","$"," "," ","#",".","$"," ","#"},
                {"#"," "," "," "," ","#","#","#"," ","#"},
                {"#","#","#"," ","@"," "," "," "," ","#"},
                {"#"," "," "," "," "," ","#","#","#","#"},
                {"#",".","$"," "," "," "," ","$",".","#"},
                {"#","#","#","#","#","#","#","#","#","#"}
        };
        x=3;
        y=4;
    }

    public String getDirection() {
        return direction;
    }

}
