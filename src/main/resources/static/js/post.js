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
                        $("#card-parent").html((index, cxt) => {
                            return cxt + '   <div class="card-body">\n' +
                                '                <p class="card-text" style="margin-left:20px;font-size: 25px;" id = "title">' + cur.p_title + '</p>\n' +
                                '                <p class="card-text" style="margin-left:20px;font-size: 25px;" id = "body">' + "Description： " + cur.p_body + '</p>\n' +
                                '                <p class="card-text" style="margin-left:20px;font-size: 20px;" id = "topic">' + "Topic： " + cur.t_id + '</p>\n' +
                                '                <p class="card-title" style="margin-left:20px;" id = "username">' + "Author： " + cur.u_id + '</p>\n' +
                                '                <p class="card-text" style="margin-left:20px;" id = "date">' + "Post date： " + cur.p_date + '</p>\n' +
                                '                <p class="card-text" style="margin-left:20px;color: darkgreen" id = "status">' + "Status： " + cur.status + '</p>\n' +
                                '                <a href="#" class="btn btn-primary" style="margin-left:20px;margin-bottom: 20px;"  onclick="gopost(' + cur.p_id + ')">See All answers</a>\n' +
                                '            </div>';
                        });
                    }
                }
            });

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
        }



    });
})

function gocreate() {
    window.location.href = "http://localhost:5000/createpost.html";
}

function gopost(pid) {
    window.location.href = "http://localhost:5000/postdetail.html?pid=" + pid;
}