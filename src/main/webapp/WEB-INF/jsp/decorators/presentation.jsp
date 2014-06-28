<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title><decorator:title default="slide.md - a HTML5 presentation builder"/></title>

<meta name="description" content="<decorator:getProperty property="page.description" default="slide.md - a HTML5 presentation builder" />" />
<meta name="keywords" content="<decorator:getProperty property="page.keywords" default="" />" />
<meta name="author" content="<decorator:getProperty property="page.author" default="Thiago Poiani - thpoiani@gmail.com" />" />
<meta name="robots" content="<decorator:getProperty property="page.robots" default="index, follow" />" />

<meta property="og:title" content="<decorator:title default="slide.md"/>" />
<meta property="og:description" content="<decorator:getProperty property="page.description" default="" />" />
<meta property="og:url" content="<decorator:getProperty property="page.url" default="" />" />
<meta property="og:type" content="website" />
<meta property="og:image" content="<decorator:getProperty property="page.image" default="${pageContext.request.contextPath}/images/slidemd.png" />" />
<meta property="og:site_name" content="<decorator:getProperty property="page.site_name" default="slide.md" />" />

<link rel="apple-touch-icon-precomposed" sizes="152x152" href="${pageContext.request.contextPath}/images/favicon/slidemd-152.png">
<link rel="apple-touch-icon-precomposed" sizes="144x144" href="${pageContext.request.contextPath}/images/favicon/slidemd-144.png">
<link rel="apple-touch-icon-precomposed" sizes="120x120" href="${pageContext.request.contextPath}/images/favicon/slidemd-120.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114" href="${pageContext.request.contextPath}/images/favicon/slidemd-114.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72" href="${pageContext.request.contextPath}/images/favicon/slidemd-72.png">
<link rel="apple-touch-icon-precomposed" href="${pageContext.request.contextPath}/images/favicon/slidemd-32.png">
<link rel="icon" sizes="16x16 32x32" href="${pageContext.request.contextPath}/images/favicon/slidemd-32.png">
<link rel="icon" sizes="32x32" href="${pageContext.request.contextPath}/images/favicon/slidemd-32.png">
<link rel="shortcut icon" href="${pageContext.request.contextPath}/images/favicon/slidemd-16.ico">

<link rel="canonical" href="<decorator:getProperty property="page.url" default="" />" />

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/<decorator:getProperty property="page.controller" default="index" />.css">

<script>
//     (function(b,o,i,l,e,r){b.GoogleAnalyticsObject=l;b[l]||(b[l]=
//     function(){(b[l].q=b[l].q||[]).push(arguments)});b[l].l=+new Date;
//     e=o.createElement(i);r=o.getElementsByTagName(i)[0];
//     e.src='//www.google-analytics.com/analytics.js';
//     r.parentNode.insertBefore(e,r)}(window,document,'script','ga'));
//     ga('create','UA-XXXXX-X');ga('send','pageview');
</script>

<!--[if lte IE 8]>
  <script>
      var htmlshim='abbr,article,aside,audio,canvas,details,figcaption,figure,footer,header,mark,meter,nav,output,progress,section,summary,time,video'.split(',');
      var htmlshimtotal=htmlshim.length;
      for(var i=0;i<htmlshimtotal;i++) document.createElement(htmlshim[i]);
  </script>
<![endif]-->

<decorator:head/>

<decorator:getProperty property="page.styles" />

</head>
<body>

<decorator:body/>

<decorator:getProperty property="page.scripts" />

</body>
</html>