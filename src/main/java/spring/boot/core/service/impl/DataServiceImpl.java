package spring.boot.core.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;
import spring.boot.core.domain.BankData;
import spring.boot.core.service.DataService;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Comparator;
import java.util.List;

@Service
public class DataServiceImpl implements DataService {
    public static String URI = "http://localhost:9080?sQuery=%s";

    private CloseableHttpClient client = HttpClients.createDefault();

    public List<BankData> search(String sQuery) throws IOException {
        String json = doGet(String.format(URI, sQuery));

        /**
         * ObjectMapper支持从byte[]、File、InputStream、字符串等数据的JSON反序列化。
         */
        ObjectMapper mapper = new ObjectMapper();
        List<BankData> beanList = mapper.readValue(json, new TypeReference<List<BankData>>() {});
        beanList.sort(new BankDataComparator());
        return beanList;
    }

    private static class BankDataComparator implements Comparator<BankData>{

        @Override
        public int compare(BankData b1, BankData b2) {
            if(b1.getScore() > b2.getScore()) return -1;
            else if(b1.getScore() < b2.getScore()) return 1;
            return 0;
        }
    }

    public String doGet(String uriAPI) {

        String resStr = "";
        //创建一个httpclient对象


        try {
            //创建URIBuilder
            URIBuilder uri = new URIBuilder(uriAPI);
            //设置参数
//        uri.addParameter("id", "10001");

            //创建httpGet对象
            HttpGet hg = new HttpGet(uri.build());
            hg.setHeader("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN; rv:1.9.0.3) Gecko/2008092417 Firefox/3.0.3");
            //设置请求的报文头部的编码
            hg.setHeader(
                    new BasicHeader("Content-Type", "charset=utf-8"));

            //设置期望服务端返回的编码
//            hg.setHeader(new BasicHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8"));

            //请求服务
            CloseableHttpResponse response = null;
            response = client.execute(hg);
            //获取响应码
            int statusCode = response.getStatusLine().getStatusCode();

            if (statusCode == 200) {

                //获取返回实例entity
                HttpEntity entity = response.getEntity();

                //通过EntityUtils的一个工具方法获取返回内容
                resStr = EntityUtils.toString(entity, "utf-8");

                //输出
//                System.out.println("请求成功,请求返回内容为: " + resStr);
                System.out.println("请求成功,请求返回内容为: " + uriAPI);
            } else {

                //输出
                System.out.println("请求失败,错误码为: " + statusCode);
            }

            //关闭response和client
            response.close();


        }catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resStr;
    }

}
