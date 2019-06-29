# Spring Boot2 集成 Mybatis之 mybatis_01_hello


### 相关Maven配置
```
<dependencies>
        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
            <version>2.0.1</version>
        </dependency>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <scope>runtime</scope>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>
```
### application.yml相关配置

`application.yml`配置
```aidl
#指定配置文件为test
spring:
  profiles:
    active: test

#配置Mybatis
mybatis:
  type-aliases-package: com.niaobulashi.entity
  mapper-locations: classpath:mapper/*.xml
  configuration:
    # 开启驼峰命名转换，如：Table(create_time) -> Entity(createTime)。不需要我们关心怎么进行字段匹配，mybatis会自动识别`大写字母与下划线`
    map-underscore-to-camel-case: true

#打印SQL日志
logging:
  level:
    com.niaobulashi.dao: DEBUG
```

`application-test.yml`配置：
```aidl
spring:
  datasource:
    url: jdbc:mysql://127.0.0.1:3306/test?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8&useSSL=true
    username: root
    password: root
    driver-class-name: com.mysql.cj.jdbc.Driver
```

在Application中启动对mapper包的扫描
```aidl
@SpringBootApplication
@MapperScan("com.niaobulashi.dao")
public class MybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisApplication.class, args);
    }

}
```

### 添加 User 的映射文件
```aidl
<mapper namespace="com.niaobulashi.dao.SysUserDao">

    <!--查询用户的所有菜单ID-->
    <select id="queryUserInfo" resultType="com.niaobulashi.entity.SysUserEntity">
        SELECT
            ur.*
        FROM
            sys_user ur
        WHERE
            1 = 1
          AND ur.user_id = #{userId}
    </select>

</mapper>
```

### 编写 Mapper 层的代码
```aidl
public interface SysUserDao {
	/**
	 * 根据userId查询用户信息
	 * @param userId  用户ID
	 */
	List<SysUserEntity> queryUserInfo(Long userId);
}
```

### 编写Service层的代码
`SysUserService`接口类：
```aidl
public interface SysUserService {
	/**
	 * 查询用户的所有菜单ID
	 */
	List<SysUserEntity> queryUserInfo(Long userId);
}
```
`SysUserServiceImpl`接口类：
```aidl
@Service("sysUserService")
public class SysUserServiceImpl  implements SysUserService {
	@Resource
	private SysUserDao sysUserDao;
	/**
	 * 查询用户的所有菜单ID
	 * @param userId
	 * @return
	 */
	@Override
	public List<SysUserEntity> queryUserInfo(Long userId) {
		return sysUserDao.queryUserInfo(userId);
	}
}
```

### 测试
```aidl
@RunWith(SpringRunner.class)
@SpringBootTest
public class MabatisTest {
    private final static Logger logger = LoggerFactory.getLogger(MabatisTest.class);

    @Autowired
    private SysUserService sysUserService;

    @Test
    public void queryUserInfo() throws Exception {
        SysUserEntity userEntity = new SysUserEntity();
        userEntity.setUserId(1L);
        List<SysUserEntity> list = sysUserService.queryUserInfo(userEntity.getUserId());
        logger.info("list:" + list);
    }

}
```
