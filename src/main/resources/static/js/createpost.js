$(document).ready(function() {
})

function createpost() {

    var title = $("#title").val();
    var description = $("#description").val();
    var topic = $("#selectTopic").val();
    console.log("title", title);
    console.log("description", description);
    console.log("topic", topic);
    var post = {
        "p_id": 9,
        "u_id": 1,
        "t_id": topic,
        "p_title": title,
        "p_body": description,
        "p_date": "2022-05-07",
        "status": "0",
    }
    $.ajax({
            url:'http://localhost:5000/createpost',
            type:"post",
            datatype:"json",
            data:post,
            async :true,
            success:function(tt){
                if(tt.status==200)
                {
                    alert("Success！");
                    window.location.href = "http://localhost:5000/post.html";
                }

                if(tt.status==500)
                    alert("Insert Fail！");
            }
        }
    )
}