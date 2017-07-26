function eventTabGenerator (eventObj, eventContainer) {
  $('#eventWrap').append('<div class="well text-center center-block" id=eventTab' + eventObj.id + '>' +
    '<h1 class="h1_label primary-text-color eventTitle" >' + eventObj.title + '</h1>' +
    '<img class="img-responsive img-rounded" src=' + eventObj.avatar + '/>' +
    '<hr class="divider-color">' +
    '<div>' +
    // 'Organization: <p class="maintext pad">' + eventObj.organization + '</p>' +
    'Start: <p class="maintext pad">' + eventObj.startdate + '</p>' +
    'Ends: <p class="maintext pad">' + eventObj.closedate + '</p>' +
    'Address: <p class="maintext pad">' + eventObj.address + '</p>' +
    '<hr class="divider-color">' +
    '<h3 class="h1_label primary-text-color">Event Container</h3>' +
    '<h3 class="h1_label primary-text-color">' + eventContainer.title + '</h3>' +
    'Type of Products: <p class="maintext pad">' + eventContainer.type + '</p>' +
    'Total Capacity: <p class="maintext pad">' + eventContainer.capacity + '</p>' +
    'Available Products: <p class="maintext pad">' + eventContainer.availableProducts + '</p>' +
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
  $('#eventWrap').append('<div class="well text-center center-block" id=eventTab' + eventObj.id + '>' +
    '<h1 class="h1_label primary-text-color eventTitle" >' + eventObj.title + '</h1>' +
    '<img class="img-responsive img-rounded" src="/img/missing.jpg" />' +
    '<hr class="divider-color">' +
    '<div>' +
    // 'Organization: <p class="maintext pad">' + eventObj.organization + '</p>' +
    'Start: <p class="maintext pad">' + eventObj.startdate + '</p>' +
    'Ends: <p class="maintext pad">' + eventObj.closedate + '</p>' +
    'Address: <p class="maintext pad">' + eventObj.address + '</p>' +
    '<hr class="divider-color">' +
    '<h3 class="h1_label primary-text-color">Event Container</h3>' +
    '<h3 class="h1_label primary-text-color">' + eventContainer.title + '</h3>' +
    'Type of Products: <p class="maintext pad">' + eventContainer.type + '</p>' +
    'Total Capacity: <p class="maintext pad">' + eventContainer.capacity + '</p>' +
    'Available Products: <p class="maintext pad">' + eventContainer.availableProducts + '</p>' +
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
