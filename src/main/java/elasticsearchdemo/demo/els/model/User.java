package elasticsearchdemo.demo.els.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;


@Data
@AllArgsConstructor
//索引名称为user，分片数为1，副本数为0
@Document(indexName = "user", shards = 1, replicas = 0)
public class User {
    @Id
    private String id;

    @Field(type = FieldType.Keyword)
    private String name;

    @Field(type = FieldType.Text)
    private String msg;

    @Field(type = FieldType.Keyword)
    private String job;

    @Field(type = FieldType.Keyword)
    private String sex;

    @Field(type = FieldType.Integer)
    private int age;

    //这里使用自定义的日期格式化
    @Field(type = FieldType.Date, name = "create_date", format = DateFormat.custom, pattern = "yyyy-MM-dd HH:MM:SS")
    private Date createDate;

}