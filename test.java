package datastructures2018;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

import javafx.scene.Group;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class test {
	public static void main(String[] args) {
	PriorityQueue<String> que = new PriorityQueue<>();
	que.offer("Oklahoma");
	que.offer("Georgia");
	que.offer("Indiana");
	que.offer("Texas");
	que.offer("Oklahoma");
	
	
	while (que.size() > 0) {
		System.out.print(que.remove() + " ");
	}
	}
}