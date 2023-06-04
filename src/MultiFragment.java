import java.util.ArrayList;
import java.util.List;

public class MultiFragment {
    
    public static void MultifragmentSolve(List<Node> nodes) {
        List<Node> route = new ArrayList<>();
        double totalDistance = 0.0;
        
        Node startNode = nodes.get(0);
        route.add(startNode);
        nodes.remove(startNode);

        while (nodes.size() > 1) {
            Node currentNode = route.get(route.size() - 1);
            Node closestNode = null;
            double shortestDistance = Double.MAX_VALUE;

            for (Node node : nodes) {
                double distance = getDistance(currentNode, node);
                if (distance < shortestDistance) {
                    shortestDistance = distance;
                    closestNode = node;
                }
            }

            if (createsLoop(route, closestNode) || leaveNodesUnconnected(route, closestNode)) {
                nodes.remove(closestNode);
                continue;
            }

            route.add(closestNode);
            nodes.remove(closestNode);
            totalDistance += shortestDistance;
        }

        Node lastNode = nodes.get(0);
        route.add(lastNode);
        totalDistance += getDistance(route.get(route.size() - 1), startNode);
        route.add(startNode);

        System.out.println();
        System.out.println("MultiFragment Route: " + route);
        System.out.println("Route distance: " + totalDistance);
        System.out.println();
    }

    // Calculates the distance between 2 nodes using the math module and Pythagoras
    public static double getDistance(Node node1, Node node2) {
        double differenceSqaureX = Math.pow(node1.getXPos() - node2.getXPos(), 2);
        double differenceSqaureY = Math.pow(node1.getYPos() - node2.getYPos(), 2);
        return Math.sqrt(differenceSqaureX + differenceSqaureY);
    }

    public static boolean createsLoop(List<Node> route, Node newNode) {
        if (route.contains(newNode)) {
            int lastIndex = route.size() - 1;
            // Node lastNode = route.get(lastIndex);
            int newNodeIndex = route.indexOf(newNode);
            if (newNodeIndex == lastIndex - 1 || newNodeIndex == lastIndex + 1) {
                return true;
            }
        }
        return false;
    }

    public static boolean leaveNodesUnconnected(List<Node> route, Node newNode) {
        for (Node node : route) {
            int nodeIndex = route.indexOf(node);
            int newNodeIndex = route.indexOf(newNode);
            if (newNodeIndex == nodeIndex - 1 || newNodeIndex == nodeIndex + 1) {
                return false;
            }
        }
        return true;
    }
}

