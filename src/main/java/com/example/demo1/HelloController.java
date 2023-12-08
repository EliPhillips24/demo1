package com.example.demo1;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

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
    public Pane myPane;;
    //1 initliaze method

    //method for all on acction.



    public void TextOnAction() {

        System.out.println(myTextFeild.getText());
        System.out.println(myDatePicker.getValue().toString());

        myListView.getItems().add(myTextFeild.getText() +"   "+myDatePicker.getValue().toString());

    }
public void ButtonRemove(){
    myListView.getItems().remove(myListView.getSelectionModel().getSelectedIndex());
    System.out.println(myListView.getSelectionModel().getSelectedIndex());
    OverListView.getItems().addAll(myListView.getSelectionModel().getSelectedItem());
}
    public void Reset(){
        myListView.getItems().clear();
        OverListView.getItems().addAll(myListView.getItems());
    }
    public void donetask(){
        myListView.getItems().remove(myListView.getSelectionModel().getSelectedIndex());
DoneListView.getItems().addAll(myListView.getSelectionModel().getSelectedItem());
    }
    public void restore(){
        OverListView.getItems().remove(OverListView.getSelectionModel().getSelectedItem());
        myListView.getItems().add(OverListView.getSelectionModel().getSelectedItem());
    }
    public void texteddit(){

        if(myRadio.isSelected()){

            myListView.setEditable(true);
            myListView.setCellFactory(TextFieldListCell.forListView());
        }
        else {
            myListView.setEditable(false);

        }

    }
    public void background(){
        BackgroundFill backgroundFill =
                new BackgroundFill(
                        Color.valueOf("#adb0cc"),
                        new CornerRadii(0),
                        new Insets(0)
                );

        Background background =
                new Background(backgroundFill);

        myPane.setBackground(background);
    }


}
