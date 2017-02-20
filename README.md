# Kafka Object Serialization Deserialization

This is an activator project for showcasing how to create a custom serializer and deserializer using Kafka APIs in which we are pushing Tweets as an object in Kafka Cluster and consuming the same object.

Here we are using : 

**Kafka Client** 

**Twitter4J Streaming** as a source.

**Jackson ObjectMapper** for byte stream conversion.

**Typesafe Config** to read configuration file.

###Serialization and Deserialization

Serialization is the process of converting an object into a stream of bytes and these bytes are used for transmission. Kafka stores and transmit these bytes of array in its queue.

Deserialization as the name suggest does the opposite of serialization where we convert bytes of array into the desired data type. Kafka provides serializer and deserializer for few data types **_String, Long, Double, Integer, Bytes etc._**

**Implementation**

To create serializer class we need to implement org.apache.kafka.common.serialization.Serializer interface and to create deserializer class we need to implement org.apache.kafka.common.serialization.Deserializer interface.

Both serializer and deserializer interfaces consist of three methods:

* **configure** : This method is called at startup to set configuration details.

* **serialize/deserialize** : This method is used for serialization and deserialization.

* **close** : This method is called when Kafka session needs to be closed.

**com.knoldus.kafka.utils.TweetSerializer** : This class is used to serialize the **_com.knoldus.utils.Tweet_** objects and is used at the time of producing messages.

**com.knoldus.kafka.utils.TweetDeserializer** : This class is used to deserialize the **_com.knoldus.utils.Tweet_** objects and is used at the time of consuming messages. 

We need to register serializer/deserializer properties in their respective class.

Serializer: 
```java
props.put("value.serializer", "com.knoldus.kafka.utils.TweetSerializer");
```

Deserializer: 
```java
props.put("value.deserializer", "com.knoldus.kafka.utils.TweetDeserializer");
```

---

### Steps to Install and Run Zookeeper and Kafka on your system :

**Step 1:** _Download Kafka_

Download Kafka from [here](https://www.apache.org/dyn/closer.cgi?path=/kafka/0.10.1.1/kafka_2.11-0.10.1.1.tgz)

**Step 2:** _Extract downloaded file_

```bash
tar -xzvf kafka_2.11-0.10.1.1.tgz
cd kafka_2.11-0.10.1.1
```

**Step 3:** _Start Servers_

Start Zookeeper:

```bash
bin/zookeeper-server-start.sh config/zookeeper.properties
```

Start Kafka server:

```bash
bin/kafka-server-start.sh config/server.properties
```

### Clone Project

```bash
git clone git@github.com:knoldus/activator-kafka-serialization-deserialization.git
cd activator-kafka-serialization-deserialization
bin/activator clean compile
```

### Start Tweet Producer

```bash
bin/activator "run-main com.knoldus.demo.ProducerDemo"
```
This will start fetching tweets and push every tweet into the Kafka queue.

### Start Tweet Consumer

```bash
bin/activator "run-main com.knoldus.demo.ConsumerDemo"
```

This will start consuming/pulling tweets from Kafka queue.

For any issue please raise a ticket @ [Github Issue](https://github.com/knoldus/activator-kafka-serialization-deserialization/issues)