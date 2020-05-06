package com.reyes.tutorial.config;

public class BatisBase {
	
	
	/**
	 * MyBatis已交由github託管，可上github查詢 - https://github.com/mybatis/mybatis-3 github
	 * 										 - https://mybatis.org/mybatis-3/ doc
	 * 
	 * <select id="selectUsers" resultType="User">
		  select id, username, password
		  from users
		  where id = #{id}
		</select>
	 * 	上面的这个示例说明了一个非常简单的命名参数映射。鉴于参数类型（parameterType）会被自动设置为 int，这个参数可以随意命名。
	 * 	原始类型或简单数据类型（比如 Integer 和 String）因为没有其它属性，会用它们的值来作为参数
	 * 
	 * 
	 * <insert id="insertUser" parameterType="User">
		  insert into users (id, username, password)
		  values (#{id}, #{username}, #{password})
		</insert>
	 * 如果 User 类型的参数对象传递到了语句中，会查找 id、username 和 password 属性，然后将它们的值传入预处理语句的参数中。
	 * 
	 * 
	 * - mapper指定
	 * 		若在interface不使用 @Mapper annotation，則需要在config類或者springboot start 開啟mapperscan，指定接口
	 * 
	 * - 
	 * 		spring boot 啟動時，MybatisAutoConfiguration.class會自動配置相關資料
	 * 			- 	自動生成SqlSessionFactory
	 * 				public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
    					SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
    			-	在yml的配置名為MybatisProperties.class-mybatis開頭
    			-	可以客製化配置一些資料(ConfigurationCustomizer)，可參照MyBatisconfig.class測試
    				private void applyConfiguration(SqlSessionFactoryBean factory) {
					    Configuration configuration = this.properties.getConfiguration();
					    if (configuration == null && !StringUtils.hasText(this.properties.getConfigLocation())) {
					      configuration = new Configuration();
					    }
					    if (configuration != null && !CollectionUtils.isEmpty(this.configurationCustomizers)) {
					      for (ConfigurationCustomizer customizer : this.configurationCustomizers) {
					        customizer.customize(configuration);
					      }
					    }
					    factory.setConfiguration(configuration);
					  }
	 * 
	 */

}
