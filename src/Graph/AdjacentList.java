package Graph;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/*
    Consider a set of four-letter words. Two four-letter words are said to be adjacent if they
    differ in only one position. So, for example, lame is adjacent to same, lime, late and lamb
    among others.

    You are provided with a list of 1024 common four-letter words
    (on the website). Build the adjacency list representation of the graph and then answer
    the following questions based on it.
    • How many edges are there?
    • What are all the neighbors of word?
 */


public class AdjacentList {
    static HashMap<String,Integer> word_map = new HashMap<>();
    static ArrayList<ArrayList<String>> list = new ArrayList<>(1024);
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> wordList = new ArrayList<>(1024);
        Scanner input = new Scanner(new File("src/Graph/word.txt"));
        int index = 0, edges = 0;
        while (input.hasNext()){
            String word = input.next();
            wordList.add(word);
            word_map.put(word,index++);
            list.add(new ArrayList<>());
        }

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
                    edges++;
                }
            }
        }

        System.out.println("No. of edges: "+edges/2);
        System.out.println(getAllNeighbours("word"));
    }
    public static ArrayList<String> getAllNeighbours(String word){
        return list.get(word_map.get(word));
    }
}

