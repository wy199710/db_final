var pid;
$(document).ready(function() {
})

function updatePost() {
    $.getJSON("http://localhost:5000/getuserinfo", function (msg) {
        if (msg.status == 404)
            alert("Please login!");
        else {
            p_id = getQueryVariable("pid");
            $.getJSON("http://localhost:5000/post/" + p_id, function (msg) {
                if (msg.post != null) {
                    $("#title").html(msg.post.p_title);
                    $("#body").html(msg.post.p_body);
                    $("#topic").html("Topic： " + (msg.post.t_name));
                    $("#username").html("Author： " + msg.post.username);
                    $("#date").html("Post Date： " + msg.post.p_date);
                    $("#status").html("Status： " + (msg.post.status == 1 ? "resolved" : "unresolved"));
                }
            });
            updateAnswer();
        }
    });
}
function updateAnswer() {
    $("#card-parent").html('');
    $.getJSON("http://localhost:5000/answerbypid/" + p_id,function(msg){
        if (msg.answer != null) {
            for (const cur of msg.answer) {
                $("#card-parent").html((index, cxt) => {
                    return cxt +
                        '<div className="card" style="position: relative;top:50px;left:200px;background-color:aliceblue;height:fit-content;width: 80%;border-radius: 10px">' +
                        '   <div class="card-body" style="background-color: white;height:auto;margin-top:30px;border-radius: 10px">\n' +
                        '                <p class="card-text" style="margin-left:20px; color: darkred;font-size: 25px;" id = "best">' + (cur.best_answer == true ? "Best Answer:" : "") + '</p>\n' +
                        '                <p class="card-text" style="margin-left:20px;font-size: 22px;"  id = "a_body">' + cur.a_content + '</p>\n' +
                        '                <p class="card-text" style="margin-left:20px;font-size: 18px;" id = "a_uname">' + "Author： " + cur.username + '</p>\n' +
                        '                <p class="card-text" style="margin-left:20px;font-size: 18px;color:darkred;font-style:italic" id = "thumbup">' + "Likes： " + cur.thumbup +
                        '                <button class="btn btn-primary" style="margin-left: 20px" onclick="addlike(' + cur.a_id + ')">I like it!</button>' + '</p>\n' +
                        '                <p class="card-title" style="margin-left:20px;padding-bottom: 20px;" id = "a_date">' + "Answer date： " + cur.a_date + '</p>\n' +
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

function resolved()
{
    $.ajax({
            url:'http://localhost:5000/updateStatus/'+getQueryVariable("pid"),
            type:"post",
            datatype:"json",
            async :true,
            success:function(tt){
                if(tt.status==200)
                {
                    console.log(12343124);
                 updatePost();
                }
            }
        }
    )
}

function createanswer()
{
    window.location.href = "http://localhost:5000/createanswer.html?pid=" + getQueryVariable("pid");
}