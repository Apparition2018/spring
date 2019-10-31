package com.ljh.xml.my.ioc.car;

/**
 * Buick
 *
 * @author ljh
 * created on 2019/10/29 15:02
 */
public class Buick implements Car {

    public void start() {
        System.out.println("Buick.start");
    }

    public void turnLeft() {
        System.out.println("Buick.turnLeft");
    }

    public void turnRight() {
        System.out.println("Buick.turnRight");;
    }

    public void stop() {
        System.out.println("Buick.stop");
    }
}
