$(function () {
    $('#userinfo').click(function () {
        $('#userhouse').removeClass('user_menu_a');
        $(this).addClass('user_menu_a');
        $('#userinfo_body').show();
        $('#userhouse_body').hide();
        $('#userinfo_content').show();
        $('#house_record_content').hide();
    })
    $('#userhouse').click(function () {
        $('#userinfo').removeClass('user_menu_a');
        $(this).addClass('user_menu_a');
        $('#userinfo_body').hide();
        $('#userhouse_body').show();
        $('#userhouse_content').show();
        $('#house_content').hide();
    })

    $('#change_password').click(function () {
        $('#password_tr').toggle();
    })

    $('#house_record').click(function () {
        $('#userinfo_content').hide();
        $('#house_record_content').show();
    })

    $('#user_info').click(function () {
        $('#userinfo_content').show();
        $('#house_record_content').hide();
    })

    $('#landlord_info').click(function () {
        $('#userhouse_content').show();
        $('#house_content').hide();
    })

    $('#house_info').click(function () {
        $('#userhouse_content').hide();
        $('#house_content').show();
    })

})