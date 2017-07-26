var name;
var type;
var email;
var avatarPath;
var description;

function showOrgDetails () {
  $('#orgPage').empty().append('<h1 class="h1_label primary-text-color">' + name + '</h1><hr class="divider-color">');
  $('#orgPage').append('<div><p class="maintext pad">' + type + '</p>');
  $('#orgPage').append('<p class="maintext pad">' + email + '</p><hr class="divider-color">');
  $('#orgPage').append('<h3 class="h1_label primary-text-color">Description</h3><p class="maintext pad">' + description + '</p></div>');
}
$('#showOrgDetailsImg').ready(function () {
  var url = '/api/organizations/';
  var id = $('#hiddenId').text();
  $.get(url + id).done(function (orgDetails) {
    if (orgDetails.avatarPath !== null) {
      $('#showOrgDetailsImg').empty().append('<img class="img-responsive img-rounded" src=' + orgDetails.avatarPath + ' alt=' + orgDetails.name + '/>');
    } else {
      $('#showOrgDetailsImg').empty().append('<img class="img-responsive img-rounded" src="/img/user-default.png" />');
    }
    name = orgDetails.name;
    type = orgDetails.type;
    email = orgDetails.email;
    avatarPath = orgDetails.avatarPath;
    description = orgDetails.description;
  });
});

$('#homePage').click(function () {
  showOrgDetails();
  $('#rowOrg').hide().show(600, function () {
    let scrollPos = $(this).offset().top;
    $(window).scrollTop(scrollPos);
  });
});
