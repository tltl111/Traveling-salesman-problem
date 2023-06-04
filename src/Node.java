import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

public class Node {
    private List<Node> nodes;

    private String name;
    private double xPos;
    private double yPos;
    private double distance;

    public Node() {
        this.nodes = new ArrayList<>();
    }
    
    public Node(String name, double xPos, double yPos) {
        this.name = name;
        this.xPos = xPos;
        this.yPos = yPos;
        this.distance = 0.0;
    }

    public String getName() {
        return name;
    }

    public double getXPos() {
        return xPos;
    }

    public double getYPos() {
        return yPos;
    }

    public double getDistance() {
        return distance;
    }
    
    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return name;
    }

    public void addNode(Node newNode) {
        nodes.add(newNode);
    }

    public List<Node> getNodes() {
        return nodes;
    }

    // Print all the nodes in the list
    public void printNodes() {
        List<Node> nodes = getNodes();
        for (Node node : nodes) {
            System.out.println(node.getName() + " (" + node.getXPos() + ", " + node.getYPos() + ")");
        }
    }

    // Print one of the nodes manually by index location
    public void printOneNode() {
        List<Node> nodes = getNodes();
        Node node1 = nodes.get(0);
        String printName = node1.getName();
        System.out.println(printName);
    }

    // Calculates the distance between 2 nodes using the math module and Pythagoras
    public double getDistance(Node node1, Node node2) {
        double differenceSqaureX = Math.pow(node1.getXPos() - node2.getXPos(), 2);
        double differenceSqaureY = Math.pow(node1.getYPos() - node2.getYPos(), 2);
        return Math.sqrt(differenceSqaureX + differenceSqaureY);
    }

    public void printDistance(Node node1, Node node2) {
        double distance = getDistance(node1, node2);
        System.out.println("The distance between " + node1.getName() + " and " + node2.getName() + " is: " + distance);
    }

    public int size() {
        return nodes.size();
    }

    public Node get(int index) {
        return nodes.get(index);
    }
}
