<section class="row">
  <div class="content-medium">
    <h2 class="subtitle">Presentation not found</h2>

    <c:if test="${empty user}">
      <a href="${pageContext.request.contextPath}/" class="button" title="Return">Return</a>
    </c:if>
    <c:if test="${not empty user}">
      <a href="${pageContext.request.contextPath}/dashboard" class="button" title="Return">Return</a>
    </c:if>
  </div>
</section>