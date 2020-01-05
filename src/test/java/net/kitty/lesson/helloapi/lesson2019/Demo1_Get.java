package net.kitty.lesson.helloapi.lesson2019;

import java.io.IOException;


import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;


public class Demo1_Get {
	
	public static void main(String[] args) throws ClientProtocolException, IOException {
		
		//构建客户端
		CloseableHttpClient client =HttpClients.createDefault();
		
		//构建请求
		
		String url="http://localhost:8080/javamall/admin/backendUi!main.do";
		
		HttpGet request =new HttpGet(url);
		
		HttpResponse response=client.execute(request);
		
		//response.getStatusLine();
		//response.getAllHeaders();
		//response.getEntity();
		
		
		
		//打印相应内容
		System.out.println("response.getStatusLine():"+ response.getStatusLine());
		System.out.println("response.getAllHeaders():"+ response.getAllHeaders());
		System.out.println("response.getEntity():"+ response.getEntity());
		
		
		
		
		
		
		
	}
	

}
