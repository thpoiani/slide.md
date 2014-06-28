<content tag="controller">live</content>

<section class="row">
  <form id="form" action="${pageContext.request.contextPath}/presentations" method="post">
    <input type="hidden" name="_method" value="put">
    <input type="hidden" name="presentation.id" value="${presentation.id}">
    <input type="hidden" name="presentation.hash" value="${presentation.hash}">
    <input type="hidden" name="presentation.user.id" value="${presentation.user.id}">

    <div class="content-medium">
      <h2 class="subtitle" contenteditable>${presentation.title}</h2>
      <button class="button save" id="save" type="submit" title="save presentation">SAVE</button>
      <a class="button back" href="${pageContext.request.contextPath}/dashboard" title="back to dashboard">DASHBOARD</a>
    </div>

    <div class="content live">
      <div id="editor" class="markdown"><c:out value="${presentation.context}" /></div>
      <iframe id="iframe" class="slide" src="${pageContext.request.contextPath}/presentation/${presentation.hash}" frameborder="0"></iframe>
      <div id="css" class="css">${presentation.css}</textarea>
    </div>
  </form>
</section>

<content tag="scripts">
  <script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
  <script>window.jQuery || document.write('<script src="${pageContext.request.contextPath}/js/jquery/dist/jquery.min.js"><\/script>')</script>

  <script src="${pageContext.request.contextPath}/js/ace-builds/src-min-noconflict/ace.js"></script>
  <script src="${pageContext.request.contextPath}/js/live.js"></script>
</content>