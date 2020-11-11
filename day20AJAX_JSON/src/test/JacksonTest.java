package test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domian.Person;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.util.*;

/**
 * @author wyl
 * @create 2020-11-10
 * @Description
 * @Version
 */
public class JacksonTest {
    //Java 对象转换成JSON字符串
    @Test
    public void test01() throws Exception {
        Person person = new Person();
        person.setName("张三");
        person.setAge(23);
        person.setGender("男");

        //创建Jackson对象 ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();
        //转换
            /*
            转换方法：
                writeValue(参数1，obj):
                    参数1：
                        File：将obj对象转换为JSON字符串，并保存到指定的文件中
                        Writer：将obj对象转换为JSON字符串，并将json数据填充到字符输出流中
                        OutputStream：将obj对象转换为JSON字符串，并将json数据填充到字节输出流中
                writeValueAsString(obj):将对象转为json字符串
         */
        String string = objectMapper.writeValueAsString(person);
        System.out.println(string);//{"name":"张三","age":23,"gender":"男","birthday":null}

        //将数据写到d://a.txt中
        objectMapper.writeValue(new File("./a.txt"),person);
        //将数据关联到Writer中
        objectMapper.writeValue(new FileWriter(".///b.txt"),person);

    }

    @Test
    public void test02() throws Exception{
        Person person = new Person();
        person.setName("张三");
        person.setAge(23);
        person.setGender("男");
        person.setBirthday(new Date());

        //转换
        ObjectMapper objectMapper = new ObjectMapper();
        String string = objectMapper.writeValueAsString(person);
        //@JsonIgnore
        System.out.println(string);
    }
    //List 集合  --> 打印成一个数组形式，每个元素是一个json字符串
    @Test
    public void test03() throws Exception{
        Person person = new Person();
        person.setName("张三");
        person.setAge(23);
        person.setGender("男");
        person.setBirthday(new Date());
        Person person01= new Person();
        person01.setName("张三");
        person01.setAge(23);
        person01.setGender("男");
        person01.setBirthday(new Date());
        Person person02 = new Person();
        person02.setName("张三");
        person02.setAge(23);
        person02.setGender("男");
        person02.setBirthday(new Date());

        List<Person> persons = new ArrayList<>();
        persons.add(person);
        persons.add(person01);
        persons.add(person02);




        //转换
        ObjectMapper objectMapper = new ObjectMapper();
        String string = objectMapper.writeValueAsString(persons);
        //@JsonIgnore
        System.out.println(string);//[{"name":"张三","age":23,"gender":"男","birthday":"2020-11-10"},{"name":"张三","age":23,"gender":"男","birthday":"2020-11-10"},{"name":"张三","age":23,"gender":"男","birthday":"2020-11-10"}]
    }


    //Map 集合  --> 和一个对象的效果类似
    @Test
    public void test04() throws Exception{
        Map<String, Object> stringObjectHashMap = new HashMap<>();
        /*stringObjectHashMap.put("name","张三");
        stringObjectHashMap.put("age",23);
        stringObjectHashMap.put("gender","男");*/
        //{"gender":"男","name":"张三","age":23}

        Person person = new Person();
        person.setName("张三");
        person.setAge(23);
        person.setGender("男");
        person.setBirthday(new Date());
        Person person01= new Person();
        person01.setName("张三");
        person01.setAge(23);
        person01.setGender("男");
        person01.setBirthday(new Date());
        Person person02 = new Person();
        person02.setName("张三");
        person02.setAge(23);
        person02.setGender("男");
        person02.setBirthday(new Date());

        stringObjectHashMap.put("1",person);
        stringObjectHashMap.put("2",person01);
        stringObjectHashMap.put("3",person02);

        //转换
        ObjectMapper objectMapper = new ObjectMapper();
        String string = objectMapper.writeValueAsString(stringObjectHashMap);
        //@JsonIgnore
        System.out.println(string);
        //{"1":{"name":"张三","age":23,"gender":"男","birthday":"2020-11-10"},"2":{"name":"张三","age":23,"gender":"男","birthday":"2020-11-10"},"3":{"name":"张三","age":23,"gender":"男","birthday":"2020-11-10"}}
    }

    //JSON字符串转换成Java对象
    @Test
    public void test05() throws Exception{
        //1.初始化 JSON字符串
        //String json = "{\"gender\":'男',\"name\":'张三',\"age\":23}";  最好只使用json01那种形式的，虽然本身json支持单引号，但是这里使用单引号会解析错误
       // System.out.println(json);
        String json01 = "{\"gender\":\"男\",\"name\":\"张三\",\"age\":23}";
        System.out.println(json01);
        //2.创建ObjectMapper对象
        ObjectMapper objectMapper = new ObjectMapper();
        //3.转换
        Person person = objectMapper.readValue(json01, Person.class);
        System.out.println(person);//Person{name='张三', age=23, gender='男'}  有Person内中的toString 方法提供格式
        //"Person{" +"name='" + name + '\'' +", age=" + age +", gender='" + gender + '\'' +'}'


    }
}
