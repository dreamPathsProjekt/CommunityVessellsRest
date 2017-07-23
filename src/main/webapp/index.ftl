<!DOCTYPE html>
<html>

<#include "/templates/header.html"/>

<body data-spy="scroll" data-target=".navbar" data-offset="60">
    
<#include "/templates/register.html"/>
<#include "templates/login.html"/>    
<#if sessionObj?has_content>
<p>session is here ${sessionObj}</p>
<#else>
<#include "/templates/navbarmain.html"/>     
</#if>
   

<div class="container-fluid">

<#include "/templates/jumbo.html"/>
<#include "templates/purpose.html"/>		


                
</div>


        
<#include "templates/footer.html"/>        
<#include "/templates/includes.html"/>

</body>
</html>