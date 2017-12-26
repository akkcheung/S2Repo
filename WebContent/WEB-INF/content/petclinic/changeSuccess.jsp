<%@ taglib prefix="s" uri="/struts-tags" %>
<!-- The record is updated -->


<s:if test="hasActionMessages()">
   <div class="alert alert-success">
      <s:actionmessage/>
   </div>
</s:if>