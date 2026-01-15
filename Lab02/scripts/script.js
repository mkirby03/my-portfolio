var secret = Math.floor(Math.random() * 100) + 1;
var guesses = 0;

console.log("Secret Number: " + secret); // diagnostic print; for testing only

function onClick() {

    // INSERT YOUR CODE HERE
    var guess = document.getElementById("guess").value;
    var output = document.getElementById("output");
    var paragraph = document.createElement("p");
    if (validate(guess)) {
        guesses++;
        if (guess == secret)
        {
            paragraph.textContent = "Congratulations, you guessed correctly in only " + guesses + " guess(es)! Please refresh the page to play again.";
            output.appendChild(paragraph);
        }
        if (guess > secret)
        {
            paragraph.textContent = guess + " is too high.";
            output.appendChild(paragraph);
        }
        else if (guess < secret)
        {
            paragraph.textContent = guess + " is too low.";
            output.appendChild(paragraph);
        }
    }
    else {
        paragraph.textContent = "Invalid guess. Please enter another guess between 1 and 100.";
        output.appendChild(paragraph);
        guesses++;
    }
}

function validate(guess) {

    var result = false;

    // INSERT YOUR CODE HERE
    if (!isNaN(guess) && guess >= 1 && guess <= 100) {
        result = true;
    }
    return result;
}