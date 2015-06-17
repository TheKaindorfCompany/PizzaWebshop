$(function () {
    $(".distances li").click(function () {
        $(".distances li").removeClass("active");
        $(this).addClass("active");
        $("#restaurants option").attr('selected', false);
        $('#restaurants option:contains("' + $(this).children('.text').text() + '")').attr('selected', true).change();
        $('#restaurants option:contains("' + $(this).children('.text').text() + '")').change();
    });

    $('#restaurants').change(function () {
        $(".distances li").removeClass("active");
        $(".distances li:contains('" + $('#restaurants option:selected').text() + "')").addClass("active");
        $(".media").css("display", "none");
        $(".media .media-heading:contains('" + $('#restaurants option:selected').text() + "')").parent().parent().css("display", "inline");
        $(".well .restaurant").text($('#restaurants option:selected').text());
    });

});
