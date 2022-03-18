package com.example.nakupnilistek;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class NakupniListek extends Application {
    String[] texts;
    //creating label
    //v panelu splněno
    Label[] l = new Label[1000];
    //v panelu chybí
    Label[] l2 = new Label[1000];
    //creating text field
    TextField[] text = new TextField[1000];
    //creating check box
    CheckBox[] check = new CheckBox[1000];
    //creating buttons
    //neznam pocet
    Button btn[] = {new Button("přidat"),new Button("odebrat"),new Button("uložit"),new Button(),new Button()};
    //button pro potvrzeni
    Button[] btn2 = new Button[1000];
    //creating hboxes
    HBox[] line = new HBox[1000];
    //creating Vboxes
    VBox[] col = {new VBox(),new VBox(),new VBox(),new VBox()};
    //creating anchorpane
    AnchorPane safe[] = {new AnchorPane(),new AnchorPane(),new AnchorPane()};
    //creating tab
    Tab panel[] = {new Tab("Potřeba koupit"),new Tab("Splněno"),new Tab("Chybí")};
    //creating tabpane
    TabPane pane = new TabPane(panel[0], panel[1], panel[2]);
    //creating scrollpane
    ScrollPane roll[] ={new ScrollPane(),new ScrollPane(),new ScrollPane()};
    //creating scene
    Scene scene = new Scene(pane, 400, 480);
    //some function
    private void pridat(){
        if (col[0].getChildren().size() < text.length) {
            col[0].getChildren().addAll(line[col[0].getChildren().size()]);
            col[1].getChildren().addAll(l[col[1].getChildren().size()]);
            col[2].getChildren().addAll(l2[col[2].getChildren().size()]);
        }
    }
    private void odebrat(){
        if(col[0].getChildren().size() > 1) {
            col[0].getChildren().remove(col[0].getChildren().size() - 1);
            col[1].getChildren().remove(col[1].getChildren().size() - 1);
            col[2].getChildren().remove(col[2].getChildren().size() - 1);
        }
    }
    private void potvrdit(){
        texts[col[0].getChildren().size()] = text[col[0].getChildren().size()].getText();
        l2[col[2].getChildren().size()].setText(texts[col[0].getChildren().size()]);
        if(check[col[0].getChildren().size()].isSelected()){
            check[col[0].getChildren().size()].setSelected(true);
            l[col[1].getChildren().size()].setText(texts[col[0].getChildren().size()]);
            col[2].getChildren().remove(l[col[1].getChildren().size()]);
        }
    }

    @Override
    public void start(Stage stage) {
        texts = new String[1000];
        //fix null problem https://stackoverflow.com/questions/46246704/javafx-error-on-using-an-array-of-vbox-in-netbeans
        //vkladani do poli
        for (int i = 0; i < l.length; i++) {
            l[i] = new Label();
            l2[i] = new Label();
            text[i] = new TextField();
            text[i].setPromptText("Zadejte zboži");
            check[i] = new CheckBox();
            btn2[i] = new Button("Potvrdit");
            line[i] = new HBox();
            line[i].getChildren().addAll(check[i], text[i], btn2[i]);
        }
        for (int i = 0; i < 5; i++) {
            col[0].getChildren().addAll(line[i]);
            col[1].getChildren().addAll(l[i]);
            col[2].getChildren().addAll(l2[i]);
        }
        col[3].getChildren().addAll(btn[0], btn[1], btn[2]);
        safe[0].getChildren().addAll(col[0],col[3]);
        safe[1].getChildren().addAll(col[1]);
        safe[2].getChildren().addAll(col[2]);
        for (int i = 0; i < 3; i++) {
            col[i].relocate(110, 10);
        }

        //nezavrit panel: https://stackoverflow.com/questions/31531059/how-to-remove-close-button-from-tabs-in-javafx
        for (int i = 0; i < 3; i++) {
            panel[i].setOnCloseRequest(e -> e.consume());
        }
        // jak dat veci do tabu: https://www.educba.com/javafx-tabpane/
        for (int i = 0; i < 3; i++) {
            roll[i].setContent(safe[i]);
            panel[i].setContent(roll[i]);
        }
        //col[0].setAlignment(Pos.CENTER_LEFT);
        //col[1].setAlignment(Pos.CENTER_LEFT);
        //col[2].setAlignment(Pos.CENTER_LEFT);
        btn[0].setStyle("-fx-background-color: #FFFF0F;");

        //some functions
        //pridat
        btn[0].setOnAction((e)->{
           pridat();
        });
        //odebrat
        btn[1].setOnAction((e) -> {
            odebrat();
        });
        btn2[col[0].getChildren().size()].setOnAction((e)->{
            potvrdit();
        });
        //klaves. pridat
        pane.setOnKeyPressed((e)->{
            if(e.getCode() == KeyCode.CONTROL.P) {
                pridat();
            }
            if(e.getCode() == KeyCode.DELETE) {
               odebrat();
            }
        });
        //presune se do chybi
        //pro klavesy
        text[col[0].getChildren().size()].setOnKeyPressed((e) -> {
                if (e.getCode() == KeyCode.ENTER) {
                    //jak presout to do splneno:https://www.tutorialkart.com/javafx/javafx-textfield/
                    //https://stackoverflow.com/questions/20273820/how-to-copy-content-from-one-tab-to-another-in-javafx
                    //https://www.educba.com/javafx-textfield/
                    potvrdit();
                }
        });


    //vyresit
        //jak videt obrazek (1:34:21)https://www.youtube.com/watch?v=9XJicRt_FaI
       //stage.getIcons().add(new Image(getClass().getResourceAsStream("ikonka.png")));
        stage.setScene(scene);
        stage.setTitle("Nákupní seznam");
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}