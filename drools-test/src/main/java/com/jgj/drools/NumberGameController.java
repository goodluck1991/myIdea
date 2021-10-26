package com.jgj.drools;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 循环打印 1 到 50，
 * 是 5 的倍數就印 five，
 * 是 7 的倍數就印 seven，
 * 同時是 5 和 7 的倍數就印  five and seven,
 * 否则打印数字本身
 *
 * @author Alnex
 * @date: 2020/11/3 9:05
 */
@RestController
@RequestMapping("number")
public class NumberGameController {

    @GetMapping("/")
    public Object numberGame() {
        // KieServices is the factory for all KIE services
        KieServices kieServices = KieServices.Factory.get();

        // From the kie services, a container is created from the classpath
        KieContainer kieContainer = kieServices.getKieClasspathContainer();

        KieSession kieSession = null;
        // 初始化数据
        List<Number> lists = getDataInit();
        for (Number number : lists) {
            // From the container, a session is created based on
            // its definition and configuration in the META-INF/kmodule.xml file
            // 此处的 KieSession name 要与 kmodule.xml 文件定义的session name 保持一致
            kieSession = kieContainer.newKieSession("numberGame");

            kieSession.insert(number);
            kieSession.fireAllRules();
            System.out.println("第" + number.getNumber() + "条数据的匹配数据为" + number.getStyle());
        }
        assert kieSession != null;
        kieSession.dispose();
        return "规则匹配完成";
    }

    private List<Number> getDataInit() {
        List<Number> list = new ArrayList<>();
        Number number = null;
        for (int i = 0; i < 50; i++) {
            number = new Number();
            number.setNumber(i);

            list.add(number);
        }
        return list;
    }
}
