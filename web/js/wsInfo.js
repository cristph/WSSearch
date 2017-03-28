/**
 * Created by cristph on 2017/3/27.
 */

$(function(){
    var Ajxh=$("#Ajxh").val();
    //alert('send'+Ajxh);
    $.post(
        "/getDsrList",
        {
            "Ajxh":Ajxh
        },
        function (data) {
            //alert(data);
            $('#dsrPanel').html(data);
        }
    );
});

function getQK(Ajxh,Dsrbh){
    $.post(
        "/getQK",
        {
            "Ajxh":Ajxh,
            "Dsrbh":Dsrbh
        },
        function(data){
            $('#QKPanel').html(data);
            $('#QKModal').modal();
        }
    );

}

function getQZCS(Ajxh,Dsrbh){
    $.post(
        "/getQZCS",
        {
            "Ajxh":Ajxh,
            "Dsrbh":Dsrbh
        },
        function(data){
            $('#QZCSPanel').html(data);
            $('#QZCSModal').modal();
        }
    );
}