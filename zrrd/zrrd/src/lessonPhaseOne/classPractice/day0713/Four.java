package lessonPhaseOne.classPractice.day0713;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Four {


    public static void main(String[] args) {
        List<Integer> ranNum = generateNum(10,1,100);
        List<Integer> getResult = getNumOverTen(ranNum);

        System.out.println("Random Numbers:" + ranNum);
        System.out.println("Numbers Greater Than or Equal to 10:" + getResult);
    }
    public static List<Integer> generateNum(int count,int min,int max){
        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();

        for (int i =0;i < count;i++){
            int ranNum = random.nextInt(max - min) + min;
            // int ranNum = Math.random()*(max - min) + min;
            numbers.add(ranNum);
        }
        return numbers;
    }
    public static List<Integer> getNumOverTen(List<Integer> numbers){
        List<Integer> result = new ArrayList<>();
        for (int number : numbers){
            if (number >= 10){
                result.add(number);
            }
        }
        return result;
    }

}
