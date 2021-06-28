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
            var table = document.createElement('table');
            table.innerHTML +="<tr style='background-color:#28a745'><td colspan='2'>"
            +"<strong>Name</strong>"+"</td><td>"+"<strong>Price,rub</strong>"+"</td><td>"+"<strong>Description</strong>";
             table.className = "table table-success table-striped";
             var tr;
             var td;
            data.forEach(function (item) {
                               tr = table.insertRow();
                               td = tr.insertCell();
                               var a = document.createElement('a');
                               a.appendChild(document.createTextNode(item.name));
                               a.title = item.name;
                               a.style.color='green';
                               a.href='/item'+item.id;
                               td.appendChild(a);
                               td = tr.insertCell();
                               switch (item.name) {
                                 case 'TV':
                                   td.innerHTML="<img src='/resources/img/tv.jpg' width='300' height='170'>";
                                   break;
                                 case 'Oven':
                                   td.innerHTML="<img src='/resources/img/oven.jpg' width='300' height='170'>";
                                   break;
                                 case 'Washer':
                                  td.innerHTML="<img src='/resources/img/washer.jpg' width='300' height='250'>";
                                   break;
                                 case 'Washing machine':
                                    td.innerHTML="<img src='/resources/img/dwasher.jpg' width='300' height='200'>";
                                    break;
                                 case 'Smartphone':
                                      td.innerHTML="<img src='/resources/img/Smartphone.jpg' width='300' height='170'>";
                                      break;
                               }
                               td = tr.insertCell();
                               td.appendChild(document.createTextNode(item.price));
                               td = tr.insertCell();
                               td.appendChild(document.createTextNode(item.description));

                        });


            mainDiv.appendChild(table);

    }
});
}
