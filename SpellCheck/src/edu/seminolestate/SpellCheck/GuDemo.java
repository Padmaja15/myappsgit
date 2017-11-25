package edu.seminolestate.SpellCheck;

/*
* Author: P Parise
* Date: 11/24/2017
*/
import java.io.File;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;

public class GuDemo extends Application {
	private static DictionaryProcessor dictionary = new DictionaryProcessor();

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) {

		Label dicName = new Label("Enter the Dictionary file name");
		TextField txtDictName = new TextField();
		Label spellFile = new Label("Enter Spell checking file");
		TextField txtSpellcheckFile = new TextField();
		TextField txtError = new TextField();
		TextField txtDisplay = new TextField();

		FlowPane pane = new FlowPane();

		pane.setPadding(new Insets(15));
		pane.setVgap(15);
		pane.setHgap(15);

		pane.getChildren().add(dicName);
		pane.getChildren().add(txtDictName);
		pane.getChildren().add(spellFile);
		pane.getChildren().add(txtSpellcheckFile);
		Scene scene = new Scene(pane, 400, 500);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Spell Checking User Interface");
		primaryStage.show();

		Button btnSpellCheck = new Button("Spell Check");
		pane.getChildren().add(btnSpellCheck);

		Button btnExit = new Button("EXIT");
		pane.getChildren().add(btnExit);
		btnSpellCheck.setOnAction(new javafx.event.EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {

				if (!txtDictName.getText().isEmpty() && !txtSpellcheckFile.getText().isEmpty()) {
					File filea = new File(txtDictName.getText());
					File fileb = new File(txtSpellcheckFile.getText());
					if ((filea.exists()) || (fileb.exists())) {

						dictionary.readFiles(txtDictName.getText(), txtSpellcheckFile.getText());
						ObservableList<String> items = FXCollections.observableArrayList(dictionary.getUnknownWords());
						ListView<String> list = new ListView<String>();
						list.setOrientation(Orientation.VERTICAL);
						list.setPrefSize(150, 220);
						list.setItems(items);
						txtDisplay.setText("List of Unknown words");
						pane.getChildren().add(txtDisplay);
						pane.getChildren().add(list);

					} else {
						txtError.setText("File(s) doesn't exist !");
						pane.getChildren().add(txtError);

					}

				} else {
					txtError.setText("Proper data not entered!");
					pane.getChildren().add(txtError);

				}
				btnSpellCheck.setDisable(true);
			}

		});

		btnExit.setOnAction(new javafx.event.EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent f) {
				primaryStage.close();
				System.exit(0);
			}
		});
	}

}
