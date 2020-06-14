package com.view;

import java.net.URL;
import java.util.ResourceBundle;

import com.main.MainApp;
import com.vo.Room;
import com.vo.User2;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class WaitingRoomController implements Initializable{
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
	private TextArea chatArea;
//	@FXML
//	private ScrollPane sp;
	@FXML
	private TextField input;
	@FXML
	private Button submitButton;
	@FXML
	private Button readyStart;
	@FXML
	private Button exitButton;
	
	private Stage waitingRoomStage;
	
	private Room room;
	private User2 user;
	
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
		RoomNameLabel.setText("방 이름");
		UserLabel1.setText("");
		UserLabel2.setText("");
		UserLabel3.setText("");
		UserLabel4.setText("");
		UserLabel5.setText("");
		UserLabel6.setText("");
		UserLabel7.setText("");
		UserLabel8.setText("");
		input.setText("");
		input.requestFocus();
	}
	
	
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		CurrUserCount.setText(String.valueOf(mainApp.getUserListOfRoomList().size()));
		MaxUserCount.setText("8");
		//UserLabel8.getStylesheets().add("LabelStyle.css");
		//UserLabel8.getStyleClass().add(".-rectPrepared");
	}
	
	public Stage getWaitingRoomStage() {
		return waitingRoomStage;
	}
	public void setWaitingRoomStage(Stage waitingRoomStage) {
		this.waitingRoomStage = waitingRoomStage;
	}

	public void changeRoomName() {
		RoomNameLabel.setText(room.getName().get());
	}

	public void changeMaxNum() {
		MaxUserCount.setText(room.getUserCnt().get().substring(room.getUserCnt().get().length()-1, room.getUserCnt().get().length()));
	}
	
	public void changeLabel1() {
		UserLabel1.setText(user.getNickname().get());
	}
	
	public User2 getUser() {
		return user;
	}

	public void setUser(User2 user) {
		this.user = user;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	@FXML
	private void submitAppend() {
		chatArea.appendText(input.getText()+"\n");
		input.setText("");
		input.requestFocus();
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
	
	@FXML
	private void exitApp() {
		System.exit(0);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
}
