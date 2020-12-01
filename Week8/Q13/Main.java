public class Main {
    public static void main(String[] args) {
        Vertex vertex1 = new Vertex("1");
        Vertex vertex2 = new Vertex("2");
        Vertex vertex3 = new Vertex("3");
        Vertex vertex4 = new Vertex("4");
        Vertex vertex5 = new Vertex("5");
        Vertex vertex6 = new Vertex("6");

        vertex1.addEdge(new Edge(0,vertex1,vertex1));
        vertex1.addEdge(new Edge(7,vertex1,vertex2));
        vertex1.addEdge(new Edge(2,vertex1,vertex3));
        vertex1.addEdge(new Edge(9,vertex1,vertex4));
        vertex1.addEdge(new Edge(3,vertex1,vertex5));
        vertex1.addEdge(new Edge(5,vertex1,vertex6));

        vertex2.addEdge(new Edge(4,vertex2,vertex5));

        vertex3.addEdge(new Edge(9,vertex3,vertex2));
        vertex3.addEdge(new Edge(4,vertex3,vertex4));
        vertex3.addEdge(new Edge(9,vertex3,vertex5));
        vertex3.addEdge(new Edge(4,vertex3,vertex6));

        vertex5.addEdge(new Edge(5,vertex5,vertex4));
        vertex5.addEdge(new Edge(1,vertex5,vertex6));

        vertex6.addEdge(new Edge(10,vertex6,vertex4));
        
        ShortestPath sp = new ShortestPath();
        sp.calShortestPaths(vertex1);
        
        String output = "";
        output += "\n*********************************************";
        output += "\n\t\tShortest Paths";
        output += "\n*********************************************";
        output += "\n1 to 1: " + sp.getShortestPath(vertex1);
        output += "\n1 to 2: " + sp.getShortestPath(vertex2);
        output += "\n1 to 3: " + sp.getShortestPath(vertex3);
        output += "\n1 to 4: " + sp.getShortestPath(vertex4);
        output += "\n1 to 5: " + sp.getShortestPath(vertex5);
        output += "\n1 to 6: " + sp.getShortestPath(vertex6);
        output += "\n*********************************************";
        output += "\n\t\tMinimum distance";
        output += "\n*********************************************";
        output += "\n1 to 1: " + vertex1.getDistance();
        output += "\n1 to 2: " + vertex2.getDistance();
        output += "\n1 to 3: " + vertex3.getDistance();
        output += "\n1 to 4: " + vertex4.getDistance();
        output += "\n1 to 5: " + vertex5.getDistance();
        output += "\n1 to 6: " + vertex6.getDistance();
        
        System.out.println(output);
    }
}