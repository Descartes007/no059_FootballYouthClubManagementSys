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


import com.dao.XueyuanDao;
import com.entity.XueyuanEntity;
import com.service.XueyuanService;
import com.entity.vo.XueyuanVO;
import com.entity.view.XueyuanView;

@Service("xueyuanService")
public class XueyuanServiceImpl extends ServiceImpl<XueyuanDao, XueyuanEntity> implements XueyuanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XueyuanEntity> page = this.selectPage(
                new Query<XueyuanEntity>(params).getPage(),
                new EntityWrapper<XueyuanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XueyuanEntity> wrapper) {
		  Page<XueyuanView> page =new Query<XueyuanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<XueyuanVO> selectListVO(Wrapper<XueyuanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public XueyuanVO selectVO(Wrapper<XueyuanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<XueyuanView> selectListView(Wrapper<XueyuanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XueyuanView selectView(Wrapper<XueyuanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
