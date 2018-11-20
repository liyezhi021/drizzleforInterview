package com.example.Controller;

import com.example.elasticSearch.GoodsRepository;
import com.example.entity.GoodsInfo;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.common.lucene.search.function.FiltersFunctionScoreQuery;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.functionscore.FunctionScoreQueryBuilder;
import org.elasticsearch.index.query.functionscore.ScoreFunctionBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GoodsController {

    @Autowired
    private GoodsRepository goodsRepository;

    private Integer PAGESIZE=10;

    @GetMapping("save")
    public String save(){
        GoodsInfo goodsInfo = new GoodsInfo(System.currentTimeMillis(),
                "goods1"+System.currentTimeMillis(), "商品1");
        goodsRepository.save(goodsInfo);
        return "success";
    }

    @GetMapping("delete")
    public String delete(long id){
        goodsRepository.deleteById(id);
        return "success";
    }

    @GetMapping("update")
    public String update(long id,String name,String description){
        GoodsInfo goodsInfo = new GoodsInfo(id,
                name,description);
        goodsRepository.save(goodsInfo);
        return "success";
    }

    @GetMapping("getOne")
    public GoodsInfo getOne(long id){
        GoodsInfo goodsInfo = goodsRepository.findById(id).get();
        return goodsInfo;
    }

    @GetMapping("getGoodsList")
    public List<GoodsInfo> getList(Integer pageNumber, String query){
        if(pageNumber==null) pageNumber = 0;
        //es搜索默认第一页页码是0
        SearchQuery searchQuery=getEntitySearchQuery(pageNumber,PAGESIZE,query);
        Page<GoodsInfo> goodsPage = goodsRepository.search(searchQuery);
        return goodsPage.getContent();
    }

    private SearchQuery getEntitySearchQuery(int pageNumber, int pageSize, String searchContent) {
        QueryBuilder queryBuilder = QueryBuilders.matchAllQuery();
        //queryBuilder.should(QueryBuilders.matchQuery("name", searchContent));
        //queryBuilder.add(QueryBuilders.matchQuery("description", searchContent));
        FunctionScoreQueryBuilder functionScoreQueryBuilder = QueryBuilders.functionScoreQuery(queryBuilder)
                //设置权重分 求和模式
                .scoreMode(FiltersFunctionScoreQuery.ScoreMode.SUM)
                //设置权重分最低分
                .setMinScore(10);

        // 设置分页
        Pageable pageable = new PageRequest(pageNumber, pageSize);
        return new NativeSearchQueryBuilder()
                .withPageable(pageable)
                .withQuery(functionScoreQueryBuilder).build();
    }

}
