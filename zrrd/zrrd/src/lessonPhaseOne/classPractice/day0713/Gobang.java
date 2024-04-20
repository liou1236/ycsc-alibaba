package lessonPhaseOne.classPractice.day0713;

import java.util.ArrayList;

public class Gobang {

    static String[][] board = new String[5][5];

    static ArrayList<int[]> aList = new ArrayList<int[]>();
    static ArrayList<int[]> bList = new ArrayList<int[]>();

    //初始化
    static {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = "✛";
            }

        }
    }

    // 下棋 识别下黑子还是白子
    public static boolean play(int x, int y, int count) {

        if (board[x][y] != "✛") {
            // 此处已有棋子
            return false;
        }
        if (count % 2 == 0) {
            board[x][y] = "◉";
            aList.add(new int[]{x, y});
        } else {
            board[x][y] = "◔";
            bList.add(new int[]{x, y});
        }
        return true;
    }

    // 刷新棋盘
    public static void print() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }


    public static String judge() {

        // ABABA 最少要走五步  才会连成线
        if (aList.size() + bList.size() < 5) return "Pending";


        // 判断坐标位置 是否能连线
        //   它的坐标  是否满足四种逻辑之一

        // 如果我们取 aList中的一个坐标   和其他坐标进行比对
        //   其实只要比较三个坐标  和其他所有坐标的关系   就知道是否赢了

        // 循环次数  第一次筛选角色A  第二次筛选角色B
        int count = 0;

        String role = "A";
        ArrayList<int[]> roleList = aList;

        while (count < 2) {
            count++;

            // 最小拿3个坐标  就可以比较出是否连成线
            int size = Math.min(board.length, roleList.size() / 3);

            for (int i = 0; i < size; i++) {
                int[] coor = roleList.get(i);

                // 用容器来承装  满足某一种条件的坐标
                ArrayList<int[]> rows = new ArrayList<int[]>();
                rows.add(coor);

                ArrayList<int[]> columns = new ArrayList<int[]>();
                columns.add(coor);

                // 横纵坐标之差相等的对角线
                ArrayList<int[]> oneLine = new ArrayList<int[]>();
                oneLine.add(coor);


                // 和其他所有坐标比对
                for (int j = 0; j < roleList.size(); j++) {
                    if (i == j) continue;

                    int[] coorTmp = roleList.get(j);
                    if (coorTmp[0] == coor[0]) {
                        rows.add(coorTmp);
                        continue;
                    }

                    if (coorTmp[1] == coor[1]) {
                        columns.add(coorTmp);
                        continue;
                    }

                    // 在一条线上  并且位置挨着
                    if (coorTmp[0] - coorTmp[1] == coor[0] - coor[1]) {
                        oneLine.add(coorTmp);
                    }
                }


                // 如果任意一个容器长度==3  代表连成相对应的线
                if (rows.size() == 3 || columns.size() == 3
                        || oneLine.size() == 3) {

                    // 返回A  赢了
                    return role;
                }
            }

            // 切换角色B
            if (count == 1) {
                role = "B";
                roleList = bList;
            }
        }

        // 发现A和B都没连成线  判断是否有空位
        if (aList.size() + bList.size()
                == board.length * board.length) {
            return "Draw";
        }

        return "Pending";
    }


}

