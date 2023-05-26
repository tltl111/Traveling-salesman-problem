public class Main {
    public static void main(String[] args) {
        
        nodeList nodeList = new nodeList();
        Node leeuwarden = new Node("leeuwarden",53.201390,5.808590);
        Node utrecht = new Node("utrecht", 52.090830,5.122220);
        Node groningen = new Node("groningen",53.219170,6.566670);
        Node arnhem = new Node("arnhem", 51.980000,5.911110);
        Node maastricht = new Node("maastricht", 50.848330,5.688890);
        Node assen = new Node("assen",52.996670,6.562500);
        Node lelystad = new Node("lelystad", 52.508330,5.475000);
        Node amsterdam = new Node("amsterdam", 52.374030,4.889690);
        Node denhaag = new Node("den haag", 52.076670,4.298610);
        Node middelburg = new Node("middelburg", 51.500000,3.613890);
        Node shertogenbosch = new Node("'s hertogenbosch", 51.699170,5.304170);

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

        nodeList.printNodes();

    }
}
