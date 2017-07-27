function createExpPromiseAjax (promiseURI) {
  $('#sendPromise').submit(function (e) {
    e.preventDefault();
    var promiseData = jsonfromExp('#promiseTitle', '#expire', '#count');

    $.ajax({
      type: 'POST',
      url: promiseURI,
      contentType: 'application/json',
      processData: true,
      data: promiseData

    }).done(function (responseData, status, xhr) {
    // get location from xhr header and follow link
      var follow = xhr.getResponseHeader('Location');
      alert(follow);
      alertSuccessEvent('#alertEvent', '#responseMsgEvent');
    }).fail(function (xhr, status, error) {
      errorHandlingEvent(xhr, '#alertEvent', '#responseMsgEvent');
    });
    return false;
  });
}

function createClothPromiseAjax (promiseURI) {
  $('#sendPromise').submit(function (e) {  
  e.preventDefault();
  var promiseData = jsonfromCloth('#promiseTitle', '#sizeCloth', '#conditionCloth', '#count');

  $.ajax({
    type: 'POST',
    url: promiseURI,
    contentType: 'application/json',
    processData: true,
    data: promiseData

  }).done(function (responseData, status, xhr) {
    // get location from xhr header and follow link
    var follow = xhr.getResponseHeader('Location');
    alert(follow);
    alertSuccessEvent('#alertEvent', '#responseMsgEvent');
  }).fail(function (xhr, status, error) {
    errorHandlingEvent(xhr, '#alertEvent', '#responseMsgEvent');
  });
  return false;
  });
}

function jsonfromExp (promiseTitle, expire, count) {
  var title = $(promiseTitle).val();
  var expireIn = $(expire).val();
  var countIn = $(count).val();

  return JSON.stringify({
    'title': title,
    'count': countIn,
    'expireOps': {
      'expire': expireIn
    }

  });
}

function jsonfromCloth (promiseTitle, sizeCloth, conditionCloth, count) {
  var title = $(promiseTitle).val();
  var size = $(sizeCloth + ' option:selected').text();
  var clotheCondition = $(conditionCloth + ' option:selected').text();
  var countIn = $(count).val();

  return JSON.stringify({
    'title': title,
    'count': countIn,
    'clothOps': {
      'size': size,
      'clotheCondition': clotheCondition
    }

  });
}

function errorHandlingEvent (xhr, alert, msgId) {
  $(msgId).empty().append('<strong>Error: Creating Promise Failed</strong>');
  $(alert).hide().show(500).attr('class', 'alert alert-dismissible alert-danger', function () {
    let scrollPos = $(alert).offset().top;
    $(window).scrollTop(scrollPos);
  });
}

function alertSuccessEvent (alert, msgId) {
  $(msgId).empty().append('<strong>Success: Promise Created</strong>');
  $(alert).hide().show(500).attr('class', 'alert alert-dismissible alert-success', function () {
    let scrollPos = $(alert).offset().top;
    $(window).scrollTop(scrollPos);
  });
}
