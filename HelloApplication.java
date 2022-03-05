package com.example.nakupnilistek;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {
        TextField text = new TextField();
        TextField text2 = new TextField();
        TextField text3 = new TextField();
        TextField text4 = new TextField();
        TextField text5 = new TextField();
        TextField text6 = new TextField();
        TextField text7 = new TextField();
        TextField text8 = new TextField();
        TextField text9 = new TextField();
        TextField text10 = new TextField();

        CheckBox check = new CheckBox();
        CheckBox check2 = new CheckBox();
        CheckBox check3 = new CheckBox();
        CheckBox check4 = new CheckBox();
        CheckBox check5 = new CheckBox();
        CheckBox check6 = new CheckBox();
        CheckBox check7 = new CheckBox();
        CheckBox check8 = new CheckBox();
        CheckBox check9 = new CheckBox();
        CheckBox check10 = new CheckBox();


        Button button = new Button(" + ");
        button.relocate(190, 300);

        HBox line = new HBox(check, text);
        HBox line2 = new HBox(check2, text2);
        HBox line3 = new HBox(check3, text3);
        HBox line4 = new HBox(check4, text4);
        HBox line5 = new HBox(check5, text5);
        HBox line6 = new HBox(check6, text6);
        HBox line7 = new HBox(check7, text7);
        HBox line8 = new HBox(check8, text8);
        HBox line9 = new HBox(check9, text9);
        HBox line10 = new HBox(check10, text10);

        VBox col = new VBox(line,line2,line3,line4,line5,line6,line7,line8,line9,line10);
        col.relocate(110,10);

        AnchorPane safe = new AnchorPane(col, button);
        Tab panel = new Tab("Potřeba koupit" );
        Tab panel2 = new Tab("Splněno");
        //nezavrit panel https://stackoverflow.com/questions/31531059/how-to-remove-close-button-from-tabs-in-javafx
        panel.setOnCloseRequest(e -> e.consume());
        panel2.setOnCloseRequest(e -> e.consume());
        // jak dat veci do tabu https://www.educba.com/javafx-tabpane/
        panel.setContent(safe);


        TabPane pane = new TabPane(panel,panel2);
        Scene scene = new Scene(pane, 400, 480);
        stage.setScene(scene);
        stage.setTitle("Nákupní lístek");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}