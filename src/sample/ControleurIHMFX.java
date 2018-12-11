package sample;

import com.sun.org.apache.xpath.internal.functions.FuncFalse;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class ControleurIHMFX {
    Controleur controleur;
    VueIHMFX vue;
    Button reset,undo;
    EventHandler<Event>event;

    ControleurIHMFX(Controleur controleur, VueIHMFX vue) {
        this.controleur = controleur;
        this.vue = vue;

        //ICI
        event=new EventHandler<Event>() {
            public void handle(Event event) {
                //获取键码
                KeyEvent ke = (KeyEvent) event;
                //强转
                KeyCode code = ke.getCode();
                switch (code){
                    case UP:
                        controleur.move("u",false);
                        break;
                    case DOWN:
                        controleur.move("d",false);
                        break;
                    case LEFT:
                        controleur.move("l",false);
                        break;
                    case RIGHT:
                        controleur.move("r",false);
                        break;
                }

                if(controleur.win()){
                    vue.afficheWin();
                }
            }
        };

        reset = new Button("Reset");
        reset.setOnAction(new ActionReset());
        undo = new Button("Undo");
        undo.setOnAction(new ActionUndo());
    }

    class ActionReset implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event) {
            controleur.reset();
        }
    }
    class ActionUndo implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event) {

        }
    }

}