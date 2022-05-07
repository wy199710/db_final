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
                            return cxt + '   <div class="card-body" style="background-color: white;height:auto;margin-top:30px;border-radius: 10px">\n' +
                                '                <p class="card-text" style="padding-left:20px;font-size: 25px;background-color: darkblue;color:white;border-radius: 10px" id = "pid">' + "Post：" + cur.p_title + '</p>\n' +
                                '                <p class="card-text" style="margin-left:20px;font-size: 25px;" id = "body">' + "Answer content：" + cur.a_content + '</p>\n' +
                                '                <p class="card-text" style="margin-left:20px;font-size: 18px;" id = "date">' + "Answer Date： " + cur.a_date + '</p>\n' +
                                '                <p class="card-text" style="margin-left:20px;font-size: 18px;color:darkred;font-style:italic;" id = "thumbup">' + "Thumbup： " + cur.thumbup + '</p>\n' +
                                '                <p class="card-text" style="margin-left:20px;font-size: 18px;color: red" id = "ifbest">' + "Best Answer： " + (cur.best_answer == true? "Yes" : "No") + '</p>\n' +
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