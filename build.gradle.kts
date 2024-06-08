plugins {
    id("java")
}

group = "org.ERPSystem"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.apache.poi:poi:5.0.0") // Excel 파일 읽기
    implementation("org.apache.poi:poi-ooxml:5.0.0") // Excel 파일 읽기
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")

}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}
