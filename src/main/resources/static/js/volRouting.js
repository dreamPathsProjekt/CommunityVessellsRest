$('#homePageVol').click(function () {
  $('#promise').hide();
  $('#eventRowVol').hide();

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

$('#promisesButton').click(function () {
  $('#rowVol').hide();
  $('#eventRowVol').hide();

  //showCreateEventPage();

  $('#promise').hide().show(600, function () {
    let scrollPos = $(this).offset().top;
    $(window).scrollTop(scrollPos);
  });
});

$('#eventsPageVol').click(function () {
  $('#rowVol').hide();
  $('#promise').hide();

  getAllEvents();

  $('#eventRowVol').hide().show(600, function () {
    let scrollPos = $(this).offset().top;
    $(window).scrollTop(scrollPos);
  });
});

// change to create Promise
function showCreateEventPage () {
  $('#promisePage').empty().load('/templates/createEvent.html', function () {
    $('.resetbtn').click(function () {
      $('#inputHidden').hide();
      $('#alertEvent').hide();
    });

    // Flatpickr init

    $('#inputStart').flatpickr({
      minDate: 'today'
    });

    // Get the input Start Date and intantiate a new datepicker with this min Date
    $('#inputStart').change(function () {
      var selected = $('#inputStart').val();
      $('#inputHidden').show(1000);
      var newMin = Date.parse(selected);
      $('#inputEnd').flatpickr({
        minDate: newMin
      });
    });
    $('#sendEvent').submit(createEventAjax);
  });
}