<c:if test="${not empty presentation.css}">
  <content tag="styles">
    <style>${presentation.css}</style>
  </content>
</c:if>



<textarea id="source">
  <c:out value="${presentation.context}" />
</textarea>

<content tag="scripts">
  <script src="${pageContext.request.contextPath}/js/remark/out/remark.js"></script>
  <script src="${pageContext.request.contextPath}/js/preview.js"></script>
</content>
