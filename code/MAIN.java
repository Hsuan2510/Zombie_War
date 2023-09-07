package project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MAIN extends Application{
	public static Stage currentStage; //紀錄當前場景
	public static Scene menuScene;  //menu畫面
	public static final int width = 850;
    public static final int height = 480;
    
	@Override
	public void start(Stage primaryStage) throws Exception {
		currentStage =primaryStage;
		Parent root=FXMLLoader.load(getClass().getResource("menu.fxml"));
		menuScene=new Scene(root,width,height);
		
		
		currentStage.setTitle("Zombie War");
		currentStage.setScene(menuScene);
		currentStage.show();
		
	}
	public static void main(String[]args) {
		launch(args);
	}

}
