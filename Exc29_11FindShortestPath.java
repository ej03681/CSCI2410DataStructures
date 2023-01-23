package datastructures2018;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exc29_11FindShortestPath {
	public static void main(String[] args) {
        System.out.print("Enter a file name: ");
        Scanner in = new Scanner(System.in);
        String URLString = in.next();
        
		try {
			java.net.URL url = new java.net.URL(URLString);
			Scanner input = new Scanner(url.openStream());

			int nVertices = input.nextInt();
			ArrayList<Integer> vertices = new ArrayList<>();
			for (int i = 0; i < nVertices; i++) {
				vertices.add(i);
			}
			ArrayList<WeightedEdge> edgeList = new ArrayList<>();

			input.nextLine();
			for (int j = 1; j < nVertices; j++) {
				String s = input.nextLine();
				String[] line = s.split("[\\|]");
				for (int i = 0; i < line.length; i++) {
					String[] nums = line[i].split("[,]");
					String edge = nums[0].trim();
					String edge2 = nums[1].trim();
					String w = nums[2].trim();
					
					edgeList.add(
							new WeightedEdge(Integer.parseInt(edge), Integer.parseInt(edge2), Double.parseDouble(w)));
					edgeList.add(
							new WeightedEdge(Integer.parseInt(edge2), Integer.parseInt(edge), Double.parseDouble(w)));
				}
			}

			System.out.print("Enter two vertices: ");
			int vert1 = in.nextInt();
			int vert2 = in.nextInt();
			
			WeightedGraph<Integer> graph = new WeightedGraph<>(vertices,  edgeList);

			System.out.println("The number of vertices is " + graph.getSize());
			graph.printWeightedEdges();
			System.out.print("A path from " + vert1 + " to " + vert2 + ": ");
			WeightedGraph<Integer>.ShortestPathTree tree = graph.getShortestPath(graph.getIndex(vert2));
			List<Integer> path = tree.getPath(graph.getIndex(vert1));
			for(Integer s: path) {
				System.out.print(s + " ");
			}
			input.close();

		} catch (java.net.MalformedURLException ex) {
			System.out.println("Invalid URL");
		} catch (java.io.IOException ex) {
			System.out.println("IO Errors");
		}
	}
}