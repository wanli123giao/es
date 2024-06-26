package com.wl.es;

import org.apache.http.HttpHost;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

public class ESTest_Doc_Delete {
    public static void main(String[] args) throws Exception{
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200)));

//        IndexRequest request = new IndexRequest();

        DeleteRequest request = new DeleteRequest();
        request.index("user").id("1001");
        DeleteResponse response = client.delete(request, RequestOptions.DEFAULT);
        System.out.println(response);
        client.close();
    }
}
