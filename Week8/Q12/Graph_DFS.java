
/**
 * Write a description of class DFStraversal here.
 *
 * @author TsangHoYin
 * @version 1.0
 */
import java.util.*;
public class Graph_DFS{
    private int v;
    private LinkedList<Integer> adj[];
    private boolean passed[];
    private String result;
    public Graph_DFS(){}
    
    public Graph_DFS(int vertices){
        this.v = vertices;
        result = "";
        passed = new boolean[v];
        adj = new LinkedList[v];
        for(int i=0; i < v; i++){
            adj[i] = new LinkedList();
        }
    }
    
    public void addEdge(int v, int w){
        adj[v].add(w);
    }
    
    public String executeDFS(int v){
        result += v + " ";
        passed[v] = true;
        
        Iterator<Integer> content = adj[v].listIterator();
        while (content.hasNext()){
            int current = content.next();
            if (!passed[current])
                executeDFS(current);
        }
        return result;
    }
}
