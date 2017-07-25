<!DOCTYPE html>
<html>
<#include "/templates/header.html"/>

<body data-spy="scroll" data-target=".navbar" data-offset="60">

<#if sessionUser?has_content>
    <p>session is here ${sessionUser} <br> ${sessionId} <br> ${message} <br> ${sessionEmail}</p>
<#else>
    <#include "/templates/navbarmain.html"/>     
</#if>

</body>
</html>