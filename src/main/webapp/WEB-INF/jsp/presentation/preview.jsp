<c:if test="${not empty presentation.css}">
  <content tag="styles">
    <style>${presentation.css}</style>
  </content>
</c:if>



<textarea id="source">

class: center, middle

${presentation.context}

</textarea>

<content tag="scripts">
  <script src="${pageContext.request.contextPath}/js/remark/out/remark.js"></script>
  <script src="${pageContext.request.contextPath}/js/preview.js"></script>
</content>
