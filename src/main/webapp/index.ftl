<!DOCTYPE html>
<html>

<#include "/templates/header.html"/>

<body data-spy="scroll" data-target=".navbar" data-offset="60">
    

<#include "templates/login.html"/>    

<#if sessionUser?has_content>
    <#if sessionUser == "organization">
        <#include "/templates/navbarOrg.ftl"/>
    </#if>
    <#if sessionUser == "volunteer">
        <#include "/templates/navbarVol.ftl"/>
    </#if>
    
<#else>
    <#include "/templates/navbarmain.html"/>     
</#if>
   

<div class="container-fluid main">

<#if message?has_content && !sessionUser?has_content>
    <div class="well bg-danger">
        <a href="#loginModal"  data-toggle="modal" type="button" class="btn btn-large btn-block btn-danger">Error!: ${message}</a>
    </div>
</#if>

<#include "/templates/jumbo.html"/>

<#if sessionUser?has_content>
    <div id="hiddenId" hidden>${sessionId}</div>
</#if>



<#include "templates/purpose.html"/>		

<hr class="divider-color">
<div class="row text-center" id="register">

<!-- <button type="submit" class="btn btn-primary" id="test23">Test</button> -->

<h2 class="h1_label slideanim">Register Now!</h2>
<button type="submit" class="btn btn-md btn-default" id="VolunteerBtn">Volunteer</button>
<button type="submit" class="btn btn-md btn-default" id="OrganizationBtn">Organization</button>
<div id="show"></div>
</div>

<#include "/templates/registerOrg.html"/>
<#include "templates/registerVol.html"/>

                
</div>


        
<#include "templates/footer.html"/>        
<#include "/templates/includes.html"/>

</body>
</html>