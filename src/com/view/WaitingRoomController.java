package com.view;

import com.main.MainApp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class WaitingRoomController {
	@FXML
	private Label RoomNameLabel;
	@FXML
	private Label CurrUserCount;
	@FXML
	private Label MaxUserCount;
	@FXML
	private Label UserLabel1;
	@FXML
	private Label UserLabel2;
	@FXML
	private Label UserLabel3;
	@FXML
	private Label UserLabel4;
	@FXML
	private Label UserLabel5;
	@FXML
	private Label UserLabel6;
	@FXML
	private Label UserLabel7;
	@FXML
	private Label UserLabel8;
	@FXML
	private ScrollPane sp;
	@FXML
	private TextField input;
	@FXML
	private Button submitButton;
	@FXML
	private Button readyStart;
	@FXML
	private Button exitButton;
	@FXML
	private Pane user1;
	@FXML
	private Pane user2;
	@FXML
	private Pane user3;
	@FXML
	private Pane user4;
	@FXML
	private Pane user5;
	@FXML
	private Pane user6;
	@FXML
	private Pane user7;
	@FXML
	private Pane user8;
	
	private MainApp mainApp;
	
	private String state = "R";

	public WaitingRoomController() {
		super();
	}
	
	@FXML
	private void initialize() {
		UserLabel1.setText("�����01");
		UserLabel2.setText("�����02");
		UserLabel3.setText("�����03");
		UserLabel4.setText("�����04");
		UserLabel5.setText("�����05");
		UserLabel6.setText("�����06");
		UserLabel7.setText("�����07");
		UserLabel8.setText("�����08");
		// readyStart.setOnAction(event -> ChangeReadyColor);    
            
       
	}
	
	
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		CurrUserCount.setText("0");
		MaxUserCount.setText("8");
		//UserLabel8.getStylesheets().add("LabelStyle.css");
		//UserLabel8.getStyleClass().add(".-rectPrepared");
	}
	
	public void ChangeReadyColor() {
		
		//사용자가 몇번째 pane에 들어가는지 알아야 background 바꿀 수 있음.
		if(state=="R") {
			readyStart.setStyle("-fx-background-color :  #42A5F5;");
			user1.setStyle("-fx-background-color :  #EF5350;");
			state="B";
		}else {
			readyStart.setStyle("-fx-background-color : #EF5350;");
			user1.setStyle("-fx-background-color :  #42A5F5;");
			state="R";
		}
	}
	
	public void exit() {
		
	}
	
}
