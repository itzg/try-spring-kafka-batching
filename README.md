
This application demonstrates a few Kafka concepts using Spring Boot:
- Batching configured per-listener
- Disabled auto-startup of a consumer with explicit start after "configuration loads"

## Getting started

Start a Kafka container:
```shell
docker-compose up -d
```

Start the application:
```shell
./gradlew bootRun
```

## Sample output

```log

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v2.6.0)

2021-11-24 19:00:13.767  INFO 38256 --- [           main] me.itzg.app.Application                  : Starting Application using Java 17.0.1 on Quattro with PID 38256 (C:\Users\itzg\git\try-spring-kafka-batching\build\classes\java\main started by itzg in C:\Users\itzg\git\try-spring-kafka-batching)
2021-11-24 19:00:13.770  INFO 38256 --- [           main] me.itzg.app.Application                  : No active profile set, falling back to default profiles: default
2021-11-24 19:00:15.713  INFO 38256 --- [   scheduling-1] me.itzg.app.MessagesGenerator            : Generating messages 1..101
2021-11-24 19:00:15.717  INFO 38256 --- [           main] me.itzg.app.Application                  : Started Application in 2.553 seconds (JVM running for 3.682)
2021-11-24 19:00:15.721  INFO 38256 --- [           main] me.itzg.app.AppConfigLoader              : Starting
2021-11-24 19:00:15.812  INFO 38256 --- [   scheduling-1] me.itzg.app.MessagesGenerator            : Generated 100 messages
2021-11-24 19:00:25.733  INFO 38256 --- [   scheduling-1] me.itzg.app.AppConfigLoader              : Loaded...starting listener containers
2021-11-24 19:00:30.948  INFO 38256 --- [ntainer#0-0-C-1] o.s.k.l.KafkaMessageListenerContainer    : try-batching: partitions assigned: [messages-0, messages-1]
2021-11-24 19:00:31.019  INFO 38256 --- [ntainer#0-0-C-1] me.itzg.app.AppConsumer                  : Pretending to process contents=[Message 1, Message 2, Message 3, Message 4, Message 5, Message 6, Message 7, Message 8, Message 9, Message 10, Message 11, Message 12, Message 13, Message 14, Message 15, Message 16, Message 17, Message 18, Message 19, Message 20, Message 21, Message 22, Message 23, Message 24, Message 25, Message 26, Message 27, Message 28, Message 29, Message 30, Message 31, Message 32, Message 33, Message 34, Message 35, Message 36, Message 37, Message 38, Message 39, Message 40, Message 41, Message 42, Message 43, Message 44, Message 45, Message 46, Message 47, Message 48, Message 49, Message 50, Message 51, Message 52, Message 53, Message 54, Message 55, Message 56, Message 57, Message 58, Message 59, Message 60, Message 61, Message 62]
2021-11-24 19:00:36.079  INFO 38256 --- [ntainer#0-0-C-1] me.itzg.app.AppConsumer                  : Pretending to process contents=[Message 63, Message 64, Message 65, Message 66, Message 67, Message 68, Message 69, Message 70, Message 71, Message 72, Message 73, Message 74, Message 75, Message 76, Message 77, Message 78, Message 79, Message 80, Message 81, Message 82, Message 83, Message 84, Message 85, Message 86, Message 87, Message 88, Message 89, Message 90, Message 91, Message 92, Message 93, Message 94, Message 95, Message 96, Message 97, Message 98, Message 99, Message 100]
2021-11-24 19:01:15.819  INFO 38256 --- [   scheduling-1] me.itzg.app.MessagesGenerator            : Generating messages 101..201
2021-11-24 19:01:15.841  INFO 38256 --- [ntainer#0-0-C-1] me.itzg.app.AppConsumer                  : Pretending to process contents=[Message 101, Message 102]
2021-11-24 19:01:15.849  INFO 38256 --- [   scheduling-1] me.itzg.app.MessagesGenerator            : Generated 100 messages
2021-11-24 19:01:20.860  INFO 38256 --- [ntainer#0-0-C-1] me.itzg.app.AppConsumer                  : Pretending to process contents=[Message 103, Message 104, Message 105, Message 106, Message 107, Message 108, Message 109, Message 110]
2021-11-24 19:01:25.874  INFO 38256 --- [ntainer#0-0-C-1] me.itzg.app.AppConsumer                  : Pretending to process contents=[Message 111, Message 112, Message 113]
2021-11-24 19:01:30.890  INFO 38256 --- [ntainer#0-0-C-1] me.itzg.app.AppConsumer                  : Pretending to process contents=[Message 114, Message 115, Message 116, Message 117]

```