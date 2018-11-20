package com.example.elasticSearch;

import com.example.entity.GoodsInfo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsRepository extends ElasticsearchRepository<GoodsInfo, Long> {
}
