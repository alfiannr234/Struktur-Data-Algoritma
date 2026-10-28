import java.util.HashMap;
import java.util.Map;
import java.time.LocalDateTime;

class RewardEventMap {
    public static void main(String[] args) {

        // Map menyimpan reward dan waktu klaim
        Map<String, LocalDateTime> claimedRewards = new HashMap<>();

        // Simulasi
        claimReward(claimedRewards, "5000 coin");
        claimReward(claimedRewards, "20 gems");
        claimReward(claimedRewards, "5000 coin"); // coba klaim ulang

        // Tampilkan semua reward yang sudah diklaim
        System.out.println("\nData Reward:");
        for (Map.Entry<String, LocalDateTime> entry : claimedRewards.entrySet()) {
            System.out.println(entry.getKey() + " diklaim pada " + entry.getValue());
        }
    }

    public static void claimReward(Map<String, LocalDateTime> rewards, String reward) {
        if (rewards.containsKey(reward)) {
            System.out.println("Reward '" + reward + "' sudah pernah diklaim!");
        } else {
            rewards.put(reward, LocalDateTime.now());
            System.out.println("Berhasil klaim reward: " + reward);
        }
    }
}