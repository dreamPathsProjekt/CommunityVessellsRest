var url = 'http://localhost:8080/api/';

$('#test23').click(function getOrganizations () {
  $.get(url + 'organizations/')
    .done(function (data) {
      var organizations = data._embedded.organizations;
      for (let i = 0; i < organizations.length; i++) {
        $('#show').append('<br>' + organizations[i].name + '<a href=' + url + 'organizations/' + organizations[i].id + '>goto</a>');
        $('#show').append('<br>' + organizations[i].email);
        $('#show').append('<br>---<br>');
        // alert(organizations[i].name);
        // alert(organizations[i].email);
        let scrollPos = $('#show').offset().top;
        $(window).scrollTop(scrollPos);
      }
    });
});