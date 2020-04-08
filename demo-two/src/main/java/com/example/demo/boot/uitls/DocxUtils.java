package com.example.demo.boot.uitls;


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/*import org.apache.poi.xwpf.converter.core.XWPFConverterException;
import org.apache.poi.xwpf.converter.pdf.PdfConverter;
import org.apache.poi.xwpf.converter.pdf.PdfOptions;*/

/**
 * @description: DocxUtils <br>
 * @date: 2020/4/8 9:50 <br>
 * @author: PWB <br>
 * @since: 1.0 <br>
 */
@Slf4j
public class DocxUtils {

    public static final String TEMPLATE_PATH = "template";


    public static byte[] getContractZip(String templateName, Map<String, Object> model, Boolean isToShop) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ZipOutputStream zip = new ZipOutputStream(outputStream);
        String fileName = templateName.substring(0, templateName.lastIndexOf("."));
        fileName = TEMPLATE_PATH + "/" + templateName;
        InputStream inputStream = DocxUtils.class.getClassLoader().getResourceAsStream(fileName);
        try {
            byte[] dox = docxContentChange(inputStream, model);
            // 添加到zip

            if (isToShop) {
                fileName = "兔店合作协议商务条款-到店HLW20200327.docx";
            } else {
                fileName = "兔店合作协议商务条款-包邮HLW20200327.docx";
            }
            zip.putNextEntry(new ZipEntry(fileName));
            zip.write(dox);
            for (int i = 0; i < 2; i++) {
                int j = i + 1;
                fileName = "兔店合作协议通用条款HLW20200327（" + j + "）.jpg";
                String filePath = TEMPLATE_PATH + "/images/freeShipping/" + fileName;
                if (isToShop) {
                    filePath = filePath.replaceAll("freeShipping", "toShop");
                }
                log.info("合同路径file Path：{}", filePath);
                zip.putNextEntry(new ZipEntry(fileName));
                inputStream = DocxUtils.class.getClassLoader().getResourceAsStream(filePath);
                if (inputStream == null) {
                    log.info("获取资源文件为null");
                }
                // 该变量记录每次真正读的字节个数
                int len;
                // 定义每次读取的字节数组
                byte[] buffer = new byte[1024];
                while ((len = inputStream.read(buffer)) > 0) {
                    zip.write(buffer, 0, len);
                }
                inputStream.close();
            }
            zip.closeEntry();
            zip.flush();
        } catch (Exception e) {
            log.info("获取资源文件异常 原因：{}", e.getMessage());
        } finally {
            IOUtils.closeQuietly(zip);
        }
        return outputStream.toByteArray();
    }

    /**
     * @param is     doc文档模板 <br>
     * @param params key value 将模板里的可以替换为响应VALUE <br>
     * @return byte[] <br>
     * @description: doc内容改变 <br>
     * @since: 1.0 <br>
     * @date: 2020/4/8 10:40 <br>
     * @author: PWB <br>
     */
    public static byte[] docContentChange(InputStream is, Map<String, Object> params) throws IOException {
        HWPFDocument document = new HWPFDocument(is);
        Range range = document.getRange();

        Set<String> keys = params.keySet();
        for (String key : keys) {
            range.replaceText("{{" + key + "}}", String.valueOf(params.get(key)));
        }

        OutputStream os = new FileOutputStream("D:\\var\\contract_1.docx");
        //把doc输出到输出流中
        document.write(os);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        document.write(baos);
        byte[] bytes = baos.toByteArray();
        document.close();
        baos.close();
        return bytes;
    }

    /**
     * @param is     docx文档模板 <br>
     * @param params key value 将模板里的可以替换为响应VALUE <br>
     * @return byte[] <br>
     * @description: docx内容改变 <br>
     * @since: 1.0 <br>
     * @date: 2020/4/8 10:40 <br>
     * @author: PWB <br>
     */
    public static byte[] docxContentChange(InputStream is, Map<String, Object> params) throws IOException {
        XWPFDocument document = new XWPFDocument(is);
        List<XWPFParagraph> list = document.getParagraphs();
        for (XWPFParagraph paragraph : list) {
            String regex = "(\\w|\\W)*\\{\\{\\w+}}(\\w|\\W)*";//{{string}}匹配
            if (!paragraph.getText().matches(regex)) {
                continue;
            }
            List<XWPFRun> runs = paragraph.getRuns();
            loop:
            for (XWPFRun run : runs) {
                if (!run.text().matches(regex)) {
                    continue;
                }
                if (null == params || params.keySet().size() < 1) {
                    run.setText("", 0);
                    continue;
                }
                Set<String> keySet = params.keySet();
                for (String key : keySet) {
                    if (run.text().contains(key)) {
                        String text = run.text().replaceAll(getReplaceAllKey("{{" + key.toString() + "}}"), String.valueOf(params.get(key)));
                        run.setText(text, 0);
                        continue loop;
                    }
                }
                run.setText("", 0);
            }
        }
        OutputStream os = new FileOutputStream("D:\\var\\contract_1.docx");
        //把doc输出到输出流中
        document.write(os);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        document.write(baos);
        byte[] bytes = baos.toByteArray();
        document.close();
        baos.close();
        return bytes;
    }


    /**
     * @param is     docx文档模板 <br>
     * @param params key value 将模板里的可以替换为响应VALUE <br>
     * @return byte[] <br>
     * @description: docx内容改变 <br>
     * @since: 1.0 <br>
     * @date: 2020/4/8 10:40 <br>
     * @author: PWB <br>
     */
    public static byte[] docxContentChangeTypeTwo(InputStream is, Map<String, String> params) throws IOException {
        XWPFDocument document = new XWPFDocument(is);
        // 替换段落中的指定文字
        Iterator<XWPFParagraph> itPara = document.getParagraphsIterator();
        while (itPara.hasNext()) {
            XWPFParagraph paragraph = itPara.next();
            List<XWPFRun> runs = paragraph.getRuns();
            for (XWPFRun run : runs) {
                String oneparaString = run.getText(run.getTextPosition());
                if (StringUtils.isBlank(oneparaString)) {
                    continue;
                }
                for (Map.Entry<String, String> entry : params.entrySet()) {
                    oneparaString = oneparaString.replace("{{" + entry.getKey() + "}}", entry.getValue());
                }
                run.setText(oneparaString, 0);
            }
        }
        OutputStream os = new FileOutputStream("D:\\var\\contract_1.docx");
        //把doc输出到输出流中
        document.write(os);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        document.write(baos);
        byte[] bytes = baos.toByteArray();
        document.close();
        baos.close();
        return bytes;
    }


    /**
     * <br>描 述:    将docx字节数组流转换为pdf字节数组流
     * <br>作 者: shizhenwei
     * <br>历 史: (版本) 作者 时间 注释
     * @param docxBytes docx文档字节数组
     * @return
     * @throws IOException
     * 注：需在部署系统安装word对应的中文字体
     */
   /* public static byte[] docx2pdf(byte[] docxBytes) throws XWPFConverterException, IOException{
        PdfOptions options = PdfOptions.create();
        XWPFDocument document = new XWPFDocument(new ByteArrayInputStream(docxBytes));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfConverter.getInstance().convert(document, baos, options);
        return baos.toByteArray();
    }*/


    /**
     * <br>描 述:    将Word模板流改变内容后转换为pdf字节数组流
     * <br>作 者: shizhenwei
     * <br>历 史: (版本) 作者 时间 注释
     * @param is docx文档输入流
     * @param params key value 将模板里的可以替换为响应VALUE
     * @return
     * @throws IOException
     * * 注：需在部署系统安装word对应的中文字体
     */
    /*public static byte[] docx2pdf(InputStream is,Map<String, String> params) throws XWPFConverterException, IOException{
        XWPFDocument document = new XWPFDocument(is);
        List<XWPFParagraph> list = document.getParagraphs();
        for(XWPFParagraph paragraph : list){
            String regex = "(\\w|\\W)*\\{\\{\\w+\\}\\}(\\w|\\W)*";//{{string}}匹配
            if(!paragraph.getText().matches(regex)){
                continue;
            }
            List<XWPFRun> runs = paragraph.getRuns();
            for(int i=0; i<runs.size(); i++){
                XWPFRun run = runs.get(i);
                if(!run.text().matches(regex)){
                    continue;
                }
                Set<String> keySet = params.keySet();
                for(String key : keySet){
                    key = "{{"+key+"}}";
                    if(run.text().contains(key)){
                        String text = run.text().replaceAll(getReplaceAllKey(key), params.get(key));
                        run.setText(text,0);
                    }
                }
            }
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfOptions options = PdfOptions.create();
        PdfConverter.getInstance().convert(document, baos, options);
        byte[] bytes = baos.toByteArray();
        document.close();
        baos.close();
        return bytes;
    }*/

    /**
     * @param key <br>
     * @return java.lang.String <br>
     * @description: String replaceAll方法默认正则 {{}} 对特殊字符进行转义,如 {} == \\{\\} <br>
     * @since: 1.0 <br>
     * @date: 2020/4/8 11:29 <br>
     * @author: PWB <br>
     */
    public static String getReplaceAllKey(String key) {
        StringBuilder afterKey = new StringBuilder();
        for (int i = 0; i < key.length(); i++) {
            if ('{' == key.charAt(i)) {
                afterKey.append("\\{");
            } else if ('}' == key.charAt(i)) {
                afterKey.append("\\}");
            } else {
                afterKey.append(key.charAt(i));
            }
        }
        return afterKey.toString();
    }
}
