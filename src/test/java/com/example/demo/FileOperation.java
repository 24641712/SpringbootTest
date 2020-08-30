package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

/**
 * @version 1.0
 * @Description :
 * Copyright: Copyright (c)2019
 * Created Date : 2020/6/13
 */
@Slf4j

public class FileOperation {

    @Test
    public void test(){
        log.info("hello world");
//        System.out.println("hello");
    }

    @Test
    public void FileDelete(){
        String content = "　　美国国税局预测，美国就业岗位减少的局面可能会持续数年。该局8月20日发布的数据显示，预计2021年美国将有2.294亿可以归为雇员的岗位，比2019年疫情前估计的低约3720万。该统计数据是用于估计W-2税表和该机构将收到的代扣税款的数量。报告同时预测，至少在2027年之前，W-2申报数量都将低于先前估计水平。2027年度的申报数量料比原先预估减少约1590万份。也就是说，美国国税局认为，美国数以千万计的失业现象，美国经济复苏前景十分悲观，萧条或将持续至2027年。而美国失业者越来越多的另一个进展是，据路透社8月20日报道，在截至8月15日的一周内，美国新申请失业救济的美国人数量上周出人意料地回升至100万人以上。报道指出，首次申请失业救济人数上升至经季节性调整后的110.6万人，高于此前一周的97.1万人。\n" +
                "\n" +
                "　　而对于美国经济不太乐观的就业数据，美国金融网站8月21日分析报道称，失业人数的增加导致美国人的消费急剧下降。这也印证了BWC中文网三周前就独家分析提及的，美国经济不断炮制膨胀美元，并不能改变大多数美国人生活的困境。雪上加霜的是，据《华尔街日报》上周报道，根据美国人口普查局数据显示，截至7月底，美国约有12.1%的成年人家里在近一周有过食物不足的经历，这一数字高于5月初的9.8%。还有近20%的有孩一族表示负担不起孩子的饮食，这也高于6月初的近17%。而彭博社三周前援引美国人口普查局最新的每周家庭脉搏调查数据显示，当时一周就有近3000万美国人饿了肚子，感到饥饿。越来越多的美国人正在走向食品银行（也称食品救济处）。而这对于地广人稀，农场主经济高度发达的美国经济而言，似乎更像是一个讽刺。不过，这在美国经济而言，并不意外。\n" +
                "\n" +
                "　　要知道，上世纪三十年代初，美国大萧条时期的“倒牛奶”现象也正是如此。而这背后出现的核心逻辑和深层原因正是，美国经济和美元的最终受益者并非大多数美国人，而是那些离美元印钞机最近的银行家和华尔街精英。对此，美国西北大学经济学家尚岑巴赫（Diane Whitmore Schanzenbach）表示，“我很明显地看到，问题很大，而且这个问题似乎比大萧条最严重时还要严峻。”不仅如此，越来越多的美国失业者，由于无力负担房租或房贷等情况，而不得不面临被从住所中驱逐的可能。预计可能有多至4300万美国人被逐出家园，或将不得不露宿街头，而无家可归。例如，在弗吉尼亚州的里士满，名叫萨米卡·罗林斯（Shamika Rollins）未付的账单已开始堆积起来，而在几周前她收到了驱逐通知。\n" +
                "\n" +
                "　　值得注意的是，多位华尔街金融大鳄已经发出美国经济萧条的警告。分析预计，或将有23万亿美元（价值约159.9万亿人民币）的全球资金陆续从美国市场撤离。例如，股神沃伦.巴菲特一改此前一直对黄金“嗤之以鼻”的态度，巴菲特旗下伯克希尔哈撒韦最新公布的13F报告显示，该公司二季度只有一项新建仓—巴里克黄金。有分析认为，这是巴菲特为美国市场可能发生的某种危机，而做出的提前预判。　而另一位华尔街金融大鳄乔治·索罗斯数周前发出警告说，由于美国当局努力提高美国风险资产和债务的努力，美国市场可能会走进大萧条雷区。日前，索罗斯再次表示，在美国市场没再增加新的投资。无独有偶，索罗斯曾经的伙伴，华尔街商品大王吉姆·罗杰斯8月20日在接受Kitco News采访时更是用了十分肯定的语气警告称，“美国最严重的金融危机将来临，美国是世界历史上最大的债务国（目前美国联邦债务总额已高达近27万亿美元）”，罗杰斯警告说，下一次金融危机可能比我们今年看到的还要严重，“这肯定是我一生中最糟糕的时刻，是因为美联储已经印制并花费了惊人的资金，但这意味着下次情况还会变得更糟。";
        for(int i=0;i<1000000;i++){
            String filestr = String.format("G:\\tmp\\deletefile\\file_%d.txt",i);
            String path = writerToLoacal(filestr, content);
            File file = new File(path);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(file.exists()){
                log.info("文件上传成功：{}", file.getAbsoluteFile());
            }else{
                log.warn("上传文件不存在:{}", file.getAbsoluteFile());

            }
            file.delete();
        }

    }

    public String writerToLoacal(String filestr, String content){
        try {
            File myFile = new File(filestr);
            RandomAccessFile randomAccessFile = new RandomAccessFile(myFile,"rw");
            FileChannel fileChannel = randomAccessFile.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(content.getBytes().length);
            byteBuffer.put(content.getBytes());
            byteBuffer.flip();
            fileChannel.write(byteBuffer);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return filestr;
    }

    @Test
    public void delete(){
        File dir = new File("G:\\tmp\\deletefile");
        for(File file : dir.listFiles()){
            log.info(file.getAbsolutePath());
            file.delete();
        }

    }


}
