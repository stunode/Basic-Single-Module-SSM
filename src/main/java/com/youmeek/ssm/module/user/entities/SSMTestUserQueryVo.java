package com.youmeek.ssm.module.user.entities;

import java.util.List;

/**
 * Created by Administrator on 2016/5/31.
 */
public class SSMTestUserQueryVo {
    //传入多个id
    private List<Integer> ids;


    //在这里包装所需要的查询条件

    //用户查询条件
    private SSMTestUserCustom userCustom;

    public SSMTestUserCustom getUserCustom() {
        return userCustom;
    }

    public void setUserCustom(SSMTestUserCustom userCustom) {
        this.userCustom = userCustom;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    //可以包装其它的查询条件，订单、商品
    //....
}
