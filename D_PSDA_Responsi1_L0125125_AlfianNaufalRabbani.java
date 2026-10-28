import java.util.*;

// 1. tree node (skill tree)
class SkillTreeNode {
    String skillName;
    List<SkillTreeNode> nextSkills;

    public SkillTreeNode(String skillName) {
        this.skillName = skillName;
        this.nextSkills = new ArrayList<>();
    }

    public void addSkill(SkillTreeNode skill) {
        this.nextSkills.add(skill);
    }

    public void printSkillTree(String indent) {
        System.out.println(indent + "-> " + skillName);
        for (SkillTreeNode child : nextSkills) {
            child.printSkillTree(indent + "   ");
        }
    }
}

// 2. binary tree node (percabangan cerita)
class StoryNode {
    String dialog;
    StoryNode choiceA, choiceB;

    public StoryNode(String dialog) {
        this.dialog = dialog;
    }

    public void printStoryPath() {
        System.out.println("Cerita: " + dialog);
        if (choiceA != null)
            System.out.println(" - Pilihan A: " + choiceA.dialog);
        if (choiceB != null)
            System.out.println(" - Pilihan B: " + choiceB.dialog);
    }
}

// 3. binary search tree (papan peringkat level pemain)
class LevelLeaderboard {
    class PlayerNode {
        int level;
        String name;
        PlayerNode left, right;

        public PlayerNode(int level, String name) {
            this.level = level;
            this.name = name;
            left = right = null;
        }
    }

    PlayerNode root;

    public void addPlayer(int level, String name) {
        root = addRec(root, level, name);
    }

    private PlayerNode addRec(PlayerNode root, int level, String name) {
        if (root == null) {
            return new PlayerNode(level, name);
        }
        if (level < root.level) {
            root.left = addRec(root.left, level, name);
        } else if (level > root.level) {
            root.right = addRec(root.right, level, name);
        }
        return root;
    }

    // print in-order
    public void showLeaderboard() {
        reverseInorderRec(root);
        System.out.println();
    }

    private void reverseInorderRec(PlayerNode root) {
        if (root != null) {
            reverseInorderRec(root.right);

            System.out.println("Level " + root.level + " - " + root.name);

            reverseInorderRec(root.left);
        }
    }
}

class systemRPG {

    public static void main(String[] args) {
        System.out.println("=== SISTEM MANAJEMEN GAME RPG ===\n");

        // 1. List (Quest Log)
        System.out.println("1. Daftar Quest Aktif (List):");
        List<String> questLog = new ArrayList<>();
        questLog.add("Kalahkan 10 slime di Hutan");
        questLog.add("Kumpulkan 5 bunga mawar");
        questLog.add("Bicara dengan kepala desa");
        System.out.println("Quest Anda saat ini:");
        for (int i = 0; i < questLog.size(); i++) {
            System.out.println((i + 1) + ". " + questLog.get(i));
        }
        System.out.println("--------------------------------------------------");

        // 2. STACK (Riwayat Lokasi / Checkpoint)
        System.out.println("2.Riwayat Pergerakan/Checkpoint (Stack):");
        Stack<String> lokasi = new Stack<>();
        lokasi.push("Desa Pemula");
        lokasi.push("Hutan Gelap");
        lokasi.push("Gua Naga");
        System.out.println("Jejak Lokasi: " + lokasi);
        System.out.println("Gunakan item 'Return Stone', kembali ke: " + lokasi.pop());
        System.out.println("Lokasi saat ini: " + lokasi.peek());
        System.out.println("--------------------------------------------------");

        // 3. QUEUE (giliran menyerang saat dalam pertarungan)
        System.out.println("3. Turn-Based Combat (Queue):");
        Queue<String> giliranTarung = new LinkedList<>();
        giliranTarung.offer("Hero (Pemain)");
        giliranTarung.offer("Goblin A");
        giliranTarung.offer("Goblin B");
        System.out.println("Urutan Giliran: " + giliranTarung);
        System.out.println("Sekarang giliran: " + giliranTarung.poll() + " menyerang!");
        System.out.println("Antrean berikutnya: " + giliranTarung);
        System.out.println("--------------------------------------------------");

        // 4. SET (Gelar/Title Karakter)
        System.out.println("4. Daftar Gelar/Title Pemain (Set):");
        Set<String> titles = new HashSet<>();
        titles.add("Novice");
        titles.add("Dragon Slayer");
        titles.add("Novice"); // Duplikat, tidak dapat dimasukkan kembali
        System.out.println("Gelar yang dimiliki: " + titles);
        System.out.println("--------------------------------------------------");

        // 5. MAP (Inventory/Tas Barang)
        System.out.println("5. Inventory Item (Map):");
        Map<String, Integer> inventory = new HashMap<>();
        inventory.put("Health Potion", 5);
        inventory.put("Mana Potion", 2);
        inventory.put("Iron Sword", 1);
        System.out.println("Isi Tas: " + inventory);
        System.out.println("Jumlah Health Potion: " + inventory.get("Health Potion"));
        System.out.println("--------------------------------------------------");

        // 6. TREE (Skill Tree Pemain)
        System.out.println("6. Skill Tree Karakter (Tree)):");
        SkillTreeNode rootSkill = new SkillTreeNode("Basic Strike (Level 1)");
        SkillTreeNode pedangSkill = new SkillTreeNode("Sword Mastery (Level 5)");
        SkillTreeNode tamengSkill = new SkillTreeNode("Shield Block (Level 5)");

        rootSkill.addSkill(pedangSkill);
        rootSkill.addSkill(tamengSkill);

        pedangSkill.addSkill(new SkillTreeNode("Fire Slash (Level 10)"));
        pedangSkill.addSkill(new SkillTreeNode("Wind Blade (Level 10)"));
        tamengSkill.addSkill(new SkillTreeNode("Heavy Guard (Level 10)"));

        rootSkill.printSkillTree("");
        System.out.println("--------------------------------------------------");

        // 7. BINARY TREE (Percabangan Pilihan Cerita)
        System.out.println("7. Percabangan Cerita (Binary Tree):");
        StoryNode awal = new StoryNode("Kamu melihat seseorang dirampok di jalan.");
        awal.choiceA = new StoryNode("Tolong korban tersebut.");
        awal.choiceB = new StoryNode("Abaikan dan pergi.");
        awal.printStoryPath();
        System.out.println("--------------------------------------------------");

        // 8. BINARY SEARCH TREE (Leaderboard Pemain Berdasarkan Level)
        System.out.println("8. Leaderboard Level Pemain (Binary Search Tree):");
        LevelLeaderboard leaderboard = new LevelLeaderboard();
        leaderboard.addPlayer(50, "Arthur");
        leaderboard.addPlayer(20, "Lancelot");
        leaderboard.addPlayer(75, "Merlin");
        leaderboard.addPlayer(10, "Noob");
        leaderboard.addPlayer(60, "Jinx");

        System.out.println("Peringkat Pemain:");
        leaderboard.showLeaderboard();
        System.out.println("--------------------------------------------------");
    }
}