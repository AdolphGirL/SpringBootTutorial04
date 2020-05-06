package com.reyes.tutorial.config;

import org.apache.ibatis.session.Configuration;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;

/**
 * @MapperScan，開啟mapper掃描，也可以不用，但mapper上就必須開啟@Mapper
 * 				掃描指定路徑下
 */
//@MapperScan(value = "com.reyes.tutorial.mapper")，暫時取消，因為測試配置xml，在yml有設定mapper location
@org.springframework.context.annotation.Configuration
public class MyBatisconfig {
	
	/**
	 * 可以設定資料庫欄位和java bean欄位的映射方式
	 * 例如，如果資料庫為xxx_yyy，而java bean為xxxYYY
	 * 
	 */
	@Bean
	public ConfigurationCustomizer configurationCustomizer(){
		return new ConfigurationCustomizer(){

			@Override
			public void customize(Configuration configuration) {
				// 下底線(資料庫欄位)自動轉換為駝峰字(bean)
				configuration.setMapUnderscoreToCamelCase(true);
			}
			
		};
	}
	
}
