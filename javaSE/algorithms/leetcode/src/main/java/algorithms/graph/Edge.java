package algorithms.graph;

class Edge {

    private int from;
    private int to;
    private double weight;

    public Edge(int from, int to, double weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "to=" + to +
                ", weight=" + weight +
                '}';
    }
}
