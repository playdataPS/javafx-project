package com.main;

import com.view.DrawController;
import com.view.LoginController;
import com.view.RoomListController;
import com.view.WaitingRoomController;
import com.vo.GameUser;
import com.vo.Room;
import com.vo.User2;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;
	
	private ObservableList<Room> roomData = FXCollections.observableArrayList();
	public ObservableList<Room> getRoomData() {
		return roomData;
	}
	private ObservableList<User2> userListOfRoomList = FXCollections.observableArrayList();
	public ObservableList<User2> getUserListOfRoomList() {
		return userListOfRoomList;
	}
	private ObservableList<GameUser> playerlist = FXCollections.observableArrayList();
	public ObservableList<GameUser> getGameUsers() {
		return playerlist;
	}
	// �� �����͸� �߰��� �����ڿ���!!
	public MainApp() {
		roomData.add(new Room(1, "����01"));
		roomData.add(new Room(2, "����02"));
		roomData.add(new Room(3, "����03"));
		roomData.add(new Room(4, "����04"));
		userListOfRoomList.add(new User2("�����01"));
		userListOfRoomList.add(new User2("�����02"));
		userListOfRoomList.add(new User2("�����03"));
		playerlist.add(new GameUser("jihye"));
	}


	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Main");
//		initLogin();
//		initRoomList();
//		initWaitingRoom();
//		initAnswer();
		initDraw();
//		initSetting();
//		initScore();
	}

	private void initLogin() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("../view/Login.fxml"));
			AnchorPane root = (AnchorPane) loader.load();
			
			Stage loginStage = new Stage();
			loginStage.setTitle("Login");
			
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			
			LoginController controller = loader.getController();
			controller.setMainApp(this);
			
			primaryStage.show(); 
			primaryStage.setResizable(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void initWaitingRoom() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("../view/WaitingRoom.fxml"));
			AnchorPane root = (AnchorPane) loader.load();
			
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			
			WaitingRoomController controller = loader.getController();
	        controller.setMainApp(this);
			
			primaryStage.show(); 
			primaryStage.setResizable(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void initAnswer() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("../view/Answer.fxml"));
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
	private void initDraw() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("../view/Draw.fxml"));
			AnchorPane root = (AnchorPane) loader.load();
			
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			
			DrawController controller = loader.getController();
			controller.setMainApp(this);
			
			//controller.GameWord();
			
			primaryStage.show(); 
			primaryStage.setResizable(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void initRoomList() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("../view/RoomList.fxml"));
			BorderPane root = (BorderPane) loader.load();
			
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			
			RoomListController controller = loader.getController();
			controller.setMainApp(this);
			
			primaryStage.show(); 
			primaryStage.setResizable(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void initSetting() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("../view/Setting.fxml"));
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
	private void initScore() {
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
