public class Node {
    private String name;
    private double xPos;
    private double yPos;

    public Node(String name, double xPos, double yPos) {
        this.name = name;
        this.xPos = xPos;
        this.yPos = yPos;
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
}
