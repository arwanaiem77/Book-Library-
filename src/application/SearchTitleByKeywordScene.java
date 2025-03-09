package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class SearchTitleByKeywordScene extends Pane{

	public SearchTitleByKeywordScene(Stage primaryStage,Scene oldScene) {
			Button back =new Button("Back");
	    	back.setStyle("-fx-background-color: #E65A1D; -fx-text-fill: white; -fx-font-size: 14px; -fx-padding: 10px 20px; -fx-border-radius: 5px; -fx-background-radius: 5px;");
			back.setOnAction(a ->{
				primaryStage.setScene(oldScene);		
				primaryStage.setFullScreen(true);
			});
			
			BorderPane bp =new BorderPane();
			Label l =new Label(" Title : ");
			l.setFont(new Font(20));
			TextField tf =new TextField();
			Button search =new Button("search");
	    	search.setStyle("-fx-background-color: #E65A1D; -fx-text-fill: white; -fx-font-size: 14px; -fx-padding: 10px 20px; -fx-border-radius: 5px; -fx-background-radius: 5px;");

			HBox hb =new HBox(10);
			hb.getChildren().addAll(l,tf,search,back);
			
			TableView<BookRecords> tv = new TableView<BookRecords>();
			ObservableList<BookRecords> ov = FXCollections.observableArrayList(BookRecords.bookList);
			
			TableColumn<BookRecords,Integer> tc1 =new TableColumn<>("BookID");
			tc1.setCellValueFactory(new PropertyValueFactory<>("bookId"));
			TableColumn<BookRecords,String> tc2 =new TableColumn<>("Title");
			tc2.setCellValueFactory(new PropertyValueFactory<>("title"));
			TableColumn<BookRecords,String> tc3 =new TableColumn<>("Author");
			tc3.setCellValueFactory(new PropertyValueFactory<>("author"));
			TableColumn<BookRecords,String> tc4 =new TableColumn<>("Category");
			tc4.setCellValueFactory(new PropertyValueFactory<>("category"));
			TableColumn<BookRecords,Integer> tc5 =new TableColumn<>("Published Year");
			tc5.setCellValueFactory(new PropertyValueFactory<>("publishedYear"));
			TableColumn<BookRecords,String> tc6 =new TableColumn<>("ISBN");
			tc6.setCellValueFactory(new PropertyValueFactory<>("isbn"));
			
			tv.getColumns().addAll(tc1, tc2, tc3, tc4, tc5,tc6);
			tv.setItems(ov);
			
			bp.setCenter(tv);
			bp.setTop(hb);
			
			search.setOnAction(a ->{			
				tv.getItems().clear();

				String keyword=tf.getText().toLowerCase();
				ObservableList<BookRecords> ov1 = FXCollections.observableArrayList();

				for(int i=0; i<BookRecords.bookList.size();i++) {
					if(BookRecords.bookList.get(i).getTitle().toLowerCase().contains(keyword))
						ov1.add(BookRecords.bookList.get(i));
					
				}
				tv.setItems(ov1);
			
				
			});
			bp.setStyle("-fx-background-color: #F8EED9;");
			Scene scene =new Scene(bp,1100,700);
			primaryStage.setScene(scene);		
			primaryStage.setFullScreen(true);
			primaryStage.show();
			
	}
	
	

}
