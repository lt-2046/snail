import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.liutao.snail.model.entity.MUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * HibernateBaseDao Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>四月 18, 2019</pre>
 */
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-redis.xml")
public class RedisTest {
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }


    /**
     * Method: updateByBatch(List<T> list)
     */
    @Test
    public void testUpdateByBatch() throws Exception {
        MUser user  = new MUser();
        user.setUserName("redisName");
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set("user",user);
        System.out.println(((MUser)valueOperations.get("user")).getUserName());
//        valueOperations = redisTemplate.opsForValue();
        valueOperations.set("first","hellow word");
        System.out.println(valueOperations.get("first"));


        ValueOperations<String, String> stringStringValueOperations = stringRedisTemplate.opsForValue();
        stringStringValueOperations.set("secound","hello everyone");
        System.out.println(stringStringValueOperations.get("secound"));
        System.out.println(redisTemplate.opsForValue().get("secound"));
    }
} 
