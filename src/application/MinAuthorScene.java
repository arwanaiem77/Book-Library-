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

public class MinAuthorScene extends Pane{
	ArrayList<String> AuthorList=new ArrayList<>();
	ArrayList<String> minAuthorList=new ArrayList<>();
	ArrayList<Object> bookList=new ArrayList<>();


	public MinAuthorScene(Stage primaryStage,Scene oldScene) {
		BorderPane bp =new BorderPane();
		VBox vb =new VBox(10);
		vb.setAlignment(Pos.CENTER);
		for (int i=0;i<BookRecords.bookList.size();i++) {
			AuthorList.add(BookRecords.bookList.get(i).getAuthor());
		}

		Collections.sort(AuthorList);
		
		int count=1;
        int minCount = Integer.MAX_VALUE; // Initialize to a large value
		String str =AuthorList.get(0);
		String strMax;

		for (int i=1;i<AuthorList.size();i++) {
			if (AuthorList.get(i).equals(str))
				count++;
			else {
			
				
					if(count<minCount) {
						minCount=count;
						minAuthorList.clear();
						minAuthorList.add(str);

					}else if(count == minCount) {
						minAuthorList.add(str);

					}
				
				count=1;
				str=AuthorList.get(i);
			}
		}
		if(count<minCount) {
			minCount=count;
			minAuthorList.clear();
			minAuthorList.add(str);
		}else if(count == minCount) {
			minAuthorList.add(str);
		}
		
	     for (String author : minAuthorList) {
	            Label l1 = new Label("Author with minimum books: " + author + " : " + minCount + " books");
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
		
//		for(int i=0;i<minAuthorList.size();i++) {
//			for (int j=1;j<BookRecords.bookList.size();j++) {
//				if(BookRecords.bookList.get(i).getAuthor().equals(minAuthorList.get(i))) {
//					bookList.add(BookRecords.bookList.get(j).getTitle());
//				}
//				
//			}
//			
//		}
//
//
//		for (String author : minAuthorList) {
//			Label l1 = new Label("Author with minimum books: " + author + " : " + minCount + " books");
//			l1.setFont(new Font(20));
//			vb.getChildren().add(l1);
//			Label label = new Label("Books:");
//			label.setFont(new Font(15));
//			vb.getChildren().add(label);
//			for (int i = 0; i < BookRecords.bookList.size(); i++) {
//
//				if (BookRecords.bookList.get(i).getAuthor().equals(author)) {
//					bookList.add(BookRecords.bookList.get(i).getTitle());
//					Label bookLabel = new Label(bookList.get(i)+"");
//					bookLabel.setFont(new Font(15));
//					vb.getChildren().add(bookLabel);
//				}
//
//			}
//		}

       bp.setCenter(vb);
		
		
   
       
       
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
