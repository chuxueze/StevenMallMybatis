# StevenMallMybatis

## 功能说明
使用SpringBoot+MyBatis进行数据的操作

## 总结
1、 在pom.xml文件中引入相关三方件：
```
        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
            <version>1.1.1</version>
        </dependency>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.11</version>
        </dependency>

```
2、application.properties文件中添加数据库相关的连接
```
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
spring.datasource.url=jdbc:mysql://192.168.192.11:3306/steven-mall-mybatis-db?useUnicode=true&characterEncoding=UTF-8
spring.datasource.username=root
spring.datasource.password=##密码##
spring.datasource.max-active=10
spring.datasource.max-idle=5
spring.datasource.min-idle=0
#mybatis.mapper-locations=classpath:/mybatis/*Mapper.xml
mybatis.type-aliases-package=com.steven.mall.domain
mybatis.config-locations=classpath:mybatis/mybatis-config.xml
mybatis.mapper-locations=classpath:mybatis/mapper/*.xml
```

3、编写mybatis-config.xml文件
```
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration PUBLIC "-//mybatis.org//DTD Config 3.0//EN" "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <typeAliases>
        <typeAlias alias="Integer" type="java.lang.Integer" />
        <typeAlias alias="Long" type="java.lang.Long" />
        <typeAlias alias="HashMap" type="java.util.HashMap" />
        <typeAlias alias="LinkedHashMap" type="java.util.LinkedHashMap" />
        <typeAlias alias="ArrayList" type="java.util.ArrayList" />
        <typeAlias alias="LinkedList" type="java.util.LinkedList" />
    </typeAliases>
</configuration>
```
4、编写具体的mapper文件
```
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="com.steven.mall.mapper.DealMapper">
    <resultMap id="BaseResultMap" type="com.steven.mall.domain.Deal">
        <id column="id" property="id" jdbcType="BIGINT"/>
        <result column="deal_title" property="dealTitle" jdbcType="VARCHAR"/>
        <result column="sku_id" property="skuId" jdbcType="VARCHAR"/>
    </resultMap>
    <select id="getAllDeals" resultMap="BaseResultMap">
        SELECT *
        FROM deal
    </select>
</mapper>
```
5、编写Mapper操作类
```
/**
 * 定义接口映射器
 */
@Repository
//@Mapper
public interface DealMapper {
    // 查询所有商品
    //@Select("Select * from deal")
    List<Deal> getAllDeals();
}
```
6、以注入的方式，编写最终的逻辑实现类
```
    // 注入用户Service
    @Autowired
    private DealMapper dealMapper;

    @RequestMapping("/list")
    public List<Deal> getAllDeals(){
        List<Deal> deals = dealMapper.getAllDeals();
        return  deals;
    }
```