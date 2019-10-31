package com.ljh.xml;

import com.ljh.xml.my.ioc.IoCContainer;
import com.ljh.xml.my.ioc.car.Audi;
import com.ljh.xml.my.ioc.car.Buick;
import com.ljh.xml.my.ioc.human.Human;
import com.ljh.xml.my.ioc.human.LiSi;
import com.ljh.xml.my.ioc.human.ZhangShan;
import org.junit.Before;
import org.junit.Test;

/**
 * MyIoCTest
 *
 * @author ljh
 * created on 2019/10/29 15:43
 */
public class MyIoCTest {

    private IoCContainer ioCContainer = new IoCContainer();

    @Before
    public void before() {
        ioCContainer.setBean(Audi.class, "audi");
        ioCContainer.setBean(Buick.class, "buick");
        ioCContainer.setBean(ZhangShan.class, "zhangshan", "audi");
        ioCContainer.setBean(LiSi.class, "lisi", "buick");
    }

    @Test
    public void test() {
        Human zhagnsan = (Human) ioCContainer.getBean("zhangshan");
        zhagnsan.goHome();
        Human lisi = (Human) ioCContainer.getBean("lisi");
        lisi.goHome();
    }
}
