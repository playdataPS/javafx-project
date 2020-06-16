package com.view;

import com.client.ClientListener;
import com.main.MainApp;
import com.vo.Room;
import com.vo.User;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;

public class LoginController {
	@FXML
	private TextField nicknameTextField;
	@FXML
	private Button startButton;
	@FXML
	private Label noticeLabel;

	private MainApp mainApp;

	private Stage loginStage;

	@FXML
	private void initialize() {
		nicknameTextField.setText("");
		noticeLabel.setText("닉네임을 입력해주세요.");
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}

	public void setLoginStage(Stage loginStage) {
		this.loginStage = loginStage;
	}

	@FXML
	private void gameStart() {
		String nickname = nicknameTextField.getText();

		boolean check = nickname.isEmpty();

		if (check) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.initOwner(loginStage);
			alert.setTitle("ERRORS");
			alert.setContentText("닉네임을 입력해주세요.");
			alert.showAndWait();
		} else {
			User user = new User();
			user.setNickname(nickname);
			System.out.println("--------client data--------");
			System.out.println(user.getNickname());
			System.out.println("--------client data--------");

			ClientListener cli = new ClientListener("192.168.3.76", 5555, nickname);
			cli.createConnect();

			Room room = new Room("들어오세요", 8);
			mainApp.initWaitingRoom(user, room);
		}
	}
}
