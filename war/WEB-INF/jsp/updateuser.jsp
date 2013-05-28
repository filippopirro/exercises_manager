<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>  
	<head>  
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
		<title>Exercises Manager</title>
		<!--<link rel="shortcut icon" href="./resources/images/logo_shortcut_icon_transparent.png">-->
		<!--link rel="stylesheet" href="./css/style.css" type="text/css"/-->
		<link rel="stylesheet" href="./css/dhtml_goodies_topbarmenu.css" type="text/css"/>
		<link rel="stylesheet" href="./css/tld_descriptions.css" type="text/css"/>
		<script type="text/javascript">
			if (location.hostname.toLowerCase().indexOf('dhtmlgoodies') >= 0) {
			  var _gaq = _gaq || [];
			  _gaq.push(['_setAccount', 'UA-2042963-3']);
			  _gaq.push(['_trackPageview']);
			
			  (function() {
			    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
			    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
			    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
			  })();
			}
		</script>
		<script type="text/javascript">
		    function noBack() { window.history.forward() }
		    noBack();
		    window.onload = noBack;
		    window.onpageshow = function(evt) { if (evt.persisted) noBack() }
		    window.onunload = function() { void (0) }
		</script>
		<script src="./javascript/dhtml_goodies_topbarmenu.js" type="text/javascript"></script>
	</head>  
	<body>
		<%@ include file="/WEB-INF/jsp/topmenubar.jsp" %>
		<div id="mainContainer">
			<div>
				<p>
					<span style="font-size: 12pt;font-style: bold;"></span><br/>
					<form:form method="POST" modelAttribute="user">
						<form:label path="username" cssClass="spring_input">
							<spring:message code="label.user.username"/>
						</form:label></br>
						<form:input path="username"  readonly="true"/></br>
						<form:errors path="username" cssClass="spring_error"/></br>
						<form:label path="first_name" cssClass="spring_input">
							<spring:message code="label.user.first_name"/>
						</form:label></br>
						<form:input path="first_name"/></br>
						<form:errors path="first_name" cssClass="spring_error"/></br>
						<form:label path="last_name" cssClass="spring_input">
							<spring:message code="label.user.last_name"/>
						</form:label></br>
						<form:input path="last_name"/></br>
						<form:errors path="last_name" cssClass="spring_error"/></br>
						<form:label path="email" cssClass="spring_input">
							<spring:message code="label.user.email"/>
						</form:label></br>
						<form:input path="email"/></br>
						<form:errors path="email" cssClass="spring_error"/></br>
						<input type="submit" value="<spring:message code="input.submit.save"/>" class="button"/>
					</form:form>
				</p>
				<p>
					<span style="font-size: 12pt;font-style: bold;"></span><br/>
				</p>
				<p>
					<span style="font-size: 12pt;font-style: bold;"></span><br/>
				</p>
			</div>
		</div>
		<div id="footerContainer">
			<div>
			</div>
		</div>
	</body>  
</html>
