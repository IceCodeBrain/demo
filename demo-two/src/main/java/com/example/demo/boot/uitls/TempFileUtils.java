package com.example.demo.boot.uitls;

import com.example.demo.boot.restful.CommonException;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @description: Image2Binary <br>
 * @date: 2020/10/21 10:49 <br>
 * @author: PWB <br>
 * @since: 1.0 <br>
 */
public class TempFileUtils {

    private static Logger log = LoggerFactory.getLogger(TempFileUtils.class);

    public static byte[] toByteArray(InputStream in) throws IOException {

        return getBytes(in);
    }

    private static byte[] getBytes(InputStream in) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024 * 4];
        int n = 0;
        while ((n = in.read(buffer)) != -1) {
            out.write(buffer, 0, n);
        }
        return out.toByteArray();
    }

    /**
     * 网络文件转换为byte二进制
     *
     * @param @param  url
     * @param @return
     * @param @throws IOException    设定文件
     * @return byte[]    返回类型
     * @throws
     * @Title: toByteArray
     * @Description: TODO(这里用一句话描述这个方法的作用)
     */
    public static byte[] toByteArray(String urlStr) throws IOException {
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        DataInputStream in = new DataInputStream(conn.getInputStream());
        return getBytes(in);
    }

    /**
     * @param @param  url
     * @param @return
     * @param @throws IOException    设定文件
     * @return byte[]    返回类型
     * @throws IOException 网络文件转换为本地文件
     * @throws
     * @Title: toByteArray
     * @Description: TODO(这里用一句话描述这个方法的作用)
     */
    public static void toBDFile(String urlStr, String bdUrl) throws IOException {
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        DataInputStream in = new DataInputStream(conn.getInputStream());
        byte[] data = toByteArray(in);
        in.close();
        FileOutputStream out = new FileOutputStream(bdUrl);
        out.write(data);
        out.close();
    }

    /**
     * 直接获取网络文件的md5值
     *
     * @param urlStr
     * @return
     */
    public static String getMd5ByUrl(String urlStr) {
        String md5;
        try {
            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            DataInputStream in = new DataInputStream(conn.getInputStream());
            md5 = DigestUtils.md5Hex(in);
        } catch (IOException e) {
            throw new CommonException("直接获取网络文件的md5值异常", e.getCause());
        }
        return md5;
    }

    /**
     * 获取网络文件的输入流
     *
     * @param urlStr
     * @return
     */
    public static InputStream getInputStreamByUrl(String urlStr) {
        DataInputStream in = null;
        try {
            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            in = new DataInputStream(conn.getInputStream());
        } catch (IOException e) {
            throw new CommonException("获取网络文件的输入流 异常", e.getCause());
        }
        return in;
    }

    /**
     * 获取网络文件，暂存为临时文件
     */
    public static File createTempFile(String url) {
        File tmpFile;
        try {
            tmpFile = File.createTempFile("temp", ".tmp");
            TempFileUtils.toBDFile(url, tmpFile.getCanonicalPath());
        } catch (IOException e) {
            throw new CommonException("获取网络文件，暂存为临时文件 异常", e.getCause());
        }
        return tmpFile;
    }
}
