package com.jgj.drools.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class SpringBeanUtils implements BeanFactoryPostProcessor {

    private static ConfigurableListableBeanFactory beanFactory;

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        beanFactory = configurableListableBeanFactory;
    }

    public static <T> T getByName(String beanName) {
        return ((T) beanFactory.getBean(beanName));
    }

    public static <T> T getByType(Class<T> beanType) {
        return beanFactory.getBean(beanType);
    }
}
