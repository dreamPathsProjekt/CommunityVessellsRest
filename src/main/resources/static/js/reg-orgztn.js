var urlOrg = '/api/';

var customURIOrg = urlOrg + 'organization/';

$('#sendOrg').submit(function (e) {
  e.preventDefault();

  var emailOrg = $('#sendOrg #orgEmail').val();
  var passwordOrg = $('#sendOrg #orgPassword').val();
  var nameOrg = $('#sendOrg #orgName').val();
  var typeOrg = $('#sendOrg #orgType option:selected').text();
  var descriptionOrg = $('#sendOrg #orgDescription').val();

  var formDataOrg = new FormData();
  formDataOrg.append('file', $('#orgFile')[0].files[0]);

  var requestOrg =
    {
      'email': emailOrg,
      'password': passwordOrg,
      'name': nameOrg,
      'type': typeOrg,
      'description': descriptionOrg
    };

  var dataOrg = JSON.stringify(requestOrg);
  // console.log(requestOrg);

  $.ajax({
    type: 'POST',
    url: customURIOrg,
    contentType: 'application/json',
    processData: true,
    data: dataOrg

  })
    .done(function (responseData, status, xhr) {
      // get location from xhr header and follow link
      var follow = xhr.getResponseHeader('Location');
      $.get(follow).done(function (organization) {
        // get back object created to retrieve id

        var avatarURIOrg = customURIOrg + organization.id + '/avatar';
        // alert(avatarURIOrg);
        // code to upload here
        alertSuccess('#alertOrg', '#responseMsgOrg');

        $.ajax({
          url: avatarURIOrg,
          type: 'POST',
          data: formDataOrg,
          cache: false,
          contentType: false,
          enctype: 'multipart/form-data',
          processData: false
        }).done(function () {
          alertSuccess('#alertOrg', '#responseMsgOrg');
        });
      })
        .fail(function (xhr, status, error) {
          errorHandling(xhr, '#alertOrg', '#responseMsgOrg');
        });
    })
    .fail(function (xhr, status, error) {
      errorHandling(xhr, '#alertOrg', '#responseMsgOrg');
    });

  return false;
});
