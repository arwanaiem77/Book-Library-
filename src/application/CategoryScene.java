package application;

import java.util.ArrayList;
import java.util.Collections;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class CategoryScene extends Pane  {
ArrayList<String> categoryList=new ArrayList<>();

	public CategoryScene(Stage primaryStage,Scene oldScene) {
		BorderPane bp =new BorderPane();
		VBox vb =new VBox(10);
		vb.setAlignment(Pos.CENTER);
		for (int i=0;i<BookRecords.bookList.size();i++) {
			categoryList.add(BookRecords.bookList.get(i).getCategory());
		}

		Collections.sort(categoryList);
		if(!categoryList.isEmpty()) {
		int count=1;			
		String str =categoryList.get(0);

		for (int i=1;i<categoryList.size();i++) {
			if (categoryList.get(i).equals(str))
				count++;
			else {
				Label l=new Label(str+":"+count);
				l.setFont(new Font(20));
				vb.getChildren().add(l);
				count=1;
				str=categoryList.get(i);
			}
		}
		Label l=new Label(str+":"+count);
		l.setFont(new Font(20));
		vb.getChildren().add(l);
		
       bp.setCenter(vb);
		
		
		
//		boolean found =false;
//		for (int i=0;i<BookRecords.bookList.size()-1;i++) {
//			for(int j=0;j<categoryList.size()-1;j++) {
//				if (BookRecords.bookList.get(i).getCategory().equals(categoryList.get(j))) {
//					freqList.set(j, freqList.get(j)+1);
//					found=true;
//					 break;
//				}
//				
//			}
//		 if (found==false) {
//					categoryList.add(BookRecords.bookList.get(i).getCategory());
//					freqList.add(1);
//					
//		}
//		}
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
	
	} else {
	    Alert alert = new Alert(AlertType.ERROR);
	    alert.setTitle("Error");
	    alert.setContentText("There is no books added ");
	    alert.showAndWait();
		
	}


}
	

}
