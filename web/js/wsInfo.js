/**
 * Created by cristph on 2017/3/27.
 */

$(function(){
    var Ajxh=$("#Ajxh").val();
    alert('send'+Ajxh);
    $.post(
        "/getDsrList",
        {
            "Ajxh":Ajxh
        },
        function (data) {
            alert(data);
        }
    );
});