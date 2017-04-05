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

    var Ajxz=$('#Ajxz').val();
    var Spcx=$('#Spcx').val();
    //alert(Ajxh+";"+Ajxz+";"+Spcx);
    var jbqkPost=$.post(
        "/getJBQK",
        {
            "Ajxh":Ajxh,
            "Ajxz":encodeURIComponent(Ajxz),
            "Spcx":encodeURIComponent(Spcx)
        },
        function(data){
            $('#jbqkPanel').html(data);
        }
    );

    jbqkPost.done(function(){
        $('#BGRBCPanel').on('show.bs.collapse',function(){
            $('#BGRBCPanel').html("load...");
            $.post(
                "/getQKD",
                {
                    "Class":"WsAjjbqkBgrbc",
                    "Ajxh":Ajxh
                },
                function(data){
                    $('#BGRBCPanel').html(data);
                }
            );
        });

        $('#BGRBHPanel').on('show.bs.collapse',function(){
            $('#BGRBHPanel').html("load...");
            $.post(
                "/getQKD",
                {
                    "Class":"WsAjjbqkBhrbh",
                    "Ajxh":Ajxh
                },
                function(data){
                    $('#BGRBHPanel').html(data);
                }
            );
        });

        $('#BSSLDPanel').on('show.bs.collapse',function(){
            $('#BSSLDPanel').html("load...");
            $.post(
                "/getQKD",
                {
                    "Class":"WsAjjbqkBssld",
                    "Ajxh":Ajxh
                },
                function(data){
                    $('#BSSLDPanel').html(data);
                }
            );
        });

        $('#BSSRBCDPanel').on('show.bs.collapse',function(){
            $('#BSSRBCDPanel').html("load...");
            $.post(
                "/getQKD",
                {
                    "Class":"WsAjjbqkBssrbcd",
                    "Ajxh":Ajxh
                },
                function(data){
                    $('#BSSRBCDPanel').html(data);
                }
            );
        });

        $('#BSZJDPanel').on('show.bs.collapse',function(){
            $('#BSZJDPanel').html("load...");
            $.post(
                "/getQKD",
                {
                    "Class":"WsAjjbqkBszjd",
                    "Ajxh":Ajxh
                },
                function(data){
                    $('#BSZJDPanel').html(data);
                }
            );
        });

        $('#CMSSDPanel').on('show.bs.collapse',function(){
            $('#CMSSDPanel').html("load...");
            $.post(
                "/getQKD",
                {
                    "Class":"WsAjjbqkCmssd",
                    "Ajxh":Ajxh
                },
                function(data){
                    $('#CMSSDPanel').html(data);
                }
            );
        });

        $('#QSSLDPanel').on('show.bs.collapse',function(){
            $('#QSSLDPanel').html("load...");
            $.post(
                "/getQKD",
                {
                    "Class":"WsAjjbqkQssld",
                    "Ajxh":Ajxh
                },
                function(data){
                    $('#QSSLDPanel').html(data);
                }
            );
        });

        $('#QSZJDPanel').on('show.bs.collapse',function(){
            $('#QSZJDPanel').html("load...");
            $.post(
                "/getQKD",
                {
                    "Class":"WsAjjbqkQszjd",
                    "Ajxh":Ajxh
                },
                function(data){
                    $('#QSZJDPanel').html(data);
                }
            );
        });

        $('#ZJDPanel').on('show.bs.collapse',function(){
            $('#ZJDPanel').html("load...");
            $.post(
                "/getQKD",
                {
                    "Class":"WsAjjbqkZjd",
                    "Ajxh":Ajxh
                },
                function(data){
                    $('#ZJDPanel').html(data);
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

