package com.wl.es;

import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.aggregations.metrics.MaxAggregationBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.SortOrder;

import javax.swing.text.Highlighter;

public class ESTest_Doc_Query {
    public static void main(String[] args) throws Exception {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200)));

//        IndexRequest request = new IndexRequest();
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//        request.source(new SearchSourceBuilder().query(QueryBuilders.matchAllQuery()));
//        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
//        SearchHits hits = response.getHits();
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());
//        for (SearchHit hit : hits){
//            System.out.println(hit.getSourceAsString());
//        }
//条件查询
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
////        request.source(new SearchSourceBuilder().query(QueryBuilders.termQuery("age",30)));
//        request.source(new SearchSourceBuilder().query(QueryBuilders.termQuery("sex","男")));
//        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
//        SearchHits hits = response.getHits();
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());
//        for (SearchHit hit : hits){
//            System.out.println(hit.getSourceAsString());
//        }
//分页查询
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//        SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
////        builder.from(2);
////        builder.size(2);
//        builder.sort("age", SortOrder.DESC);
//        request.source(builder);
//        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
//        SearchHits hits = response.getHits();
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());
//        for (SearchHit hit : hits){
//            System.out.println(hit.getSourceAsString());
//        }
        //过滤字段
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//        SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
//        String [] excludes={};
//        String [] includes={"age"};
//        builder.fetchSource(includes,excludes);
//        request.source(builder);
//        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
//        SearchHits hits = response.getHits();
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());
//        for (SearchHit hit : hits){
//            System.out.println(hit.getSourceAsString());
//        }

//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//        SearchSourceBuilder builder = new SearchSourceBuilder();
//        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
//        boolQueryBuilder.must(QueryBuilders.matchQuery("age", "30"));
//        boolQueryBuilder.mustNot(QueryBuilders.matchQuery("age", "30"));
//        boolQueryBuilder.should(QueryBuilders.matchQuery("age", "40"));
//        builder.query(boolQueryBuilder);
//        request.source(builder);
//        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
//        SearchHits hits = response.getHits();
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());
//        for (SearchHit hit : hits){
//            System.out.println(hit.getSourceAsString());
//        }
//范围查询
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//        SearchSourceBuilder builder = new SearchSourceBuilder();
//        RangeQueryBuilder rangeQuery = QueryBuilders.rangeQuery("age");
//        rangeQuery.gte(30);
//        rangeQuery.lte(40);
//        builder.query(rangeQuery);
//        request.source(builder);
//        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
//        SearchHits hits = response.getHits();
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());
//        for (SearchHit hit : hits) {
//            System.out.println(hit.getSourceAsString());
//        }
//模糊查询
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//        SearchSourceBuilder builder = new SearchSourceBuilder();
//        builder.query(QueryBuilders.fuzzyQuery("name", "wanl").fuzziness(Fuzziness.ONE));
//
//
//        request.source(builder);
//        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
//        SearchHits hits = response.getHits();
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());
//        for (SearchHit hit : hits){
//            System.out.println(hit.getSourceAsString());
//        }
        //高亮查询
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//        SearchSourceBuilder builder = new SearchSourceBuilder();
//        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("name", "wanli");
//        HighlightBuilder highlightBuilder = new HighlightBuilder();
//        highlightBuilder.preTags("<font color='red");
//        highlightBuilder.postTags("</font>");
//        highlightBuilder.field("name");
//        builder.highlighter(highlightBuilder);
//        builder.query(termQueryBuilder);
//
//        request.source(builder);
//        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
//        SearchHits hits = response.getHits();
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());
//        for (SearchHit hit : hits){
//            System.out.println(hit.getSourceAsString());
//        }
        SearchRequest request = new SearchRequest();
        request.indices("user");
        SearchSourceBuilder builder = new SearchSourceBuilder();
        TermsAggregationBuilder field = AggregationBuilders.terms("ageGroup").field("age");
//        MaxAggregationBuilder field = AggregationBuilders.max("maxAge").field("age");
        builder.aggregation(field);

        request.source(builder);
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        SearchHits hits = response.getHits();
        System.out.println(hits.getTotalHits());
        System.out.println(response.getTook());
        for (SearchHit hit : hits) {
            System.out.println(hit.getSourceAsString());
        }

        client.close();
    }
}
