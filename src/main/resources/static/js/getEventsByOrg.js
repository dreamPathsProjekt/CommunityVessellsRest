function eventTabGenerator (eventObj, eventContainer) {
  $('#eventWrap').append('<div class="well text-center center-block event" id=eventTab' + eventObj.id + '>' +
    '<h1 class="h1_label primary-text-color eventTitle" >' + eventObj.title + '</h1>' +
    '<img class="img-responsive img-rounded eventImg" src=' + eventObj.avatar + '/>' +
    // '<hr class="divider-color">' +
    '<div>' +
    // 'Organization: <p class="maintext pad">' + eventObj.organization + '</p>' +
    '<p class="maintext pad"><b>Starts:</b> ' + eventObj.startdate + '</p>' +
    '<p class="maintext pad"><b>Ends:</b> ' + eventObj.closedate + '</p>' +
    '<p class="maintext pad"><b>Address:</b> ' + eventObj.address + '</p>' +
    '<hr class="divider-color">' +
    '<h3 class="h1_label contTitle">Event Container: ' +
    '<span class="h1_label primary-text-color">' + eventContainer.title + '</span></h3>' +
    '<p class="maintext pad"><b>Type of Products:</b> ' + eventContainer.type + '</p>' +
    '<p class="maintext pad"><b>Total Capacity:</b> ' + eventContainer.capacity + '</p>' +
    '<p class="maintext pad"><b>Available Products:</b> ' + eventContainer.availableProducts + '</p>' +
    '<button type="submit" class="btn btn-raised btn-default productBtn">Show Products</button>' +
    '</div></div>');
  var products = eventContainer._links.products.href;
  // generate href
  $('#eventTab' + eventObj.id).find('.productBtn').click(function () {
    $.get(products).done(function (data) {
      // bind uri ok
      alert(products);
    });
  });
}

function eventTabGeneratorWithoutImage (eventObj, eventContainer) {
  $('#eventWrap').append('<div class="well text-center center-block event" id=eventTab' + eventObj.id + '>' +
    '<h1 class="h1_label primary-text-color eventTitle" >' + eventObj.title + '</h1>' +
    '<img class="img-responsive img-rounded eventImg" src="/img/missing.jpg" />' +
    // '<hr class="divider-color">' +
    '<div>' +
    // 'Organization: <p class="maintext pad">' + eventObj.organization + '</p>' +
    '<p class="maintext pad"><b>Starts:</b> ' + eventObj.startdate + '</p>' +
    '<p class="maintext pad"><b>Ends:</b> ' + eventObj.closedate + '</p>' +
    '<p class="maintext pad"><b>Address:</b> ' + eventObj.address + '</p>' +
    '<hr class="divider-color">' +
    '<h3 class="h1_label contTitle">Event Container: ' +
    '<span class="h1_label primary-text-color">' + eventContainer.title + '</span></h3>' +
    '<p class="maintext pad"><b>Type of Products:</b> ' + eventContainer.type + '</p>' +
    '<p class="maintext pad"><b>Total Capacity:</b> ' + eventContainer.capacity + '</p>' +
    '<p class="maintext pad"><b>Available Products:</b> ' + eventContainer.availableProducts + '</p>' +
    '<button type="submit" class="btn btn-raised btn-default productBtn">Show Products</button>' +
    '</div></div>');
  var products = eventContainer._links.products.href;
  // generate href
  $('#eventTab' + eventObj.id).find('.productBtn').click(function () {
    $.get(products).done(function (data) {
      // bind uri ok
      alert(products);
    });
  });
}

function getProducts (eventContainer) {
  $('.productBtn').click(function () {
    alert(eventContainer);
  });
}

function getEventsByOrg () {
  var url = '/api/organizations/';
  var id = $('#hiddenId').text();
  $.get(url + id + '/events').done(function (orgEvents) {
    var eventsArray = orgEvents._embedded.events;
    for (let i = 0; i < eventsArray.length; i++) {
      console.log(eventsArray[i]);
      console.log(eventsArray[i]._links.eventContainer.href);

      $.get(eventsArray[i]._links.eventContainer.href).done(function (eventContainer) {
        if (eventsArray[i].avatar !== null) {
          eventTabGenerator(eventsArray[i], eventContainer);
        } else {
          eventTabGeneratorWithoutImage(eventsArray[i], eventContainer);
        }
      });
    }
  });
}
