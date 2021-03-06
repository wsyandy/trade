package com.cjt.trade.service;

import java.util.List;

import com.cjt.trade.dto.BaseDto;
import com.cjt.trade.model.Goods;
import com.cjt.trade.vo.GoodsVo;

public interface IGoodsService {

	public int insertGoods(Goods product);
	
	public int deleteGoods(int id);
	
	public List<GoodsVo> getAllGoods(BaseDto dto);
	public int getAllGoodsCount(BaseDto dto);
	
	public Goods getGoodsById(int id);
	
	public int updateGoods(Goods product);
	
	/**
	 * 获取首页滚动商品
	 */
	public List<Goods> getScrollGoods();
	
	/**
	 * 获取首页热卖商品
	 */
	public List<Goods> getHotGoods();
}
