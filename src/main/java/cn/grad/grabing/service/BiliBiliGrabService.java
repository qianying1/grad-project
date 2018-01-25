package cn.grad.grabing.service;

import org.jsoup.Connection;

public interface BiliBiliGrabService {

	void beginGrabing();

	Connection initBeforeGrabing(String targetValue);

}
