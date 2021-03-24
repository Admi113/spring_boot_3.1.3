const getUSersUrl = "http://localhost:8081/users/";
const getRolesUrl = "http://localhost:8081/roles/";
const getCurrentUser = "http://localhost:8081/auth/";
const addUserForm = document.querySelector('.add-user-form');
const editUserForm = document.querySelector('.edit-user-form');
const deleteUserForm = document.querySelector('.delete-user-form');
const idModal = document.getElementById('id_modal');
const idModalDelete = document.getElementById('id_modal_delete');
const nameModal = document.getElementById('firstname');
const nameModalDelete = document.getElementById('firstname_delete');
const surnameModal = document.getElementById('lastname');
const surnameModalDelete = document.getElementById('lastname_delete');
const ageModal = document.getElementById('age');
const ageModalDelete = document.getElementById('age_delete');
const emailModal = document.getElementById('email');
const emailModalDelete = document.getElementById('email_delete');
const passwordModal = document.getElementById('password');
// const passwordModalDelete = document.getElementById('password_delete');
// const selectRoleModal = document.getElementById('select_role_editform');
// const selectRoleModalDelete = document.getElementById('select_role_deleteform ');


let roles
fetch(getRolesUrl)
    .then(response => {
        response.json()
            .then(data => {
                roles = data
                // console.log(roles)
            })
    })
// console.log(roles)

// ----------------------------Users Table--------------------------------------------
const printUsers = (users) => {
    {
        let temp = "";
        // console.log(users);
        if (users.length > 0) {
            users.forEach((user) => {

                temp += `<tr id="idrow${user.id}"> <td >${user.id}</td>
                                                    <td >${user.name}</td>
                                                    <td >${user.surname}</td>
                                                    <td >${user.age}</td>
                                                    <td >${user.email}</td><td>`

                for (let i = 0; i < user.roles.length; i++) {
                    temp += `${user.roles[i].role} `
                }
                temp += `</td >`

                temp += ` <td><div class="container" style="margin-top: -5%;margin-left: -15% ">
                            <a type="button" class="btn btn-primary tBtn" id="${user.id}"
                            data-toggle="modal" data-target="#editModal" onclick="clickeBtn()" >Edit
                                </a>
                         </div></td>`

                temp += ` <td><div class="container" style="margin-top: -5%;margin-left: -15% ">
                            <a type="button" class="btn btn-danger delBtn" id="${user.id}"
                            data-toggle="modal" data-target="#deleteModal" onclick="clickeBtnDelete()" >Delete
                                </a>
                         </div></td>`


                // temp += `<div class="modal fade " id="editModal${user.id}" tabindex="-1" role="dialog"
                //              aria-labelledby="editModalLabel"
                //              aria-hidden="true">
                //             <form class="edit_modal_form${user.id}" >
                //
                //
                //
                //                 <div class="modal-dialog" role="document">
                //                     <div class="modal-content">
                //                         <div class="modal-header">
                //                             <h5 class="modal-title">Edit user</h5>
                //                             <button type="button" class="close"
                //                                     data-dismiss="modal" aria-label="Close">
                //                                 <span aria-hidden="true">&times;</span>
                //                             </button>
                //                         </div>
                //                         <div class="modal-body">
                //                             <div class="form-group" style="text-align: center; vertical-align: middle">
                //                                 <label
                //                                         class="col-form-label">
                //                                     <div class="container-fluid" >
                //                                         ID
                //                                     </div>
                //                                 </label>
                //                                 <input type="text" class="form-control"
                //                                        id="id1${user.id}"
                //                                        name="id" value=${user.id}>
                //                             </div>
                //                             <div class="form-group" style="text-align: center; vertical-align: middle">
                //                                 <label for="firstname${user.id}"
                //                                        class="col-form-label">First
                //                                     name</label>
                //                                 <input type="text" class="form-control"
                //                                        id="firstname${user.id}"
                //                                        name="name" value=${user.name}>
                //                             </div>
                //                             <div class="form-group" style="text-align: center; vertical-align: middle">
                //                                 <label for="lastname${user.id}"
                //                                        class="col-form-label">Last
                //                                     name</label>
                //                                 <input type="text" class="form-control"
                //                                        id="lastname${user.id}"
                //                                        name="surname"
                //                                        value=${user.surname}>
                //                             </div>
                //                             <div class="form-group" style="text-align: center; vertical-align: middle">
                //                                 <label for="age${user.id}"
                //                                        class="col-form-label">Age</label>
                //                                 <input type="text" class="form-control"
                //                                        id="age${user.id}"
                //                                        name="age" value=${user.age}>
                //                             </div>
                //                             <div class="form-group" style="text-align: center; vertical-align: middle">
                //                                 <label for="email${user.id}" class="col-form-label">Email</label>
                //                                 <input type="text" class="form-control"
                //                                        id="email${user.id}"
                //                                        name="email" value="value=${user.email}">
                //                             </div>
                //                             <div class="form-group" style="text-align: center; vertical-align: middle">
                //                                 <label for="password${user.id}"
                //                                        class="col-form-label">Password</label>
                //                                 <input type="password" class="form-control"
                //                                        id="password${user.id}" name="password"
                //                                        value=${user.password}>
                //                             </div>`


                // temp += `<div class="form-group "
                //                                      style="text-align: center; vertical-align: middle">
                //                                     <label>Role</label>
                //                                     <select name="select_role" id="select_roles${user.id}"
                //                                             class="form-control"
                //                                             multiple="multiple">`
                // console.log(roles);
                // if (roles.length > 0) {
                //     roles.forEach((role) => {
                //         temp += `<option id="selectoptions${user.id}" value= ${role.id} >`
                //         temp += ` ${role.role} `
                //         temp += `</option> `
                //     })
                //     temp += ` </select></div>
                //                         <div class="modal-footer">
                //                             <button type="button" class="btn btn-secondary"
                //                                     data-dismiss="modal">Close
                //                             </button>
                //                             <button  class="btn btn-primary eBtn">
                //                                 Edit
                //                             </button>
                //                         </div>
                //                     </div>
                //                    </div>
                //
                //             </form>
                //         </div></td></tr>`
                //
                // }
                // window.addEventListener("load", ()=> {
                //     console.log(document.querySelector('.edit_modal_form1'))
                //
                //     // document.querySelector(' .modal-open').addEventListener('click', (e) => {
                //     //     e.preventDefault();
                //     //     console.log("wtf is going on?");
                //     // })
                // });
                document.getElementById("data").innerHTML = temp;

            })

        }
    }
}
//----------------------------ABOUT USER-----------------------------------------------------
const prinCurrentUser = (user) => {
    {
        let temp = "";
        // console.log(users);

                temp += `<tr id="idrow${user.id}"> <td >${user.id}</td>
                                                    <td >${user.name}</td>
                                                    <td >${user.surname}</td>
                                                    <td >${user.age}</td>
                                                    <td >${user.email}</td><td>`
                for (let i = 0; i < user.roles.length; i++) {
                    temp += `${user.roles[i].role} `
                }
                temp += `</td >`
                document.getElementById("aboutUserTable").innerHTML = temp;
    }
}
const printUser = () => {
    fetch(getCurrentUser)
        .then(response => {
            response.json()
                .then(data => {
                    prinCurrentUser(data)
                })
        })
}
printUser();

const printTable = () => {
    fetch(getUSersUrl)
        .then(response => {
            response.json()
                .then(data => {
                    printUsers(data)
                })
        })
}
printTable();

//---------------------Nav Bar-------------------------------------

const printHeader = (user) => {

    let temp = "";
    // console.log(user);
    temp += `   <div class="navbar-text" style="padding: 0px">
                            <text class="text-navbar" style="color: aliceblue;
                            font-weight: bold;font-size: x-large ">${user.email}
                            </text>
                            <text style="color: aliceblue; font-size: x-large ">with roles:</text>
                            <text  style="color: aliceblue;font-size: x-large">`
    for (let i = 0; i < user.roles.length; i++) {
        temp += `${user.roles[i].role} `
    }
    temp += `</text>`
    temp += ` </div>
    
                <div class="navbar-text navbar-right" style="margin: 0px;padding: 0">
                <a style="color: darkgray; font-size: large "
                href="javascript: document.logoutForm.submit()" role="menuitem"> Logout</a>
                 </div>`

    document.getElementById("navbar").innerHTML = temp;
}
const printNavBar = (url) => {
    fetch(url)
        .then(response => {
            response.json()
                .then(data => printHeader(data))
        })
}
printNavBar(getCurrentUser);
//---------------------Roles Form-------------------------------------
const printCreateForm = (roles) => {
    {
        let temp1 = `<div class=\"form-group col-md-4\" style=\"text-align: center; vertical-align: middle\">
                <label>Role</label>
                <select name=\"select_role\" class=\"form-control\"\n
                multiple=\"multiple\" id=\"select_role\">;`
        // console.log(roles);
        if (roles.length > 0) {
            roles.forEach((role) => {
                temp1 += `<option id="selectoptions${role.id}" value= ${role.id} >`
                temp1 += ` ${role.role} `
                temp1 += `</option> `
            })
            temp1 += `</select></div> <div class="container" style="left: 80%">
                <button type="submit" class="btn btn-primary btn-success"
                style="margin-left: 8.5%"> Add new user
                </button>
                </div>`
            document.getElementById("userCreateForm").innerHTML += temp1;
        }
    }
}
const printFormToCreate = (url) => {
    fetch(url)
        .then(response => {
            response.json()
                .then(data => printCreateForm(data))
        })
}
printFormToCreate(getRolesUrl);

//-------------------------------Добавляем юзера_----------------
addUserForm.addEventListener("submit", (e) => {
    e.preventDefault();
    let role = document.getElementById("select_role");
    const roles = [];
    for (let i = 0; i < role.length; i++) {
        if (role[i].selected) {
            let data = {
                id: Number(role[i].value),
                role: role[i].text
            }
            roles.push(data)
        }
    }
    fetch("http://localhost:8081/save", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            name: document.getElementById("username_create").value,
            surname: document.getElementById("lastname_create").value,
            password: document.getElementById("password_create").value,
            email: document.getElementById("inputEmail4_create").value,
            age: document.getElementById("age_create").value,
            roles: roles
        })
    })
        .then(response => {
            response.json()
                .then(data => {
                    // printUsers(data)
                    printTable();
                    document.getElementById('userCreateForm').reset();
                    document.getElementById('firstTabList').classList.add("active")
                    document.getElementById('firstTabList').setAttribute("aria-selected","true")
                    document.getElementById('secondTab').classList.remove("active")
                    document.getElementById('secondTab').setAttribute("aria-selected","false")
                    document.getElementById('home').classList.add("active")
                    document.getElementById('profile').classList.remove("active")

                })
        });

})

function clickeBtn() {

    let id = event.target.id
    fetch("http://localhost:8081/getOne/" + id, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            id: id
        })
    })
        .then(response => {
            response.json()
                .then(data => {
                    console.log(data)
                    idModal.value = data.id;
                    nameModal.value = data.name;
                    surnameModal.value = data.surname;
                    ageModal.value = data.age;
                    emailModal.value = data.email;
                    passwordModal.value = data.password;


                    fetch(getRolesUrl)
                        .then(response => {
                            response.json()
                                .then(roles => {
                                    let temp = "";
                                    if (roles.length > 0) {
                                        roles.forEach((role) => {
                                            temp += `<option value= ${role.id} >`
                                            temp += ` ${role.role} `
                                            temp += `</option> `

                                        })
                                        document.getElementById("select_role_editform").innerHTML = temp
                                    }
                                })
                        })
                })
        })
}

function clickeBtnDelete() {
    // console.log(event.target.parent)
    // console.log(event.target.id)
    let id = event.target.id
    fetch("http://localhost:8081/getOne/" + id, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            id: id
        })
    })
        .then(response => {
            response.json()
                .then(data => {
                    console.log(data)
                    idModalDelete.value = data.id;
                    nameModalDelete.value = data.name;
                    surnameModalDelete.value = data.surname;
                    ageModalDelete.value = data.age;
                    emailModalDelete.value = data.email;

                    fetch(getRolesUrl)
                        .then(response => {
                            response.json()
                                .then(roles => {
                                    let temp = "";
                                    if (roles.length > 0) {
                                        roles.forEach((role) => {
                                            temp += `<option value= ${role.id} >`
                                            temp += ` ${role.role} `
                                            temp += `</option> `

                                        })
                                        document.getElementById("select_role_deleteform").innerHTML = temp
                                    }
                                })
                        })
                })
        })
}

editUserForm.addEventListener("submit", (e) => {
    e.preventDefault();
    let role1 = document.getElementById("select_role_editform");
    // console.log(role)
    const rolesmodal = [];
    for (let i = 0; i < role1.length; i++) {
        if (role1[i].selected) {
            let dataroles = {
                id: Number(role1[i].value),
                role: role1[i].text
            }
            rolesmodal.push(dataroles)
        }
    }

    fetch("http://localhost:8081/edit", {
        method: "PUT",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            id: document.getElementById("id_modal").value,
            name: document.getElementById("firstname").value,
            surname: document.getElementById("lastname").value,
            password: document.getElementById("password").value,
            email: document.getElementById("email").value,
            age: document.getElementById("age").value,
            roles: rolesmodal
        })
    })
        .then(() => {
            printTable()
            $('.editmodal').modal('hide');
            $('.modal-backdrop').remove();
        });

})

deleteUserForm.addEventListener("submit", (e) => {
    e.preventDefault();
    let role1 = document.getElementById("select_role_deleteform");
    // console.log(role)
    const rolesmodal = [];
    for (let i = 0; i < role1.length; i++) {
        if (role1[i].selected) {
            let dataroles = {
                id: Number(role1[i].value),
                role: role1[i].text
            }
            rolesmodal.push(dataroles)
        }
    }
    let id = document.getElementById("id_modal_delete").value
    fetch("http://localhost:8081/delete/" + id, {
        method: "DELETE",
        headers: {
            "Content-Type": "application/json"
        }

    })
        .then(() => {
            printTable()
            $('.deletemodal').modal('hide');
            $('.modal-backdrop').remove();
        });

})