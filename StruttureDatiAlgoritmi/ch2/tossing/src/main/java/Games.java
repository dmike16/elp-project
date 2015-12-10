import java.util.Random;

/**
 * Created by dmike on 10/12/15.
 * @author dmike
 */
interface Game{
    int tossing();
}

interface GameFactory{
    Game getGame();
}

enum Coin {
    CROSS,HEAD
}

enum DICE {
    FIRST, SECOND, THIRD, FOURTH, FIVETH, SIXTH, SEVENTH
}

class CoinTossing implements Game{
    @Override
    public int tossing(){
        int toss = coin.nextInt(2);
        Coin tc;

        upgradeTossingNumber();

        if (toss == 1){
            tc = Coin.HEAD;
        } else {
            tc = Coin.CROSS;
        }

        System.out.println("Tossing Number " + counter + " result: " + tc);

        return toss;
    }
    CoinTossing(){
        System.out.println("Take a new Coin");
    }
    private void upgradeTossingNumber(){
        counter++;
    }
    private long counter = 0;
    private static final Random coin = new Random(47);
}

class CoinTossingFactory implements GameFactory{
    @Override
    public Game getGame(){
        return new CoinTossing();
    }
}

class DiceTossing implements Game{
    public int tossing(){
        int toss = dice.nextInt(6);
        DICE d = DICE.SEVENTH;

        upgradeDiceToss();

        switch (toss){
            case 0:
                d = DICE.FIRST;
                break;
            case 1:
                d = DICE.SECOND;
                break;
            case 2:
                d = DICE.THIRD;
                break;
            case 3:
                d = DICE.FOURTH;
                break;
            case 4:
                d = DICE.FIVETH;
                break;
            case 5:
                d = DICE.SIXTH;
                break;
            default:
                System.out.println("Your Dice is Strange");
                break;
        }

        System.out.println("Toss Number " + counter + " Face : " + d);

        return toss;
    }
    DiceTossing(){
        System.out.println("A new Dice");
    }
    private void upgradeDiceToss(){
        counter++;
    }
    private long counter = 0;
    private static final Random dice = new Random(48);
}

class DiceTossingFactory implements GameFactory{
    public Game getGame(){
        return new DiceTossing();
    }
}

public class Games {
    public static void playGame(GameFactory g){
        Game s = g.getGame();
        int i = 10;

        while ((i--) >= 0){
            s.tossing();
        }
    }
    public static void main(String[] args){
        playGame(new CoinTossingFactory());
        playGame(new DiceTossingFactory());
    }
}
