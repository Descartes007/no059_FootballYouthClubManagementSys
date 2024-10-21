package com.dao;

import com.entity.KechengqiandaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.KechengqiandaoVO;
import com.entity.view.KechengqiandaoView;


/**
 * 课程签到
 * 
 * @author 
 * @email 
 * @date 2021-04-14 06:54:13
 */
public interface KechengqiandaoDao extends BaseMapper<KechengqiandaoEntity> {
	
	List<KechengqiandaoVO> selectListVO(@Param("ew") Wrapper<KechengqiandaoEntity> wrapper);
	
	KechengqiandaoVO selectVO(@Param("ew") Wrapper<KechengqiandaoEntity> wrapper);
	
	List<KechengqiandaoView> selectListView(@Param("ew") Wrapper<KechengqiandaoEntity> wrapper);

	List<KechengqiandaoView> selectListView(Pagination page,@Param("ew") Wrapper<KechengqiandaoEntity> wrapper);
	
	KechengqiandaoView selectView(@Param("ew") Wrapper<KechengqiandaoEntity> wrapper);
	
}
