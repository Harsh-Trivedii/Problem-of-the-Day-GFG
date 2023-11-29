Problem of the day: Euler circuit and Path

Question link: https://www.geeksforgeeks.org/problems/euler-circuit-and-path/1

Question: An Eulerian Path is a path in graph that visits every edge exactly once and it starts and ends up at different indexes. An Eulerian Circuit is an Eulerian Path which starts and ends on the same vertex. Given an undirected acyclic graph with V nodes, and E edges, with adjacency list adj, return 2 if the graph contains an eulerian circuit, else if the graph contains an eulerian path, return 1, otherwise, return 0.

Expected Time Complexity: O(V+E) where E is the number of edges in graph.
Expected Space Complexity: O(V)

Constraints:
1 ≤ V, E ≤ 104
1 ≤ adj[i][j] ≤ V-1

