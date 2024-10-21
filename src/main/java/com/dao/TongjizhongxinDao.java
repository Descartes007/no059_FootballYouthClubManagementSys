package com.dao;

import com.entity.TongjizhongxinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.TongjizhongxinVO;
import com.entity.view.TongjizhongxinView;


/**
 * 统计中心
 * 
 * @author 
 * @email 
 * @date 2021-04-14 06:54:13
 */
public interface TongjizhongxinDao extends BaseMapper<TongjizhongxinEntity> {
	
	List<TongjizhongxinVO> selectListVO(@Param("ew") Wrapper<TongjizhongxinEntity> wrapper);
	
	TongjizhongxinVO selectVO(@Param("ew") Wrapper<TongjizhongxinEntity> wrapper);
	
	List<TongjizhongxinView> selectListView(@Param("ew") Wrapper<TongjizhongxinEntity> wrapper);

	List<TongjizhongxinView> selectListView(Pagination page,@Param("ew") Wrapper<TongjizhongxinEntity> wrapper);
	
	TongjizhongxinView selectView(@Param("ew") Wrapper<TongjizhongxinEntity> wrapper);
	
}
