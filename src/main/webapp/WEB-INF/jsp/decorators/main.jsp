<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title><decorator:title default="slide.md - a HTML5 presentation builder"/></title>

<meta name="description" content="<decorator:getProperty property="meta.description" default="" />" />
<meta name="keywords" content="<decorator:getProperty property="meta.keywords" default="" />" />
<meta name="author" content="<decorator:getProperty property="meta.author" default="Thiago Poiani - thpoiani@gmail.com" />" />
<meta name="robots" content="<decorator:getProperty property="meta.robots" default="index, follow" />" />

<meta property="og:title" content="<decorator:title default="slide.md"/>" />
<meta property="og:description" content="<decorator:getProperty property="meta.description" default="" />" />
<meta property="og:url" content="<decorator:getProperty property="meta.url" default="" />" />
<meta property="og:type" content="website" />
<meta property="og:image" content="<decorator:getProperty property="meta.image" default="" />" />
<meta property="og:site_name" content="<decorator:getProperty property="meta.site_name" default="slide.md" />" />

<link rel="apple-touch-icon-precomposed" sizes="152x152" href="">
<link rel="apple-touch-icon-precomposed" sizes="144x144" href="">
<link rel="apple-touch-icon-precomposed" sizes="120x120" href="">
<link rel="apple-touch-icon-precomposed" sizes="114x114" href="">
<link rel="apple-touch-icon-precomposed" sizes="72x72" href="">
<link rel="apple-touch-icon-precomposed" href="">
<link rel="icon" sizes="16x16 32x32" href="">
<link rel="icon" sizes="32x32" href="">
<link rel="shortcut icon" href="">

<link rel="canonical" href="<decorator:getProperty property="meta.url" default="" />" />

<link rel="stylesheet" href="css/index.css">

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
</head>
<body>
<header class="row top">
  <div class="content right">
    <a class="button signup" href="${pageContext.request.contextPath}/join" title="join">join</a>
    <a class="button login" href="${pageContext.request.contextPath}/enter" title="enter">enter</a>
  </div>

  <div class="content header center">
    <h1 class="logo">
      <a href="${pageContext.request.contextPath}/" title="slide.md">
          slide.md
      </a>
    </h1>
  </div>
</header>

  <decorator:body/>
  
<footer class="row center">
  <p>
    <strong><a href="https://github.com/thpoiani" target="_blank" title="Thiago Poiani">Thiago Poiani</a></strong> &copy; 2014
  </p>
</footer>
</body>
</html>