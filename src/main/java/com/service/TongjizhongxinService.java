package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.TongjizhongxinEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.TongjizhongxinVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.TongjizhongxinView;


/**
 * 统计中心
 *
 * @author 
 * @email 
 * @date 2021-04-14 06:54:13
 */
public interface TongjizhongxinService extends IService<TongjizhongxinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<TongjizhongxinVO> selectListVO(Wrapper<TongjizhongxinEntity> wrapper);
   	
   	TongjizhongxinVO selectVO(@Param("ew") Wrapper<TongjizhongxinEntity> wrapper);
   	
   	List<TongjizhongxinView> selectListView(Wrapper<TongjizhongxinEntity> wrapper);
   	
   	TongjizhongxinView selectView(@Param("ew") Wrapper<TongjizhongxinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<TongjizhongxinEntity> wrapper);
   	
}

