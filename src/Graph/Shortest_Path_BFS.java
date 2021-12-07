package Graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Shortest_Path_BFS {
    // maps strings to integer value
    static HashMap<String,Integer> word_map = new HashMap<>();
    // maps integer to string value
    static HashMap<Integer,String> int_to_Word = new HashMap<>();
    // number of vertices
    static int n = 1024;
    // list representation of graph
    static ArrayList<ArrayList<String>> list = new ArrayList<>(n);
    public static void main(String[] args) throws FileNotFoundException {
        // stores all the words from the input file
        ArrayList<String> wordList = new ArrayList<>(n);
        Scanner input = new Scanner(new File("src/Graph/word.txt"));

        int index1 = 0,index2 = 0;

        // reads all words from the given file
        while (input.hasNext()){
            String word = input.next();
            wordList.add(word);
            word_map.put(word,index1++);
            int_to_Word.put(index2++,word);
            list.add(new ArrayList<>());
        }

        // create edges and make list representation of graph
        for (String word1 : wordList){
            for(String word2: wordList){
                int count=0;
                if(!word1.equals(word2)){
                    for (int i = 0; i < 4; i++) {
                        if(word1.charAt(i)==word2.charAt(i)) count++;
                    }
                }
                if (count==3){
                    int word_index = word_map.get(word1);
                    list.get(word_index).add(word2);
                }
            }
        }
        printShortestDistance(word_map.get("root"),word_map.get("tree"));
        printShortestDistance(word_map.get("frog"),word_map.get("toad"));
        printShortestDistance(word_map.get("foal"),word_map.get("pony"));
    }

    // prints the shortest distance with all the vertex along the path
    private static void printShortestDistance(int source, int dest) {
        // array to store immediate predecessor of a vertex while traversing from source to destination
        int[] predecessor = new int[n];
        // array to store distance between the source and the vertex
        int[] dist = new int[n];

        // checks if the source and destination are connected
        // Also, predecessor array and dist array are filled with the values
        if (!BFS(source,dest,predecessor,dist)){
            System.out.println("Given source and destination are not connected");
            return;
        }

        // path to store all the predecessor
        LinkedList<Integer> path = new LinkedList<>();
        int crawl = dest;
        path.add(crawl);
        // crawl back to source from the destination using predecessor array
        while (predecessor[crawl] != -1){
            path.add(predecessor[crawl]);
            crawl=predecessor[crawl];
        }

        // prints out the shortest distance
        //System.out.println("Shortest length to reach the destination: "+dist[dest]);

        System.out.println("Shortest path from "+int_to_Word.get(source)+" to "+int_to_Word.get(dest)+ " is:");
        // prints out all the vertex from source to destination
        for (int i = path.size()-1; i >0 ; i--) {
            System.out.print(int_to_Word.get(path.get(i)) + " --> ");
        }
        System.out.println(int_to_Word.get(path.get(0)));
    }

    // Method to carry out Breadth First Search
    private static boolean BFS(int source, int dest, int[] predecessor, int[] distance) {
        LinkedList<Integer> queue = new LinkedList<Integer>();

        // visited array where all elements are initialized as false by default
        boolean[] visited = new boolean[n];

        // set the distance from source to all vertex to max integer value
        // set the predecessor of each vertex to -1 while traversing from source to destination
        for (int i = 0; i < n; i++) {
            distance[i] = Integer.MAX_VALUE;
            predecessor[i]=-1;
        }

        // set visited of source vertex to true
        // set distance from source to source as 0
        // added source vertex to the queue
        visited[source] = true;
        distance[source] = 0;
        queue.add(source);

        // Traverse the graph until the queue is empty or the destination is found
        // returns the boolean value to the method
        while (!queue.isEmpty()){
            // take out a vertex from the queue
            int u = queue.remove();
            // go to all vertex that is linked to the given vertex
            for (int i = 0; i < list.get(u).size(); i++) {
                // get the index of the string obtained from graph as the graph is of strings
                int string_index = word_map.get(list.get(u).get(i));
                // check if the vertex is visited or not
                if (!visited[string_index]){
                    // set the visited of vertex to true
                    // set the distance of the neighbours to distance of u + 1 , which is the shortest by default
                    // set the predecessor of all the neighbours as the current vertex
                    // add all the neighbours to the queue
                    visited[string_index]=true;
                    distance[string_index] = distance[u]+1;
                    predecessor[string_index] = u;
                    queue.add(string_index);

                    // returns if the destination is found
                    if (string_index == dest){
                        return true;
                    }
                }
            }
        }
        // returns false if the source and destination are not found connected
        return false;
    }
}
