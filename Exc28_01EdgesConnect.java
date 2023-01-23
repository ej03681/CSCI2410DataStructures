package datastructures2018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Exc28_01EdgesConnect {
	public static void main(String[] args) {

		System.out.print("Enter a file name: ");
		String URLString = new Scanner(System.in).next();

		try {
			java.net.URL url = new java.net.URL(URLString);
			Scanner input = new Scanner(url.openStream());

			int nVertices = input.nextInt();

			ArrayList<Edge> edgeList = new ArrayList<>();

			String[] vertices = new String[nVertices];

			input.nextLine();
			for (int j = 0; j < nVertices; j++) {
				String s = input.nextLine();
				String[] line = s.split("[\\s+]");
				String u = line[0];
				vertices[j] = u;
				
				for (int i = 1; i < line.length; i++) {
					edgeList.add(new Edge(Integer.parseInt(u), Integer.parseInt(line[i])));
	
				}
			}

			Graph<String> graph = new UnweightedGraph<>(Arrays.asList(vertices), edgeList);

			System.out.println("The number of vertices is " + graph.getSize());

			for (int u = 0; u < nVertices; u++) {
				System.out.print("Vertex " + graph.getVertex(u) + ":");
				for (Integer e : graph.getNeighbors(u))
					System.out.print(" (" + u + ", " + e + ")");
				System.out.println();

			}
			UnweightedGraph.SearchTree tree = graph.dfs(0);

			System.out.println(
					"The graph is " + (tree.getNumberOfVerticesFound() != graph.getSize() ? "not " : "") + "connected");
			input.close();
			
		} catch (java.net.MalformedURLException ex) {
			System.out.println("Invalid URL");
		} catch (java.io.IOException ex) {
			System.out.println("IO Errors");
		}
	}
}