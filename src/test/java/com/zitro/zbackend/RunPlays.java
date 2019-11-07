package com.zitro.zbackend;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Before;
import org.junit.Test;

public class RunPlays {
	
	private List<String> users;
	
	private List<Integer> games;
	
	@Before 
	public void initialize() {
		users = new ArrayList<String>();
		users.add("76469355-682a-40b4-8807-ec3269a111a8");
		users.add("b4d3400a-14ba-4846-9b47-5fbb4bba9c3d");
		users.add("db5636a8-89e2-4be3-844c-2e661089ef59");
		
		games= new ArrayList<Integer>();
		games.add(1);
		games.add(2);
		games.add(3);
		games.add(4);
		games.add(5);
		games.add(6);
	}
	
	public void call() throws IOException {
		CloseableHttpClient client = HttpClients.createDefault();
	    HttpPost httpPost = new HttpPost("http://localhost:8090/play");
	    
	    Random r = new Random();

		int userIndex = r.nextInt(users.size()-0) + 0;
		int gameIndex = r.nextInt(games.size()-0) + 0;
		int amount = r.nextInt(10-0) + 0;
	 
	    String json = "{\"player\":\""+users.get(userIndex)+"\", \"game\":\""+games.get(gameIndex)+"\", \"amountPlayed\":\""+amount+"\"}";
	    StringEntity entity = new StringEntity(json);
	    httpPost.setEntity(entity);
	    httpPost.setHeader("Accept", "application/json");
	    httpPost.setHeader("Content-type", "application/json");
	 
//	    CloseableHttpResponse response = client.execute(httpPost);
//	    assertNotNull(response);
	    
//	    HttpEntity resposneEntity = response.getEntity();
//	    String responseString = EntityUtils.toString(resposneEntity, "UTF-8");
	    client.execute(httpPost);
	    client.close();
	}

	@Test
	public void loadPlays() throws ClientProtocolException, IOException {
		for(int i = 0; i<10; i++) {
			this.call();
		}
	}
	
}
