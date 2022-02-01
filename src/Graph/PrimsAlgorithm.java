package Graph;

import java.util.ArrayList;
import java.util.Arrays;

/*
    Time complexity is O(n^2)
 */
public class PrimsAlgorithm {
    public static void main(String[] args) {
        int[][] graph = {   {0,4,6,0,0,0},
                            {4,0,6,3,4,0},
                            {6,6,0,1,8,0},
                            {0,3,1,0,2,3},
                            {0,4,8,2,0,7},
                            {0,0,0,3,7,0}};

        findMST(graph);
    }

    private static void findMST(int[][] graph) {
        int n = graph[0].length;
        int[] parent = new int[n];
        int[] value = new int[n];
        Arrays.fill(value,Integer.MAX_VALUE);
        boolean[] mstSet = new boolean[n];
        
        // Assuming start point as node 0
        parent[0] = -1;
        value[0] = 0;
        
        // Create MST with (V-1) edges
        for (int i = 0; i < n; i++) {
            int U = selectMinVertex(value,mstSet);
            mstSet[U] = true;

            // scan through all the vertices in order to find adjacent vertices
            for (int j = 0; j < n; j++) {
                /*
                    3 constraints:
                     1. Edge is present from U to j
                     2. Vertex j os not included in MST
                     3. Edge weight is smaller than current edge weight

                 */
                if (graph[U][j]!=0 && !mstSet[j] && graph[U][j]<value[j]){
                    value[j]=graph[U][j];
                    parent[j]=U;
                }
            }
        }
        for (int i = 1; i < n; i++) {
            System.out.println("U->V: "+parent[i]+"->"+i+" wt = "+graph[parent[i]][i]);
        }
    }

    private static int selectMinVertex(int[] value, boolean[] mstSet) {
        int minimum = Integer.MAX_VALUE;
        int vertex = -1;
        for (int i = 0; i < value.length; i++) {
            if (!mstSet[i] && value[i]<minimum){
                vertex = i;
                minimum = value[i];
            }
        }
        return vertex;
    }
}
