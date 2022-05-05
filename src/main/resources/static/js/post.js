$(document).ready(function() {
    var userid;
    $.getJSON("http://localhost:5000/getuserinfo",function(msg){

        if(msg.status == 404)
            alert("Please login!");
        else
        {
            userid = msg.user.u_id;
            $.getJSON("http://localhost:5000/getuserpost",function(msg){
                if (msg.postList != null) {
                    for (const cur of msg.postList) {
                        $("#list-parent").html((index, cxt) => {
                            return cxt + '<li class="list-group-item" style="display: flex; justify-content: space-between">\n' + cur.p_title + ' ' + cur.p_body;
                        });
                    }
                }
            });
        }


        // $.getJSON("http://localhost:5000/post",function(msg){
        //     if(msg.status == 404)
        //         alert("Please login!");
        //     else {
        //         console.log(msg.post[1]);
        //         $("#title").html("    "+msg.post[1].p_title);
        //         $("#username").html("Author： "+msg.post[1].u_id);
        //         $("#topic").html("Topic： "+msg.post[1].t_id);
        //         $("#body").html("Description: "+msg.post[1].p_body);
        //         $("#date").html("Post date: " + msg.post[1].p_date);
        //         $("#status").html("Status: " + (msg.post[1].status ==1 ? "Resolved":"Unresolved"));
        //     }
        // });
    });
})

function gocreate() {
    window.location.href = "http://localhost:5000/createpost.html";
}