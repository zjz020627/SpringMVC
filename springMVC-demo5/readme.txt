拦截器
作用：拦截控制器方法

1.类实现HandlerInterceptor接口

2.springMVC配置里配置拦截器
<!--配置拦截器-->
<mvc:interceptors>
        <!--以下两种方式都是对DispatcherServlet所处理的所有的请求进行拦截-->
        <!--<bean class="com.study.mvc.interceptors.FirstInterceptor"></bean>-->
        <!--<ref bean="firstInterceptor"></ref>-->
        <!--
            下面方式表示自定义拦截规则
            mapping /** 表示匹配所有请求
            exclude-mapping / 除了 / 以外都拦截
        -->
        <mvc:interceptor>
            <mvc:mapping path="/**"/>
            <mvc:exclude-mapping path="/"/>
            <ref bean="firstInterceptor"/>
        </mvc:interceptor>
    </mvc:interceptors>

3.重写实现接口类中的三个方法
preHandle:在控制器方法执行之前执行

postHandle:在控制器方法执行之后执行

afterCompletion:渲染视图完毕后执行

多个拦截器执行顺序

preHandle按照配置的顺序来执行

postHandle和afterCompletion按照配置的反序执行



有5个拦截器
1.first     preHandle --> true
2.second    preHandle --> true
3.third     preHandle --> true
4.four       preHandle --> false
5.five      preHandle --> true

上面5个拦截器
直到最后一次拦截前的preHandle都会执行,
postHandle一个都不会执行,
直到最后一次拦截前的afterCompletion都会执行