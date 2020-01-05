package net.kitty.lesson.helloapi.lesson2019;

import java.io.IOException;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Demo2_TestNGApi {
	//创建类变量，所有方法都可以使用
	CloseableHttpClient client;
	
	//@BeforeMethod：在所有测试方法运行之前运行，用于创建公共环境信息
	@BeforeMethod
	public void setUp() {
		//初始化客户端
		client= HttpClients.createDefault();
	}
	
	//@AfterMethod: 在所有测试方法运行之后运行，常常用于销毁环境信息
	@AfterMethod
	public void tearDown() throws IOException {
		//关闭客户端连接
		client.close();
	}
	
	
	@Test(description="获取Javamall主页内容")
	public void test() throws ClientProtocolException, IOException {
       //1.构建请求
		String url = "http://192.168.3.11:8080/javamall/admin/backendUi!main.do";
		HttpGet request = new HttpGet(url);  
		//2.添加请求头
		String name="Cookie";
		String value="JSESSIONID=CF29120034D14338429D3A6A85CEE9BB";
		Header header=new BasicHeader(name, value);
		request.addHeader(header);
       //3. 执行请求：获取响应
		HttpResponse response = client.execute(request);
		//4.1： 获取响应码statusLine，断言响应码返回为200
		int responseCode= response.getStatusLine().getStatusCode();
		Assert.assertEquals(200, responseCode);
		//4.2:  遍历响应头，打印出头信息
		 System.out.println("response.getAllHeaders" + response.getAllHeaders());
		 Header[] headers=response.getAllHeaders();
		 for(Header h:headers) {
			 System.out.println("---------------------");
			 System.out.println(h.getName());
			 System.out.println(h.getValue());
		 }
		 //4.3 解析ResponseEntity，转化为String输出
		String resultStr=EntityUtils.toString(response.getEntity());
		System.out.println("resultStr："+resultStr);
	}
	
	
}
