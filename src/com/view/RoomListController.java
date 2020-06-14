package com.view;

import com.main.MainApp;
import com.vo.Room;
import com.vo.User2;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class RoomListController {
	@FXML
	private TableView<Room> roomList;
	@FXML
	private TableColumn<Room, Integer> roomNo;
	@FXML
	private TableColumn<Room, String> roomName;
	@FXML
	private TableColumn<Room, String> userCnt;
	@FXML
	private TableColumn<Room, String> enterButton;
	@FXML
	private Label noticeLabel;
	@FXML
	private TableView<User2> userList;
	@FXML
	private TableColumn<User2, String> userName;
	@FXML
	private Button galleryButton;
	@FXML
	private Button createRoomButton;
	@FXML
	private Button randomMatchingButton;
	
	private MainApp mainApp;

	public RoomListController() {
		super();
	}
	
	@FXML
	private void initialize() {
		roomNo.setCellValueFactory(cellData -> cellData.getValue().getNo().asObject());
		roomName.setCellValueFactory(cellData -> cellData.getValue().getName());
		userCnt.setCellValueFactory(cellData -> cellData.getValue().getUserCnt());
		enterButton.setCellValueFactory(cellData -> cellData.getValue().getEnterButton());
		noticeLabel.setText("���� ������ ���ؼ��� ������Ī�� �����ּ���.");
		userName.setCellValueFactory(cellData -> cellData.getValue().getNickname());
	}
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		
		roomList.setItems(mainApp.getRoomData());
		userList.setItems(mainApp.getUserListOfRoomList());

		userName.setText("������ (" + userList.getItems().size() + "��)");
	}
}
