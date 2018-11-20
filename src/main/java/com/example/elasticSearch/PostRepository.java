package com.example.elasticSearch;

import com.example.entity.Post;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

public interface PostRepository extends ElasticsearchRepository<Post, String> {
}
