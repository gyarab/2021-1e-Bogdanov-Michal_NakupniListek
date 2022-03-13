package com.example.nakupnilistek;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



import java.io.File;
import java.io.IOException;


public class HelloApplication extends Application {
    boolean[] checks;
    String[] texts;
    @Override
    public void start(Stage stage) {
        checks = new boolean[100];
        texts = new String[100];

        //creating label
        Label l = new Label();
        Label l2 = new Label();
        Label l3 = new Label();
        Label l4 = new Label();
        Label l5 = new Label();
        Label l6 = new Label();
        Label l7 = new Label();
        Label l8 = new Label();
        Label l9 = new Label();
        Label l10 = new Label();
        Label l1 = new Label();
        Label l22 = new Label();
        Label l33 = new Label();
        Label l44 = new Label();
        Label l55 = new Label();
        Label l66 = new Label();
        Label l77 = new Label();
        Label l88 = new Label();
        Label l99 = new Label();
        Label l100 = new Label();

        //creating text field
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

        text.setPromptText("Zadejte zboži");
        text2.setPromptText("Zadejte zboží");
        text3.setPromptText("Zadejte zboží");
        text4.setPromptText("Zadejte zboží");
        text5.setPromptText("Zadejte zboží");
        text6.setPromptText("Zadejte zboží");
        text7.setPromptText("Zadejte zboží");
        text8.setPromptText("Zadejte zboží");
        text9.setPromptText("Zadejte zboží");
        text10.setPromptText("Zadejte zboží");

        //creating check box
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
        CheckBox check1 = new CheckBox();
        CheckBox check22 = new CheckBox();
        CheckBox check33 = new CheckBox();
        CheckBox check44 = new CheckBox();
        CheckBox check55 = new CheckBox();
        CheckBox check66 = new CheckBox();
        CheckBox check77 = new CheckBox();
        CheckBox check88 = new CheckBox();
        CheckBox check99 = new CheckBox();
        CheckBox check100 = new CheckBox();

        //creating buttons
        Button button = new Button(" přidat ");
        Button btn = new Button(" odebrat ");
        Button btn2 = new Button(" ulo6it ");
        button.relocate(300, 300);
        btn.relocate(300,310);
        btn2.relocate(330,310);
        button.setStyle("-fx-background-color: #FFFF0F;");

        //creating hboxes
        HBox line = new HBox(check, text, check1);
        HBox line2 = new HBox(check2, text2, check22);
        HBox line3 = new HBox(check3, text3, check33);
        HBox line4 = new HBox(check4, text4, check44);
        HBox line5 = new HBox(check5, text5, check55);
        HBox line6 = new HBox(check6, text6, check66);
        HBox line7 = new HBox(check7, text7, check77);
        HBox line8 = new HBox(check8, text8, check88);
        HBox line9 = new HBox(check9, text9, check99);
        HBox line10 = new HBox(check10, text10, check100);

        VBox col = new VBox(line,line2,line3,line4,line5,line6,line7,line8,line9,line10);
        VBox col2 = new VBox(l,l2,l3,l4,l5,l6,l7,l8,l9,l10);
        VBox col3 = new VBox(l1,l22,l33,l44,l55,l66,l77,l88,l99,l100);


        AnchorPane safe = new AnchorPane(col, button, btn, btn2);
        AnchorPane safe2 = new AnchorPane(col2);
        AnchorPane safe3 = new AnchorPane(col3);

        Tab panel = new Tab("Potřeba koupit" );
        Tab panel2 = new Tab("Splněno");
        Tab panel3 = new Tab("Chybí");

        //nezavrit panel: https://stackoverflow.com/questions/31531059/how-to-remove-close-button-from-tabs-in-javafx
        panel.setOnCloseRequest(e -> e.consume());
        panel2.setOnCloseRequest(e -> e.consume());
        panel3.setOnCloseRequest(e -> e.consume());

        // jak dat veci do tabu: https://www.educba.com/javafx-tabpane/
        panel.setContent(safe);
        panel2.setContent(safe2);
        panel3.setContent(safe3);

        col.relocate(110,10);
        col2.relocate(110,10);
        col3.relocate(110,10);

        TabPane pane = new TabPane(panel,panel2,panel3);
        Scene scene = new Scene(pane, 400, 480);

        //some functions
        //presune se do chybi
           text.setOnKeyPressed((e) -> {
               if(e.getCode() == KeyCode.ENTER) {
                   texts[0]= text.getText();
                   l1.setText( texts[0]);
                   //jak presout to do splneno:https://www.tutorialkart.com/javafx/javafx-textfield/
                   //https://stackoverflow.com/questions/20273820/how-to-copy-content-from-one-tab-to-another-in-javafx
                   //https://www.educba.com/javafx-textfield/
                   //can not click again
                   check.setOnAction((e2)->{
                       check.setSelected(true);
                       if(check.isSelected()){
                           l.setText(texts[0]);
                           col3.getChildren().remove(l1);
                       }
                   });
               }
           });
        text2.setOnKeyPressed((e) -> {
            if(e.getCode() == KeyCode.ENTER) {
                texts[1]= text2.getText();
                l22.setText( texts[1]);
                check2.setOnAction((e2)->{
                    check2.setSelected(true);
                    if(check2.isSelected()){
                        l2.setText(texts[1]);
                        col3.getChildren().remove(l22);
                    }
                });
            }
        });
        text3.setOnKeyPressed((e) -> {
            if(e.getCode() == KeyCode.ENTER) {
                texts[2]= text3.getText();
                l33.setText( texts[2]);
                check3.setOnAction((e2)->{
                    check3.setSelected(true);
                    if(check3.isSelected()){
                        l3.setText(texts[2]);
                        col3.getChildren().remove(l33);
                    }
                });
            }
        });
        text4.setOnKeyPressed((e) -> {
            if(e.getCode() == KeyCode.ENTER) {
                texts[3]= text4.getText();
                l44.setText( texts[3]);
                check4.setOnAction((e2)->{
                    check4.setSelected(true);
                    if(check4.isSelected()){
                        l4.setText(texts[3]);
                        col3.getChildren().remove(l44);
                    }
                });
            }
        });
        text5.setOnKeyPressed((e) -> {
            if(e.getCode() == KeyCode.ENTER) {
                texts[4]= text5.getText();
                l55.setText( texts[4]);
                check5.setOnAction((e2)->{
                    check5.setSelected(true);
                    if(check5.isSelected()){
                        l5.setText(texts[4]);
                        col3.getChildren().remove(l55);
                    }
                });
            }
        });
        text6.setOnKeyPressed((e) -> {
            if(e.getCode() == KeyCode.ENTER) {
                texts[5]= text6.getText();
                l66.setText( texts[5]);
                check6.setOnAction((e2)->{
                    check6.setSelected(true);
                    if(check6.isSelected()){
                        l6.setText(texts[5]);
                        col3.getChildren().remove(l66);
                    }
                });
            }
        });
        text7.setOnKeyPressed((e) -> {
            if(e.getCode() == KeyCode.ENTER) {
                texts[6]= text7.getText();
                l77.setText( texts[6]);
                check7.setOnAction((e2)->{
                    check7.setSelected(true);
                    if(check7.isSelected()){
                        l7.setText(texts[6]);
                        col3.getChildren().remove(l77);
                    }
                });
            }
        });
        text8.setOnKeyPressed((e) -> {
            if(e.getCode() == KeyCode.ENTER) {
                texts[7]= text8.getText();
                l88.setText( texts[7]);
                check8.setOnAction((e2)->{
                    check8.setSelected(true);
                    if(check8.isSelected()){
                        l8.setText(texts[7]);
                        col3.getChildren().remove(l88);
                    }
                });
            }
        });
        text9.setOnKeyPressed((e) -> {
            if(e.getCode() == KeyCode.ENTER) {
                texts[8]= text9.getText();
                l99.setText(texts[8]);
                check9.setOnAction((e2)->{
                    check9.setSelected(true);
                    if(check9.isSelected()){
                        l9.setText(texts[8]);
                        col3.getChildren().remove(l99);
                    }
                });
            }
        });
        text10.setOnKeyPressed((e) -> {
            if(e.getCode() == KeyCode.ENTER) {
                texts[9]= text10.getText();
                l100.setText( texts[9]);
                check10.setOnAction((e2)->{
                    check10.setSelected(true);
                    if(check10.isSelected()){
                        l10.setText(texts[9]);
                        col3.getChildren().remove(l100);
                    }
                });

            }
        });

        check1.setOnAction((e)->{
            check1.setSelected(true);
            if(check1.isSelected()){
                texts[0]= text.getText();
                l1.setText(texts[0]);
                line.getChildren().remove(check1);
                check.setOnAction((e2)->{
                    check.setSelected(true);
                    if(check.isSelected()){
                        l.setText(texts[0]);
                        col3.getChildren().remove(l1);
                    }
                });
            }
        });
        check22.setOnAction((e)->{
            check22.setSelected(true);
            if(check22.isSelected()){
                texts[1]= text2.getText();
                l22.setText(texts[1]);
                line2.getChildren().remove(check22);
                check2.setOnAction((e2)->{
                    check2.setSelected(true);
                    if(check2.isSelected()){
                        l2.setText(texts[1]);
                        col3.getChildren().remove(l22);
                    }
                });
            }
        });
        check33.setOnAction((e)->{
            check33.setSelected(true);
            if(check33.isSelected()){
                texts[2]= text3.getText();
                l33.setText(texts[2]);
                line3.getChildren().remove(check33);
                check3.setOnAction((e2)->{
                    check3.setSelected(true);
                    if(check3.isSelected()){
                        l3.setText(texts[2]);
                        col3.getChildren().remove(l33);
                    }
                });
            }
        });
        check44.setOnAction((e)->{
            check44.setSelected(true);
            if(check44.isSelected()){
                texts[3]= text4.getText();
                l44.setText(texts[3]);
                line4.getChildren().remove(check44);
                check4.setOnAction((e2)->{
                    check4.setSelected(true);
                    if(check4.isSelected()){
                        l4.setText(texts[3]);
                        col3.getChildren().remove(l44);
                    }
                });
            }
        });

            button.setOnAction((e) -> {
                Label l11 = new Label();
                Label l111 = new Label();
                TextField text11 = new TextField();
                CheckBox check11 = new CheckBox();
                HBox line11 = new HBox(check11, text11);
                texts[10]=text11.getText();
                col.getChildren().addAll(line11);
                col2.getChildren().addAll(l11);
                col3.getChildren().addAll(l111);
                l111.setText( texts[10]);

            });

        btn.setOnAction((e)->{
            line10.getChildren().remove(check10);
            line10.getChildren().remove(text10);
            btn.setOnAction((e2)->{
                line9.getChildren().remove(check9);
                line9.getChildren().remove(text9);
                btn.setOnAction((e3)->{
                        line8.getChildren().remove(check8);
                        line8.getChildren().remove(text8);
                    btn.setOnAction((e4)->{
                        line7.getChildren().remove(check7);
                        line7.getChildren().remove(text7);
                        btn.setOnAction((e5)->{
                            line6.getChildren().remove(check6);
                            line6.getChildren().remove(text6);
                            btn.setOnAction((e6)->{
                                line5.getChildren().remove(check5);
                                line5.getChildren().remove(text5);
                                btn.setOnAction((e7)->{
                                    line4.getChildren().remove(check4);
                                    line4.getChildren().remove(text4);
                                    btn.setOnAction((e8)->{
                                        line3.getChildren().remove(check3);
                                        line3.getChildren().remove(text3);
                                        btn.setOnAction((e9)->{
                                            line2.getChildren().remove(check2);
                                            line2.getChildren().remove(text2);
                                            safe.getChildren().remove(btn);
                                        });
                                    });

                                });

                            });

                        });

                    });

                });

            });

        });



        pane.setOnKeyPressed((e)->{
            if(e.getCode() == KeyCode.CONTROL.SHIFT.P) {
                Label l11 = new Label();
                TextField text11 = new TextField();
                CheckBox check11 = new CheckBox();
                HBox line11 = new HBox(check11, text11);
                text11.setOnKeyPressed((e2)->{
                    l11.setText("chybí: " + text11.getText());
                });
                col.getChildren().addAll(line11);
                col2.getChildren().addAll(l11);
                check11.setOnAction((e2) -> {
                    l11.setText(text11.getText());
                    check11.setOnAction((e3) -> {
                        l11.setText("chybí: " + text11.getText());
                    });
                });
            }
        });

        //vyresit
        //stage.getIcons().add(new Image());
        stage.setScene(scene);
        stage.setTitle("Nákupní seznam");
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}