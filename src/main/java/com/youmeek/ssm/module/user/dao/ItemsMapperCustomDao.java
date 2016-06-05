package com.youmeek.ssm.module.user.dao;

import com.youmeek.ssm.module.user.entities.ItemsCustom;
import com.youmeek.ssm.module.user.entities.ItemsQueryVo;

import java.util.List;

/**
 * Created by admin on 2016/6/4.
 */
public interface ItemsMapperCustomDao {
    public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo)throws Exception;
}
