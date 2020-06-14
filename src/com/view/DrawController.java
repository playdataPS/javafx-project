package com.view;

import java.util.ArrayList;

import com.main.MainApp;
import com.vo.GameUser;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class DrawController {
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
	private TableView<GameUser> playerlist ;
	@FXML
	private TableColumn<GameUser, String> player;
	@FXML
	private TextField inputchat;
	@FXML
	private TextArea chat;
	@FXML
	private ColorPicker cPick;
	@FXML
	private Slider slider;
	
	private GraphicsContext gc;
	
    double startX, startY, lastX,lastY,oldX,oldY;
    double hg;

	private MainApp mainApp;
	
	private String word="바나나";
	
	private Stage drawStage;

	public DrawController() {
		super();
	}
	
    public void setDrawStage(Stage drawStage) {
		this.drawStage = drawStage;
	}

	private void freeDrawing()
    {
        gc.setLineWidth(slider.getValue());
        gc.setStroke(cPick.getValue());
        gc.strokeLine(oldX, oldY, lastX, lastY);
        oldX = lastX;
        oldY = lastY;
    }
	
	@FXML
    private void onMousePressedListener(MouseEvent e){
        this.startX = e.getX();
        this.startY = e.getY();
        this.oldX = e.getX();
        this.oldY = e.getY();
    }
	
    @FXML
    private void onMouseDraggedListener(MouseEvent e){
        this.lastX = e.getX();
        this.lastY = e.getY();
        
        freeDrawing();
    }
    
	private void initialize() {
		player.setCellValueFactory(cellData -> cellData.getValue().getPlayer());
	}
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	
		playerlist.setItems(mainApp.getGameUsers());
		
		GameWord();
		
		gc = canvas.getGraphicsContext2D();
		gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
		
		slider.setMin(1);
		slider.setMax(50);
		
		cPick.setValue(Color.BLACK);
		
		inputchat.requestFocus();
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
	
	@FXML
	private void submitBtn() {
		chat.appendText(inputchat.getText());
	}
	
	@FXML
	private void exitbtn() {
		drawStage.hide();
	}
}
