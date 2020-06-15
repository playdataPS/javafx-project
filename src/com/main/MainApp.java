package com.main;

import com.client.Client;
import com.view.AnswerController;
import com.view.DrawController;
import com.view.LoginController;
import com.view.RoomListController;
import com.view.SettingController;
import com.view.WaitingRoomController;
import com.vo.Data;
import com.vo.GameUser;
import com.vo.Room;
import com.vo.User;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainApp extends Application {

	private Stage primaryStage;
	
	private ObservableList<Room> roomData = FXCollections.observableArrayList();
	public ObservableList<Room> getRoomData() {
		return roomData;
	}
	private ObservableList<User> userListOfRoomList = FXCollections.observableArrayList();
	public ObservableList<User> getUserListOfRoomList() {
		return userListOfRoomList;
	}
	private ObservableList<User> userListOfWaitingRoom = FXCollections.observableArrayList();
	public ObservableList<User> getUserListOfWaitingRoom() {
		return userListOfWaitingRoom;
	}
	private ObservableList<GameUser> playerlist = FXCollections.observableArrayList();
	public ObservableList<GameUser> getGameUsers() {
		return playerlist;
	}
	
	public Stage getPrimaryStage() {
		return primaryStage;
	}
	
	// 방 데이터 추가는 생성자에서!!
	public MainApp() {
//		roomData.add(new Room(1, "제목01"));
//		roomData.add(new Room(2, "제목02"));
//		roomData.add(new Room(3, "제목03"));
//		roomData.add(new Room(4, "제목04"));
//		userListOfRoomList.add(new User2("사용자01"));
//		userListOfRoomList.add(new User2("사용자02"));
//		userListOfRoomList.add(new User2("사용자03"));
	}

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
//		initLogin();
//		initRoomList();
		User user = new User("건동");
		Room room = new Room("들어오세요", 8);
		initWaitingRoom(user, room);
//		initAnswer();
//		initDraw();
//		initSetting();
//		initScore();
	}

	public void initLogin() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("../view/Login.fxml"));
			AnchorPane root = (AnchorPane) loader.load();
			
			primaryStage.setTitle("Login");
			
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			
			LoginController controller = loader.getController();
			controller.setMainApp(this);
			controller.setLoginStage(primaryStage);
			
			primaryStage.show(); 
			primaryStage.setResizable(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void initWaitingRoom(User user, Room room) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("../view/WaitingRoom.fxml"));
			AnchorPane root = (AnchorPane) loader.load();
			
			Stage waitingRoomStage = new Stage();
			waitingRoomStage.setTitle("Room List");
			waitingRoomStage.initModality(Modality.WINDOW_MODAL);
			waitingRoomStage.initOwner(primaryStage);
	        
			Scene scene = new Scene(root);
			waitingRoomStage.setScene(scene);
			
			WaitingRoomController controller = loader.getController();
	        controller.setMainApp(this);
	        controller.setWaitingRoomStage(primaryStage);
	        controller.setRoom(room);
	        controller.setUser(user);
	        controller.changeRoomName();
	        controller.changeLabel1();
	        controller.changeMaxNum();
	        
	        getRoomData().add(room);
	        getUserListOfWaitingRoom().add(user);
			
	        waitingRoomStage.show(); 
	        waitingRoomStage.setResizable(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void initAnswer() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("../view/Answer.fxml"));
			AnchorPane root = (AnchorPane) loader.load();
			
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			
			AnswerController controller = loader.getController();
			controller.setMainApp(this);
			
			primaryStage.show(); 
			primaryStage.setResizable(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void initDraw() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("../view/Draw.fxml"));
			AnchorPane root = (AnchorPane) loader.load();
			
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			
			DrawController controller = loader.getController();
			controller.setMainApp(this);
			controller.setDrawStage(primaryStage);
			
			primaryStage.show(); 
			primaryStage.setResizable(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void initRoomList(User user) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("../view/RoomList.fxml"));
			BorderPane root = (BorderPane) loader.load();
	        Stage roomListStage = new Stage();
	        roomListStage.setTitle("Room List");
	        roomListStage.initModality(Modality.WINDOW_MODAL);
	        roomListStage.initOwner(primaryStage);
	        Scene scene = new Scene(root);
	        roomListStage.setScene(scene);

	        RoomListController controller = loader.getController();
	        controller.setRoomListStage(roomListStage);
	        controller.setUser(user);
	        Client cli = new Client(user, Data.FIRST_CONNECTION);
	        
	        getUserListOfRoomList().add(user);

	        controller.setMainApp(this);
	        primaryStage.hide();
	        roomListStage.showAndWait();
	        roomListStage.setResizable(false);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void initSetting(User user) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("../view/Setting.fxml"));
			AnchorPane root = (AnchorPane) loader.load();

			Stage settingStage = new Stage();
			settingStage.setTitle("Setting");
			settingStage.initModality(Modality.WINDOW_MODAL);
			settingStage.initOwner(primaryStage);
	        Scene scene = new Scene(root);
	        settingStage.setScene(scene);

	        SettingController controller = loader.getController();
	        controller.setSettingStage(settingStage);
	        controller.setUser(user);

	        controller.setMainApp(this);
	        settingStage.showAndWait();
			
	        settingStage.setResizable(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void initScore() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("../view/Score.fxml"));
			AnchorPane root = (AnchorPane) loader.load();
			
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			
			//MainAppController controller = loader.getController();
			//controller.setMainApp(this);
			
			primaryStage.show(); 
			primaryStage.setResizable(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
