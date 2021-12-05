package Graph;

// Given an undirected graph, print all connected components line by line.

import java.util.ArrayList;

public class Graph_Connected_Components{
    static ArrayList<ArrayList<Integer>> adjListArray = new ArrayList<>();
    static int n = 8;  // no. of vertices
    public static void main(String[] args) {

        for (int i = 0; i < n; i++) {
            adjListArray.add(i,new ArrayList<>());
        }

        // edges created for graph with vertices 0,1,2,3,4
        addEdge(0,1);
        addEdge(1,2);
        addEdge(3,4);
        addEdge(5,6);
        addEdge(6,7);

        connectedComponents();
    }

    private static void connectedComponents() {
        // traverse to all vertices
        boolean[] visited = new boolean[n];
        for (int v = 0; v < n; v++) {
            if (!visited[v]){
                DFSUtil(v,visited);
                System.out.println();
            }
        }
    }

    // Utilize DFS to traverse the graph and recursively call itself till the child nodes are found
    private static void DFSUtil(int i, boolean[] visited) {
        visited[i] = true;
        System.out.print(i+" ");

        for (int x:adjListArray.get(i)){
            if (!visited[x]){
                DFSUtil(x,visited);
            }
        }
    }

    private static void addEdge(int src, int dest) {
        adjListArray.get(src).add(dest);
        // Since graph is undirected, add an edge from dest
        // to src also
        adjListArray.get(dest).add(src);
    }
}
