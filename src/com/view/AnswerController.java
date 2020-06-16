package com.view;

import java.net.URL;
import java.util.ResourceBundle;

import com.main.MainApp;
import com.vo.GameUser;
import com.vo.Room;
import com.vo.User2;

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

public class AnswerController implements Initializable{
	
//	@FXML
//	private Label word_num1;
	@FXML
	private Label word_num2;
	@FXML
	private Label word_num3;
	@FXML
	private Label word_num4;
//	@FXML
//	private Label word_num5;
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
	@FXML
	private Button match;
	@FXML
	private TextField inputanswer;
	
	@FXML
	private Button out;
	
	private String userturn = "jihye";
	
	private MainApp mainApp;
	
	private String allText = "";
	
	private Room room;
	
	private User2 user2;
	
	public void Turn() {
		
		user.setText(userturn);
		
	}
	public void clickSend() {
		chat.appendText(inputchat.getText() + "\n");
		inputchat.setText("");
	}
	public void clickanswer() {
		chat.appendText(inputanswer.getText() + "\n");
		inputanswer.setText("");
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		player.setCellValueFactory(cellData -> cellData.getValue().getPlayer());
		
		word_num2.setText("?");
		word_num3.setText("?");
		word_num4.setText("?");
		
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
		};
		bar.progressProperty().bind(task.progressProperty());
		Thread thread = new Thread(task);
		thread.start();
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;

		playerlist.setItems(mainApp.getGameUsers());
	}
	
	@FXML
	private void exitApp() {
		System.exit(0);
	}
}


