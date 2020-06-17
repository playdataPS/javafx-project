package com.view;

import java.util.Collections;
import java.util.List;

import com.client.ClientListener;
import com.main.MainApp;
import com.vo.Room;
import com.vo.Status;
import com.vo.User;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class WaitingRoomController {

	private static WaitingRoomController instance;
	@FXML
	private Label RoomNameLabel;
	@FXML
	private Label CurrUserCount;
	@FXML
	private Label MaxUserCount;

	@FXML
	private Label UserLabel1;
	@FXML
	private Label UserLabel2;
	@FXML
	private Label UserLabel3;
	@FXML
	private Label UserLabel4;
	@FXML
	private Label UserLabel5;
	@FXML
	private Label UserLabel6;
	@FXML
	private Label UserLabel7;
	@FXML
	private Label UserLabel8;

	@FXML
	private Label[] UserLabels = { UserLabel1, UserLabel2, UserLabel3, UserLabel4, UserLabel5, UserLabel6, UserLabel7,
			UserLabel8 };

	@FXML
	private TextArea chatArea;
	@FXML
	private TextField input;
	@FXML
	private Button submitButton;
	@FXML
	private Button readyStart;
	@FXML
	private Button exitButton;
	@FXML
	private Pane user1;
	@FXML
	private Pane user2;
	@FXML
	private Pane user3;
	@FXML
	private Pane user4;
	@FXML
	private Pane user5;
	@FXML
	private Pane user6;
	@FXML
	private Pane user7;
	@FXML
	private Pane user8;

	@FXML
	private GridPane grid;

	private Stage waitingRoomStage;

	private MainApp mainApp;

	private Room room;

	private User user;

	private String state = "R";
	@FXML
	private List<Label> labelList;
	@FXML
	private List<Pane> userPaneList;

	public WaitingRoomController() {
		instance = this;
	}

	public static WaitingRoomController getInstance() {
		return instance;
	}

	@FXML
	private void initialize() {
//		System.out.println("initialize  " + getUser().getNickname());
		RoomNameLabel.setText("방 이름");
//		UserLabel1.setText(getUser().getNickname());
		UserLabel1.setText("");
		UserLabel2.setText("");
		UserLabel3.setText("");
		UserLabel4.setText("");
		UserLabel5.setText("");
		UserLabel6.setText("");
		UserLabel7.setText("");
		UserLabel8.setText("");
		input.setText("");
		input.requestFocus();
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
//		CurrUserCount.setText(String.valueOf(mainApp.getUserListOfRoomList().size()));
		MaxUserCount.setText("8");
		// UserLabel8.getStylesheets().add("LabelStyle.css");
		// UserLabel8.getStyleClass().add(".-rectPrepared");
	}

	public Stage getWaitingRoomStage() {
		return waitingRoomStage;
	}

	public void setWaitingRoomStage(Stage waitingRoomStage) {
		this.waitingRoomStage = waitingRoomStage;
	}

	public void changeRoomName() {
		RoomNameLabel.setText(room.getName());
	}

//	public void changeMaxNum() {
//		MaxUserCount.setText(room.getUserCnt().substring(room.getUserCnt() - 1,
//				room.getUserCnt()));
//	}

	public void changeCurrNum(int x) {
		CurrUserCount.setText(String.valueOf(x));
	}

	public void changeLabel(List<User> users) {
		Platform.runLater(() -> {
//			RoomNameLabel.setText(user.getNickname());
			CurrUserCount.setText(String.valueOf(users.size()));
			for (int i = 0; i < users.size(); i++) {
				String nickname = users.get(i).getNickname();
				System.out.println("nickname  :  " + nickname);
				userPaneList.get(i).setStyle(
						"-fx-background-color : #42A5F5; -fx-background-radius: 5px; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 10, 0, 0, 0);");
				labelList.get(i).setText(nickname);
			} // for end

		});

	}

	public void changeMessage() {
		Platform.runLater(() -> {
			// 채팅창의 내용을 업데이트
		});
	}

	@FXML
	private void submitAppend() {
		System.out.println("내용 가져와"+input.getText());
		ClientListener cli = new ClientListener();
		User userData = new User();
		userData.setNickname(getUser().getNickname());
		userData.setMessage(input.getText());
		userData.setStatus(Status.CHAT);
		cli.sendMessage(userData);
		input.setText("");
	}

	public void changeLabel1() {
		UserLabel1.setText(user.getNickname());
	}

	public void changeLabel1(String nickname) {
		UserLabel1.setText(nickname);
	}

	public void changeLabel2() {
		UserLabel2.setText(user.getNickname());
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public void refreshConstraints() {

	}

	public void ChangeReadyColor(List<User> users) {// ready 버튼 클릭
		// 사용자가 몇번째 pane에 들어가는지 알아야 background 바꿀 수 있음.
		// Platform.runLater(()->{
		int idx = 0;
		StringBuffer style = new StringBuffer();
		style.append(
				"-fx-background-radius: 5px; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 10, 0, 0, 0);");
		String red = style.append(" -fx-background-color : #EF5350;").toString();
		String blue = style.append(" -fx-background-color : #42A5F5;").toString();
		for (User u : users) {

			System.out.println("pane " + u.getNickname() + "  :  " + u.getStatus());

			if (u.getStatus().equals(Status.READY)) {
				if (state == "R") {
					readyStart.setStyle(blue);

					userPaneList.get(idx).setStyle(red);
					state = "B";
				} else {
					readyStart.setStyle(red);
					userPaneList.get(idx).setStyle(blue);
					state = "R";
				}
			}
			idx++;

		}

		// });

	}// end ChangeReadyColor()

	@FXML
	private void clickReadyBtn() {

		readyStart.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				User userData = ClientListener.getInstance().getUser();
				if (userData.getStatus().equals(Status.CONNECTED) || userData.getStatus().equals(Status.WAITING)) {
					userData.setStatus(Status.READY);
				} else if (userData.getStatus().equals(Status.READY)) {
					userData.setStatus(Status.WAITING);
				}
				userData.setNickname(LoginController.getInstance().getPlayerName());
				ClientListener.getInstance().sendData(userData);
			}
		});

	}

	@FXML
	private void readyStartState() {

	}

	@FXML
	private void exitApp() {
		System.exit(0);
	}

}
