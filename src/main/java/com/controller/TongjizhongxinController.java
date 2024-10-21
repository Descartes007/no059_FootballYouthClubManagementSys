package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.TongjizhongxinEntity;
import com.entity.view.TongjizhongxinView;

import com.service.TongjizhongxinService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 统计中心
 * 后端接口
 * @author 
 * @email 
 * @date 2021-04-14 06:54:13
 */
@RestController
@RequestMapping("/tongjizhongxin")
public class TongjizhongxinController {
    @Autowired
    private TongjizhongxinService tongjizhongxinService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,TongjizhongxinEntity tongjizhongxin,
		HttpServletRequest request){
        EntityWrapper<TongjizhongxinEntity> ew = new EntityWrapper<TongjizhongxinEntity>();
		PageUtils page = tongjizhongxinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tongjizhongxin), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,TongjizhongxinEntity tongjizhongxin, HttpServletRequest request){
        EntityWrapper<TongjizhongxinEntity> ew = new EntityWrapper<TongjizhongxinEntity>();
		PageUtils page = tongjizhongxinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tongjizhongxin), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( TongjizhongxinEntity tongjizhongxin){
       	EntityWrapper<TongjizhongxinEntity> ew = new EntityWrapper<TongjizhongxinEntity>();
      	ew.allEq(MPUtil.allEQMapPre( tongjizhongxin, "tongjizhongxin")); 
        return R.ok().put("data", tongjizhongxinService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(TongjizhongxinEntity tongjizhongxin){
        EntityWrapper< TongjizhongxinEntity> ew = new EntityWrapper< TongjizhongxinEntity>();
 		ew.allEq(MPUtil.allEQMapPre( tongjizhongxin, "tongjizhongxin")); 
		TongjizhongxinView tongjizhongxinView =  tongjizhongxinService.selectView(ew);
		return R.ok("查询统计中心成功").put("data", tongjizhongxinView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        TongjizhongxinEntity tongjizhongxin = tongjizhongxinService.selectById(id);
        return R.ok().put("data", tongjizhongxin);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        TongjizhongxinEntity tongjizhongxin = tongjizhongxinService.selectById(id);
        return R.ok().put("data", tongjizhongxin);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody TongjizhongxinEntity tongjizhongxin, HttpServletRequest request){
    	tongjizhongxin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(tongjizhongxin);
        tongjizhongxinService.insert(tongjizhongxin);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody TongjizhongxinEntity tongjizhongxin, HttpServletRequest request){
    	tongjizhongxin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(tongjizhongxin);
        tongjizhongxinService.insert(tongjizhongxin);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody TongjizhongxinEntity tongjizhongxin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(tongjizhongxin);
        tongjizhongxinService.updateById(tongjizhongxin);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        tongjizhongxinService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<TongjizhongxinEntity> wrapper = new EntityWrapper<TongjizhongxinEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = tongjizhongxinService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
