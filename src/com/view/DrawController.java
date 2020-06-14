package com.view;

import java.net.URL;
import java.util.ResourceBundle;

import com.main.MainApp;
import com.vo.GameUser;

import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class DrawController implements Initializable{
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
	private TableView<GameUser> playerlist;
	@FXML
	private TableColumn<GameUser, String> player;
	@FXML
	private TextField inputchat;
	@FXML
	private TextArea chat;
	@FXML
	private Label user;

	// 메인 애플리케이션 참조
	private MainApp mainApp;

	// db의 WORD 불러옴.
	private String word = "라라라";
	
	private String userturn = "jihye";


	// 생성자. initialize() 메서드 이전에 호출
	public DrawController() {
		super();
	}

	
	// 참조를 다시 유지하기 위해 메인 애플리케이션이 호한다.
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;

		playerlist.setItems(mainApp.getGameUsers());
		//GameWord();

	}

	public void GameWord() {

		char[] charArr = word.toCharArray();

		if (String.valueOf(charArr[0]) != null) {
			word_num2.setText(String.valueOf(charArr[0]));
		}
		if (String.valueOf(charArr[1]) != null) {
			word_num3.setText(String.valueOf(charArr[1]));
		}
		if (String.valueOf(charArr[2]) != null) {
			word_num4.setText(String.valueOf(charArr[2]));
		}
//         if(String.valueOf(charArr[3]) != null) {
//            word_num4.setText(String.valueOf(charArr[3]));
//         }
//         if(String.valueOf(charArr[4]) != null) {
//            word_num5.setText(String.valueOf(charArr[4]));
//         }
	}
	
	public void Turn() {
		
		user.setText(userturn);
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		player.setCellValueFactory(cellData -> cellData.getValue().getPlayer());
		
		GameWord();
		Turn();
	
		Task<Boolean> task = new Task<Boolean>() {
			
			@Override
			protected Boolean call() throws Exception {
				boolean flag = false;
				for (int i = 0; i<=50; i++) {
					updateProgress(i, 50);
					Thread.sleep(130);
					flag = true;
				}
				return flag;
			}
			
		};//task end 
		
		
//		System.out.println("result : "+task.getValue());
		bar.progressProperty().bind(task.progressProperty());
		Thread thread = new Thread(task);
		thread.start();

	}

	@FXML
	private void exitApp() {
		System.exit(0);
	}
}
