package com.ljh.annotation.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * AnotherBean
 *
 * @author ljh
 * created on 2019/10/31 14:17
 */
@Component
@Scope("prototype")
public class AnotherBean {
}
