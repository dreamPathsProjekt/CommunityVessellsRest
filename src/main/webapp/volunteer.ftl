<!DOCTYPE html>
<html>
<#include "/templates/header.html"/>

<body data-spy="scroll" data-target=".navbar" data-offset="60">

<#if sessionUser?has_content>
    <#if sessionUser == "organization">
        <#include "/templates/navbarOrg.ftl"/>
    </#if>

<#else>
    <#include "/templates/navbarmain.html"/>     
</#if>

<div class="container-fluid main">

<#if sessionUser?has_content>
    <div id="hiddenId" hidden>${sessionId}</div>
</#if>

</div>


<#include "templates/footer.html"/>        
<#include "/templates/includesVol.html"/>

</body>
</html>