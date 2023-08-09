/*
 * MIT License
 *
 * Copyright (c) 2023 Joel Schaltenbrand.
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS
 * BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN
 * ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

let firstNumber = '';
let currentNumber = '';
let operator = '';
let displayText = '';
let opAlreadyPressed = false;

async function performCalculation(endCalc) {
    const requestData = {
        number1: parseFloat(firstNumber), number2: parseFloat(currentNumber), operator: operator
    };
    const response = await fetch(window.location.href + 'api/calc', {
        method: 'POST', headers: {
            'Accept': 'application/json', 'Content-Type': 'application/json'
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
