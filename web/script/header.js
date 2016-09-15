/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function header()
{
    var str="Log In";
var result=str.italics();
document.getElementById("login").innerHTML=(result);
}

function validate()
{
    var pass=document.getElementById("pass").value;
    var cpass=document.getElementById("cpass").value;
    if(pass!==cpass)
    {
        alert("Password doesnt match");
        return false;
    }
    else
    {
    return true;
    }
    
    }

  function DoPost(){
      $.post("login", { action: "how" } );  
      form.submit();
   }


