// window.addEventListener("load", () => {


    
// })



async function login(e) {
    e.preventDefault();

    let usernameInputElem = document.getElementById("username-input");
    let passwordInputElem = document.getElementById("password-input");
    

    console.log(usernameInputElem.value, passwordInputElem.value)
    let response = await fetch ("http://localhost:9000/api/login", {
        method: "POST",
        body: JSON.stringify({
            username: usernameInputElem.value,
            password: passwordInputElem.value,
        })
    })

    // console.log(response.ok)
    // console.log(response)
    let result = await response.json();
    console.log(response.status)

    // window.location = "frontend/pages/reimuresmentList/reimbursementList.html"

    if(response.status == 200){
        localStorage.user = result.userId
        localStorage.role = result.roleId
        localStorage.pending = "false"
        // if (localStorage.role == 1) {

        // } else if (localStorage.role == 2) {
        //     window.location.href = ``
        // }
        window.location.href = `./pages/reimuresmentList/reimbursementList.html`

    }else {
    //    let unsuccessfulLogin = document.getElementById("unsuccessfulLogin")
    //    unsuccessfulLogin.removeClass("d-none")
    $('#unsuccessfulLogin').removeClass('d-none')
    }
    // console.log(result)

}
function logout(event) {
event.preventDefault()

    localStorage.clear();
    window.location.href= '../../index.html'
    

}

function homePage(e) {
    e.preventDefault();

    if (localStorage.user == null || localStorage.role == null){

        window.location.href= '../../index.html'
    } else {

        window.location.href="./pages/reimuresmentList/reimbursementList.html"
    }


}

function newUser() {

    window.location.href= "./pages/newUser.html"
}


async function createUser(event){
    event.preventDefault()

    let signupUsername = document.getElementById("signupUsername");
    let signupPassword = document.getElementById("signupPassword");
    let signupFirstName = document.getElementById("signupFirstName");
    let signupLastName = document.getElementById("signupLastName")
    let signupEmail = document.getElementById("signupEmail")
    console.log(signupUsername.value)

    let response = await fetch ("http://localhost:9000/users", {
        method: "POST",
        body: JSON.stringify({
            firstName: signupFirstName.value,
            username: signupUsername.value,
            password: signupPassword.value,
            lastName: signupLastName.value,
            userEmail: signupEmail.value
        })
    })

    let results = await response.json();

    if (response.status == 200 ) {
        window.location.href = "../index.html"
    }
    else {
        $('#unsuccessfulSignup').removeClass('d-none')
    }


}