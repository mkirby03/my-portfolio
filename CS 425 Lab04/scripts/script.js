var getList = function () {

$.ajax({
    url: 'https://testbed.jaysnellen.com:8443/EmployeeDatabaseServer/employees',
    method: 'GET',
    dataType: 'json',
    success: function(response) {
        var tableOutput = document.getElementById("output");
        tableOutput.innerHTML = "";

        var table = document.createElement("table");
        var thead = document.createElement("thead");
        var tbody = document.createElement("tbody");
        var headerRow = document.createElement("tr");

        var headers = ["id", "name", "age", "salary"];

        headers.forEach(function(key) {
            var th = document.createElement("th");
            th.textContent = key;
            headerRow.appendChild(th);
        });
        thead.appendChild(headerRow);

        response.data.forEach(function(employee) {
            var row = document.createElement("tr");
            headers.forEach(function(key) {
                var td = document.createElement("td");
                td.textContent = employee[key];
                row.appendChild(td);
            });
            tbody.appendChild(row);
        });
        table.appendChild(thead);
        table.appendChild(tbody);

        tableOutput.appendChild(table);
    }
});
}

var createEmployee = function () {

    $.ajax({
        url: 'https://testbed.jaysnellen.com:8443/EmployeeDatabaseServer/employee',
        method: 'POST',
        data: $('#inputform').serialize(),
        dataType: 'json',
        success: function(response) {
            $('#output').text(response.message);
        },
        error: function(xhr) {
            $('#output').text('Error: ' + xhr.responseText);
        }
    });
};

var updateEmployee = function () {

    $.ajax({
        url: 'https://testbed.jaysnellen.com:8443/EmployeeDatabaseServer/employee',
        method: 'PUT',
        data: $('#inputform').serialize(),
        dataType: 'json',
        success: function(response) { 
            $('#output').text(response.message);
        },
        error: function(xhr) {
            $('#output').text('Error: ' + xhr.responseText);
        }
    });
};

var deleteEmployee = function () {

    $.ajax({
        url: 'https://testbed.jaysnellen.com:8443/EmployeeDatabaseServer/employee',
        method: 'DELETE',
        data: $('#id').serialize(),
        dataType: 'json',
        success: function(response) {
            $('#output').text(response.message);
        },
        error: function(xhr) {
            $('#output').text('Error: ' + xhr.responseText);
        }
    });
};  

