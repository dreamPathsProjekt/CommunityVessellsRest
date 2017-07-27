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

  // showCreatePromisePage();

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
function showCreatePromisePage (promiseURI, containerType) {
  $('#rowVol').hide();
  $('#eventRowVol').hide();
  // load form based on content type
  if (containerType === 'Food' || containerType === 'Pharmaceuticals') {
    showCreateExp(promiseURI);
  }
  if (containerType === 'Clothing') {
    showCreateCloth(promiseURI);
  }
}

function showCreateExp (promiseURI) {
  $('#promisePage').empty().load('/templates/createPromiseExp.html', function () {
    $('.resetbtn').click(function () {
      $('#inputHidden').hide();
      $('#alertEvent').hide();
    });

    $('#promise').hide().show(600, function () {
      let scrollPos = $(this).offset().top;
      $(window).scrollTop(scrollPos);
    });
    // Flatpickr init

    $('#expire').flatpickr({
      minDate: 'today'
    });

    createExpPromiseAjax(promiseURI);
  });
}

function showCreateCloth (promiseURI) {
  $('#promisePage').empty().load('/templates/createPromiseCloth.html', function () {
    $('.resetbtn').click(function () {
      $('#inputHidden').hide();
      $('#alertEvent').hide();
    });

    $('#promise').hide().show(600, function () {
      let scrollPos = $(this).offset().top;
      $(window).scrollTop(scrollPos);
    });

    createClothPromiseAjax(promiseURI);
  });
}
