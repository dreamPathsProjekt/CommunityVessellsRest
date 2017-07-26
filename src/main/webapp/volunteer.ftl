<!DOCTYPE html>
<html>
<#include "/templates/header.html"/>

<body data-spy="scroll" data-target=".navbar" data-offset="60">

<#if sessionUser?has_content>
    <#if sessionUser == "volunteer">
        <#include "/templates/navbarVol.ftl"/>
    </#if>

<#else>
    <#include "/templates/navbarmain.html"/>     
</#if>

<div class="container-fluid main">

<#if sessionUser?has_content>
    <div id="hiddenId" hidden>${sessionId}</div>
</#if>

<div class="container col-md-12 col-sm-12">
<div class="row">
<#include "templates/sideNavVol.html"/>
    <div class="col-md-9 col-sm-9 col-sm-offset-1" id="mainPageVol">
        <div class="row" hidden id="rowVol">
             <div class="well page text-center center-block" id="volPage"></div>
        </div>
    </div>
</div>
</div>

</div>


<#include "templates/footer.html"/>        
<#include "/templates/includesVol.html"/>

</body>
</html>