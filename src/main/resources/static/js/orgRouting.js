$('#homePage').click(function () {
  showOrgDetails();
  $('#rowOrg').hide().show(600, function () {
    let scrollPos = $(this).offset().top;
    $(window).scrollTop(scrollPos);
  });
});

function showOrgDetails () {
  $('#orgPage').empty().load('/templates/orgDetails.html', function () {
    $('#orgName').text(orgName);
    $('#orgType').text(orgType);
    $('#orgEmail').text(orgEmail);
    $('#orgDescription').text(orgDescription);
  });
}
