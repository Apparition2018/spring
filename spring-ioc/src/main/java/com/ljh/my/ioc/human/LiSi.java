package com.ljh.my.ioc.human;

import com.ljh.my.ioc.car.Car;

/**
 * LiSi
 *
 * @author ljh
 * created on 2019/10/29 15:20
 */
public class LiSi extends HumanWithCar {

    public LiSi(Car car) {
        super(car);
    }

    @Override
    public void goHome() {
        car.start();
        car.stop();
    }
}
