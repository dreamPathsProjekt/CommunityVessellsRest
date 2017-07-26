var volFirstName;
var volLastName;
var volEmail;
var volAvatarPath;

$('#showVolDetailsImg').ready(function () {
  var url = '/api/volunteers/';
  var id = $('#hiddenId').text();
  
  $.get(url + id).done(function (volDetails) {
    if (volDetails.avatarPath !== null) {
      $('#showVolDetailsImg').empty().append('<img class="img-responsive img-rounded" src=' + volDetails.avatarPath + ' alt=' + volDetails.lastName + '/>');
    } else {
      $('#showVolDetailsImg').empty().append('<img class="img-responsive img-rounded" src="/img/user-default.png" />');
    }
    volFirstName = volDetails.firstName;
    volLastName = volDetails.lastName;
    volEmail = volDetails.email;
    volAvatarPath = volDetails.avatarPath;
  });
});
