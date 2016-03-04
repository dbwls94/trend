/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.65
 * Generated at: 2016-03-02 14:24:25 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.stt;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.util.*;
import vo.Resultdb;

public final class speech_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("  <head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>\r\n");
      out.write("    <title>Web Speech API Demo</title>\r\n");
      out.write("    <style>\r\n");
      out.write("      body\r\n");
      out.write("      {\r\n");
      out.write("        max-width: 500px;\r\n");
      out.write("        margin: 2em auto;\r\n");
      out.write("        font-size: 20px;\r\n");
      out.write("      }\r\n");
      out.write("\r\n");
      out.write("      h1\r\n");
      out.write("      {\r\n");
      out.write("        text-align: center;\r\n");
      out.write("      }\r\n");
      out.write("\r\n");
      out.write("      .buttons-wrapper\r\n");
      out.write("      {\r\n");
      out.write("        text-align: center;\r\n");
      out.write("      }\r\n");
      out.write("\r\n");
      out.write("      .hidden\r\n");
      out.write("      {\r\n");
      out.write("        display: none;\r\n");
      out.write("      }\r\n");
      out.write("\r\n");
      out.write("      #transcription,\r\n");
      out.write("      #log\r\n");
      out.write("      {\r\n");
      out.write("        display: block;\r\n");
      out.write("        width: 100%;\r\n");
      out.write("        height: 5em;\r\n");
      out.write("        overflow-y: scroll;\r\n");
      out.write("        border: 1px solid #333333;\r\n");
      out.write("        line-height: 1.3em;\r\n");
      out.write("      }\r\n");
      out.write("\r\n");
      out.write("      .button-demo\r\n");
      out.write("      {\r\n");
      out.write("        padding: 0.5em;\r\n");
      out.write("        display: inline-block;\r\n");
      out.write("        margin: 1em auto;\r\n");
      out.write("      }\r\n");
      out.write("    </style>\r\n");
      out.write("  </head>\r\n");
      out.write("  <body>\r\n");
      out.write("    <h1>Web Speech API</h1>\r\n");
      out.write("    <h2>Result</h2>\r\n");
      out.write("    <textarea id=\"transcription\" readonly=\"readonly\"></textarea>\r\n");
      out.write("\r\n");
      out.write("    <span>Results:</span>\r\n");
      out.write("    <label><input type=\"radio\" name=\"recognition-type\" value=\"final\" checked=\"checked\" /> Final only</label>\r\n");
      out.write("    <label><input type=\"radio\" name=\"recognition-type\" value=\"interim\" /> Interim</label>\r\n");
      out.write("\r\n");
      out.write("    <h3>ing</h3>\r\n");
      out.write("    <div id=\"log\"></div>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"buttons-wrapper\">\r\n");
      out.write("      <button id=\"button-play-ws\" class=\"button-demo\">Play demo</button>\r\n");
      out.write("      <button id=\"button-stop-ws\" class=\"button-demo\">Stop demo</button>\r\n");
      out.write("      <button id=\"clear-all\" class=\"button-demo\">Clear all</button>\r\n");
      out.write("      <form action=\"start.jsp\" method=\"GET\">\r\n");
      out.write("      \t<input type=\"submit\" value=\"형태소 분석\">\r\n");
      out.write("      </form>\r\n");
      out.write("    </div>\r\n");
      out.write("    <span id=\"ws-unsupported\" class=\"hidden\">Web Speech Api</span>\r\n");
      out.write("\r\n");
      out.write("    <script>\r\n");
      out.write("      // Test browser support\r\n");
      out.write("      window.SpeechRecognition = window.SpeechRecognition || window.webkitSpeechRecognition || null;\r\n");
      out.write("\r\n");
      out.write("      if (window.SpeechRecognition === null) \r\n");
      out.write("      {\r\n");
      out.write("        document.getElementById('ws-unsupported').classList.remove('hidden');\r\n");
      out.write("        document.getElementById('button-play-ws').setAttribute('disabled', 'disabled');\r\n");
      out.write("        document.getElementById('button-stop-ws').setAttribute('disabled', 'disabled');\r\n");
      out.write("      } \r\n");
      out.write("      else \r\n");
      out.write("      {\r\n");
      out.write("        var recognizer = new window.SpeechRecognition();\r\n");
      out.write("        var transcription = document.getElementById('transcription'); //결과 받아올 변수\r\n");
      out.write("        var log = document.getElementById('log');\r\n");
      out.write("\t\t\r\n");
      out.write("        // 사용자가 멈출때 쓰일 인자\r\n");
      out.write("        recognizer.continuous = true;\r\n");
      out.write("\r\n");
      out.write("        // 인식 시작\r\n");
      out.write("        recognizer.onresult = function(event) \r\n");
      out.write("        {\r\n");
      out.write("          transcription.textContent = '';\r\n");
      out.write("\r\n");
      out.write("          for (var i = event.resultIndex; i < event.results.length; i++)\r\n");
      out.write("          {\r\n");
      out.write("            if (event.results[i].isFinal) //인식 끝나면 정확도까지 보여줌(Stop demo 버튼 누르면)\r\n");
      out.write("            {\r\n");
      out.write("              //현재 시간\r\n");
      out.write("              var now = new Date();\r\n");
      out.write("              var nowAll = now.getFullYear() + \"-\" + (now.getMonth() + 1) + \"-\" + now.getDate() + \" \" + now.getHours() + \":\" + now.getMinutes() + \":\" + now.getSeconds() + \" \";\r\n");
      out.write("              transcription.textContent = event.results[i][0].transcript + ' (Confidence: ' + event.results[i][0].confidence + ')';\r\n");
      out.write("              \r\n");
      out.write("              console.log(event.results[i][0].transcript);\r\n");
      out.write("             \r\n");
      out.write("              var xhr = new XMLHttpRequest();\r\n");
      out.write("              \r\n");
      out.write("              var a=decodeURIComponent(event.results[i][0].transcript); \r\n");
      out.write("              xhr.open('GET', '/final/stt/api?date='+nowAll + '&transcription=' + a + '&confidence=' + event.results[i][0].confidence, true);\r\n");
      out.write("              xhr.send(null); \r\n");
      out.write("            } \r\n");
      out.write("            else\r\n");
      out.write("            {\r\n");
      out.write("              transcription.textContent += event.results[i][0].transcript; //인식 결과가 계속 더해짐\r\n");
      out.write("            }\r\n");
      out.write("          }\r\n");
      out.write("          \r\n");
      out.write("        };\r\n");
      out.write("\r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        //에러 처리\r\n");
      out.write("        recognizer.onerror = function(event)\r\n");
      out.write("        {\r\n");
      out.write("          log.innerHTML = 'Recognition error: ' + event.message + '<br />' + log.innerHTML;\r\n");
      out.write("        };\r\n");
      out.write("\r\n");
      out.write("        document.getElementById('button-play-ws').addEventListener('click', function() \r\n");
      out.write("        {\r\n");
      out.write("          //연속적인 결과 얻을때\r\n");
      out.write("          recognizer.interimResults = document.querySelector('input[name=\"recognition-type\"][value=\"interim\"]').checked;\r\n");
      out.write("\r\n");
      out.write("          try \r\n");
      out.write("          {\r\n");
      out.write("            recognizer.start(); //인식 시작\r\n");
      out.write("            log.innerHTML = 'Recognition started' + '<br />' + log.innerHTML;\r\n");
      out.write("          } \r\n");
      out.write("          catch(ex)\r\n");
      out.write("          {\r\n");
      out.write("            log.innerHTML = 'Recognition error: ' + ex.message + '<br />' + log.innerHTML; //에러 메시지 출력\r\n");
      out.write("          }\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("        document.getElementById('button-stop-ws').addEventListener('click', function() \r\n");
      out.write("        {\r\n");
      out.write("          recognizer.stop();\r\n");
      out.write("          log.innerHTML = 'Recognition stopped' + '<br />' + log.innerHTML;\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("        document.getElementById('clear-all').addEventListener('click', function()\r\n");
      out.write("        {\r\n");
      out.write("          transcription.textContent = '';\r\n");
      out.write("          log.textContent = '';\r\n");
      out.write("        });\r\n");
      out.write("      }\r\n");
      out.write("      \r\n");
      out.write("      \r\n");
      out.write("    </script>\r\n");
      out.write("  </body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}