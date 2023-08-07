let firstNumber = '';
let currentNumber = '';
let operator = '';
let displayText = '';
let opAlreadyPressed = false;

async function performCalculation(endCalc) {
    const requestData = {
        number1: parseFloat(firstNumber), number2: parseFloat(currentNumber), operator: operator
    };
    const response = await fetch('http://localhost:8080/calculator/api/calc', {
        method: 'POST', headers: {
            'Content-Type': 'application/json'
        }, body: JSON.stringify(requestData)
    });
    currentNumber = await response.json();
    displayText = currentNumber;
    setDisplayTest();
    if (endCalc) {
        operator = '';
        opAlreadyPressed = false;
    }
    firstNumber = '';
}

function continueWithResult() {
    firstNumber = currentNumber;
    currentNumber = '';
    opAlreadyPressed = true;
    displayText += ' ' + operator + ' ';
    setDisplayTest();
}

function setDisplayTest() {
    $('#result').val(displayText);
}

function startCalc(value) {
    if (value >= '0' && value <= '9') {
        currentNumber += value;
        displayText += value;
        setDisplayTest();
    } else if (value === '.') {
        if (currentNumber === '') {
            currentNumber = 0;
            displayText += currentNumber;
        }
        currentNumber += '.'
        displayText += '.'
        setDisplayTest();
    } else if (value === 'c') {
        currentNumber = '';
        operator = '';
        firstNumber = '';
        displayText = '';
        setDisplayTest();
        opAlreadyPressed = false;
    } else if (value === '+' || value === '-' || value === '*' || value === '/') {
        if (currentNumber === '') {
            currentNumber = 0;
            displayText += currentNumber;
        }
        operator = value;
        if (opAlreadyPressed) {
            performCalculation(false).then(() => continueWithResult());
        } else {
            continueWithResult();
        }
    } else if (value === '=') {
        if (currentNumber !== '' && firstNumber !== '' && operator !== '') {
            performCalculation(true).then();
        }
    }
}

$(document).ready(function () {
    $('input[type="button"]').click(function () {
        startCalc($(this).val());
    });
});

document.addEventListener("keydown", function (event) {
    if (event.key === 'Escape') {
        startCalc('c');
    } else if (event.key === 'Enter') {
        startCalc('=');
    } else {
        startCalc(event.key);

    }
});
