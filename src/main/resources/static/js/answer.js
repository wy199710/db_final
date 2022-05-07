$(document).ready(function() {
    var userid;
    $.getJSON("http://localhost:5000/getuserinfo",function(msg){

        if(msg.status == 404)
            alert("Please login!");

        else
        {
            userid = msg.user.u_id;
            $.getJSON("http://localhost:5000/getuseranswer",function(msg){
                if (msg.answerList != null) {
                    for (const cur of msg.answerList) {
                        $("#card-parent").html((index, cxt) => {
<<<<<<< Updated upstream
                            return cxt + '   <div class="card-body">\n' +
                                '                <p class="card-text" style="margin-left:20px;font-size: 25px;" id = "pid">' + "Post id：" + cur.p_id + '</p>\n' +
                                '                <p class="card-text" style="margin-left:20px;font-size: 25px;" id = "body">' + "Answer content：" + cur.a_content + '</p>\n' +
                                '                <p class="card-text" style="margin-left:20px;font-size: 20px;" id = "date">' + "Answer Date： " + cur.a_date + '</p>\n' +
                                '                <p class="card-title" style="margin-left:20px;" id = "thumbup">' + "Thumbup： " + cur.thumb_up + '</p>\n' +
                                '                <p class="card-text" style="margin-left:20px;" id = "ifbest">' + "Best Answer： " + cur.p_date + '</p>\n' +
                                '                <p class="card-text" style="margin-left:20px;color: darkgreen" id = "status">' + "Status： " + (cur.status == 1 ? "Yes" : "No") + '</p>\n' +
=======
                            return cxt + '   <div class="card-body" style="background-color: white;height:auto;margin-top:30px;border-radius: 10px">\n' +
                                '                <p class="card-text" style="padding-left:20px;font-size: 25px;background-color: darkblue;color:white;border-radius: 10px" id = "pid">' + "Post：" + cur.p_title + '</p>\n' +
                                '                <p class="card-text" style="margin-left:20px;font-size: 25px;" id = "body">' + "Answer content：" + cur.a_content + '</p>\n' +
                                '                <p class="card-text" style="margin-left:20px;font-size: 18px;" id = "date">' + "Answer Date： " + cur.a_date + '</p>\n' +
                                '                <p class="card-title" style="margin-left:20px;font-size: 18px;color:darkred;font-style:italic;" id = "thumbup">' + "Like： " + cur.thumbup + '</p>\n' +
                                '                <p class="card-text" style="margin-left:20px;font-size: 18px;color: red" id = "ifbest">' + "Best Answer： " + (cur.best_answer == true? "Yes" : "No") + '</p>\n' +
>>>>>>> Stashed changes
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