$('#homePage').click(function () {
  $('#createEvent').hide();
  $('#eventWrap').hide();

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

$('#createEventPage').click(function () {
  $('#rowOrg').hide();
  $('#eventWrap').hide();

  showCreateEventPage();

  $('#createEvent').hide().show(600, function () {
    let scrollPos = $(this).offset().top;
    $(window).scrollTop(scrollPos);
  });
});

function showCreateEventPage () {
  $('#createPage').empty().load('/templates/createEvent.html', function () {
    // Flatpickr init

    $('#inputStart').flatpickr({
      minDate: 'today'
    });

    // Get the input Start Date and intantiate a new datepicker with this min Date
    $('#inputStart').change(function () {
      var selected = $('#inputStart').val();
      alert(selected);
      var newMin = Date.parse(selected);
      $('#inputEnd').flatpickr({
        minDate: newMin
      });
    });
  });
}
