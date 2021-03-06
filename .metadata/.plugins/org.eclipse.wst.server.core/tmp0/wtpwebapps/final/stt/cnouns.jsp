<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="org.apache.commons.logging.Log"%>
<%@page import="org.apache.commons.logging.LogFactory"%>    
<%
	request.setCharacterEncoding("EUC-KR");
	Log log = LogFactory.getLog("org.apache.lucene.analysis.kr");
    String question = request.getParameter("input");
    if(question==null) question = "";    
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">



<%@page import="org.apache.lucene.analysis.kr.morph.WordSpaceAnalyzer"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.lucene.analysis.kr.morph.AnalysisOutput"%>
<%@page import="org.apache.lucene.analysis.kr.morph.CompoundNounAnalyzer"%>
<%@page import="org.apache.lucene.analysis.kr.morph.CompoundEntry"%><HTML>
 <HEAD>
  <TITLE>Morpheme analysis</TITLE>
	<STYLE type="text/css">
	
	td {  font-size: 10pt}
	select {  font-size: 10pt}
	textarea {  font-size: 10pt}
	.benhur1 {  font-size: 12pt}
	a {color: #EDA900}
	a:visited {  text-decoration: none; color: #EDA900}
	a:link {  text-decoration: none; color: #EDA900}
	a:hover {  color: #E95D3C; text-decoration: underline }

.outer {
	color:#666666;
	background-color:#ffffff;
	font-family: 돋움, Arial, Tahoma;
	border-bottom: #4a93dd 1px solid;
}
.title {
	color:#666666;
	background-color:#ffffff;
	font-family: 돋움, Arial, Tahoma;
	FONT-SIZE: 12px;
	height: 18px; margin-bottom:0px;
	padding: 2px 0 2px 10px;
}
.inner {
	color:#666666;
	background-color:#ffffff;
	font-family: 돋움, Arial, Tahoma;
	FONT-SIZE: 12px;
	height: 18px; margin-bottom:0px;
	padding: 2px 0 2px 10px;
	margin: 0 0 0 50px;
}
	
	.h1 {
	 	stext-align: center;
        font-family: 'Impact';
        color: #E95D3C;
	}
	
		.button-demo {
		background: #E95D3C;
    	color: #fff;
    	font-family: Lucida Console;
    	font-size: 13px;
    	height: 30px;
    	width: 80px;
    	line-height: 20px;
    	margin: 10px 10px;
    	text-align: center;
    	border: 0;
    	transition: all 0.3s ease 0s;
	}


	.button-demo:hover {
 		 background: #EDA900
	}
		
	</STYLE>
 </HEAD>

 <BODY>
 <table width="800" align="center">
  <tr>
  <td>
	<a href="start.jsp" class="menu">형태소분석</a>  | <a href="cnouns.jsp" class="menu">복합명사 분해</a>  | <a href="space.jsp" class="menu">자동띄워쓰기</a> | <a href="keyword.jsp" class="menu">색인어추출</a>
	<hr/>
  </td>
  </tr>
  </table>
 <form method="post" name="morph">
  <table width="800" align="center">
  <tr>
  <td>
		<div style="font-size:18pt;text-align:center" class="h1">Decompose a compound noun</div>
  </td>
  </tr>
  <tr>
  <td>
  <div style="text-align:center">
  <textarea name="input" rows="7" cols="100"></textarea>
  <div>
  <div style="text-align:right;margin-right:35px">
  	<input type="submit" name="action" class="button-demo" value="실행하기">
  </div>
  </td>
  </tr>
  <tr>
  <td style="background-color:#FFCA6C">
  <div style="font-weight:bold;margin-top:20px;">입력 : </div>
  <div style="padding-left:40px;margin-top:5px"><%=question %></div>
  </td>
  </tr>
  <tr>
  <td>
  <div style="font-weight:bold;margin-top:20px">출력 : </div>
  <hr>
<%
try {
	if(!"".equals(question)) {
		log.info(question);
		long start = System.currentTimeMillis();
		CompoundNounAnalyzer analyzer = new CompoundNounAnalyzer();
		analyzer.setExactMach(false);
		
		List<CompoundEntry> entries = analyzer.analyze(question);

		out.println("<div class='outer'>");
		if(entries.size()==0) {
			out.print(question);
		} else {
			boolean one = false;
			for(int i=0;i<entries.size();i++) {
				if(i!=0&&entries.get(i).getWord().length()!=1&&!one) out.println("/");
				out.print(entries.get(i).getWord());
				if(i==0&&entries.get(i).getWord().length()==1) one=true;
				else one=false;
			}
		}

		out.println("</div>");
		
		out.println("<div>"+(System.currentTimeMillis()-start)+"ms</div>");
	}
} catch(Exception e) {
	out.println(e.getMessage());
	e.printStackTrace();
}
%>	
  </td>
  </tr>
  </table>
</form>  
 </BODY>
</HTML>