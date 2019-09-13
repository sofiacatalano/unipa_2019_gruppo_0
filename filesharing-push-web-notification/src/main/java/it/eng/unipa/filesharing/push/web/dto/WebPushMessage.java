package it.eng.unipa.filesharing.push.web.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import it.eng.unipa.filesharing.push.Message;

public class WebPushMessage implements Message{
	
	public String title;
	public String clickTarget;
	public Options options;	
	
	@JsonInclude(value = JsonInclude.Include.NON_NULL)
	public static class Options {
		
		/*
		 * "Visual Options",
		 */
		
		// "body": "<String>",
		public String body;
		// "icon": "<URL String>",
		public String icon;
		// "image": "<URL String>",
		public String image;
		// "badge": "<URL String>",
		public String badge;
		// "vibrate": "<Array of Integers>",
		public Integer[] vibrate;
		// "sound": "<URL String>",
		public String sound;
		//  "dir": "<String of 'auto' | 'ltr' | 'rtl'>",
		public String dir;
		
		/*
		 * "Behavioural Options",
		 */
		// "tag": "<String>",
		public String tag;
		//	"data": "<Anything>",
		public String data;
		//	"requireInteraction": "<boolean>",
		public Boolean requireInteraction;
		//	"renotify": "<Boolean>",
		public Boolean renotify;
		//	"silent": "<Boolean>",
		public Boolean silent;
		
		/*
		 * "Both Visual & Behavioural Options",
		 */
		//	 "actions": "<Array of Strings>",
		public String[] actions;
		
		/*
		 * "Information Option. No visual affect.",
		 */
		// "timestamp": "<Long>"
		public Long timestamp;
		
		
	}
	
	
	@Override
	public String toBody() {
		try {
			return new ObjectMapper().writeValueAsString(this);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}

}
