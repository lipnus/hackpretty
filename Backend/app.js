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

// app.get('/', function(req, res) {
// });
// app.use(express.static(__dirname + '/img'));
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

// app.post('/post-test', function(req, res) {
// 	console.log('post test');
// 	console.log(req.body);

// 	// respond
// 	res.writeHead(404);
// 	res.end("hah");
// });

// app.post('/post-main', function(req, res) {
// 	console.log('post main');
// 	console.log(req.body);

// 	// respond
// 	res.writeHead(200);
// 	res.end("success");
// });

// app.post('/post-all-products', function(req, res) {
// 	console.log('post all products');
// 	console.log(req.body);
	
// 	// res.writeHead(200);
// 	connection.query('SELECT * from product', function (err, rows, fields) {
// 		if (err) {
// 			console.log("Error while performing query.", err);
// 		} else {
// 			// console.log("rows: ", rows);
// 			// console.log("fields: ", fields);
// 			// console.log("json send");
// 			// res.json(rows);

// 			res.writeHead(200);	//success
// 			res.set('Content-Type', 'text/plain');
// 			res.send(JSON.stringify(rows));
// 		}
// 	});
// });

// Input: Keyword
// Output: 해당하는 product list (ingredients count 필드 추가)
//
// 키워드 받아서 product name으로 검색
app.post('/search-by-keyword', function(req, res) {
	console.log('post search by keyword');
	console.log(req.body);

	var keyword = req.body.value;

	// using name
	// Join 사용
	// ---> connection query는 비동기라 쿼리 여러번 쓰는건 X
	connection.query("SELECT product.*, COUNT(ingredient.id) as score FROM `product` LEFT OUTER JOIN `ingredient` ON ingredient.prod_id = product.prod_id WHERE name LIKE '%"+keyword+"%' GROUP BY product.prod_id;", function (err, rows, fields) {
		if (err) {
			console.log("Error while performing query.", err);
		} else {
			res.set('Content-Type', 'text/plain');
			res.send(JSON.stringify(rows));
		}
	});
});

// Input: [ids]?
app.post('/ingredients', function(req, res) {

});

app.post('/search-by-image', function(req, res) {
	//search product info by image (Base64 encoded)
	console.log('img upload');
	console.log(req.body);

	//decoded ==> img
	var encoded = req.body.value;
	var decoded = new Buffer(encoded, 'base64').toString('ascii');

	//google image search api is deprecated
	// --> google vision api
});

// Listen
port = 3000;
app.listen(port);
console.log('Listening at http://localhost:' + port);