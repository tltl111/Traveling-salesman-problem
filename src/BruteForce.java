import java.util.ArrayList;
import java.util.List;

public class BruteForce {

    public static void BruteForceSolve(Node nodeList) {
        List<Node> nodes = nodeList.getNodes();

        List<List<Node>> solutions = createSolutions(nodes);

        double shortestDistance = Double.MAX_VALUE;
        List<Node> shortestRoute = new ArrayList<>();

        for (List<Node> solution : solutions) {
            List<Node> route = new ArrayList<>(solution);

            route.add(route.get(0));

            double distance = calculateTotalDistance(route);

            if (distance < shortestDistance) {
                shortestDistance = distance;
                shortestRoute = route;
            }
        }

        System.out.println("BruteForce Route: " + shortestRoute);
        System.out.println("Route Distance: " + shortestDistance);
    }

    private static List<List<Node>> createSolutions(List<Node> nodes) {
        List<List<Node>> solutions = new ArrayList<>();
        createSolutionsHelper(nodes.size(), nodes, solutions);
        return solutions;
    }

    private static void createSolutionsHelper(int n, List<Node> nodes, List<List<Node>> solutions) {
        if (n == 1) {
            solutions.add(new ArrayList<>(nodes));
            return;
        }

        for (int i = 0; i < n; i++) {
            createSolutionsHelper(n - 1, nodes, solutions);
            if (n % 2 == 0) {
                swap(nodes, i, n - 1);
            } else {
                swap(nodes, 0, n - 1);
            }
        }
    }

    private static void swap(List<Node> nodes, int i, int j) {
        Node temp = nodes.get(i);
        nodes.set(i, nodes.get(j));
        nodes.set(j, temp);
    }

    private static double calculateTotalDistance(List<Node> route) {
        double totalDistance = 0.0;
        for (int i = 0; i < route.size() - 1; i++) {
            Node current = route.get(i);
            Node next = route.get(i + 1);
            double distance = getDistance(current, next);
            totalDistance += distance;
        }
        return totalDistance;
    }

    // Calculates the distance between 2 nodes using the math module and Pythagoras
    public static double getDistance(Node node1, Node node2) {
        double differenceSqaureX = Math.pow(node1.getXPos() - node2.getXPos(), 2);
        double differenceSqaureY = Math.pow(node1.getYPos() - node2.getYPos(), 2);
        return Math.sqrt(differenceSqaureX + differenceSqaureY);
    }
}
