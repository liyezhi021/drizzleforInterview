package com.example.Controller;

import com.example.elasticSearch.PostRepository;
import com.example.entity.Post;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.elasticsearch.index.query.QueryBuilders.*;

@RestController
public class ElasticSearchPostController {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    private PostRepository postRepository;

    @RequestMapping("/add")
    public Object add() {
        Post post = new Post();
        post.setTitle("我是");
        post.setContent("我爱中华人民共和国");
        post.setWeight(1);
        post.setUserId(1);
        postRepository.save(post);
        post = new Post();
        post.setTitle("我是");
        post.setContent("中华共和国");
        post.setWeight(2);
        post.setUserId(2);
        return postRepository.save(post);
    }

    //https://blog.csdn.net/tianyaleixiaowu/article/details/77965257
    //1 单字符串全文查询

    /**
     * 单字符串模糊查询，默认排序。将从所有字段中查找包含传来的word分词后字符串的数据集
     */
    @GetMapping("/singleWord")
    public Object singleTitle(String word, @PageableDefault Pageable pageable) {
        //使用queryStringQuery完成单字符串查询
        SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(queryStringQuery(word)).withPageable(pageable).build();
        return elasticsearchTemplate.queryForList(searchQuery, Post.class);
    }

    /**
     * 单字符串模糊查询，单字段排序。
     */
    @RequestMapping("/singleWord1")
    public Object singlePost(String word, @PageableDefault(sort = "weight", direction = Sort.Direction.DESC) Pageable pageable) {
        //使用queryStringQuery完成单字符串查询
        SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(queryStringQuery(word)).withPageable(pageable).build();
        return elasticsearchTemplate.queryForList(searchQuery, Post.class);
    }

    //2 某字段按字符串模糊查询

    /**
     * 单字段对某字符串模糊查询
     */
    @RequestMapping("/singleMatch")
    public Object singleMatch(String content, Integer userId, @PageableDefault Pageable pageable) {
        SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(matchQuery("content", content)).withPageable(pageable).build();
        // SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(matchQuery("userId", userId)).withPageable(pageable).build();
        return elasticsearchTemplate.queryForList(searchQuery, Post.class);
    }

    //3 PhraseMatch查询，短语匹配

    /**
     * 单字段对某短语进行匹配查询，短语分词的顺序会影响结果
     */
    @RequestMapping("/singlePhraseMatch")
    public Object singlePhraseMatch(String content, @PageableDefault Pageable pageable) {
        SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(matchPhraseQuery("content", content)).withPageable(pageable).build();
        return elasticsearchTemplate.queryForList(searchQuery, Post.class);
    }

    //slop
    @RequestMapping("/singlePhraseMatch1")
    public Object singlePhraseMatch1(String content, @PageableDefault Pageable pageable) {
        //SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(matchPhraseQuery("content", content)).withPageable(pageable).build();
        // 少匹配一个分词也OK
        SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(matchPhraseQuery("content", content).slop(2)).withPageable(pageable).build();
        return elasticsearchTemplate.queryForList(searchQuery, Post.class);
    }

    /*GET /my_index/my_type/_search   可以匹配  quick xxx fox
    {
        "query": {
        "match_phrase": {
            "title": {
                "query": "quick fox",
                        "slop":  1
            }
        }
    }
    }*/

    //Term查询  这个是最严格的匹配，属于低级查询，不进行分词的

    /**
     * term匹配，即不分词匹配，你传来什么值就会拿你传的值去做完全匹配
     */
    @RequestMapping("/singleTerm")
    public Object singleTerm(Integer userId, @PageableDefault Pageable pageable) {
        //不对传来的值分词，去找完全匹配的
        SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(termQuery("userId", userId))
                .withPageable(pageable).build();
        return elasticsearchTemplate.queryForList(searchQuery, Post.class);
    }

    //5 multi_match多个字段匹配某字符串

    /**
     * 多字段模糊匹配   如果希望完全匹配的文档占的评分比较高，要用best_fields
     */
    @RequestMapping("/multiMatch")
    public Object singleUserId(String title, @PageableDefault(sort = "weight", direction = Sort.Direction.DESC) Pageable pageable) {
        SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(multiMatchQuery(title, "title", "content")).withPageable(pageable).build();
        return elasticsearchTemplate.queryForList(searchQuery, Post.class);
    }


    //之前的查询中，当我们输入“我天”时，ES会把分词后所有包含“我”和“天”的都查询出来，如果我们希望必须是包含了两个字的才能被查询出来，那么我们就需要设置一下Operator。

    /**
     * 单字段包含所有输入
     */
    @RequestMapping("/contain")
    public Object contain(String title) {
        SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(matchQuery("title", title).operator(MatchQueryBuilder.DEFAULT_OPERATOR.AND)).build();
        return elasticsearchTemplate.queryForList(searchQuery, Post.class);
    }

    /**
     * 单字段包含所有输入(按比例包含)
     */
    @RequestMapping("/contain1")
    public Object contain1(String title) {
        SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(matchQuery("title", title).operator(MatchQueryBuilder.DEFAULT_OPERATOR.AND).minimumShouldMatch("75%")).build();
        return elasticsearchTemplate.queryForList(searchQuery, Post.class);
    }

    //合并查询 boolQuery

    /**
     * 多字段合并查询
     */
    @RequestMapping("/bool")
    public Object bool(String title, Integer userId, Integer weight) {
        SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(boolQuery()
                .must(termQuery("userId", userId)).should(rangeQuery("weight")
                        .lt(weight)).must(matchQuery("title", title))).build();
        return elasticsearchTemplate.queryForList(searchQuery, Post.class);
    }

}
