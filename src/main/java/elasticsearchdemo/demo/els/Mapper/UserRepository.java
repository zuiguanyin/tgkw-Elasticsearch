package elasticsearchdemo.demo.els.Mapper;

import elasticsearchdemo.demo.els.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface UserRepository extends ElasticsearchRepository<User, String> {

    List<User> findByName(String name);

    Page<User> findByJob(String job, Pageable pageable);

    List<User> findByJobOrderByAgeAsc(String Job);

    List<User> findByJobAndAgeBetween(String Job, int gt, int lt);

}
