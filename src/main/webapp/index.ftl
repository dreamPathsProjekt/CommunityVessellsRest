<!DOCTYPE html>
<html>

<#include "/templates/header.html"/>

<body data-spy="scroll" data-target=".navbar" data-offset="60">
    

<#include "templates/login.html"/>    

<#if sessionObj?has_content>
    <p>session is here ${sessionObj}</p>
<#else>
    <#include "/templates/navbarmain.html"/>     
</#if>
   

<div class="container-fluid">

<#include "/templates/jumbo.html"/>
<#include "templates/purpose.html"/>		

<hr class="divider-color">
<div class="row text-center" id="register">

<button type="submit" class="btn btn-primary" id="test23">Test</button>

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