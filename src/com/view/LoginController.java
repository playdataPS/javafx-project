package com.view;

import com.main.MainApp;
import com.vo.User;
import com.vo.User2;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginController {
	@FXML
	private TextField nicknameTextField;
	@FXML
	private Button startButton;
	@FXML
	private Label noticeLabel;
	
	private MainApp mainApp;
	private User2 user;
	
	@FXML
	private void initialize() {
		nicknameTextField.setText("");
		noticeLabel.setText("닉네임을 입력해주세요.");
	}
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
//	public void setUser(User2 user) {
//		this.user = user;
////		this.user.setNo(no);
////		this.user.setIp(ip);
////		this.user.setNickname(nickname);
////		this.user.setScore(score);
////		this.user.setRegdate(regdate);
//	}
	
	@FXML
	private void gameStart() {
		String nickname = nicknameTextField.getText();
		User2 user = new User2(nickname);
		mainApp.initWaitingRoom(user);
	}
}