 // Get the modal
    var modal = document.getElementById("adModal");

    // Get the <span> element that closes the modal
    var span = document.getElementsByClassName("close")[0];

    // When the page loads, open the modal
    window.onload = function() {
        modal.style.display = "block";
    }

    // When the user clicks on <span> (x), close the modal
    span.onclick = function() {
        modal.style.display = "none";
    }

    // When the user clicks anywhere outside of the modal, close it
    window.onclick = function(event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }
/*
-----------------------------------------------------*/
/*
// Get the modal
var modal = document.getElementById("adModal");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// Function to show the modal
function showModal() {
    modal.style.display = "block";
}

// Function to hide the modal and set the flag in localStorage
function hideModal() {
    modal.style.display = "none";
    localStorage.setItem('adShown', 'true');
}

// When the page loads, check if the ad has been shown before
window.onload = function() {
    if (!localStorage.getItem('adShown')) {
        showModal();
    }
}

// When the user clicks on <span> (x), close the modal
span.onclick = function() {
    hideModal();
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        hideModal();
    }
}*/
