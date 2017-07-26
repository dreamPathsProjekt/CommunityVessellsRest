$('#homePageVol').click(function () {
  showVolDetails();
  $('#rowVol').hide().show(600, function () {
    let scrollPos = $(this).offset().top;
    $(window).scrollTop(scrollPos);
  });
});

function showVolDetails () {
  $('#volPage').empty().load('/templates/volDetails.html', function () {
    $('#volEmail').text(volEmail);
    $('#volFirstName').text(volFirstName);
    $('#volLastName').text(volLastName);
  });
}
