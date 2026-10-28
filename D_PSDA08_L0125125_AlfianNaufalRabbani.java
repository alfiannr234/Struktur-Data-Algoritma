import java.util.LinkedList;

class GraphMatrix {

    // Number of vertices
    private int n;

    // Adjacency matrix
    private int[][] g;

    // Constructor
    GraphMatrix(int x) {
        this.n = x;
        g = new int[n][n];
    }

    // Function to display adjacency matrix
    public void displayAdjacencyMatrix() {
        // Displaying the 2D matrix
        for (int i = 0; i < n; ++i) {
            System.out.println();
            for (int j = 0; j < n; ++j) {
                System.out.print(" " + g[i][j]);
            }
        }
        System.out.println();
    }

    // Function to update adjacency
    // matrix for edge insertion
    public void addEdge(int x, int y) {
        // Checks if the vertices exists
        if ((x < 0) || (x >= n)) {
            System.out.println("Vertex " + x + " does not exist!");
            return;
        }
        if ((y < 0) || (y >= n)) {
            System.out.println("Vertex " + y + " does not exist!");
            return;
        }

        // Checks if it is a self edge
        if (x == y) {
            System.out.println("Same Vertex!");
        } else {
            // Insert edge (Directed Graph)
            g[y][x] = 1;
            // Delete comment below for Undirected Graph
            g[x][y] = 1;
        }
    }

    // Function to update adjacency
    // matrix for edge removal
    public void removeEdge(int x, int y) {
        // Checks if the vertices exists
        if ((x < 0) || (x >= n)) {
            System.out.println("Vertex " + x + " does not exist!");
            return;
        }
        if ((y < 0) || (y >= n)) {
            System.out.println("Vertex " + y + " does not exist!");
            return;
        }

        // Checks if it is a self edge
        if (x == y) {
            System.out.println("Same Vertex!");
        } else {
            // Remove edge
            g[y][x] = 0;

            // Delete comment below for Undirected Graph
            // g[x][y] = 0;
        }
    }
}

// Driver Code
class Main {
    public static void main(String[] args) {
        int N = 11;
        GraphMatrix obj = new GraphMatrix(N);

        // Inserting edges
        obj.addEdge(0, 1);
        obj.addEdge(0, 2);
        obj.addEdge(0, 3);
        obj.addEdge(0, 4);
        obj.addEdge(0, 8);
        obj.addEdge(1, 6);
        obj.addEdge(2, 6);
        obj.addEdge(3, 4);
        obj.addEdge(3, 8);
        obj.addEdge(4, 9);
        obj.addEdge(5, 6);
        obj.addEdge(5, 10);
        obj.addEdge(6, 7);
        obj.addEdge(7, 9);
        obj.addEdge(7, 10);
        obj.addEdge(9, 10);

        System.out.println("Adjacency matrix after edge insertions:");
        obj.displayAdjacencyMatrix();
    }
}

class GraphList {
    // Jumlah vertex (node)
    private int V;

    // Array dari LinkedList untuk menyimpan daftar ketetanggaan
    private LinkedList<Integer>[] adjList;

    // Constructor
    public GraphList(int vertices) {
        this.V = vertices;

        // Inisialisasi ukuran array sebanyak jumlah vertex
        adjList = new LinkedList[V];

        // Inisialisasi LinkedList kosong untuk setiap elemen array
        for (int i = 0; i < V; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    // Method untuk menambahkan Edge
    public void addEdge(int source, int destination) {
        // Cek validitas node
        if (source < 0 || source >= V || destination < 0 || destination >= V) {
            System.out.println("Vertex tidak valid!");
            return;
        }

        // Tambahkan destination ke list milik source
        adjList[source].add(destination);

        // diaktifkan karena graf ini Undirected
        adjList[destination].add(source);
    }

    // Method untuk menghapus Edge
    public void removeEdge(int source, int destination) {
        if (source < 0 || source >= V || destination < 0 || destination >= V) {
            System.out.println("Vertex tidak valid!");
            return;
        }

        // Menghapus destination dari list source.
        adjList[source].remove((Integer) destination);

        // diaktifkan karena graf ini Undirected
        adjList[destination].remove((Integer) source);
    }

    // Method untuk menampilkan Graph
    public void displayGraph() {
        System.out.println("Representasi Adjacency List:");
        for (int i = 0; i < V; i++) {
            System.out.print("Vertex " + i + " terhubung ke: ");

            // Loop melalui isi LinkedList pada index i
            for (Integer node : adjList[i]) {
                System.out.print(node + " ");
            }
            System.out.println();
        }
    }
}

// Driver Code
class Main2 {
    public static void main(String[] args) {
        int V = 11; // 11 karena node pada graf ada dari 0 sampai 10
        GraphList graph = new GraphList(V);

        // Memnambahkan edge
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(0, 4);
        graph.addEdge(0, 8);
        graph.addEdge(1, 6);
        graph.addEdge(2, 6);
        graph.addEdge(3, 4);
        graph.addEdge(3, 8);
        graph.addEdge(4, 9);
        graph.addEdge(5, 6);
        graph.addEdge(5, 10);
        graph.addEdge(6, 7);
        graph.addEdge(7, 9);
        graph.addEdge(7, 10);
        graph.addEdge(9, 10);

        // Tampilkan graph
        graph.displayGraph();
    }
}