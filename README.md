# hkafka
High Availability Kafka, Spring Boot


### 单机安装部署

1、kafka安装

http://kafka.apache.org/downloads

下载`kafka_2.13-3.1.0.tgz`，解压。

2、启动kafka：

命令行下进入kafka目录

修改配置文件 vim config/server.properties

打开 listeners=PLAINTEXT://localhost:9092

```
nohup bin/zookeeper-server-start.sh config/zookeeper.properties &

bin/kafka-server-start.sh config/server.properties
```

3、命令行操作Kafka

```
bin/kafka-topics.sh --bootstrap-server localhost:9092 --list  # 查看有多少topic
bin/kafka-topics.sh --bootstrap-server localhost:9092 --create --topic testk --partitions 4 -- replication-factor 1 
bin/kafka-topics.sh --bootstrap-server localhost:9092 --describe --topic testk 
bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --from-beginning --topic testk 
bin/kafka-console-producer.sh --bootstrap-server localhost:9092 --topic testk

```

4、简单性能测试

```
# 生产者
bin/kafka-producer-perf-test.sh --topic testk --num-records 100000 --record-size 1000 --throughput 2000 --producer-props bootstrap.servers=localhost:9092 

# 消费者
bin/kafka-consumer-perf-test.sh --bootstrap-server localhost:9092 --topic testk --fetch-size 1048576 --messages 100000 --threads 1
```

结论：mac 本地 ssd 硬盘，1k 的数据，生产者和消费者基本10w-30w量级每秒


### 集群安装部署


