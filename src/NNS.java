import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NNS {
    /*
     * Using the random module to pick a random node to start at.
     * While the nodes list is not empty it loops over all nodes remaining in the
     * list and checks the
     * distance between the starting/current node and checks the distance for the
     * shortest distance
     * using a for each loop.
     * It stores the node with shortest distance in the newRoute list and remove it
     * from nodes list
     * and adds the distance to the total distance.
     * It repeats till the nodes list is empty and adds the starting node to the
     * list so it completes
     * the route.
     * In the end it prints the result.
     */
    public static void NNSolve(Node nodeList) {
        Random random = new Random();
        List<Node> startNode = new ArrayList<>();
        List<Node> newRoute = new ArrayList<>();
        List<Node> nodes = nodeList.getNodes();

        int startNodeInt = random.nextInt(nodes.size());
        // int startNodeInt = 0; // Choose the node you want to start at manually
        newRoute.add(nodes.get(startNodeInt));
        startNode.add(nodes.get(startNodeInt));
        nodes.remove(startNodeInt);

        double totalDistance = 0.0;

        while (!nodes.isEmpty()) {
            Node lastNode = newRoute.get(newRoute.size() - 1);
            Node closestNode = null;
            double shortestDistance = Double.MAX_VALUE;

            for (Node node : nodes) {
                double distance = nodeList.getDistance(lastNode, node);
                if (distance < shortestDistance) {
                    shortestDistance = distance;
                    closestNode = node;
                }
            }

            if (closestNode != null) {
                newRoute.add(closestNode);
                nodes.remove(closestNode);
                totalDistance += shortestDistance;
            }
        }
        Node lastNode = newRoute.get(newRoute.size() - 1);
        newRoute.add(startNode.get(0));

        double distance = nodeList.getDistance(lastNode, startNode.get(0));
        totalDistance += distance;

        System.out.println("NNS Route: " + newRoute);
        System.out.println("Route distance: " + totalDistance + "\n");
    }
}
