package com.erp.system.common;


import com.erp.system.common.annotation.Component;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

import java.lang.reflect.Constructor;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 의존성 주입을 관리하는 싱글톤 클래스.
 * 클래스들을 자동으로 등록하고 인스턴스화하여 의존성을 관리함.
 */
public class DependencyInjector {
    private static volatile DependencyInjector instance; // 싱글톤 인스턴스
    private final Map<Class<?>, Object> instances = new HashMap<>(); // 등록된 인스턴스를 저장하는 맵

    /**
     * 생성자: 클래스 초기화 및 자동 등록을 수행함.
     */
    private DependencyInjector() {
        System.out.println("\n--------------------------- 1. DependencyInjector 생성 ---------------------------\n");
        long startTime = System.nanoTime(); // 시작 시간 기록
        autoRegister();
        long endTime = System.nanoTime(); // 종료 시간 기록
        long duration = endTime - startTime; // 실행 시간 계산
        System.out.println("\n실행 시간: " + duration / 1_000_000 + " ms");
        System.out.println("--------------------------- 1. DependencyInjector 종료 ---------------------------\n");
    }

    /**
     * 싱글톤 인스턴스를 반환.
     * 인스턴스가 없으면 새로 생성.
     * @return DependencyInjector의 싱글톤 인스턴스
     */
    public static synchronized DependencyInjector getInstance() {
        if (instance == null) {
            instance = new DependencyInjector();
        }
        return instance;
    }

    /**
     * 요청된 타입의 인스턴스를 반환.
     * @param type 요청된 클래스 타입
     * @return 요청된 타입의 인스턴스, 없으면 오류 메시지 출력
     */
    public <T> T getInstance(Class<T> type) {
        T instance = type.cast(instances.get(type));
        if (instance == null) {
            System.err.println(type.getSimpleName() + "에 대한 인스턴스를 찾을 수 없습니다.");
        }
        return instance;
    }

    /**
     * 모든 클래스를 자동 등록함.
     * Reflections 라이브러리를 사용하여 @Component 애노테이션이 있는 클래스를 찾고 등록함.
     */
    private void autoRegister() {
        Reflections reflections = new Reflections(new ConfigurationBuilder()
                .setUrls(ClasspathHelper.forJavaClassPath())
                .setScanners(new SubTypesScanner(), new TypeAnnotationsScanner()));

        Set<Class<?>> allTypes = reflections.getTypesAnnotatedWith(Component.class);
        List<Class<?>> sortedTypes = sortTypesByDependencyOrder(allTypes);

        for (Class<?> clazz : sortedTypes) {
            if (!instances.containsKey(clazz)) {
                registerInstance(clazz);
            }
        }
    }

    /**
     * 클래스를 의존성 순서에 따라 정렬함.
     * @param types 정렬할 클래스 집합
     * @return 정렬된 클래스 리스트
     */
    private List<Class<?>> sortTypesByDependencyOrder(Set<Class<?>> types) {
        return types.stream()
                .sorted(Comparator.comparingInt(this::setOrder))
                .collect(Collectors.toList());
    }

    /**
     * 클래스의 우선순위를 설정함.
     * @param type 우선순위를 설정할 클래스
     * @return 설정된 우선순위 값
     */
    private int setOrder(Class<?> type) {
        if (type.getSimpleName().contains("BatchScheduler")) {
            return 1;
        } else if (type.getSimpleName().contains("Repository")) {
            return 2;
        } else if (type.getSimpleName().contains("Service")) {
            return 3;
        } else if (type.getSimpleName().contains("Controller")) {
            return 4;
        }
        return 5; // 기타 경우
    }

    /**
     * 주어진 클래스의 인스턴스를 생성하고 등록함.
     * @param clazz 등록할 클래스
     */
    private void registerInstance(Class<?> clazz) {
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        Arrays.sort(constructors, Comparator.comparingInt(Constructor::getParameterCount)); // 매개변수가 적은 생성자 우선

        for (Constructor<?> constructor : constructors) {
            try {
                constructor.setAccessible(true);
                Object[] params = Arrays.stream(constructor.getParameterTypes())
                        .map(param -> instances.get(param)) // 맵에서 인스턴스를 가져옴
                        .toArray();
                Object instance = constructor.newInstance(params);
                Class<?> keyType = findInterfaceType(clazz);
                instances.put(keyType != null ? keyType : clazz, instance);
                System.out.println("등록 성공 : " + clazz.getName());
                return;
            } catch (Exception e) {
                System.err.println("등록 실패 : " + clazz.getName() + "\n 사유 : " + e.getMessage());
            }
        }
        System.err.println(clazz.getName() + "에 적합한 생성자를 찾을 수 없습니다.");
    }

    /**
     * 클래스 타입에 따른 인터페이스 타입을 찾음.
     * @param clazz 찾을 클래스
     * @return 찾아진 인터페이스 타입 또는 null
     */
    private Class<?> findInterfaceType(Class<?> clazz) {
        // 여러 인터페이스가 구현된 경우 특정 인터페이스를 선택할 수 있도록 확장 가능
        return Arrays.stream(clazz.getInterfaces()).findFirst().orElse(null);
    }

    /**
     * 주어진 타입에 해당하는 모든 인스턴스를 반환.
     * @param type 찾을 타입
     * @return 찾은 인스턴스 맵
     */
    public Map<Class<?>, Object> getAllInstancesOfType(Class<?> type) {

        Map<Class<?>, Object> result = new HashMap<>();
        for (Map.Entry<Class<?>, Object> entry : instances.entrySet()) {
            if (type.isAssignableFrom(entry.getKey())) {
                result.put(entry.getKey(), entry.getValue());
            }
        }
        return result;
    }

    /**
     * 주어진 타입에 해당하는 인스턴스를 반환.
     * @param baseType 검색할 클래스의 기반 타입
     * @param type 반환될 인스턴스의 타입
     * @return 찾은 인스턴스, 없으면 null
     */
    public Object getInstancesOfType(Class<?> baseType, Class<?> type) {
        for (Map.Entry<Class<?>, Object> entry : instances.entrySet()) {
            // 'type'의 이름이 포함되어 있고, 'baseType'이 'entry.getKey()'에 할당 가능한 경우 해당 인스턴스 반환
            if (entry.getKey().getName().contains(type.getSimpleName()) && baseType.isAssignableFrom(entry.getKey())) {
                return entry.getValue();
            }
        }
        return null;
    }


}