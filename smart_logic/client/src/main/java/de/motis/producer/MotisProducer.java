package de.motis.producer;

import de.ibw.tms.entities.TmsJpaApp;
import de.motis.config.RabbitMQConfig;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
/**
 *  @author iberl@verkehr.tu-darmstadt.de
 *  @version 1.0
 *  @since 2021-05-28
 *
 *  Diese Kompontent verwaltet den Nachrichtenversand als String an den Motis - Server
 *
 */

    @Component
    @ConfigurationProperties("jsa.rabbitmq")
    public class MotisProducer {


        private AmqpTemplate amqpTemplate = null;


        private String exchange;


        private String routingKey;




    /**
     * Sendet msg an den Motis-Server
     * @param msg - Nachrichten-String an den Server
     */
    public void produceMsg(String msg){
            if(amqpTemplate == null) {
                amqpTemplate = (AmqpTemplate) TmsJpaApp.getBean(AmqpTemplate.class);
            }
            amqpTemplate.convertAndSend(exchange, routingKey, msg);
            System.out.println("Send msg = " + msg);

    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getRoutingKey() {
        return routingKey;
    }

    public void setRoutingKey(String routingKey) {
        this.routingKey = routingKey;
    }
}
