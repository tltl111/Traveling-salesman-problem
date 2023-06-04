import java.util.ArrayList;
import java.util.List;

public class Raster {
    
    public static void RasterSolve(List<Node> nodes) {
        List<Node> route = new ArrayList<>();

        List<Node> LowLeftStorage = new ArrayList<>();
        List<Node> LowRightStorage = new ArrayList<>();
        List<Node> HighLeftStorage = new ArrayList<>();
        List<Node> HighRightStorage = new ArrayList<>();

        double sumX = 0.0;
        double sumY = 0.0;
        double totalDistance = 0.0;

        for (Node node : nodes) {          
            sumX += node.getXPos();
            sumY += node.getYPos();
        }

        double averageX = sumX / nodes.size();
        double averageY = sumY / nodes.size();

        for (Node node : nodes) {
            if (node.getXPos() < averageX) {
                if (node.getYPos() < averageY) {
                    LowLeftStorage.add(node);
                } else {
                    LowRightStorage.add(node);
                }
            } else {
                if (node.getYPos() < averageY) {
                    HighLeftStorage.add(node);
                } else {
                    HighRightStorage.add(node);
                }
            }
        }
        route.add(LowRightStorage.get(1));
        LowRightStorage.remove(1);

        while (!LowRightStorage.isEmpty()) {
            Node lastNode = route.get(route.size() - 1);
            Node closestNode = null;
            double shortestDistance = Double.MAX_VALUE;

            for (Node node: LowRightStorage) {
                double distance = getDistance(lastNode, node);
                if (distance < shortestDistance) {
                    shortestDistance = distance;
                    closestNode = node;
                }
            }

            if (closestNode != null) {
                route.add(closestNode);
                LowRightStorage.remove(closestNode);
                totalDistance += shortestDistance;
            }
        }

        while (!LowLeftStorage.isEmpty()) {
            Node lastNode = route.get(route.size() - 1);
            Node closestNode = null;
            double shortestDistance = Double.MAX_VALUE;

            for (Node node: LowLeftStorage) {
                double distance = getDistance(lastNode, node);
                if (distance < shortestDistance) {
                    shortestDistance = distance;
                    closestNode = node;
                }
            }

            if (closestNode != null) {
                route.add(closestNode);
                LowLeftStorage.remove(closestNode);
                totalDistance += shortestDistance;
            }
        }

        while (!HighLeftStorage.isEmpty()) {
            Node lastNode = route.get(route.size() - 1);
            Node closestNode = null;
            double shortestDistance = Double.MAX_VALUE;

            for (Node node: HighLeftStorage) {
                double distance = getDistance(lastNode, node);
                if (distance < shortestDistance) {
                    shortestDistance = distance;
                    closestNode = node;
                }
            }

            if (closestNode != null) {
                route.add(closestNode);
                HighLeftStorage.remove(closestNode);
                totalDistance += shortestDistance;
            }
        }

        while (!HighRightStorage.isEmpty()) {
            Node lastNode = route.get(route.size() - 1);
            Node closestNode = null;
            double shortestDistance = Double.MAX_VALUE;

            for (Node node: HighRightStorage) {
                double distance = getDistance(lastNode, node);
                if (distance < shortestDistance) {
                    shortestDistance = distance;
                    closestNode = node;
                }
            }

            if (closestNode != null) {
                route.add(closestNode);
                HighRightStorage.remove(closestNode);
                totalDistance += shortestDistance;
            }
        }

        Node lastNode = route.get(route.size() - 1);
        route.add(route.get(0));

        double distance = getDistance(lastNode, route.get(0));
        totalDistance += distance;

        System.out.println("Raster Route: " + route);
        System.out.println("Raster distance: " + totalDistance + "\n");
    }

    public static double getDistance(Node node1, Node node2) {
        double differenceSqaureX = Math.pow(node1.getXPos() - node2.getXPos(), 2);
        double differenceSqaureY = Math.pow(node1.getYPos() - node2.getYPos(), 2);
        return Math.sqrt(differenceSqaureX + differenceSqaureY);
    }
}
