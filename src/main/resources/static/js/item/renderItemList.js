var base_url = 'http://localhost:8080';
var mainDiv;
var items = [];
var csrfToken = {};

function renderItemList() {
    get("/csrfToken").then(token => csrfToken = token);
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
            data.forEach(function (item) {
                               items.push(item);
                               let tr = table.insertRow();
                               tr.id = item.id;
                               let td = tr.insertCell();
                               let a = document.createElement('a');
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

                               td = tr.insertCell();
                               let button = document.createElement("button");
                               button.id = item.id;
                               button.setAttribute("onclick", "addItemToCart(this)");
                               button.appendChild(document.createTextNode("Add To Cart"));
                               td.appendChild(button);
                        });
            mainDiv.appendChild(table);
    }
});
}
