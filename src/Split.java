import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.util.Collections;


public class Split {
    public static void splitSolve(List<Node> nodes, int startNode) {
        List<Node> route = new ArrayList<>();

        List<Node> leftStorage = new ArrayList<>();
        List<Node> rightStorage = new ArrayList<>();

        double sumY = 0.0;

        for (Node node : nodes) {
            sumY += node.getYPos();
        }

        double averageY = sumY / nodes.size();

        route.add(nodes.get(startNode));
        nodes.remove(startNode);

        for (Node node : nodes) {
            double distance = getDistance(route.get(0), node);
            node.setDistance(distance);            
        }

        nodes.sort(Comparator.comparingDouble(Node::getDistance));
        
        for (Node node : nodes) {
            if (node.getYPos() < averageY){
                leftStorage.add(node);
            } else {
                rightStorage.add(node);
            }
        }

        route.addAll(leftStorage);
        Collections.reverse(rightStorage);
        route.addAll(rightStorage);

        route.add(route.get(0));
        
        System.out.println(route);
    }

    public static double getDistance(Node node1, Node node2) {
        double differenceSqaureX = Math.pow(node1.getXPos() - node2.getXPos(), 2);
        double differenceSqaureY = Math.pow(node1.getYPos() - node2.getYPos(), 2);
        return Math.sqrt(differenceSqaureX + differenceSqaureY);
    }
}
