$(document).ready(function() {
})

function login() {
    var username = document.getElementById("username");
    var password = document.getElementById("password");

    var user = {
        "username":username.value,
        "password":password.value
    }
    $.ajax({
        type :"post",
        url:"http://localhost:5000/login",
        datatype: "json",
        data:user,
        async :true,
        success:function(msg){
            if(msg.status==200){
                alert("Success！");
                window.location.href = "http://localhost:5000/mainpage.html";
            }
            if(msg.status==400)
                alert("Password is wrong！");
            if(msg.status==404)
                alert("Account does not exist！");
        }
    })
}

function register() {
    var username = document.getElementById("username");
    var password = document.getElementById("password");

    var user = {
        "username":username.value,
        "password":password.value
    }
    $.ajax({
            url:'http://localhost:5000/register',
            type:"post",
            datatype:"json",
            data:user,
            async :true,
            success:function(tt){
                if(tt.status==200)
                {
                    alert("Success！");
                    window.location.href = "http://localhost:5000/mainpage.html";
                }

                if(tt.status==400)
                    alert("Account exists！");
            }
        }
    )
}