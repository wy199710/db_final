$(document).ready(function() {
    $.getJSON("http://localhost:5000/getuserinfo",function(msg){

        if(msg.status == 404)
            alert("Please login!");
        else
        {
            $.getJSON("http://localhost:5000/post",function(msg){
                if (msg.post != null) {
                    for (const cur of msg.post) {
                        $("#card-parent").html((index, cxt) => {
                            return cxt + '   <div class="card-body">\n' +
                                '                <p class="card-text" style="margin-left:20px;font-size: 25px;" id = "title">' + cur.p_title + '</p>\n' +
                                '                <p class="card-text" style="margin-left:20px;font-size: 25px;" id = "body">' + "Description： " + cur.p_body + '</p>\n' +
                                '                <p class="card-text" style="margin-left:20px;font-size: 20px;" id = "topic">' + "Topic： " + cur.t_name + '</p>\n' +
                                '                <p class="card-title" style="margin-left:20px;" id = "username">' + "Author： " + cur.username + '</p>\n' +
                                '                <p class="card-text" style="margin-left:20px;" id = "date">' + "Post date： " + cur.p_date + '</p>\n' +
                                '                <p class="card-text" style="margin-left:20px;color: darkgreen" id = "status">' + "Status： " + cur.status + '</p>\n' +
                                '                <a href="#" class="btn btn-primary" style="margin-left:20px;margin-bottom: 20px;"  onclick="gopost(' + cur.p_id + ')">See All answers</a>\n' +
                                '            </div>';
                        });
                    }
                }
            });
        }
    });
})

function gopost(pid) {
    window.location.href = "http://localhost:5000/postdetail.html?pid=" + pid;
}