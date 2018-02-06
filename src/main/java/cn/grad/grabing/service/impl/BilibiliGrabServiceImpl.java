package cn.grad.grabing.service.impl;

import cn.grad.grabing.helper.BilibiliDocumentInitailizer;
import cn.grad.grabing.util.StrPropertiesMapper;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebRequest;
import org.jsoup.Connection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.grad.grabing.service.BiliBiliGrabService;
import cn.grad.grabing.util.BaseUtil;

import javax.annotation.Resource;

@Service("bilibiliGrabServiceImpl")
public class BilibiliGrabServiceImpl extends BaseUtil implements BiliBiliGrabService {

	private final String configuationPath = StrPropertiesMapper.CONFIGURATION_BASE_PATH + StrPropertiesMapper.BILIBILI
			+ ".properties";
	@Autowired
	private BilibiliDocumentInitailizer bilibiliDocumentInitailizer;
	@Resource(name="bilibiliWebClient")
	private WebClient webClient;
	@Resource(name="bilibiliWebRequest")
	private WebRequest webRequest;

	/**
	 * b站爬虫入口
	 */
	@Override
	public void beginGrabing(Connection jsoupConn) {
		initializer(jsoupConn);
		grabbing();
	}

	/**
	 * 开始抓取信息
	 */
	private void grabbing(){

	}
	/**
	 * 初始化
	 *
	 * @param jsoupConn
	 */
	private void initializer(Connection jsoupConn){
		//jsoup
		bilibiliDocumentInitailizer.analizeConfigurationAndUseInConn(jsoupConn);
		this.setConn(jsoupConn);
		//htmlunit
		bilibiliDocumentInitailizer.initWebClient(webClient);
		try {
			bilibiliDocumentInitailizer.initWebRequest(webRequest);
		}catch (Exception e){
			e.printStackTrace();
			log.error("fail to init webRequest in bilibili initializer nest exception is :"+e);
		}
	}

}
