/**
 * Created by cristph on 2017/3/27.
 */

$(function(){
    var Ajxh=$("#Ajxh").val();
    //alert('send'+Ajxh);
    var dsrPost=$.post(
        "/getDsrList",
        {
            "Ajxh":Ajxh
        },
        function (data) {
            //alert(data);
            $('#dsrPanel').html(data);
        }
    );

    dsrPost.done(function(){
        //alert("Time");
        $.post(
            "/getSSJL",
            {
                "Ajxh":Ajxh
            },
            function(data){
                $('#ssjlPanel').html(data);
            }
        );

        var cpfxgcPost=$.post(
            "getCPFXGC",
            {
                "Ajxh":Ajxh
            },
            function(data){
                $('#cpfxgcPanel').html(data);
            }
        );

        cpfxgcPost.done(function(){
            $.post(
                "/getXSPJJG",
                {
                    "Ajxh":Ajxh
                },
                function(data){
                    $('#xspjjgPanel').html(data);
                }
            );
        });
    });
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

function getCTR(Ajxh){
    $.post(
        "/getCTR",
        {
            "Ajxh":Ajxh
        },
        function(data){
            $('#CTRPanel').html(data);
            $('#CTRModal').modal();
        }
    );
}

function getZKJL(Ajxh){
    $.post(
        "/getZKJL",
        {
            "Ajxh":Ajxh
        },
        function (data) {
            $('#ZKJLPanel').html(data);
            $('#ZKJLModal').modal();
        }
    );
}

function getFLFT(Ajxh){
    $.post(
        "/getFLFT",
        {
            "Ajxh":Ajxh
        },
        function(data){
            $('#FLFTPanel').html(data);
            $('#FLFTModal').modal();
        }
    );
}

function getLXQJ(Ajxh){
    $.post(
        "/getLXQJ",
        {
            "Ajxh":Ajxh
        },
        function(data){
            $('#LXQJPanel').html(data);
            $('#LXQJModal').modal();
        }
    );
}

function getPF(Ajxh,Fzbh){
    $.post(
        "/getPF",
        {
            "Ajxh":Ajxh,
            "Fzbh":Fzbh
        },
        function(data){
            $('#PFPanel').html(data);
            $('#PFModal').modal();
        }
    );
}