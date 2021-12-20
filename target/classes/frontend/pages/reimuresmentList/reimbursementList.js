window.addEventListener("load", async () => {

    if (localStorage.user == null || localStorage.role == null ) {

        window.location.href= '../../index.html'
    } else if(localStorage.role == 2){ 
        filterReimb();
        getReimbs();
        

    } else {
        getReimbs();
        let submitBtn = document.getElementById("submitReimb")
        submitBtn.addEventListener("click", submitReimb)
    }

})


async function getReimbs() {

    
    if (localStorage.role == 1) {
    
       let response = await fetch (`http://localhost:9000/users/${localStorage.user}/reimbursements`, { method:"GET" })
    
    console.log(response)
    let reimbdata = await response.json();
    console.log(reimbdata)
    populateReimbs(reimbdata);
} else if (localStorage.role == 2) {

    let response = await fetch (`http://localhost:9000/users/${localStorage.user}/reimbursementsAdmin`, { method:"GET" })
    
    console.log(response)
    let reimbdata = await response.json();
    console.log(reimbdata)
    populateReimbs(reimbdata)

    

    $('#adminView').removeClass('d-none');
    


}

    
//populate the reimbursements
    
}
 async function submitReimb(event) {
    event.preventDefault()

    console.log(inputAmount.value,inputT.value,inputDesc.value,localStorage.user)

    let response = await fetch(`http://localhost:9000/users/${localStorage.user}/reimbursements`, {
        method: "POST",
        body: JSON.stringify({
           reimbAmount:  inputAmount.value,
           reimbDesc: inputDesc.value,
           reimbAuthor: localStorage.user,
           reimbTypeId: inputT.value
        })
    })
    let result = await response.json();
     console.log(result)
     window.location.href="./reimbursementList.html"
}

async function approveReimb(event) {
    // event.preventDefault()

    console.log(localStorage.reimbId)

    let response = await fetch(`http://localhost:9000/users/${localStorage.user}/reimbursements/${localStorage.reimbId}`, {
        method: "PATCH",
        headers : { 
            'Content-Type': 'application/json',
            'Accept': 'application/json'
           },
        body: JSON.stringify({
           reimbStatusId: 2,
           reimbId: localStorage.reimbId
        })
    })
    let result = await response.json();


    console.log(result)
    location.reload()
}
async function denyReimb(event) {
    event.preventDefault()

    console.log(localStorage.reimbId)

    let response = await fetch(`http://localhost:9000/users/${localStorage.user}/reimbursements/${localStorage.reimbId}`, {
        method: "PATCH",
        headers : { 
            'Content-Type': 'application/json',
            'Accept': 'application/json'
           },
        body: JSON.stringify({
           reimbStatusId: 3,
           reimbId: localStorage.reimbId
        })
    })
    let result = await response.json();


    console.log(result)
    location.reload()
}


function populateReimbs(reimbdata) {


let reimbList = reimbdata.map(stringJson)


if (localStorage.pending == "true") {

    $('.my-table').bootstrapTable({
        data: reimbList.filter(filterList)
    });
    
} else {  
    $('.my-table').bootstrapTable({
        data: reimbList
    });

}

// $(document).ready(function(){
    
//     $('.my-table').each(function(){
//        var SelectedDate = new Date($(this).text());
//        if() {
//            $(this).css('color', 'red');
//        }
//     });
//   });

//   var theDateYouWant = $('selectorForDatCol').text()



}
async function checkSession() {

}


function stringJson(list) {

    
    let reimb = {
                    "reimbId": (list.reimbId ? list.reimbId.toString() : ""),
                    "reimbAuthor": (list.reimbAuthor ? list.reimbAuthor.toString() : ""),
                    "reimbAmount": (list.reimbAmount ? list.reimbAmount.toString() : ""),
                    "reimbSubmitted": list.reimbSubmitted? list.reimbSubmitted.toString() : "Pending" ,
                    "reimbResolved": list.reimbResolved ? list.reimbResolved.toString() : "Pending",
                    "reimbStatusId": (list.reimbStatusId ? (list.reimbStatusId == 1 ?  "Pending" : (list.reimbStatusId == 2 ?  "Approved" : "Denied" ) ) : ""),
                    "reimbTypeId": (list.reimbTypeId ? list.reimbTypeId.toString() : ""),
                    "reimbResolver": (list.reimbResolver ? list.reimbResolver.toString() : "Pending"),
                    "reimbDesc": (list.reimbDesc ? list.reimbDesc.toString() : ""),
                    "reimbView": "View"

    }
    // console.log(reimb);
    return reimb;

}


function LinkFormatter(value, row, index) {
    console.log(value == "Pending")
    
   var reimbView =  `<a id='reimbId${row.reimbId}' class="viewBtn" onClick='Details(${row.reimbId})'data-bs-toggle="modal" data-bs-target="#viewModal" <a href="javascript:void(0)"  >${value}</a>`;
   return reimbView
//    href='../reimbursement.html'
  }
function colorStatus (list) {
    // let rStatus = row.reimbStatusId
    // let rStatus = document.getElementb
    let statusForeach = list.forEach((e) => {

        if (e.reimbStatusId == "Approved") {
        row.style.backgroundColor = "green"
    //    let appCol = ` <p id="reimbStatus" class="app-color" >Status: ${(row.reimbStatusId ? (row.reimbStatusId.toString() == 1 ?  "Pending" : (row.reimbSubmitted.toString() == 2 ? "Approved" : "Denied" ) ) : "")}</p>`
        // return row.style.backgroundColor = 'green'
        
    } else if (e.reimbStatusId == "Denied") {
       let denCol =  `<p id="reimbStatus" class= "den-color" >Status: ${(row.reimbStatusId ? (row.reimbStatusId.toString() == 1 ?  "Pending" : (row.reimbSubmitted.toString() == 2 ? "Approved" : "Denied" ) ) : "")}</p>`
        // return row.style.backgroundColor = 'red'
        row.style.backgroundColor = "green"
    }
        
    })

    
    
        
    console.log(list)
    return list

}

function filterReimb() {
    filterBtn.innerHTML = "";
    console.log(filterBtn)
    filterBtn.innerHTML = `<button type="btn" class="btn btn-lg btn-secondary" onclick="pending(event)" id="newReimb" >Show Pending Only</button>`
}
function filterList(list){

return list.reimbStatusId == "Pending" 
}

function pending(event) {
    event.preventDefault()
    
    localStorage.pending == "false" ? localStorage.pending = "true" : localStorage.pending = "false"
    location.reload()


}

 async function Details(id){

    
    localStorage.reimbId = id
    console.log(localStorage.reimbId)
     console.log(`http://localhost:9000/users/${localStorage.user}/reimbursements/${id.toString()}`)
    let response = await fetch (`http://localhost:9000/users/${localStorage.user}/reimbursements/${id.toString()}`, {
        method: "GET"
    })
    let reimb = await response.json();

    let modalBody = document.getElementById("modal-body")
    modalBody.innerHTML = 
        `<p id="reimbId"> Reimbursement ID : ${reimb.reimbId}</p>
        <p id="reimbAuthor"> Author ID : ${reimb.reimbAuthor}</p>
        <p id="reimbAmount">Amount: $${reimb.reimbAmount}</p>
        <p id="reimbSubmitted">Submitted: ${reimb.reimbSubmitted}</p>
        <p id="reimbResolved">Resolved: ${reimb.reimbResolved ? reimb.reimbResolved.toString() : "Pending"}</p>
        <p id="reimbStatus" >Status: ${(reimb.reimbStatusId ? (reimb.reimbStatusId.toString() == 1 ?  "Pending" : (reimb.reimbSubmitted.toString() == 2 ? "Approved" : "Denied" ) ) : "")}</p>
        <p id="reimbType">Type: ${reimb.reimbTypeId}</p>
        <p id="reimbDesc">Description: ${reimb.reimbDesc}</p>
        <p id="reimbResolver">Resolver: ${reimb.reimbResolver ? reimb.reimbResolver.toString() : "Pending"}</p>`

    console.log(reimb)

}

function cellStyle(value, row, index) {

    console.log(value)
    return {
      classes: value.trim() == 'Pending' ? 'pending' : (value.trim() == 'Approved' ? 'approved' : 'denied' )
    };
    cl
  }


var lodging = document.getElementById("type4")
var inputT = document.getElementById("inputType")
var inputAmount = document.getElementById("inputAmount")
var inputDesc = document.getElementById("inputDesc")
var filterBtn = document.getElementById("createReimb")
var pendingBtn = localStorage.pending
