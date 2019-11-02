package com.xyz.java.base.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author gxg
 * @date 2019/10/22 11:37
 * @description Http工具类
 */
public class HttpUtils {

    public static final String GET = "GET";
    public static final String POST = "POST";
    public static final String DEFAULT_CHARSET = "UTF-8";

    /**
     * 默认连接超时时间
     */
    public static final int DEFAULT_CONNECT_TIMEOUT = 5000;

    /**
     * 默认读取数据超时时间
     */
    public static final int DEFAULT_READ_TIMEOUT = 5000;


    private HttpUtils() {}

    /**
     * http GET 请求
     *
     * @param httpUrl
     * @return
     */
    public static String sendGetRequest(String httpUrl) {
        return sendGetRequest(httpUrl,DEFAULT_CONNECT_TIMEOUT);
    }

    /**
     * http GET 请求
     * @param httpUrl
     * @param connectTimeout
     * @return
     */
    public static String sendGetRequest(String httpUrl, int connectTimeout) {

        HttpURLConnection connection = null;
        InputStream inputStream = null;
        BufferedReader reader = null;
        String result = null;

        try {
            connection = createHttpURLConnection(httpUrl);
            connection.setRequestMethod(GET);
            connection.setConnectTimeout(connectTimeout);
            connection.setReadTimeout(DEFAULT_READ_TIMEOUT);
            connection.connect();

            inputStream = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(inputStream, DEFAULT_CHARSET));
            StringBuilder sbf = new StringBuilder();
            String temp = null;
            while ((temp = reader.readLine()) != null) {
                sbf.append(temp);
                sbf.append("\r\n");
            }
            result = sbf.toString();

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (null != reader) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != inputStream) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != connection) {
                connection.disconnect();
            }
        }
        return result;
    }


    public static String sendPostRequest(String httpUrl, String requestBody, int connectTimeout) {

        HttpURLConnection connection = null;
        BufferedReader reader = null;
        String result = null;

        try {
            connection = createHttpURLConnection(httpUrl);
            connection.setRequestMethod(POST);
            connection.setConnectTimeout(connectTimeout);
            connection.setReadTimeout(DEFAULT_READ_TIMEOUT);
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.connect();

            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), DEFAULT_CHARSET);
            out.append(requestBody);
            out.flush();
            out.close();

            reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), DEFAULT_CHARSET));

            StringBuilder sbf = new StringBuilder();
            String temp = null;
            while ((temp = reader.readLine()) != null) {
                sbf.append(temp);
                sbf.append("\r\n");
            }
            result = sbf.toString();


        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {

        }
        return result;

    }


    /**
     * 创建连接对象
     *
     * @param httpUrl
     * @return
     * @throws IOException
     */
    private static HttpURLConnection createHttpURLConnection(String httpUrl) throws IOException {
        URL url = new URL(httpUrl);
        return (HttpURLConnection) url.openConnection();
    }


    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        String result = sendGetRequest("http://www.du5555.com");
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(result);
    }

}
