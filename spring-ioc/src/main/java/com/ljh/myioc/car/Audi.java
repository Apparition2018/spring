package com.ljh.myioc.car;

/**
 * Audi
 *
 * @author ljh
 * created on 2019/10/29 14:57
 */
public class Audi implements Car {

    public void start() {
        System.out.println("Audi.start");
    }

    public void turnLeft() {
        System.out.println("Audi.turnLeft");
    }

    public void turnRight() {
        System.out.println("Audi.turnRight");;
    }

    public void stop() {
        System.out.println("Audi.stop");
    }

}
