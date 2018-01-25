package cn.grad.grabing.service.impl;

import cn.grad.grabing.util.StrPropertiesMapper;
import org.springframework.stereotype.Service;

import cn.grad.grabing.service.BiliBiliGrabService;
import cn.grad.grabing.util.BaseUtil;

@Service("bilibiliGrabServiceImpl")
public class BilibiliGrabServiceImpl extends BaseUtil implements BiliBiliGrabService {

	private final String configuationPath = StrPropertiesMapper.CONFIGURATION_BASE_PATH + StrPropertiesMapper.BILIBILI
			+ ".properties";
	/**
	 * b站爬虫入口
	 */
	@Override
	public void beginGrabing() {
		
	}

}
