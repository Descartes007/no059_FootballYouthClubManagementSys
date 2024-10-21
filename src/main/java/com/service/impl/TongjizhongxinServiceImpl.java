package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.TongjizhongxinDao;
import com.entity.TongjizhongxinEntity;
import com.service.TongjizhongxinService;
import com.entity.vo.TongjizhongxinVO;
import com.entity.view.TongjizhongxinView;

@Service("tongjizhongxinService")
public class TongjizhongxinServiceImpl extends ServiceImpl<TongjizhongxinDao, TongjizhongxinEntity> implements TongjizhongxinService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TongjizhongxinEntity> page = this.selectPage(
                new Query<TongjizhongxinEntity>(params).getPage(),
                new EntityWrapper<TongjizhongxinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<TongjizhongxinEntity> wrapper) {
		  Page<TongjizhongxinView> page =new Query<TongjizhongxinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<TongjizhongxinVO> selectListVO(Wrapper<TongjizhongxinEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public TongjizhongxinVO selectVO(Wrapper<TongjizhongxinEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<TongjizhongxinView> selectListView(Wrapper<TongjizhongxinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public TongjizhongxinView selectView(Wrapper<TongjizhongxinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
