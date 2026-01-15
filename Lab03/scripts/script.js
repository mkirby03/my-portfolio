function showEpisodeCount() {
    
    $("#output").html( "Number of Episodes (should be 79): " + db["prodnums"].length );
    
}

function createTable() {
    
    var table = document.createElement("table");

    /* INSERT YOUR CODE HERE */
    var thead = document.createElement("thead");
    var tbody = document.createElement("tbody");
    var headerRow = document.createElement("tr");
    db["colheadings"].forEach(function(heading) {
        var th = document.createElement("th");
        th.textContent = heading;
        headerRow.appendChild(th);
    });
    thead.appendChild(headerRow);

    db["data"].forEach(function(rowData, index) {
        var row = document.createElement("tr");
        var prodNum = document.createElement("td");
        prodNum.textContent = db["prodnums"][index];
        row.appendChild(prodNum);

        rowData.forEach(function(data) {
            var cell = document.createElement("td");
            cell.textContent = data; 
            row.appendChild(cell);
        });

        tbody.appendChild(row);
    });

    table.appendChild(thead);
    table.appendChild(tbody);

    
    document.getElementById("output").appendChild(table);
    
}