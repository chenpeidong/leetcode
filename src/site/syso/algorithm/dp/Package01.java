package site.syso.algorithm.dp;

/**
 * 01背包问题
 */
public class Package01 {

    public static void main(String[] args) {

        int totalItem = 4;
        int bagCapacity = 8;    //背包容量

        int[] w = new int[]{0, 2, 3, 4, 5}; //  物品重量
        int[] v = new int[]{0, 3, 4, 7, 6}; //  物品价值

        int[][] dpArr = new int[5][9];  //  动态规划表

        // 计算
        for (int i = 1; i <= totalItem; i++) {
            for (int j = 1; j <= bagCapacity; j++) {
                if (j < w[i]) { // 当前背包容量小于物品体积、该物品不加入背包
                    dpArr[i][j] = dpArr[i - 1][j];
                } else {
                    dpArr[i][j] = Math.max(dpArr[i - 1][j], dpArr[i - 1][j - w[i]] + v[i]);
                }
            }
        }

        // 打印二维数组
        for (int[] ints : dpArr) {
            for (int anInt : ints) {
                System.out.print(anInt);
                System.out.print(" ");
            }
            System.out.println();
        }

        System.out.println();

        // 计算出背包中的具体物品
        int jt = bagCapacity;
        for (int i = totalItem; i >= 0; i--) {
            for (int j = jt; j >= 0; j--) {
                if (i >= 1 && dpArr[i][j] > dpArr[i - 1][j]) {
                    System.out.println(i);
                    jt -= w[i];
                    break;
                }
            }
        }

    }

}
