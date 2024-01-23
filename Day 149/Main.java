//{ Driver Code Starts
//Initial template for JAVA

import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            String st[] = read.readLine().trim().split("\\s+");
            int n = Integer.parseInt(st[0]);
            int m = Integer.parseInt(st[1]);

            for (int i = 0; i < n; i++)
                list.add(i, new ArrayList<Integer>());

            ArrayList<ArrayList<Integer>> prerequisites = new ArrayList<>();
            for (int i = 1; i <= m; i++) {
                String s[] = read.readLine().trim().split("\\s+");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                list.get(v).add(u);
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(u);
                pair.add(v);
                prerequisites.add(pair);
            }

            int[] res = new Solution().findOrder(n, m, prerequisites);
            
            if(res.length==0)
                System.out.println("No Ordering Possible");
            else
            {
                if (check(list, n, res) == true)
                    System.out.println("1");
                else
                    System.out.println("0");
            }
        }
    }
    static boolean check(ArrayList<ArrayList<Integer>> list, int V, int[] res) {
        int[] map = new int[V];
        for (int i = 0; i < V; i++) {
            map[res[i]] = i;
        }
        for (int i = 0; i < V; i++) {
            for (int v : list.get(i)) {
                if (map[i] > map[v]) return false;
            }
        }
        return true;
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int[] findOrder(int n, int m, ArrayList<ArrayList<Integer>> prerequisites) 
    {
        // Create an array to store the in-degrees of each task
        int[] inDegrees = new int[n];
        
        // Create an adjacency list to represent the graph
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        // Populate the in-degrees and adjacency list based on prerequisites
        for (ArrayList<Integer> prerequisite : prerequisites) {
            int task = prerequisite.get(0);
            int prerequisiteTask = prerequisite.get(1);
            
            inDegrees[task]++;
            graph.get(prerequisiteTask).add(task);
        }
        
        // Use a queue to perform a topological sort
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegrees[i] == 0) {
                queue.add(i);
            }
        }
        
        // Perform topological sort
        int[] result = new int[n];
        int index = 0;
        while (!queue.isEmpty()) {
            int currentTask = queue.poll();
            result[index++] = currentTask;
            
            for (int neighbor : graph.get(currentTask)) {
                inDegrees[neighbor]--;
                if (inDegrees[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }
        
        // Check if all tasks were included in the result
        if (index == n) {
            return result;
        } else {
            return new int[0]; // Return empty array if it's impossible to finish all tasks
        }
    }
}
