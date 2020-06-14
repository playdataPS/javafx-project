package com.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class MicroPaint extends Application {

@Override
public void start(Stage stage) throws Exception {
    //Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));

    FXMLLoader loader = new FXMLLoader();
	loader.setLocation(MicroPaint.class.getResource("/FXMLDocument.fxml"));
	AnchorPane root = (AnchorPane) loader.load();
	
	stage.setTitle("MicroPaint");
	
    Scene scene = new Scene(root);

    stage.setScene(scene);
    
    FXMLDocumentController controller = loader.getController();
    stage.show();
}

/**
 * @param args the command line arguments
 */
public static void main(String[] args) {
    launch(args);
}

}