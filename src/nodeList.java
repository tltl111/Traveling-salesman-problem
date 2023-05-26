import java.util.ArrayList;
import java.util.List;

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

    public void printNodes() {
        List<Node> nodes = getNodes();
        for (Node node : nodes) {
            System.out.println(node.getName() + " (" + node.getXPos() + ", " + node.getYPos() + ")");
        }
    }
}
