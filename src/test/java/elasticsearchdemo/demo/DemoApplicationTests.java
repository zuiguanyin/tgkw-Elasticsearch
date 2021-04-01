package elasticsearchdemo.demo;

import elasticsearchdemo.demo.els.Mapper.UserRepository;
import elasticsearchdemo.demo.els.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    private UserRepository userRepository;

    @Test
    void contextLoads() {
        ArrayList<User> users = new ArrayList<>();

        users.add(new User("12", "亚瑟", "我是召唤师", "召唤师", "男", 10, new Date()));
        users.add(new User("12", "黎明", "我是歌手", "歌手", "男", 14, new Date()));
        users.add(new User("13", "周杰伦", "我是歌手", "歌手", "男", 8, new Date()));
        users.add(new User("12", "孙楠", "我是歌手", "歌手", "男", 16, new Date()));
        users.add(new User("12", "吴京", "我是演员", "演员", "男", 12, new Date()));
        users.add(new User("12", "古力娜扎", "我是演员", "演员", "女", 18, new Date()));
        users.add(new User("12", "吴京", "我是演员", "演员", "男", 11, new Date()));
        userRepository.saveAll(users);
    }

    /**
     * 根据name精确匹配查询
     */
    @Test
    void findByName() {
        List<User> user = userRepository.findByName("吴京");
        System.out.println(user);
    }

    @Test
    void findByNameAndJob() {
        //分页条件
        PageRequest pageRequest = PageRequest.of(0, 2);
        //排序条件，按照age升序排列
        Sort asc = Sort.by("age").ascending();
        //降序排列
        //Sort desc = Sort.by("age").descending();
        Page<User> user = userRepository.findByJob("演员", pageRequest);
        System.out.println(user.getContent());
    }
    /**
     * job精确匹配，并按age正序排序
     */
    @Test
    void findByJobOrderByAgeAsc() {
        List<User> users = userRepository.findByJobOrderByAgeAsc("歌手");
        System.out.println(users);
    }

}
