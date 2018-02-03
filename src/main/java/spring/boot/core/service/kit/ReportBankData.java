package spring.boot.core.service.kit;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import spring.boot.core.domain.BankData;
import spring.boot.core.service.kit.component.PDFHeaderFooter;
import spring.boot.core.service.kit.component.PDFKit;
import spring.boot.core.service.kit.component.chart.Line;
import spring.boot.core.service.kit.component.chart.impl.DefaultLineChart;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fgm on 2017/4/17.
 * 360报告
 *
 */
@Slf4j
@Component
public class ReportBankData {

    @Value("${fs.pdf.path}")
    private String pdfPath;

    public String createPDF(String dataId, String htmlData){
        return createPDF(dataId, htmlData, "bankData.pdf");
    }

    /**
     * 创建PDF
     * @param fileName
     * @return
     */
    public  String createPDF(String dataId, String htmlData, String fileName){
        //pdf保存路径
        try {
            //设置自定义PDF页眉页脚工具类
            PDFHeaderFooter headerFooter=new PDFHeaderFooter();
            PDFKit kit=new PDFKit();
            kit.setHeaderFooterBuilder(headerFooter);
            //设置输出路径
//            String dataId = String.valueOf(((BankData)data).getId());
            kit.setSaveFilePath(String.format(pdfPath, dataId));
            String saveFilePath=kit.exportToFile(fileName, htmlData);
            return  saveFilePath;
        } catch (Exception e) {
            log.error("PDF生成失败{}", ExceptionUtils.getFullStackTrace(e));
            return null;
        }

    }

    public static void main(String[] args) {

        ReportBankData kit=new ReportBankData();
        BankData bankData=new BankData();

        bankData.setName("kkkkk");
        bankData.setIssueDate("2018-1-20");
        bankData.setPartyPerson("zhangsna");
        bankData.setBankName("pufa");
        bankData.setHolderName("里斯");
        bankData.setMainCase("fsdfds");
        bankData.setAccording("fff");
        bankData.setDecision("2222");
        bankData.setOrgName("fsfs");
        bankData.setOriUrl("http://example.coo");

//        String path= kit.createPDF(bankData,"bankData.pdf");
//        System.out.println(path);



    }






}
