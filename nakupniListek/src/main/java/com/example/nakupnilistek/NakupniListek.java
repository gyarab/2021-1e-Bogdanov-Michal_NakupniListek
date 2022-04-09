package com.example.nakupnilistek;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class NakupniListek extends Application {
    //index pro pole
    int x = 100;
    int[] findIndex = new int[x];
    String[] texts = new String[x];;
    String getAdress ;
    //creating label
    //v panelu splněno
    Label[] ldone = new Label[x];
    //v panelu chybí
    Label[] lmiss = new Label[x];
    //creating text field
    TextField[] text = new TextField[x];
    TextField adress = new TextField();
    //creating check box
    CheckBox[] check = new CheckBox[x];
    //creating buttons
    //neznam pocet
    Button btn[] = {new Button("přidat"),new Button("odebrat"),new Button("uložit"),new Button("uložit"),new Button()};
    //button pro potvrzeni
    Button[] btn2 = new Button[x];
    //creating hbox
    HBox[] line = new HBox[x];
    //creating Vboxes
    VBox[] col = {new VBox(),new VBox(),new VBox(),new VBox(),new VBox(adress, btn[3])};
    //creating anchorpane
    AnchorPane safe[] = {new AnchorPane(),new AnchorPane(),new AnchorPane()};
    //creating tab
    Tab panel[] = {new Tab("Potřeba koupit"),new Tab("Splněno"),new Tab("Chybí")};
    //creating tabpane
    TabPane pane = new TabPane(panel[0], panel[1], panel[2]);
    //creating scrollpane
    ScrollPane roll[] ={new ScrollPane(),new ScrollPane(),new ScrollPane()};
    //creating FileChooser
    FileChooser filechoose = new FileChooser();
    //creating scene
    Scene scene = new Scene(pane,400,480);
    //creating stage
    Stage stage1 = new Stage();

    //some function
   private void zakladna(){
        for(int i=0; i < x; i++ ) {
            //fix null problem https://stackoverflow.com/questions/46246704/javafx-error-on-using-an-array-of-vbox-in-netbeans
            if (i < 100) {
                ldone[i] = new Label();
                lmiss[i] = new Label();
                text[i] = new TextField();
                text[i].setPromptText("Zadejte zboži");
                check[i] = new CheckBox();
                btn2[i] = new Button("Potvrdit");
                line[i] = new HBox();
                line[i].getChildren().addAll(check[i], text[i], btn2[i]);
                line[i].setAlignment(Pos.CENTER);
            }
            if (i < 5) {
                col[0].getChildren().addAll(line[i]);
                col[1].getChildren().addAll(ldone[i]);
                col[2].getChildren().addAll(lmiss[i]);
            }
            if(i<3){
               col[i].relocate(110, 10);
                // jak dat veci do tabu: https://www.educba.com/javafx-tabpane/
                //nezavrit panel: https://stackoverflow.com/questions/31531059/how-to-remove-close-button-from-tabs-in-javafx
                panel[i].setOnCloseRequest(e -> e.consume());
                roll[i].setContent(safe[i]);
                panel[i].setContent(roll[i]);
            }
        }
    }
    private void pridat(){
        if (col[0].getChildren().size() < text.length) {
            col[0].getChildren().addAll(line[col[0].getChildren().size()]);
            col[1].getChildren().addAll(ldone[col[1].getChildren().size()]);
            col[2].getChildren().addAll(lmiss[col[2].getChildren().size()]);
        }
    }
    private void odebrat(){
        if(col[0].getChildren().size() > 1) {
            for(int i=0; i< 3; i++) {
                col[i].getChildren().remove(col[i].getChildren().size() - 1);
            }
        }
    }
    private void potvrdit() {
        for(int i = 0; i < x;i++) {
            findIndex[i] = i;
            int z = (int) Array.get(findIndex, i);
            btn2[i].setOnAction((e) -> {
                //jak ziskat index:https://www.geeksforgeeks.org/array-get-method-in-java/
                texts[z] = text[z].getText();
                lmiss[z].setText(texts[z]);
                line[z].getChildren().remove(btn2[z]);
                check[z].setOnAction((e2)->{
                    check[z].setSelected(true);
                    if (check[z].isSelected()) {
                        ldone[z].setText(texts[z]);
                        col[2].getChildren().removeAll(lmiss[z]);
                    }
                });
            });
            //potvrdit
          text[i].setOnKeyPressed((e) -> {
                if (e.getCode() == KeyCode.ENTER) {
                    //jak presunout to do splneno:https://www.tutorialkart.com/javafx/javafx-textfield/
                    //https://stackoverflow.com/questions/20273820/how-to-copy-content-from-one-tab-to-another-in-javafx
                    //https://www.educba.com/javafx-textfield/
                    texts[z] = text[z].getText();
                    lmiss[z].setText(texts[z]);
                    line[z].getChildren().remove(btn2[z]);
                    check[z].setOnAction((e2)->{
                        check[z].setSelected(true);
                        if (check[z].isSelected()) {
                            ldone[z].setText(texts[z]);
                            col[2].getChildren().remove(lmiss[z]);
                        }
                    });
                }
            });
        }

    }
    private void ulozit(){
       //https://www.tutorialspoint.com/how-to-save-files-using-a-file-chooser-in-javafx
        filechoose.showSaveDialog(stage1);
        filechoose.setTitle("Save");
        filechoose.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Only text files", "*.txt*"));
    }
    @Override
    public void start(Stage stage) {
        zakladna();
        potvrdit();
        //vkladani do poli
        col[3].getChildren().addAll(btn[0], btn[1], btn[2]);
        safe[0].getChildren().addAll(col[0],col[3]);
        safe[1].getChildren().addAll(col[1]);
        safe[2].getChildren().addAll(col[2]);

        col[0].setAlignment(Pos.CENTER);
        col[1].setAlignment(Pos.CENTER);
        col[2].setAlignment(Pos.CENTER);
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
        btn[2].setOnAction((e)->{
            ulozit();
        });
        //klaves. pridat a odebrat
        pane.setOnKeyPressed((e)->{
            if(e.getCode() == KeyCode.CONTROL.P) {
                pridat();
            }
            if(e.getCode() == KeyCode.DELETE) {
               odebrat();
            }
        });
        //vyresit
        // jak videt obrazek (1:34:21)https://www.youtube.com/watch?v=9XJicRt_FaI
        //stage.getIcons().add(new Image(HelloApplication.class.getResourceAsStream("ikonka.png")));
        stage.setScene(scene);
        stage.setTitle("Nákupní seznam");
        stage.show();


    }
    public static void main(String[] args) {
        launch();
    }
}