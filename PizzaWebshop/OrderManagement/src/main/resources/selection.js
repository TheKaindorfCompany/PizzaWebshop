$(function () {
    $(".distances li").click(function () {
        $(".distances li").removeClass("active");
        $(this).addClass("active");
        $('#restaurants option:contains("' + $(this).children('.text').text() + '")').attr('selected', true);
        $('#restaurants option:contains("' + $(this).children('.text').text() + '")').change();
    });

    $('#restaurants').change(function () {
        $(".distances li").removeClass("active");
        $(".distances li:contains('" + $('#restaurants option:selected').text() + "')").addClass("active");
        $(".media").css("display", "none");
        console.log($(".media .media-heading:contains('" + $('#restaurants option:selected').text() + "')").parent(".media"));
        $(".media .media-heading:contains('" + $('#restaurants option:selected').text() + "')").parent().parent().css("display", "inline");
    });

});
