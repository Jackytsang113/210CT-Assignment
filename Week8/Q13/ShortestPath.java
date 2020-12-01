import java.util.PriorityQueue;
import java.util.*;
public class ShortestPath{
    public void calShortestPaths(Vertex vt){
        vt.setDistance(0);
        PriorityQueue<Vertex> priQueue = new PriorityQueue<>();
        priQueue.add(vt);
        vt.setPassed(true);

        while(!priQueue.isEmpty()){
            Vertex currentVt = priQueue.poll();
            for(Edge edge : currentVt.getAdjList()){
                Vertex v = edge.getTarget();
                if(!v.isPassed()){
                    int newDistance = currentVt.getDistance() + edge.getWeight();

                    if( v.getDistance() > newDistance){
                        priQueue.remove(v);
                        v.setDistance(newDistance);
                        v.setPrevious(currentVt);
                        priQueue.add(v);
                    }
                }
            }
            currentVt.setPassed(true);
        }
    }

    public List<Vertex> getShortestPath(Vertex target){
        List<Vertex> path = new ArrayList<>();
        
        Vertex current=target;
        while(current != null){
            path.add(current);
            current = current.getPrevious();
        }
        
        Collections.reverse(path);
        return path;
    }
}