package controller;

import java.io.IOException;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Book;
public class App extends Application {

	  @FXML
	  private TextField isbnfield;
	  @FXML
	  private TextField titlefield;
	  @FXML
	  private TextField authorfield;
	  @FXML
	  private TextField isbnSearchField;
	  @FXML
	  private Button SearchButton;
	  @FXML
	  private Text titleText;
	  @FXML
	  private Text authortext;
	  @FXML
	  private Text isAvailabletext;
	  
	  private BookDAO dbDAO = new BookDAO();
	  
	@Override
	public void start(Stage arg0) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("gui.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 640, 480);
        arg0.setTitle("Library Manager");
        arg0.setScene(scene);
        arg0.show();
	}
	
	public static void main(String[] args) throws SQLException {
		Database db = new Database();
		db.initDB();
		launch(args);
    }
	
	@FXML
    private void handleSwitchToAdd(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/controller/addBook.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
	@FXML
	private void handleSwitchToHome(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/controller/gui.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
	
	@FXML
	private void handleAddBook() {
		Book newBook = new Book(isbnfield.getText(), titlefield.getText(), authorfield.getText(), true);
		dbDAO.addBookDB(newBook);
		System.out.println(dbDAO.getLatestBook().getTitle()); 
	}
	
	@FXML
	private void handleSearchBook() {
		Book SearchedBook = dbDAO.searchByISBN(isbnSearchField.getText());
		titleText.setText(SearchedBook.getTitle());
		authortext.setText(SearchedBook.getAuthor());
		isAvailabletext.setText(String.valueOf(SearchedBook.isAvailable()));
		System.out.println(SearchedBook.getTitle());
	}

}
