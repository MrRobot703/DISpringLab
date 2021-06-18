var base_url = 'http://localhost:8080/';
var mainDiv;



function renderPetList() {
    mainDiv.innerHTML = "";
    $.ajax({
        type: 'GET',
        url: base_url + "/find/pets",
        datatype: "application/json",
        async: false,
        success: function (data) {
            let table = document.createElement('table');
            table.className = "table table-bordered";
            data.forEach(function (pet) {
                table.innerHTML += "<tr style='background-color: darkseagreen'><td colspan='3'>" + pet.name + "</td><td>Игрушки</td><td>" + pet.toys.length + "</td></tr>";
                pet.toys.forEach(function (item) {
                    let rowPetToys = document.createElement('tr');
                    rowPetToys.innerHTML += "<td>" + item + "</td>"
                    table.appendChild(rowPetToys);
                });
            });

            mainDiv.appendChild(table);
        }
    });
}




