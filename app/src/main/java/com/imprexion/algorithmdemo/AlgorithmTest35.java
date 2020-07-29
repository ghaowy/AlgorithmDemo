package com.imprexion.algorithmdemo;

/**
 * @author : gongh
 * @date : 2020/5/26 17:24
 * <p>
 * LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...
 * 他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！
 * “红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,他想了想,决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。
 * 上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。LL决定去买体育彩票啦。
 * 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何， 如果牌能组成顺子就输出true，否则就输出false。为了方便起见,你可以认为大小王是0。
 */
public class AlgorithmTest35 {

    public static void main(String[] args) {
        System.out.println(isContinuous(new int[]{0, 3, 2, 6, 4}));
    }


    public static boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return false;
        }
        int length = numbers.length;
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        int zeroCount = 0;
        for (int i = 0; i < length; i++) {

            if (numbers[i] > 0 && numbers[i] > maxValue) {
                maxValue = numbers[i];
            }
            if (numbers[i] > 0 && numbers[i] < minValue) {
                minValue = numbers[i];
            }
            if (numbers[i] == 0) {
                zeroCount++;
            }
        }

        System.out.println("minValue= " + minValue);
        System.out.println("maxValue= " + maxValue);
        System.out.println("zeroCount= " + zeroCount);

        int[] arr = new int[maxValue - minValue + 1];
        for (int i = 0; i < length; i++) {
            if (numbers[i] != 0) {
                arr[numbers[i] - minValue]++;
            }
        }
        boolean result = true;
        int length1 = arr.length;
        for (int i = 0; i < length1; i++) {
            if (arr[i] == 0) {
                zeroCount--;
            }
            if (arr[i] > 1) {
                result = false;
                break;
            }
            if (zeroCount < 0) {
                result = false;
                break;
            }
        }
        return result;
    }


}
