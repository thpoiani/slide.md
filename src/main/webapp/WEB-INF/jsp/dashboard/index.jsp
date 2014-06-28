<content tag="controller">dashboard</content>

<section class="row">
  <div class="content-medium">
    <h2 class="subtitle">${user.name}</h2>
      <a href="${pageContext.request.contextPath}/presentation/new" class="button new" title="new presentation">NEW</a>
  </div>

  <div class="content">
    <ul class="row presentations">

      <c:forEach items="${user.presentations}" var="presentation">
        <li class="presentation" style="background: #777">
          <iframe class="slide" id="iframe" src="${pageContext.request.contextPath}/presentation/${presentation.hash}" frameborder="0"></iframe>
          <nav class="menu">
            <ul>
              <li class="preview"><a href="${pageContext.request.contextPath}/presentation/${presentation.hash}" title="preview"></a></li>
              <li class="share"><a href="${pageContext.request.contextPath}/share" title="share"></a></li>
              <li class="edit"><a href="${pageContext.request.contextPath}/presentation/${presentation.hash}/live" title="edit"></a></li>
              <li class="delete">
                <form action="${pageContext.request.contextPath}/presentations/${presentation.id}" method="post">
                  <input type="hidden" name="_method" value="delete"/>
                  <button type="submit" onclick="return confirm('Are you sure?')" title="remove"></button>
                </form>
            </ul>
          </nav>
        </li>
      </c:forEach>

    </ul>
  </div>
</section>

<content tag="scripts">
  <script src="${pageContext.request.contextPath}/js/dashboard.js"></script>
</content>