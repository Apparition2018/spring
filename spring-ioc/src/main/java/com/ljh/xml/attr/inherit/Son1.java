package com.ljh.xml.attr.inherit;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Son1
 *
 * @author ljh
 * created on 2019/10/31 11:18
 */
@Getter
@Setter
@ToString(callSuper = true)
public class Son1 extends Parent {

    private String attr4;
    private String attr5;
}
