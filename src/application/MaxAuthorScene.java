package application;

import java.util.ArrayList;
import java.util.Collections;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MaxAuthorScene extends Pane {
	ArrayList<String> AuthorList=new ArrayList<>();
	ArrayList<String> maxAuthorList=new ArrayList<>();
	ArrayList<String> bookList=new ArrayList<>();


	public MaxAuthorScene(Stage primaryStage,Scene oldScene) {
		BorderPane bp =new BorderPane();
		VBox vb =new VBox(10);
		vb.setAlignment(Pos.CENTER);
		for (int i=0;i<BookRecords.bookList.size();i++) {
			AuthorList.add(BookRecords.bookList.get(i).getAuthor());
		}

		Collections.sort(AuthorList);
		
		int count=1;
		int maxCount=1;
		String str =AuthorList.get(0);
		String strMax;

		for (int i=1;i<AuthorList.size();i++) {
			if (AuthorList.get(i).equals(str))
				count++;
			else {
				if(count>maxCount) {
					maxCount=count;
					strMax=str;
					maxAuthorList.clear();
					maxAuthorList.add(str);
				}else if(count == maxCount) {
					maxAuthorList.add(str);
				}
				count=1;
				str=AuthorList.get(i);
			}
		}
		if(count>maxCount) {
			maxCount=count;
			maxAuthorList.clear();
			maxAuthorList.add(str);
		}else if(count == maxCount) {
			maxAuthorList.add(str);
		}
		
	     for (String author : maxAuthorList) {
	            Label l1 = new Label("Author with Maximum books: " + author + " : " + maxCount + " books");
	            l1.setFont(new Font(20));
	            vb.getChildren().add(l1);

	            for (int i = 0; i < BookRecords.bookList.size(); i++) {
	                if (BookRecords.bookList.get(i).getAuthor().equals(author)) {
	                    String bookTitle = BookRecords.bookList.get(i).getTitle();
	                    Label bookLabel = new Label(bookTitle);
	                    bookLabel.setFont(new Font(15));
	                    vb.getChildren().add(bookLabel);
	                }
	            }
	     }
		
		
		
		
		
		
//		for(int i=1;i<maxAuthorList.size();i++) {
//			for (int j=1;j<BookRecords.bookList.size();j++) {
//				if(BookRecords.bookList.get(i).getAuthor().equals(maxAuthorList.get(i))) {
//					bookList.add(BookRecords.bookList.get(j).getTitle());
//				}
//				
//			}
//			
//		}
//	    for (String author : maxAuthorList) {
//	        Label l1 = new Label("Author with maximum books: " + author + " : " + maxCount + " books");
//	        l1.setFont(new Font(20));
//	        vb.getChildren().add(l1);
//	    }
//		
//		 for (String author : maxAuthorList) {
//		        for (int i = 0; i < BookRecords.bookList.size(); i++) {
//		            if (BookRecords.bookList.get(i).getAuthor().equals(author)) {
//		            	bookList.add(BookRecords.bookList.get(i).getTitle()); // Assuming getTitle() returns the book title
//		            }
//		        }
//		    }
		
       bp.setCenter(vb);
		
		
       for (String bookTitle : bookList) {
           Label bookLabel = new Label(bookTitle);
           bookLabel.setFont(new Font(15));
           vb.getChildren().add(bookLabel);
       }
     	bp.setStyle("-fx-background-color: #F8EED9;");
    	Button back =new Button("Back");
    	back.setStyle("-fx-background-color: #E65A1D; -fx-text-fill: white; -fx-font-size: 14px; -fx-padding: 10px 20px; -fx-border-radius: 5px; -fx-background-radius: 5px;");
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
