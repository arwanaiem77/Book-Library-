package application;

import java.util.ArrayList;
import java.util.Collections;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class ActiveScene extends Pane {
	ArrayList<String> AuthorList=new ArrayList<>();
	boolean isFound;

	public ActiveScene(Stage primaryStage,Scene oldScene) {
		BorderPane bp =new BorderPane();
		TextField tf=new TextField();
		Label l =new Label ("Enter the author you want to check the activity:");
		Button btn =new Button("check");
		HBox hb =new HBox(7);
		hb.setAlignment(Pos.CENTER);
		l.setFont(new Font(20));
		hb.getChildren().addAll(l,tf,btn);
		VBox vb =new VBox(10);
		vb.setAlignment(Pos.CENTER);
		vb.getChildren().add(hb);
		for (int i=0;i<BookRecords.bookList.size();i++) {
			if(BookRecords.bookList.get(i).getPublishedYear()>=2020)
				AuthorList.add(BookRecords.bookList.get(i).getAuthor());
		}		

	    VBox vb2 = new VBox();
	    vb2.setAlignment(Pos.CENTER);
	    vb.getChildren().add(vb2);

	    btn.setOnAction(a -> {
	        vb2.getChildren().clear(); 
	        String searchText = tf.getText().trim(); 

	        if (searchText.isEmpty()) {
	            Label messageLabel = new Label("Please enter an author's name.");
	            messageLabel.setFont(new Font(15));
	            vb2.getChildren().add(messageLabel);
	        } else {
	            boolean isFound = false; 
	            for (String author : AuthorList) {
	                if (author.equalsIgnoreCase(searchText)) { 
	                    isFound = true;
	                    break; 
	                }
	            }

	            Label resultLabel = new Label(isFound ? "Is Active" : "Is NOT Active");
	            resultLabel.setFont(new Font(15));
	            vb2.getChildren().add(resultLabel);
	        }
	    });
//		VBox vb2 =new VBox();
//
//		for (int i=0;i<AuthorList.size();i++) {
//			Label l2 = new Label(AuthorList.get(i));
//			l2.setFont(new Font(15));
//			vb2.getChildren().add(l2);
//
//		}	
//
//		btn.setOnAction(a ->{
//			vb2.getChildren().clear();
//			for (int i=0;i<AuthorList.size();i++) {
//				if (tf.getText().equalsIgnoreCase(AuthorList.get(i))) {
//					isFound=true;
//					break;
//				}
//			}
//
//		});
//		if(isFound) {
//			Label l3=new Label("is Active");
//			l3.setFont(new Font(15));
//			vb2.setAlignment(Pos.CENTER);
//			vb2.getChildren().add(l3);
//		}else {
//			Label l3=new Label("is NOT Active");
//			l3.setFont(new Font(15));
//			vb2.setAlignment(Pos.CENTER);
//			vb2.getChildren().add(l3);
//		}
//		
//		vb.getChildren().add(vb2);
//

		bp.setCenter(vb);

		
     	bp.setStyle("-fx-background-color: #F8EED9;");
    	Button back =new Button("Back");
		back.setOnAction(a ->{
			primaryStage.setScene(oldScene);		
			primaryStage.setFullScreen(true);
		});
		bp.setBottom(back);
		Scene scene =new Scene(bp,1100,700);
		primaryStage.setScene(scene);		
		primaryStage.setFullScreen(true);
		primaryStage.show();
	}


}
