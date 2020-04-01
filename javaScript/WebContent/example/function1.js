//변수값이 null, 0 -> 거짓(false)
//변수값이 있거나, "값" -> 참(true)
        var num = 1;
        function gallary(direct){
            if(direct){//증가 -> 1 다음
                if(num==4){
                    num = 0
                }                  
                num++;
            }else{//감소 -> 0 이전
                if(num==1){
                    num = 5
                }
                num--;
            }
            var photo = document.getElementById('photo');
            photo.setAttribute("src", "../images/images" +num+ ".jpg")
        }