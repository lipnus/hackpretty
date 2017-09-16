// import
var express = require('express');
var fs = require('fs');
var bodyParser = require('body-parser');
var mysql = require('mysql');
var connection = mysql.createConnection({
	host: '163.180.118.201',
	user: 'hackpretty',
	password: 'hackpretty',
	port: 3306,
	database: 'hackpretty'
});

// instance
var app = express();
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended: true}));

connection.connect();

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

app.post('/post-all-products', function(req, res) {
	console.log('post all products');
	console.log(req.body);
	
	// res.writeHead(200);
	connection.query('SELECT * from product', function (err, rows, fields) {
		if (err) {
			console.log("Error while performing query.", err);
		} else {
			// console.log("rows: ", rows);
			// console.log("fields: ", fields);
			// console.log("json send");
			// res.json(rows);

			res.writeHead(200);	//success
			res.set('Content-Type', 'text/plain');
			res.send(JSON.stringify(rows));
		}
	});
});


//
app.post('/search-by-keyword', function(req, res) {
	console.log('post search by keyword');
	console.log(req.body);

	var keyword = req.body.value;

	connection.query("SELECT * FROM product WHERE name LIKE '%"+keyword+"%'", function (err, rows, fields) {
		if (err) {
			console.log("Error while performing query.", err);
		} else {
			// console.log("rows: ", rows);

			// res.writeHead(200);
			res.set('Content-Type', 'text/plain');
			res.send(JSON.stringify(rows));
		}
	});
});

port = 3000;
app.listen(port);
console.log('Listening at http://localhost:' + port);