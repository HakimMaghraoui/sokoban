package sample;


import javafx.scene.input.KeyCode;
import javafx.scene.control.Alert;

import java.util.ArrayList;

public class ModeleConcret implements Modele {
    private static String [][] map;
    private static String [][] map2;
    private static ArrayList<String> tabMove=new ArrayList<String>();
    private int indice=-1;
    private static int x=0;
    private static int y=0;

    public ArrayList<String> getTabMove(){
        return tabMove;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int i){
        indice=i;
    }

    public boolean win() {
        boolean win = true;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                switch(map2[i][j]){
                    case ".":
                        if(map[i][j]!="*"){
                            win=false;
                        }
                        break;
                    case "*":
                        if(map[i][j]!="*"){
                            win=false;
                        }
                        break;
                    case "+":
                        if(map[i][j]!="*"){
                            win=false;
                        }
                }
            }
        }
        return win;
    }

     public void chargerNiveau(String [][]mapTmp){

         map2=new String[mapTmp.length][mapTmp[0].length];
         map=new String[mapTmp.length][mapTmp[0].length];

         for(int a=0;a<mapTmp.length;a++){
            for (int b=0;b<mapTmp[a].length;b++){
                map2[a][b]=""+mapTmp[a][b];
            }
         }
         reset();

    }

    public String [][] getEtat() {
        return map;
    }

    public  void afficher(){
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    public void move(String m, boolean b) {
        int f=0;
        int fb=0;
        switch (m) {
            case "u":
                boolean u=false;
                if (map[x - 1][y].equals(" ") || map[x - 1][y].equals(".")) {
                    if(map[x - 1][y].equals(".")){
                        f=1;
                    }
                    if (map2[x][y].equals(".")||map2[x][y].equals("*")) {
                        map[x][y] = ".";
                    } else {
                        map[x][y] = " ";
                    }
                    if (map2[x][y].equals("+")){
                        map[x][y] = ".";
                    }

                    if (f==1){
                        map[x - 1][y] = "+";
                    }else {
                        map[x - 1][y] = "@";
                    }
                    u=true;
                    f=0;
                    if(!b){
                        tabMove.add("u");
                        indice++;
                    }
                    for(int k=0; k<tabMove.size();k++){
                        System.out.print(tabMove.get(k)+" / ");
                    }
                    System.out.println(indice);
                }
                if (map[x - 1][y].equals("$") || map[x - 1][y].equals("*")) {
                    if (map[x - 2][y].equals(" ") || map[x - 2][y].equals(".")) {
                        if(map[x - 2][y].equals(".")){
                            fb=1;
                        }
                        if (map2[x][y].equals(".")||map2[x][y].equals("+")||map2[x][y].equals("*")) {
                            map[x][y] = ".";
                        } else {
                            map[x][y] = " ";
                        }
                        if(map[x-1][y].equals("*")){
                            map[x - 1][y] = "+";
                        }else{
                            map[x - 1][y] = "@";
                        }
                        u=true;
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
                        for(int k=0; k<tabMove.size();k++){
                            System.out.print(tabMove.get(k)+" / ");
                        }
                        System.out.println(indice);
                    }
                }
                if(u){
                    x-=1;
                }
                break;
            case "U":
                move("d",true);
                if(map2[x - 2][y].equals(".")||map2[x-2][y].equals("+")){
                    map[x-2][y]=".";
                }else {
                    map[x-2][y]=" ";
                }
                break;
            case "d":
                boolean d=false;
                if (map[x + 1][y].equals(" ") || map[x + 1][y].equals(".")) {
                    if(map[x + 1][y].equals(".")){
                        f=1;
                    }
                    if (map2[x][y].equals(".")||map2[x][y].equals("*")) {
                        map[x][y] = ".";
                    } else {
                        map[x][y] = " ";
                    }
                    if (map2[x][y].equals("+")){
                        map[x][y] = ".";
                    }
                    if(f==1){
                        map[x + 1][y] = "+";
                    }else {
                        map[x + 1][y] = "@";
                    }
                    d=true;
                    f=0;
                    if(!b){
                        tabMove.add("d");
                        indice++;
                    }
                    for(int k=0; k<tabMove.size();k++){
                        System.out.print(tabMove.get(k)+" / ");
                    }
                    System.out.println(indice);
                }
                if (map[x + 1][y].equals("$") || map[x + 1][y].equals("*")) {
                    if (map[x + 2][y].equals(" ") || map[x + 2][y].equals(".")) {
                        if(map[x + 2][y].equals(".")){
                            fb=1;
                        }
                        if (map2[x][y].equals(".")||map2[x][y].equals("+")||map2[x][y].equals("*")) {
                            map[x][y] = ".";
                        } else {
                            map[x][y] = " ";
                        }
                        if(map[x+1][y].equals("*")){
                            map[x + 1][y] = "+";
                        }else{
                            map[x + 1][y] = "@";
                        }
                        d=true;
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
                        for(int k=0; k<tabMove.size();k++){
                            System.out.print(tabMove.get(k)+" / ");
                        }
                        System.out.println(indice);

                    }
                }
                if(d){
                    x+=1;
                }
                break;
            case "D":
                move("u",true);
                if(map2[x + 2][y].equals(".")||map2[x-2][y].equals("+")){
                    map[x+2][y]=".";
                }else {
                    map[x+2][y]=" ";
                }
                break;
            case "l":
                boolean l=false;
                if (map[x][y - 1].equals(" ") || map[x][y - 1].equals(".")) {
                    if(map[x][y - 1].equals(".")){
                        f=1;
                    }
                    if (map2[x][y].equals(".")||map2[x][y].equals("*")) {
                        map[x][y] = ".";
                    } else {
                        map[x][y] = " ";
                    }
                    if(f==1){
                        map[x][y - 1] = "+";
                    }else {
                        map[x][y - 1] = "@";
                    }
                    if (map2[x][y].equals("+")){
                        map[x][y] = ".";
                    }
                    l=true;
                    f=0;
                    if(!b){
                        tabMove.add("l");
                        indice++;
                    }
                    for(int k=0; k<tabMove.size();k++){
                        System.out.print(tabMove.get(k)+" / ");
                    }
                    System.out.println(indice);

                }
                if (map[x][y - 1].equals("$") || map[x][y - 1].equals("*")) {
                    if (map[x][y - 2].equals(" ") || map[x][y - 2].equals(".")) {
                        if(map[x][y - 2].equals(".")){
                            fb=1;
                        }
                        if (map2[x][y].equals(".")||map2[x][y].equals("+")||map2[x][y].equals("*")) {
                            map[x][y] = ".";
                        } else {
                            map[x][y] = " ";
                        }
                        if(map[x][y-1].equals("*")){
                            map[x][y-1] = "+";
                        }else{
                            map[x][y-1] = "@";
                        }
                        if(fb==1){
                            map[x][y - 2] = "*";
                        }else {
                            map[x][y - 2] = "$";
                        }
                        l=true;
                        fb=0;
                        if(!b){
                            tabMove.add("L");
                            indice++;
                        }
                        for(int k=0; k<tabMove.size();k++){
                            System.out.print(tabMove.get(k)+" / ");
                        }
                        System.out.println(indice);

                    }
                }
                if(l){
                    y-=1;
                }
                break;
            case "L":
                move("r",true);
                if(map2[x][y - 2].equals(".")||map2[x-2][y].equals("+")){
                    map[x][y-2]=".";
                }else {
                    map[x][y-2]=" ";
                }
                break;
            case "r":
                boolean r=false;
                if (map[x][y + 1].equals(" ") || map[x][y + 1].equals(".")) {
                    if(map[x][y + 1].equals(".")){
                        f=1;
                    }
                    if (map2[x][y].equals(".")||map2[x][y].equals("*")) {
                        map[x][y] = ".";
                    } else {
                        map[x][y] = " ";
                    }
                    if(f==1){
                        map[x][y + 1] = "+";
                    }else {
                        map[x][y + 1] = "@";
                    }
                    if (map2[x][y].equals("+")){
                        map[x][y] = ".";
                    }
                    r=true;
                    f=0;
                    if(!b){
                        tabMove.add("r");
                        indice++;
                    }
                    for(int k=0; k<tabMove.size();k++){
                        System.out.print(tabMove.get(k)+" / ");
                    }
                    System.out.println(indice);

                }
                if (map[x][y + 1].equals("$") || map[x][y + 1].equals("*")) {
                    if (map[x][y + 2].equals(" ") || map[x][y + 2].equals(".")) {
                        if (map[x][y + 2].equals(".")){
                            fb=1;
                        }
                        if (map2[x][y].equals(".")||map2[x][y].equals("+")||map2[x][y].equals("*")) {
                            map[x][y] = ".";
                        } else {
                            map[x][y] = " ";
                        }
                        if(map2[x][y+1].equals("*")){
                            map[x][y+1] = "+";
                        }else{
                            map[x][y+1] = "@";
                        }
                        if(fb==1){
                            map[x][y + 2] = "*";
                        }else {
                            map[x][y + 2] = "$";
                        }
                        r=true;
                        fb=0;
                        if(!b){
                            tabMove.add("R");
                            indice++;
                        }
                        for(int k=0; k<tabMove.size();k++){
                            System.out.print(tabMove.get(k)+" / ");
                        }
                        System.out.println(indice);

                    }
                }
                if(r){
                    y+=1;
                }
                break;
            case "R":
                move("l",true);
                if(map2[x][y + 2].equals(".")||map2[x-2][y].equals("+")){
                    map[x][y+2]=".";
                }else {
                    map[x][y+2]=" ";
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void reset() {

        for (int i = 0; i < map2.length; i++) {
            for (int j = 0; j < map2[i].length; j++) {
                map[i][j]=""+map2[i][j];
                if (map2[i][j]!=null && (map2[i][j].equals("@")||map2[i][j].equals("+"))){
                    x=i;
                    y=j;
                }

            }
            }

    }




}
