// import
var express = require('express');
var fs = require('fs');
var bodyParser = require('body-parser');

var app = express();
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended: true}));

app.get('/', function(req, res) {
  console.log('GET /');

  //index load (test)
  fs.readFile('index.html', function(error, data) {
  	if (error) {
  		console.log(error);
  	} else {
  		res.writeHead(200, {'Content-Type': 'text/html'});
  		res.end(data);
  	}
  });
});

// POST handle
app.post('/', function(req, res) {
  console.log('POST /');
  console.log(req.body);
});

app.post('/post-test', function(req, res) {
	console.log('post test');
	console.log(req.body);

	// respond
	res.writeHead(404);
	res.end("hah");
});

app.post('/post-main', function(req, res) {
	console.log('post main');
	console.log(req.body);

	// respond
	res.writeHead(200);
	res.end("success");
});

port = 3000;
app.listen(port);
console.log('Listening at http://localhost:' + port);