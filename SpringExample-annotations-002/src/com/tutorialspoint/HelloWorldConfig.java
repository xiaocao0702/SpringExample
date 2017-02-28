package com.tutorialspoint;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @Import 注解:
 * @import 注解允许从另一个配置类中加载 @Bean 定义。
 * 你可以在另一个 Bean 声明中导入上述 Bean 声明
 * @Import(ConfigA.class)
 * 不需要同时引入两个class
 * 这样只需在主函数中声明HelloWorldConfig，则不需再额外的引入AppConfig了
 * @author caopl
 *
 */
@Configuration
@Import(AppConfig.class)
public class HelloWorldConfig {

	@Bean
	public HelloWorld helloWorld() {
		return new HelloWorld();
	}
}
