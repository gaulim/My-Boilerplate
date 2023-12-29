# My-Boilerplate

## SpringBoot

### 1. 개발환경

|             | Java형태 | Kotlin형태     | 비고                 |
|:-----------:|:--------:|:--------------:|:---------------------|
| Spring Boot | 3.2.0    | 3.2.0          |                      |
| Kotlin      | -        | 1.9.20         |                      |
| Gradle      | 8.5      | 8.5            | Groovy               |
| JVM         | 21       | 21             |                      |
| Lombok      | 사용함   | 사용안함       |                      |
| Logger      | Logback  | kotlin-logging | 모두 Slf4j 기반 동작 |

### 2. 설정

2-1. 그래들 버전 판올림

```
gradle wrapper --gradle-version=<그래들버전>
```

### 3. 빌드/실행/중지

3-1. 의존성 새로 고침

```
./gradlew [--refresh-dependencies]
```

3-2. 빌드 산출물 제거 (클린)

```
./gradlew clean
```

3-3. 빌드 (의존성 새로 고침 포함 가능)

빌드시 jar 배포본이 생성되는 위치는 `<프로젝트루트>/build/libs` 이다.

```
./gradlew build [--refresh-dependencies]
```

3-4. 로컬에서 실행 및 중지

`bootRun` 방식으로 실행시 진행률이 80% 근처에서 멈추는 현상이 있는데 무시하면 된다.

```
./gradlew bootRun
```

중지하려면 <kbd>Ctrl</kbd>+<kbd>C</kbd> 버튼을 누른다.

3-5. 서버에서 jar 배포본을 백그라운드로 실행

빌드시 jar 배포본이 생성되는 위치는 `<프로젝트루트>/build/libs` 이다.

```
mkdir -p /tmp/<프로젝트명>
nohub java [옵션] -jar <배포파일.jar> > /tmp/<프로젝트명>/output.log 2>&1 & echo $! > /tmp/<프로젝트명>/.pid
```

3-6. 서버에서 백그라운드로 실행중인 프로세스를 중지

```
kill `cat /tmp/<프로젝트명>/.pid`
rm /tmp/<프로젝트명>/.pid
```
