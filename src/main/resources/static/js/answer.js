$(document).ready(function() {
    var userid;
    $.getJSON("http://localhost:5000/getuserinfo",function(msg){

        if(msg.status == 404)
            alert("Please login!");
        else
        {
            userid = msg.user.u_id;
            $.getJSON("http://localhost:5000/getuseranswer",function(msg){
                if (msg.postList != null) {
                    for (const cur of msg.postList) {
                        $("#list-parent").html((index, cxt) => {
                            return cxt + '<li class="list-group-item" style="display: flex; justify-content: space-between">\n' + cur.a_content + ' ' + cur.p_id;
                        });
                    }
                }
            });
        }
    });

})