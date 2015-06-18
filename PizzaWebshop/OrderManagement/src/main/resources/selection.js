$(function () {
    $(".distances li").click(function () {
        $(".distances li").removeClass("active");
        $(this).addClass("active");
        $("#restaurants option").attr('selected', false);
        $('#restaurants option:contains("' + $(this).children('.text').text().trim() + '")').prop('selected', true);
        $('#restaurants option:contains("' + $(this).children('.text').text().trim() + '")').change();
    });

    $('#restaurants').change(function () {
        $(".distances li").removeClass("active");
        $(".distances li:contains('" + $('#restaurants option:selected').text() + "')").addClass("active");
        $(".media").css("display", "none");
        $(".media .media-heading:contains('" + $('#restaurants option:selected').text() + "')").parent().parent().css("display", "inline");
        $(".well .restaurant").text($('#restaurants option:selected').text());
        $(".row.product").css("display", "none");
        $(".row.product." + $('#restaurants option:selected').text().trim().replace(/\ /g, "")).css("display", "inline");
        $(".table.cart tr").each(function(){
            if($(this).hasClass("head") || $(this).hasClass("total")) {

            } else {
                $(this).remove();
            }
        });
        $(".table .total .price").text("-");
    });

    $(".buy-product").click(function() {
        var price = $(this).parent().children(".price").text().replace(" $", "");
        var name = $(this).parent().parent().children(".name").text();
        var exists = false;
        $(".table.cart tr.product .name").each(function() {
            if($(this).text() === name) {
                exists = true;
                $(this).parent().children('.count').text(parseInt($(this).parent().children('.count').text()) + 1);
            }
        });
        if(exists == false) {
            $("<tr class='product'><td class='number'>" + ($(".table.cart tr.product").size() + 1) + "</td><td class='name'>" + name + "</td> <td class='count'>1</td> <td class='price'>" + price + "</td></tr>").insertBefore(".table.cart tr.total");
        }
            var total = 0.;
        $(".table.cart tr.product .price").each(function() {
            total += parseFloat($(this).text()) * parseFloat($(this).parent().children(".count").text());
            total = Math.round(total*100)/100;
        })
        $(".table.cart tr.total .price").text(total);
    });

    /*
     <tr>
     <td>1</td>
     <td>Product 1</td>
     <td>2</td>
     <td>24,-</td>
     </tr>
     */

});
