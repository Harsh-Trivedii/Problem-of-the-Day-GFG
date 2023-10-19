//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for(int i = 0; i < V+1; i++)
                list.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
                list.get(v).add(u);
            }
            int X = sc.nextInt();
            
            Solution ob = new Solution();
            
            System.out.println(ob.nodeLevel(V,list,X));
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution
{
    //Function to find the level of node X.
    int nodeLevel(int V, ArrayList<ArrayList<Integer>> adj, int X)
    {
        // code here
        boolean[] visited = new boolean[V];

        // Create a queue for BFS.
        Queue<Integer> queue = new LinkedList<>();

        // Initialize the level to 0 for the starting node.
        int level = 0;

        // Start from node 0 and mark it as visited.
        queue.add(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();

            // Process all nodes at the current level.
            for (int i = 0; i < size; i++) {
                int current = queue.poll();

                // If the current node is the target node X, return the level.
                if (current == X) {
                    return level;
                }

                // Visit all adjacent nodes of the current node.
                for (int neighbor : adj.get(current)) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        queue.add(neighbor);
                    }
                }
            }

            // Increment the level for the next level of nodes.
            level++;
        }

        // If the target node X is not found, return -1.
        return -1;
    }
}
