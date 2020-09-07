package com.imprexion.forTest;

import android.view.View;
import android.view.ViewGroup;

/**
 * @author : gongh
 * @date : 2020/8/17 15:49
 * @desc : TODO
 */
class ViewCount {
    int count = 0;
    boolean isOdd = true;

    public static int getCount(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return 0;
        }

        // 获取总的view孩子数量
        int count = 0;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof ViewGroup) {
                // 如果是ViewGroup 则递归调用 获取View个数
                count += getCount(((ViewGroup) childAt));
            } else {
                count += 1;
            }
        }
        return count;
    }


    public void printVal() {
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        try {
                            printBase();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        ).start();

        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        try {
                            printOdd();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        ).start();
    }

    // 打印偶数
    private void printOdd() throws InterruptedException {

        synchronized (this) {
            while (true) {
                if (!isOdd) {
                    wait();
                }
                Thread.sleep(1000);
                System.out.println(count);
                count++;
                isOdd = !isOdd;
                notifyAll();
            }

        }


    }

    // 打印基数
    private void printBase() throws InterruptedException {
        synchronized (this) {
           a : while (true) {
                if (isOdd) {
                    wait();
                }
                Thread.sleep(1000);
                System.out.println(count);
                count++;
                isOdd = !isOdd;
                notifyAll();
            }
        }
    }
}
