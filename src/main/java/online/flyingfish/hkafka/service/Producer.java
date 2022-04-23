package online.flyingfish.hkafka.service;

import online.flyingfish.hkafka.Order;

public interface Producer {

    void send(Order order);

    void close();

    // add your interface method here

    // and then implement it

}
