package com.view;


import com.main.MainApp;
import com.vo.GameUser;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class DrawController {
	@FXML
	private Label word_num1;
	@FXML
	private Label word_num2;
	@FXML
	private Label word_num3;
	@FXML
	private Label word_num4;
	@FXML
	private Label word_num5;
	@FXML
	private ProgressBar bar; 
	@FXML
	private Button send;
	@FXML
	private Canvas canvas;
	@FXML
	private TableView<GameUser> playerlist ;
	@FXML
	private TableColumn<GameUser, String> player;
	@FXML
	private TextField inputchat;
	@FXML
	private TextArea chat;
	
	//메인 애플리케이션 참
	private MainApp mainApp;
	
	//db의 WORD 불러옴.
	private String word="바나나";
	

	
	//생성자. initialize() 메서드 이전에 호출
	public DrawController() {
		super();
	}

	private void initialize() {
		//playerlist테이블 play열 초기화
		player.setCellValueFactory(cellData -> cellData.getValue().getPlayer());
	}
	
	
	
	//참조를 다시 유지하기 위해 메인 애플리케이션이 호한다.
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	
		playerlist.setItems(mainApp.getGameUsers());
		
		GameWord();
	}
	
	
	
	public void GameWord() {
		
		char[] charArr = word.toCharArray();
		if(String.valueOf(charArr[0]) != null) {
			word_num2.setText(String.valueOf(charArr[0]));
		}
		if(String.valueOf(charArr[1]) != null) {
			word_num3.setText(String.valueOf(charArr[1]));
		}
		if(String.valueOf(charArr[2]) != null) {
			word_num4.setText(String.valueOf(charArr[2]));
		}		
	}
}