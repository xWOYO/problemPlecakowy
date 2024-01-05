import java.text.MessageFormat;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        backpackProblem();

    }

    private static final int NUMBER_OF_ITEMS = 100;
    private static final int VOLUME = 2500;
    private static final int NUMBER_OF_RUNS = 400;

    private static void backpackProblem(){
        int[] items = fillitems();
        boolean[] itemsInBackpack = new boolean[NUMBER_OF_ITEMS];
        boolean[] newItemsInBackpack = new boolean[NUMBER_OF_ITEMS];
        int itemsVolume = 0;

        for(int i = 0; i < NUMBER_OF_RUNS; i++){
            int randomPlace = getRandomNumber(0, 99);
            newItemsInBackpack = itemsInBackpack.clone();
            newItemsInBackpack[randomPlace] = !newItemsInBackpack[randomPlace];
            int newItemsVolume = sumItemsValues(items, newItemsInBackpack);

            if(newItemsVolume > itemsVolume && newItemsVolume < VOLUME) {
                itemsInBackpack = newItemsInBackpack.clone();
                itemsVolume = newItemsVolume;
            }
            if(newItemsVolume == VOLUME) {
                String message = MessageFormat.format("After: {0} runs algorithm found max value ({1}).", i, VOLUME);
                System.out.println(message);
                return;
            }
        }

        String message = MessageFormat.format("After: {0} runs sum of volumes of items that are in backpack is: {1}.", NUMBER_OF_RUNS, itemsVolume);
        System.out.println(message);

    }

    private static int[] fillitems() {
        int[] items = new int[NUMBER_OF_ITEMS];

        for(int i = 0; i < NUMBER_OF_ITEMS; i++) {
            items[i] = getRandomNumber(10, 100);
        }
        return items;
    }

    private static int sumItemsValues(int[] items, boolean[] itemsInBackpack){
        int sum = 0;
        for(int i = 0; i < NUMBER_OF_ITEMS; i++) {
            if(itemsInBackpack[i] == true){
                sum = sum + items[i];
            }
        }

        return sum;
    }

    private static int getRandomNumber(int start, int stop){
        Random random = new Random();
        return random.nextInt((stop - start) + 1) + start;
    }


}

