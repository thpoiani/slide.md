<content tag="controller">live</content>

<section class="row">
  <form id="form" action="${pageContext.request.contextPath}/presentations" method="post">
    <input type="hidden" name="_method" value="put">
    <input type="hidden" name="presentation.id" value="${presentation.id}">
    <input type="hidden" name="presentation.hash" value="${presentation.hash}">
    <input type="hidden" name="presentation.createdAt" value="${presentation.createdAt}">
    <input type="hidden" name="presentation.user.id" value="${presentation.user.id}">

    <div class="row">
      <a class="button" href="${pageContext.request.contextPath}/dashboard" title="back to dashboard">BACK</a>
      <button class="button" id="save" type="submit" title="save presentation">SAVE</button>
    </div>

    <div class="content-medium">
      <h2 class="subtitle" contenteditable>${presentation.title}</h2>
    </div>

    <div class="content">
      <div id="editor">${presentation.context}</div>
      <iframe id="iframe" class="slide" src="${pageContext.request.contextPath}/presentation/${presentation.hash}" frameborder="0"></iframe>
    </div>
  </form>
</section>

<content tag="scripts">
  <script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
  <script>window.jQuery || document.write('<script src="${pageContext.request.contextPath}/js/jquery/dist/jquery.min.js"><\/script>')</script>

  <script src="${pageContext.request.contextPath}/js/ace-builds/src-min-noconflict/ace.js"></script>
  <script src="${pageContext.request.contextPath}/js/live.js"></script>
</content>