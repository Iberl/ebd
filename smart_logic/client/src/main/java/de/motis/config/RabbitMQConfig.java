package de.motis.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;
import org.springframework.stereotype.Component;

/**
 *  @author iberl@verkehr.tu-darmstadt.de
 *  @version 1.0
 *  @since 2021-05-28
 *
 * Diese Klasse verwaltet die Verbindung zu Motis. Der Nachrichtenaustausch findet ueber einen RabbitMQ-Server.
 * Die Verbindungsdaten werden in dieser Klasse gehalten.
 *
 */

@Component
@ConfigurationProperties("spring.rabbitmq")
public class RabbitMQConfig {



        private String queuename;

        private String exchange;

        private String routingKey;

        public RabbitMQConfig() {
        }


        public Queue getQueue() {
            return new Queue(queuename, false);
        }


        public TopicExchange exchange() {
            return new TopicExchange(exchange);
        }
        @Bean
        Binding binding() {
            return BindingBuilder.bind(getQueue()).to(exchange()).with(routingKey);
        }

        /*@Bean
        SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
                                                 MessageListenerAdapter listenerAdapter) {
            SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
            container.setConnectionFactory(connectionFactory);
            container.setQueueNames(queue);
            container.setMessageListener(listenerAdapter);
            return container;
        }*/



        @Bean
        public Jackson2JsonMessageConverter getMessageConverter() {
            return new Jackson2JsonMessageConverter();

        }


        /**
         * Diese Bean definiert den Nachrichten-Converter
         * @return den Converter der mit den Nachrichten einhergeht
         */
        @Bean
        public MappingJackson2MessageConverter consumerJackson2MessageConverter() {
            return new MappingJackson2MessageConverter();
        }

        /**
         * Die Nachrichtenverwaltung muss ueber den MessageHandler definiert werden. Diese Bean geibt den Handler wieder
         * @return Handler zur Nachrichtenverwaltung
         */
        @Bean
        public DefaultMessageHandlerMethodFactory messageHandlerMethodFactory() {
            DefaultMessageHandlerMethodFactory factory = new DefaultMessageHandlerMethodFactory();

            return factory;
        }

        public String getRoutingKey() {
            return routingKey;
        }

        public String getQueuename() {
            return queuename;
        }

        public void setQueuename(String queuename) {
            this.queuename = queuename;
        }

        public String getExchange() {
                return exchange;
        }


        public void setExchange(String exchange) {
            this.exchange = exchange;
        }

        public void setRoutingKey(String routingKey) {
            this.routingKey = routingKey;
        }
}
