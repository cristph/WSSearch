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

function showAj(Wsah){
    open(addURLParam("/wsInfo","Wsah",Wsah));
}

function showPage(sorts,orders,BeginIndex){
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
            "SortClass[]":sorts,
            "SortType[]":orders,
            "BeginIndex":BeginIndex
        },
        function(data){
            $('#AjDiv').html(data);
        }
    );
}

function goPage(BeginIndex){
    var current=event.toElement.parentNode;
    $(current.parentNode).find("li").each(function(){
       $(this).removeClass("active");
    });
    $(current).addClass("active");
    var sorts=[];
    var orders=[];
    sorts.push('fycj');
    orders.push($('#fycjOrder').val());
    sorts.push('cprq');
    orders.push($('#cprqOrder').val());
    sorts.push('spcx');
    orders.push($('#spcxOrder').val());
    showPage(sorts,orders,BeginIndex);
    $('#currentPageIndex').val(BeginIndex);
}

function goPrevious(){
    var maxPageNum=$('#maxPageNum').val();
    var currentPageIndex=$('#currentPageIndex').val();
    if(currentPageIndex==1){
        return;
    }else{
        var firstPageIndex=$('#firstPageIndex').val();
        if(currentPageIndex==firstPageIndex){
            var str="";
            var previous=parseInt(currentPageIndex)-1;
            str+="<li><a href=\"javascript:void(0)\" aria-label=\"Previous\" onclick=\"goPrevious()\"><span aria-hidden=\"true\">&laquo;</span></a></li>";
            if(previous-4>=1){
                for(var i=previous-4;i<=previous;i++){
                    str+="<li id=\"page"+i+"\" class=\"\"><a href=\"javascript:void(0)\" onclick=\"goPage('"+i+"')\">"+i+"</a></li>";
                }
            }else{
                for(var i=1;i<=previous;i++){
                    str+="<li id=\"page"+i+"\" class=\"\"><a href=\"javascript:void(0)\" onclick=\"goPage('"+i+"')\">"+i+"</a></li>";
                }
            }
            str+="<li><a href=\"javascript:void(0)\" aria-label=\"Next\" onclick=\"goNext()\"><span aria-hidden=\"true\">&raquo;</span></a></li>";
            $('#PP').html(str);
            $('#page'+previous).addClass('active');
            $('#endPageIndex').val(previous);
            if(previous-4>=1){
                $('#firstPageIndex').val(previous-4);
            }else{
                $('#firstPageIndexPageIndex').val(1);
            }
            $('#currentPageIndex').val(previous);
            goPage(previous);
        }else{
            $('#page'+currentPageIndex).removeClass('active');
            var previous=parseInt(currentPageIndex)-1;
            $('#page'+previous).addClass('active');
            $('#currentPageIndex').val(previous);
            goPage(previous);
        }
    }


}

function goNext(){
    var maxPageNum=$('#maxPageNum').val();
    var currentPageIndex=$('#currentPageIndex').val();
    if(currentPageIndex==maxPageNum){
        return;
    }else{
        var endPageIndex=$('#endPageIndex').val();
        if(currentPageIndex==endPageIndex){
            var str="";
            var next=parseInt(currentPageIndex)+1;
            str+="<li><a href=\"javascript:void(0)\" aria-label=\"Previous\" onclick=\"goPrevious()\"><span aria-hidden=\"true\">&laquo;</span></a></li>";
            if(next+4<=maxPageNum){
                for(var i=next;i<next+5;i++){
                    str+="<li id=\"page"+i+"\" class=\"\"><a href=\"javascript:void(0)\" onclick=\"goPage('"+i+"')\">"+i+"</a></li>";
                }
            }else{
                for(var i=next;i<=maxPageNum;i++){
                    str+="<li id=\"page"+i+"\" class=\"\"><a href=\"javascript:void(0)\" onclick=\"goPage('"+i+"')\">"+i+"</a></li>";
                }
            }
            str+="<li><a href=\"javascript:void(0)\" aria-label=\"Next\" onclick=\"goNext()\"><span aria-hidden=\"true\">&raquo;</span></a></li>";
            $('#PP').html(str);
            $('#page'+next).addClass('active');
            $('#firstPageIndex').val(next);
            if(next+4<=maxPageNum){
                $('#endPageIndex').val(next+4);
            }else{
                $('#endPageIndex').val(maxPageNum);
            }
            $('#currentPageIndex').val(next);
            goPage(next);
        }else{
            $('#page'+currentPageIndex).removeClass('active');
            var next=parseInt(currentPageIndex)+1;
            $('#page'+next).addClass('active');
            $('#currentPageIndex').val(next);
            goPage(next);
        }
    }
}

$('#complexSearch').click(function(){
    var qwjsInput=$('#qwjsInput').val();
    var qwjs=$('#qwjs option:selected').val();
    var ay=$('#ay').val();
    var ah=$('#ah').val();
    var ajmc=$('#ajmc').val();
    var fymc=$('#fymc').val();
    var fycj=$('#fycj option:selected').val()=='all' ? '' : $('#fycj option:selected').val();
    var ajlx=$('#ajlx option:selected').val()=='all' ? '': $('#ajlx option:selected').val();
    var spcx=$('#spcx option:selected').val()=='all' ? '': $('#spcx option:selected').val();
    var wslx=$('#wslx option:selected').val()=='all' ? '': $('#wslx option:selected').val();
    var cprqbegin=$('#cprqbegin').val();
    var cprqend=$('#cprqend').val();
    var cpry=$('#cpry').val();
    var dsr=$('#dsr').val();
    var lvsuo=$('#lvsuo').val();
    var lvshi=$('#lvshi').val();
    var flyj=$('#flyj').val();
    var cpnf=$('#cpnf').val();

    console.log("qwjsInput:"+qwjsInput+";qwjs:"+qwjs+";ay:"+ay+";ah:"+ah+";ajmc:"+ajmc+";fymc:"+fymc+";fycj:"+fycj+";ajlx:"+ajlx
        +";spcx:"+spcx+";wslx:"+wslx+";cprqbegin:"+cprqbegin+";cprqend:"+cprqend+";cpry:"+cpry+";dsr:"+dsr+";lvsuo:"+lvsuo
        +";lvshi:"+lvshi+";flyj:"+flyj+";cpnf:"+cpnf);

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
    var path=document.getElementById("xml"+fileName).value;
    var url=addURLParam("/singleDownload","path",path);
    url=addURLParam(url,"fileName",fileName);
    console.log("download url:"+url);
    location.href=url;
}


function downloadSingleDOC(fileName){
    var path=document.getElementById("doc"+fileName).value;
    var url=addURLParam("/singleDownload","path",path);
    url=addURLParam(url,"fileName",fileName);
    console.log("download url:"+url);
    location.href=url;
}

function downloadAll(type){
    var url="/downloadAll";
    url=addURLParam(url,"ay",$('#cond_ay').val());
    url=addURLParam(url,"ah",$('#cond_ah').val());
    url=addURLParam(url,"ajmc",$('#cond_ajmc').val());
    url=addURLParam(url,"fymc",$('#cond_fymc').val());
    url=addURLParam(url,"fycj",$('#cond_fycj').val());
    url=addURLParam(url,"ajlx",$('#cond_ajlx').val());
    url=addURLParam(url,"spcx",$('#cond_spcx').val());
    url=addURLParam(url,"wslx",$('#cond_wslx').val());
    url=addURLParam(url,"cprqbegin",$('#cond_cprqbegin').val());
    url=addURLParam(url,"cprqend",$('#cond_cprqend').val());
    url=addURLParam(url,"cpry",$('#cond_cpry').val());
    url=addURLParam(url,"dsr",$('#cond_dsr').val());
    url=addURLParam(url,"lvsuo",$('#cond_lvsuo').val());
    url=addURLParam(url,"lvshi",$('#cond_lvshi').val());
    url=addURLParam(url,"flyj",$('#cond_flyj').val());
    url=addURLParam(url,"cpnf",$('#cond_cpnf').val());
    url=addURLParam(url,"type",type);
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
    $('#cond_'+key).val('');
    $(event.toElement.parentNode).remove();

    var url="/complexSearch";
    url=addURLParam(url,"ay",$('#cond_ay').val());
    url=addURLParam(url,"ah",$('#cond_ah').val());
    url=addURLParam(url,"ajmc",$('#cond_ajmc').val());
    url=addURLParam(url,"fymc",$('#cond_fymc').val());
    url=addURLParam(url,"fycj",$('#cond_fycj').val());
    url=addURLParam(url,"ajlx",$('#cond_ajlx').val());
    url=addURLParam(url,"spcx",$('#cond_spcx').val());
    url=addURLParam(url,"wslx",$('#cond_wslx').val());
    url=addURLParam(url,"cprqbegin",$('#cond_cprqbegin').val());
    url=addURLParam(url,"cprqend",$('#cond_cprqend').val());
    url=addURLParam(url,"cpry",$('#cond_cpry').val());
    url=addURLParam(url,"dsr",$('#cond_dsr').val());
    url=addURLParam(url,"lvsuo",$('#cond_lvsuo').val());
    url=addURLParam(url,"lvshi",$('#cond_lvshi').val());
    url=addURLParam(url,"flyj",$('#cond_flyj').val());
    url=addURLParam(url,"cpnf",$('#cond_cpnf').val());

    location.href=url;

    //var sorts=[];
    //var orders=[];
    //sorts.push('fycj');
    //orders.push($('#fycjOrder').val());
    //sorts.push('cprq');
    //orders.push($('#cprqOrder').val());
    //sorts.push('spcx');
    //orders.push($('#spcxOrder').val());
    //showPage(sorts,orders,$('#currentPageIndex').val());
    //resetNum();
    //
    //var createViewPost=$.post(
    //    "/createView",
    //    {
    //        "ay":encodeURIComponent($('#cond_ay').val()),
    //        "ah":encodeURIComponent($('#cond_ah').val()),
    //        "ajmc":encodeURIComponent($('#cond_ajmc').val()),
    //        "fymc":encodeURIComponent($('#cond_fymc').val()),
    //        "fycj":encodeURIComponent($('#cond_fycj').val()),
    //        "ajlx":encodeURIComponent($('#cond_ajlx').val()),
    //        "spcx":encodeURIComponent($('#cond_spcx').val()),
    //        "wslx":encodeURIComponent($('#cond_wslx').val()),
    //        "cprqbegin":encodeURIComponent($('#cond_cprqbegin').val()),
    //        "cprqend":encodeURIComponent($('#cond_cprqend').val()),
    //        "cpry":encodeURIComponent($('#cond_cpry').val()),
    //        "dsr":encodeURIComponent($('#cond_dsr').val()),
    //        "lvsuo":encodeURIComponent($('#cond_lvsuo').val()),
    //        "lvshi":encodeURIComponent($('#cond_lvshi').val()),
    //        "flyj":encodeURIComponent($('#cond_flyj').val()),
    //        "cpnf":encodeURIComponent($('#cond_cpnf').val())
    //    },
    //    function(data){
    //        $('#viewName').val(data);
    //    }
    //);
    //
    //createViewPost.done(function(){
    //    var p1=new Promise(function (resolve){
    //        $.post(
    //            "/groupStatistics",
    //            {
    //                "groupName": "AYCJ",
    //                "viewName": $('#viewName').val()
    //            },
    //            function(map){
    //                var i=1;
    //                for(var key in map){
    //                    var value=map[key];
    //                    var entry={id:2*10+i, pId:2, name:"案由层级"+key+"("+value+")"};
    //                    nodes.push(entry);
    //                    i++;
    //                }
    //                resolve('p1 done');
    //            }
    //        );
    //    });
    //
    //    var p2=new Promise(function (resolve){
    //        $.post(
    //            "/groupStatistics",
    //            {
    //                "groupName": "FYCJ",
    //                "viewName": $('#viewName').val()
    //            },
    //            function(map){
    //                var i=1;
    //                var fycjArray=["全部","最高法院","高级法院","中级法院","低级法院","基层法院"];
    //                for(var key in map){
    //                    var value=map[key];
    //                    var entry={id:3*10+i, pId:3, name:fycjArray[key]+"("+value+")"};
    //                    nodes.push(entry);
    //                    i++;
    //                }
    //                resolve("p2 done");
    //            }
    //        );
    //    });
    //
    //    var p3=new Promise(function (resolve){
    //        $.post(
    //            "/groupStatistics",
    //            {
    //                "groupName": "CPNF",
    //                "viewName": $('#viewName').val()
    //            },
    //            function(map){
    //                var i=1;
    //                for(var key in map){
    //                    var value=map[key];
    //                    var entry={id:4*10+i, pId:4, name:key+"年("+value+")"};
    //                    nodes.push(entry);
    //                    i++;
    //                }
    //                resolve('p3 done');
    //            }
    //        );
    //    });
    //
    //    var p4=new Promise(function (resolve){
    //        $.post(
    //            "/groupStatistics",
    //            {
    //                "groupName": "SPCX",
    //                "viewName": $('#viewName').val()
    //            },
    //            function(map){
    //                var i=1;
    //                for(var key in map){
    //                    var value=map[key];
    //                    var entry={id:5*10+i, pId:5, name:key+"("+value+")"};
    //                    nodes.push(entry);
    //                    i++;
    //                }
    //                resolve('p4 done');
    //            }
    //        );
    //    });
    //
    //    var p5=new Promise(function (resolve){
    //        $.post(
    //            "/groupStatistics",
    //            {
    //                "groupName": "WSLX",
    //                "viewName": $('#viewName').val()
    //            },
    //            function(map){
    //                var i=1;
    //                for(var key in map){
    //                    var value=map[key];
    //                    var entry={id:6*10+i, pId:6, name:key+"("+value+")"};
    //                    nodes.push(entry);
    //                    i++;
    //                }
    //                resolve('p5 done');
    //            }
    //        );
    //    });
    //
    //    Promise.all([p1,p2,p3,p4,p5]).then(function(result){
    //        console.log(result);
    //        $.fn.zTree.init($("#treeDemo"), setting, nodes);
    //    });
    //});
}

function resetNum(){
    $.post(
        "/getNum",
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
            "cpnf":encodeURIComponent($('#cond_cpnf').val())
        },
        function(data){
            var nums=data.split(';');
            $('#AJC').html(nums[0]);
            $('#PN').html(nums[1]);
        }
    );
}

function changeSortOrder(sortClass){
    var current=$('#'+sortClass+'Arrow');
    if(current.hasClass('glyphicon-arrow-up')){
        current.removeClass('glyphicon-arrow-up');
        current.addClass('glyphicon-arrow-down');
        $('#'+sortClass+'Order').val('desc');
    }else{
        current.removeClass('glyphicon-arrow-down');
        current.addClass('glyphicon-arrow-up');
        $('#'+sortClass+'Order').val('asc');
    }
    //alert("post");
    var sorts=[];
    var orders=[];
    sorts.push('fycj');
    orders.push($('#fycjOrder').val());
    sorts.push('cprq');
    orders.push($('#cprqOrder').val());
    sorts.push('spcx');
    orders.push($('#spcxOrder').val());
    showPage(sorts,orders,1);
}