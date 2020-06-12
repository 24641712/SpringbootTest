package com.example.demo.oss;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.*;

import java.io.*;

/**
 * @version 1.0
 * @Description :
 * Copyright: Copyright (c)2019
 * Created Date : 2020/5/26
 */
public class OSSClients {
    //您的AccessKeyId
    static String accessKeyId = "LTAI4GEmPZZLvxtaTQSm8ds7";
    //您的AccessKeySecret
    static String accessKeySecret = "AmvquSvLOJSj2YB9OdA5v5oJWf6tUA";
    //需要上传到VOD的本地视频文件的完整路径，需要包含文件扩展名
    static String uploadFile = "G:\\download.mp4";
    private static String bucketName = "ccl-video";
    private static String endpoint = "http://oss-cn-beijing.aliyuncs.com";
    private static String key = "v2/v21/download12.mp4";

    public static void main(String[] args) throws IOException
    {

        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        try {
            UploadFileRequest uploadFileRequest = new UploadFileRequest(bucketName, key);
            // The local file to upload---it must exist.
            uploadFileRequest.setUploadFile(uploadFile);
            // Sets the concurrent upload task number to 5.
            uploadFileRequest.setTaskNum(5);
            // Sets the part size to 1MB.
            uploadFileRequest.setPartSize(1024 * 1024 * 1);
            // Enables the checkpoint file. By default it's off.
            uploadFileRequest.setEnableCheckpoint(true);

            UploadFileResult uploadResult = ossClient.uploadFile(uploadFileRequest);

            CompleteMultipartUploadResult multipartUploadResult =
                    uploadResult.getMultipartUploadResult();
            System.out.println(multipartUploadResult.getETag());

        } catch (OSSException oe) {
            System.out.println("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            System.out.println("Error Message: " + oe.getErrorMessage());
            System.out.println("Error Code:       " + oe.getErrorCode());
            System.out.println("Request ID:      " + oe.getRequestId());
            System.out.println("Host ID:           " + oe.getHostId());
        } catch (ClientException ce) {
            System.out.println("Caught an ClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network.");
            System.out.println("Error Message: " + ce.getMessage());
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            ossClient.shutdown();
        }
    }

}
