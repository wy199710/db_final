function edit() {
       var email = $("#email").val();
       var city = $("#city").val();
       var state = $("#state").val();
       var country =  $("#country").val();
       var profile =  $("#profile").val();
       var post = {
           "email": email ,
           "city": city,
           "state": state,
           "country": country,
           "profile": profile,
       }
       $.ajax({
               url:'http://localhost:5000/updateProfile',
               type:"post",
               datatype:"json",
               data:post,
               async :true,
               success:function(tt){
                   if(tt.status==200)
                   {
                       alert("Success！");
                       window.location.href = "http://localhost:5000/profile.html";
                   }

                   if(tt.status==500)
                       alert("Insert Fail！");
               }
           }
       )
}