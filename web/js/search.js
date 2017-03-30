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
    location.href=addURLParam("/searchByAh","Ah",input);
});

function showAj(Ajxh){
    location.href=addURLParam("/wsInfo","Ajxh",Ajxh);
}

function goPage(AH,SortClass,SortType,BeginIndex){
    //alert(AH+SortClass+SortType+BeginIndex);
    $.post(
        "/goPage",
        {
            "AH":AH,
            "SortClass":SortClass,
            "SortType":SortType,
            "BeginIndex":BeginIndex
        },
        function(data){
            $('#AjDiv').html(data);
        }
    );
    //$(this).closest('.d').addClass("active");
}