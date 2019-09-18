package com.leyou;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class ElasticSearchManager {

    TransportClient client=null;

    @Before
    public void initClient() throws UnknownHostException {
        client=new PreBuiltTransportClient(Settings.EMPTY)
                .addTransportAddress(new TransportAddress(InetAddress.getByName("127.0.0.1"),9300));
    }

    @Test
    public void testQuery(){

        //QueryBuilder query = QueryBuilders.termQuery("goodsName", "华为");
        //WildcardQueryBuilder query = QueryBuilders.wildcardQuery("goodsName", "*华*");
        //QueryBuilder query = QueryBuilders.fuzzyQuery("goodsName", "化为");
        //((FuzzyQueryBuilder) query).fuzziness(Fuzziness.ONE);
        //QueryBuilder query = QueryBuilders.matchAllQuery();
        //QueryBuilder query = QueryBuilders.matchQuery("goodsName", "小米苹果华为");
        //QueryBuilder query = QueryBuilders.rangeQuery("price").gte(2000).lte(8888);
        QueryBuilder query = QueryBuilders.boolQuery()
                .must(QueryBuilders.termQuery("goodsName", "华为"))
                .mustNot(QueryBuilders.rangeQuery("price").gte(4000).lte(8888));
        SearchResponse searchResponse= client.prepareSearch("heima")
                .setQuery(query)
                .get();

        long hits = searchResponse.getHits().getTotalHits();
        System.out.println("总数为:"+hits);

        SearchHit[] searchHits = searchResponse.getHits().getHits();
        for (SearchHit hit : searchHits) {
            String string = hit.getSourceAsString();
            System.out.println(string);
        }

    }



    @After
    public void end(){
        client.close();
    }
}
