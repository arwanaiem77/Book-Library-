package application;

import java.util.Collections;
import java.util.Comparator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BookTableView extends Pane {
	public BookTableView(Stage primaryStage,Scene oldScene) {
		Button back =new Button("Back");
		back.setStyle("-fx-background-color: #E65A1D; -fx-text-fill: white; -fx-font-size: 14px; -fx-padding: 10px 20px; -fx-border-radius: 5px; -fx-background-radius: 5px;");
		back.setOnAction(a ->{
			primaryStage.setScene(oldScene);		
			primaryStage.setFullScreen(true);
		});

		BorderPane bp =new BorderPane();
		ComboBox<String> Sorting =new ComboBox<>();

		HBox hb =new HBox(10);
		hb.getChildren().addAll(Sorting,back);

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


		Sorting.getItems().addAll("Title", "Author", "Published Year");
		Sorting.setOnAction(a ->{

			if (Sorting.getSelectionModel().getSelectedItem().equals("Title")) {	

				  Collections.sort(BookRecords.bookList, new Comparator<BookRecords>() {
                      @Override
                      public int compare(BookRecords b1, BookRecords b2) {
                          return b1.getTitle().compareTo(b2.getTitle());
                      }
                  });

			}else if (Sorting.getSelectionModel().getSelectedItem().equals("Author")) {	

				  Collections.sort(BookRecords.bookList, new Comparator<BookRecords>() {
                      @Override
                      public int compare(BookRecords b1, BookRecords b2) {
                          return b1.getAuthor().compareTo(b2.getAuthor());
                      }
                  });
			}
			else if (Sorting.getSelectionModel().getSelectedItem().equals("Published Year")) {			    
		         Collections.sort(BookRecords.bookList, new Comparator<BookRecords>() {
                     @Override
                     public int compare(BookRecords b1, BookRecords b2) {
                         return Integer.compare(b1.getPublishedYear(), b2.getPublishedYear()); 
                     }
                 });


			}
			ObservableList<BookRecords> ov1 = FXCollections.observableArrayList(BookRecords.bookList);
			tv.setItems(ov1);



		});



		Scene scene =new Scene(bp,1100,700);
		primaryStage.setScene(scene);		
		primaryStage.setFullScreen(true);
		primaryStage.show();
	}

}
