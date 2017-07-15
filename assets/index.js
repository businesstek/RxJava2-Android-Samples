//
// go to path of heroku
// git add *
// git commit -m "fix"
// git push heroku master
// https://secret-ridge-27839.herokuapp.com/getAnUser/12

var express = require('express');
var app = express();

var user = [{
    id: 12,
    firstname: 'able',
    lastname: 'black',
    isfollowing: ['baseball']
  },
  {
    id: 13,
    firstname: 'bly',
    lastname: 'cane',
    isfollowing: ['football']
  },
  {
    id: 14,
    firstname: 'candy',
    lastname: 'donut',
    isfollowing: ['baseball', 'football']
  }];

var userdetail =[
  {
    id: 12,
    firstname: 'able',
    lastname: 'black'
  },
  {
    id: 13,
    firstname: 'bly',
    lastname: 'cane'
  },
  {
    id: 14,
    firstname: 'candy',
    lastname: 'donut'
  }
];

app.set('port', (process.env.PORT || 5000));

//for android app
app.get('/getAnUser/:userId', function(request, response) {
  var id = request.params.userId;
  var item = userdetail.filter(function(el) {
    return (el.id == id);
  });
var str = JSON.stringify(item[0]);
response.send(str);
});

app.get('/getAllBaseballFans', function(request, response) {
  var item = user.filter(function(el) {
    return (el.isfollowing.indexOf("baseball") >= 0);
  });
  var jObject={};
  for(i in item)
  {
      jObject[i] = item[i];
  }
  response.send(jObject);
});

app.get('/getAllFootballFans', function(request, response) {
  var item = user.filter(function(el) {
    return (el.isfollowing.indexOf("football") >= 0);
  });
  var jObject={};
  for(i in item)
  {
      jObject[i] = item[i];
  }
  response.send(jObject);

});

app.get('/getAllFriends/:userId', function(request, response) {
  var id = request.params.userId;
  var item = user.filter(function(el) {
    return (el.id === id);
  });
  response.send(item);
});

app.get('/getAllUsers', function(request, response) {
  response.send(user);
});

app.get('/getAnUserDetail/:userId', function(request, response) {
var id = request.params.userId;
  var item = userdetail.filter(function(el) {
    return (el.id == id);
  });
  response.send(item);
});


app.listen(app.get('port'), function() {
  console.log('Node app is running on port', app.get('port'));
});
