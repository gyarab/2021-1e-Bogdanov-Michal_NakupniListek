package com.example.nakupnilistek;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class NakupniListek extends Application {

    //creating Arraylist
    //for string
    public List<String> data = new ArrayList<String>();
    //for boolean
    public List<Boolean> done = new ArrayList<Boolean>();

    //CSV file delimiter
    private static Character delimiter = ';';

    //creating Vboxes
    //in tab "Potřeba koupit"
    public VBox colNeeds = new VBox();
    //in tab "Splněno"
    public VBox colDone = new VBox();
    //in tab "Chybí"
    public VBox colMiss = new VBox();

    //creating anchor pane
    //in tab "Potřeba koupit"
    public AnchorPane anchorNeeds = new AnchorPane();
    //in tab "Splněno"
    public AnchorPane anchorDone = new AnchorPane();
    //in tab "Chybí"
    public  AnchorPane anchorMiss = new AnchorPane();

    //creating tab
    public Tab panelNeeds = new Tab("Potřeba koupit");
    public Tab panelDone = new Tab("Splněno");
    public Tab panelMiss = new Tab("Chybí");

    //creating tabpane and adding tabs in it
    public TabPane pane = new TabPane(panelNeeds, panelDone, panelMiss);

    //creating scrollpane
    //for tab "Potřeba koupit"
    public ScrollPane scrollNeeds = new ScrollPane();
    //for tab"Splněno"
    public ScrollPane scrollDone = new ScrollPane();
    //for tab "Chybí"
    public ScrollPane scrollMiss = new ScrollPane();


    //creating FileChooser
    public FileChooser fileDialog = new FileChooser();

    private void pridat() {
        pridat(new String[0]);
    }

    private void pridat(String[] addedProducts) {

        String note = new String();
        boolean bought = false;

        if (addedProducts.length == 2) {
            note = addedProducts[0];
            bought = Boolean.parseBoolean(addedProducts[1]);
        }

        //data
        data.add(note);
        done.add(bought);

        //GUI
        Label lDone = new Label();

        Label lMiss = new Label();

        TextField text = new TextField();
        //position of new data
        text.setId(Integer.toString(data.size() - 1));
        text.setText(note);
        text.setPromptText("Zadejte zboži");

        CheckBox check = new CheckBox();
        check.setSelected(bought);

        Button confirmBtn = new Button("potvrdit");

        HBox line = new HBox(check, text, confirmBtn);

        VBox colOfThings = new VBox();
        colOfThings.getChildren().addAll(line);

        colNeeds.getChildren().addAll(colOfThings);
        colDone.getChildren().addAll(lDone);
        colMiss.getChildren().addAll(lMiss);

        if (check.isSelected()) {
            line.getChildren().remove(confirmBtn);
            odskrtnout(check, text, lDone, lMiss);
        }

        //GUI action
        confirmBtn.setOnAction((e) -> {
            potvrdit(check, text, lMiss, lDone, line, confirmBtn);
        });
        text.setOnAction((e) -> {
            potvrdit(check, text, lMiss, lDone, line, confirmBtn);
        });
    }

    private void odebrat() {
        if (colNeeds.getChildren().size() > 1) {
            data.remove(data.size() - 1);
            done.remove(done.size() - 1);
            colNeeds.getChildren().remove(colNeeds.getChildren().size() - 1);
            colDone.getChildren().remove(colDone.getChildren().size() - 1);
            colMiss.getChildren().remove(colMiss.getChildren().size() - 1);
        }
    }

    private void potvrdit(CheckBox check, TextField text, Label lMiss, Label lDone, HBox line, Button confirmBtn) {
        data.set(Integer.parseInt(text.getId()), text.getText());
        lMiss.setText(data.get(Integer.parseInt(text.getId())));
        line.getChildren().remove(confirmBtn);
        check.setOnAction((e) -> {
            odskrtnout(check, text, lDone, lMiss);
        });
    }

    private void odskrtnout(CheckBox check, TextField text, Label lDone, Label lMiss) {
        check.setSelected(true);
        done.set(Integer.parseInt(text.getId()), check.isSelected());
        lDone.setText(data.get(Integer.parseInt(text.getId())));
        colMiss.getChildren().remove(lMiss);

    }

    private void ulozit() {
        fileDialog.setTitle("Save File");
        fileDialog.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files", "*.csv"));
        File newFile = fileDialog.showSaveDialog(null);
        if (newFile != null) {
            try {
                OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(newFile));

                BufferedWriter bufWriter = new BufferedWriter(writer);

                for (int index = 0; index < data.size(); index++) {
                    String name = data.get(index);
                    name = name.replace(delimiter, ',');

                    //ukladani do souboru
                    bufWriter.write(name);
                    bufWriter.write(delimiter);
                    bufWriter.write(String.valueOf(done.get(index)));
                    bufWriter.newLine();
                }
                bufWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void nacist() {
        fileDialog.setTitle("Load File");
        fileDialog.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files", "*.csv"));

        File selectedFile = fileDialog.showOpenDialog(null);

        if (selectedFile != null) {

            colNeeds.getChildren().clear();
            colDone.getChildren().clear();
            colMiss.getChildren().clear();
            data.clear();
            done.clear();

            // create a reader
            //default UTF-8
            try (BufferedReader br = new BufferedReader(new FileReader(selectedFile))) {
                // read the file line by line
                String lineRead;
                while ((lineRead = br.readLine()) != null) {
                    // convert line into columns
                    String[] columns = lineRead.split(delimiter.toString());
                    pridat(columns);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void ovladaciPrvky() {

        pridat();

        //creating buttons
        //add new smth
        Button btnAdd = new Button("přidat");
        //remove smth
        Button btnRemove = new Button("odebrat");
        //save file
        Button btnSave = new Button("uložit");
        //load from file
        Button btnLoad = new Button("načíst");

        //creating hbox
        HBox lineNextTo = new HBox();

        //creating vbox
        VBox colOfButtons = new VBox();
        colOfButtons.getChildren().addAll(btnAdd, btnRemove, btnSave, btnLoad);

        anchorNeeds.getChildren().addAll(lineNextTo);
        anchorDone.getChildren().addAll(colDone);
        anchorMiss.getChildren().addAll(colMiss);

        lineNextTo.setAlignment(Pos.CENTER);
        colDone.relocate(110, 10);
        colMiss.relocate(110, 10);

        btnAdd.setPrefWidth(75);
        btnRemove.setPrefWidth(75);
        btnSave.setPrefWidth(75);
        btnLoad.setPrefWidth(75);

        panelNeeds.setOnCloseRequest(e -> e.consume());
        panelDone.setOnCloseRequest(e -> e.consume());
        panelMiss.setOnCloseRequest(e -> e.consume());

        scrollNeeds.setContent(colNeeds);
        scrollNeeds.setPrefWidth(275);
        scrollDone.setContent(anchorDone);
        scrollMiss.setContent(anchorMiss);

        lineNextTo.getChildren().addAll(colOfButtons, scrollNeeds);

        panelNeeds.setContent(lineNextTo);
        panelDone.setContent(scrollDone);
        panelMiss.setContent(scrollMiss);

        //GUI action
        btnAdd.setOnAction((e) -> {
            pridat();
        });

        btnRemove.setOnAction((e) -> {
            odebrat();
        });

        btnSave.setOnAction((e) -> {
            ulozit();
        });

        btnLoad.setOnAction((e) -> {
            nacist();
        });

        pane.setOnKeyPressed((e) -> {
            if (e.getCode() == KeyCode.CONTROL.ALT.P) {
                pridat();
            }
            if (e.getCode() == KeyCode.DELETE) {
                odebrat();
            }
            if (e.getCode() == KeyCode.CONTROL.SHIFT.S) {
                ulozit();
            }
            if (e.getCode() == KeyCode.CONTROL.V) {
                nacist();
            }
        });

    }

    @Override
    public void start(Stage stage) {

        ovladaciPrvky();

       java.net.URL imgULR = getClass().getResource("/com/example/nakupnilistek/ikonka.png");
       Image icon = new Image(String.valueOf(imgULR));
       stage.getIcons().add(icon);
        Scene scene = new Scene(pane, 350, 480);
        stage.setScene(scene);
        stage.setTitle("Nákupní seznam");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}