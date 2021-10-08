/* 
 * Given an undirected graph and a number m, determine if the graph can be coloured with at most m colours such that no two adjacent vertices of the graph are colored with the same color.
 * Here coloring of a graph means the assignment of colors to all vertices.
 *
 * Input:
 *
 * A 2D array graph[V][V] where V is the number of vertices in graph and graph[V][V] is an adjacency matrix representation of the graph. A value graph[i][j] is 1 if there is a direct edge from i to j, otherwise graph[i][j] is 0.
 * An integer m is the maximum number of colors that can be used.
 * Output:
 * An array color[V] that should have numbers from 1 to m. color[i] should represent the color assigned to the ith vertex. The code should also return false if the graph cannot be colored with m colors.
 *
 * Example:
 *
 * Input:
 * graph = {0, 1, 1, 1},
 *         {1, 0, 1, 0},
 *         {1, 1, 0, 1},
 *         {1, 0, 1, 0}
 * Output:
 * Solution Exists:
 * Following are the assigned colors
 *  1  2  3  2
 * Explanation: By coloring the vertices with following colors, adjacent vertices does not have same colors
 *
 * Time Complexity: O(m^V).
 * There is a total O(m^V) combination of colors. So the time complexity is O(m^V).
 * Space Complexity: O(V).
 * Recursive Stack of graphColoring(…) function will require O(V) space.
 *  */

class GFG {

        static final int V = 4; // number of vertices

        private static void printSolution(int[] color) {

                System.out.print("Solution Exists: here are the assigned colors : ");
                for(int i : color) {
                        System.out.print(i + ", ");
                }
        }

        private static boolean isSafe(boolean[][] graph, int[] color) {

                for(int i = 0; i < V; ++i) {

                        for(int j = i + 1; j < V; ++j) {

                                if(graph[i][j] && color[i] == color[j]) {
                                        return false;
                                }
                        }
                }
                return true;
        }

        private static boolean graphColoring(boolean[][] graph, int i, int m, int[] color) {

                // if all the vertices are reached
                if(i == V) {

                        if(isSafe(graph, color)) {

                                printSolution(color);
                                return true;
                        }
                        return false;
                }
                // Assigning each color from 1 to m
                for(int j = 1; j <= m; ++j) {

                        color[i] = j;

                        // Recur of the rest vertices
                        if(graphColoring(graph, i + 1, m, color)) {
                                return true;
                        }
                        color[i] = 0;
                }
                return false;
        }

        public static void main(String[] args) {


                boolean[][] graph = {
                        { false, true, true, true },
                        { true, false, true, false },
                        { true, true, false, true },
                        { true, false, true, false },
                };

                int m = 3; // number of colors
                int[] color = new int[V]; // stores the output
                // initialize all zeros
                for(int i = 0; i < V; ++i) {
                        color[i] = 0;
                }

                if(!graphColoring(graph, 0, m, color)) {
                        System.out.println("Solution does not exist");
                }
        }
}
