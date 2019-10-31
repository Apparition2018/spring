package com.ljh.xml.attr.inherit;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Son2
 *
 * @author ljh
 * created on 2019/10/31 11:18
 */
@Getter
@Setter
@ToString(callSuper = true)
public class Son2 extends Parent {

    private String attr6;
    private String attr7;
}
