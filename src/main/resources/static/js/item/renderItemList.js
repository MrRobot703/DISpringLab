var base_url = 'http://localhost:8080/';
var mainDiv;



function renderItemList() {
    mainDiv.innerHTML = "";
    $.ajax({
        type: 'GET',
        url: base_url + "/getAllItems",
        datatype: "application/json",
        async: false,
        success: function (data) {
//            var img = document.createElement('img');
//            img.src='/resources/img/simple/logo.png';
            var table = document.createElement('table');
            table.className = "table table-bordered";
//            table.innerHTML +="<tr style='background-color:#28a745'><td colspan='3'>"+"<strong>Name</strong>"+"</td><td>"+"</td><td>"+"<strong>Price,rub</strong>";


            var tr;
            var td;
            for(var i=0;i<data.length;++i){
            tr = table.insertRow();
            tr.style.border = '1px black';
            tr.style.backgroundColor="darkseagreen";
            tr.setAttribute('rowSpan', '2');
            for(var j=0;j<3;++j){
                td = tr.insertCell();
                td.style.width  = '400px';
//                td.innerHTML="<img src='/resources/img/sale.png' width='150' height='100'>";
                }
                }

//            data.forEach(function (item) {
//                            table.innerHTML += "<tr style='background-color: darkseagreen'><td colspan='3'>" + item.name+"</td><td>"+"<img src='/resources/img/sale.png' width='150' height='100'>"+"<img src='/resources/img/sale2.png' width='150' height='100'>"+"</td><td>"+item.price;
//                        });

            mainDiv.appendChild(table);

    }
});
}
