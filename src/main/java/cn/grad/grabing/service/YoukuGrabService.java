package cn.grad.grabing.service;

public interface YoukuGrabService {

    /**
     * 开始对目标地址进行数据抓取
     */
    void beginGrabing();

    void initBeforeGrabing(String targetValue);
}
