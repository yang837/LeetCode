package leetcode;

class GNode {
    int nV; // number of vertices
    int nE; // number of edges
    int MaxVNum = 10;
    int[][] G = new int[MaxVNum][MaxVNum]; // 邻接表

    GNode() {}

    GNode(int V, int E) {
        this.nV = V;
        this.nE = E;

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                this.G[i][j] = 0;
            }
        }
    }

    public void insertEdge(int u, int v, int weight) {
        this.G[u][v] = weight;
        this.G[v][u] = weight;
    }
}

public class Graph {
    public static void main(String[] args) {
        GNode gNode = new GNode();
    }
}
