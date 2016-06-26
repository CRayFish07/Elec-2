<%@page import="com.yzx.elec.stringEnum.StringEnum"%>
<%@page import="java.io.IOException"%>
<%@page import="java.awt.Font"%>
<%@page import="java.awt.Color"%>
<%@page import="java.awt.Graphics"%>
<%@page import="java.awt.Image"%>
<%@page import="javax.imageio.ImageIO"%>
<%@page import="java.awt.image.BufferedImage"%>
<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%!
	void setHeadInfo(HttpServletResponse response) {
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache_Control", "no-cache");
		response.setDateHeader("Expires", 0);
	}
	
	//随机验证码
	String rankCheckWord() {
		StringBuilder result = new StringBuilder();
		for(int i=0; i<4; i++) {
			result.append(random.nextInt(10));
		}
		
		return result.toString();
	}
	
	
	Color randomColor(int min, int max) {
		if(min < 0) {
			min = 0;
		}
		if(max < 0) {
			max = 0;
		}
		
		if(min > 255) {
			min = 255;
		}
		if(max > 255) {
			max = 255;
		}
		
		int r = min + random.nextInt(max-min);
		int g = min + random.nextInt(max-min);
		int b = min + random.nextInt(max-min);
		
		return new Color(r, g, b);
	}
	
	
	int width = 55;
	int height = 20;
	Random random = new Random();
	//画出验证码
	BufferedImage drawCheckWord(String checkWord) {
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		//取得画笔
		Graphics graphics = image.getGraphics();
		
		//设置背景色
		graphics.setColor(randomColor(200, 250));
		graphics.fillRect(0, 0, width, height);
		
		//设置字体
		graphics.setFont(new Font("serif", Font.CENTER_BASELINE, 16));
		
		//产生随机线条
		//随机产生155条干扰线，使图象中的认证码不易被其它程序探测到
		graphics.setColor(randomColor(160, 200));
		for (int i = 0; i < 100; i++) {
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int xl = random.nextInt(12);
			int yl = random.nextInt(12);
			graphics.drawLine(x, y, x + xl, y + yl);
		}
		
		//画出验证码
		for(int i=0; i<4; i++) {
			CharSequence charSeq = checkWord.subSequence(i, i+1);
			graphics.setColor(randomColor(20, 110));
			graphics.drawString(String.valueOf(charSeq), 13 * i + 6, 16);
		}
		
		return image;
	}
	%>
	
	<%
	//设置头信息
	setHeadInfo(response);
	
	//随机验证码
	String checkWord = rankCheckWord();
	
	//将验证码放入session
	session.setAttribute(StringEnum.CHECK_WORD, checkWord);
	
	//画出验证码
	BufferedImage image = drawCheckWord(checkWord);
	
	try {
		ImageIO.write(image, "JPEG", response.getOutputStream());
	} catch(IOException e) {
	}
	
	out.clear();
	out = pageContext.pushBody();
	%>
</body>
</html>