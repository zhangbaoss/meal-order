package com.zhangbao.handler;

import com.zhangbao.feign.UserFeign;
import com.zhangbao.pojo.UserPoJo;
import com.zhangbao.vo.PoJoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description TODO
 * @Author zhangbao
 * @Date 2019/11/13 9:27
 * @Version 1.0
 **/
@RestController
@RequestMapping("/user")
public class UserHandler {

    @Autowired
    private UserFeign userFeign;

    /**
     * 查询所有菜单和菜品类型
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/list")
    public PoJoVo<UserPoJo> list(@RequestParam("page") int page, @RequestParam("limit") int limit) {
        int pageNum = (page - 1) * limit;
        return userFeign.list(pageNum, limit);
    }

    @PostMapping("/post")
    public PoJoVo<Void> post(@RequestBody UserPoJo userPoJo) {
        return userFeign.post(userPoJo);
    }

    @GetMapping("/get/{id}")
    public PoJoVo<UserPoJo> get(@PathVariable("id") long id) {
        return userFeign.get(id);
    }

    @PutMapping("/put")
    public PoJoVo<Void> put(@RequestBody UserPoJo userPoJo) {
        return userFeign.put(userPoJo);
    }

    @DeleteMapping("/delete/{id}")
    public PoJoVo<Void> delete(@PathVariable("id") long id) {
        return userFeign.delete(id);
    }
}
