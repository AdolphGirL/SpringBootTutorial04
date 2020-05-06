#### spring boot with mybatis 註解版與配置版
- MyBatis已交由github託管，可上github查詢  
  - https://github.com/mybatis/mybatis-3
  - https://mybatis.org/mybatis-3/，doc
- MyBatis簡單範例  
  ```
  <select id="selectUsers" resultType="User">
    select id, username, password from users where id = #{id}
  </select>

  parameterType，當為原始類型的資料時，會自動拿它們的值來做為參數。
  而#{id}，可以任意命名
  ```

  ```
  <insert id="insertUser" parameterType="User">
    insert into users (id, username, password) values (#{id}, #{username}, #{password})
  </insert>

  parameterType - User，當傳入user時，會自動尋找id、username、password屬性
  ```

- mapper指定  
  若在interface不使用 @Mapper annotation，則需要在config類或者springboot start 開啟mapperscan，指定接口。  

  ```
  mybatis:
  config-location: classpath:mybatis/mybatis-config.xml
  mapper-locations: classpath:mybatis/mapper/*.xml
  ```

- spring boot 啟動時，MybatisAutoConfiguration.class會自動配置相關資料
  - 自動生成SqlSessionFactory  
    ```
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
    					SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
    ```
  - 在yml的配置名為MybatisProperties.class-mybatis開頭

  - 可以客製化配置一些資料(ConfigurationCustomizer)，可參照MyBatisconfig.class測試
    ```
    private void applyConfiguration(SqlSessionFactoryBean factory) {
		 Configuration configuration = this.properties.getConfiguration();
		   if (configuration == null && !StringUtils.hasText(this.  properties.getConfigLocation())) {
		      configuration = new Configuration();
		   }
		   if (configuration != null && !CollectionUtils.isEmpty(this.configurationCustomizers)) {
                    for (ConfigurationCustomizer customizer : this.configurationCustomizers) {
                        customizer.customize(configuration);
                    }
		}
		factory.setConfiguration(configuration);
	}
    ```
- 註解版，但若不使用 Mapper annotation，則需要在config類或者springboot start 開啟mapperscan，指定接口
  ```
  @Mapper
    public interface DepartmentMapper {
        
    //	測試，故意亂用一個變數名xx
        @Select("select * from department where id = #{xx}")
        public Department getDeptById(Integer id);
        
        @Delete("select * from department where id = #{xx}")
        public int deleteDeptById(Integer id);
        
    //	#{name}解析物件名，會自動將原先寫入後新增的主鍵的值，綁定回物件department
        @Options(useGeneratedKeys = true, keyProperty = "id")
        @Insert("insert into department (name) values (#{name})")
        public int insertDepartment(Department department);
        
        @Update("update department set name = #{name} where id = #{id}")
        public int updateDepartment(Department department);
        
    }
  ```
- xml配置，@MapperScan，開啟mapper掃描，也可以不用，但mapper上就必須開啟@Mapper掃描指定路徑下  
  ```
  @MapperScan(value = "com.reyes.tutorial.mapper")，暫時取消，因為測試配置xml，在yml有設定mapper location
  ```