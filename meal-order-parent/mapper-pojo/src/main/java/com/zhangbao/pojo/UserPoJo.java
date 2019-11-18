package com.zhangbao.pojo;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Description TODO
 * @Author zhangbao
 * @Date 2019/11/15 13:36
 * @Version 1.0
 **/
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "t_user")
public class UserPoJo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;
    private String nickname;
    private String gender;
    private String telephone;
    @Column(name = "register_date")
    private Date registerDate;
    private String address;
}
