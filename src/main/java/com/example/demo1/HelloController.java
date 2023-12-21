package com.example.demo1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Popup;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;



public class HelloController {
    @FXML
    private Label welcomeText;
    // feilds for controllers
    public TextField myTextFeild;
    public ListView myListView;
    public ListView DoneListView;
    public ListView OverListView;
    public RadioButton myRadio;
    public DatePicker myDatePicker;
    public ColorPicker myColorPicker;
    public Pane myPane;
    public Button popupbutton;

    public TableView myTableView;
    //1 initliaze method

    //method for all on acction.
    public void TextOnAction() {

        System.out.println(myTextFeild.getText());
        System.out.println(myDatePicker.getValue().toString());

        myListView.getItems().add(myTextFeild.getText() + "   " + myDatePicker.getValue().toString());

    }

    public void popup() {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Popup");
        ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
        alert.setContentText("This is a Popup");
        alert.getDialogPane().getButtonTypes().add(type);
        Text txt = new Text("Click the button to show the dialog");
        alert.showAndWait();

    }

    public void ButtonRemove() {
        myListView.getItems().remove(myListView.getSelectionModel().getSelectedIndex());
        System.out.println(myListView.getSelectionModel().getSelectedIndex());
        OverListView.getItems().addAll(myListView.getSelectionModel().getSelectedItem());
    }

    public void Reset() {
        myListView.getItems().clear();
        OverListView.getItems().addAll(myListView.getItems());

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Cleared");
        ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
        alert.setContentText("You Cleared The List");
        alert.getDialogPane().getButtonTypes().add(type);
        Text txt = new Text("Click the button to show the dialog");
        alert.showAndWait();

    }

    public void donetask() {
        myListView.getItems().remove(myListView.getSelectionModel().getSelectedIndex());
        DoneListView.getItems().addAll(myListView.getSelectionModel().getSelectedItem());
    }

    public void restore() {
        OverListView.getItems().remove(OverListView.getSelectionModel().getSelectedItem());
        myListView.getItems().add(OverListView.getSelectionModel().getSelectedItem());
    }

    public void texteddit() {

        if (myRadio.isSelected()) {
            System.out.println("AHL<FJSAHLASKD");
            myListView.setEditable(true);
            myListView.setCellFactory(TextFieldListCell.forListView());
        } else {
            myListView.setEditable(false);
        }
    }

    public void Saving() throws Exception {
        File fileForData = new File("Save");
        FileOutputStream outputStream = new FileOutputStream(fileForData);
        ObjectOutputStream objOutputStream = new ObjectOutputStream(outputStream);
        ObservableList list1 = myListView.getItems();
        objOutputStream.writeObject(list1.size());
        for (Object item: list1) {
            objOutputStream.writeObject(item);
        }
     //   objOutputStream.writeObject(myListView);
     //   objOutputStream.writeObject(DoneListView);
        objOutputStream.flush();
        System.out.println(list1);
    }

    public void RecalData() throws Exception {
        File fileForData = new File("Save");
        FileInputStream inputStream = new FileInputStream(fileForData);
        ObjectInputStream objInputStream = new ObjectInputStream(inputStream);
        Integer numOfSavedObjects = (Integer)objInputStream.readObject();
        for (int i = 0; i < numOfSavedObjects; i = i + 1) {
            String listText = (String) objInputStream.readObject();
            myListView.getItems().add(listText);
        }
        inputStream.close();
    }

    public void initialize() throws Exception{
        this.RecalData();
    }

}



