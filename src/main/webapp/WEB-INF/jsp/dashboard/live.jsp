<content tag="controller">live</content>

<section class="row">
  <div class="content-medium">
    <h2 class="subtitle" data-id="">Live Preview</h2>
    <p>Status: <span id="status"></span></p>
  </div>

  <div class="content">
    <div id="editor"></div>
    <iframe class="slide" src="${pageContext.request.contextPath}/dashboard/hash" frameborder="0"></iframe>
  </div>

</section>

<content tag="scripts">
  <script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
  <script>window.jQuery || document.write('<script src="${pageContext.request.contextPath}/js/jquery/dist/jquery.min.js"><\/script>')</script>

  <script src="${pageContext.request.contextPath}/js/ace-builds/src-min-noconflict/ace.js"></script>
  <script src="${pageContext.request.contextPath}/js/live.js"></script>
</content>