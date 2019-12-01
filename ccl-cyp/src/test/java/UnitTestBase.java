
import org.apache.commons.lang3.StringUtils;
import org.junit.After;
import org.junit.Before;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class UnitTestBase {
    // 文件模式绝对路径FileSystemXmlApplicationContext context =new FileSystemXmlApplicationContext("文件绝对路径.xml")
    // web应用<listener><listener-class>  org.springframework.web.context.Context.LoaderListener</listener-class></listener>
    //<servlet>
    //-------------------分割线--------------上下分别是web应用中的两种不同的方式
    //<servlet-name>context<servlet-name>
    //<servlet-class>org.springframework.web.contextContextLoaderServlet</servlet-class>
    //<load-on-startup>1<...
    //</servlet>
    //以及下面这种classpath模式 相对路径
    private ClassPathXmlApplicationContext context;
    private  String springXmlpath;
    public UnitTestBase (String springXmlpath){
        this.springXmlpath=springXmlpath;
    }
    @Before
    public void before(){
        if(StringUtils.isEmpty(springXmlpath)){
            springXmlpath="classpath*:spring-*.xml";
        }
        context =new ClassPathXmlApplicationContext(springXmlpath.split("[,\\s]+"));
        context.start();
    }
    @After
    public void after(){
        context.destroy();
    }
    @SuppressWarnings("unchecked")
    protected <T extends Object> T  getBean(String beanId){
        return (T)context.getBean(beanId);

    }
    protected <T extends  Object> T getBean(Class<T>  clazz){

        return context.getBean(clazz);
    }
}
