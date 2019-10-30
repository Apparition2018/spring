package com.ljh.my.ioc.human;

import com.ljh.my.ioc.car.Car;

/**
 * ZhangShan
 *
 * @author ljh
 * created on 2019/10/29 14:59
 */
public class ZhangShan extends HumanWithCar {


    public ZhangShan(Car car) {
        super(car);
    }

    @Override
    public void goHome() {
        car.start();
        car.turnLeft();
        car.turnRight();
        car.stop();
    }
}
