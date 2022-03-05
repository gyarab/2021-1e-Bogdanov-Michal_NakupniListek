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
        Label l = new Label("NESPLNĚNO");
        Label l2 = new Label("NESPLNĚNO");
        Label l3 = new Label("NESPLNĚNO");
        Label l4 = new Label("NESPLNĚNO");
        Label l5 = new Label("NESPLNĚNO");
        Label l6 = new Label("NESPLNĚNO");
        Label l7 = new Label("NESPLNĚNO");
        Label l8 = new Label("NESPLNĚNO");
        Label l9 = new Label("NESPLNĚNO");
        Label l10 = new Label("NESPLNĚNO");

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
        VBox col2 = new VBox(l,l2,l3,l4,l5,l6,l7,l8,l9,l10);
        col.relocate(110,10);
        col2.relocate(110,10);

        AnchorPane safe = new AnchorPane(col, button);
        AnchorPane safe2 = new AnchorPane(col2);
        Tab panel = new Tab("Potřeba koupit" );
        Tab panel2 = new Tab("Splněno");
        //nezavrit panel: https://stackoverflow.com/questions/31531059/how-to-remove-close-button-from-tabs-in-javafx
        panel.setOnCloseRequest(e -> e.consume());
        panel2.setOnCloseRequest(e -> e.consume());
        // jak dat veci do tabu: https://www.educba.com/javafx-tabpane/
        panel.setContent(safe);
        panel2.setContent(safe2);

        TabPane pane = new TabPane(panel,panel2);
        Scene scene = new Scene(pane, 400, 480);

        //jak presout to do splneno:https://www.tutorialkart.com/javafx/javafx-textfield/
        //https://stackoverflow.com/questions/20273820/how-to-copy-content-from-one-tab-to-another-in-javafx
        //https://www.educba.com/javafx-textfield/
        check.setOnAction((e) -> {
            l.setText(text.getText());check7.setOnAction((e2) -> {
                l.setText("NESPLNĚNO");
                check.setOnAction((e3) -> {
                    l.setText(text.getText());
                });
            });
        });
        check2.setOnAction((e) -> {
            l2.setText(text2.getText());
            check2.setOnAction((e2) -> {
                l2.setText("NESPLNĚNO");
                check2.setOnAction((e3) -> {
                    l2.setText(text2.getText());
                });
            });
        });
        check3.setOnAction((e) -> {
            l3.setText(text3.getText());
            check3.setOnAction((e2) -> {
                l3.setText("NESPLNĚNO");
                check3.setOnAction((e3) -> {
                    l3.setText(text3.getText());
                });
            });

        });
        check4.setOnAction((e) -> {
            l4.setText(text4.getText());
            check4.setOnAction((e2) -> {
                l4.setText("NESPLNĚNO");
                check4.setOnAction((e3) -> {
                    l4.setText(text4.getText());
                });
            });
        });
        check5.setOnAction((e) -> {
            l5.setText(text5.getText());
            check5.setOnAction((e2) -> {
                l5.setText("NESPLNĚNO");
                check5.setOnAction((e3) -> {
                    l5.setText(text5.getText());
                });
            });
        });
        check6.setOnAction((e) -> {
            l6.setText(text6.getText());
            check6.setOnAction((e2) -> {
                l6.setText("NESPLNĚNO");
                check6.setOnAction((e3) -> {
                    l6.setText(text6.getText());
                });
            });
        });
        check7.setOnAction((e) -> {
            l7.setText(text7.getText());
            check7.setOnAction((e2) -> {
                l7.setText("NESPLNĚNO");
                check7.setOnAction((e3) -> {
                    l7.setText(text7.getText());
                });
            });
        });
        check8.setOnAction((e) -> {
            l8.setText(text8.getText());
            check8.setOnAction((e2) -> {
                l8.setText("NESPLNĚNO");
                check8.setOnAction((e3) -> {
                    l8.setText(text8.getText());
                });
            });
        });
        check9.setOnAction((e) -> {
            l9.setText(text9.getText());
            check9.setOnAction((e2) -> {
                l9.setText("NESPLNĚNO");
                check9.setOnAction((e3) -> {
                    l9.setText(text9.getText());
                });
            });
        });
        check10.setOnAction((e) -> {
            l10.setText(text10.getText());
            check10.setOnAction((e2) -> {
                l10.setText("NESPLNĚNO");
                check7.setOnAction((e3) -> {
                    l10.setText(text10.getText());
                });
            });
        });

        button.setOnAction((e) -> {
          //  TextField text11 = new TextField();
          //  CheckBox check11 = new CheckBox();
          //  HBox line11 = new HBox(check11, text11);
          //  new VBox(line,line2,line3,line4,line5,line6,line7,line8,line9,line10,line11);
        });
        stage.setScene(scene);
        stage.setTitle("Nákupní seznam");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
