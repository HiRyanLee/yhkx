#工程说明
  该工程为统一电商平台-营销中心sale promotion，业务范围：
- 营销活动计价
- 营销活动处理

版本控制
SNA 
#项目结构：
 - ecip-sp-restapi  
   Contorller、Servlet、Filter、Intercetor、ExceptionHandler
           参数检查、参数解析（User）、响应报文生成  
 - ecip-sp-service  
   负责业务逻辑
 - ecip-sp-storage（mybaits + velocity）  
   负责Cache、DB操作、velocity生成数据库相关代码
 - ecip-sp-core  
   负责Model、Enum、Exception、Util...
   
#开发说明：   
## DB操作类：
    1.建表至Oracle
    2.使用OracleGenerator
      设置DB的url,user,password三个变量
      修改wantedTableName为想要的表名
      WIN/MAC操作系统路径名规范的不同所以需要修改，getProjectPath()方法
    3.运行main方法
    
## Cache操作类：
    1.所有的RedisKey统一在RedisKeyUtil中保存
    2.涉及到retryer的操作在xxCache中自行解决
    3.
    
## 异常处理：
    1.可能抛出NPE异常的方法必须强制在注释中说明
    2.Service尽可能多的处理异常
    3.Controller不处理异常，抛出给CommonExceptionHandler进行处理
    
## 拦截器、过滤器：
    1.拦截器过滤器例子参照ecip-sp-restapi中的filter/interceptor
    步骤：
       - 新建Interceptor、Filter
       - 在WebConfig中声明顺序、匹配路径
       
## 代码调用顺序
    Controller->Service-Stroage
    不可以跨层调用

## 日志使用方式
    ApiLogger.info("xxx");
    ApiLogger.error("xxx", e);
    
## HTTP调用方式
    HttpUtil.get(url, null);
    HttpUtil.postWithJson("http://11.4.66.30:8080/xmusp-ws/ws/booking/flightSearch", "", headers);


## 主要事项：
    1.注释尽量全，代码使用阿里规约插件自查

## 分支管理：
    1.master分支与线上运行代码严格一致
    2.线上版本bug修复请使用新分支master_fix_xxx修复并验证后，再合并至master上
    3.develop
    5.git提交需要说明此次提交的目的：
      feat：新功能（feature）
      fix：修补bug
      docs：文档变更（documentation）
      style： 代码风格变更（不影响任何代码）
      refactor：重构（即不是新增功能，也不是修改bug的代码变动）
      test：增加测试
      chore：开发工具（构建过程或辅助工具的变动）

## 合作开发：
    1.如果一个工程由多人合作，涉及到A->B的调用，请B先给出API设计，使AB并行开发
    

## 命名规范：
	控制器/服务类/DB操作/Cache类操作一定要带后缀
	OfferController
	OfferService(Impl)
	OfferDao(Impl)
	OfferCache(Impl)
	
## 工程注解列表：
### Bean生成
    @Service
    注解在类上，表示一个业务层Bean
    
    @Controller
    注解在类上，表示一个控制层Bean
    
    @Repository
    注解在类上，表示一个数据层Bean
    
    @Component
    注解在类上，表示通用Bean
    
    @Scope
    注解在类上，描述Spring容器如何创建Bean实例
    
    @Value
    注解在变量上，从配置文件中读取

### Bean注入
    @Autowired
    按类型装配
    
    @Qualifier
    当有多个同一类型的Bean时，可以用@Qualifier(“name”)来指定。与@Autowired配合使用
    
    @Resource
    按名称装配

    @SpringBootApplication
    @SpringBootApplication=@Configuration+@EnableAutoConfiguration+@ComponentScan。
    
    @Configuration 
    注解在类上，表示这是一个IOC容器，类似于springMVC的xml配置文件转化得到的java配置
    
    @Bean
    注解在方法上，声明当前方法返回一个Bean
    
    @PostContruct
    注解在方法上，构造函数执行后执行
    
    @PreDestroy
    注解在方法上，在Bean销毁之前执行
    
    @EnableAutoConfiguration 自动配置。
    
    @ComponentScan
    注解在类型上，扫描标准了@Controller、@Service、@Repository、@Component注解的类，注册为Bean
   
    @Lazy
    延迟初始化

### 控制器  
    @RestController注解是@Controller和@ResponseBody的合集,表示这是个控制器bean,
    并且是将函数的返回值直接填入HTTP响应体中,是REST风格的控制器。
    @RestController=@ResponseBody+@Controller
    
    @PathVariable
    获取参数
    
    @ControllerAdvice
    注释在类上，表示统一处理异常的
    
    @ExceptionHandler（Exception.class）
    注释在方法上，面表示遇到这个异常就执行以下方法。
    
    @RequestBody
    注释在变量上，获取原始的HTTP请求报文
    
    
##几句鸡汤：
- 磨刀不误砍柴工
- 代码是写给人看的，所以需要尽量多的注释
- 要对自己的每一行代码负责