$(document).ready(function() {
    $.getJSON("http://localhost:5000/getuserinfo",function(msg){

        if(msg.status == 404)
            alert("Please login!");
        else
        {
            $.getJSON("http://localhost:5000/getuserpost",function(msg){
                if (msg.postList != null) {
                    for (const cur of msg.postList) {
                        $("#card-parent").html((index, cxt) => {
                            return cxt + '   <div class="card-body" style="background-color: white;height:auto;margin-top:30px;border-radius: 10px">\n' +
                                '                <p class="card-text" style="padding-left:20px;font-size: 25px;background-color: darkblue;color:white;border-radius: 10px" id = "title">' + cur.p_title + '</p>\n' +
                                '                <p class="card-text" style="margin-left:20px;font-size: 22px;" id = "body">' + "Description： " + cur.p_body + '</p>\n' +
                                '                <p class="card-text" style="margin-left:20px;font-size: 18px;color:darkred;font-style:italic"  id = "topic">' + "Topic： " + cur.t_name + '</p>\n' +
                                '                <p class="card-text" style="margin-left:20px;font-size: 18px;" id = "username">' + "Author： " + cur.username + '</p>\n' +
                                '                <p class="card-text" style="margin-left:20px;" id = "date">' + "Post date： " + cur.p_date + '</p>\n' +
                                '                <p class="card-text" style="margin-left:20px;color: darkgreen" id = "status">' + "Status：" + (cur.status==1 ? "resolved":"unresolved") + '</p>\n' +
                                '                <a href="#" class="btn btn-primary" style="margin-left:20px;margin-bottom: 20px;"  onclick="gopost(' + cur.p_id + ')">See All answers</a>\n' +
                                '            </div>';
                        });
                    }
                }
            });
        }
    });
})

function gocreate() {
    window.location.href = "http://localhost:5000/createpost.html";
}

function gopost(pid) {
    window.location.href = "http://localhost:5000/postdetail.html?pid=" + pid;
}