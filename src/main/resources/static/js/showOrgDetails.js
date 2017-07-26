var orgName;
var orgType;
var orgEmail;
var orgAvatarPath;
var orgDescription;

$('#showOrgDetailsImg').ready(function () {
  var url = '/api/organizations/';
  var id = $('#hiddenId').text();
  $.get(url + id).done(function (orgDetails) {
    if (orgDetails.avatarPath !== null) {
      $('#showOrgDetailsImg').empty().append('<img class="img-responsive img-rounded" src=' + orgDetails.avatarPath + ' alt=' + orgDetails.name + '/>');
    } else {
      $('#showOrgDetailsImg').empty().append('<img class="img-responsive img-rounded" src="/img/user-default.png" />');
    }
    orgName = orgDetails.name;
    orgType = orgDetails.type;
    orgEmail = orgDetails.email;
    orgAvatarPath = orgDetails.avatarPath;
    orgDescription = orgDetails.description;
  });
});
