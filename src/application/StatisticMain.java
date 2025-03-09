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

public class StatisticMain extends Pane {

	public StatisticMain(Stage primaryStage,Scene oldScene) {
		BorderPane bp =new BorderPane();
		ImageView categoryImg=new ImageView(new Image("category.png"));
		categoryImg.setFitHeight(300);
		categoryImg.setFitWidth(300);
		ImageView yearMaxImg=new ImageView(new Image("yearMax.png"));
		yearMaxImg.setFitHeight(300);
		yearMaxImg.setFitWidth(300);
		ImageView authorImg=new ImageView(new Image("author.png"));
		authorImg.setFitHeight(300);
		authorImg.setFitWidth(300);
		ImageView yearMinImg=new ImageView(new Image("yearMin.png"));
		yearMinImg.setFitHeight(300);
		yearMinImg.setFitWidth(300);
		ImageView authorMaxImg=new ImageView(new Image("authorMax.png"));
		authorMaxImg.setFitHeight(300);
		authorMaxImg.setFitWidth(300);
		ImageView authorMinImg=new ImageView(new Image("authorMin.png"));
		authorMinImg.setFitHeight(300);
		authorMinImg.setFitWidth(300);
		ImageView specificYearImg=new ImageView(new Image("specificYear.png"));
		specificYearImg.setFitHeight(300);
		specificYearImg.setFitWidth(300);
		ImageView activeImg=new ImageView(new Image("check.png"));
		activeImg.setFitHeight(300);
		activeImg.setFitWidth(300);
		
		Button category =new Button("",categoryImg);
		category.setPrefHeight(300);
		category.setPrefWidth(300);
		Button yearMax =new Button("",yearMaxImg);
		yearMax.setPrefHeight(300);
		yearMax.setPrefWidth(300);
		Button author =new Button("",authorImg);
		author.setPrefHeight(300);
		author.setPrefWidth(300);
		Button yearMin =new Button("",yearMinImg);
		yearMin.setPrefHeight(300);
		yearMin.setPrefWidth(300);	
		Button authorMax =new Button("",authorMaxImg);
		authorMax.setPrefHeight(300);
		authorMax.setPrefWidth(300);
		Button authorMin =new Button("",authorMinImg);
		authorMin.setPrefHeight(300);
		authorMin.setPrefWidth(300);
		Button specificYear =new Button("",specificYearImg);
		specificYear.setPrefHeight(300);
		specificYear.setPrefWidth(300);
		Button active =new Button("",activeImg);
		active.setPrefHeight(300);
		active.setPrefWidth(300);
		
		GridPane gp =new GridPane();
		gp.add(category, 0, 0);
		gp.add(yearMax, 0, 1);
		gp.add(author, 1, 0);
		gp.add(yearMin, 1, 1);
		gp.add(specificYear, 2, 0);
		gp.add(authorMax, 2, 1);
		gp.add(active, 3, 0);
		gp.add(authorMin, 3, 1);
		gp.setAlignment(Pos.CENTER);
		
		bp.setCenter(gp);
		bp.setStyle("-fx-background-color: #F8EED9;");
		Button back =new Button("Back");
    	back.setStyle("-fx-background-color: #E65A1D; -fx-text-fill: white; -fx-font-size: 14px; -fx-padding: 10px 20px; -fx-border-radius: 5px; -fx-background-radius: 5px;");
		back.setOnAction(a ->{
			primaryStage.setScene(oldScene);		
			primaryStage.setFullScreen(true);
		});
		Scene scene =new Scene(bp,1100,700);
		primaryStage.setScene(scene);		
		primaryStage.setFullScreen(true);
		primaryStage.show();
		bp.setBottom(back);
		category.setOnAction(a ->{
			Scene scenee =new Scene(new CategoryScene(primaryStage,scene),1100,700);
		});
		author.setOnAction(a ->{
			Scene scenee =new Scene(new AuthorScene(primaryStage,scene),1100,700);
			
		});
		specificYear.setOnAction(a ->{
			Scene scenee =new Scene(new SpecificYearScene(primaryStage,scene),1100,700);

		});
		yearMax.setOnAction(a ->{
			Scene scenee =new Scene(new MaxBookYear(primaryStage,scene),1100,700);

		});
		yearMin.setOnAction(a ->{
			Scene scenee =new Scene(new MinYearScene(primaryStage,scene),1100,700);

		});
		authorMax.setOnAction(a ->{
			Scene scenee =new Scene(new MaxAuthorScene(primaryStage,scene),1100,700);

		});
		authorMin.setOnAction(a ->{
			Scene scenee =new Scene(new MinAuthorScene(primaryStage,scene),1100,700);

		});
		active.setOnAction(a ->{
			Scene scenee =new Scene(new ActiveScene(primaryStage,scene),1100,700);

		});
		
	}
	

}
