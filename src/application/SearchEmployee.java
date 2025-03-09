package application;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SearchEmployee extends Pane {

	public SearchEmployee(Stage primaryStage,Scene oldScene) {
		BorderPane bp =new BorderPane();
		ImageView searchByKeyTitleImg=new ImageView(new Image("ktitle.png"));
		searchByKeyTitleImg.setFitHeight(300);
		searchByKeyTitleImg.setFitWidth(300);
		ImageView searchByKeyAuthorImg=new ImageView(new Image("kauthor.png"));
		searchByKeyAuthorImg.setFitHeight(300);
		searchByKeyAuthorImg.setFitWidth(300);
		ImageView searchByBookIDImg=new ImageView(new Image("id.png"));
		searchByBookIDImg.setFitHeight(300);
		searchByBookIDImg.setFitWidth(300);
		ImageView searchByTitleImg=new ImageView(new Image("title.png"));
		searchByTitleImg.setFitHeight(300);
		searchByTitleImg.setFitWidth(300);
		
		Button searchByKeyTitle =new Button("",searchByKeyTitleImg);
		searchByKeyTitle.setPrefHeight(300);
		searchByKeyTitle.setPrefWidth(300);
		Button searchByKeyAuthor =new Button("",searchByKeyAuthorImg);
		searchByKeyAuthor.setPrefHeight(300);
		searchByKeyAuthor.setPrefWidth(300);
		Button searchByBookID =new Button("",searchByBookIDImg);
		searchByBookID.setPrefHeight(300);
		searchByBookID.setPrefWidth(300);
		Button searchByTitle =new Button("",searchByTitleImg);
		searchByTitle.setPrefHeight(300);
		searchByTitle.setPrefWidth(300);
		
		GridPane gp =new GridPane();
		gp.add(searchByKeyTitle, 700, 100);
		gp.add(searchByKeyAuthor, 800, 100);
		gp.add(searchByBookID, 700, 200);
		gp.add(searchByTitle, 800, 200);
		
		gp.setAlignment(Pos.CENTER);
		
		bp.setCenter(gp);
		bp.setStyle("-fx-background-color: #F8EED9;");
		Button back =new Button("Back");
    	back.setStyle("-fx-background-color: #E65A1D; -fx-text-fill: white; -fx-font-size: 14px; -fx-padding: 10px 20px; -fx-border-radius: 5px; -fx-background-radius: 5px;");
		back.setOnAction(a ->{
			primaryStage.setScene(oldScene);		
			primaryStage.setFullScreen(true);
		});
		bp.setBottom(back);
		bp.setStyle("-fx-background-color: #F8EED9;");

		Scene scene =new Scene(bp,1100,700);
		primaryStage.setScene(scene);		
		primaryStage.setFullScreen(true);
		primaryStage.show();
		
		searchByBookID.setOnAction(a ->{
			Scene scenee =new Scene(new SearchBookID(primaryStage,scene),1100,700);
		});
		searchByTitle.setOnAction(a ->{
			Scene scenee =new Scene(new SearchBookTitle(primaryStage,scene),1100,700);

		});
		searchByKeyTitle.setOnAction(a ->{
			Scene scenee =new Scene(new SearchTitleByKeywordScene(primaryStage,scene),1100,700);

		});
		searchByKeyAuthor.setOnAction(a ->{
			Scene scenee =new Scene(new SearchAuthorByKeywordScene(primaryStage,scene),1100,700);

		});
	
	}
	
	

}
