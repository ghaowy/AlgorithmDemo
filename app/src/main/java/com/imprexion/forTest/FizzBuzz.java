package com.imprexion.forTest;

import java.util.function.IntConsumer;

class FizzBuzz {
    private int n;
    private int now = 1;

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        synchronized(this) {
            while(now <= n) {
                while(now % 3 != 0) {
                    wait();
                }
                printFizz.run();
                now++;
                notifyAll();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
         synchronized(this) {
            while(now <= n) {
                while(now % 5 != 0) {
                    wait();
                }
                printBuzz.run();
                now++;
                 notifyAll();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
         synchronized(this) {
            while(now <= n) {
                while(now % 5 != 0 || now % 3 != 0) {
                    wait();
                }
                printFizzBuzz.run();
                now++;
                notifyAll();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
          synchronized(this) {
            while(now <= n) {
                while(now % 5 == 0 || now % 3 == 0) {
                    wait();
                }
                
                printNumber.accept(now);
                now++;
                notifyAll();
            }
        }
    }
}