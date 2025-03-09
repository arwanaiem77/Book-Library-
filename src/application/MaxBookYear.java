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

public class MaxBookYear extends Pane{
	ArrayList<Integer> specificYearList=new ArrayList<>();
	ArrayList<Integer> maxYearList=new ArrayList<>();

	public MaxBookYear(Stage primaryStage,Scene oldScene) {
		BorderPane bp =new BorderPane();
		VBox vb =new VBox(10);
		vb.setAlignment(Pos.CENTER);
		for (int i=0;i<BookRecords.bookList.size();i++) {
			specificYearList.add(BookRecords.bookList.get(i).getPublishedYear());
		}


		Collections.sort(specificYearList);
		
		int count=1;	
		int maxCount = 1;
		int j = specificYearList.get(0);
		maxYearList.add(j); 

		for (int i=1;i<specificYearList.size();i++) {
			if (specificYearList.get(i).equals(j)) {
				count++;
				
			}
			else {
				if(count>maxCount) {
					maxCount = count;
					maxYearList.clear();
					maxYearList.add(j);
				}else if(count == maxCount) {
					maxYearList.add(j);
				}
				count=1;
				j=specificYearList.get(i);
			}
		}
		if (count > maxCount) {
			maxCount = count;
			maxYearList.clear();
			maxYearList.add(j);
		} else if (count == maxCount) {
			maxYearList.add(j);
		}
		for(int i =0;i<maxYearList.size();i++) {
			Label l1 = new Label("Year with maximum books: " + maxYearList.get(i) + " : " + maxCount + " books");
			l1.setFont(new Font(20));
			vb.getChildren().add(l1);
		}
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
