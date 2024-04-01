package com.wl.es;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

public class ESTest_Doc_Insert_Batch {
    public static void main(String[] args) throws Exception{
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200)));

        BulkRequest request = new BulkRequest();


        request.add(new IndexRequest().index("user").id("1001").source(XContentType.JSON,"name","zhangsan","age",30,"sex","男"));
        request.add(new IndexRequest().index("user").id("1002").source(XContentType.JSON,"name","lisi","age",50,"sex","男"));
        request.add(new IndexRequest().index("user").id("1003").source(XContentType.JSON,"name","wangwu","age",70,"sex","男"));
//        request.add(new IndexRequest().index("user").id("1002").source(XContentType.JSON,"name","lisi"));
//        request.add(new IndexRequest().index("user").id("1003").source(XContentType.JSON,"name","wangwu"));
        BulkResponse bulk = client.bulk(request, RequestOptions.DEFAULT);
        System.out.println(bulk.getTook());
        System.out.println(bulk.getItems());
        client.close();

    }
}
