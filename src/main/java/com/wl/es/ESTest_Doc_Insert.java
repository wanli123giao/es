package com.wl.es;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

public class ESTest_Doc_Insert {
    public static void main(String[] args) throws Exception{
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200)));

        IndexRequest request = new IndexRequest();
        request.index("user").id("1001");

        User user = new User();
        user.setAge(18);
        user.setName("wanli");
        user.setSex("男");

        ObjectMapper mapper = new ObjectMapper();
        String userJosn = mapper.writeValueAsString(user);
        request.source(userJosn, XContentType.JSON);
        IndexResponse response = client.index(request, RequestOptions.DEFAULT);

        System.out.println(response.getResult());
        client.close();
    }
}
