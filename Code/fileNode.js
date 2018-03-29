var http = require('http');
var connect = require('connect');
var qs = require('querystring');
var parse = require('parse');
var express = require('express');
var app = express();
var bodyParser = require('body-parser');
var fs = require('fs');

var write = function(a, b, c){
    var classPath = '.:/usr/lib/erlang/lib/jinterface-1.8/priv/OtpErlang.jar'
    var child = require('child_process').spawn(
        'java', ['-classpath', classPath, 'Codefile', a, b, c]
      );
    }


    app.use(bodyParser.urlencoded({ extended: true }));

    app.post("/save", function (req1, res1){
        var file1 = req1.body.file;
        var stream = fs.createWriteStream("file.erl");
        stream.once('open', function(fd) {
        stream.write(file1);
        stream.end();   
        });

    });


    app.post("/path", function (req, res) {
        var oldVar1 = req.body.oldVar
        var arity1 = req.body.arity;
        var newVar1 = req.body.newVar;
        write(oldVar1, arity1, newVar1);
        console.log('success!', oldVar1, arity1, newVar1);
        res.end();
    });

    app.get("/load", function (req, res) {

        fs.readFile('file.erl', 'utf8', function(err, output) { 
            console.log(output); 
            res.send(output);
        })
    });
    




    app.listen(8080);
  

