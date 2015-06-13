$(function () {
    $(".distances li").click(function () {
        $(".distances li").removeClass("active");
        $(this).addClass("active");
        console.log($('#restaurants option:contains("' + $(this).text() + '")'));
        $('#restaurants option:contains("' + $(this).children('.text').text() + '")').attr('selected', true);
        $('#restaurants option:contains("' + $(this).children('.text').text() + '")').change();
    });

    $('#restaurants').change(function () {
        $(".distances li").removeClass("active");
        $(".distances li:contains('" + $('#restaurants option:selected').text() + "')").addClass("active");
        console.log($('#restaurants option:selected').text());
    });

});
