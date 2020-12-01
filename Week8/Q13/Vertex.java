import java.util.*;
public class Vertex implements Comparable<Vertex> {
    private String name;
    private List<Edge> adjList;
    private Vertex previous;
    private boolean passed;
    private int distance = Integer.MAX_VALUE;

    public Vertex(){}
    
    public Vertex(String name) {
        this.name = name;
        this.adjList = new ArrayList<>();
    }

        public void addEdge(Edge edge) {
        this.adjList.add(edge);
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Edge> getAdjList() {
        return adjList;
    }

    public void setAdjList(List<Edge> adjList) {
        this.adjList = adjList;
    }

    public boolean isPassed() {
        return passed;
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
    }

    public Vertex getPrevious() {
        return previous;
    }

    public void setPrevious(Vertex previous) {
        this.previous = previous;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
    
    public String toString() {
        return this.name;
    }

    public int compareTo(Vertex otherVertex) {
        return Double.compare(this.distance, otherVertex.getDistance());
    }
}
 