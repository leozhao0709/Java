package algorithms.graph;

import java.util.Arrays;
import java.util.List;

class Path {
    int src;
    int des;
    double distance;
    List<Integer> pathArray;


    public Path(int src, int des, double distance, List<Integer> pathArray) {
        this.src = src;
        this.des = des;
        this.distance = distance;
        this.pathArray = pathArray;
    }

    @Override
    public String toString() {
        return "Path{" +
                "src=" + src +
                ", des=" + des +
                ", distance=" + distance +
                ", path=" + Arrays.toString(pathArray.toArray())+
                '}';
    }
}
