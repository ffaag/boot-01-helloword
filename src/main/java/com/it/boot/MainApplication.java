package com.it.boot;

import com.it.boot.bean.Pet;
import com.it.boot.bean.User;
import com.it.boot.conifg.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author ZuYingFang
 * @time 2021-09-10 16:23
 * @SpringBootApplication：这是一个springBoot应用
 * 这是一个主程序类，所有的一切从这里开始，有一个就行了
 * 主程序所在包及其下面的所有子包里面的组件都会被默认扫描进来
 * o 无需以前的包扫描配置
 * o 想要改变扫描路径，@SpringBootApplication(scanBasePackages="com.it")
 *  或者@ComponentScan 指定扫描路径
 */

@SpringBootApplication  // 当前扫描包是com.it.boot下面的所有，上面说明了可以自己设置
public class MainApplication {

    public static void main(String[] args) {

        // 1 返回我们的IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);

        // 2 查看容器里面的组件
        String[] beanDefinitionNames = run.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }

        // 3 从容器中获取组件
        User user01 = run.getBean("user01", User.class);
        Pet tom = run.getBean("tom", Pet.class);
        System.out.println(user01);
        System.out.println(tom);

        // 4 MyConfig也是一个组件
        MyConfig bean = run.getBean(MyConfig.class);
        System.out.println(bean);

        // 如果@Configuration(proxyBeanMethods = true)代理对象调用方法。sprigboot总会检查这个组件是否在容器中存在
        // 保持组件单实例，有的话直接拿，没有就获取，这个时候两个user是相同的，如果是false，每次调用都会生成新的对象，则不相同
        User user = bean.user01();
        User user001 = bean.user01();
        System.out.println(user == user001);


        boolean tom1 = run.containsBean("tom");
        System.out.println(tom1);

        boolean user011 = run.containsBean("user01");
        System.out.println(user011);

    }

}
