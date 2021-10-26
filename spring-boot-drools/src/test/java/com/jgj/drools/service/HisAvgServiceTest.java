package com.jgj.drools.service;

import com.jgj.drools.base.BaseTest;
import com.jgj.drools.domain.UserInfo;
import com.jgj.drools.dto.UserInfoItemDTO;
import com.jgj.drools.enums.HistSubEnum;
import com.jgj.drools.util.SpringBeanUtils;
import org.drools.core.base.RuleNameEqualsAgendaFilter;
import org.junit.Test;
import org.kie.api.KieBase;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.AgendaFilter;
import org.kie.api.runtime.rule.Match;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.*;

public class HisAvgServiceTest extends BaseTest {

    @Resource
    private KieBase kieBase;

    @Test
    public void setVal(){
        KieSession kieSession = kieBase.newKieSession();

        UserInfoItemDTO userInfoItemDTO = new UserInfoItemDTO();

        UserInfo userInfo = new UserInfo();
        userInfo.setNature("A");
        userInfo.setPsCode("psCode001");

        userInfoItemDTO.setUserInfo(userInfo);

        Set<String> histSubThrPsEnums = new HashSet<>();
        histSubThrPsEnums.add(HistSubEnum.item01.getCode());
        userInfoItemDTO.setHistSubThrPsEnums(histSubThrPsEnums);

        Map<String, Set<Long>> map = new HashMap<>();
        Set<Long> set = new HashSet<>();
        map.put(HistSubEnum.item01.getCode(), set);
        userInfoItemDTO.setServiceIdMap(map);


        kieSession.insert(userInfoItemDTO);
//        kieSession.fireAllRules(new RuleNameEqualsAgendaFilter("field_object"));
        kieSession.fireAllRules();
        kieSession.dispose();
        System.out.println(userInfoItemDTO.getServiceIdMap());
    }

    @Test
    public void calculate() {
        for (UserInfo userInfo : initData()) {
            KieSession kieSession = kieBase.newKieSession();
            kieSession.insert(userInfo);

            kieSession.fireAllRules(1);
            HisAvgService hisAvgService = SpringBeanUtils.getByName(userInfo.getServiceName());
            if (hisAvgService != null) {
                hisAvgService.calculate(userInfo);
            }
            kieSession.dispose();
        }
    }

    private List<UserInfo> initData() {
        List<UserInfo> list = new ArrayList<>();

        UserInfo userInfo1 = new UserInfo();
        userInfo1.setNature("A");
        userInfo1.setPsCode("psCode001");

        UserInfo userInfo2 = new UserInfo();
        userInfo2.setNature("B");
        userInfo2.setPsCode("psCode001");

        UserInfo userInfo3 = new UserInfo();
        userInfo3.setNature("B");
        userInfo3.setPsCode("psCode002");

        UserInfo userInfo4 = new UserInfo();
        userInfo4.setNature("D");
        userInfo4.setPsCode("psCode000");

        list.add(userInfo1);
        list.add(userInfo2);
        list.add(userInfo3);
        list.add(userInfo4);

        return list;
    }
}
