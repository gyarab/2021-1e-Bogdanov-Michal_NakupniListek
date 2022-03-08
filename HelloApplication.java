package com.example.nakupnilistek;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
//obrazek nahrat tam kde je fxml
    @Override
    public void start(Stage stage) {
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

        Button button = new Button(" přidat ");
        Button btn = new Button(" odebrat ");
        button.relocate(300, 300);
        btn.relocate(300,310);
        button.setStyle("-fx-background-color: #FFFF0F;");

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

        AnchorPane safe = new AnchorPane(col, button, btn);
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

        l.setText("chybí: " + text.getText());
        l2.setText("chybí: " + text2.getText());
        l3.setText("chybí: " + text3.getText());
        l4.setText("chybí: " + text4.getText());
        l5.setText("chybí: " + text5.getText());
        l6.setText("chybí: " + text6.getText());
        l7.setText("chybí: " + text7.getText());
        l8.setText("chybí: " + text8.getText());
        l9.setText("chybí: " + text9.getText());
        l10.setText("chybí: " + text10.getText());
        
        text.setOnKeyPressed((e)->{
            l.setText("chybí: " + text.getText());
        });
         text2.setOnKeyPressed((e)->{
            l2.setText("chybí: " + text2.getText());
        });
         text3.setOnKeyPressed((e)->{
            l3.setText("chybí: " + text3.getText());
        });
         text4.setOnKeyPressed((e)->{
            l4.setText("chybí: " + text4.getText());
        });
         text5.setOnKeyPressed((e)->{
            l5.setText("chybí: " + text5.getText());
        });
         text6.setOnKeyPressed((e)->{
            l6.setText("chybí: " + text6.getText());
        });
         text7.setOnKeyPressed((e)->{
            l7.setText("chybí: " + text7.getText());
        });
         text8.setOnKeyPressed((e)->{
            l8.setText("chybí: " + text8.getText());
        });
         text9.setOnKeyPressed((e)->{
            l9.setText("chybí: " + text9.getText());
        });
         text10.setOnKeyPressed((e)->{
            l10.setText("chybí: " + text10.getText());
        });

            //jak presout to do splneno:https://www.tutorialkart.com/javafx/javafx-textfield/
            //https://stackoverflow.com/questions/20273820/how-to-copy-content-from-one-tab-to-another-in-javafx
            //https://www.educba.com/javafx-textfield/
        check.setOnAction((e) -> {
                l.setText(text.getText());
                check.setOnAction((e2) -> {
                    l.setText("chybí: " + text.getText());
                    check.setOnAction((e3) -> {
                        l.setText(text.getText());
                    });
                });
            });


        check2.setOnAction((e) -> {
                l2.setText(text2.getText());
                check2.setOnAction((e2) -> {
                    l2.setText("chybí: " + text2.getText());

                });
            });


            check3.setOnAction((e) -> {
                l3.setText(text3.getText());
                check3.setOnAction((e2) -> {
                    l3.setText("chybí: " + text3.getText());
                    check3.setOnAction((e3) -> {
                        l3.setText(text3.getText());
                    });
                });

            });

            check4.setOnAction((e) -> {
                l4.setText(text4.getText());
                check4.setOnAction((e2) -> {
                    l4.setText("chybí: " + text4.getText());
                    check4.setOnAction((e3) -> {
                        l4.setText(text4.getText());
                    });
                });
            });

            check5.setOnAction((e) -> {
                l5.setText(text5.getText());
                check5.setOnAction((e2) -> {
                    l5.setText("chybí: " + text5.getText());
                    check5.setOnAction((e3) -> {
                        l5.setText(text5.getText());
                    });
                });
            });

            check6.setOnAction((e) -> {
                l6.setText(text6.getText());
                check6.setOnAction((e2) -> {
                    l6.setText("chybí: " + text6.getText());
                    check6.setOnAction((e3) -> {
                        l6.setText(text6.getText());
                    });
                });
            });

            check7.setOnAction((e) -> {
                l7.setText(text7.getText());
                check7.setOnAction((e2) -> {
                    l7.setText("chybí: " + text7.getText());
                    check7.setOnAction((e3) -> {
                        l7.setText(text7.getText());
                    });
                });
            });

            check8.setOnAction((e) -> {
                l8.setText(text8.getText());
                check8.setOnAction((e2) -> {
                    l8.setText("chybí: " + text8.getText());
                    check8.setOnAction((e3) -> {
                        l8.setText(text8.getText());
                    });
                });
            });

            check9.setOnAction((e) -> {
                l9.setText(text9.getText());
                check9.setOnAction((e2) -> {
                    l9.setText("chybí: " + text9.getText());
                    check9.setOnAction((e3) -> {
                        l9.setText(text9.getText());
                    });
                });
            });

            check10.setOnAction((e) -> {
                l10.setText(text10.getText());
                check10.setOnAction((e2) -> {
                    l10.setText("chybí: " + text10.getText());
                    check10.setOnAction((e3) -> {
                        l10.setText(text10.getText());
                    });
                });
            });

            button.setOnAction((e) -> {
                Label l11 = new Label();
                TextField text11 = new TextField();
                CheckBox check11 = new CheckBox();
                HBox line11 = new HBox(check11, text11);
                l11.setText("chybí: " + text11.getText());
                col.getChildren().addAll(line11);
                col2.getChildren().addAll(l11);
                check11.setOnAction((e2) -> {
                    l11.setText(text11.getText());
                    check11.setOnAction((e3) -> {
                        l11.setText("chybí: " + text11.getText());
                        check11.setOnAction((e4) -> {
                            l11.setText(text11.getText());
                        });
                    });
                });
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
                l11.setText("chybí: " + text11.getText());
                col.getChildren().addAll(line11);
                col2.getChildren().addAll(l11);
                check11.setOnAction((e2) -> {
                    l11.setText(text11.getText());
                    check11.setOnAction((e3) -> {
                        l11.setText("chybí: " + text11.getText());
                        check11.setOnAction((e4) -> {
                            l11.setText(text11.getText());
                        });
                    });
                });
            }
        });
        
        col.setAlignment(Pos.CENTER);
        col2.setAlignment(Pos.CENTER);
        
        stage.getIcons().add(new Image("D:\\repository\\RocnikovaPrace\\MichalBogd\\ikonka.png"));
        stage.setScene(scene);
        stage.setTitle("Nákupní seznam");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
