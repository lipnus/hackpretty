// import
var express = require('express');
var fs = require('fs');
var bodyParser = require('body-parser');
var mysql = require('mysql');
var request = require('request');
var gcloud = require('gcloud')({
	/**
	 * keyfile --> google vision console에서 발급
	 */
	keyFilename: 'hackpretty-47c76d932490.json',
	projectId: 'hackpretty-180110'
});
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

// index loader for test
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

// GET IMG handle
app.get('/img/:id', function(req, res) {
	// console.log(id);
	var img_id = req.params.id;
	res.sendFile(__dirname+"/img/"+img_id+".jpg");
});

// POST handle
app.post('/', function(req, res) {
	console.log('POST /');
	console.log(req.body);
});

// Input: Keyword
// Output: 해당하는 product list (ingredients count 필드 추가)
//
// 키워드 받아서 product name으로 검색
app.post('/search', function(req, res) {
	console.log('post search by keyword');
	console.log(req.body);

	var keyword = req.body.keyword;

	// using name
	// Join 사용
	// ---> connection query는 비동기라 쿼리 여러번 쓰는건 X
	connection.query("SELECT product.*, COUNT(ingredient.id) as score FROM `product` LEFT OUTER JOIN `ingredient` ON ingredient.prod_id = product.prod_id WHERE name LIKE '%"+keyword+"%' GROUP BY product.prod_id LIMIT 1;", function (err, rows, fields) {
		if (err) {
			console.log("Error while performing query.", err);
			
			res.send();
		} else {
			//--> return single row
			console.log("response rows:", rows);
			if (rows.length == 0) {
				res.writeHead(200, {'Content-Type': 'text/plain'});
				res.end(JSON.stringify({
					"response": "reject"
				}));
			}

			// res.set('Content-Type', 'text/plain');
			res.writeHead(200, {'Content-Type': 'text/plain; charset=utf-8'});
			res.end(JSON.stringify(rows[0]));
		}
	});
});

// Input: [ids]?
// app.post('/ingredients', function(req, res) {
// });

app.post('/img_search', function(req, res) {
	//search product info by image (Base64 encoded)
	console.log('img upload');
	// console.log(req.body);

	//decoded ==> img
	var base64encoded = req.body.image;
	// var decoded = new Buffer(base64encoded, 'base64');

	//google image search api is deprecated
	// --> google vision api
	// fs.writeFile("test.jpg", decoded, "binary", function(err) 
	fs.writeFile("temp.png", base64encoded, 'base64', function(err) {
		if (err) {
			console.log("err:",err);
		}
	});


	console.log("vision start");

	var vision = gcloud.vision();
	// Choose what the Vision API should detect
	// Choices are: faces, landmarks, labels, logos, properties, safeSearch, texts
	var types = ['labels'];

	console.log("before send");

	// Send the image to the Cloud Vision API
	vision.detect("temp.png", types, function(err, detections, apiResponse) {
		if (err) {
			res.end('Cloud Vision Error:', err);
		} else {
			res.writeHead(200, {'Content-Type': 'text/plain'});

			// Write out the JSON output of the Vision API
			res.end(JSON.stringify(detections, null, 4));
		}
	});

	console.log("vision end");
});


// Listen
port = 3000;
app.listen(port);
console.log('Listening at http://localhost:' + port);