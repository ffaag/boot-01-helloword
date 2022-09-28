package com.it.boot.conifg;

import ch.qos.logback.core.db.DBHelper;
import com.it.boot.bean.Car;
import com.it.boot.bean.Pet;
import com.it.boot.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * @author ZuYingFang
 * @time 2021-09-10 19:52
 */


/**
 * 表明这是个配置类，而且这个类也是一个IOC组件，proxyBeanMethods：代理bean的方法
 * Full(proxyBeanMethods = true) 先去容器中找，没有就创建，默认就是true，即全模式每次都要现去容器中找，比较慢
 * Lite(proxyBeanMethods = false)  IOC不会保存这些代理对象，不管怎么样，都会自行创建，这就是轻量级的，不用找，很快
 *      解决组件依赖的场景————当为true时，下面用到的pet就是依赖到的
 *
 * @Import({User.class, DBHelper.class})————给容器中自动创建这两个类型的组件，默认组件的名字为全类名
 *
 * @ConditionalOnBean(name = "helloController")————当容器中有这个MyConfig组件的时候我们才执行下面的代码，否则不执行
 *
 * @ImportResource("classpath:bean1.xml")————导入自己写的spring配置文件，可以放在任何一个类上面，一般放在这个类上面
 *
 */

@Import({User.class, DBHelper.class})
@Configuration(proxyBeanMethods = true)
@ConditionalOnBean(name = "helloController")
@ImportResource("classpath:bean1.xml")
@EnableConfigurationProperties(Car.class)   // 开启Car配置绑定功能，而且把这个Car组件自动注入到容器中
public class MyConfig {

    @Bean("tom")
    public Pet tomcatPet(){
        return new Pet("tomcat");
    }


    @ConditionalOnBean(name = "tom")   // 当容器中有这个tom组件的时候我们才执行下面的代码
    @Bean("user01")    // 不指定id时默认以方法名为id
    public User user01(){
        return new User("张三", 18, tomcatPet());
    }


}
