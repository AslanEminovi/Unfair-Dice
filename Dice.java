import java.util.Random;

public class Dice {
    private final int[] probabilities = {5, 10, 20, 5, 5, 5, 5, 5, 10, 30};
    private int[] counters = new int[10];
    private int totalRolls = 0;
    private int lastRolledNumber = -1;
    
    public int roll() {
        Random random = new Random();
        int roll = random.nextInt(100); // Generate a random number between 0 and 99

        int side = 0;
        int cumulativeProbability = 0;
        for (int i = 0; i < 10; i++) {
            cumulativeProbability += probabilities[i];
            if (roll < cumulativeProbability) {
                side = i + 1;
                break;
            }
        }

        // Update counters and totalRolls
        counters[side - 1]++;
        totalRolls++;
        lastRolledNumber = side;

        return side;
    }

    public int getRolledNumber() {
        return lastRolledNumber;
    }

    public void getReport() {
        System.out.println("Dice has been Rolled " + totalRolls + " times");
        for (int i = 0; i < 10; i++) {
            System.out.println((i + 1) + ": >" + counters[i]);
        }
    }

    public static void main(String[] args) {
        Dice dice = new Dice();
        int rolls = 20;
        for (int i = 0; i < rolls; i++) {
            dice.roll();
        }
        dice.getReport();
    }
}
