var base_url = 'http://localhost:8080/';
var mainDiv;

//import styles from './css/main.css'


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
            data.forEach(function (item) {
//                               tr.className="rowStyle";
                               tr = table.insertRow();
                               tr.style.border = '1px black';
                               tr.style.backgroundColor="darkseagreen";
                               td = tr.insertCell();
                               td.style.width  = '300px';

                               var a = document.createElement('a');
                               var linkText = document.createTextNode(item.name);
                               a.appendChild(linkText);
                               a.title = item.name;
                               a.href='/item'+1001;
                               td.appendChild(a);
                               td = tr.insertCell();
                               td.style.width  = '300px';
                               switch (item.name) {
                                 case 'TV':
                                   td.innerHTML="<img src='/resources/img/tv.jpg' width='150' height='100'>";
                                   break;
                                 case 'Oven':
                                   td.innerHTML="<img src='/resources/img/oven.jpg' width='150' height='100'>";
                                   break;
                                 case 'Washer':
                                  td.innerHTML="<img src='/resources/img/washer.jpg' width='150' height='100'>";
                                   break;
                                 case 'Washing machine':
                                    td.innerHTML="<img src='/resources/img/dwasher.jpg' width='150' height='100'>";
                                    break;
                                 case 'Smartphone':
                                      td.innerHTML="<img src='/resources/img/Smartphone.jpg' width='150' height='100'>";
                                      break;

                               }
                               td = tr.insertCell();
                               td.style.width  = '100px';
                               td.appendChild(document.createTextNode(item.price));
                                td = tr.insertCell();
                                td.style.width  = '100px';
                                td.appendChild(document.createTextNode('Description'));

                        });


//            for(var i=0;i<data.length;++i){
//            tr = table.insertRow();
//            tr.style.border = '1px black';
//            tr.style.backgroundColor="darkseagreen";
//            tr.setAttribute('rowSpan', '2');
//            for(var j=0;j<3;++j){
//                td = tr.insertCell();
//                td.style.width  = '400px';
////                td.innerHTML="<img src='/resources/img/sale.png' width='150' height='100'>";
//                }
//                }



            mainDiv.appendChild(table);

    }
});
}
