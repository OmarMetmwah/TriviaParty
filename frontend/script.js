const url = "localhost:8081";
const restUrl = "http://" + url;
const wsUrl = "ws://" + url;
function checkCredintaials() {
    const email = localStorage.getItem('email');
    const token = localStorage.getItem('token');
    if (!email || !token) {
        window.location.href = 'login.html';
    } else {
        window.location.href = 'mainmenue.html';
    }
}


function checkAnswer(answer) {
    const correctAnswer = 'Paris';
    const resultDiv = document.getElementById('result');
    if (answer === correctAnswer) {
        resultDiv.innerHTML = 'Correct! 🎉';
        resultDiv.style.color = 'green';
    } else {
        resultDiv.innerHTML = 'Wrong! 😞';
        resultDiv.style.color = 'red';
    }
}

function login(event) {
    event.preventDefault();
    const email = event.target.email.value;
    const password = event.target.password.value;

    fetch(restUrl + '/api/v1/player/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ email, password })
    })
        .then(response => response.json())
        .then(data => {
            if (data.id) {
                localStorage.setItem('email', email);
                localStorage.setItem('token', data.token);
                localStorage.setItem('playerId', data.id);
                window.location.href = 'index.html';
            } else {
                alert('Login failed: ' + data.errorMessage);
            }
        })
        .catch(error => {
            console.error('Error:', error);
            alert('An error occurred. Please try again.');
        });
}

function logout() {
    localStorage.removeItem('email');
    localStorage.removeItem('token');
    localStorage.removeItem('playerId');
    window.location.href = 'index.html';
}

function joinGame() {
    var gameId = prompt('Enter game code:');
    fetch(restUrl + '/api/v1/game/' + gameId + '/join', {
        method: 'POST',
        headers: {
            'Authorization': 'Bearer ' + localStorage.getItem('token')
        },
    })
        .then(response => response.json())
        .then(data => {
            console.log(data);
            if (data.status == 200) {
                localStorage.setItem('gameId', gameId);
                window.location.href = 'question.html';
            } else {
                alert('failed: ' + data.errorMessage);
            }
        })
        .catch(error => {
            console.error('Error:', error);
            alert('An error occurred. Please try again.');
        });

}

function createGame() {
    fetch(restUrl + '/api/v1/game', {
        method: 'POST',
        headers: {
            'Authorization': 'Bearer ' + localStorage.getItem('token')
        },
    })
        .then(response => response.json())
        .then(data => {
            if (data) {
                localStorage.setItem('gameId', data);
                window.location.href = 'question.html';
            } else {
                alert('failed: ' + data.errorMessage);
            }
        })
        .catch(error => {
            console.error('Error:', error);
            alert('An error occurred. Please try again.');
        });
}
function exit() {
    localStorage.removeItem('gameId');
    window.location.href = 'mainmenue.html';
}