

import com.spring.InjectionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
public class TestInjection extends UnitTestBase {

    public TestInjection() {
        super("classpath*:spring-ioc.xml");
    }
    @Test
    public  void test(){
        InjectionService service =super.getBean("injectionService");
        service.save("这是要保存的数据");
    }
}
