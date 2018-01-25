package cn.grad.grabing.util;

import cn.grad.grabing.helper.AcfunDocumentInitailizer;
import cn.grad.grabing.helper.DocumentInitailizer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dozer.Mapper;
import org.jsoup.Connection;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class BaseUtil<T extends Class> extends BaseLogger {

    @Autowired
    protected Mapper dozer;
    @Autowired
    private DocumentInitailizer documentInitailizer;

    private String seedUri;
    //	private Properties grabingConfiguations;
    private Document doc;

    /**
     * 开始进行数据抓取前进行参数初始化
     *
     * @param targetUri
     */
    public Connection initBeforeGrabing(String targetUri) {
        if (Validation.isStringNull(targetUri)) {
            log.error("the target url can`t be null!");
            return null;
        }
        this.seedUri = targetUri;
//		PropertiesIO io = new PropertiesIO();
//		grabingConfiguations = io.initConnector(configuationPath);
        Connection conn = documentInitailizer.initConnectionByUrl(this.seedUri);
        if (!Validation.isObjNull(conn))
            this.doc = documentInitailizer.getDocumentByConn(conn);
        else
            log.error("could`t gettig html document from url: " + this.seedUri);
        return conn;
    }

    public void grabingFromReptile(String targetWebName) {
        switch (targetWebName) {
            case StrPropertiesMapper.ACFUN:
                break;
            case StrPropertiesMapper.BILIBILI:
                break;
            case StrPropertiesMapper.DOUYU:
                break;
            case StrPropertiesMapper.IQIYI:
                break;
            case StrPropertiesMapper.LETV:
                break;
            case StrPropertiesMapper.PPTV:
                break;
            case StrPropertiesMapper.SOHU:
                break;
            case StrPropertiesMapper.TUDOU:
                break;
            case StrPropertiesMapper.YOUKU:
                break;
            default:
                break;
        }
    }

    public void beginGrabing() {
    }

    public Document getDoc() {
        return doc;
    }

    public void setDoc(Document doc) {
        this.doc = doc;
    }

    public String getSeedUri() {
        return seedUri;
    }

    public void setSeedUri(String seedUri) {
        this.seedUri = seedUri;
    }
}
