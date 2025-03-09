package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class AddBook extends Pane {

	public AddBook(Stage primaryStage,Scene oldScene) {
//		Button readFile = new Button("Read from file");
//		readFile.setOnAction(a -> {
//		    FileChooser file = new FileChooser();
//		    File c = file.showOpenDialog(primaryStage);
//		    if (c != null) {
//		        try (Scanner scan = new Scanner(c)) {
//		            while (scan.hasNextLine()) {
//		                String[] str = scan.nextLine().split(",");
//		                // Check if the array has the expected number of elements
//		                if (str.length == 6) {
//		                    try {
//		                        int id = Integer.parseInt(str[0].trim());
//		                        int year = Integer.parseInt(str[4].trim());
//		                        BookRecords book = new BookRecords(id, str[1].trim(), str[2].trim(), str[3].trim(), year, str[5].trim());
//		                        BookRecords.bookList.add(book);
//		                    } catch (NumberFormatException e) {
//		                        // Handle the case where parsing fails
//		                        System.err.println("Invalid number format in line: " + Arrays.toString(str));
//		                        // Optionally, show an alert to the user
//		                        Alert alert = new Alert(AlertType.ERROR);
//		                        alert.setTitle("ERROR!");
//		                        alert.setContentText("Invalid number format in line: " + Arrays.toString(str));
//		                        alert.showAndWait();
//		                    }
//		                } else {
//		                    // Handle the case where the line does not have the expected number of elements
//		                    System.err.println("Invalid line format: " + Arrays.toString(str));
//		                    // Optionally, show an alert to the user
//		                    Alert alert = new Alert(AlertType.ERROR);
//		                    alert.setTitle("ERROR!");
//		                    alert.setContentText("Invalid line format: " + Arrays.toString(str));
//		                    alert.showAndWait();
//		                }
//		            }
//		            Alert alert = new Alert(AlertType.INFORMATION);
//		            alert.setTitle("SUCCESS!");
//		            alert.setContentText("The books were added successfully");
//		            alert.showAndWait();
//		        } catch (FileNotFoundException e) {
//		            e.printStackTrace();
//		        }
//		    }
//		});
		Button readFile =new Button("Read from file");
		readFile.setStyle("-fx-background-color: #E65A1D; -fx-text-fill: white; -fx-font-size: 14px; -fx-padding: 10px 20px; -fx-border-radius: 5px; -fx-background-radius: 5px;");

		readFile.setOnAction(a ->{
			FileChooser file =new FileChooser();	
			File c = file.showOpenDialog(primaryStage);
			if (c != null) {
				int countLines=0;
				try (Scanner scan = new Scanner(c)) {
					while (scan.hasNextLine()) {
						String [] str = scan.nextLine().split(",");
						if(str.length==6) {
						BookRecords book =new BookRecords(Integer.parseInt(str[0].trim()),str[1].trim(),str[2].trim(),str[3].trim(),Integer.parseInt(str[4].trim())
								,str[5].trim());
						BookRecords.bookList.add(book);
						countLines++;
						}else {
						     Alert alert = new Alert(AlertType.ERROR);
			                    alert.setTitle("ERROR!");
			                    alert.setContentText("Invalid line format: " +countLines );
			                    alert.showAndWait();
						}
					}Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("SUCCESS!");
						alert.setContentText("The book added successfully");
						alert.showAndWait();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

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
		
		VBox vb1 =new VBox(20);
		vb1.getChildren().addAll(gp,readFile);
		
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
		
		Button add = new Button("Add");
		add.setStyle("-fx-background-color: #E65A1D; -fx-text-fill: white; -fx-font-size: 14px; -fx-padding: 10px 20px; -fx-border-radius: 5px; -fx-background-radius: 5px;");

		add.setOnAction(a ->{
			if(idTf.getText()==null||authorTf.getText()==null||titleTf.getText()==null||categoryTf.getText()==null||publishTf.getText()==null||isbnTf.getText()==null) {
			    Alert alert = new Alert(AlertType.ERROR);
			    alert.setTitle("Error");
			    alert.setContentText("Please add all the information");
			    alert.showAndWait();

			}
			else {

				BookRecords bookObj =new BookRecords(Integer.parseInt(idTf.getText()),titleTf.getText(),authorTf.getText(),categoryTf.getText(),
						Integer.parseInt(publishTf.getText()),isbnTf.getText());
				BookRecords.bookList.add(bookObj);
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("SUCCESS!");
				alert.setContentText("The book added successfully");
				alert.showAndWait();

				idTf.clear();
				authorTf.clear();
				titleTf.clear();
				categoryTf.clear();
				publishTf.clear();
				isbnTf.clear();	
			}
		});
		
		HBox hb1 =new HBox(30);
		Button tv =new Button("Table View");
		tv.setStyle("-fx-background-color: #E65A1D; -fx-text-fill: white; -fx-font-size: 14px; -fx-padding: 10px 20px; -fx-border-radius: 5px; -fx-background-radius: 5px;");

		hb1.getChildren().addAll(back,add,tv);
		
	
		
		vb.getChildren().addAll(img,hb1);

		HBox hb =new HBox(300);
		hb.setPadding(new Insets(50,50,50,50));
		hb.getChildren().addAll(vb,vb1);
		hb.setStyle("-fx-background-color: #F8EED9;");

		Scene scene =new Scene(hb,1100,700);
		primaryStage.setScene(scene);		
		primaryStage.setFullScreen(true);
		primaryStage.show();
		
		tv.setOnAction(a ->{
			Scene scenee =new Scene(new BookTableView(primaryStage,scene),1100,700);

		});
	}
	//	 Alert alert = new Alert(AlertType.ERROR);
//	    alert.setTitle("Error");
//	    alert.setHeaderText(null);
//	    alert.setContentText("Please add a photo for the employee.");
//	    alert.showAndWait();
	

}
