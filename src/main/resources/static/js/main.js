    const getUSersUrl = "http://localhost:8081/admin/users/";
    const getRolesUrl = "http://localhost:8081/admin/roles/";
    const getCurrentUser = "http://localhost:8081/admin/auth/";
    const addUserForm = document.querySelector('.add-user-form');
    const editUserButton = document.querySelector(' .eBtn');


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
    const printUsers = (users, roles) => {
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
                    //    <td> <div class="container" style="margin-top: -5%;margin-left: -15% ">
                    //          <a href="http://localhost:8081/admin/users/" type="button" id="${user.id}" class="btn btn-primary edit-user-form" data-toggle="modal"
                    //          data-target="#exampleModal">Edit</a> </div></td>
                    //
                    // </tr>`

                    // <!--    Edit в Таблице!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!-->

                    temp += ` <td><div class="container" style="margin-top: -5%;margin-left: -15% ">
                            <a type="button" class="btn btn-primary tBtn"
                            data-toggle="modal" data-target="#editModal${user.id}" >Edit
                                </a>
                         </div>`

                    temp += `<div class="modal fade " id="editModal${user.id}" tabindex="-1" role="dialog"
                                 aria-labelledby="editModalLabel"
                                 aria-hidden="true">
                                <form class="edit_modal_form${user.id}" >
    
    
    
                                    <div class="modal-dialog" role="document">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h5 class="modal-title">Edit user</h5>
                                                <button type="button" class="close"
                                                        data-dismiss="modal" aria-label="Close">
                                                    <span aria-hidden="true">&times;</span>
                                                </button>
                                            </div>
                                            <div class="modal-body">
                                                <div class="form-group" style="text-align: center; vertical-align: middle">
                                                    <label
                                                            class="col-form-label">
                                                        <div class="container-fluid" >
                                                            ID
                                                        </div>
                                                    </label>
                                                    <input type="text" class="form-control"
                                                           id="id1${user.id}"
                                                           name="id" value=${user.id}>
                                                </div>
                                                <div class="form-group" style="text-align: center; vertical-align: middle">
                                                    <label for="firstname${user.id}"
                                                           class="col-form-label">First
                                                        name</label>
                                                    <input type="text" class="form-control"
                                                           id="firstname${user.id}"
                                                           name="name" value=${user.name}>
                                                </div>
                                                <div class="form-group" style="text-align: center; vertical-align: middle">
                                                    <label for="lastname${user.id}"
                                                           class="col-form-label">Last
                                                        name</label>
                                                    <input type="text" class="form-control"
                                                           id="lastname${user.id}"
                                                           name="surname"
                                                           value=${user.surname}>
                                                </div>
                                                <div class="form-group" style="text-align: center; vertical-align: middle">
                                                    <label for="age${user.id}"
                                                           class="col-form-label">Age</label>
                                                    <input type="text" class="form-control"
                                                           id="age${user.id}"
                                                           name="age" value=${user.age}>
                                                </div>
                                                <div class="form-group" style="text-align: center; vertical-align: middle">
                                                    <label for="email${user.id}" class="col-form-label">Email</label>
                                                    <input type="text" class="form-control"
                                                           id="email${user.id}"
                                                           name="email" value="value=${user.email}">
                                                </div>
                                                <div class="form-group" style="text-align: center; vertical-align: middle">
                                                    <label for="password${user.id}"
                                                           class="col-form-label">Password</label>
                                                    <input type="password" class="form-control"
                                                           id="password${user.id}" name="password"
                                                           value=${user.password}>
                                                </div>`


                    temp += `<div class="form-group "
                                                         style="text-align: center; vertical-align: middle">
                                                        <label>Role</label>
                                                        <select name="select_role" id="select_roles${user.id}"
                                                                class="form-control"
                                                                multiple="multiple">`
                    // console.log(roles);
                    if (roles.length > 0) {
                        roles.forEach((role) => {
                            temp += `<option id="selectoptions${user.id}" value= ${role.id} >`
                            temp += ` ${role.role} `
                            temp += `</option> `
                        })
                        temp += ` </select></div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-secondary"
                                                        data-dismiss="modal">Close
                                                </button>
                                                <button  class="btn btn-primary eBtn">
                                                    Edit
                                                </button>
                                            </div>
                                        </div>
                                       </div>
    
                                </form>
                            </div></td></tr>`

                    }
                    window.addEventListener("load", ()=> {
                        console.log(document.querySelector('.edit_modal_form1'))

                        // document.querySelector(' .modal-open').addEventListener('click', (e) => {
                        //     e.preventDefault();
                        //     console.log("wtf is going on?");
                        // })
                    });
                    document.getElementById("data").innerHTML = temp;

                })

            }
        }
    }

    // const printTable = (url) => {
    //     fetch(url)
    //         .then(response => {
    //             response.json()
    //                 .then(data => printUsers(data))
    //         })
    // }
    // printTable(getUSersUrl);
    const printTable = () => {
        fetch(getUSersUrl)
            .then(response => {
                response.json()
                    .then(data1 => {
                        fetch(getRolesUrl)
                            .then(response => {
                                response.json()
                                    .then(data => {
                                        printUsers(data1, data)
                                    })
                            })
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
        // console.log(roles);

        fetch("http://localhost:8081/admin/save", {
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
                        printTable()
                    })
            });

    })


    // $(document).ready(function () {
    //
    //     $('.table .eBtn').on('click',function (event){
    //
    //         $('.myForm #exampleModal').modal();
    //         console.log("WTF");
    //     });
    // });


