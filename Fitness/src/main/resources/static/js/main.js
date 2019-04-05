function clickButton() {

    var container = document.getElementById ("fitness-info");
    console.log ("Test click");
    var request = new XMLHttpRequest ();
    //https://api.jsonbin.io/b/5ca2ebcec980796377d6b9f6 Second hosting service if the service is down
    request.open ('GET', 'https://api.myjson.com/bins/1f0syy.json');
    request.onload = function () {
        var data = JSON.parse (request.responseText);
        renderHTML (data);

    };
    request.send ();


    function renderHTML(data) {
        var htmlString = "";

        for (i = 0; i < data.length; i++) {
            htmlString += "<p><em>" + data[i].package + "</em> lasts for " + data[i].duration + " <br>Workouts include: <br> For chest, ";

            for (ii = 0; ii < data[i].workouts.chest.length; ii++) {
                if (ii == 0) {
                    htmlString += data[i].workouts.chest[ii];
                } else {
                    htmlString += " and " + data[i].workouts.chest[ii];
                }
            }
            htmlString += ' and for arms: ';

            for (ii = 0; ii < data[i].workouts.arms.length; ii++) {
                if (ii == 0) {
                    htmlString += data[i].workouts.arms[ii];
                } else {
                    htmlString += " and " + data[i].workouts.arms[ii];
                }
            }

            htmlString += '.</p>';

        }

        container.insertAdjacentHTML ('beforeend', htmlString);
    }
}


// Close the dropdown menu if the user clicks outside of it
window.onclick = function (event) {
    if (!event.target.matches ('.dropdownlink')) {
        var dropdowns = document.getElementsByClassName ("menuitems");
        var i;
        for (i = 0; i < dropdowns.length; i++) {
            var openDropdown = dropdowns[i];
            if (openDropdown.classList.contains ('show')) {
                openDropdown.classList.remove ('show');
            }
        }
    }
};


function calsPerDay() {
    function getByID(id) {
        return document.getElementById (id)
    }

    var age = getByID ("age").value;
    var height = getByID ("height").value * 2.54 * 39.3701;
    var weight = getByID ("weight").value;
    var total = 0;

    if (getByID ("male").checked)
        total = 66.46 + (13.75 * weight) + (5.0 * height - (6.74 * age));
    else if (getByID ("female").checked)
        total = 665 + (9.57 * weight) + (1.83 * height - (4.68 * age));
    if (total > 0 && total < 20000) {
        getByID ("totalCals").innerHTML = Math.round (total)
    } else {
        getByID ("totalCals").innerHTML = "ERROR"

    }

}


var nav = responsiveNav (".nav-collapse", { // Selector
    animate: true, // Boolean: Use CSS3 transitions, true or false
    transition: 284, // Integer: Speed of the transition, in milliseconds
    label: "Menu", // String: Label for the navigation toggle
    insert: "before", // String: Insert the toggle before or after the navigation
    customToggle: "", // Selector: Specify the ID of a custom toggle
    closeOnNavClick: false, // Boolean: Close the navigation when one of the links are clicked
    openPos: "relative", // String: Position of the opened nav, relative or static
    navClass: "nav-collapse", // String: Default CSS class. If changed, you need to edit the CSS too!
    navActiveClass: "js-nav-active", // String: Class that is added to  element when nav is active
    jsClass: "js", // String: 'JS enabled' class which is added to  element
    init: function () {
    }, // Function: Init callback
    open: function () {
    }, // Function: Open callback
    close: function () {
    } // Function: Close callback
});


function color() {
    var val = "Intermediate";
    var ColIndexToCheck = 0;
    var header = document.getElementById ("testTable").getElementsByTagName ("td");


}

color ();


function findSum() {

    var table = document.getElementById ("tbl");
    var sum = 0;
    for (var i = 0, row; row = table.rows[i]; i++) {
        for (var j = 0, col; col = row.cells[j]; j++) {
            if (i > 0 && j == 1) {
                sum += Number (col.innerHTML.valueOf ());
            }
        }
    }
    document.getElementById ("mins").innerText = sum;
}


function sortTable() {
    const getCellValue = (tr, idx) => tr.children[idx].innerText || tr.children[idx].textContent;

    const comparer = (idx, asc) => (a, b) => ((v1, v2) =>
            v1 !== '' && v2 !== '' && !isNaN (v1) && !isNaN (v2) ? v1 - v2 : v1.toString ().localeCompare (v2)
    ) (getCellValue (asc ? a : b, idx), getCellValue (asc ? b : a, idx));


    document.querySelectorAll ('th').forEach (th => th.addEventListener ('click', (() => {
        const table = th.closest ('table');
        Array.from (table.querySelectorAll ('tr:nth-child(n+2)'))
            .sort (comparer (Array.from (th.parentNode.children).indexOf (th), this.asc = !this.asc))
            .forEach (tr => table.appendChild (tr));
    })));
}





