$(document).ready(function() {
    $.getJSON("http://localhost:5000/getuserinfo",function(msg){

        if(msg.status == 404)
            alert("Please login!");
        else
        {
            $.getJSON("http://localhost:5000/getuseranswer",function(msg){
                if (msg.answerList != null) {
                    for (const cur of msg.answerList) {
                        $("#card-parent").html((index, cxt) => {
                            return cxt + '   <div class="card-body">\n' +
                                '                <p class="card-text" style="margin-left:20px;font-size: 25px;" id = "pid">' + "Post：" + cur.p_title + '</p>\n' +
                                '                <p class="card-text" style="margin-left:20px;font-size: 25px;" id = "body">' + "Answer content：" + cur.a_content + '</p>\n' +
                                '                <p class="card-text" style="margin-left:20px;font-size: 20px;" id = "date">' + "Answer Date： " + cur.a_date + '</p>\n' +
                                '                <p class="card-title" style="margin-left:20px;" id = "thumbup">' + "Thumbup： " + cur.thumbup + '</p>\n' +
                                '                <p class="card-text" style="margin-left:20px;" id = "ifbest">' + "Best Answer： " + cur.p_date + '</p>\n' +
                                '                <p class="card-text" style="margin-left:20px;color: darkgreen" id = "status">' + "Status： " + (cur.status == 1 ? "Yes" : "No") + '</p>\n' +
                                '                <a href="#" class="btn btn-primary" style="margin-left:20px;margin-bottom: 20px;" onclick="gopost(' + cur.p_id + ')">View Question</a>\n' +
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