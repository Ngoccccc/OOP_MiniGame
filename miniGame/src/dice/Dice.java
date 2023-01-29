package dice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Dice {
    private List<Integer> sucsac = new ArrayList<Integer>();

    public int getScore() {
        Random rand = new Random();
        int rand1 = rand.nextInt(100);
        int result = 0;
        if (rand1 < 20) {
            result = this.sucsac.get(0);
        } else if (rand1 >= 20 && rand1 < 36) {
            result = this.sucsac.get(1);
        } else if (rand1 >= 36 && rand1 < 52) {
            result = this.sucsac.get(2);
        } else if (rand1 >= 52 && rand1 < 68) {
            result = this.sucsac.get(3);
        } else if (rand1 >= 68 && rand1 < 84) {
            result = this.sucsac.get(4);
        } else if (rand1 >= 84 && rand1 < 100) {
            result = this.sucsac.get(5);
        }
        return result;
    }

    public Dice(int chisodacbiet) {
        sucsac.add(chisodacbiet);
        for (int i = 1; i <= 6; i++) {
            if (i != chisodacbiet) {
                sucsac.add(i);
            }
        }
    }

    public static void main(String[] args) {
        Dice dice = new Dice(2);
        System.out.println(dice.getScore());
    }
}
