package jedis.test;


import jedis.util.JedisPoolUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author wyl
 * @create 2020-11-11
 * @Description Jedis测试  长时间不使用可能需要重启服务器端（先开启服务器）
 * @Version
 */
public class JedisTest {
    @Test
    //快速入门
    public void test01(){
        //获取连接
        Jedis jedis = new Jedis("localhost", 6379); //使用非空参构造函数，具体指定IP+PORT
        //操作
        jedis.set("username","zhangsan");
        //关闭连接
        jedis.close();
    }

    @Test
    //string 数据结构操作
    public void test02(){
        Jedis jedis = new Jedis(); //使用空参构造函数，使用默认的IP+PORT,即：localhost 6379
        jedis.set("username","lisi");
        String username = jedis.get("username");
        System.out.println(username);
        //setex方法可以存储键值对，并且在一段指定的时间后进行删除(有时间的信息，如有时间限制的验证码信息存储)
        jedis.setex("activecode",20,"hehe");
        jedis.close();
    }

    @Test
    //hash 数据结构操作
    public void test03(){
        Jedis jedis = new Jedis();
        jedis.hset("user","name","lisi+++");
        jedis.hset("user","age","23");    //value 在这里只能是string?
        jedis.hset("user","gender","男");

        //获取hash
        String name = jedis.hget("user", "name");
        System.out.println(name);

        //获取所有
        Map<String, String> user = jedis.hgetAll("user");
        //遍历map(一种使用keySet，一种用entrySet)
        //方式一：取出所有的key（key存放在Set中），再通过key取value
        Set<String> keySet = user.keySet();
        /*System.out.println(keySet);*/

        for (String key:keySet){
            //获取value
            String value = user.get(key);
            System.out.println(key+":"+value);
        }

        Iterator<String> iterator = keySet.iterator();
        while (iterator.hasNext()){
            String key = iterator.next();
            System.out.println(key+":"+user.get(key));
        }



        //方式二:整个entry（key-value）一起取出放入集合
        Set<Map.Entry<String, String>> entries = user.entrySet();
             //while 迭代器遍历
        Iterator<Map.Entry<String, String>> iterator1 = entries.iterator();
        while (iterator1.hasNext()){
            Map.Entry<String, String> node = iterator1.next();
            System.out.println(node.getKey()+":"+node.getValue());
        }

            //foreach遍历
        for (Map.Entry node :entries) {
            System.out.println(node.getKey()+":"+node.getValue());
        }
        jedis.close();
    }
    @Test
    // list 数据结构
    public void test05(){

        Jedis jedis = new Jedis();
        //list存储
        jedis.lpush("mylist","a","b","c");
        jedis.rpush("mylist","a","b","c");

        //list 数据获取
        List<String> mylist = jedis.lrange("mylist", 0, -1);
        System.out.println(mylist);

        //list弹出
        String element1 = jedis.lpop("mylist");
        System.out.println(element1);

        String mylist1 = jedis.rpop("mylist");
        System.out.println(mylist1);

        List<String> mylist2 = jedis.lrange("mylist", 0, -1);
        System.out.println(mylist2);


        jedis.close();
    }

    @Test
    //set 数据结构操作
    public void test06(){
        Jedis jedis = new Jedis();
        jedis.sadd("myset","java","php","c++");  //重复元素不会重复添加

        Set<String> myset = jedis.smembers("myset");
        System.out.println(myset);

        jedis.close();
    }

    @Test
    //sortedset 数据结构操作
    public void test07(){
        Jedis jedis = new Jedis();
        jedis.zadd("mysortedset",35,"A");
        jedis.zadd("mysortedset",15,"B");
        jedis.zadd("mysortedset",25,"C");

        Set<String> mysortedset = jedis.zrange("mysortedset", 0, -1);
        System.out.println(mysortedset);
        /*System.out.printf("hello");
        System.out.printf("hello");*/
    }
    @Test
    //jedis连接池使用
    public void test08(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(50);
        jedisPoolConfig.setMaxIdle(10);//最大空闲连接

        JedisPool jedisPool = new JedisPool(jedisPoolConfig, "127.0.0.1", 6379); //"localhost"

        Jedis jedis= jedisPool.getResource();
        jedis.set("test","hello");

        String test = jedis.get("test");
        System.out.println(test);

        jedis.close(); //释放jedis回连接池
    }

    @Test
    //jedis连接池工具类使用
    public void test09(){
        //通过连接池工具类获取
        Jedis jedis = JedisPoolUtils.getJedis();

        jedis.set("hi","hihihi");

        System.out.println(jedis.get("hi"));

        jedis.close();
    }

}
