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

<div class="container col-md-12 col-sm-12">
<div class="row">
<#include "templates/sideNavOrg.html"/>
    <div class="col-md-9 col-sm-9 col-sm-offset-1" id="mainPage">
        <!-- Home Page -->
        <div class="row" id="rowOrg" hidden >
             <div class="well page text-center center-block" id="orgPage"></div>
        </div>

        <!-- Create Event -->
        <div class="row" id="createEvent" hidden >
            <div class="well page text-center center-block" id="createPage"></div>
        </div>

        <!-- Events go here -->
        <div class="row" id="eventRow" hidden >
            <div class="page text-center center-block" id="eventWrap"></div>
        </div>

        <div id="helper" hidden></div>
        

    </div>
</div>
</div>


</div>


<#include "templates/footer.html"/>       
<#include "/templates/includesOrg.html"/>
 
</body>
</html>