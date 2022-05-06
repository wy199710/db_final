var pid;
$(document).ready(function() {
    $.getJSON("http://localhost:5000/getuserinfo",function(msg){

        if(msg.status == 404)
            alert("Please login!");
        else {
            p_id = getQueryVariable("pid");
            $.getJSON("http://localhost:5000/post/" + p_id,function(msg){
                if (msg.post != null) {
                    $("#title").html(msg.post.p_title);
                    $("#body").html(msg.post.p_body);
                    $("#topic").html(msg.post.t_name);
                    $("#username").html(msg.post.username);
                    $("#date").html(msg.post.p_date);
                    $("#status").html("Status： " + msg.post.status);
                }
            });
            updateAnswer();
        }
    });

})

function updateAnswer() {
    $("#card-parent").html('');
    $.getJSON("http://localhost:5000/answerbypid/" + p_id,function(msg){
        if (msg.answer != null) {
            for (const cur of msg.answer) {
                $("#card-parent").html((index, cxt) => {
                    // style="margin: 0 0 5px 0; border: black solid 2px; border-radius: 10px"
                    return cxt +
                        '<div className="card" style="position: relative;top:50px;left:200px;background-color:aliceblue;height:fit-content;width: 80%;border-radius: 10px">' +
                        '   <div class="card-body">\n' +
                        '                <p class="card-text" style="margin-left:20px; color: red" id = "best">' + (cur.best_answer == true ? "This is the best answer!" : "") + '</p>\n' +
                        '                <p class="card-text" style="margin-left:20px;font-size: 25px;" id = "a_body">' + cur.a_content + '</p>\n' +
                        '                <p class="card-text" style="margin-left:20px;font-size: 25px;" id = "a_uname">' + "Author： " + cur.u_id + '</p>\n' +
                        '                <p class="card-text" style="margin-left:20px;font-size: 20px;" id = "thumbup">' + "Likes： " + cur.thumbup +
                        '<button class="btn btn-primary" style="margin-left: 20px" onclick="addlike(' + cur.a_id + ')">I like it!</button>' + '</p>\n' +
                        '                <p class="card-title" style="margin-left:20px;" id = "a_date">' + "Answer date： " + cur.a_date + '</p>\n' +
                        '            </div></div>';
                });
            }
        }
    });
}

function getQueryVariable(variable)
{
    var query = window.location.search.substring(1);
    var vars = query.split("&");
    for (var i=0;i<vars.length;i++) {
        var pair = vars[i].split("=");
        if(pair[0] == variable){return pair[1];}
    }
    return(false);
}

function addlike(aid)
{
    var data = {
        "a_id": aid
    }
    $.ajax({
            url:'http://localhost:5000/addlike',
            type:"post",
            datatype:"json",
            data:data,
            async :true,
            success:function(tt){
                if(tt.status==200)
                {
                    updateAnswer();
                }
            }
        }
    )
}