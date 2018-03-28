$('#refacButton').click(function(){

    saveFile();
    openPopup();
    setTimeout("loadFile()", 1000);
});


function openPopup() {
    var b = document.getElementById("Options1");
    var opt = b.options[b.selectedIndex].value;
     if(opt==="f1")
     {
     prompt("Please choose an old variable name");
     prompt("Please choose a new variable name");
     }
     else if(opt==="f2"){
         var oldVar = prompt("Please choose an old function name");
         var arity = prompt("Please choose the arity");
         var newVar = prompt("Please choose a new variable name");
         
         $.ajax({
            type: 'POST',
            data: {oldVar: oldVar, arity: arity, newVar: newVar},
            url: 'http://localhost:8080/path',
        })
        $("txtAfter").load("testfile.erl");
     }
     else if(opt==="f3"){
         prompt("Please choose an old module name");
         prompt("Please choose a new module name")
     }
     else if(opt==="f4"){
         prompt("Please choose old parameter name");
         prompt("Please choose new parameter name")
     }
     else if(opt==="f5"){
         prompt("Please specify target module name");
     }
     else if(opt==="f6"){
         prompt("Please specify new function name");
     }
     else if(opt==="f7"){
         prompt("Please specify new variable name");
     }
     else if(opt==="f8"){
         prompt("Please select variable name");
     }
     else if(opt==="f10"){
         prompt("Please select a sequence of parameters");
     }
}

function saveFile(){

    var file = document.getElementById("txtBefore").value;
    
    $.ajax({
        type: 'POST',
        data: {file},
        url: 'http://localhost:8080/save',
    })

}

function loadFile(){

    $(document).ready(function() {
            $.ajax({
                url : 'http://localhost:8080/load',
                type: 'get',
                dataType: "text",
                complete : function (r) {
                    $("#txtAfter").val(r.responseText);
                },
                
            });

    });
}