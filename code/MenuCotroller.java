package project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class MenuCotroller  implements Initializable{
		boolean n=false;
		public static int onemin=1000,twomin=1000,threemin=1000;
		public static int onesec=1000,twosec=1000,threesec=1000;
		@FXML
		public AnchorPane lightclick;
		@FXML
		Button simple;
		@FXML
		Button medium;
		@FXML
		Button hard;
		@FXML
		ImageView light;
		@FXML
		public void onsimplePressed() throws IOException{
			Parent simple=FXMLLoader.load(getClass().getResource("simple.fxml"));
			Scene simpleScene=new Scene(simple);
			simpleScene.getRoot().requestFocus();
			MAIN.currentStage.setScene(simpleScene);
		}
		@FXML
		public void click() {
			n=!n;
			if(n) {
				lightclick.setVisible(true);
			}
			else lightclick.setVisible(false);
				
		}
		@FXML
		public void medium() throws IOException{
			Parent medium=FXMLLoader.load(getClass().getResource("medium.fxml"));
			Scene mediumScene=new Scene(medium);
			mediumScene.getRoot().requestFocus();
			MAIN.currentStage.setScene(mediumScene);
		}
		@FXML
		public void onhardPressed() throws IOException{
			Parent hard=FXMLLoader.load(getClass().getResource("hard.fxml"));
			Scene hardScene=new Scene(hard);
			hardScene.getRoot().requestFocus();
			MAIN.currentStage.setScene(hardScene);
		}
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			Timeline lightmove=new Timeline(new KeyFrame(Duration.millis(500),(e)->{
					light.setLayoutY(335);
			
			}));
			Timeline nn=new Timeline(new KeyFrame(Duration.millis(1000),(e)->{
				light.setLayoutY(354);
				light.setLayoutX(46);
			}));
			lightmove.setCycleCount(Timeline.INDEFINITE);
			lightmove.play();
			nn.setCycleCount(Timeline.INDEFINITE);
			nn.play();
		}
}
