package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class MainScene extends HBox{
	


	public MainScene(Stage primaryStage) {
		
		HBox hb =new HBox(170);// important to add it to the scene.
		hb.setPadding(new Insets(50,50,50,50));
		
		ImageView mainPhoto =new ImageView(new Image("main.png"));
		mainPhoto.setFitHeight(600);
		mainPhoto.setFitWidth(300);	
		ImageView addImg=new ImageView(new Image("add.png"));
		addImg.setFitHeight(300);
		addImg.setFitWidth(300);
		ImageView searchImg=new ImageView(new Image("search.png"));
		searchImg.setFitHeight(300);
		searchImg.setFitWidth(300);
		ImageView editImg=new ImageView(new Image("edit.png"));
		editImg.setFitHeight(300);
		editImg.setFitWidth(300);
		ImageView staticImg=new ImageView(new Image("static.png"));
		staticImg.setFitHeight(300);
		staticImg.setFitWidth(300);	
		ImageView saveImg=new ImageView(new Image("save.png"));
		saveImg.setFitHeight(300);
		saveImg.setFitWidth(300);	
		ImageView deleteImg=new ImageView(new Image("delete.png"));
		deleteImg.setFitHeight(300);
		deleteImg.setFitWidth(300);
		
		Button add =new Button("",addImg);
		add.setPrefHeight(300);
		add.setPrefWidth(300);
		Button search =new Button("",searchImg);
		search.setPrefHeight(300);
		search.setPrefWidth(300);
		Button edit =new Button("",editImg);
		edit.setPrefHeight(300);
		edit.setPrefWidth(300);
		Button stat =new Button("",staticImg);
		stat.setPrefHeight(300);
		stat.setPrefWidth(300);
		Button save =new Button("",saveImg);
		save.setPrefHeight(300);
		save.setPrefWidth(300);
		Button delete =new Button("",deleteImg);
		delete.setPrefHeight(300);
		delete.setPrefWidth(300);
		
		GridPane gp =new GridPane();
		gp.add(add, 700, 100);
		gp.add(search, 800, 100);
		gp.add(edit, 1000, 100);
		gp.add(stat, 700, 200);
		gp.add(save, 800, 200);
		gp.add(delete, 1000, 200);
		
		
		hb.getChildren().addAll(mainPhoto,gp);
		hb.setStyle("-fx-background-color: #F8EED9;");
		Scene scene =new Scene(hb,1100,700);
		primaryStage.setScene(scene);			
		primaryStage.setFullScreen(true);
		primaryStage.show();


		add.setOnAction(a ->{
			Scene scenee =new Scene(new AddBook(primaryStage,scene),1100,700);
		
		});
		search.setOnAction(a ->{
			Scene scenee =new Scene(new SearchEmployee(primaryStage,scene),1100,700);

		});
		edit.setOnAction(a ->{
			Scene scenee =new Scene(new EditBook(primaryStage,scene),1100,700);

		});
		stat.setOnAction(a ->{
			Scene scenee =new Scene(new StatisticMain(primaryStage,scene),1100,700);
		});
		save.setOnAction(a ->{
			File file =new File("updatedBooks.txt");
			try {
				PrintWriter print =new PrintWriter(file);
				for(int i=0; i<BookRecords.bookList.size();i++) {
					print.println(BookRecords.bookList.get(i).toString());
				}
				print.close();
				
				Alert alertForFile = new Alert(AlertType.INFORMATION);
				alertForFile.setTitle("Information loaded successfully");
				alertForFile.setHeaderText(null);
				alertForFile.setContentText("Information loaded to the file successfully");
				alertForFile.showAndWait();
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		});
		delete.setOnAction(a ->{
			Scene scenee =new Scene(new DeleteScene(primaryStage,scene),1100,700);

		});

		
		
	}

}
