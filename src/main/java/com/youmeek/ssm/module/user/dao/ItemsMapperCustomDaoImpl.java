package com.youmeek.ssm.module.user.dao;

import com.youmeek.ssm.module.user.entities.ItemsCustom;
import com.youmeek.ssm.module.user.entities.ItemsQueryVo;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

/**
 * Created by admin on 2016/6/4.
 */

//@Repository("itemsMapperCustom")
public class ItemsMapperCustomDaoImpl extends SqlSessionDaoSupport implements ItemsMapperCustomDao {

    @Override
    public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception {
        SqlSession sqlSession = this.getSqlSession();
        List<ItemsCustom> list = sqlSession.selectList("itemsMapperCustom.findItemsList",itemsQueryVo);
        return  list ;
    }
}
