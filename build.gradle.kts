plugins {
    id("java")
}

group = "org.ERPSystem-Phase1"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.apache.poi:poi:5.0.0") // POI 라이브러리 : 마이크로소프트 오피스 파일을 자바 언어로 읽고 쓰는 기능을 제공
    implementation("org.apache.poi:poi-ooxml:5.0.0") // POI 라이브러리 : 마이크로소프트 오피스 파일을 자바 언어로 읽고 쓰는 기능을 제공
    implementation("org.reflections:reflections:0.10.2") // 리플렉션 라이브러리 : 자바 리플렉션을 이용하여 클래스를 동적으로 로드하고 메소드를 실행할 수 있음
    implementation("org.slf4j:slf4j-api:1.7.30") // SLF4J 라이브러리 : 로깅을 위한 라이브러리
    implementation("ch.qos.logback:logback-classic:1.2.3") // Logback 라이브러리 : SLF4J 라이브러리를 이용하여 로깅을 구현한 라이브러리
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")

}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}