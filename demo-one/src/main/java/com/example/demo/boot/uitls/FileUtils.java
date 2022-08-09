package com.example.demo.boot.uitls;


import com.example.demo.boot.core.Constants;
import com.example.demo.boot.core.SnowflakeIdWorker;
import com.example.demo.boot.restful.CommonException;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 创建临时文件 <br>
 * @date: 2020/10/21 10:49 <br>
 * @author: PWB <br>
 * @since: 1.0 <br>
 */
public class FileUtils {

    private static final Logger log = LoggerFactory.getLogger(FileUtils.class);

    public static byte[] toByteArray(InputStream in) throws IOException {

        return getBytes(in);
    }

    private static byte[] getBytes(InputStream in) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024 * 4];
        int n;
        while ((n = in.read(buffer)) != -1) {
            out.write(buffer, 0, n);
        }
        return out.toByteArray();
    }

    /**
     * 网络文件转换为byte二进制
     */
    public static byte[] toByteArray(String urlStr) throws IOException {
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        DataInputStream in = new DataInputStream(conn.getInputStream());
        return getBytes(in);
    }

    /**
     * @param urlStr 网络文件路径 <br>
     * @param bdUrl  临时文件路径 <br>
     * @description: 获取网络文件，暂存为临时文件 <br>
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
     */
    public static String getMd5ByUrl(String urlStr) {
        String md5;
        try {
            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            DataInputStream in = new DataInputStream(conn.getInputStream());
            md5 = DigestUtils.md5Hex(String.valueOf(in));
        } catch (IOException e) {
            throw new CommonException("直接获取网络文件的md5值异常", e.getCause());
        }
        return md5;
    }

    /**
     * 获取网络文件的输入流
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
            FileUtils.toBDFile(url, tmpFile.getCanonicalPath());
        } catch (IOException e) {
            throw new CommonException("获取网络文件，暂存为临时文件 异常", e.getCause());
        }
        return tmpFile;
    }

    public static Long getVideoDuration(String fileUrl) {
 /*       if (StringUtils.isEmpty(fileUrl)) {
            return null;
        }
        try {
            URL source = new URL(fileUrl);
            MultimediaObject instance = new MultimediaObject(source);
            MultimediaInfo result = instance.getInfo();
            return result.getDuration();
        } catch (EncoderException | MalformedURLException e) {
            throw new CommonException("获取视频时长异常", e);
        }*/
        return 0L;
    }

    public static String transformBase64Image(String base64Image, String path, String fileName) {
        if (base64Image == null || base64Image.trim().length() < 1) {
            return null;
        }
        try {
            Path directory = Paths.get(path);
            if (!Files.exists(directory)) {
                Files.createDirectories(directory);
            }
            Base64.Decoder decoder = Base64.getDecoder();
            byte[] bytes = decoder.decode(base64Image);
            for (int i = 0; i < bytes.length; ++i) {
                if (bytes[i] < 0) {// 调整异常数据
                    bytes[i] += 256;
                }
            }
            path = path.concat(fileName);
            OutputStream out = new FileOutputStream(path);
            out.write(bytes);
            out.flush();
            out.close();
        } catch (Exception e) {
            log.info(e.getMessage());
            return null;
        }
        return path;
    }


    public static String saveByCopy(String filePath, MultipartFile file) throws IOException {
        String filename = getFileName(file.getOriginalFilename() + "");
        Path directory = Paths.get(filePath);
        if (!Files.exists(directory)) {
            Files.createDirectories(directory);
        }
        InputStream inputStream = file.getInputStream();
        long copy = Files.copy(inputStream, directory.resolve(filename));
        return filePath.concat("/").concat(filename);
    }


    public static String saveByCopy(MultipartFile file) throws IOException {
        String filePath = FileUtils.getDirectory(Constants.UPLOAD_OTHER);
        return saveByCopy(filePath, file);
    }

    public static List<String> saveFiles(MultipartFile[] files, String httpUrl) throws IOException {
        log.debug("files ={}", files.length);
        String filePath = FileUtils.getDirectory(Constants.UPLOAD_IMAGE);
        String filename;
        List<String> list = new LinkedList<>();
        for (MultipartFile file : files) {
            filename = FileUtils.getFileName(file.getOriginalFilename() + "");
            Path directory = Paths.get(filePath);
            if (!Files.exists(directory)) {
                Files.createDirectories(directory);
            }
            InputStream inputStream = file.getInputStream();
            Files.copy(inputStream, directory.resolve(filename));
            list.add(httpUrl.concat(filePath).concat("/").concat(filename));
        }
        log.debug("listFiles ={}", list);
        return list;
    }


    public static String saveByTransferTo(String filePath, MultipartFile file) throws IOException {
        String filename = getFileName(file.getOriginalFilename() + "");
        File fileSave = new File(filePath);
        if (!fileSave.exists()) {
            fileSave.mkdir();
        }
        fileSave = new File(filePath, filename);
        file.transferTo(fileSave);
        return filePath.concat("/").concat(filename);
    }

    public static String getDirectory(String basePath) {
        return basePath.concat(DateUtils.parseDateToStr("yyyyMMdd", new Date()));
    }

    public static String getFileName(String fileName) {
        log.info(fileName);
        String suffix = "";
        if (StringUtils.isNotEmpty(fileName)) {
            if (fileName.contains(".")) {
                String[] arr = fileName.split("\\.");
                if (arr.length > 1) {
                    suffix = arr[arr.length - 1];
                }
            }
        }
        if (StringUtils.isNotEmpty(suffix)) {
            return SnowflakeIdWorker.getSnowId() + "." + suffix;
        }
        return SnowflakeIdWorker.getSnowId() + ".tmp";
    }

}
