package com.ljh.object;

import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Admin
 *
 * @author ljh
 * created on 2019/10/28 17:03
 */
@Data
@XmlRootElement(name = "admin")
public class Admin {
    @XmlElement(name = "name")
    private String name;
    @XmlElement(name = "age")
    private String age;
}
