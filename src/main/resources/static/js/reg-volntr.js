var url = 'http://localhost:8080/api/';

var customURI = url + 'volunteer/';
$(function () {
  $('#volBtn').click(function (e) {
    e.preventDefault();

    var email = $('#sendVol #inputEmail').val();
    var password = $('#sendVol #inputPassword').val();
    var firstName = $('#sendVol #inputFirstname').val();
    var lastName = $('#sendVol #inputLastname').val();

    // var formData = new FormData();
    //*  get the file after ajax request
    // var files = $("#inputFile").get(0).files;
    var request =
    {
      'email': email,
      'password': password,
      'firstName': firstName,
      'lastName': lastName
    };

    var data = JSON.stringify(request);
    console.log(request);
    alert(request);

    var ajaxRequest = $.ajax({
      type: 'POST',
      url: customURI,
      contentType: 'application/json',
      processData: true,
      data: data,

      error: function (xhr, status, error) {
        console.log(xhr);
        console.log(status);
        console.log(error);
        console.log(request);
      }
    });

    ajaxRequest.done(function (xhr, textStatus) {
    // $('#response').attr('class', 'alert alert-success');
      alert('Volunteer created successfully');
    });
  });
  return false;
});
