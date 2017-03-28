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
            //alert(data);
            $('#dsrPanel').html(data);
        }
    );
});

function getQK(Ajxh,Dsrbh){
    //alert("QK");
    $.post(
        "/getQK",
        {
            "Ajxh":Ajxh,
            "Dsrbh":Dsrbh
        },
        function(data){
            //alert(data);
            $('#QKPanel').html(data);
            $('#QKModal').modal();
        }
    );

}

function getQZCS(Ajxh,Dsrbh){
    alert("QZCS");
}