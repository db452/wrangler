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
         app.startApp();
         //app.renameFunction(oldVar,arity,newVar);

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