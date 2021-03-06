package com.cjt.trade.controller.backend.mall;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.cjt.trade.controller.BaseController;
import com.cjt.trade.dto.BaseDto;
import com.cjt.trade.model.MapModel;
import com.cjt.trade.model.Trade;
import com.cjt.trade.service.ITradeService;
import com.cjt.trade.util.JSONUtil;
import com.cjt.trade.vo.TradeVo;

/**
 * @author wulitaotao
 * @date 2017年1月3日
 * @subscription 商品行业
 */
@Controller
@RequestMapping(value = "/backend/")
public class TradeController extends BaseController {

	@Resource
	private ITradeService tradeService;
	
	@RequestMapping(value = "/tradeList.action")
	public String tradeList() {
		return "backend/mall/tradeList";
	}

	@RequestMapping(value = "getAllTrades.action")
	@ResponseBody
	public JSONObject getAllTrades(int page, int rows, BaseDto dto) {
		dto.setStart((page - 1) * rows);
		dto.setLimit(rows);
		List<TradeVo> vos = tradeService.getAllTrades(dto);
		int count = tradeService.getAllTradesCount(dto);
		return JSONUtil.toGridJson(vos, count);
	}
	
	/**
	 * 获取所有“商品行业”下拉框选项，自动封装为json
	 */
	@RequestMapping(value = "getAllTradesOpt.action")
	@ResponseBody
	public List<MapModel> getAllTradesOpt(){
		return tradeService.getAllTradesOpt();
	}
	
	@RequestMapping(value = "addTrade.action")
	public String addTrade(Trade trade, Model model) {
		int lines = tradeService.insertTrade(trade);
		if (lines > 0) {
			model.addAttribute("returnUrl", "tradeAdd.action");
			return "success";
		}
		return "ERROR";
	}
	
	@RequestMapping(value = "updateTrade.action")
	public String updateTrade(Trade trade, Model model){
		int lines = tradeService.updateTrade(trade);
		if (lines > 0) {
			return tradeList();
		}
		return "ERROR";
	}

	@RequestMapping(value = "tradeAdd.action")
	public String tradeAdd() {
		return "backend/mall/tradeAdd";
	}

	@RequestMapping(value = "getTradeById.action")
	@ResponseBody
	public Trade getTradeById(int id) {
		return tradeService.getTradeById(id);
	}

	@RequestMapping(value = "deleteTradeById.action")
	@ResponseBody
	public boolean deleteTradeById(int id) {
		int lines = tradeService.deleteTrade(id);
		return lines > 0;
	}
}
