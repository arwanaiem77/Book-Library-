package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class EditBook extends Pane{

	public EditBook(Stage primaryStage,Scene oldScene) {
	
		
		GridPane gp =new GridPane();
		gp.setPadding(new Insets(200,50,50,50));
		TextField idTf =new TextField();
		TextField titleTf =new TextField();
		TextField authorTf =new TextField();
		TextField categoryTf =new TextField();
		TextField publishTf =new TextField();
		TextField isbnTf =new TextField();
		Label bookIdLabel = new Label("BookID");
		bookIdLabel.setFont(new Font(20));
		Label titleLabel = new Label("Title");
		titleLabel.setFont(new Font(20));
		Label authorLabel = new Label("Author");
		authorLabel.setFont(new Font(20));
		Label categoryLabel = new Label("Category");
		categoryLabel.setFont(new Font(20));
		Label publishLabel = new Label("Published Year");
		publishLabel.setFont(new Font(20));
		Label isbnLabel = new Label("ISBN");
		isbnLabel.setFont(new Font(20));
		
		
		gp.add(bookIdLabel, 0, 0);
		gp.add(idTf, 1, 0);
		gp.add(titleLabel, 0, 1);
		gp.add(titleTf, 1, 1);
		gp.add(authorLabel, 0, 2);
		gp.add(authorTf, 1, 2);
		gp.add(categoryLabel, 0, 3);
		gp.add(categoryTf, 1, 3);	
		gp.add(publishLabel, 0, 4);
		gp.add(publishTf, 1, 4);
		gp.add(isbnLabel, 0, 5);
		gp.add(isbnTf, 1, 5);
		
		HBox hbox =new HBox(7);
		TextField tf =new TextField();
		Button edit =new Button("Edit");
		Label l=new Label("Enter Thie BookID:");
		l.setFont(new Font(20));
		hbox.getChildren().addAll(l,tf,edit);
		edit.setStyle("-fx-background-color: #E65A1D; -fx-text-fill: white; -fx-font-size: 14px; -fx-padding: 10px 20px; -fx-border-radius: 5px; -fx-background-radius: 5px;");

		edit.setOnAction(a ->{
			for (int i=0;i<BookRecords.bookList.size()-1;i++) {
				if(Integer.parseInt(tf.getText())== BookRecords.bookList.get(i).getBookId()) {
					idTf.setText(String.valueOf(BookRecords.bookList.get(i).getBookId()));
					authorTf.setText(BookRecords.bookList.get(i).getAuthor());
					titleTf.setText(BookRecords.bookList.get(i).getTitle());
					categoryTf.setText(BookRecords.bookList.get(i).getCategory());
					publishTf.setText(String.valueOf(BookRecords.bookList.get(i).getPublishedYear()));
					isbnTf.setText(BookRecords.bookList.get(i).getIsbn());
					
				}
			}
		});
		
		VBox vb1 =new VBox(200);
		vb1.getChildren().addAll(gp,hbox);
		
		VBox vb =new VBox(100);
		ImageView img =new ImageView (new Image("library.JPG"));
		img.setFitWidth(600);
		img.setFitHeight(600);
		
		Button back =new Button("Back");
    	back.setStyle("-fx-background-color: #E65A1D; -fx-text-fill: white; -fx-font-size: 14px; -fx-padding: 10px 20px; -fx-border-radius: 5px; -fx-background-radius: 5px;");
		back.setOnAction(a ->{
			primaryStage.setScene(oldScene);		
			primaryStage.setFullScreen(true);
		});
		
		Button saveEditing = new Button("Save Edit");
		saveEditing.setStyle("-fx-background-color: #E65A1D; -fx-text-fill: white; -fx-font-size: 14px; -fx-padding: 10px 20px; -fx-border-radius: 5px; -fx-background-radius: 5px;");

		saveEditing.setOnAction(a ->{
			BookRecords book=null ;
			 for (int i=0;i<BookRecords.bookList.size();i++) {
		            if (BookRecords.bookList.get(i).getBookId() == Integer.parseInt(idTf.getText())) {
		                book = BookRecords.bookList.get(i);
		                break;
		            }
		        }
			book.setBookId(Integer.parseInt(idTf.getText()));
			book.setTitle(titleTf.getText());
			book.setAuthor(authorTf.getText());
			book.setCategory(categoryTf.getText());
			book.setPublishedYear(Integer.parseInt(publishTf.getText()));
			book.setIsbn(isbnTf.getText());			
			//BookRecords.bookList.set(Integer.parseInt(idTf.getText()), book);

				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("SUCCESS!");
				alert.setContentText("The information edited successfully");
				alert.showAndWait();

				idTf.clear();
				authorTf.clear();
				titleTf.clear();
				categoryTf.clear();
				publishTf.clear();
				isbnTf.clear();	
			
		});
		
		HBox hb1 =new HBox(20);
		hb1.getChildren().addAll(back,saveEditing);
		
		vb.getChildren().addAll(img,hb1);

		HBox hb =new HBox(300);
		hb.setPadding(new Insets(50,50,50,50));
		hb.getChildren().addAll(vb,vb1);
		hb.setStyle("-fx-background-color: #F8EED9;");
		
		Scene scene =new Scene(hb,1100,700);
		primaryStage.setScene(scene);		
		primaryStage.setFullScreen(true);
		primaryStage.show();




	}


}



