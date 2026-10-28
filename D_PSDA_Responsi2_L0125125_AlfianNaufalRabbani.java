class User {
    int id;
    String nama;

    public User(int id, String nama) {
        this.id = id;
        this.nama = nama;
    }

    @Override
    public String toString() {
        return "User{id=" + id + ", nama='" + nama + "'}";
    }
}

class BackendUserSystem {

    // DISJOINT SET
    static class DisjointSet {
        int[] parent;
        int[] rank;

        public DisjointSet(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        public int find(int i) {
            if (parent[i] == i) {
                return i;
            }
            parent[i] = find(parent[i]);
            return parent[i];
        }

        public void union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);

            if (rootI != rootJ) {
                if (rank[rootI] < rank[rootJ]) {
                    parent[rootI] = rootJ;
                } else if (rank[rootI] > rank[rootJ]) {
                    parent[rootJ] = rootI;
                } else {
                    parent[rootJ] = rootI;
                    rank[rootI]++;
                }
            }
        }

        public boolean isSameCircle(int i, int j) {
            return find(i) == find(j);
        }
    }

    // MERGE SORT
    public static void mergeSort(User[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    private static void merge(User[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        User[] L = new User[n1];
        User[] R = new User[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[left + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i].id <= R[j].id) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // BINARY SEARCH
    public static User binarySearch(User[] arr, int targetId) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid].id == targetId) {
                return arr[mid];
            }

            if (arr[mid].id < targetId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        User[] users = {
                new User(543, "Tomi"),
                new User(102, "Awi"),
                new User(876, "Rina"),
                new User(234, "Budi"),
                new User(912, "Citra")
        };

        System.out.println("--- Mengurutkan Database User (Merge Sort) ---");
        mergeSort(users, 0, users.length - 1);
        for (User u : users) {
            System.out.println(u);
        }

        DisjointSet ds = new DisjointSet(users.length);

        ds.union(0, 1);
        ds.union(2, 3);

        ds.union(3, 4);

        System.out.println("\n--- Pencarian User (Binary Search) ---");
        int targetId = 543;
        User foundUser = binarySearch(users, targetId);

        if (foundUser != null) {
            System.out.println("User ditemukan: " + foundUser.nama + " (ID: " + foundUser.id + ")");

            System.out.println("\n--- Analisis Komunitas (Disjoint Set) ---");
            System.out.print("Apakah Awi dan Tomi berada di circle yang sama? ");
            System.out.println(ds.isSameCircle(0, 2) ? "Ya" : "Tidak");

            System.out.print("Apakah Tomi dan Citra berada di circle yang sama? ");
            System.out.println(ds.isSameCircle(2, 4) ? "Ya" : "Tidak");

        } else {
            System.out.println("User dengan ID " + targetId + " tidak ditemukan.");
        }
    }
}