package com.view;

import com.main.MainApp;
import com.vo.Room;
import com.vo.User;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
	private TextArea chatArea;
	@FXML
	private TextField input;
	@FXML
	private Button submitButton;
	@FXML
	private Button readyStart;
	@FXML
	private Button exitButton;
	
	private Stage waitingRoomStage;
	
	private MainApp mainApp;
	
	private Room room;
	
	private User user;

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
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
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
	@FXML
	private void readyStartState() {
		
	}
	@FXML
	private void exitApp() {
		waitingRoomStage.hide();
	}
}
