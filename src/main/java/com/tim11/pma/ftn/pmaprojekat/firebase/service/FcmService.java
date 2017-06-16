package com.tim11.pma.ftn.pmaprojekat.firebase.service;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.bytefish.fcmjava.http.client.IFcmClient;
import de.bytefish.fcmjava.model.enums.ErrorCodeEnum;
import de.bytefish.fcmjava.model.options.FcmMessageOptions;
import de.bytefish.fcmjava.model.topics.Topic;
import de.bytefish.fcmjava.requests.notification.NotificationPayload;
import de.bytefish.fcmjava.requests.topic.TopicUnicastMessage;
import de.bytefish.fcmjava.responses.TopicMessageResponse;

@Service
public class FcmService {

	@Autowired
	private IFcmClient fcmClient;
	
	public void sendPushMessage(String text) {
	    FcmMessageOptions options = FcmMessageOptions.builder()
	        .setTimeToLive(Duration.ofMinutes(10)).build();

	    NotificationPayload payload = NotificationPayload.builder()
	        .setBody(text).setTitle("Hotel notification")
	        .setTag("tag").setSound("default").build();

	    Map<String, Object> data = new HashMap<>();
	    data.put("id", "id1");
	    data.put("text", text);

	    // Send a message
	    System.out.println("Sending notification...");

	    Topic topic = new Topic("main");
	    TopicUnicastMessage message = new TopicUnicastMessage(options, topic, data, payload);

	    
	    
	    TopicMessageResponse response = this.fcmClient.send(message);
	    ErrorCodeEnum errorCode = response.getErrorCode();
	    if (errorCode != null) {
	      System.out.println("Topic message sending failed: " + errorCode);
	    }
	  }
	
	public void sendPushMessage(String title, String body, String topicName, Map<String, Object> data, String tag) {
	    FcmMessageOptions options = FcmMessageOptions.builder()
	        .setTimeToLive(Duration.ofMinutes(10)).build();

	    NotificationPayload payload = NotificationPayload.builder()
	        .setBody(body).setTitle(title)
	        .setTag(tag).setSound("default").build();


	    Topic topic = new Topic(topicName);
	    TopicUnicastMessage message = new TopicUnicastMessage(options, topic, data, payload);

	    TopicMessageResponse response = this.fcmClient.send(message);
	    ErrorCodeEnum errorCode = response.getErrorCode();
	    if (errorCode != null) {
	      System.out.println("Topic message sending failed: " + errorCode);
	    }
	  }
	
}
