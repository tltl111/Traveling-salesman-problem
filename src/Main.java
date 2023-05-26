public class Main {
    public static void main(String[] args) {
        
        NodeList nodeList = new NodeList();
        Node leeuwarden = new Node("Leeuwarden",53.201390,5.808590);
        Node utrecht = new Node("Utrecht", 52.090830,5.122220);
        Node groningen = new Node("Groningen",53.219170,6.566670);
        Node arnhem = new Node("Arnhem", 51.980000,5.911110);
        Node maastricht = new Node("Maastricht", 50.848330,5.688890);
        Node assen = new Node("Assen",52.996670,6.562500);
        Node lelystad = new Node("Lelystad", 52.508330,5.475000);
        Node amsterdam = new Node("Amsterdam", 52.374030,4.889690);
        Node denhaag = new Node("Den haag", 52.076670,4.298610);
        Node middelburg = new Node("Middelburg", 51.500000,3.613890);
        Node shertogenbosch = new Node("'s Hertogenbosch", 51.699170,5.304170);

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

        nodeList.solve();

    }
}
