
function loadImg(id,type){
        $.ajax({
            type:'get',
            url:'data/'+type+'.json',
            success:function(data){
                var list =data.list;
                var text='';
                for(i in list){
                    text+='<div class="col-md-4 md-margin-bottom-40"style="height:288px">'
                            +'<a href='+list[i].origin+'>'
                                +'<img class="img-responsive" src='+list[i].thumb+' alt='+list[i].name+'>'
                            +'</a>'
                            +'<center><h3>'+list[i].name+'</h3></center>'

                        +'</div>';
                }
                document.getElementById(id).innerHTML=text;
            }
        })
    }