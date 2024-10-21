package com.dao;

import com.entity.KechenganpaiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.KechenganpaiVO;
import com.entity.view.KechenganpaiView;


/**
 * 课程安排
 * 
 * @author 
 * @email 
 * @date 2021-04-14 06:54:13
 */
public interface KechenganpaiDao extends BaseMapper<KechenganpaiEntity> {
	
	List<KechenganpaiVO> selectListVO(@Param("ew") Wrapper<KechenganpaiEntity> wrapper);
	
	KechenganpaiVO selectVO(@Param("ew") Wrapper<KechenganpaiEntity> wrapper);
	
	List<KechenganpaiView> selectListView(@Param("ew") Wrapper<KechenganpaiEntity> wrapper);

	List<KechenganpaiView> selectListView(Pagination page,@Param("ew") Wrapper<KechenganpaiEntity> wrapper);
	
	KechenganpaiView selectView(@Param("ew") Wrapper<KechenganpaiEntity> wrapper);
	
}
