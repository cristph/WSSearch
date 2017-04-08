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

function goPage(SortClass,SortType,BeginIndex){
    var current=event.toElement.parentNode;
    $(current.parentNode).find("li").each(function(){
       $(this).removeClass("active");
    });
    $(current).addClass("active");
    $.post(
        "/goPage",
        {
            "ay":encodeURIComponent($('#cond_ay').val()),
            "ah":encodeURIComponent($('#cond_ah').val()),
            "ajmc":encodeURIComponent($('#cond_ajmc').val()),
            "fymc":encodeURIComponent($('#cond_fymc').val()),
            "fycj":encodeURIComponent($('#cond_fycj').val()),
            "ajlx":encodeURIComponent($('#cond_ajlx').val()),
            "spcx":encodeURIComponent($('#cond_spcx').val()),
            "wslx":encodeURIComponent($('#cond_wslx').val()),
            "cprqbegin":encodeURIComponent($('#cond_cprqbegin').val()),
            "cprqend":encodeURIComponent($('#cond_cprqend').val()),
            "cpry":encodeURIComponent($('#cond_cpry').val()),
            "dsr":encodeURIComponent($('#cond_dsr').val()),
            "lvsuo":encodeURIComponent($('#cond_lvsuo').val()),
            "lvshi":encodeURIComponent($('#cond_lvshi').val()),
            "flyj":encodeURIComponent($('#cond_flyj').val()),
            "cpnf":encodeURIComponent($('#cond_cpnf').val()),
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
    console.log("qwjsInput:"+qwjsInput+";qwjs:"+qwjs+";ay:"+ay+";ah:"+ah+";ajmc:"+ajmc+";fymc:"+fymc+";fycj:"+fycj+";ajlx:"+ajlx
        +";spcx:"+spcx+";wslx:"+wslx+";cprqbegin:"+cprqbegin+";cprqend:"+cprqend+";cpry:"+cpry+";dsr:"+dsr+";lvsuo:"+lvsuo
        +";lvshi:"+lvshi+";flyj:"+flyj);

    var url="/complexSearch";
    url=addURLParam(url,"ay",ay);
    url=addURLParam(url,"ah",ah);
    url=addURLParam(url,"ajmc",ajmc);
    url=addURLParam(url,"fymc",fymc);
    url=addURLParam(url,"fycj",fycj);
    url=addURLParam(url,"ajlx",ajlx);
    url=addURLParam(url,"spcx",spcx);
    url=addURLParam(url,"wslx",wslx);
    url=addURLParam(url,"cprqbegin",cprqbegin);
    url=addURLParam(url,"cprqend",cprqend);
    url=addURLParam(url,"cpry",cpry);
    url=addURLParam(url,"dsr",dsr);
    url=addURLParam(url,"lvsuo",lvsuo);
    url=addURLParam(url,"lvshi",lvshi);
    url=addURLParam(url,"flyj",flyj);
    url=addURLParam(url,"cpnf",cpnf);

    location.href=url;
});


function downloadXml(){
    var ajs=document.getElementsByClassName("AJ");
    var paths="";
    for(var i=0;i<ajs.length;i++){
        if(ajs[i].firstElementChild.checked){
            var path=$(ajs[i].firstElementChild).val();
            if($.trim(path).length>0){
                console.log("add:"+path);
                paths+=($.trim(path)+"|");
            }
        }
    }
    console.log("xmlpaths:"+paths);
    if(paths.length>0){
        location.href=(addURLParam("/downloadZip","paths",paths));
    }else{
        alert("PLEASE Select The Files to DOWNLAOD!");
    }
}


function downloadDoc(){
    var ajs=document.getElementsByClassName("AJ");
    var paths="";
    for(var i=0;i<ajs.length;i++){
        if(ajs[i].firstElementChild.checked){
            var path=$(ajs[i].lastElementChild).val();
            if($.trim(path).length>0){
                console.log("add:"+path);
                paths+=($.trim(path)+"|");
            }
        }
    }
    console.log("docpaths:"+paths);
    if(paths.length>0){
        location.href=(addURLParam("/downloadZip","paths",paths));
    }else{
        alert("PLEASE Select The Files to DOWNLAOD!");
    }

}

function downloadSingleXML(fileName){
    var path=$('#xml'+fileName).val();
    var url=addURLParam("/singleDownload","path",path);
    url=addURLParam(url,"fileName",fileName+".xml");
    console.log("download url:"+url);
    location.href=url;
}


function downloadSingleDOC(fileName){
    var path=$('#doc'+fileName).val();
    var url=addURLParam("/singleDownload","path",path);
    url=addURLParam(url,"fileName",fileName+".doc");
    console.log("download url:"+url);
    location.href=url;
}

$('#downloadAll').click(function(){
    var ajs=document.getElementsByClassName("AJ");
    for(var i=0;i<ajs.length;i++){
        if($(ajs[i].firstElementChild).is(':checked')){
            $(ajs[i].firstElementChild).removeAttr("checked");
        }else{
            $(ajs[i].firstElementChild).prop("checked",true);
        }
    }
});

function removeLabel(key){
    //console.log("text:"+event.toElement.parentNode.textContent);
    //console.log(event.toElement.parentNode.textContent.split(':'));
    //var value=event.toElement.parentNode.textContent.split(':')[1];
    //console.log("value:"+value);
    //var str="哈哈哈:加快";
    //console.log(str.split(':'));
    $('#cond_'+key).val('');
    //alert("new:"+$('#cond_'+key).val());
    $(event.toElement.parentNode).remove();

    $.post(
        "/goPage",
        {
            "ay":encodeURIComponent($('#cond_ay').val()),
            "ah":encodeURIComponent($('#cond_ah').val()),
            "ajmc":encodeURIComponent($('#cond_ajmc').val()),
            "fymc":encodeURIComponent($('#cond_fymc').val()),
            "fycj":encodeURIComponent($('#cond_fycj').val()),
            "ajlx":encodeURIComponent($('#cond_ajlx').val()),
            "spcx":encodeURIComponent($('#cond_spcx').val()),
            "wslx":encodeURIComponent($('#cond_wslx').val()),
            "cprqbegin":encodeURIComponent($('#cond_cprqbegin').val()),
            "cprqend":encodeURIComponent($('#cond_cprqend').val()),
            "cpry":encodeURIComponent($('#cond_cpry').val()),
            "dsr":encodeURIComponent($('#cond_dsr').val()),
            "lvsuo":encodeURIComponent($('#cond_lvsuo').val()),
            "lvshi":encodeURIComponent($('#cond_lvshi').val()),
            "flyj":encodeURIComponent($('#cond_flyj').val()),
            "cpnf":encodeURIComponent($('#cond_cpnf').val()),
            "SortClass":encodeURIComponent($('#SortClass').val()),
            "SortType":encodeURIComponent($('#SortType').val()),
            "BeginIndex":0
        },
        function(data){
            $('#AjDiv').html(data);
        }
    );
}