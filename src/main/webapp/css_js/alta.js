function getPatients() {
    var email = sessionStorage.getItem('email');
    var session = sessionStorage.getItem('session');

    var http = new XMLHttpRequest();
    http.open("GET", "http://localhost:8888/api/ServePatients?email=" + email + "&session=" + session, true);

    http.onreadystatechange = function() {
        if (http.readyState === XMLHttpRequest.DONE) {
            if (http.status === 200) {
                var response = JSON.parse(http.responseText);
                var patientsSelect = document.getElementById("patientsSelect");
                patientsSelect.innerHTML = ""; // Clear previous options

                // Add options to the patients select
                for (var i = 0; i < response.length; i++) {
                    var option = document.createElement("option");
                    option.value = response[i];
                    option.textContent = response[i];
                    patientsSelect.appendChild(option);
                }
            } else {
                console.error('Error in the backend request:', http.status);
            }
        }
    };

    http.send();
}

function getMedicines() {
    var email = sessionStorage.getItem('email');
    var session = sessionStorage.getItem('session');

    var http = new XMLHttpRequest();
    http.open("GET", "http://localhost:8888/api/ServeMedicines?email=" + email + "&session=" + session, true);

    http.onreadystatechange = function() {
        if (http.readyState === XMLHttpRequest.DONE) {
            if (http.status === 200) {
                var response = JSON.parse(http.responseText);
                var medicinesSelect = document.getElementById("medicinesSelect");
                medicinesSelect.innerHTML = ""; // Clear previous options

                // Add options to the medicines select
                for (var i = 0; i < response.length; i++) {
                    var option = document.createElement("option");
                    option.value = response[i];
                    option.textContent = response[i];
                    medicinesSelect.appendChild(option);
                }
            } else {
                console.error('Error in the backend request:', http.status);
            }
        }
    };

    http.send();
}

function enviar() {
    var idXip = document.getElementById("xipIdInput").value;
    var mailP = document.getElementById("patientsSelect").value;
    var med = document.getElementById("medicinesSelect").value;
    var dateLimit = document.getElementById("dateInput").value;

    var data = {
        email: sessionStorage.getItem('email'),
        session: sessionStorage.getItem('session'),
        idXip: idXip,
        med: med,
        date: dateLimit,
        mailP: mailP
    };

    var jsonData = JSON.stringify(data);

    var http = new XMLHttpRequest();
    http.open("POST", "http://localhost:8888/api/Release", true);
    http.setRequestHeader("Content-type", "application/json");
    http.onreadystatechange = function() {
        if (http.readyState === XMLHttpRequest.DONE) {
            if (http.status === 200) {
                var response = JSON.parse(http.responseText);
                // Handle the server response
                console.log(response);
            } else {
                console.error('Error in the backend request:', http.status);
                alert("Data repetido");
            }
        }
    };

    http.send(jsonData);
}
