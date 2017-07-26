var urlOrg = '/api/';

var createEventAjax = function (e) {
  e.preventDefault();

  var orgId = $('#hiddenId').text();
  var customURIEvent = urlOrg + 'organization/' + orgId + '/event';
  var eventData = jsonfromInputEvent('#inputEventTitle', '#inputStart', '#inputEnd', '#address', '#inputContainerTitle', '#inputContainerType', '#inputCapacity');
  var avatarData = getEventFile('#eventFile');

  $.ajax({
    type: 'POST',
    url: customURIEvent,
    contentType: 'application/json',
    processData: true,
    data: eventData

  }).done(function (responseData, status, xhr) {
    // get location from xhr header and follow link
    var follow = xhr.getResponseHeader('Location');
    $.get(follow).done(function (event) {
      // get back object created to retrieve id

      var avatarURIEvent = urlOrg + 'event/' + event.id + '/avatar';
      // alert(avatarURIOrg);
      // code to upload here
      alertSuccessEvent('#alertEvent', '#responseMsgEvent');

      $.ajax({
        url: avatarURIEvent,
        type: 'POST',
        data: avatarData,
        cache: false,
        contentType: false,
        enctype: 'multipart/form-data',
        processData: false
      }).done(function () {
        alertSuccessEvent('#alertEvent', '#responseMsgEvent');
      });
    })
      .fail(function (xhr, status, error) {
        errorHandlingEvent(xhr, '#alertEvent', '#responseMsgEvent');
      });
  })
    .fail(function (xhr, status, error) {
      errorHandlingEvent(xhr, '#alertEvent', '#responseMsgEvent');
    });

  return false;
};

// gets input values and creates json Object
function jsonfromInputEvent (inputEventTitle, inputStart, inputEnd, address, inputContainerTitle, inputContainerType, inputCapacity) {
  var title = $(inputEventTitle).val();
  var startDate = $(inputStart).val();
  var endDate = $(inputEnd).val();
  var addr = $(address).val();
  var containerTitle = $(inputContainerTitle).val();
  var type = $(inputContainerType + ' option:selected').text();
  var capacity = $(inputCapacity).val();

  return JSON.stringify({
    'title': title,
    'startdate': startDate,
    'closedate': endDate,
    'address': addr,

    'eventContainer': {
      'title': containerTitle,
      'type': type,
      'capacity': capacity
    }

  });
}

// get image file
function getEventFile (eventFile) {
  var formDataOrg = new FormData();
  formDataOrg.append('file', $(eventFile)[0].files[0]);
  return formDataOrg;
}

function errorHandlingEvent (xhr, alert, msgId) {
  $(msgId).empty().append('<strong>Error: New Event Creation Failed</strong>');
  $(alert).hide().show(500).attr('class', 'alert alert-dismissible alert-danger', function () {
    let scrollPos = $(alert).offset().top;
    $(window).scrollTop(scrollPos);
  });
}

function alertSuccessEvent (alert, msgId) {
  $(msgId).empty().append('<strong>Success: New Event Created</strong>');
  $(alert).hide().show(500).attr('class', 'alert alert-dismissible alert-success', function () {
    let scrollPos = $(alert).offset().top;
    $(window).scrollTop(scrollPos);
  });
}
