
/**
 * Write a description of class Main here.
 *
 * @author TsangHoYin
 * @version 1.0
 */
public class Main{
    public static void main(String args[]){
        Graph_DFS graph = new Graph_DFS(7);
 
        graph.addEdge(1, 2); 
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(1, 5); 
        graph.addEdge(1, 6); 
        
        graph.addEdge(2, 5);
        
        graph.addEdge(3, 2); 
        graph.addEdge(3, 4); 
        graph.addEdge(3, 5); 
        graph.addEdge(3, 6);
        
        graph.addEdge(5, 4);
        graph.addEdge(5, 6);
        
        graph.addEdge(6, 4);
 
        System.out.println("Depth First Traversal (vertex 1)\n" 
        + graph.executeDFS(1));
    }
}
