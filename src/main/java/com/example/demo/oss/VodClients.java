package com.example.demo.oss;

import com.alibaba.fastjson.JSONObject;
import com.aliyun.oss.OSSClient;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.FormatType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.vod.model.v20170321.CreateUploadVideoRequest;
import com.aliyuncs.vod.model.v20170321.CreateUploadVideoResponse;
import com.aliyuncs.vod.model.v20170321.RefreshUploadVideoRequest;
import com.aliyuncs.vod.model.v20170321.RefreshUploadVideoResponse;
import org.apache.commons.codec.binary.Base64;

import java.io.File;

/**
 * @version 1.0
 * @Description :
 * Copyright: Copyright (c)2019
 * Created Date : 2020/5/27
 */
public class VodClients {

    public static DefaultAcsClient initVodClient(String accessKeyId, String accessKeySecret) throws ClientException {
        // 根据点播接入服务所在的Region填写，例如：接入服务在上海，则填cn-shanghai；其他区域请参考文档[点播中心](~~98194~~)
        String regionId = "cn-shanghai";
        DefaultProfile profile = DefaultProfile.getProfile(regionId, accessKeyId, accessKeySecret);
        DefaultAcsClient client = new DefaultAcsClient(profile);
        return client;
    }

    public static CreateUploadVideoResponse createUploadVideo(DefaultAcsClient vodClient) throws ClientException
    {
        CreateUploadVideoRequest request = new CreateUploadVideoRequest();
        request.setFileName("vod_test.mp4");
        request.setTitle("this is title");
        //request.setDescription("this is desc");
        //request.setTags("tag1,tag2");
        //request.setCoverURL("http://vod.aliyun.com/test_cover_url.jpg");
        //request.setCateId(-1L);
        //request.setTemplateGroupId("");
        //request.setWorkflowId("");
        //request.setStorageLocation("");
        //request.setAppId("app-1000000");
        //设置请求超时时间
        request.setReadTimeout(1000);
        request.setConnectTimeout(1000);
        return vodClient.getAcsResponse(request);
    }

    public static OSSClient initOssClient(JSONObject uploadAuth, JSONObject uploadAddress) {
        String endpoint = uploadAddress.getString("Endpoint");
        String accessKeyId = uploadAuth.getString("AccessKeyId");
        String accessKeySecret = uploadAuth.getString("AccessKeySecret");
        String securityToken = uploadAuth.getString("SecurityToken");
        return new OSSClient(endpoint, accessKeyId, accessKeySecret, securityToken);
    }

    public static void uploadLocalFile(OSSClient ossClient, JSONObject uploadAddress, String localFile){
        String bucketName = uploadAddress.getString("Bucket");
        String objectName = uploadAddress.getString("FileName");
        File file = new File(localFile);
        ossClient.putObject(bucketName, objectName, file);
    }

    public static RefreshUploadVideoResponse refreshUploadVideo(DefaultAcsClient vodClient) throws ClientException {
        RefreshUploadVideoRequest request = new RefreshUploadVideoRequest();
        request.setAcceptFormat(FormatType.JSON);
        request.setVideoId("VideoId");
        //设置请求超时时间
        request.setReadTimeout(1000);
        request.setConnectTimeout(1000);
        return vodClient.getAcsResponse(request);
    }

    public static String decodeBase64(String s) {
        byte[] b = null;
        String result = null;
        if (s != null) {
            Base64 decoder = new Base64();
            try {
                b = decoder.decode(s);
                result = new String(b, "utf-8");
            } catch (Exception e) {
            }
        }
        return result;
    }

    public static void main(String[] argv) {
        //您的AccessKeyId
        String accessKeyId = "<Your AccessKeyId>";
        //您的AccessKeySecret
        String accessKeySecret = "<Your AccessKeySecret>";
        //需要上传到VOD的本地视频文件的完整路径，需要包含文件扩展名
        String localFile = "/Users/yours/Video/testVideo.flv";
        try {
            // 初始化VOD客户端并获取上传地址和凭证
            DefaultAcsClient vodClient = initVodClient(accessKeyId, accessKeySecret);
            CreateUploadVideoResponse createUploadVideoResponse = createUploadVideo(vodClient);
            // 执行成功会返回VideoId、UploadAddress和UploadAuth
            String videoId = createUploadVideoResponse.getVideoId();
            JSONObject uploadAuth = JSONObject.parseObject(decodeBase64(createUploadVideoResponse.getUploadAuth()));
            JSONObject uploadAddress = JSONObject.parseObject(decodeBase64(createUploadVideoResponse.getUploadAddress()));
            // 使用UploadAuth和UploadAddress初始化OSS客户端
            OSSClient ossClient = initOssClient(uploadAuth, uploadAddress);
            // 上传文件，注意是同步上传会阻塞等待，耗时与文件大小和网络上行带宽有关
            uploadLocalFile(ossClient, uploadAddress, localFile);
            System.out.println("Put local file succeed, VideoId : " + videoId);
        } catch (Exception e) {
            System.out.println("Put local file fail, ErrorMessage : " + e.getLocalizedMessage());
        }
    }








}
