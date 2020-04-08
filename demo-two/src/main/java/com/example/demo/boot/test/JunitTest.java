package com.example.demo.boot.test;

import com.example.demo.boot.uitls.DocxUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: JunitTest <br>
 * @date: 2020/3/30 14:11 <br>
 * @author: PWB <br>
 * @since: 1.0 <br>
 */
@Slf4j
public class JunitTest {

    String encodeUrl = "redirectUrl=http%3A%2F%2Fwebdev.twoshop.com.cn%2F%23%2FliveRoom%3FparentId%3D18780129465%26anchorId%3D5%26id%3D0%26roomId%3D3%26sceneId%3D188";

    @Test
    public void testDecode() throws UnsupportedEncodingException {
        encodeUrl = URLDecoder.decode(encodeUrl, "utf-8");
        log.info(encodeUrl);
    }

    @Test
    public void testDocx() throws IOException {
        InputStream is = new FileInputStream("D:\\var\\contract\\20200408\\contract_1.docx");
        Map<String, Object> params = new HashMap<>(1);
        params.put("contractNo", "20200408110599");
        DocxUtils.docxContentChange(is, params);
    }

}
