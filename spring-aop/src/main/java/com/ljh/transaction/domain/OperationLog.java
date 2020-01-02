package com.ljh.transaction.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * OperationLog
 *
 * @author Arsenal
 * created on 2020/1/2 17:51
 */
@Entity
@Getter
@Setter
public class OperationLog {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String content;
    
    private Date createAt;
}
