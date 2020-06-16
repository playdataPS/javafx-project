package com.main;

import com.client.ClientListener;
import com.view.AnswerController;
import com.view.DrawController;
import com.view.LoginController;
import com.view.SettingController;
import com.view.WaitingRoomController;
import com.vo.GameUser;
import com.vo.Room;
import com.vo.Status;
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

	}

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		initLogin();
//		initAnswer();
//		initDraw();
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
//			controller.Update();// 사용자 추가될때마다 업데이트 되어야함

			primaryStage.show();
			primaryStage.setResizable(false);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void initWaitingRoom(User user, Room room) {
		
//		Flam
		try {
			
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("../view/WaitingRoom.fxml"));
			AnchorPane root = (AnchorPane) loader.load();

			Stage waitingRoomStage = new Stage();
			waitingRoomStage.setTitle("Waiting Room");
			waitingRoomStage.initModality(Modality.WINDOW_MODAL);
			waitingRoomStage.initOwner(primaryStage);

			Scene scene = new Scene(root);
			waitingRoomStage.setScene(scene);
			
			
			
			

			WaitingRoomController controller = loader.getController();
			controller.setUser(user);
			
			controller.setMainApp(this);
			controller.setWaitingRoomStage(primaryStage);
			controller.setRoom(room);
			controller.setUser(user);
			controller.changeRoomName();
			for(User u : user.getUserList()) {
				controller.changeLabel1(u.getNickname());
			}
			//controller.changeLabel1();
//			controller.changeMaxNum();

			getRoomData().add(room);
			getUserListOfWaitingRoom().add(user);

			primaryStage.hide();
			waitingRoomStage.show();
			waitingRoomStage.setResizable(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void WatingRommUpdate() {
		
		System.out.println("update 돼는거 호출해요");
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

//			RoomListController controller = loader.getController();
//			controller.setRoomListStage(roomListStage);
			// controller.setUser(user);
			// Client cli = new Client(user, Status.CONNECTED);
//	        ClientListener listener = 
//	        getUserListOfRoomList().add(user);
//	        User userData = new User("127.0.0.1", "eunhye");
//			
//			new ClientListener("127.0.0.1", 5555, userData).createConnect();

//			controller.setMainApp(this);
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
			// controller.setUser(user);

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

			// MainAppController controller = loader.getController();
			// controller.setMainApp(this);

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
