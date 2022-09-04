function sortAsc(columNum) {
    var tableRows = $("#tableId tr");
    for ( var i = 0; i < tableRows.length; i++) {
        for ( var j = i + 1; j < tableRows.length; j++) {
            var cell1 = tableRows.eq(i).find("td").eq(columNum);
            var cell2 = tableRows.eq(j).find("td").eq(columNum);
            if (cell1.html() > cell2.html()) {
                var temp = tableRows.eq(i).html();
                tableRows.eq(i).empty().html(tableRows.eq(j).html());
                tableRows.eq(j).empty().html(temp);
            }
        }
    }
    $("#tableId").empty().html(tableRows);
}

function sortDesc(columNum) {
    var tableRows = $("#tableId tr");
    for ( var i = 0; i < tableRows.length; i++) {
        for ( var j = i + 1; j < tableRows.length; j++) {
            var cell1 = tableRows.eq(i).find("td").eq(columNum);
            var cell2 = tableRows.eq(j).find("td").eq(columNum);
            if (cell1.html().localeCompare(cell2.html())<0) {
                var temp = tableRows.eq(i).html();
                tableRows.eq(i).empty().html(tableRows.eq(j).html());
                tableRows.eq(j).empty().html(temp);
            }
        }
    }
    $("#tableId").empty().html(tableRows);

}

(function($){
    $.getUrlParam = function(name)
    {
        var reg = new RegExp("(^|&)" + name +"=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        if (r!=null)
            return unescape(r[2]);

        return null;
    }
})(jQuery);