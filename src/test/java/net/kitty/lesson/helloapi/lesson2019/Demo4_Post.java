package net.kitty.lesson.helloapi.lesson2019;


import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;



public class Demo4_Post extends BaseTest {
	
	@Test(description="测试新增用户接口")
	public void testAddUser() throws UnsupportedEncodingException {
		
		//指明要测试的接口路径
		String path ="/javamall/shop/admin/member!saveMember.do";
		//新建参数列表
		List<NameValuePair>postDate=new ArrayList<NameValuePair>();
		//新建参数p1
		NameValuePair p1=new BasicNameValuePair("member.uname", "admin1111");
		//新建参数p2
		NameValuePair p2=new BasicNameValuePair("member.password", "admin");
		
		//把新建的参数放到参数列表当中
		postDate.add(p1);
		postDate.add(p2);
		
		//把参数列表放到请求体当中
		HttpEntity postEntity=new UrlEncodedFormEntity(postDate);
		//新建HttpPost请求，输入host+path
		HttpPost postRequest=new HttpPost(host+path);
		
		postRequest.setEntity(postEntity);
		postRequest.addHeader(header);
		
		
		
		
		
	}
	
	

}
