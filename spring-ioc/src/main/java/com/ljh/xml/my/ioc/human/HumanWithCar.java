package com.ljh.xml.my.ioc.human;

import com.ljh.xml.my.ioc.car.Car;

/**
 * HumanWithCar
 *
 * @author ljh
 * created on 2019/10/29 15:18
 */
public abstract class HumanWithCar implements Human {

    protected Car car;

    public HumanWithCar(Car car) {
        this.car = car;
    }

    public abstract void goHome();

}
