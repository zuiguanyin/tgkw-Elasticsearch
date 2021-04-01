package elasticsearchdemo.demo.els.impl;

import elasticsearchdemo.demo.els.EsSearchService;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Slf4j
@Service
public class EsSearchServiceImpl implements EsSearchService {

    private RestHighLevelClient restHighLevelClient;


    public EsSearchServiceImpl() {
        restHighLevelClient = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("localhost", 9200, "http")));
    }

    @Override
    public boolean CreateIndex(String index) throws IOException {
        //1.创建索引请求
        CreateIndexRequest request = new CreateIndexRequest(index);
        //2.客户端执行请求IndicesClient,请求后获得相应
        CreateIndexResponse response = restHighLevelClient.indices().create(request, RequestOptions.DEFAULT);
        return response.isAcknowledged();
    }

    @Override
    public boolean isExit(String index) throws IOException {
        return false;
    }

    @Override
    public boolean delete(String index) throws IOException {
        return false;
    }

    @Override
    public boolean addDocument(String index, String id, Object object) throws IOException {
        return false;
    }

    @Override
    public boolean isdocuexit(String index, String id) throws IOException {
        return false;
    }

    @Override
    public String GetDoucumment(String index, String id) throws IOException {
        return null;
    }

    @Override
    public boolean UpdateDocument(Object object, String index, String id) throws IOException {
        return false;
    }

    @Override
    public boolean DeleteDocument(String index, String id) throws IOException {
        return false;
    }

    @Override
    public boolean addmoredocument(ArrayList<Object> list, String index, String id) throws IOException {
        return false;
    }

    @Override
    public List<Map<String, Object>> termQuery(String index, TreeMap<String, Object> content, int size, int from, boolean ishigh) throws IOException {
        return null;
    }

    @Override
    public List<Map<String, Object>> matchQuery(String index, TreeMap<String, Object> content, int size, int from, boolean ishigh) throws IOException {
        return null;
    }

    @Override
    public List<Map<String, Object>> boolmustQuery(String index, TreeMap<String, Object> content, int size, int from) throws IOException {
        return null;
    }
}
