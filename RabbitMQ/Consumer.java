package com.yuhui.order.dynamicform.test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.AMQP.BasicProperties;

public class Consumer {

	public static void main(String[] args) {

		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		factory.setUsername("guest");
		factory.setPassword("guest");
		try {
			// 建立到代理服务器到连接
			Connection connection = factory.newConnection();
			// 获得信道
			Channel channel = connection.createChannel();
			String queue = channel.queueDeclare().getQueue();
			String routeKey = "hello";
			// 声明交换器
			String exchangeName = "hello-exchange";
			channel.queueBind(queue, exchangeName, routeKey);

			while (true) {
				boolean autoAck = false;
				String consumerTag = "";
				channel.basicConsume(queue, autoAck, consumerTag, new DefaultConsumer(channel) {
					@Override
					public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties,
							byte[] body) throws IOException {
						String bodyStr = new String(body);
						System.out.println(bodyStr);
					}
				});

			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}

	}

}
