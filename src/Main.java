import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Node> nodeList2 = new ArrayList<>();
        List<Node> nodeList3 = new ArrayList<>();
        List<Node> nodeList4 = new ArrayList<>();
        Node nodeList = new Node();

        Node leeuwarden = new Node("Leeuwarden", 53.201390, 5.808590);
        Node utrecht = new Node("Utrecht", 52.090830, 5.122220);
        Node groningen = new Node("Groningen", 53.219170, 6.566670);
        Node arnhem = new Node("Arnhem", 51.980000, 5.911110);
        Node maastricht = new Node("Maastricht", 50.848330, 5.688890);
        Node assen = new Node("Assen", 52.996670, 6.562500);
        Node lelystad = new Node("Lelystad", 52.508330, 5.475000);
        Node amsterdam = new Node("Amsterdam", 52.374030, 4.889690);
        Node denhaag = new Node("Den haag", 52.076670, 4.298610);
        Node middelburg = new Node("Middelburg", 51.500000, 3.613890);
        Node shertogenbosch = new Node("'s Hertogenbosch", 51.699170, 5.304170);
        Node amersfoort = new Node("Amersfoort", 52.15600, 5.38967);
        Node denhelder = new Node("Den Helder", 52.93898, 4.75402);

        nodeList.addNode(leeuwarden);
        nodeList.addNode(utrecht);
        nodeList.addNode(groningen);
        nodeList.addNode(arnhem);
        nodeList.addNode(maastricht);
        nodeList.addNode(assen);
        nodeList.addNode(lelystad);
        nodeList.addNode(amsterdam);
        nodeList.addNode(denhaag);
        nodeList.addNode(middelburg);
        nodeList.addNode(shertogenbosch);

        long startTimeNNS = System.nanoTime();
        NNS.NNSolve(nodeList);
        long endTimeNNS = System.nanoTime();
        long durationNNS = ((endTimeNNS - startTimeNNS) / 1_000_000);

        nodeList.addNode(leeuwarden);
        nodeList.addNode(utrecht);
        nodeList.addNode(groningen);
        nodeList.addNode(arnhem);
        nodeList.addNode(maastricht);
        nodeList.addNode(assen);
        nodeList.addNode(lelystad);
        nodeList.addNode(amsterdam);
        nodeList.addNode(denhaag);
        nodeList.addNode(middelburg);
        nodeList.addNode(shertogenbosch);
        // nodeList.addNode(amersfoort);
        // nodeList.addNode(denhelder);

        long startTimeBrute = System.nanoTime();
        BruteForce.BruteForceSolve(nodeList);
        long endTimeBrute = System.nanoTime();
        long durationBrute = ((endTimeBrute - startTimeBrute) / 1_000_000);

        nodeList2.add(leeuwarden);
        nodeList2.add(utrecht);
        nodeList2.add(groningen);
        nodeList2.add(arnhem);
        nodeList2.add(maastricht);
        nodeList2.add(assen);
        nodeList2.add(lelystad);
        nodeList2.add(amsterdam);
        nodeList2.add(denhaag);
        nodeList2.add(middelburg);
        nodeList2.add(shertogenbosch);

        long startTimeMulti = System.nanoTime();
        MultiFragment.MultifragmentSolve(nodeList2);
        long endTimeMulti = System.nanoTime();
        long durationMulti = ((endTimeMulti - startTimeMulti) / 1_000_000);

        nodeList3.add(leeuwarden);
        nodeList3.add(utrecht);
        nodeList3.add(groningen);
        nodeList3.add(arnhem);
        nodeList3.add(maastricht);
        nodeList3.add(assen);
        nodeList3.add(lelystad);
        nodeList3.add(amsterdam);
        nodeList3.add(denhaag);
        nodeList3.add(middelburg);
        nodeList3.add(shertogenbosch);

        long startTimeRaster = System.nanoTime();
        Raster.RasterSolve(nodeList3);
        long endTimeRaster = System.nanoTime();
        long durationRaster = ((endTimeRaster - startTimeRaster) / 1_000_000);

        nodeList4.add(leeuwarden);
        nodeList4.add(utrecht);
        nodeList4.add(groningen);
        nodeList4.add(arnhem);
        nodeList4.add(maastricht);
        nodeList4.add(assen);
        nodeList4.add(lelystad);
        nodeList4.add(amsterdam);
        nodeList4.add(denhaag);
        nodeList4.add(middelburg);
        nodeList4.add(shertogenbosch);

        long startTimeSplitSolve = System.nanoTime();
        Split.splitSolve(nodeList4, 4);
        long endTimeSplitSolve = System.nanoTime();
        long durationSplitSolve = ((endTimeSplitSolve - startTimeSplitSolve) / 1_000_000);

        System.out.println("NNS took: " + durationNNS + " ms to get a route");
        System.out.println("BruteForce took: " + durationBrute + " ms to get a route");
        System.out.println("MultiFragment took: " + durationMulti + " ms to get a route");
        System.out.println("RasterNNS took: " + durationRaster + " ms to get a route");
        System.out.println("SplitSolve took: " + durationSplitSolve + " ms to get a route");
    }
}
