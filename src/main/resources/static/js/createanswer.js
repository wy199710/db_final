$(document).ready(function() {
})

function createanswer() {
    var p_id = getQueryVariable("pid");
    var a_content = $("#answerbody").val();
    var data = {
        "p_id": p_id,
        "a_content": a_content,
    }
    $.ajax({
            url:'http://localhost:5000/createanswer',
            type:"post",
            datatype:"json",
            data:data,
            async :true,
            success:function(tt){
                if(tt.status==200)
                {
                    alert("Success！");
                    window.location.href = "http://localhost:5000/postdetail.html?pid=" + p_id;
                }

                if(tt.status==500)
                    alert("Insert Fail！");
            }
        }
    )
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