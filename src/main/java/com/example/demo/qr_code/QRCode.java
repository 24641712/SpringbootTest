package com.example.demo.qr_code;

import com.example.demo.utils.QrCodeUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class QRCode {
    public static void main(String[] args) {
        String url = "https://www.sohu.com";
        String path = "G:\\";
        QrCodeUtil.createQrCode(url,path);
        log.info("程闯亮");

    }




}
