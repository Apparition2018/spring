package com.ljh.myioc.human;

import com.ljh.myioc.car.Car;

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
