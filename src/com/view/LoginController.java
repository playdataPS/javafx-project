package com.view;

import com.main.MainApp;

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
	
	@FXML
	private void initialize() {
		nicknameTextField.setText("");
	}
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	
	@FXML
	private void gameStart() {
		
	}
}
