$(function() {
    $("#area").click(function() {
        $('#area svg:first').hide();
        $('#area svg:last').show();
        $('#subway svg:first').show();
        $('#subway svg:last').hide();
        $('#div_subway').stop();
        $('#div_subway').slideUp(500, function() {
            $('#div_area').stop();
            $('#div_area').slideDown(500);
        });
    })

    $("#subway").click(function() {
        $('#subway svg:first').hide();
        $('#subway svg:last').show();
        $('#area svg:first').show();
        $('#area svg:last').hide();
        $('#div_area').stop();
        $('#div_area').slideUp(500, function() {
            $('#div_subway').stop();
            $('#div_subway').slideDown(500);
        });

    })

    $('#unfold').click(function() {
        $('#div_unfold').slideDown(500, function() {
            $('#button_packUp').show();
            $('#button_unfold').hide();
        });
    })

    $('#packUp').click(function() {
        $('#div_unfold').slideUp(500, function() {
            $('#button_packUp').hide();
            $('#button_unfold').show();
        });
    })

    $('#sort_default').click(function() {
        $('#sort_price svg').hide();
        $('#sort_area svg').hide();
    })

    $('#sort_price').click(function() {
        $('#sort_area svg').hide();
        if ($('#sort_price svg:first').css('display') == 'none' && $('#sort_price svg:last').css('display') == 'none') {
            $('#sort_price svg:first').show();
        } else {
            $('#sort_price svg').toggle();
        }
    })

    $('#sort_area').click(function() {
        $('#sort_price svg').hide();
        if ($('#sort_area svg:first').css('display') == 'none' && $('#sort_area svg:last').css('display') == 'none') {
            $('#sort_area svg:first').show();
        } else {
            $('#sort_area svg').toggle();
        }
    })
})