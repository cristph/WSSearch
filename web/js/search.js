/**
 * Created by cristph on 2015/10/27.
 */

document.getElementById('login').addEventListener('mouseover',btnFocus,false);
document.getElementById('register').addEventListener('mouseover',btnFocus,false);

document.getElementById('login').addEventListener('mouseout',btnBlur,false);
document.getElementById('register').addEventListener('mouseout',btnBlur,false);

function btnFocus(){
    var id=this.id;
    if(id=='register'){
        this.style.backgroundColor='#32d1ac';
    }else{
        this.style.backgroundColor='#336699';
    }
}

function btnBlur(){
    this.style.backgroundColor='transparent';
}

function addURLParam(url, name, value){
    url+=( url.indexOf("?") == -1 ? "?" : "&" );
    url+=encodeURIComponent(name) + "=" + encodeURIComponent(value);
    return url;
}

$('#searchBtn').click(function(){
    var input=$('#searchInput').val();
    location.href=addURLParam("/search","AH",input);
});

$(document).keyup(function(event){
    if(event.keyCode==13){
        var input=$('#searchInput').val();
        location.href=addURLParam("/search","AH",input);
    }
});

function showAj(Ajxh){
    open(addURLParam("/wsInfo","Ajxh",Ajxh));
}

function goPage(AH,SortClass,SortType,BeginIndex){
    var current=event.toElement.parentNode;
    $(current.parentNode).find("li").each(function(){
       $(this).removeClass("active");
    });
    $(current).addClass("active");
    $.post(
        "/goPage",
        {
            "AH":encodeURIComponent(AH),
            "SortClass":encodeURIComponent(SortClass),
            "SortType":encodeURIComponent(SortType),
            "BeginIndex":BeginIndex
        },
        function(data){
            $('#AjDiv').html(data);
        }
    );
}

$('#complexSearch').click(function(){
    var qwjsInput=$('#qwjsInput').val();
    var qwjs=$('#qwjs option:selected').val();
    var ay=$('#ay').val();
    var ah=$('#ah').val();
    var ajmc=$('#ajmc').val();
    var fymc=$('#fymc').val();
    var fycj=$('#fycj option:selected').val();
    var ajlx=$('#ajlx option:selected').val();
    var spcx=$('#spcx option:selected').val();
    var wslx=$('#wslx option:selected').val();
    var cprqbegin=$('#cprqbegin').val();
    var cprqend=$('#cprqend').val();
    var cpry=$('#cpry').val();
    var dsr=$('#dsr').val();
    var lvsuo=$('#lvsuo').val();
    var lvshi=$('#lvshi').val();
    var flyj=$('#flyj').val();
    alert("qwjsInput:"+qwjsInput+";qwjs:"+qwjs+";ay:"+ay+";ah:"+ah+";ajmc:"+ajmc+";fymc:"+fymc+";fycj:"+fycj+";ajlx:"+ajlx
        +";spcx:"+spcx+";wslx:"+wslx+";cprqbegin:"+cprqbegin+";cprqend:"+cprqend+";cpry:"+cpry+";dsr:"+dsr+";lvsuo:"+lvsuo
        +";lvshi:"+lvshi+";flyj:"+flyj);
});


function downloadXml(){
    //alert("!");
    var ajs=document.getElementsByClassName("AJ");
    var paths="";
    for(var i=0;i<ajs.length;i++){
        if(ajs[i].firstElementChild.checked){
            var path=$(ajs[i].firstElementChild).val();
            //alert(path);
            paths+=(path+"|");
        }
    }
    //alert(paths);
    console.log("paths"+paths);
    $.post(
        "/download",
        {
            "paths":paths
        },
        function(data){
            console.log(data);
        }
    );
}


function downloadDoc(){
    //alert("!");
    var ajs=document.getElementsByClassName("AJ");
    var paths="";
    for(var i=0;i<ajs.length;i++){
        if(ajs[i].firstElementChild.checked){
            var path=$(ajs[i].lastElementChild).val();
            //alert(path);
            paths+=(path+"|");
        }
    }
    //alert(paths);
    console.log("paths"+paths);
    $.post(
        "/download",
        {
            "paths":paths
        },
        function(data){
            console.log(data);
        }
    );
}

$('#downloadAll').click(function(){
    //alert(document.getElementById("downloadAll").checked);
    var ajs=document.getElementsByClassName("AJ");
    for(var i=0;i<ajs.length;i++){
        if($(ajs[i].firstElementChild).is(':checked')){
            $(ajs[i].firstElementChild).removeAttr("checked");
        }else{
            $(ajs[i].firstElementChild).prop("checked",true);
        }
    }
    //if(document.getElementById("downloadAll").checked==true){
    //    var ajs=document.getElementsByClassName("AJ");
    //    for(var i=0;i<ajs.length;i++){
    //        $(ajs[i].firstElementChild).removeAttr("checked");
    //    }
    //    $('#downloadAll').removeAttr("checked");
    //}else{
    //    var ajs=document.getElementsByClassName("AJ");
    //    for(var i=0;i<ajs.length;i++){
    //        $(ajs[i].firstElementChild).attr("checked",'true');
    //    }
    //    $('#downloadAll').attr("checked",'true');
    //}

});

function removeLabel(){
    $(event.toElement.parentNode).remove();
}