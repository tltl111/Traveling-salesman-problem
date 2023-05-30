import java.util.ArrayList;
import java.util.List;
import java.lang.Math;
import java.util.Random;


public class nodeList {
    private List<Node> nodes;

    public nodeList() {
        this.nodes = new ArrayList<>();
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

    /* 
     * Using the random module to pick a random node to start at.
     * While the nodes list is not empty it loops over all nodes remaining in the list and checks the
     * distance between the starting/current node and checks the distance for the shortest distance
     * using a for each loop.
     * It stores the node with shortest distance in the newRoute list and remove it from nodes list.
     * It repeats till the nodes list is empty and prints the result.
     */
    public void solve() {
        Random random = new Random();
        List<Node> newRoute = new ArrayList<>();
        List<Node> nodes = getNodes();
        
        int startNode = random.nextInt(nodes.size());
        // int startNode = 0; // Choose the node you want to start at manually
        newRoute.add(nodes.get(startNode));
        nodes.remove(startNode);

        while (!nodes.isEmpty()) {
            Node lastNode = newRoute.get(newRoute.size() - 1);
            Node closestNode = null;
            double shortestDistance = Double.MAX_VALUE;

            for (Node node : nodes) {
                double distance = getDistance(lastNode, node);
                if (distance < shortestDistance) {
                    shortestDistance = distance;
                    closestNode = node;
                }
            }

            if (closestNode != null) {
                newRoute.add(closestNode);
                nodes.remove(closestNode);
            }
        }
        System.out.println("Route:\n");
        for (Node node : newRoute) {
            System.out.println(node.getName());
        }
    }
}
