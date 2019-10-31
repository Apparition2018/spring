package com.ljh.annotation.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * TestBean
 *
 * @author ljh
 * created on 2019/10/31 14:07
 */
@Component("testBean2")
@Scope("myScope")
public class TestBean {
}
