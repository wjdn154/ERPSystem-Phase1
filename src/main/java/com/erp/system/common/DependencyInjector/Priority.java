package com.erp.system.common.DependencyInjector;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 클래스의 우선순위를 지정하는 어노테이션.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE) // 클래스, 인터페이스, 열거형에 적용 가능
public @interface Priority {
    int value();
}