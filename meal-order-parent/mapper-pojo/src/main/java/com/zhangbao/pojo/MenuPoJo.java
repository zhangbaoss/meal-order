package com.zhangbao.pojo;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author zhangbao
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "t_menu")
public class MenuPoJo implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Double price;
    /**风味*/
    private String flavor;
    /**类型id, TODO 如果是基本类型,通用mapper不会映射*/
    private Integer tid;
}