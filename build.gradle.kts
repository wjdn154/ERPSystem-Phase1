plugins {
    id("java")
}

group = "org.ERPSystem"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.apache.poi:poi:5.0.0") // POI 라이브러리 : 마이크로소프트 오피스 파일을 자바 언어로 읽고 쓰는 기능을 제공
    implementation("org.apache.poi:poi-ooxml:5.0.0") // POI 라이브러리 : 마이크로소프트 오피스 파일을 자바 언어로 읽고 쓰는 기능을 제공
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")

}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}
