$(document).ready(function() {
    $.getJSON("http://localhost:5000/getuserinfo",function(msg){

        if(msg.status == 404)
            alert("Please login!");
        else
        {

            $("#username").html("Hello, " + msg.user.username+"!");
            $("#email").html("My email: " + msg.user.email);
            $("#address").html("My address: " + msg.user.city + ", " + msg.user.state + ", " + msg.user.country);
            $("#profile").html("My profile: " + msg.user.profile);

            $.getJSON("http://localhost:5000/point/" + msg.user.u_id,function(point){

                if(point.status == 404)
                    alert("Please login!");
                else
                {
                    $("#point").html("My current points: " + point.user.point);
                }
            });

            $.getJSON("http://localhost:5000/level/" + msg.user.u_id,function(level){

                if(level.status == 404)
                    alert("Please login!");
                else
                {
                    $("#level").html("My current level: " + (level.user.level ==3 ? 'expert':(msg.user.level ==2 ? 'advanced':'basic')));
                }
            });
        }
    });
})