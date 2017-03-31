/**
 * Created by cristph on 2017/3/27.
 */

function addURLParam(url, name, value){
    url+=( url.indexOf("?") == -1 ? "?" : "&" );
    url+=encodeURIComponent(name) + "=" + encodeURIComponent(value);
    return url;
}

$('#searchBtn').click(function(){
    var AH=$('#searchInput').val();
    var url=addURLParam("/search","AH",AH);
    location.href=url;
});