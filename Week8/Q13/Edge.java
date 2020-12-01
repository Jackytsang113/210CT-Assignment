public class Edge {
    private int weight;
    private Vertex start;
    private Vertex target;

    public Edge(){}
    
    public Edge(int weight, Vertex start, Vertex target) {
        this.weight = weight;
        this.start = start;
        this.target = target;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
    
    public int getWeight() {
        return weight;
    }

    public void setStart(Vertex start) {
        this.start = start;
    }
    
    public Vertex getStart() {
        return start;
    }

    public void setTarget(Vertex target) {
        this.target = target;
    }
    
    public Vertex getTarget() {
        return target;
    }
}