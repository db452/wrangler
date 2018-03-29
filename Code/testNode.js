var http = require('http');
var connect = require('connect');
var qs = require('querystring');
var parse = require('parse');
var express = require('express');
var app = express();
var bodyParser = require('body-parser');

var write = function(a, b, c){
    var classPath = '.:/usr/lib/erlang/lib/jinterface-1.8/priv/OtpErlang.jar'
    var child = require('child_process').spawn(
        'java', ['-classpath', classPath, 'Codefile', a, b, c]
      );
    }


    app.use(bodyParser.urlencoded({ extended: true }));


    app.post("/path", function (req, res) {
        var oldVar1 = req.body.oldVar
        var arity1 = req.body.arity;
        var newVar1 = req.body.newVar;
        write(oldVar1, arity1, newVar1);
        console.log('success!', oldVar1, arity1, newVar1);
        res.end();
    });

    app.listen(8080);
  

