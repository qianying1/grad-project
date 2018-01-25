package cn.grad.grabing.service;

import org.jsoup.Connection;

public interface AcfunGrabService{


	void beginGrabing();

	void initBeforeGrabing(String targetValue);

	void initJsoupDocumentConnection(Connection connection);
}
