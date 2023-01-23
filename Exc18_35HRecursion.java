package datastructures2018;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 *
 * @author EddyJ
 */
public class Exc18_35HRecursion extends Application {
    @Override
    public void start(Stage primaryStage){
        Hpane pane = new Hpane();
    	
        TextField tfOrder = new TextField();
        tfOrder.setOnAction(
        		e -> pane.setOrder(Integer.parseInt(tfOrder.getText())));
        tfOrder.setPrefColumnCount(4);
        tfOrder.setAlignment(Pos.BOTTOM_RIGHT);
        
        HBox  hBox = new HBox(10);
        hBox.getChildren().addAll(new Label("Enter an order: "), tfOrder);
        hBox.setAlignment(Pos.CENTER);
        
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(pane);
        borderPane.setBottom(hBox);
        
        Scene scene = new Scene(borderPane, 200, 210);
        primaryStage.setTitle("H tree");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        scene.widthProperty().addListener(ov -> pane.paint());
        scene.heightProperty().addListener(ov -> pane.paint());
        
    	
    }
    static class Hpane extends Pane {
    	private int order = 0; 
    	double sizer;
    		double w;
    		double h;
    		
    	public void setOrder(int order){
    		this.order = order;
    		paint();
    	}
    	Hpane(){
    		w = 600;
    		h = 600;
    		sizer = Math.min(w, h) * .4;
    		setMinSize(w,h);
    		paint();
    	}
    	public void paint(){
    		
    		getChildren().clear();
            double x = w * 0.30;
            double y = h * 0.70;
            displayH(x, y, order, sizer);
    	}
    
    public void displayH(double x, double y, int order, double sizer){
    		Line line1 = new Line(x, y, x, y - sizer);
            Line line2 = new Line(x + sizer, y, x + sizer, y - sizer);
            Line line3 = new Line(x, y - (sizer / 2), x + sizer, y - (sizer / 2));
            getChildren().addAll(line1, line2, line3);
            
           if (order > 0){
    		double half = sizer / 2;
    		double small = half / 2;
    		
    		displayH(line1.getStartX() - small, line1.getEndY() + half / 2, order - 1, half);
    		displayH(line2.getStartX() - small, line1.getEndY() + half / 2, order - 1, half);

    		displayH(line1.getEndX() - small, line1.getStartY() + half / 2, order - 1, half);

    		displayH(line2.getEndX() - small, line1.getStartY() + half / 2, order - 1, half);
           }
    	}
    }

public static void main(String[] args){
	Application.launch(args);
}
}
