package datastructures2018;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Exc22_19LargestBlock extends Application {
	public static final int size = 10;

	@Override
	public void start(Stage primaryStage) {

		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		Button ref = new Button("Refresh");
		Button find = new Button("Find Largest Block");

		TextField[][] n = new TextField[size][size];
		int[][] list = new int[10][10];
		for (int i = 0; i < list.length; i++) {
			for (int j = 0; j < list[i].length; j++) {
				list[i][j] = (int) (Math.random() * 2);
				pane.add(n[i][j] = new TextField(), j, i);
				n[i][j].setPrefWidth(30);
				n[i][j].setText(String.valueOf(list[i][j]));
				n[i][j].setStyle("-fx-background-color: white");
			}
		}

		pane.add(ref, 1, 10, 5, 10);
		pane.add(find, 4, 10, 5, 10);

		ref.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				for (int i = 0; i < list.length; i++) {
					for (int j = 0; j < list[i].length; j++) {
						list[i][j] = (int) (Math.random() * 2);
						n[i][j].setText(String.valueOf(list[i][j]));
						n[i][j].setStyle("-fx-background-color: white");
					}
				}
			}
		});

		find.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				int[][] data = new int[size][size];
				for (int i = 0; i < size; i++) {
					for (int j = 0; j < size; j++) {
						n[i][j].setStyle("-fx-background-color: white");
						data[i][j] = Integer.parseInt(n[i][j].getText());

					}
				}

				int[] result = findBlock(data);
				for (int i = result[0]; i < result[0] + result[2]; i++) {
					for (int j = result[1]; j < result[1] + result[2]; j++) {
						n[i][j].setStyle("-fx-background-color: red");
					}
				}
			}
		});

		Scene scene = new Scene(pane);
		primaryStage.setTitle("Largest Block Test");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static int[] findBlock(int[][] list) {

		int[] matrix = new int[3];
		for (int i = 0; i < list.length; i++) {
			for (int j = 0; j < list[i].length; j++) {
				if (list[i][j] == 1) {
					int size = getSquare(i, j, list);
					if (size > matrix[2]) {
						matrix[0] = i;
						matrix[1] = j;
						matrix[2] = size;
					}
				}
			}
		}
		return matrix;
	}

	public static int getSquare(int r, int c, int[][] list) {
		int result = 0;
		for (int i = r; i < list.length; i++) {
			for (int j = c; j < list.length; j++) {
				for (int size = 1; size < list.length; size++) {
					if (!allOnes(r, c, size, list)) {
						if (result < (size - 1)) {
							result = size - 1;
						}
						break;
					}
				}
			}
		}
		return result;
	}

	public static boolean allOnes(int r, int c, int size, int[][] list) {

		for (int i = r; i < r + size; i++) {
			if (i >= list.length) {
				return false;
			}
			for (int j = c; j < c + size; j++) {
				if (j >= list[i].length) {
					return false;
				}
				if (list[i][j] != 1) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
