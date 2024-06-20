package com.erp.system.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 자동으로 등록할 컴포넌트를 나타내는 어노테이션.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE) // 클래스, 인터페이스, 열거형에 적용 가능
public @interface Component {
}