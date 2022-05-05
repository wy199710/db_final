$(document).ready(function() {
    $.getJSON("http://localhost:5000/getuserinfo",function(msg){

        if(msg.status == 404)
            alert("Please login!");
        else
        {
            $("#email").html("My email: " + msg.user.email);
            $("#address").html("My address: " + msg.user.city + ", " + msg.user.state + ", " + msg.user.country);
            $("#point").html("My current points: " + msg.user.point);
            $("#level").html("My current level: " + msg.user.level);
        }
    });
})