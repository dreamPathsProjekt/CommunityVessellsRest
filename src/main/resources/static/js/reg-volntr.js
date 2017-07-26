var url = '/api/';

var customURI = url + 'volunteer/';

$('#sendVol').submit(function (e) {
  e.preventDefault();

  var email = $('#sendVol #inputEmail').val();
  var password = $('#sendVol #inputPassword').val();
  var firstName = $('#sendVol #inputFirstname').val();
  var lastName = $('#sendVol #inputLastname').val();

  var formData = new FormData();
  formData.append('file', $('#inputFile')[0].files[0]);

  var request =
    {
      'email': email,
      'password': password,
      'firstName': firstName,
      'lastName': lastName
    };

  var data = JSON.stringify(request);
  // console.log(request);

  $.ajax({
    type: 'POST',
    url: customURI,
    contentType: 'application/json',
    processData: true,
    data: data

  })
    .done(function (responseData, status, xhr) {
      // get location from xhr header and follow link
      var follow = xhr.getResponseHeader('Location');
      $.get(follow).done(function (volunteer) {
        // get back object created to retrieve id

        var avatarURI = customURI + volunteer.id + '/avatar';
        // alert(avatarURI);
        // code to upload here
        alertSuccess('#alertVol', '#responseMsg');

        $.ajax({
          url: avatarURI,
          type: 'POST',
          data: formData,
          cache: false,
          contentType: false,
          enctype: 'multipart/form-data',
          processData: false
        }).done(function () {
          alertSuccess('#alertVol', '#responseMsg');
        });
      })
        .fail(function (xhr, status, error) {
          errorHandling(xhr, '#alertVol', '#responseMsg');
        });
    })
    .fail(function (xhr, status, error) {
      errorHandling(xhr, '#alertVol', '#responseMsg');
    });

  return false;
});

function errorHandling (xhr, alert, msgId) {
  var responseError = xhr.responseJSON;
  if (responseError.exception.search('org.springframework.dao.DataIntegrityViolationException') !== -1) {
    $(msgId).empty().append('<strong>Error: Email Already Exists</strong>');
    $(alert).hide().show(500).attr('class', 'alert alert-dismissible alert-danger', function () {
      let scrollPos = $(alert).offset().top;
      $(window).scrollTop(scrollPos);
    });
  } else {
    $(msgId).empty().append('<strong>Error: Registration failed</strong>');
    $(alert).hide().show(500).attr('class', 'alert alert-dismissible alert-danger', function () {
      let scrollPos = $(alert).offset().top;
      $(window).scrollTop(scrollPos);
    });
  }
}

function alertSuccess (alert, msgId) {
  $(msgId).empty().append('<strong>Success: Registration completed</strong>');
  $(alert).hide().show(500).attr('class', 'alert alert-dismissible alert-success', function () {
    let scrollPos = $(alert).offset().top;
    $(window).scrollTop(scrollPos);
  });
}
