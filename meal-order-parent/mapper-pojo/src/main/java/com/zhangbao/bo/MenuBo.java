package com.zhangbao.bo;

import com.zhangbao.pojo.MenuPoJo;
import com.zhangbao.pojo.TypePoJo;
import lombok.*;

import java.io.Serializable;

/**
 * @Description TODO
 * @Author zhangbao
 * @Date 2019/11/13 13:39
 * @Version 1.0
 **/
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MenuBo extends MenuPoJo implements Serializable {
    private TypePoJo type;
}
