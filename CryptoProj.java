package datastructures2018;

import java.io.PrintWriter;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class DigitalEncrypt_Decrypt extends Application {
	public static int size = 2048;
	public static int blockS = 64;
	public static int profile;
	public static Integer[] randProfile = new Integer[blockS];
	public static Integer[] encProfile = new Integer[blockS];
	public static Integer[] decProfile = new Integer[blockS];
	public static ArrayList<Integer[]> encBlock = new ArrayList<Integer[]>();
	public static ArrayList<Integer[]> tempEnc = new ArrayList<Integer[]>();
	public static ArrayList<Integer[]> tempDec = new ArrayList<Integer[]>();
	public static Integer[] IV = new Integer[blockS];
	public static Integer[] key = new Integer[128];

	@SuppressWarnings("rawtypes")
	@Override
	public void start(Stage primaryStage) throws java.io.IOException {
		Integer[] code = new Integer[size];
		PrintWriter output = new PrintWriter(
				"C:\\Users\\EddyJ\\OneDrive\\Documents\\2018\\Intro to Ethics_Cyber Security\\String.txt");
		// Create random 2048 bits and input into
		// file-------------------------------------------------------------
		for (int i = 0; i < size; i++) {
			code[i] = (int) (Math.random() * 2);
			output.print(code[i]);
			if ((i + 1) % 64 == 0) {
				output.println();
			}
		}
		output.close();

		// **CREATE RANDOM IV && KEY---------------------------------------------------
		for (int i = 0; i < blockS; i++) {
			IV[i] = (int) (Math.random() * 2);
		}
		for (int i = 0; i < 128; i++) {
			key[i] = (int) (Math.random() * 2);
		}

		// input random bits into
		// ArrayList----------------------------------------------

		ArrayList<Integer[]> plainBlock = new ArrayList<Integer[]>();
		int n = 0;
		for (int i = 0; i < 32; i++) {
			Integer[] temp = new Integer[blockS];
			for (int j = 0; j < blockS; j++) {
				temp[j] = code[n];
				n++;
			}
			plainBlock.add(temp);
		}
		ArrayList<Integer[]> tempBlock = new ArrayList<Integer[]>(plainBlock);
		ArrayList<Integer[]> tempB2 = new ArrayList<Integer[]>(plainBlock);

		// Start GUI ------------------------------------------------------------------

		HBox Graphs = new HBox();
		BorderPane pane = new BorderPane();
		Button encrypt = new Button("Encrypt");
		Button Decrypt = new Button("Decrypt");
		Button encData = new Button("Encrypted Data");
		Button decrData = new Button("Decrypted Data");
		Button readData = new Button("Read Data from File");

		// Center pane--------------------------------------------------------------
		BorderPane encDec = new BorderPane();
		BorderPane.setAlignment(encDec, Pos.BOTTOM_CENTER);
		encDec.setStyle("-fx-border-color: gray;" + "-fx-padding: 10;" + "-fx-border-width: 10;"
				+ "-fx-border-style: solid inside;");
		encDec.setMaxWidth(500);
		encDec.setMaxHeight(400);

		Text disc = new Text(
				" The encoder/decoder takes a binary string of 64-bits and maps each\n bit in the string into a unique 8-bits "
						+ "decimal value. The encoding technique \nis based on a randomly generated user’s profile. Our progrom "
						+ "encrypts 2048\n bits and displays the encryption of a random 64 bit value.\n A user’s profile is "
						+ "established\n ");

		BorderPane.setAlignment(disc, Pos.BOTTOM_CENTER);
		BorderPane.setMargin(encrypt, new Insets(12, 12, 12, 12));
		BorderPane.setAlignment(encrypt, Pos.BOTTOM_LEFT);
		encDec.setLeft(encrypt);
		BorderPane.setMargin(encrypt, new Insets(30, 30, 30, 60));
		BorderPane.setAlignment(Decrypt, Pos.BOTTOM_RIGHT);
		BorderPane.setMargin(Decrypt, new Insets(30, 60, 30, 30));
		encDec.setRight(Decrypt);
		encDec.setTop(disc);
		pane.setCenter(encDec);

		// Create and input graphs
		// ------------------------------------------------------
		NumberAxis xAxisP = new NumberAxis(0, 64, 0);
		NumberAxis yAxisP = new NumberAxis(-255, 255, 0);
		NumberAxis xAxisE = new NumberAxis(0, 64, 0);
		NumberAxis yAxisE = new NumberAxis(-255, 255, 0);
		NumberAxis xAxisD = new NumberAxis(0, 64, 0);
		NumberAxis yAxisD = new NumberAxis(-255, 255, 0);

		LineChart<Number, Number> plainChart = new LineChart<Number, Number>(xAxisP, yAxisP);
		LineChart<Number, Number> encryptChart = new LineChart<Number, Number>(xAxisE, yAxisE);
		LineChart<Number, Number> decryptChart = new LineChart<Number, Number>(xAxisD, yAxisD);

		plainChart.setTitle("PlainText");
		encryptChart.setTitle("Plain / Encrypted Data");
		decryptChart.setTitle("Decrypted Data");
		XYChart.Series plainLine = new XYChart.Series<>();
		XYChart.Series encLine = new XYChart.Series<>();
		XYChart.Series decLine = new XYChart.Series<>();

		Graphs.getChildren().addAll(plainChart, encryptChart, decryptChart);

		pane.setBottom(Graphs);

		// Get random block!!!!---------------------------------------------------------
		Button getProfile = new Button("Get random Profile[i]");
		BorderPane.setAlignment(getProfile, Pos.CENTER_LEFT);
		getProfile.setPrefWidth(400);
		encDec.setCenter(getProfile);
		getProfile.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				profile = (int) (Math.random() * 32);
				Text prof = new Text("Random profile[i]: " + Integer.toString(profile));
				BorderPane.setAlignment(prof, Pos.BOTTOM_LEFT);
				encDec.setBottom(prof);
				plainChart.getData().clear();
				encryptChart.getData().clear();
				decryptChart.getData().clear();
			}
		});

		// Read File and display left on pane-------------------------------------
		BorderPane leftP = new BorderPane();
		randProfile = plainBlock.get(profile);
		Text title = new Text("Digital Signal Encryption/Decryption System");
		Text[] bits = new Text[65];
		bits[0] = new Text("Index                   Value");
		for (int i = 1; i < 65; i++) {
			if (i < 10)
				bits[i] = new Text(i + "                           " + Integer.toString(randProfile[i - 1]));
			else
				bits[i] = new Text(i + "                         " + Integer.toString(randProfile[i - 1]));
		}

		ListView<Text> blockT = new ListView<>(FXCollections.observableArrayList(bits));
		blockT.setPrefWidth(200);
		// Shows Index and Value && button--------------------------------------
		BorderPane.setAlignment(readData, Pos.BOTTOM_CENTER);
		leftP.setCenter(readData);
		leftP.setBottom(new ScrollPane(blockT));
		pane.setLeft(leftP);

		// EVENT HANDLER read plaintext --------------------------------------------
		readData.setOnAction(new EventHandler<ActionEvent>() {
			@SuppressWarnings({ "unchecked" })
			@Override
			public void handle(ActionEvent e) {
				plainChart.getData().clear();
				randProfile = plainBlock.get(profile);
				for (int i = 1; i < 65; i++) {
					if (i < 10)
						bits[i].setText(i + "                           " + Integer.toString(randProfile[i - 1]));
					else
						bits[i].setText(i + "                         " + Integer.toString(randProfile[i - 1]));
				}
				Integer[] pData = getSignal(randProfile);
				for (int j = 0; j < blockS; j++) {
					plainLine.getData().add(new XYChart.Data(j, pData[j]));
				}
				plainChart.getData().add(plainLine);
			}
		});
		// Encrypted data BIT scroll list and
		// button----------------------------------------------
		BorderPane rightP = new BorderPane();
		Text[] encBits = new Text[65];

		encBits[0] = new Text("Index                   Value");
		for (int i = 1; i < 65; i++) {
			if (i < 10)
				encBits[i] = new Text(i + "                           " + Integer.toString(randProfile[i - 1]));
			else
				encBits[i] = new Text(i + "                         " + Integer.toString(randProfile[i - 1]));
		}

		BorderPane.setAlignment(encData, Pos.BOTTOM_RIGHT);
		rightP.setLeft(encData);
		BorderPane.setAlignment(decrData, Pos.BOTTOM_LEFT);
		rightP.setRight(decrData);
		pane.setRight(rightP);

		ListView<Text> encrBlock = new ListView<>(FXCollections.observableArrayList(encBits));
		encrBlock.setPrefWidth(200);
		rightP.setBottom(encrBlock);

		// Encryption Event Handler/ BUTTON---&&---------------------
		XYChart.Series tempLine = plainLine;

		encrypt.setOnAction(new EventHandler<ActionEvent>() {
			@SuppressWarnings({ "unchecked" })
			@Override
			public void handle(ActionEvent e) {
				tempEnc = encrypt(tempBlock);
				encProfile = tempEnc.get(profile);

				encBits[0] = new Text("Index                   Value");
				for (int i = 1; i < 65; i++) {
					if (i < 10)
						encBits[i].setText(i + "                           " + Integer.toString(encProfile[i - 1]));
					else
						encBits[i].setText(i + "                         " + Integer.toString(encProfile[i - 1]));
				}
				Integer[] eData = getSignal(encProfile);
				for (int j = 0; j < blockS; j++) {
					encLine.getData().add(new XYChart.Data(j, eData[j]));
				}
				encryptChart.getData().addAll(tempLine, encLine);
			}
		});
		
		//ENCRYPTED DATA VIEW BUTTON------------------------------------
		encData.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {

				encBits[0] = new Text("Index                   Value");
				for (int i = 1; i < 65; i++) {
					if (i < 10)
						encBits[i].setText(i + "                           " + Integer.toString(encProfile[i - 1]));
					else
						encBits[i].setText(i + "                         " + Integer.toString(encProfile[i - 1]));
				}

			}
		});
		// Decrypted BIT list- view---------------------------------------------
		Text[] decBits = new Text[65];

		decBits[0] = new Text("Index                   Value");
		for (int i = 1; i < 65; i++) {
			if (i < 10)
				decBits[i] = new Text(i + "                           " + Integer.toString(randProfile[i - 1]));
			else
				decBits[i] = new Text(i + "                         " + Integer.toString(randProfile[i - 1]));
		}

		ArrayList<Integer[]> decBlock = new ArrayList<Integer[]>(encrypt(tempB2));
		
		//DECRYPTION BUTTON----------------------------------------------------
		Decrypt.setOnAction(new EventHandler<ActionEvent>() {
			@SuppressWarnings({ "unchecked" })
			@Override
			public void handle(ActionEvent e) {
				tempDec = decrypt(decBlock);

				decProfile = tempDec.get(profile);
				encBits[0] = new Text("Index                   Value");
				for (int i = 1; i < 65; i++) {
					if (i < 10)
						encBits[i].setText(i + "                           " + Integer.toString(decProfile[i - 1]));
					else
						encBits[i].setText(i + "                         " + Integer.toString(decProfile[i - 1]));
				}
				Integer[] dData = getSignal(decProfile);
				for (int j = 0; j < blockS; j++) {
					decLine.getData().add(new XYChart.Data(j, dData[j]));
				}
				decryptChart.getData().addAll(tempLine, decLine);
			}
		});
		
		//DECRYPT DATA VIEW BUTTON--------------------------------------------
		decrData.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {

				encBits[0] = new Text("Index                   Value");
				for (int i = 1; i < 65; i++) {
					if (i < 10)
						encBits[i].setText(i + "                           " + Integer.toString(decProfile[i - 1]));
					else
						encBits[i].setText(i + "                         " + Integer.toString(decProfile[i - 1]));
				}

			}
		});

		// Title + STAGE------------------------------------------------------------------
		title.setTextAlignment(TextAlignment.CENTER);
		title.setFont(Font.font(36));
		BorderPane.setAlignment(title, Pos.CENTER);
		pane.setTop(title);

		Scene scene = new Scene(pane, 1000, 700);
		primaryStage.setTitle("Digital Signal Encryption/Decryption System Demonstration");
		primaryStage.setScene(scene);
		primaryStage.show();

	}
	//LAUNCH GUI-----------------------------------------------------
	public static void main(String[] args) {
		launch(args);
	}

	// ENCRYPT---------------------------------------------------------------------
	public static ArrayList<Integer[]> encrypt(ArrayList<Integer[]> list) {
		Integer[] shiftedK = key;
		Integer[] newIV = IV;
		ArrayList<Integer[]> encList = new ArrayList<Integer[]>();

		// TEA--------- Run EX0r through IV and 128 bit Key-------------------------
		for (int i = 0; i < list.size(); i++) {
			Integer[] temp = list.get(i);
			for (int j = 0; j < blockS; j++) {
				temp[j] = temp[j] ^ newIV[j];
				temp[j] = temp[j] ^ shiftedK[j];
			}
			encList.add(temp);
			// +ADD+ i TO IV--------------------------------------
			String n = Integer.toBinaryString(i);
			for (int k = 1, s = 0; s < n.length(); s++) {
				newIV[blockS - k] = newIV[blockS - k] ^ n.charAt((n.length() - 1) - s);
				k++;
			}
			// SHIFT KEY TO THE LEFT EVERY BLOCK---------------------------
			for (int p = 0; p < 5; p++) {
				for (int t = 0; t > 127; t++) {
					shiftedK[t] = shiftedK[t - 1];
					shiftedK[0] = shiftedK[shiftedK.length - 1];
				}
			}
		}
		return encList;
	}

	// DECRYPT-------------------------------------------------
	public static ArrayList<Integer[]> decrypt(ArrayList<Integer[]> list) {
		Integer[] shiftedK = key;
		Integer[] newIV = IV;
		ArrayList<Integer[]> decList = new ArrayList<Integer[]>();
		Integer[] c = new Integer[blockS];

		// TEA--------- Run EX0r through IV and 128 bit Key-------------------------
		for (int i = 0; i < list.size(); i++) {
			Integer[] temp = list.get(i);
			for (int j = 0; j < blockS; j++) {
				temp[j] = temp[j] ^ newIV[j];
				temp[j] = temp[j] ^ shiftedK[j];
			}
			decList.add(temp);

			// +ADD+ i TO IV--------------------------------------
			String n = Integer.toBinaryString(i);
			for (int k = 1, s = 0; s < n.length(); s++) {
				newIV[blockS - k] = newIV[blockS - k] ^ n.charAt((n.length() - 1) - s);
				k++;
			}
			// SHIFT KEY TO THE RIGHT EVERY BLOCK---------------------------
			for (int p = 0; p < 5; p++) {
				for (int t = 0; t > 127; t++) {
					shiftedK[t] = shiftedK[t - 1];
					shiftedK[0] = shiftedK[shiftedK.length - 1];
				}
			}
		}
		return decList;
	}

	// GET SIGNAL FROM BITS---------------------------------------------------------
	public static Integer[] getSignal(Integer[] list) {
		Integer profile[] = { 210, 64, 3, 44, 105, 31, 255, 155, 80, 211, 9, 41, 181, 100, 144, 210, 56, 5, 62, 250,
				168, 78, 198, 29, 158, 117, 83, 183, 254, 100, 55, 15, 22, 236, 145, 159, 119, 225, 39, 252, 152, 199,
				93, 8, 169, 116, 2, 100, 82, 200, 247, 90, 105, 137, 59, 87, 125, 13, 95, 150, 157, 4, 247, 140 };
		Integer[] currL = list;
		for (int i = 0; i < list.length; i++) {
			if (currL[i] == 0)
				profile[i] = -1 * profile[i];
		}
		return profile;
	}

	// PRINT AN ARRAYLIST IF
	// NEEDED---------------------------------------------------------
	public static void print(ArrayList<Integer[]> list) {
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.get(i).length; j++) {
				System.out.print(list.get(i)[j]);

			}
			System.out.println();
		}
	}
}
