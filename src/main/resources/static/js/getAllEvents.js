var volunteerId = $('#hiddenId').text();

function eventTabGenerator (eventObj, eventContainer, organization) {
  $('#eventWrapVol').append('<div class="well text-center center-block event" id=eventTab' + eventObj.id + '>' +
    '<h1 class="h1_label primary-text-color eventTitle" >' + eventObj.title + '</h1>' +
    '<img class="img-responsive img-rounded eventImg" src=' + eventObj.avatar + '/>' +
    // '<hr class="divider-color">' +
    '<div>' +
    '<p class="maintext pad"><b>Organization</b>: ' + organization.name + '</p>' +
    '<p class="maintext pad"><b>Starts:</b> ' + eventObj.startdate + '</p>' +
    '<p class="maintext pad"><b>Ends:</b> ' + eventObj.closedate + '</p>' +
    '<p class="maintext pad"><b>Address:</b> ' + eventObj.address + '</p>' +
    '<hr class="divider-color">' +
    '<h3 class="h1_label contTitle">Event Container: ' +
    '<span class="h1_label primary-text-color">' + eventContainer.title + '</span></h3>' +
    '<p class="maintext pad"><b>Type of Products:</b> ' + eventContainer.type + '</p>' +
    '<p class="maintext pad"><b>Total Capacity:</b> ' + eventContainer.capacity + '</p>' +
    '<p class="maintext pad"><b>Available Products:</b> ' + eventContainer.availableProducts + '</p>' +
    '<button type="submit" class="btn btn-raised btn-default productBtn">Promise</button>' +
    '</div></div>');
  // var products = eventContainer._links.products.href;
  // generate href for promise
  $('#eventTab' + eventObj.id).find('.productBtn').click(function () {
    var promiseURI = '/api/event/' + eventObj.id + '/promise/' + volunteerId;
    var containerType = eventContainer.type;
    showCreatePromisePage(promiseURI, containerType);
  });
}

function eventTabGeneratorWithoutImage (eventObj, eventContainer, organization) {
  $('#eventWrapVol').append('<div class="well text-center center-block event" id=eventTab' + eventObj.id + '>' +
    '<h1 class="h1_label primary-text-color eventTitle" >' + eventObj.title + '</h1>' +
    '<img class="img-responsive img-rounded eventImg" src="/img/missing.jpg" />' +
    // '<hr class="divider-color">' +
    '<div>' +
    '<p class="maintext pad"><b>Organization</b>: ' + organization.name + '</p>' +
    '<p class="maintext pad"><b>Starts:</b> ' + eventObj.startdate + '</p>' +
    '<p class="maintext pad"><b>Ends:</b> ' + eventObj.closedate + '</p>' +
    '<p class="maintext pad"><b>Address:</b> ' + eventObj.address + '</p>' +
    '<hr class="divider-color">' +
    '<h3 class="h1_label contTitle">Event Container: ' +
    '<span class="h1_label primary-text-color">' + eventContainer.title + '</span></h3>' +
    '<p class="maintext pad"><b>Type of Products:</b> ' + eventContainer.type + '</p>' +
    '<p class="maintext pad"><b>Total Capacity:</b> ' + eventContainer.capacity + '</p>' +
    '<p class="maintext pad"><b>Available Products:</b> ' + eventContainer.availableProducts + '</p>' +
    '<button type="submit" class="btn btn-raised btn-default productBtn">Promise</button>' +
    '</div></div>');
  // var products = eventContainer._links.products.href;
  // generate href for promise
  $('#eventTab' + eventObj.id).find('.productBtn').click(function () {
    var promiseURI = '/api/event/' + eventObj.id + '/promise/' + volunteerId;
    var containerType = eventContainer.type;
    showCreatePromisePage(promiseURI, containerType);
  });
}

function getAllEvents () {
  var url = '/api/events/?page=0&size=100';
  $.get(url).done(function (events) {
    var eventsArray = events._embedded.events;
    for (let i = 0; i < eventsArray.length; i++) {
      console.log(eventsArray[i]);
      console.log(eventsArray[i]._links.eventContainer.href);
      console.log(eventsArray[i]._links.organization.href);

      $.get(eventsArray[i]._links.eventContainer.href).done(function (eventContainer) {
        $.get(eventsArray[i]._links.organization.href).done(function (organization) {
          if (eventsArray[i].avatar !== null) {
            eventTabGenerator(eventsArray[i], eventContainer, organization);
          } else {
            eventTabGeneratorWithoutImage(eventsArray[i], eventContainer, organization);
          }
        });
      });
    }
  });
}
