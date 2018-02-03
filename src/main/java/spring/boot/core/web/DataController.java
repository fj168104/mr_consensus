package spring.boot.core.web;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spring.boot.core.domain.BankData;
import spring.boot.core.service.DataService;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 数据控制层
 *
 * Created by bysocket on 24/07/2017.
 */
@Controller
@RequestMapping(value = "/")     // 通过这里配置使下面的映射都在 /users
public class DataController {

    @Autowired
    DataService dataService;          // 用户服务层

    /**
     *   空列表
     *    处理 "/users" 的 GET 请求，用来获取用户列表
     *    通过 @RequestParam 传递参数，进一步实现条件查询或者分页查询
     */
    @RequestMapping(method = RequestMethod.GET)
    public String getSerachPage(ModelMap map) {

        List<BankData> dataList = new ArrayList<>();

        map.addAttribute("dataList", dataList);
        return "search";
    }

    /**
     *  search
     *
     */
    @RequestMapping(value = "/datas/search/{sQuery}", method = RequestMethod.GET)
    public String searchForm(@PathVariable String sQuery, ModelMap map) throws IOException {
        List<BankData> dataList = new ArrayList<>();
        dataList.addAll(dataService.search(sQuery));
        map.addAttribute("dataList", dataList);
        return "dataList";
    }

    @RequestMapping(value="/downloadPDF/{sDataId}", method=RequestMethod.GET)
    public ResponseEntity<Resource> downloadPDFFile(@PathVariable String sDataId, ModelMap map) throws IOException {
        System.out.println("\n********** Download PDF File : ************\n");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        headers.setContentDispositionFormData("attachment", sDataId + ".pdf");
        return new ResponseEntity<>(dataService.generatePDFFile(sDataId), headers, HttpStatus.OK);
    }

    @RequestMapping(value="/fetchFM/{sDataId}", method=RequestMethod.GET)
    public String fetchBankData(@PathVariable String sDataId, Model m) throws IOException {
        m.addAttribute("bankData", dataService.createFMContent(sDataId));
        return "bankData";
    }

}