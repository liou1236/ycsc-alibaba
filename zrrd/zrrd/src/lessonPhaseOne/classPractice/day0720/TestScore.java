package lessonPhaseOne.classPractice.day0720;


import java.util.ArrayList;
import java.util.HashMap;

public class TestScore {
    public static void main(String[] args) {
        HashMap<Integer, Score> map = new HashMap<>();
        ArrayList<Score> passList = new ArrayList<>();
        ArrayList<Score> passFailList = new ArrayList<>();
        int maxId = 1;
        int minId = 1;
        int sumSc = 0;
        int count = 20;
        for (int i = 0; i <= count; i++) {
            int sc = (int) (Math.random() * 101);
            Score score = new Score(i, sc);
            map.put(i, score);
            Score maxScore = map.get(maxId);
            if (maxScore == null || sc > maxScore.score) {
                maxId = i;
            }
            if (maxScore == null || sc < map.get(minId).score){
                minId = i;
            }
            sumSc += sc;
            if (sc >= 60) passList.add(score);
            if (sc < 60) passFailList.add(score);
        }
        System.out.println(map.get(maxId));
        System.out.println(map.get(minId));
        System.out.println(sumSc/count);
        System.out.println(passList);
        System.out.println(passFailList);
    }

    static class Score {
        int id;
        int score;

        public Score(int id, int score) {
            this.id = id;
            this.score = score;
        }

        @Override
        public String toString() {
            return "Score{" + "id=" + id + ", score="
                    + score + "}";
        }
    }
}
