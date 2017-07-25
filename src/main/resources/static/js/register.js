$('#VolunteerBtn').click(function () {
  $('#registerOrg').hide(1000);
  $('#registerVol').show(1000, function () {
    let scrollPos = $(this).offset().top;
    $(window).scrollTop(scrollPos);
  });
});

$('#OrganizationBtn').click(function () {
  $('#registerVol').hide(1000);
  $('#registerOrg').show(1000, function () {
    let scrollPos = $(this).offset().top;
    $(window).scrollTop(scrollPos);
  });
});

$('.resetbtn').click(function () {
  $('#alertVol').hide();
});
