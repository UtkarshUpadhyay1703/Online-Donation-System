var mysql = require('mysql');

var con = mysql.createConnection({
  host: "localhost",
  user: "root",
  password: "sah_utk",
  database: "test"
});

con.connect(function (err) {
  if (err) throw err;
  con.query("SELECT * FROM emp", function (err, result, fields) {
    if (err) throw err;
    console.log(result);
  });
});              